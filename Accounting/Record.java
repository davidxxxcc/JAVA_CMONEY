package Accounting;

public class Record {
	//�ŧi�ݩʨê�l��
	private String name = new String("");
	private int price = 0;
	private CTime recordTime = new CTime(1,1,1);
	//��l�ƨ�غc�l
	public Record (String n, int p, CTime rt) {
		this.setData(n,p,rt);
	}
	//�ˬd��J��ƬO�_���T
	public void setData (String n, int p, CTime rt) {
		if (n != null)
			name = n;
		if (p > 0)
			price = p;
		if (rt != null)
			recordTime = rt;	
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public CTime getRecordTime () {
		return recordTime;
	}
}
