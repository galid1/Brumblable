package locate;

import pack.GameManager;
import pack.Player;

public class Ag2_City extends A1_City{
	
	private int builtable = 2;	
		
	Ag2_City(GameManager gameManager) {		
		super(gameManager);		
		this.buildings = new boolean[builtable];	
	}
	
	public void build(){
		Player gamePlayer = gameManager.getGamePlayer();
		if(enough(gamePlayer)){
			gamePlayer.pay(pricing(buildNum));
			owner = gamePlayer;		
			for(int i = 0; i < buildNum; i++)
				buildings[i] = true;			
		}
		else
			return;
	}	
		
	public int empty() {
		if(buildings == null)
			return 2;
		else if(buildings[0] == true && buildings[1] == false)
			return 1;
		else if(buildings[0] == true && buildings[1] == true)
			return 0;
		else 
			return (Integer)null;
	}
	
	public void showContent() {
		String str = "====City Content==== "
				+ "\n- City Name : " + name
				+ "\n- City Price : " + price + "W"
				+ "\n- City Owner : " + owner
				+ "\n- It's a Green City."
				+ "\n- There can be built two buildings";								
		System.out.println(str);
	}
	
	public int pricing(int buildNum){
		if(buildNum == 2)
			return price *= 1.1;
		else
			return price *= 1;
	}
	
	public void setBill() {
		if(empty() == 0)		//2개의 건물이 지어짐
			this.bill *= 1.4;
		else if(empty() == 1)   //1개의 건물이 지어짐
			this.bill *= 1.2;
		else
			return;
	}

}
