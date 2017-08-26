package pack;

import java.util.ArrayList;

import goldKey.GoldKey;
import goldKey.GoldKeys;
import locate.A0_Land;

public class Player {
	
	private A0_Land locate;	
	private ArrayList<GoldKey> ownedGoldKeys;
	private ArrayList<A0_Land> ownedLands;
	
	private String name;
	private int money;	
	private int locateNum;
	
	Player(){
		locate = null;
		this.name = null;
		this.money = 0;	
		this.locateNum = 0;
	}

	public void action(){
		locate.action();
	}

	public boolean movable(){
		return locate.movable();
	}
	/*보드에서 이동시 현위치의 지역을 입력하기위한 메소드*/
	public void move(A0_Land locate){
		if(movable())
		this.locate = locate;
	}
	/*남의 땅 도착시 돈지불*/
	public void pay(int price){
		this.money -= price;
	}
	/*월급 받을 때 사용*/
	public void receiveMoney(int salary){
		this.money += salary;
	}	
	/*위치한 지역을 리턴*/
	public A0_Land getLocate(){		
		return locate;
	}
	/*처음 사용자의 위치를 0으로 놓기위해 사용하는 메소드*/
	public void setLocate(A0_Land locate){
		this.locate = locate;
	}
	
	/*보드가 리스트이기 때문에 위치가 숫자로 표현됨 ex)board[0]*/
	public int getLocateNum(){
		return this.locateNum;
	}
	/*보드가 리스트이기 때문에 위치가 숫자로 표현됨 ex)board[0]*/
	public void setLocateNum(int locateNum){
		this.locateNum += locateNum;
	}
	
	public void initializeLocateNum(){
		this.locateNum = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getMoney(){
		return money;
	}
	/*초기 금액 설정 메소드*/
	public void setMoney(int initmoney){
		this.money = initmoney;
	}
	
	public void useGoldKey(String name){
		getGoldKeys(name).use();
	}
	
	public void showOwnedLands(){
		String str = "";
		System.out.println(str);
	}	

	public void showGoldKeys(){		
		String str = "";		
		for(int i = 0; i < ownedGoldKeys.size(); i++){
			str += "1. " + ownedGoldKeys.get(i).getName() + "\n";
		}		
		System.out.println(str);		
	}
			
	public GoldKey getGoldKeys(String name){
			GoldKey goldKey;
		for(int i = 0; i < ownedGoldKeys.size(); i++){			
			goldKey = ownedGoldKeys.get(i);
			if(goldKey.getName().equals(name))
				return goldKey;
		}
				return null;			
	}
		
}
