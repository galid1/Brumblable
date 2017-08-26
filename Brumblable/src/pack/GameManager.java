package pack;
import java.util.Scanner;
import board.Board;
import display.GameDisplayManager;

public class GameManager {//�Ұ� . 1. ���� �ֱ�  2. ���� ���� ó��
		
	private GameDisplayManager display;
	private Board board;
	private Player players[]; 	//���� �̿��ڹ迭
	private Player gamePlayer;	//�������� �÷��̾�	
	private Dice dice;		 	//�ֻ��� ����
	
	private int turn;			//���� �÷��̾ �����Ҷ� ���
	private int gameTurn;		//������ ����� �ϼ�
	private int initPlayer;		//�÷��̾� ������ �̿�	
	
	Scanner sc = new Scanner(System.in);
	
	GameManager(int userNum){
		this.display = new GameDisplayManager(this);
		this.board = new Board(this);
		this.dice = new Dice();
		this.players = new Player[userNum];
		this.gamePlayer = null;
		this.turn = -1;	
		this.gameTurn = 0;
		this.initPlayer = 0;
		initialize();
	}
	
	/*����ڵ��� �ʱ�ȭ �ϴ� �޼ҵ�
	 * 1. �÷��̾� ����
	 * 2. ������� �̸��� �ʱ�ݾ��� ����X
	 * 3. ������� ��ġ�� ������������
	 * 4. ���� �÷��̾� ���ϱ�
	 */
	public void initialize(){
		addPlayer();
		addPlayer();
		for(int i = 0; i < players.length; i++){			
			players[i].setLocate(board.getBoard(0));
		}
		gamePlayer = setFirst();
	}
	
	/*����ڸ� �߰��ϴ� �޼ҵ�*/
	public void addPlayer(){			
		for(int i = initPlayer; i < players.length; i++){
			Player player = new Player();
			players[i] = player;
			initPlayer ++;
		}
	}
		
	/*�� ������ �����ִ� �޼ҵ�*/
	public Player setTurn(){
		if(turn == 0){
			turn = 1;
			return players[1];
		}
		else{
			turn = 0;
			return players[0];
		}
	}

	/*ù������ ���ϴ� �޼ҵ�*/
	public Player setFirst(){
			int dice1 = dice.throwDice();
			int dice2 = dice.throwDice();
		if(dice1 < dice2){
			this.turn = 1;
			return players[1];
		}
		else{
			this.turn = 0;
			return players[0];
		}
	}
		
	/*�������� �÷��̾ ��ȯ*/
	public Player getGamePlayer(){
		return this.gamePlayer;
	}

	/*�ֻ��� �� ��ŭ �÷��̾ �̵���Ŵ*/
	public void move(int sumDices){	
		int move = 0;
		if(getGamePlayer().getLocateNum() + sumDices > board.getSize()){	// �� �÷��̾� ��ġ + �ֻ��� ���� > ��������Ǻ��� Ŭ��			
			move = sumDices - (board.getSize() - getGamePlayer().getLocateNum());	// ���� �������ĭ�� �̵��� �� ���� �ֻ��� �� ��ŭ �̵�
			getGamePlayer().initializeLocateNum();
			getGamePlayer().setLocate(board.getBoard(0));							// �÷��̾ 0 ��ġ�� ����
			getGamePlayer().setLocateNum(move);
			getGamePlayer().move(board.getBoard(getGamePlayer().getLocateNum()));			
		}
		else{
			move = sumDices;
			getGamePlayer().setLocateNum(move);
			getGamePlayer().move(board.getBoard(getGamePlayer().getLocateNum()));	
		}		
	}
	
