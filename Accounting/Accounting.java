package Accounting;

public class Accounting {
	private Record [] accounts = new Record [50];
	private int count = 0;
	
	public Accounting () {
	}
	public void add (String name, int price, CTime recordTime) {
		Record newAccount = new Record (name,price,recordTime);
		accounts[count++] = newAccount;
		//�N�s���󪺦�}�s�J�}�C��
	}
	public void print() {
		//�ư������ޤ��X�k�����p
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
	
	//�N�}�C�������ܦ��쥻���⭿
	//�]���O���O�ۤv�ϥΡA�]���ŧi��private
	private void resize() {
		//���ͤ@�Ӯe�q���쥻�⭿�j���}�C
		Record newArray[] = new Record [accounts.length * 2];
		//�N�쥻�}�C�������e�]���󪺰O�����}�^�ƻs��s���}�C
		for (int i = 0; i < count; i++) {
			newArray[i] = accounts[i];
		}
		this.accounts = null;
		this.accounts = newArray;
	}

	
}
