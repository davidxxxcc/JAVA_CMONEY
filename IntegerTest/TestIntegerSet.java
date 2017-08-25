package IntegerTest;

import java.util.Scanner;

public class TestIntegerSet {
	
	public static Scanner sc = new Scanner(System.in);
	public static IntegerSet a = initialize();
	public static IntegerSet b = initialize();
	public static void main(String[] args) {

		boolean run = true;
		int option = 0;
		while (run) {
			
			if (option == 0) {
				System.out.print("Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit: ");
				int input = sc.nextInt();
				switch(input) {
				case 1:
					option = 1;
					break;
				case 2:
					option = 2;
					break;
				case 3:
					IntegerSet x = b.intersection(a);
					System.out.print("Intersection: ");
					x.output();
					option = 0;
					break;
				case 4:
					IntegerSet y = b.union(a);
					System.out.print("Union: ");
					y.output();
					option = 0;
					break;
				case -1:
					run = false;
					break;
				default :
					System.out.println("Input error! ");
				}
			}
			if (option == 1) {
				option = ModifyA();
			}
			if (option == 2) {
				option = ModifyB();
			}
		}
			
	}
	
	public static IntegerSet initialize() {
		int input = 0;
		
		System.out.print("Initial size for Set: ");
		input = sc.nextInt();
		if (input <1) {
			System.out.print("Size number error! ");
			return initialize();
		}
		else {
			return new IntegerSet(input);
		}
	}
	
	public static int ModifyA () {
		boolean run = true;
		while (run) {
			System.out.print("Modify A: a) Insert. b) Output. c) Delete. d) Back: ");
			String input = sc.next();
			if (input.equals("a")) {
				System.out.print("Insert: ");
				int num = sc.nextInt();
				if (num <0 || num > 100) {
					System.out.println("Input error! ");
					continue;
				}	
				else
					a.Insert(num);
			}
			else if (input.equals("b")) {
				a.output();
			}
			else if (input.equals("c")) {
				System.out.print("Delete: ");
				int num = sc.nextInt();
				if (a.search(num)== -1)
					System.out.println("'" + num + "'not found!");
				else {
					a.delete(num);
					System.out.println("'" + num +"'successfully deleted! ");
				}
			}
			else if (input.equals("d")) {
				return 0;
			}
			else 
				System.out.println("Input error! ");
		}
		return 0;
	}
	
	public static int ModifyB () {
		boolean run = true;
		while (run) {
			System.out.print("Modify B: a) Insert. b) Output. c) Delete. d) Back: ");
			String input = sc.next();
			if (input.equals("a")) {
				System.out.print("Insert: ");
				int num = sc.nextInt();
				if (num <0 || num > 100) {
					System.out.println("Input error! ");
					continue;
				}	
				else
					b.Insert(num);
			}
			else if (input.equals("b")) {
				b.output();
			}
			else if (input.equals("c")) {
				System.out.print("Delete: ");
				int num = sc.nextInt();
				if (b.search(num)== -1)
					System.out.println("'" + num + "'not found!");
				else {
					b.delete(num);
					System.out.println("'" + num +"'successfully deleted! ");
				}
			}
			else if (input.equals("d")) {
				return 0;
			}
			else 
				System.out.println("Input error! ");
		}
		return 0;
		
	}

}
