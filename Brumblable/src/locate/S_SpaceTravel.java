package locate;

import pack.GameManager;

public class S_SpaceTravel extends A0_Land{

	private E_Type type = E_Type.SPECIFIC;
	
	public S_SpaceTravel(GameManager gameManager) {
		super(gameManager);	
	}

	public void action() {
		
	}

	public void showContent() {
		String str = "";
		System.out.println(str);
	}

	public boolean movable(){
		return false;
	}
	
}
