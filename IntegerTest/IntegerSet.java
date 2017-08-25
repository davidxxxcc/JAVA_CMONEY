package IntegerTest;

public class IntegerSet {
	
	private int [] element;	//儲存數字的陣列；最小長度為10
	private int count = 0;	//目前陣列內的數字個數
	private int size = 0;	//陣列大小
	//建構子,空的元素定義為-1
	public IntegerSet() {					
		size = 10;
		this.element = new int [size];
		for (int i = 0; i < size; i++)
			element[i] = -1;
	}
	//建構子；引數代表集合可儲存最大容量
	public IntegerSet(int s) {			
		this();
		if (s > 10) {
			this.element = new int [s];
		for (int i = 0; i < s; i++)
			element[i] = -1;
		}
	}
	
	
	//新增新的元素value（重複的元素不加入
	public void Insert(int value) {
		if (this.search(value) == -1) {
			if (size <= count)
				this.resize(size*2);
			element[count++]= value;
		}
	}
	
	//抓取編號為i的整數，如果索引超出範圍，請回傳-1
	public int getElement(int i) {
		if (i >= count)
			return -1;
		return element[i];
	}	
	//印出集合中所有元素的內容
	public void output() {
		for (int i = 0; i < count; i++) {
			if (i < count -1)
				System.out.printf("%2d, ", element[i]);
			else if ((i < count))
				System.out.printf("%2d", element[i]);
		}
		System.out.println("");
	}	
	//搜尋value是否在集合中。有則回傳其index，否則回傳-1
	public int search(int value) {
		for (int i = 0; i < count; i++) {
			if (element[i] == value)
				return i;
		}
		return -1;
	}  
	//移除元素value
	public void delete(int value) {
		for (int i = 0; i < count; i++) {
			if (element[i] == value && i < count-1) {
				for (int j = i; j < count-1; j++) {
					element[j] = element[j+1];
				}
				element[count-1] = -1;
				count--;
				break;
			}
			if (element[i] == value && i == count-1) {
					element[i] = -1;
					count--;
			}
		}
	}
	
	//求出與A的交集並予以回傳
	public IntegerSet intersection(IntegerSet a) {
		IntegerSet b = new IntegerSet();
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < a.count; j++) {
				if (this.element[i] == a.getElement(j)) {
					b.Insert(a.element[j]);
				}
			}	
		}
		return b;
	}
	
	//求出與A的聯集並予以回傳
	public IntegerSet union(IntegerSet a) {
		IntegerSet b = new IntegerSet();
		for (int i = 0; i < this.count; i++) {
			b.Insert(this.element[i]);
		}
		for (int i = 0; i < a.count; i++) {
			b.Insert(a.getElement(i));
		}
		return b;
	}		

	//數字數量大於陣列長度時變更陣列大小
	private void resize(int newSize) {
			IntegerSet newArr = new IntegerSet(newSize);
			for (int i = 0; i < count; i++) {
				newArr.element[i] = this.element[i];
			}
			this.element = null;
			this.element = newArr.element;
		}  

	
}
