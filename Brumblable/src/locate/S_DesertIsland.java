package locate;

import pack.GameManager;

public class S_DesertIsland extends A0_Land{

	private E_Type type = E_Type.SPECIFIC;
		
	public S_DesertIsland(GameManager gameManager) {
		super(gameManager);	
	}

	public void action(){
		
		//1. 주사위 더블이면 movable true
		//2. 턴이 3차례 넘어오면 movable true로
	}

	public void showContent() {
		String str = "";
		System.out.println(str);
	}
	
	public boolean movable() {
		return false;
	}

}
