package locate;

import pack.GameManager;
import pack.Player;

public abstract class A1_City extends A0_Land {
	
	protected Player owner = null;	
	protected int price = 0;		//������
	protected int bill = 0;			//�����ֿ� ���� ���� �ݾ�
	protected boolean buildings[]; //�� ���ÿ� ������ �ǹ� ��	
	protected int buildNum = 0;		//���� �ǹ� �� (��ӹ��� �Ʒ� 4���� Ŭ������ ����)
	
	A1_City(GameManager gameManager) {
		super(gameManager);
		type = E_Type.CITY;		
	}
	
	public void action(){
		if(owner == null)
			build();
		else
			gameManager.getGamePlayer().pay(bill);
	}

	public void sell(){
		/*for(int i = 0; i < buildings.length; i++){
			buildings[i] = null;
			
		  buildNum = 0;
		}*/
	}	
	
	public boolean enough(Player gamePlayer){	//���� ������� Ȯ��
		if(gameManager.getGamePlayer().getMoney() > price)
			return true;
		else
			return false;
	}

	public boolean movable(){					//���ô� Ư�̻����� �����Ƿ� �̵�����
		return true;						
	}
			
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player player){
		this.owner = player;
	}
		
	public int getBill(){				// ���� �ǹ��� ���� ���ұݾ�
		return bill;
	}
	
	public abstract void showContent();
	
	public abstract int empty();
	
	public abstract void setBill();
	
	public abstract void build();
	
}
