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
		Status option = Status.MENU;					//選單狀態
		String fileName;
		int input;
		System.out.print("載入資料檔：");
		fileName = sc.next();
		readFile(fileName);
		boolean run = true;
		
		while (run) {
			switch(option) {
			case MENU:
				System.out.print("選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? ");
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
						System.out.println("輸入錯誤!");
				}
				catch (Exception e) {
					sc.nextLine();
					System.out.println("請輸入數字!");
					continue;
				}
				
		
				break;
			case DISPLAY:
				showFile(fileName);
				option = Status.MENU;
				break;
			case ADD:
				addFile(fileName);
				System.out.println("新增成功!");
				option = Status.MENU;
				break;
			case DELETE:
				deleteFile(fileName);
				System.out.println("刪除成功!");
				option = Status.MENU;
				break;
			case MODIFY:
				modifyFile(fileName);
				System.out.println("修改成功!");
				option = Status.MENU;
				break;
			case FILTER:
				filterFile(fileName);
				System.out.println("檔案寫入成功！");
				option = Status.MENU;
				break;
			case EXIT:
				writeFile(fileName);
				System.out.println("寫入" + fileName + "成功！");
				System.out.println("程式結束");
				run = false;
				break;
			}
		}
	}
	
	
	public static void filterFile(String fileName) throws IOException {
		String name, str;
		int start, end, startIndex, endIndex;
		while (true) {
			System.out.print("輸入起始編號: ");
			start = sc.nextInt();
			
			if (start < memberSystem.getMember(0).getNo()) {
				startIndex = 0;
				break;
			}
			else if (start > memberSystem.getMember(memberSystem.getCount()-1).getNo() ){
				System.out.println("起始編號不存在!");
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
			System.out.print("輸入結束編號: ");
			end = sc.nextInt();
			
			if (end > memberSystem.getMember(memberSystem.getCount()-1).getNo()) {
				endIndex = memberSystem.getCount()-1;
				break;
			}
			else if (end < memberSystem.getMember(0).getNo()){
				System.out.println("結束編號不存在!");
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
		
		
		System.out.print("輸出資料檔名: ");
		name = sc.next();

		
		FileWriter fw = new FileWriter(name);
		str = "編號\t姓名\t身分證\t\t生日\t\t電話\r\n";
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
		System.out.print("姓名：");
		String name = sc.next();
		String id = checkid();
		MemberDate birth = checkBirth();
		String phone = checkPhone();
		str = memberSystem.modify(no,name,id,birth,phone);

	}
	public static void deleteFile(String fileName) throws IOException {
		String str;
		System.out.print("輸入編號(介於0-100)：");
		int no = findNo();
		memberSystem.delete(no);
		count--;
	}
	public static void writeFile (String fileName) throws IOException {
		String str;
		FileWriter fw = new FileWriter(fileName);
		str = "編號\t姓名\t身分證\t\t生日\t\t電話\r\n";
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
		System.out.print("姓名：");
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
			str = bufferIn.readLine();		//前兩列的讀出來的文串會被覆蓋
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
			String str = "編號\t姓名\t身分證\t\t生日\t\t電話\r\n";
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
		str = "編號\t姓名\t身分證\t\t生日\t\t電話\r\n";
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
//		fr.close();	//關檔
	}
	
	public static String checkid() {
		while (true) {
			System.out.print("身分證：");
			String id = sc.next();
			char idChar [] = id.toCharArray();
			//檢查是否為十碼
			if (idChar.length != 10) {
				System.out.println("身分證號必須為十碼!");
				continue;
			}
			//檢查第一位是否為英文數字
			else if ( (int)idChar[0] > 90 || (int)idChar[0] < 65) {
				System.out.println("第一位必須為大寫英文數字!");
				continue;
			}
			//檢查第二到第十位是否為數字
			for (int i = 1; i < 10; i++) {
				if ( (int)idChar[i] < 48 || (int)idChar[i] > 57) {
					System.out.println("第二位至第十位必須為阿拉伯數字!");
					break;
				}
			}
			
			if (Character.getNumericValue(idChar[1]) != 1 && Character.getNumericValue(idChar[1]) != 2) {
				System.out.println("第二位必須為1或2的數字!");
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
				System.out.println("檢查碼錯誤!");
				continue;
			}
			
			return id;
		}
	}
	
	public static String checkPhone() {
		while (true) {
			String phone;
			System.out.print("電話：");
			phone = sc.next();
			char charPhone[] = phone.toCharArray();
			if (charPhone.length != 10) {
				System.out.println("電話數字必須為十位!");
				continue;
			}
			if (Character.getNumericValue(charPhone[0]) != 0) {
				System.out.println("區碼第一位須為0!");
				continue;
			}
			return phone;
		}
	}
	
	public static MemberDate checkBirth() {
		
		while(true) {
			System.out.print("生日(年/月/日)：");
			int year = sc.nextInt();
			int month = sc.nextInt();
			int day = sc.nextInt();
			MemberDate b = new MemberDate(year,month,day);
			if (MemberDate.isValid(year, month, day)) {
				return b;
			}
			else {
				System.out.println("日期錯誤!");
				continue;
			}
		}
	}
	
	public static int checkNo() {
		while (true) {
			int no = 0 ;
			System.out.print("輸入編號(介於0-100)：");
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("請輸入0-100的數字!");
			}
			if (no <0 || no >100) {
				System.out.println("錯誤！超出範圍！");
				continue;
			}
			else if (memberSystem.findIndex(no) != -1) {
				System.out.println("錯誤！編號重複！");
				continue;
			}
			return no;
				
		}
	}
	
	public static int findNo() {
		while (true) {
			int no = 0 ;
			System.out.print("輸入編號)：");
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("請輸入數字!");
			}
			if (no <0 || no >100) {
				System.out.println("錯誤！超出範圍！");
				continue;
			}
			else if (memberSystem.findIndex(no) == -1) {
				System.out.println("編號不存在！");
				continue;
			}
			return no;
				
		}
	}
	
	
}
