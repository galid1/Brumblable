package goldKey;

import pack.GameManager;

public class G_WinLottery extends GoldKey{	

	public G_WinLottery() {
		name = "G_WinLottery";
		
	}

	public void use() {
		
	}

	public boolean gettable() {
		return false;
	}

	public void showContent() {
		String str = name
				+ "\n- Winnig the lottery Jackpot!"
				+ "\n(You can get the money(200,000W))" + "\n";				
		System.out.println(str);
	}

}
