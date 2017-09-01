package Contacts;

public class CDate {
	private int year, month, day;
	public CDate (int y, int m, int d) {
		this.setData(y, m, d);
	}
	//用來指定資料成員的值，可直接在建構子中呼叫它
	//也可以在物件建立後
	public void setData(int y, int m, int d) {
		year = month = day = 1;
		if (y >= 1)
			year = y;
		if (m >= 1 && m <= 12)
			month = m;
		if (CDate.isValid(y, m, d))
		day = d;
	}
	//檢查傳入的年月日是否是格式正確的日期
	//回傳false代表格式不符
	public static boolean isValid(int y, int m, int d) {
		//用陣列記住每個月的天數
		int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if (y <= 0 || m <= 0 || m > 12)
			return false;
		//如果不是二月
		if (m != 2) {
			//對應的天數不在正常範圍
			if (d <0 || d > days[m]) 
				return false;
			return true;
		}
		//二月的情況需判斷閏年
		//西元年份除以4可整除且除以100不可整除，或
		//西元年份除以400可整除
		if ((y%4 == 0 && y%100 != 0) || y%400 == 0) {
			if (d <= 0 || d >29)
				return false;
			return true;
		}
		//平年（非閏年）
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
	//回傳數字代表兩個日期比較的結果
	//回傳小於0的值即代表a日期比較早
	//回傳大於0的值即代表a比較晚
	//回傳等於0的值即代表a, b兩個日期一樣
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
	
