package goldKey;

import pack.GameManager;

public class G_PayHospital extends GoldKey{	

	G_PayHospital() {
		name = "G_PayHospital";		
	}

	public void use() {		//���� �ϰų� ���� �޴� ������ �ٷ� ��� �ǰԲ�
		
	}

	public boolean gettable(){
		return false;
	}
	
	public void showContent() {
		String str = name
				+ "\n- You have to pay Hospital expenses! (50000W)" + "\n";
		System.out.println(str);
	}

}
