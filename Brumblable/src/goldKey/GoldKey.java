package goldKey;
import locate.A0_Land;
import pack.GameManager;

public abstract class GoldKey{
	
	protected String name;	
	
	public String getName(){
		return name;
	}

	public boolean movable() {	
		return true;
	}

	public abstract void use();
	
	public abstract boolean gettable();
	
	public abstract void showContent();	
	
}
