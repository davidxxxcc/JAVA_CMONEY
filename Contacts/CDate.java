package Contacts;

public class CDate {
	private int year, month, day;
	public CDate (int y, int m, int d) {
		this.setData(y, m, d);
	}
	//�Ψӫ��w��Ʀ������ȡA�i�����b�غc�l���I�s��
	//�]�i�H�b����إ߫�
	public void setData(int y, int m, int d) {
		year = month = day = 1;
		if (y >= 1)
			year = y;
		if (m >= 1 && m <= 12)
			month = m;
		if (CDate.isValid(y, m, d))
		day = d;
	}
	//�ˬd�ǤJ���~���O�_�O�榡���T�����
	//�^��false�N��榡����
	public static boolean isValid(int y, int m, int d) {
		//�ΰ}�C�O��C�Ӥ몺�Ѽ�
		int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if (y <= 0 || m <= 0 || m > 12)
			return false;
		//�p�G���O�G��
		if (m != 2) {
			//�������ѼƤ��b���`�d��
			if (d <0 || d > days[m]) 
				return false;
			return true;
		}
		//�G�몺���p�ݧP�_�|�~
		//�褸�~�����H4�i�㰣�B���H100���i�㰣�A��
		//�褸�~�����H400�i�㰣
		if ((y%4 == 0 && y%100 != 0) || y%400 == 0) {
			if (d <= 0 || d >29)
				return false;
			return true;
		}
		//���~�]�D�|�~�^
		if (d <= 0 || d > days[m])
			return false;
		
		return true;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	//�^�ǼƦr�N���Ӥ����������G
	//�^�Ǥp��0���ȧY�N��a��������
	//�^�Ǥj��0���ȧY�N��a�����
	//�^�ǵ���0���ȧY�N��a, b��Ӥ���@��
	public static int compare(CDate a, CDate b) {
		if (a.year - b.year != 0) 
			return a.year - b.year;
		if (a.month - b.month != 0)
			return a.month - b.month;
		return a.day - b.day;
	}
	public void print() {
		System.out.printf("%04d/%02d/%02d",this.year,this.month,this.day);
	}

	
}
	
