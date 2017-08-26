package goldKey;

import pack.GameManager;

public class G_EscapeIsland extends GoldKey{

	public G_EscapeIsland() {
		name = "G_EscapeIsland";
	}

	public void use() {
		
	}

	public boolean gettable() {
		return true;
	}

	public void showContent() {
		String str = name
				+ "\n-You can escape at the Desert Island Anytime!"
				+ "\n(You can use this card when you need it)" + "\n" ;
		System.out.println(str);
	}
	
}
