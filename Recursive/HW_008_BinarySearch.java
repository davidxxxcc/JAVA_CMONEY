import java.util.Scanner;
import java.util.Arrays;

public class HW_008_BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int status = 0, input = 0, count = 0;
		int arr[] = new int [1];
		
		while (true) {
			if (status == 0) {
				System.out.print("Option: 1) Add. 2) Binray Search. -1) Quit: ");
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
				arr = bubbleSort(arr,count-1);
				int index = binarySearch(arr,key,0,count-1);
				if (index == 0) {
					System.out.println( key + " is not found!");
				} else {
					System.out.println( key + " is found!");
				}
				status = 0;
			}
		}
	}
	
	public static int binarySearch (int a[], int key, int start,int end) {
		//base case
		if (start >= end) {
			if (a[start] == key)
				return 1;
			return 0;
		}
		//recursive step
		int middle = (start + end)/2;
		if (key == a[middle]) {
			return 1;
		}
		if (key > a[middle]) {
			start = middle + 1;
			return binarySearch(a,key,start,end);
		}
		else {
			end = middle - 1;
			return binarySearch(a,key,start,end);
		} 
	}
	
	//buuble Sort
	public static int []bubbleSort (int x[],int n) {
        for (int pass = 1; pass < n; pass++)     //氣泡排序法 
        {
        	for(int i = 0; i < n - pass; i++)
        	{
        		if (x[i] > x[i+1]) {    //後面的比較大
        			int temp = x[i];        //交換
        			x[i] = x[i+1]; 
        			x[i+1] = temp;
        		}
        	}
        }
        return x;

	}
	
}
