package ListTest;


//int search(int x){}//�Y�ƦC�������ƭȦ^�Ǧ�}�A�_�h�^��-1
public class SearchList extends List{

	public SearchList(int n) {
		super(n);
	}
	public int search(int x) {
		for (int i = 0; i < count; i++) {
			if (list[i] == x)
				return i;
		}
		return -1;
	}
	
//int findMax(){}//�^�ǼƦC�����̤j��
	public int findMax() {
		int max = 0;
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				max = list[i];
			}
			else {
				if (list[i] > max)
					max = list[i];
			}
		}
		return max;
	}
//bool replace(int x, int y){}//�N�ƦC�����Ҧ�x�ƭȴ�����y�ƭ�	
	public boolean replace(int x, int y) {
		boolean find = false;
		for (int i = 0; i < count; i++) {
			if (list[i] == x) {
				list[i] = y;
				find = true;
			}

		}
		return find;
	}
	

}
