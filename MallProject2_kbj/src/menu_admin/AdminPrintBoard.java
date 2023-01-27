package menu_admin;

import _mall.MenuCommand;
import board.BoardDAO;

public class AdminPrintBoard implements MenuCommand{
	private BoardDAO bDao;
	@Override
	public void init() {
		bDao = BoardDAO.getInstance();
	}

	@Override
	public void update() {
		bDao.readBoard();
	}

}
