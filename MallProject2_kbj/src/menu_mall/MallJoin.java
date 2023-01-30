package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import member.Member;
import member.MemberDAO;
import util.Util;

public class MallJoin implements MenuCommand{
	private MallController mCon;
	private MemberDAO mDao;
	
	@Override
	public void init() {
		mCon = MallController.getInstance();
		mDao = MemberDAO.getInstance();
	}

	@Override
	public void update() {
		while(true) {
			System.out.println("\n[회원가입]");
			System.out.print("# ID ->  ");
			String id = Util.sc.next();
			if(mDao.checkId(id)==true) {
				System.out.println("중복된 ID 입니다.\n다른 ID를 사용해주세요.");
				continue;
			}
			System.out.print("# PW ->  ");
			String pw = Util.sc.next();
			System.out.print("# NAME ->  ");
			String name = Util.sc.next();
			Member m = new Member(mDao.getmNum(), id, pw, name,0);
			mDao.insertMlist(m);
			System.out.printf("[%s] 회원가입 완료\n",id);
			break;
		}
	}

}
