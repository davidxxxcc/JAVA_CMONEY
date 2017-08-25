import java.util.Scanner;
import java.util.Arrays;

public class HW_008_Insertion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int status = 0, input = 0, count = 0;
		int arr[] = new int [1];
		
		while (true) {
			if (status == 0) {
				System.out.print("Option: 1) Add. 2) Insertion Sort. -1) Quit: ");
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
				System.out.print("Before sorting: ");
				for (int i = 0; i < count; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
				System.out.print("After sorting: ");
				arr = insertionSort(arr,count);
				for (int i = 0; i < count; i++) {
					System.out.print(arr[i] + " ");
				}
				break;
			}
		}
	}
	
	public static int []insertionSort (int a[], int n) {
		//base case
		if (n <= 1) return a;
		
		//recursive step
		a = insertionSort(a,n-1);
		int temp = a[n-1]; 
		int j = 0;
		for (j = n-1; j > 0; j-- ) {	//從第n-1個對第n-2個相比
			if (temp < a[j-1]) {
				a[j] = a[j-1];
			}
			else
				break;
		}
			a[j] = temp;
	
		
		
		return a;
	}
	
}
