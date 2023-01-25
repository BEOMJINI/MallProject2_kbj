package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import member.MemberDAO;
import util.Util;

public class AdminMember implements MenuCommand {
	private MallController mCon;
	private MemberDAO mDao;
	@Override
	public void init() {
		mCon = MallController.getInstance();
		mDao = MemberDAO.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.println("\n_______ADMIN 회원관리________");
			System.out.println("[0]ADMIN 메인 [1]회원목록 [2]주문목록");
			int sel = Util.getValue(0, 2);
			if(sel == 0) {
				mCon.changeMenu("AdminMain");
			}else if(sel==1) {
				mDao.printAdminMember();
			}else if(sel==2) {
				
			}
		}
		
	}

}
