package locate;

import pack.GameManager;
import pack.Player;

public class A1_UniqueCity extends A0_Land{
	
	protected Player owner = null;	
	protected int price = 0;
	protected int bill = 0;	
	
	A1_UniqueCity(GameManager gameManager) {
		super(gameManager);
		 type = E_Type.UCITY;
	}

	public void action(){
		if(owner == null)
			build();
		else
			gameManager.getGamePlayer().pay(bill);
	}

	public void build(){
		Player gamePlayer = gameManager.getGamePlayer();
		if(enough(gamePlayer)){
			gamePlayer.pay(price);
			owner = gamePlayer;
		}
		else
			return;
	}

	public void sell(){
		/*for(int i = 0; i < buildings.length; i++){
			buildings[i] = null;
		}*/
	}
	
	public boolean enough(Player gamePlayer){					//금액 확인후 건설
		if(gameManager.getGamePlayer().getMoney() > price)
			return true;
		else
			return false;
	}

	public boolean movable(){
		return true;					//유니크도시는 특이사항이 없으므로 이동가능
	}	

	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player player){
		this.owner = player;
	}
	
	public int getBill(){
		return bill;
	}

	public void showContent() {
		String str = "";
		System.out.println(str);		
	}
	
}
