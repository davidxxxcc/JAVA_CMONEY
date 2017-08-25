import java.util.Scanner;

public class HW_008_TestPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		int input = 0;
		String text;
		char[] ch = new char [1];
		while(true) {

			if (option == 0) {
				System.out.print("Option: 1) Test Palindrome. -1) Quit: ");
				input = sc.nextInt();
				if (input == 1)
					option = 1;
			}
			
			if (option == 1) {
				System.out.print("Input a string: ");
				text = sc.nextLine();
				text = sc.nextLine();
				text = text.replaceAll(" ","");
				ch = text.toCharArray();
				option = 2;
			}
			
			if (option == 2) {
				int result = TestPalindrome(ch,0,ch.length-1);
				if (result == 1) {
					System.out.println("The input string is a palindrome.");
				} else {
					System.out.println("The input string is not a palindrome.");
				}
				option = 0;
			}
		}

	}
	
	public static int TestPalindrome (char a[], int leftEnd, int rightEnd) {
		//base case
		int sum = leftEnd+rightEnd;

			if ((leftEnd + 1 == sum/2) && (sum % 2 == 0)) {
				if (a[leftEnd] == a[rightEnd])
					return 1;
				return 0;
			}
				

			if ( (sum % 2 != 0) && (leftEnd == sum/2)) {
				if (a[leftEnd] == a[rightEnd])
					return 1;
				return 0;
			}
			
		//recursive step
		int found = TestPalindrome(a,leftEnd + 1,rightEnd - 1);
		if (found == 1) {
			if (a[leftEnd+1] == a[rightEnd-1])
				return 1;
			return 0;
		}
		return found;
	}
}
