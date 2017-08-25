package CardTest;

import java.util.Scanner;
public class CardTest {

	public static void main(String[] args) {
//	Cards a = new Cards();

//	a.newCards();
//	b.newCards();
//	System.out.print(b.toString());
//	int n = b.getCard();
//	System.out.println("");
		ShuffleCards a = new ShuffleCards();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean run = true;
		a.newCards();
		while(true) {
			switch(option) {
			case 0:
				System.out.print("Options: 1)remain cards , 2)get card, 3)µo¥|²ÕµP, -1)Quit: ");
				int input = sc.nextInt();
				if (input == 1)
					option = 1;
				else if (input == 2)
					option = 2;
				else if (input == 3)
					option = 3;
				else if (input == -1)
					option = -1;
				else 
					System.out.println("Input error!");
				break;
			case 1:
				System.out.println("Remaining cards: " + a.getRemain());
				option = 0;
				break;
			case 2:
				printCard(a.getCard());
				System.out.println("");
				option = 0;
				break;
			case 3:
				for (int i = 1; i < 53; i ++) {
						printCard(a.getCard());
					if (i%4 ==0)
					System.out.println("");
				}
				option = 0;
				break;
			case -1:
				run = false;
				break;
			}
			
		}
	}
	
	public static void printCard(int n) {
		String[] color = {"S","H","D","C"};
		String cardString = ("");
		cardString = color[n/13] + "#" + Integer.toString(n%13+1) + " ";
		System.out.printf("%5s",cardString);
	}

}
