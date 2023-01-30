package member;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public void saveMemberList() {
		String fileName= "src/file/MEMBERLIST.txt";
		String data = "";
		FileWriter fw = null;
		for(int i=0; i<mlist.size(); i++) {
			data+=mlist.get(i).getNum()+"/"+mlist.get(i).getId()+"/"+mlist.get(i).getPw()+"/"+mlist.get(i).getName()+"\n";
		}
		try {
			fw=new FileWriter(fileName);
			fw.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("[현재 회원목록 저장완료]");
	}
	
	public void loadMemberList() {
		String fileName= "src/file/MEMBERLIST.txt";
		String data="";
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			int read =0;
			while(true) {
				read=fr.read();
				if(read!=-1) {
					data+=(char)read;
				}else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		mlist.clear();
		String [] data2 = data.split("\n");
		String [] info = null;
		if(info == null) {
			System.out.println("[회원목록 불러오기 실패]\n저장된 회원목록이 없습니다.");
			return;
		}
		for(int i=0; i<data2.length; i++) {
			info = data2[i].split("/");
			mlist.add(new Member(Integer.parseInt(info[0]),info[1],info[2],info[3]));
		}
		System.out.println("[저장되어있던 회원목록 불러오기 완료]");
	}

}
