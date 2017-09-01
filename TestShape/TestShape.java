package TestShape;

import java.util.Arrays;
import java.util.Scanner;

public class TestShape {
	public static int count = 0;
	public static Shape a[] = new Shape [10];	//宣告抽象類別型態的變數
	public static Scanner sc  = new Scanner(System.in);
	public static void main(String[] args) {
		int option = 0;
		boolean run = true;

		while (run) {
			
			switch(option) {
			case 0:
				System.out.print("Menu: 1)add, 2)output, -1)Quit: ");
				int input = sc.nextInt();
				if (input != 1 && input != 2 && input != -1) {
					System.out.println("Input error!");
				}
				else {
					option = input;
				}
				break;
			case 1:
				addShape();
				option = 0;
				break;
			case 2:
				for (int i = 0; i < count; i++) {
					if (a[i] instanceof Shape) {
						System.out.printf("Type: %10s\t",a[i].getClass().getName());
						a[i].show();
					}
				}
				System.out.println("");
				option = 0;
				break;
			case -1:
				run = false;
				break;
				
			}
		}
	}
	
	public static void addShape() {
		if (count >= a.length) {
			resize(a);
		}
		int choice = 0;
		boolean run = true;
		while (run) {
			switch(choice) {
			case 0:
				System.out.print("Options: 1)rectangle, 2)circle, 3)trapezoid, -1)Quit: ");
				int input = sc.nextInt();
				if (input != 1 && input != 2 && input != 3 && input != -1) {
					System.out.println("Input error!");
				}
				else {
					choice = input;
				}
				break;
			case 1:
				System.out.print("Enter length and width: ");
				double length = sc.nextDouble();
				double width = sc.nextDouble();
				if (length < 0 || width < 0) {
					System.out.println("Input error!");
				}
				else {
					a[count] = new Rectangle(length,width);
					System.out.printf("Type: %10s\t","Rectangle");
					a[count++].show();
					choice = 0;
				}

				break;
			case 2:
				System.out.print("Enter radius: ");
				double radius = sc.nextInt();
				if (radius < 0) {
					System.out.println("Input error!");
				}
				else {
					a[count] = new Circle(radius);
					System.out.printf("Type: %10s\t","Circle");
					a[count++].show();
					choice = 0;
				}

				break;
			case 3:
				System.out.print("Enter upper, lower and height: ");
				double upper = sc.nextDouble();
				double lower = sc.nextDouble();
				double height = sc.nextDouble();
				if (upper < 0 || lower < 0 || height < 0) {
					System.out.println("Input error!");
				}
				else {
					a[count] = new Trapezoid(upper, lower, height);
					System.out.printf("Type: %10s\t","Trapezoid");
					a[count++].show();
					choice = 0;	
				}
				break;
			case -1:
				run = false;
				break;
			default:
				System.out.println("Input error!");
			}
		}
	}
	
	public static Shape[] resize (Shape[] a) {
		return Arrays.copyOf(a,a.length * 2);
	}
}










