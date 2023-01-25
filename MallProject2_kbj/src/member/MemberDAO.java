package member;

import java.util.ArrayList;

public class MemberDAO {
	private MemberDAO () {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private ArrayList<Member> mlist;
	private int mNum;

	public ArrayList<Member> getMlist() {
		return mlist;
	}

	public void setMlist(ArrayList<Member> mlist) {
		this.mlist = mlist;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

	/** controller init */
	public void init() {
		mlist = new ArrayList<>();
		mNum = 1000;
		sampleMember();
	}

	/** 아이디 , 비밀번호 일치 체크 */
	public boolean checkLogin(String id, String pw) {
		for (Member m : mlist) {
			if (id.equals(m.getId()) && pw.equals(m.getPw())) {
				// loginId = id;
				return true;
			}
		}
		return false;
	}

	/** 중복 아이디 체크 */
	public boolean checkId(String id) {
		for (Member m : mlist) {
			if (id.equals(m.getId())) {
				return true;
			}
		}
		return false;
	}

	/** 멤버번호 부여 */
	public int Num() {
		mNum++;
		return mNum;
	}

	/** 멤버리스트에 넣기 */
	public void insertMlist(Member m) {
		mlist.add(m);
	}

	/** 회원 샘플데이터 */
	public void sampleMember() {
		Member member = new Member(Num(), "admin", "admin", "관리자");
		insertMlist(member);
		member = new Member(Num(), "a","a","A");
		insertMlist(member);
		member = new Member(Num(), "b", "b","B");
		insertMlist(member);
	}
	
	public void printAdminMember() {
		System.out.println("\n[전체 회원목록]");
		for(Member m : mlist) {
			System.out.println(m.toString());
		}
	}

}
