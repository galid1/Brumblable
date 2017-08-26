package pack;
import java.util.Scanner;
import board.Board;
import display.GameDisplayManager;

public class GameManager {//할것 . 1. 월급 주기  2. 게임 오버 처리
		
	private GameDisplayManager display;
	private Board board;
	private Player players[]; 	//게임 이용자배열
	private Player gamePlayer;	//진행중인 플레이어	
	private Dice dice;		 	//주사위 생성
	
	private int turn;			//현재 플레이어를 지정할때 사용
	private int gameTurn;		//게임이 진행된 턴수
	private int initPlayer;		//플레이어 생성시 이용	
	
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
	
	/*사용자들을 초기화 하는 메소드
	 * 1. 플레이어 생성
	 * 2. 사용자의 이름과 초기금액을 설정X
	 * 3. 사용자의 위치를 시작지점으로
	 * 4. 시작 플레이어 정하기
	 */
	public void initialize(){
		addPlayer();
		addPlayer();
		for(int i = 0; i < players.length; i++){			
			players[i].setLocate(board.getBoard(0));
		}
		gamePlayer = setFirst();
	}
	
	/*사용자를 추가하는 메소드*/
	public void addPlayer(){			
		for(int i = initPlayer; i < players.length; i++){
			Player player = new Player();
			players[i] = player;
			initPlayer ++;
		}
	}
		
	/*현 순서를 정해주는 메소드*/
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

	/*첫순서를 정하는 메소드*/
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
		
	/*진행중인 플레이어를 반환*/
	public Player getGamePlayer(){
		return this.gamePlayer;
	}

	/*주사위 수 만큼 플레이어를 이동시킴*/
	public void move(int sumDices){	
		int move = 0;
		if(getGamePlayer().getLocateNum() + sumDices > board.getSize()){	// 현 플레이어 위치 + 주사위 수가 > 보드게임판보다 클때			
			move = sumDices - (board.getSize() - getGamePlayer().getLocateNum());	// 남은 보드게임칸을 이동한 후 남는 주사위 수 만큼 이동
			getGamePlayer().initializeLocateNum();
			getGamePlayer().setLocate(board.getBoard(0));							// 플레이어를 0 위치로 놓고
			getGamePlayer().setLocateNum(move);
			getGamePlayer().move(board.getBoard(getGamePlayer().getLocateNum()));			
		}
		else{
			move = sumDices;
			getGamePlayer().setLocateNum(move);
			getGamePlayer().move(board.getBoard(getGamePlayer().getLocateNum()));	
		}		
	}
	
	/*진행하는 메소드
	 * 1. 현재 플레이어의 게임 진행 목록 출력
	 * 2. 	0. 게임 설명 출력
	 * 		1. 선택시 주사위를 던짐
	 * 		2. 선택시 소유한 땅을 출력
	 * 		3. 선택시 소유한 황금열쇠 출력
	 * 		4. 선택시 황금열쇠 사용
	 * */
	public void play(){		
		while(true){
			display.beforeThrowDisplay();
			int choice = sc.nextInt();
			if(choice == 0){
				/*게임설명 메소드*/
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
	
	/*한 턴을 진행하는 메소드
	 * 1. 플레이메소드 실행
	 * 2. 사용자가 던진 주사위 내용 출력
	 * 3. 사용자가 이동한 정보 출력 (도착한 도시의 정보)	 
	 * 4. 사용자 선택목록 출력
	 * 5. 	1.선택시 해당 위치에서의 행동
	 * 	  	2.선택시 현플레이어의 상태 출력
	 * 6. 주사위 더블시 한번더 아니라면 다음 턴으로 
	 * */
	public void playTurn(){
			int choice;
		while(true){					
			play();												//턴진행		
						
			dice.showDices();
			System.out.println("Move " + dice.getSumDices() + "\n");	//주사위 출력
			
			display.locateExplainDisplay();						//유저위치 정보 출력
			
			gamePlayer.getLocate().showContent();				//유저가 도착한 도시정보 출력		
						
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
					if(dice.doubles())	//setTurn()메소드 사용시 턴이 넘어가므로 
						setTurn();		//주사위가 더블이면 한번더 하기위해 차례를 한번 고의적으로 넘김
					this.gamePlayer = setTurn(); // 다시 차례 돌아옴
				}
								
				}
			
			if(dice.doubles())	{
				display.doubleDisplay();
				playTurn();
			}
							
			this.gamePlayer = setTurn();
		}
	}
	
	/*게임의 승리를 정하는 메소드*/
	public boolean isOver(){	//이메소드를 계속 확인하며 진행
		return true;
	}

	/*게임 진행 메소드
	 * 1. 메인화면을 띄움
	 * 2. 시작 , 종료 선택
	 * 3. 이름과 초기금액 설정
	 * 4. 첫순서가 정해짐
	 * 5. 게임 진행 
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
	
	//승리조건 1. 돈을 1000만원 모은다
	//		2. 상대를 파산시킨다
	//		3. S 도시를 모두 모은다(S도시 매입시에만 메소드로 전체 S도시 소유주를 확인한다) 
	
}
