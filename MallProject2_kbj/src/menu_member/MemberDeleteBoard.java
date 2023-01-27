package menu_member;

import _mall.MenuCommand;
import board.BoardDAO;

public class MemberDeleteBoard implements MenuCommand{
	private BoardDAO bDao;
	@Override
	public void init() {
		bDao = BoardDAO.getInstance();
	}

	@Override
	public void update() {
		bDao.deleteBoard2();
	}

}
