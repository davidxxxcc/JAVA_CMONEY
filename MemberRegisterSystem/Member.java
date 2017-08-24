package MemberRegisterSystem;

public class Member {
	
	int no;
	private String name, id,phone;
	private MemberDate birth;
	
	public Member (int n, String na,String i, MemberDate b, String p) {
		setData(n,na,i,b,p);
	}
	
	public int getNo () {
		return no;
	}
	public void setData(int n, String na,String i, MemberDate b, String p) {
		no = n;
		name = na;
		id = i;
		birth = b;
		phone = p;
	}
	
	@Override
	public String toString () {
		String str;
		String number = String.valueOf(no);
		str = number + "\t" + name + "\t" + id + "\t" + birth.toString() + "\t" + phone + "\r\n";
		return str;
	}
	

}
