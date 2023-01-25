package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import member.MemberDAO;
import util.Util;

public class MallLogin implements MenuCommand{
	private MallController mCon;
	private MemberDAO mDao;
	@Override
	public void init() {
		mCon = MallController.getInstance();
		mDao= MemberDAO.getInstance();
	}

	@Override
	public void update() {
		while(true) {
		System.out.println("\n[로그인]");
		System.out.print("# ID ->  ");
		String id = Util.sc.next();
		System.out.print("# PW ->  ");
		String pw = Util.sc.next();
		if(mDao.checkLogin(id, pw)==false) {
			System.out.println("[로그인실패]\nID 또는 PW 를 확인해주세요.");
			continue;
		}
		if(id.equals("admin")) {
			mCon.setLoginId(id);
			System.out.printf("\n[%s 로그인]\n",id);
			mCon.changeMenu("AdminMain");
		} else {
			mCon.setLoginId(id);
			System.out.printf("\n[%s 로그인]\n",id);
			mCon.changeMenu("MemberMain");
		}
		break;
		}
	}

}
