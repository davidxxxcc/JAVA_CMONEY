package ListTest;


//int search(int x){}//璝计いΤ计肚玥肚-1
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
	
//int findMax(){}//肚计い程
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
//bool replace(int x, int y){}//盢计い┮Τx计蠢传y计	
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
