package locate;
import pack.Player;
import display.GameDisplayManager;
import pack.GameManager;

public abstract class A0_Land {
			
	protected GameManager gameManager;
	protected GameDisplayManager display = new GameDisplayManager(gameManager);
	
	protected String name = null;		
	protected E_Type type;
		
	protected A0_Land(GameManager gameManager){
		this.gameManager = gameManager;
	}	

	public String getName(){
		return this.name;
	}
	
	public E_Type getType(){
		return this.type;
	}
	
	public abstract void action();	
	
	public abstract boolean movable();
	
	public abstract void showContent();
	
	//이를 상속받는 도시,특별도시 클래스를 만든다
	//사용자는 해당 지점에 도착시 가장먼저 타입을 받고 그다음 소유자를 받는다
}
