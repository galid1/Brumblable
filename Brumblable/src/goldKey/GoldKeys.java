package goldKey;

import java.util.ArrayList;
import java.util.Collections;
import locate.A0_Land;
import locate.E_Type;
import pack.GameManager;

public class GoldKeys extends A0_Land {	//보드의 황금열쇠가 들어갈자리에 이 객체를 넣는다(A0_Land 를 상속받을지 어떻게 할지)

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
	/*뽑은 카드에 대한 설명*/
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
	
	/*상속시 강제된 메소드 아직 필요없음*/
	public void showContent() {
		String str = "";
		System.out.println(str);
	}
	
}
