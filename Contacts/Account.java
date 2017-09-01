package Contacts;

public class Account {
	
	private String name = new String("");
	private int age = 0;
	private CDate birthday = new CDate (1,1,1);
	
	//初始化建構子
	public Account (String n, int a, CDate b) {
		this.setData(n,a,b);
	}
	public void setData(String n , int a, CDate b) {
		if (n != null)
			name = n;
		if (a > 0)
			age = a;
		if (b != null)
			birthday = b;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public CDate getBirthday() {
		return birthday;
	}
}
	
	