	/*�����ϴ� �޼ҵ�
	 * 1. ���� �÷��̾��� ���� ���� ��� ���
	 * 2. 	0. ���� ���� ���
	 * 		1. ���ý� �ֻ����� ����
	 * 		2. ���ý� ������ ���� ���
	 * 		3. ���ý� ������ Ȳ�ݿ��� ���
	 * 		4. ���ý� Ȳ�ݿ��� ���
	 * */
	public void play(){		
		while(true){
			display.beforeThrowDisplay();
			int choice = sc.nextInt();
			if(choice == 0){
				/*���Ӽ��� �޼ҵ�*/
			}
			else if(choice == 1){
				if(gamePlayer.movable()){
					move(dice.throwDice());
					break;
				}			
			}		
			else if(choice == 2){
				gamePlayer.showOwnedLands();
			}
			else if (choice == 3){
				gamePlayer.showGoldKeys();
			}
			else if (choice == 4){
	//			gamePlayer.useGoldKey(name);
			}
			else
				display.errorDisplay();			
			}
	}
	
	/*�� ���� �����ϴ� �޼ҵ�
	 * 1. �÷��̸޼ҵ� ����
	 * 2. ����ڰ� ���� �ֻ��� ���� ���
	 * 3. ����ڰ� �̵��� ���� ��� (������ ������ ����)	 
	 * 4. ����� ���ø�� ���
	 * 5. 	1.���ý� �ش� ��ġ������ �ൿ
	 * 	  	2.���ý� ���÷��̾��� ���� ���
	 * 6. �ֻ��� ����� �ѹ��� �ƴ϶�� ���� ������ 
	 * */
	public void playTurn(){
			int choice;
		while(true){					
			play();												//������		
						
			dice.showDices();
			System.out.println("Move " + dice.getSumDices() + "\n");	//�ֻ��� ���
			
			display.locateExplainDisplay();						//������ġ ���� ���
			
			gamePlayer.getLocate().showContent();				//������ ������ �������� ���		
						
			while(true){
				display.afterThrowDisplay();
				
				choice = sc.nextInt();
				
				if(choice == 0){
					display.userDisplay();
				}
				else if(choice == 1){
					gamePlayer.action();
					break;
				}	
				else if(choice == 2){
					if(dice.doubles())	//setTurn()�޼ҵ� ���� ���� �Ѿ�Ƿ� 
						setTurn();		//�ֻ����� �����̸� �ѹ��� �ϱ����� ���ʸ� �ѹ� ���������� �ѱ�
					this.gamePlayer = setTurn(); // �ٽ� ���� ���ƿ�
				}
								
				}
			
			if(dice.doubles())	{
				display.doubleDisplay();
				playTurn();
			}
							
			this.gamePlayer = setTurn();
		}
	}
	
	/*������ �¸��� ���ϴ� �޼ҵ�*/
	public boolean isOver(){	//�̸޼ҵ带 ��� Ȯ���ϸ� ����
		return true;
	}

	/*���� ���� �޼ҵ�
	 * 1. ����ȭ���� ���
	 * 2. ���� , ���� ����
	 * 3. �̸��� �ʱ�ݾ� ����
	 * 4. ù������ ������
	 * 5. ���� ���� 
	 * */
	public void run(){			
			int choice , initmoney;
			String name;
		while(true){	
			display.mainDisplay();
			choice = sc.nextInt();
			
			if(choice == 0)
				break;
			
			else if(choice == 1){
				
					display.setNameDisplay();					
					name = sc.next();
					players[0].setName(name);		
					
					display.setNameDisplay();
					name = sc.next();
					players[1].setName(name);		
					
					display.setInitMoneyDisplay();
					initmoney = sc.nextInt();
					players[0].setMoney(initmoney);
					players[1].setMoney(initmoney); 
					
					display.setFirstDisplay();
				
					playTurn();
			}
		}		
	}
	
	//�¸����� 1. ���� 1000���� ������
	//		2. ��븦 �Ļ��Ų��
	//		3. S ���ø� ��� ������(S���� ���Խÿ��� �޼ҵ�� ��ü S���� �����ָ� Ȯ���Ѵ�) 
	
}
