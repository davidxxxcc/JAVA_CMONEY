package TimeTableSystem;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;

public class TimeTableTest {
	
	private static Scanner sc = new Scanner(System.in);
	public static CItem [] item = new CItem[50];
	public static int count = 0;
	public static void main(String[] args) 
			throws FileNotFoundException,IOException
	{
		String str;
		System.out.print("���J����ɡG");
		String fileName = sc.next();
		FileReader fr = new FileReader(fileName);
		BufferedReader bufferIn = new BufferedReader(fr);
		String title = bufferIn.readLine();
		
		
		while((str = bufferIn.readLine())!= null) {
			String [] strArr = str.split(",");
			String [] info = Arrays.copyOfRange(strArr,0,5);
			String [] info2 = Arrays.copyOfRange(strArr,5,8);
			String [] days = Arrays.copyOfRange(strArr,8,15);
			addItem(info,info2,days);
		}
		fr.close();
		
		while(true) {
			System.out.print("�ﶵ�G1)�˵��Ҧ����u���, 2)�s�W���u, 3)�˵����w���u��T, 4)�R�����u, 5)�g�J�ɮ�, -1) �����G ");
			int input = sc.nextInt();
			
			if (input == 1) {
				System.out.println(title);
				for (int i = 0; i < count; i++) {
					System.out.println(item[i].toString());
				}
			}
			
			else if (input == 2) {
				String [] inputS = new String[15];
				System.out.print("�п�J�ȹB�~��: ");
				inputS[0] = sc.next();
				System.out.print("�п�J���u�s��: ");
				inputS[1] = sc.next();
				System.out.print("�п�J��u: ");
				inputS[2] = sc.next();
				System.out.print("�п�J����: ");
				inputS[3] = sc.next();
				System.out.print("�п�J���u�W��: ");
				inputS[4] = sc.next();
				System.out.print("�п�J���W: ");
				inputS[5] = sc.next();
				System.out.print("�п�J�Z����: ");
				inputS[6] = sc.next();
				System.out.print("�п�J�o���ɶ�: ");
				inputS[7] = sc.next();
				System.out.print("�п�J�@���O�_�o��  0)�_ 1)�O: ");
				inputS[8] = sc.next();
				inputS[9] = sc.next();
				inputS[10] = sc.next();
				inputS[11] = sc.next();
				inputS[12] = sc.next();
				inputS[13] = sc.next();
				inputS[14] = sc.next();
				String [] info = Arrays.copyOfRange(inputS,0,5);
				String [] info2 = Arrays.copyOfRange(inputS,5,8);
				String [] days = Arrays.copyOfRange(inputS,8,15);
				addItem(info,info2,days);
				System.out.println(title);
				for (int i = 0; i < count; i++) {
					System.out.println(item[i].toString());
				}
			}
			
			
			else if (input == 3) {
				System.out.println("��ܸ��u�s��");
				System.out.print("�п�J���u�s��: ");
				String mainLine = sc.next();
				System.out.print("�п�J��u: ");
				String subLine = sc.next();
				System.out.println(title);
				for (int i = 0; i < count; i++) {
					if ((mainLine.compareTo(item[i].getMainLine()) == 0) && (subLine.compareTo(item[i].getSubLine()) == 0)){
						for (int j = 0; j < item[i].getItemCount();j++) {
							String strItem = item[i].toString();
							String strStop = item[i].getStop(j).toString();
							System.out.println(strItem + "," + strStop);
						}
					}
				}
			}
			
			else if (input == 4) {
				System.out.println("�R�����u�s��");
				System.out.print("�п�J���u�s��: ");
				String mainLine = sc.next();
				System.out.print("�п�J��u: ");
				String subLine = sc.next();
				int check = 1;
				while(check > 0) {
					check = 0;
					for (int i = 0; i < count; i++) {
						if ((mainLine.compareTo(item[i].getMainLine()) == 0) && (subLine.compareTo(item[i].getSubLine()) == 0)){
							if (count == 1) {
								item[i] = null;
							}
							else {
								for (int j = i; j < count-1; j++) {
									item[j] = item[j + 1];
								}
								item[count-1] = null;
							}
							count--;
							check++;
						}
					}
				}

				
				System.out.println("�R�����u" + mainLine + " ��u" + subLine);
			}
			
			else if (input == 5) {
				System.out.print("�п�J����X���ɦW�P�榡");
				String fileOutput = sc.next();
				FileWriter fw = new FileWriter(fileOutput);
				BufferedWriter buffOut = new BufferedWriter(fw,100);
				fw.write(title);
				buffOut.newLine();
				
				for (int i = 0; i < count; i++) {
					String output = "";
					for (int j = 0; j < item[i].getItemCount(); j++) {
						output = item[i].toString() + "," + item[i].getStop(j).toString();
						buffOut.write(output);
						buffOut.newLine();
					}
					buffOut.flush();
				}
				fw.close();
				System.out.println("�ɮ�"+ fileOutput+"��X���\!");
			}
			
			else if (input == -1) {
				break;
			}
		}
		

	}
	
	public static int[] findItem(String mainLine, String subLine) {
		String str [] = {mainLine, subLine};
		int getIndex[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int itemCount = 0;
		for (int i = 0; i < count; i++) {
			if (compareString(str,item[i].getMainLineSubLine())) {
				if (itemCount >= getIndex.length)
					getIndex = Arrays.copyOf(getIndex, getIndex.length*2);
				getIndex[itemCount++] = i;
			}	
		}
		return getIndex;
	}
	
	public static void addItem(String[] info, String[] info2, String[] days) {
		int getIndex = -1;
		for (int i = 0; i < count; i++) {
			if (compareString(item[i].getInfo(), info) == true) {
				getIndex = i;
				break;
			}
		}
		
		if (getIndex == -1) {
			if (count >= item.length)
				item = Arrays.copyOf(item, item.length*2);
			item[count] = new CItem (info);
			item[count++].addStop(info2, days);
		}
		else if (getIndex != -1) {
			item[getIndex].addStop(info2, days);
		}
	}
	
	// return true if two strings are the same
	public static boolean compareString(String[] a, String[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].compareTo(b[i]) != 0)
				return false;
		}
		return true;
	}

}
