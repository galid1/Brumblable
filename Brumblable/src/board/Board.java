package board;

import java.util.ArrayList;

import locate.*;
import pack.GameManager;
import goldKey.GoldKeys;

public class Board {
	
	private GameManager gameManager;
	
	private ArrayList<A0_Land> board;
	
	public Board(GameManager gameManager){
		this.gameManager = gameManager;
		this.board = new ArrayList();
		creatBoard();
	}
	
	public A0_Land getBoard(int index){
		return board.get(index);
	}
	
	public int getSize(){
		return board.size();
	}
	
	public void creatBoard(){		
		board.add(new S_StartPoint(gameManager));
		board.add(new Cy_Taipei(gameManager));
		board.add(new S_HitandMiss(gameManager));
		board.add(new Cy_Hongkong(gameManager));
		board.add(new Cy_Manila(gameManager));
		board.add(new Cu_Jejudo(gameManager));
		board.add(new Cy_Singapore(gameManager));
		board.add(new GoldKeys(gameManager));
		board.add(new Cy_Cairo(gameManager));
		board.add(new Cy_Istanbul(gameManager));
		board.add(new S_DesertIsland(gameManager));
		board.add(new Cg_Athens(gameManager));
		board.add(new GoldKeys(gameManager));
		board.add(new Cg_Copenhagen(gameManager));
		board.add(new Cg_Stockholm(gameManager));
		board.add(new Cu_Concorde(gameManager));
		board.add(new Cg_Zurich(gameManager));
		board.add(new GoldKeys(gameManager));
		board.add(new Cg_Berlin(gameManager));
		board.add(new Cg_Montreal(gameManager));
		board.add(new S_SocialPay(gameManager));
		board.add(new Cp_BuenosAires(gameManager));
		board.add(new GoldKeys(gameManager));
		board.add(new Cp_Saopaulo(gameManager));
		board.add(new Cp_Sydney(gameManager));
		board.add(new Cu_Busan(gameManager));
		board.add(new Cp_Hawaii(gameManager));
		board.add(new Cp_Lisbon(gameManager));
		board.add(new Cu_QueenElizabeth(gameManager));
		board.add(new Cp_Madrid(gameManager));
		board.add(new S_SpaceTravel(gameManager));
		board.add(new Cr_Tokyo(gameManager));
		board.add(new Cu_Columbia(gameManager));
		board.add(new Cr_Paris(gameManager));
		board.add(new Cr_Roma(gameManager));
		board.add(new GoldKeys(gameManager));
		board.add(new Cr_London(gameManager));
		board.add(new Cr_Newyork(gameManager));
		board.add(new S_SocialStorage(gameManager));
		board.add(new Cr_Seoul(gameManager));				
	}
	
	
}
