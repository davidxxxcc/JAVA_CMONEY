package ListTest;

import java.util.Scanner;
public class ListTest {
	public static Scanner sc = new Scanner(System.in);
	public static int option = 0;
	public static AdvancedSearchList a = new AdvancedSearchList(10);
	public static void main(String[] args) {
		boolean run = true;
		// 1) Append, 2)Search, 3)Max, 4)remove(index), 5)remove(value,number), -1)Quit:
		while (run) {
			switch(option) {
			case 0:
				option = option();
				break;
			case 1:
				addNumber();
				option = 0;
				break;
			case 2:
				searchNumber();
				option = 0;
				break;
			case 3:
				maxNumber();
				option = 0;
				break;
			case 4:
				remove1Var();
				option = 0;
				break;
			case 5:
				remove2Var();
				option = 0;
				break;
			case 6:
				run = false;
				break;
			}
		}
	}
	public static int option() {
		while (true) {
			System.out.print("Options: 1) Append, 2)Search, 3)Max, 4)remove(index), 5)remove(value,number), -1)Quit: ");
			int input = sc.nextInt();
			if (input == 1)
				return 1;
			else if (input == 2)
				return 2;
			else if (input == 3)
				return 3;
			else if (input == 4)
				return 4;
			else if (input == 5)
				return 5;
			else if (input == -1)
				return 6;
			else
				System.out.println("¿é¤J¿ù»~!");
			}
	}
	public static void addNumber() {
		while (true) {
			System.out.print("Please add number: ");
			int input = sc.nextInt();
			if (input == -1) {
				break;
			}
			else
				a.add(input);
		}
	}
	
	public static void searchNumber() {
		System.out.print("Please enter a number: ");
		int input = sc.nextInt();
		a.print();
		System.out.println("");
		if (a.search(input) == -1)
				System.out.println(input + " is not in the list!");
		else
			System.out.println(input + " is in " + a.search(input) + " index");
	}
	
	public static void maxNumber() {
		System.out.println(+ a.findMax()+ " is max in the list!");
	}
	
	public static void remove1Var() {
		System.out.print("Please enter index to remove in the list: ");
		int input = sc.nextInt();
		a.remove(input);
		a.print();
		System.out.println("");
	}

	public static void remove2Var() {
		System.out.print("Please enter value  and number to remove in the list: ");
		int value = sc.nextInt();
		int number = sc.nextInt();
		a.remove(value, number);
		a.print();
		System.out.println("");
		
	}
}
