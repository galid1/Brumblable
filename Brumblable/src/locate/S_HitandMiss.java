package locate;

import pack.GameManager;

public class S_HitandMiss extends A0_Land{

	private E_Type type = E_Type.SPECIFIC;
	
	public S_HitandMiss(GameManager gameManager) {
		super(gameManager);		
	}

	public void action() {
		
	}

	public void showContent() {
		String str = "";
		System.out.println(str);
	}
	
	public boolean movable(){
		return true;
	}
	
}
