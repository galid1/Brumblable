package locate;

import pack.GameManager;
import pack.Player;

public abstract class A1_City extends A0_Land {
	
	protected Player owner = null;	
	protected int price = 0;		//땅가격
	protected int bill = 0;			//소유주에 대한 지불 금액
	protected boolean buildings[]; //한 도시에 지어진 건물 수	
	protected int buildNum = 0;		//지을 건물 수 (상속받은 아래 4개의 클래스에 영향)
	
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
	
	public boolean enough(Player gamePlayer){	//돈이 충분한지 확인
		if(gameManager.getGamePlayer().getMoney() > price)
			return true;
		else
			return false;
	}

	public boolean movable(){					//도시는 특이사항이 없으므로 이동가능
		return true;						
	}
			
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player player){
		this.owner = player;
	}
		
	public int getBill(){				// 지은 건물에 대한 지불금액
		return bill;
	}
	
	public abstract void showContent();
	
	public abstract int empty();
	
	public abstract void setBill();
	
	public abstract void build();
	
}
