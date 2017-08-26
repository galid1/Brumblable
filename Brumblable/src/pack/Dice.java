package pack;

import java.util.Random;

public class Dice {
	
	Random rand = new Random();
	private int dices[] = new int[2];	
	private int sumDices;
		
	public int throwDice(){
			sumDices = 0;
		for(int i = 0; i < dices.length; i++){
			dices[i] = 0;
			dices[i] = rand.nextInt(6)+1;
			sumDices += dices[i];
		}								
		return sumDices;
	}
	
	public int getSumDices(){
		int sum = dices[0] + dices[1];
		return sum;
	}
	
	public void showDices(){		
		String str = "First Dice = " + dices[0]
					+"\n"
					+"Second Dice = " + dices[1];
		if(doubles())
			str += "\n Congratulation! Dices are double!";
		System.out.println(str);
	}
	
	public boolean doubles(){
		if(dices[0] == dices[1])			
			return true;
		else
			return false;
	}
	
}
