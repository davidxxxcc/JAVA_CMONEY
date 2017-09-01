package Accounting;

public class Record {
	//宣告屬性並初始化
	private String name = new String("");
	private int price = 0;
	private CTime recordTime = new CTime(1,1,1);
	//初始化其建構子
	public Record (String n, int p, CTime rt) {
		this.setData(n,p,rt);
	}
	//檢查輸入資料是否正確
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
