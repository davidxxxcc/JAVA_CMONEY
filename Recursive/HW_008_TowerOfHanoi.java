import java.util.Scanner;

public class HW_008_TowerOfHanoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the number of plates: ");
		int input = sc.nextInt();
		towersOfHanoi(input,1,3,2);
	}
	
	/*
	 �ѼƥN��n�q�W�lfrom���ʽs��no���L�l��W�lto�h�A�P�ɥH�W�ltemp�@������
	�u�n�����ʤ@�ӽL�l�A�ЦL�X�H�U�T���G
	Move �L�l�s�� from �ӷ��W�l�s�� to �ӷ��W�l�s��
	�м��g�@�ӥD�禡�n�D�ϥΪ̿�J�@�ӼƦrn�N��@�}�l�n���ʪ��L�l�`�ơA�éI�stowersOfHanoi�ӦL�X�h�����L�{�C
	 */
	public static void towersOfHanoi(int no, int from, int to, int temp) {
		//base case
		if (no <= 1) {
			System.out.println("Move " + no +  " from " + from +  " to " + to);	
			return;
		}
		
		//�������A�𳻳���N-1���L���ʨ�B��
		towersOfHanoi(no-1, from , temp , to);
			
		//�A��A��ѤU���j�L����C
		System.out.println("Move " + no +  " from " + from +  " to " + to);
		
		//�̫��B��N-1���L����C
		towersOfHanoi(no-1, temp , to , from);
	}
}
