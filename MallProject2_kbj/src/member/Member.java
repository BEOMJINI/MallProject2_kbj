package member;

public class Member {
	private int num;
	private String id;
	private String pw;
	private String name;
	private double memberPoint;
	public Member(int num, String id, String pw, String name, double memberPoint) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.memberPoint = memberPoint;
		
	}
	
	@Override
	public String toString() {
		String s = String.format("[NUM]%-4d [ID]%7s [PW]%7s [NAME]%7s", num, id, pw, name);
		return s;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(double memberPoint) {
		this.memberPoint = memberPoint;
	}
	
	
}
