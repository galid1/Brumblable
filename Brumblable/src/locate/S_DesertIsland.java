package locate;

import pack.GameManager;

public class S_DesertIsland extends A0_Land{

	private E_Type type = E_Type.SPECIFIC;
		
	public S_DesertIsland(GameManager gameManager) {
		super(gameManager);	
	}

	public void action(){
		
		//1. �ֻ��� �����̸� movable true
		//2. ���� 3���� �Ѿ���� movable true��
	}

	public void showContent() {
		String str = "";
		System.out.println(str);
	}
	
	public boolean movable() {
		return false;
	}

}
