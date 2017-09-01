package Accounting;

public class CTime {
	private int hour, minute, second;
	
	public CTime(int h, int m, int s) {
		this.setData(h,m,s);
	}
	
	public void setData(int h, int m,int s) {
		hour = minute = second = 1;
		if (CTime.isValid(h,m,s)) {
			hour = h;
			minute = m;
			second = s;
		}
	}
	
	public static boolean isValid(int h, int m, int s) {
		if (h < 0 || h >= 24)
			return false;
		if (m < 0 || m >= 60)
			return false;
		if (s < 0 || s >= 60)
			return false;
		return true;
	}
	
	public int getHour () {
		return hour;
	}
	public int getMinute () {
		return minute;
	}
	public int getSecond () {
		return second;
	}
	
	//�ΨӤ����Ӯɶ����󪺤j�p�A�e�̸��j���ܡ]��ܮɶ����ߡ^�A�h�^�Ǥ@�Ӥj��s���Ʀr�A���p���ܫh�^�Ǥp��s���Ʀr�A�p�G�۵��h�^�ǹs�C
	public static int compare(CTime a, CTime b) {
		if (a.hour - b.hour != 0)
			return a.hour - b.hour;
		if (a.minute - b.minute != 0)
			return a.minute - b.minute;
		return a.second - b.second;
	}
	public void print() {
		System.out.printf("%02d�I%02d��%02d��", this.hour,this.minute,this.second);
	}
}
