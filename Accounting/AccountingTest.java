package Accounting;
import java.util.Scanner;

public class AccountingTest {
	public static Accounting accountBook = new Accounting();
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int option = -1;
		do {
			System.out.print("�ﶵ�G1)�s�W,2)�L�X����,-1)�����G");
			option = scanner.nextInt();
			if (option != -1 && option != 1 && option != 2) {
				System.out.print("Error!");
			}
			else if (option == -1) {
				System.out.println("�P�±z���ϥ�!");
				break;
			}
			else if (option == 2) {
				accountBook.print();
			}
			else if (option == 1) {
				System.out.print("�~�W�G");
				String name = scanner.next();
				System.out.print("����G");
				int price = scanner.nextInt();
				System.out.print("�ɶ�(��/��/��)�G");
				int hour = scanner.nextInt();
				int minute = scanner.nextInt();
				int second = scanner.nextInt();
				CTime b1 = new CTime(hour, minute, second);
				accountBook.add(name,price,b1);
				System.out.println("�s�W���\!\n");
			}
		} while (true);
	}
}
