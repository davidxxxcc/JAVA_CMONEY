package Contacts;
//�p��ï���O�A�ΨӰO��h���p�����
public class Contacts {
	//�ΰ}�C���x�s�o�Ǹ�ơA�C�@�Ӥ������O���VAccount���󪺰Ѧ�
	private Account accounts[] = new Account [50];
	private int count = 0; //�ثe�x�s����Ƶ���
	
	public Contacts() {
	}
	public void add(String name, int age, CDate birthday) {
		Account newAccount = new Account (name,age,birthday);
		this.accounts[this.count++] = newAccount;
		//�N�s���󪺦�}�s�J�}�C��
	}
	public void print() {
		//�ư������ޤ��X�k�����p
		for (int i = 0; i < count; i++) {
			Account person = this.accounts[i];
			String name = person.getName();
			int age = person.getAge();
			CDate birthday = person.getBirthday();
			System.out.printf("%2d%10s",i + 1, name);
			System.out.printf("%5d",age);
			System.out.print("  ");
			birthday.print();
			System.out.println("");
		}
	}
	
	//�N�}�C�������ܦ��쥻���⭿
	//�]���O���O�ۤv�ϥΡA�]���ŧi��private
	private void resize() {
		//���ͤ@�Ӯe�q���쥻�⭿�j���}�C
		Account newArray[] = new Account [accounts.length * 2];
		//�N�쥻�}�C�������e�]���󪺰O�����}�^�ƻs��s���}�C
		for (int i = 0; i < this.count; i++) {
			newArray[i] = this.accounts[i];
		}
		this.accounts = null;
		this.accounts = newArray;
	}

}
