package Accounting;

public class Accounting {
	private Record [] accounts = new Record [50];
	private int count = 0;
	
	public Accounting () {
	}
	public void add (String name, int price, CTime recordTime) {
		Record newAccount = new Record (name,price,recordTime);
		accounts[count++] = newAccount;
		//將新物件的位址存入陣列中
	}
	public void print() {
		//排除掉索引不合法的情況
		for (int i = 0; i < count; i++) {
			Record person = this.accounts[i];
			String name = person.getName();
			int price = person.getPrice();
			CTime recordTime = person.getRecordTime();
			System.out.printf("%2d %10s",i+1,name);
			System.out.printf("%5d", price);
			System.out.printf("  ");
			recordTime.print();
			System.out.println("");
		}
	}
	
	//將陣列的長度變成原本的兩倍
	//因為是類別自己使用，因此宣告為private
	private void resize() {
		//產生一個容量為原本兩倍大的陣列
		Record newArray[] = new Record [accounts.length * 2];
		//將原本陣列中的內容（物件的記憶體位址）複製到新的陣列
		for (int i = 0; i < count; i++) {
			newArray[i] = accounts[i];
		}
		this.accounts = null;
		this.accounts = newArray;
	}

	
}
