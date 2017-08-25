import java.util.Scanner;
import java.util.Arrays;

public class HW_008_LinearSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int status = 0, input = 0, count = 0;
		int arr[] = new int [1];
		
		while (true) {
			if (status == 0) {
				System.out.print("Option: 1) Add. 2) Search. -1) Quit: ");
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
				System.out.print("Key: ");
				int key = sc.nextInt();
				int index = LinearSearch(arr,key,count);
				if (index == -1) {
					System.out.println( key + " is not found!");
				} else {
					System.out.println( key + " is found!");
				}
				break;
			}
		}
	}
	
	public static int LinearSearch (int a[], int key, int n) {
		//base case
		if (n <= 1) {			
			if (a[0] == key)
				return 0;
			return -1;
		}
		
		//recursive step
		int found = LinearSearch(a,key,n-1);
		if (found == -1) {
			if (a[n-1] == key)
				return n-1;
			return -1;
		}	
		return found;
	}
}
