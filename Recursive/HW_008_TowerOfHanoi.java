import java.util.Scanner;

public class HW_008_TowerOfHanoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the number of plates: ");
		int input = sc.nextInt();
		towersOfHanoi(input,1,3,2);
	}
	
	/*
	 參數代表要從柱子from移動編號no的盤子到柱子to去，同時以柱子temp作為中介
	只要有移動一個盤子，請印出以下訊息：
	Move 盤子編號 from 來源柱子編號 to 來源柱子編號
	請撰寫一個主函式要求使用者輸入一個數字n代表一開始要移動的盤子總數，並呼叫towersOfHanoi來印出搬移的過程。
	 */
	public static void towersOfHanoi(int no, int from, int to, int temp) {
		//base case
		if (no <= 1) {
			System.out.println("Move " + no +  " from " + from +  " to " + to);	
			return;
		}
		
		//那麼先把A塔頂部的N-1塊盤移動到B塔
		towersOfHanoi(no-1, from , temp , to);
			
		//再把A塔剩下的大盤移到C
		System.out.println("Move " + no +  " from " + from +  " to " + to);
		
		//最後把B塔的N-1塊盤移到C
		towersOfHanoi(no-1, temp , to , from);
	}
}
