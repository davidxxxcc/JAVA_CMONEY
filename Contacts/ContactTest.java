package Contacts;
import java.util.Scanner;

public class ContactTest {
	public static Contacts accountBook = new Contacts();
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int option = -1;
		do {
			System.out.print("選項：1)新增,2)印出全部,-1)結束：");
			option = scanner.nextInt();
			if (option != -1 && option != 1 && option != 2) {
				System.out.print("Error!");
			}
			else if (option == -1) {
				System.out.println("感謝您的使用!");
				break;
			}
			else if (option == 2) {
				accountBook.print();
			}
			else if (option == 1) {
				System.out.print("姓名：");
				String name = scanner.next();
				System.out.print("年齡：");
				int age = scanner.nextInt();
				System.out.print("生日(年/月/日)：");
				int year = scanner.nextInt();
				int month = scanner.nextInt();
				int day = scanner.nextInt();
				CDate b1 = new CDate(year, month, day);
				accountBook.add(name,age,b1);
				System.out.println("新增成功!\n");
			}
		} while (true);
	}
}

