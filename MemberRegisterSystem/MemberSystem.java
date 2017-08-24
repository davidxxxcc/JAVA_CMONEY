package MemberRegisterSystem;

public class MemberSystem {
	
	private Member[] members = new Member[50];
	private int count;
	
	public MemberSystem () {
		count = 0;
	}
	public int getCount() {
		return count;
	}
	public Member getMember (int n) {
		return members[n];
	}

	
	public String add(int no, String name,String id, MemberDate birth,String phone) {
		Member newMember = new Member (no,name,id,birth,phone);
		this.members[this.count] = newMember;
		return members[count++].toString();
	}
	public String modify(int no, String name,String id, MemberDate birth,String phone) {
		int found = findIndex(no);
		if (found != -1) {
			members[found].setData(no, name, id, birth, phone);
			return members[found].toString();
		}
		return null;
	}
	
	public void delete(int no) {
		int found = findIndex(no);
		if (found != -1) {
			if (found == count -1)
				members[found] = null;
			else {
				for (int i = found; i < count-1; i++) {
					members[i] = members[i +1];
					}
				members[count-1] = null;
			}
			count--;
			}
	}
	
	public int findIndex(int serialNum) {
		for (int i = 0; i < count; i++) {
			if (members[i].no == serialNum)
				return i;
		}
		return -1;
	}
	
}
