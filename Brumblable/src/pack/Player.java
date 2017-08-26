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
	/*���忡�� �̵��� ����ġ�� ������ �Է��ϱ����� �޼ҵ�*/
	public void move(A0_Land locate){
		if(movable())
		this.locate = locate;
	}
	/*���� �� ������ ������*/
	public void pay(int price){
		this.money -= price;
	}
	/*���� ���� �� ���*/
	public void receiveMoney(int salary){
		this.money += salary;
	}	
	/*��ġ�� ������ ����*/
	public A0_Land getLocate(){		
		return locate;
	}
	/*ó�� ������� ��ġ�� 0���� �������� ����ϴ� �޼ҵ�*/
	public void setLocate(A0_Land locate){
		this.locate = locate;
	}
	
	/*���尡 ����Ʈ�̱� ������ ��ġ�� ���ڷ� ǥ���� ex)board[0]*/
	public int getLocateNum(){
		return this.locateNum;
	}
	/*���尡 ����Ʈ�̱� ������ ��ġ�� ���ڷ� ǥ���� ex)board[0]*/
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
	/*�ʱ� �ݾ� ���� �޼ҵ�*/
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
