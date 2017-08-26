package pack;

public class Tester {

	public static void main(String[] args) {
		Dice dice = new Dice();
		
		System.out.println(dice.throwDice());
		dice.showDices();
		System.out.println(dice.doubles());
	}

}
