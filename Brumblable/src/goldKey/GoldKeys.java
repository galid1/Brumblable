package goldKey;

import java.util.ArrayList;
import java.util.Collections;
import locate.A0_Land;
import locate.E_Type;
import pack.GameManager;

public class GoldKeys extends A0_Land {	//������ Ȳ�ݿ��谡 ���ڸ��� �� ��ü�� �ִ´�(A0_Land �� ��ӹ����� ��� ����)

	private GameManager gameManager;
	
	private ArrayList <GoldKey> goldKeys;
		
	public GoldKeys(GameManager gameManager) {
		super(gameManager);
		type = E_Type.GOLDKEY;
		this.goldKeys = new ArrayList<GoldKey>();
		createGoldKeys();
	}

	public void action() {
		pop();
		popContent();
		shuffle();
	}

	public void shuffle(){
		Collections.shuffle(goldKeys);
	}
	
	public GoldKey pop(){		
		return goldKeys.get(0);
	}
	/*���� ī�忡 ���� ����*/
	public void popContent(){
		String str = "You pop : " + pop().getName();
		System.out.println(str);
		pop().showContent();		
	}
	
	public boolean movable() {		
		return true;
	}

	public void createGoldKeys(){
		goldKeys.add(new G_PayHospital());
		goldKeys.add(new G_WinLottery());
		goldKeys.add(new G_EscapeIsland());	
	}
	
	/*��ӽ� ������ �޼ҵ� ���� �ʿ����*/
	public void showContent() {
		String str = "";
		System.out.println(str);
	}
	
}
