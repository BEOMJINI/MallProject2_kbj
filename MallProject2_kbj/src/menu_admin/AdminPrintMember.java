package menu_admin;

import _mall.MenuCommand;
import member.MemberDAO;

public class AdminPrintMember implements MenuCommand {
	private MemberDAO mDao;
	@Override
	public void init() {
		mDao = MemberDAO.getInstance();
	}

	@Override
	public void update() {
		mDao.printAdminMember();
	}

}
