package MemberRegisterSystem;
import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class MemberRegister {
	public static MemberSystem memberSystem = new MemberSystem();
	public static Scanner sc = new Scanner (System.in);
	public static int count = 0;
	public static enum Status {
		MENU,
		DISPLAY,
		ADD,
		DELETE,
		MODIFY,
		FILTER,
		EXIT
	}
	
	public static void main(String[] args) throws IOException {
		Status option = Status.MENU;					//��檬�A
		String fileName;
		int input;
		System.out.print("���J����ɡG");
		fileName = sc.next();
		readFile(fileName);
		boolean run = true;
		
		while (run) {
			switch(option) {
			case MENU:
				System.out.print("�ﶵ�G1)�˵�����, 2)�s�W, 3)�R��, 4)�ק�, 5)�z��s��, -1) ����? ");
				try {
					input = sc.nextInt();
					if (input == 1)
						option = Status.DISPLAY;
					else if (input == 2)
						option = Status.ADD;
					else if (input == 3)
						option = Status.DELETE;
					else if (input == 4)
						option = Status.MODIFY;
					else if (input == 5)
						option = Status.FILTER;
					else if (input == -1)
						option = Status.EXIT;
					else
						System.out.println("��J���~!");
				}
				catch (Exception e) {
					sc.nextLine();
					System.out.println("�п�J�Ʀr!");
					continue;
				}
				
		
				break;
			case DISPLAY:
				showFile(fileName);
				option = Status.MENU;
				break;
			case ADD:
				addFile(fileName);
				System.out.println("�s�W���\!");
				option = Status.MENU;
				break;
			case DELETE:
				deleteFile(fileName);
				System.out.println("�R�����\!");
				option = Status.MENU;
				break;
			case MODIFY:
				modifyFile(fileName);
				System.out.println("�ק令�\!");
				option = Status.MENU;
				break;
			case FILTER:
				filterFile(fileName);
				System.out.println("�ɮ׼g�J���\�I");
				option = Status.MENU;
				break;
			case EXIT:
				writeFile(fileName);
				System.out.println("�g�J" + fileName + "���\�I");
				System.out.println("�{������");
				run = false;
				break;
			}
		}
	}
	
	
	public static void filterFile(String fileName) throws IOException {
		String name, str;
		int start, end, startIndex, endIndex;
		while (true) {
			System.out.print("��J�_�l�s��: ");
			start = sc.nextInt();
			
			if (start < memberSystem.getMember(0).getNo()) {
				startIndex = 0;
				break;
			}
			else if (start > memberSystem.getMember(memberSystem.getCount()-1).getNo() ){
				System.out.println("�_�l�s�����s�b!");
				continue;
			}
			else {
				if (memberSystem.findIndex(start) != -1) {
					startIndex = memberSystem.findIndex(start);
					break;
				}
				else {
					for (int i = 0; i < memberSystem.getCount(); i++) {
						if (start > memberSystem.getMember(i).getNo() && start < memberSystem.getMember(i+1).getNo()) {
							startIndex = i +1;
							break;
						}
					}
				}
			}
		}
		
		while (true) {
			System.out.print("��J�����s��: ");
			end = sc.nextInt();
			
			if (end > memberSystem.getMember(memberSystem.getCount()-1).getNo()) {
				endIndex = memberSystem.getCount()-1;
				break;
			}
			else if (end < memberSystem.getMember(0).getNo()){
				System.out.println("�����s�����s�b!");
				continue;
			}
			else {
				if (memberSystem.findIndex(end) != -1) {
					endIndex = memberSystem.findIndex(end);
					break;
				}
				else {
					for (int i = 0; i < memberSystem.getCount(); i++) {
						if (end > memberSystem.getMember(i).getNo() && end < memberSystem.getMember(i+1).getNo()) {
							endIndex = i;
							break;
						}
					}
				}
			}
		}
		
		
		System.out.print("��X����ɦW: ");
		name = sc.next();

		
		FileWriter fw = new FileWriter(name);
		str = "�s��\t�m�W\t������\t\t�ͤ�\t\t�q��\r\n";
		str += "===========================================================\r\n";
		for (int i = startIndex; i <= endIndex; i++) {
			str += memberSystem.getMember(i).toString();
		}
		fw.write(str);
		fw.flush();
		fw.close();
		
	}
 	public static void modifyFile(String fileName) throws IOException {
		String str;
		int no = findNo();
		System.out.print("�m�W�G");
		String name = sc.next();
		String id = checkid();
		MemberDate birth = checkBirth();
		String phone = checkPhone();
		str = memberSystem.modify(no,name,id,birth,phone);

	}
	public static void deleteFile(String fileName) throws IOException {
		String str;
		System.out.print("��J�s��(����0-100)�G");
		int no = findNo();
		memberSystem.delete(no);
		count--;
	}
	public static void writeFile (String fileName) throws IOException {
		String str;
		FileWriter fw = new FileWriter(fileName);
		str = "�s��\t�m�W\t������\t\t�ͤ�\t\t�q��\r\n";
		str += "===========================================================\r\n";
		fw.write(str);
		for (int i = 0; i < count; i++) {
			str = memberSystem.getMember(i).toString();
			fw.write(str);
			fw.flush();
		}
		fw.close();
	}
	public static void addFile(String fileName) throws IOException {
		String str;
		int no = checkNo();
		System.out.print("�m�W�G");
		String name = sc.next();
		String id = checkid();
		MemberDate birth = checkBirth();
		String phone = checkPhone();
		str = memberSystem.add(no,name,id,birth,phone);
		count++;
	}
	
	public static void readFile(String fileName) throws IOException,FileNotFoundException {
		try(FileReader fr = new FileReader(fileName))
		{	
			int no, year, month, day;
			BufferedReader bufferIn = new BufferedReader(fr);
			String str = bufferIn.readLine();
			str = bufferIn.readLine();		//�e��C��Ū�X�Ӫ����|�Q�л\
			while ((str = bufferIn.readLine()) != null) {
				String [] strArray = str.split("\t");
				
				try {
					no = Integer.parseInt(strArray[0]);
				}
				catch (Exception e) {
					break;
				}
				String name = strArray[1];
				String id = strArray[2];
				String[] birthArray = strArray[3].split("/");
				try {
					year = Integer.parseInt(birthArray[0]);
					month = Integer.parseInt(birthArray[1]);
					day = Integer.parseInt(birthArray[2]);
				}
				catch (Exception e) {
					break;
				}

				MemberDate birth = new MemberDate(year,month,day);
				String phone = strArray[4];
				str = memberSystem.add(no,name,id,birth,phone);
				count ++;
			}
		}
		catch (FileNotFoundException e) 
		{
			FileWriter fw = new FileWriter(fileName);
			String str = "�s��\t�m�W\t������\t\t�ͤ�\t\t�q��\r\n";
			str += "===========================================================\r\n";
			fw.write(str);
			fw.flush();
			fw.close();
		}
	}
	
	public static void showFile(String fileName) throws IOException {
//		char cbuf[] = new char[256];
//		FileReader fr = new FileReader(fileName);
//		BufferedReader bufferIn = new BufferedReader(fr);
		String str;
		int num;
//		String str1;
		str = "�s��\t�m�W\t������\t\t�ͤ�\t\t�q��\r\n";
		str += "===========================================================\r\n";
		System.out.print(str);
		for (int i = 0; i < count; i++) {
			str = memberSystem.getMember(i).toString();
			System.out.print(str);
		}
//		while((num = fr.read(cbuf)) != -1) {
//			str1 = new String(cbuf,0,num);
//			System.out.print(str1);
//		}
		System.out.println("");
//		fr.close();	//����
	}
	
	public static String checkid() {
		while (true) {
			System.out.print("�����ҡG");
			String id = sc.next();
			char idChar [] = id.toCharArray();
			//�ˬd�O�_���Q�X
			if (idChar.length != 10) {
				System.out.println("�����Ҹ��������Q�X!");
				continue;
			}
			//�ˬd�Ĥ@��O�_���^��Ʀr
			else if ( (int)idChar[0] > 90 || (int)idChar[0] < 65) {
				System.out.println("�Ĥ@�쥲�����j�g�^��Ʀr!");
				continue;
			}
			//�ˬd�ĤG��ĤQ��O�_���Ʀr
			for (int i = 1; i < 10; i++) {
				if ( (int)idChar[i] < 48 || (int)idChar[i] > 57) {
					System.out.println("�ĤG��ܲĤQ�쥲�������ԧB�Ʀr!");
					break;
				}
			}
			
			if (Character.getNumericValue(idChar[1]) != 1 && Character.getNumericValue(idChar[1]) != 2) {
				System.out.println("�ĤG�쥲����1��2���Ʀr!");
				continue;
			}
			
			int [] areaCode = {10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
			int code =  areaCode[(int)idChar[0] - 65];
			int y = 0, x = 0, z = 0;
			y = (code%10) *9 + (code/10);
			int count = 7;
			for (int i = 1; i < 9; i++) {
				x += (i+count) * Character.getNumericValue(idChar[i]);
				count -= 2;
			}
			z = 10 - (y + x)%10;
			
			if (Character.getNumericValue(idChar[9]) != z) {
				System.out.println("�ˬd�X���~!");
				continue;
			}
			
			return id;
		}
	}
	
	public static String checkPhone() {
		while (true) {
			String phone;
			System.out.print("�q�ܡG");
			phone = sc.next();
			char charPhone[] = phone.toCharArray();
			if (charPhone.length != 10) {
				System.out.println("�q�ܼƦr�������Q��!");
				continue;
			}
			if (Character.getNumericValue(charPhone[0]) != 0) {
				System.out.println("�ϽX�Ĥ@�춷��0!");
				continue;
			}
			return phone;
		}
	}
	
	public static MemberDate checkBirth() {
		
		while(true) {
			System.out.print("�ͤ�(�~/��/��)�G");
			int year = sc.nextInt();
			int month = sc.nextInt();
			int day = sc.nextInt();
			MemberDate b = new MemberDate(year,month,day);
			if (MemberDate.isValid(year, month, day)) {
				return b;
			}
			else {
				System.out.println("������~!");
				continue;
			}
		}
	}
	
	public static int checkNo() {
		while (true) {
			int no = 0 ;
			System.out.print("��J�s��(����0-100)�G");
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("�п�J0-100���Ʀr!");
			}
			if (no <0 || no >100) {
				System.out.println("���~�I�W�X�d��I");
				continue;
			}
			else if (memberSystem.findIndex(no) != -1) {
				System.out.println("���~�I�s�����ơI");
				continue;
			}
			return no;
				
		}
	}
	
	public static int findNo() {
		while (true) {
			int no = 0 ;
			System.out.print("��J�s��)�G");
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("�п�J�Ʀr!");
			}
			if (no <0 || no >100) {
				System.out.println("���~�I�W�X�d��I");
				continue;
			}
			else if (memberSystem.findIndex(no) == -1) {
				System.out.println("�s�����s�b�I");
				continue;
			}
			return no;
				
		}
	}
	
	
}
