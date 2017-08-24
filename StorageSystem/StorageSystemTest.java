package StorageSystem;
import java.util.Scanner;
public class StorageSystemTest {
	public static Scanner sc = new Scanner(System.in);
	public static Storage dataBase [] = new Storage[3] ;		//新增Storage類別的物件
	public static void main(String[] args) {
		//初始化Storage類別的物件陣列dataBase
		for (int i = 0; i < dataBase.length; i++) {
			dataBase[i] = new Storage();
		}
		boolean run = true;
		int option = 0, shop = 0;
		System.out.println("歡迎進入8-12連鎖超商「倉儲管理系統」（StorageSystem）");

		while (run) {
			if (option == 0) {
				shop = chooseShop();

				option = 1;
			}
			if (option == 1) {
				String suit [] = new String [] {"一","二","三"};
				System.out.printf("%1s店資訊\n",suit[shop]);
				System.out.print("1)顯示所有資料  2)增加商品資料  3)出貨登錄  4)進貨登錄   5)上一步");
				int input = sc.nextInt();
				switch (input) {
				case 1:
					option = 2;
					break;
				case 2:
					option = 3;
					break;
				case 3:
					option = 4;
					break;
				case 4:
					option = 5;
					break;
				case 5:
					option = 0;
					break;
				default:
					System.out.println("輸入錯誤!");
				}
			}
			//顯示所有資料
			if (option == 2) {
				System.out.printf("%10s\t%12s\t%5s\t%5s\t%5s\t%5s\n","Product No","Product Name","Price","Unit","Stock","Maker");
				dataBase[shop].print();
				System.out.println("");
				option = 1;
				continue;
			}
			//增加商品資料
			if (option == 3) {
				System.out.println("新增商品頁面");
				addProduct(shop);
				System.out.println("商品新增完成!");
				option = 1;
				continue;
			}
			//出貨登錄
			if (option == 4) {
				System.out.println("出貨登錄頁面");
				System.out.printf("%10s\t%12s\t%5s\t%5s\t%5s\t%5s\n","Product No","Product Name","Price","Unit","Stock","Maker");
				dataBase[shop].print();
				System.out.println("");
				exportProduct(shop);
				System.out.println("商品出貨登錄完成!");
				option = 1;
				continue;
			}
			//進貨登錄
			if (option == 5) {
				System.out.println("進貨登錄頁面");
				System.out.printf("%10s\t%12s\t%5s\t%5s\t%5s\t%5s\n","Product No","Product Name","Price","Unit","Stock","Maker");
				dataBase[shop].print();
				System.out.println("");
				importProdcut(shop);
				System.out.println("商品進貨登錄完成!");
				option = 1;
				continue;
			}
			
		}

	}
	
	
	
	
	
	/*
	 假設描述商品（Product）的屬性為：商品編號（Product No.，字串）、商品名稱（Product Name，字串）、單價（Price，整數）、單位（Unit，字串）、庫存量（Stock，整數）與製造商（Maker，字串）
	 */
	public static int chooseShop() {
		
		while (true) {
			System.out.print("請選擇分店 	1)一店 	2)二店	3)三店	:");
			int input = sc.nextInt();
			if (input == 1)
				return 0;
			if (input == 2)
				return 1;
			if (input == 3)
				return 2;
			else
				System.out.println("輸入錯誤!");
		}

	}
	public static void addProduct(int shop) {
	//	String suit [] = new String [] {"一","二","三"};
		boolean run = true;
		String no ="";
		String name ="";
		int price = 0;
		String unit ="" ;
		int stock = 0;
		String maker ="";
		int option = 0;
		while (run) {
			
			switch(option) {
			case 0:
			//	System.out.printf("%1s店資訊\n",suit[shop]);
				System.out.print("請輸入商品編號(001-099): ");
				no = sc.next();
				int afterConvert = 0;
				try{
				   afterConvert = Integer.parseInt(no);
				}catch(NumberFormatException e){
				   afterConvert = 0;
				}
				if (afterConvert <= 0 || afterConvert > 99) {
					System.out.println("輸入錯誤!");
					continue;
				}
				System.out.print("請輸入商品名稱: ");
				name = sc.next();
				option = 1;
				break;
			case 1:
				System.out.print("請輸入商品單價: ");
				price = sc.nextInt();
				if (price < 0 || price > 2147483647) {
					System.out.println("輸入錯誤!");
					continue;
				}
				option = 2;
				break;
			case 2:
				System.out.print("請輸入單位: ");
				unit = sc.next();
				option = 3;
				break;
			case 3:
				System.out.print("請輸入庫存量: ");
				stock = sc.nextInt();
				if (stock < 0 || stock > 2147483647) {
					System.out.println("輸入錯誤!");
					continue;
				}
				option = 4;
				break;
			case 4:
				System.out.print("請輸入製造商: ");
				maker = sc.next();
				run = false;
				break;
			}
		}
		dataBase[shop].add(no,name,price,unit,stock,maker);	
	}
	
	public static void exportProduct(int shop) {
		int option = 0,num = 0;
		String no = ("");
		do {
			if (option == 0) {
				System.out.print("請輸入商品編號: ");
				no = sc.next();	
				int afterConvert = 0;
				try{
				   afterConvert = Integer.parseInt(no);
				}catch(NumberFormatException e){
				   afterConvert = 0;
				}
				if (afterConvert == 0 || dataBase[shop].findProduct(no) == -1) {
					System.out.println("輸入錯誤!");
					continue;
				}
				option = 1;
			}
			if (option == 1) {
				System.out.print("請輸入出口數量: ");
				num = sc.nextInt();
				if (num > dataBase[shop].findStock(no)) {
					System.out.println("庫存不足!");
					continue;
				}
			}
			break;
		} while (true);
		dataBase[shop].exportProdcut(no, num);

	}
	
	public static void importProdcut(int shop) {
		int option = 0,num = 0;
		String no = ("");
		do {
			if (option == 0) {
				System.out.print("請輸入商品編號: ");
				no = sc.next();	
				int afterConvert = 0;
				try{
				   afterConvert = Integer.parseInt(no);
				}catch(NumberFormatException e){
				   afterConvert = 0;
				}
				if (afterConvert == 0 || dataBase[shop].findProduct(no) == -1) {
					System.out.println("輸入錯誤!");
					continue;
				}
				option = 1;
			}
			if (option == 1) {
				System.out.print("請輸入進口數量: ");
				num = sc.nextInt();
			}
			break;
		} while (true);
		dataBase[shop].importProduct(no, num);
	}

}
