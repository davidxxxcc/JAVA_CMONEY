package ListTest;

import java.util.Arrays;

public class List {
	protected int[] list;
	protected int count;
	
	//Initialize constructor
	public List(int n) {
		SetData(n);
		
	}
	
	//Define the variable n for array length
	public void SetData(int n) {
		count = 0;
		if (n < 10)
			list = new int [10];
		else 
			list = new int [n];
	}
	
	//Add a integer x to the first none input element list[] and return boolean value
	public boolean add(int x) {
		if (count >= list.length)
			list = Arrays.copyOf(list,list.length*2);
		list[count++] = x;
		return true;
	}
	
	//Remove all of the integer x in list[] and return boolean value
	public boolean remove(int x) {
		int k = count;
		for(int i = 0; i < k; i++) {
				while(list[i] == x) {
					if (i < k-1) {
						for (int j = i; j < k-1; j++)
							list[j] = list[j+1];
						list[k-1] = 0;
					}
					if (i == k-1)	//last element
						list[i] = 0;
				}
		}
		return true;
	}

}
