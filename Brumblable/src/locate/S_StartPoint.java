package locate;

import pack.GameManager;

public class S_StartPoint extends A0_Land{

	private E_Type type = E_Type.STARTPOINT;
	
	public S_StartPoint(GameManager gameManager) {
		super(gameManager);
		name = "Start Point";
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
