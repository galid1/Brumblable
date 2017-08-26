package goldKey;

import pack.GameManager;

public class G_PayHospital extends GoldKey{	

	G_PayHospital() {
		name = "G_PayHospital";		
	}

	public void use() {		//지불 하거나 돈을 받는 종류는 바로 사용 되게끔
		
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
