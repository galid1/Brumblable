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
	
	//�̸� ��ӹ޴� ����,Ư������ Ŭ������ �����
	//����ڴ� �ش� ������ ������ ������� Ÿ���� �ް� �״��� �����ڸ� �޴´�
}
