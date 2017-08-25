import java.util.Scanner;
import java.util.Arrays;

public class HW_008_Minimum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int status = 0, input = 0, count = 0;
		int arr[] = new int [1];
		
		while (true) {
			if (status == 0) {
				System.out.print("Option: 1) Add. 2) Minimum. -1) Quit: ");
				input = sc.nextInt();
				if (input == 1) status = 1;
				if (input == 2) status = 2;
				if (input == -1) break;
			}
			if (status == 1) {
				if (count >= arr.length)
					arr = Arrays.copyOf(arr, arr.length*2);
				System.out.print("Insert grade (-1 to end): ");
				int x = sc.nextInt();
				if(x == -1) {
					status = 0;
				}
				else if (x <0) {
					System.out.println("Input error!");
				}
				else {
					arr[count] = x;
					count++;
				}				
			}
			
			if (status == 2) {
				int min = RecursiveMinimum(arr,count);
				System.out.println("Minimum: " + min);
				break;
			}
		}

	}
	
	public static int RecursiveMinimum (int a[], int n) {
		if (n == 1) return a[0];		//base case
		
		int min = RecursiveMinimum(a,n-1);
		if (min < a[n-1])
			return min;
		return a[n-1];
	}

}
