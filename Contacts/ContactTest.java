package Contacts;
import java.util.Scanner;

public class ContactTest {
	public static Contacts accountBook = new Contacts();
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
				System.out.print("�m�W�G");
				String name = scanner.next();
				System.out.print("�~�֡G");
				int age = scanner.nextInt();
				System.out.print("�ͤ�(�~/��/��)�G");
				int year = scanner.nextInt();
				int month = scanner.nextInt();
				int day = scanner.nextInt();
				CDate b1 = new CDate(year, month, day);
				accountBook.add(name,age,b1);
				System.out.println("�s�W���\!\n");
			}
		} while (true);
	}
}

