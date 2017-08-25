package IntegerTest;

public class IntegerSet {
	
	private int [] element;	//�x�s�Ʀr���}�C�F�̤p���׬�10
	private int count = 0;	//�ثe�}�C�����Ʀr�Ӽ�
	private int size = 0;	//�}�C�j�p
	//�غc�l,�Ū������w�q��-1
	public IntegerSet() {					
		size = 10;
		this.element = new int [size];
		for (int i = 0; i < size; i++)
			element[i] = -1;
	}
	//�غc�l�F�޼ƥN���X�i�x�s�̤j�e�q
	public IntegerSet(int s) {			
		this();
		if (s > 10) {
			this.element = new int [s];
		for (int i = 0; i < s; i++)
			element[i] = -1;
		}
	}
	
	
	//�s�W�s������value�]���ƪ��������[�J
	public void Insert(int value) {
		if (this.search(value) == -1) {
			if (size <= count)
				this.resize(size*2);
			element[count++]= value;
		}
	}
	
	//����s����i����ơA�p�G���޶W�X�d��A�Ц^��-1
	public int getElement(int i) {
		if (i >= count)
			return -1;
		return element[i];
	}	
	//�L�X���X���Ҧ����������e
	public void output() {
		for (int i = 0; i < count; i++) {
			if (i < count -1)
				System.out.printf("%2d, ", element[i]);
			else if ((i < count))
				System.out.printf("%2d", element[i]);
		}
		System.out.println("");
	}	
	//�j�Mvalue�O�_�b���X���C���h�^�Ǩ�index�A�_�h�^��-1
	public int search(int value) {
		for (int i = 0; i < count; i++) {
			if (element[i] == value)
				return i;
		}
		return -1;
	}  
	//��������value
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
	
	//�D�X�PA���涰�ä��H�^��
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
	
	//�D�X�PA���p���ä��H�^��
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

	//�Ʀr�ƶq�j��}�C���׮��ܧ�}�C�j�p
	private void resize(int newSize) {
			IntegerSet newArr = new IntegerSet(newSize);
			for (int i = 0; i < count; i++) {
				newArr.element[i] = this.element[i];
			}
			this.element = null;
			this.element = newArr.element;
		}  

	
}
