package ListTest;

public class AdvancedSearchList extends SearchList{
	public AdvancedSearchList(int n) {
		super(n);
	}
	//int search(int x);//�ϥ�binary search�i��j�M�A�����ƭȦ^�Ǧ�}�A�_�h�^��-1
	@Override public int search(int x) {
		int left = 0;
		int right = count - 1;
		while(left <= right) {
				int middle = (left + right)/2;
				if (x == list[middle])
					return middle;
				if (x < list[middle])
					right = middle - 1;
				else
					left = middle + 1;
		}
		return -1;
	}
	
	public int[] bubbleSort(int[]m) {
		for (int pass = 1; pass < count; pass++) {
			for (int i = 0; i < count - pass; i++) {
				if (m[i] > m [i+1]) {
					int temp = m[i];
					m[i] = m[i+1];
					m[i+1] = temp;
				}
			}
		}
		return m;
	}
	//bool remove(int index);//�������w��m���ȡA�ñN�ƦC�V�e����(�Ҧ��Ů沾�̫ܳ�)
	public boolean remove(int index) {
		int k = list.length;
					if (index < k-1) {
						for (int j = index; j < k-1; j++)
							list[j] = list[j+1];
						count--;
					}
					if (index == k-1) {	//last element
						list[index] = 0;
						count--;
					}
		return true;
	}
	
	//bool remove(int x, int num);//�����ƦC�����enum��x�ȡAnum�ǤJ-1�ɫh��������
	public boolean remove(int x, int num) {
		int k = count;
		int countNum = 0;
		if (num == -1) {
			for (int i = 0; i < k; i++) {
				list[i] = 0;
			}
			count = 0;
			return true;
		}
		else if (num >= 0) {
			for (int i = 0; i < k; i++) {
				while (list[i] == x && count > 0 && countNum < num) {
						if (i < k-1) {
							for (int j = i; j < k-1; j++)
								list[j] = list[j+1];
							list[k-1] = 0;
							countNum++;
							count--;
						}
						if (i == k-1) { //last element 
							list[i] = 0;
							countNum++;
							count--;
						}
				}
			}
			if (countNum == num)
				return true;
		}
		
		return false;	
	}
	
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.print(list[i] + " ");
		}
	}
}
