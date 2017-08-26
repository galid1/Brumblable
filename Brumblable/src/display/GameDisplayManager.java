package display;

import locate.E_Type;
import pack.GameManager;

public class GameDisplayManager {	//할일 : 게임설명  , 남의땅 도착시 , 액션시
		
	private GameManager gameManager;
	
	public GameDisplayManager(GameManager gameManager){
		this.gameManager = gameManager;
	}
		
	/*메인화면*/
	public void mainDisplay(){
		String str = "========Brumblable========"
				+ "\n0. Exit"
				+ "\n1. Start";		
		System.out.println(str);
	}

	/*에러 화면*/
	public void errorDisplay(){
		String str = "====Error===="
				+ "\n- Please re-input.";
		System.out.println(str);
	}
	
	/*게임 설명*/
	public void gameExplainDisplay(){
		String str = "";
		
		System.out.println(str);
	}
	
	/*건물짓기 설명 (필요에따라 리턴타임 String으로)*/
	public void buildExplainDisplay(){
		String str = "========BuiltExplain========"
				+ "\n- When you build one Building, the price is 1.2times."
				+ "\n- ... Two Buildings, the price is 1.4times."
				+ "\n- ... Three Buildings, the price is 1.6times."
				+ "\n- ... Four Buildings, the price is 2times.";
		System.out.println(str);
	}
	
	/*도착한 곳 설명*/
	public void locateExplainDisplay(){
		String str = "";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.CITY)
			str = "You Arrive at City!"
				+ "\n- You can build Buildings" + "\n";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.UCITY)
			str = "You Arrive at Unique City!"
				+ "\n- You can build a Building" + "\n";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.SPECIFIC)
			str = "You Arrive at Specific Place!" + "\n";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.GOLDKEY)
			str = "You Arrive at GoldKey!"
				+ "\n- You can draw a Card!" + "\n";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.STARTPOINT)
			str = "You Arrive at StartPoint!"
				+ "\n- You receive a salary(300000)" + "\n";
		System.out.println(str);		
	}
	
	/*진행할 플레이어수 지정(아직 구현안함)*/
	public void setPlayerDisplay(){
		String str = "========Brumblable========"
				+ "\nPut the number of people to play the game(Not yet Only two!)";
		System.out.println(str);
	}
	
	/*사용자 이름 지정*/
	public void setNameDisplay(){
		String str = "========Brumblable========"
				+ "\nPut the name of Player : ";
		System.out.println(str);
	}
	
	/*사용자 초기금액 지정*/
	public void setInitMoneyDisplay(){
		String str = "========Brumblable========"
				+ "\nPut the InitMoney : ";
		System.out.println(str);
	}
	
	/*시작 플레이어*/
	public void setFirstDisplay(){		
		String str = "The game will start ..."
				+ "\nThe start player is " + gameManager.getGamePlayer().getName();
		System.out.println(str);
	}
	
	/*턴 시작 화면*/
	public void beforeThrowDisplay(){
		String str = gameManager.getGamePlayer().getName() + "'s Turn"
				+ "\nLocate in " + gameManager.getGamePlayer().getLocate().getName()
				+ "\n"
				+ "\n========Player("+ gameManager.getGamePlayer().getName() +")========"
				+ "\n0. Game Explain"
				+ "\n1. Throw dices"				
				+ "\n2. Owned Lands"
				+ "\n3. Owned Gold Keys"
				+ "\n4. Use Gold Keys";
		System.out.println(str);
	}
	
	/*턴 종료전 화면*/
	public void afterThrowDisplay(){
		String str1 = "";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.CITY ||
				gameManager.getGamePlayer().getLocate().getType() == E_Type.UCITY)
			str1 = "\n  (Build buildings)";		
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.GOLDKEY)				
			str1 = "\n  (Pop GoldKey)";
		
		String str = "\n"
				+ "\n========Plyer("+ gameManager.getGamePlayer().getName() +")========"
				+ "\n0. Status"
				+ "\n1. Action" + str1
				+ "\n2. Turning";
		System.out.println(str);
	}
			
	public void actionDisPlay(){
		String str = "";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.CITY)
			str = "You built a Building!" + "\n";				
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.UCITY)
			str = "You built a Building!" + "\n";	
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.SPECIFIC)
			str = "You do a special action!" + "\n";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.GOLDKEY)
			str = "Pop a GoldCard!";
		if(gameManager.getGamePlayer().getLocate().getType() == E_Type.STARTPOINT)
			str = "You receive salary!(300,000W)";
		System.out.println(str);
	}
	
	/*유저화면*/
	public void userDisplay(){
		String str ="=====User Status====="
				+ "\n- Player : " + gameManager.getGamePlayer().getName()
				+ "\n- Money : " + gameManager.getGamePlayer().getMoney() +"W";
		System.out.println(str);
	}	
		
	/*주사위 더블*/
	public void doubleDisplay(){
		String str = "====Double Dices===="
				+ "\n- Congratulation!"
				+ "\n- Play one more because Dices are double.";
		System.out.println(str);
	}
		
}
