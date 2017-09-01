package Accounting;
import java.util.Scanner;

public class AccountingTest {
	public static Accounting accountBook = new Accounting();
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
				System.out.print("品名：");
				String name = scanner.next();
				System.out.print("價格：");
				int price = scanner.nextInt();
				System.out.print("時間(時/分/秒)：");
				int hour = scanner.nextInt();
				int minute = scanner.nextInt();
				int second = scanner.nextInt();
				CTime b1 = new CTime(hour, minute, second);
				accountBook.add(name,price,b1);
				System.out.println("新增成功!\n");
			}
		} while (true);
	}
}
