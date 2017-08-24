package StorageSystem;
import java.util.Scanner;
public class StorageSystemTest {
	public static Scanner sc = new Scanner(System.in);
	public static Storage dataBase [] = new Storage[3] ;		//�s�WStorage���O������
	public static void main(String[] args) {
		//��l��Storage���O������}�CdataBase
		for (int i = 0; i < dataBase.length; i++) {
			dataBase[i] = new Storage();
		}
		boolean run = true;
		int option = 0, shop = 0;
		System.out.println("�w��i�J8-12�s��W�ӡu���x�޲z�t�Ρv�]StorageSystem�^");

		while (run) {
			if (option == 0) {
				shop = chooseShop();

				option = 1;
			}
			if (option == 1) {
				String suit [] = new String [] {"�@","�G","�T"};
				System.out.printf("%1s����T\n",suit[shop]);
				System.out.print("1)��ܩҦ����  2)�W�[�ӫ~���  3)�X�f�n��  4)�i�f�n��   5)�W�@�B");
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
					System.out.println("��J���~!");
				}
			}
			//��ܩҦ����
			if (option == 2) {
				System.out.printf("%10s\t%12s\t%5s\t%5s\t%5s\t%5s\n","Product No","Product Name","Price","Unit","Stock","Maker");
				dataBase[shop].print();
				System.out.println("");
				option = 1;
				continue;
			}
			//�W�[�ӫ~���
			if (option == 3) {
				System.out.println("�s�W�ӫ~����");
				addProduct(shop);
				System.out.println("�ӫ~�s�W����!");
				option = 1;
				continue;
			}
			//�X�f�n��
			if (option == 4) {
				System.out.println("�X�f�n������");
				System.out.printf("%10s\t%12s\t%5s\t%5s\t%5s\t%5s\n","Product No","Product Name","Price","Unit","Stock","Maker");
				dataBase[shop].print();
				System.out.println("");
				exportProduct(shop);
				System.out.println("�ӫ~�X�f�n������!");
				option = 1;
				continue;
			}
			//�i�f�n��
			if (option == 5) {
				System.out.println("�i�f�n������");
				System.out.printf("%10s\t%12s\t%5s\t%5s\t%5s\t%5s\n","Product No","Product Name","Price","Unit","Stock","Maker");
				dataBase[shop].print();
				System.out.println("");
				importProdcut(shop);
				System.out.println("�ӫ~�i�f�n������!");
				option = 1;
				continue;
			}
			
		}

	}
	
	
	
	
	
	/*
	 ���]�y�z�ӫ~�]Product�^���ݩʬ��G�ӫ~�s���]Product No.�A�r��^�B�ӫ~�W�١]Product Name�A�r��^�B����]Price�A��ơ^�B���]Unit�A�r��^�B�w�s�q�]Stock�A��ơ^�P�s�y�ӡ]Maker�A�r��^
	 */
	public static int chooseShop() {
		
		while (true) {
			System.out.print("�п�ܤ��� 	1)�@�� 	2)�G��	3)�T��	:");
			int input = sc.nextInt();
			if (input == 1)
				return 0;
			if (input == 2)
				return 1;
			if (input == 3)
				return 2;
			else
				System.out.println("��J���~!");
		}

	}
	public static void addProduct(int shop) {
	//	String suit [] = new String [] {"�@","�G","�T"};
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
			//	System.out.printf("%1s����T\n",suit[shop]);
				System.out.print("�п�J�ӫ~�s��(001-099): ");
				no = sc.next();
				int afterConvert = 0;
				try{
				   afterConvert = Integer.parseInt(no);
				}catch(NumberFormatException e){
				   afterConvert = 0;
				}
				if (afterConvert <= 0 || afterConvert > 99) {
					System.out.println("��J���~!");
					continue;
				}
				System.out.print("�п�J�ӫ~�W��: ");
				name = sc.next();
				option = 1;
				break;
			case 1:
				System.out.print("�п�J�ӫ~���: ");
				price = sc.nextInt();
				if (price < 0 || price > 2147483647) {
					System.out.println("��J���~!");
					continue;
				}
				option = 2;
				break;
			case 2:
				System.out.print("�п�J���: ");
				unit = sc.next();
				option = 3;
				break;
			case 3:
				System.out.print("�п�J�w�s�q: ");
				stock = sc.nextInt();
				if (stock < 0 || stock > 2147483647) {
					System.out.println("��J���~!");
					continue;
				}
				option = 4;
				break;
			case 4:
				System.out.print("�п�J�s�y��: ");
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
				System.out.print("�п�J�ӫ~�s��: ");
				no = sc.next();	
				int afterConvert = 0;
				try{
				   afterConvert = Integer.parseInt(no);
				}catch(NumberFormatException e){
				   afterConvert = 0;
				}
				if (afterConvert == 0 || dataBase[shop].findProduct(no) == -1) {
					System.out.println("��J���~!");
					continue;
				}
				option = 1;
			}
			if (option == 1) {
				System.out.print("�п�J�X�f�ƶq: ");
				num = sc.nextInt();
				if (num > dataBase[shop].findStock(no)) {
					System.out.println("�w�s����!");
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
				System.out.print("�п�J�ӫ~�s��: ");
				no = sc.next();	
				int afterConvert = 0;
				try{
				   afterConvert = Integer.parseInt(no);
				}catch(NumberFormatException e){
				   afterConvert = 0;
				}
				if (afterConvert == 0 || dataBase[shop].findProduct(no) == -1) {
					System.out.println("��J���~!");
					continue;
				}
				option = 1;
			}
			if (option == 1) {
				System.out.print("�п�J�i�f�ƶq: ");
				num = sc.nextInt();
			}
			break;
		} while (true);
		dataBase[shop].importProduct(no, num);
	}

}
