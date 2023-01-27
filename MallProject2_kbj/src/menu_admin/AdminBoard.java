package menu_admin;

import _mall.MenuCommand;
import board.BoardDAO;
import controller.MallController;
import util.Util;

public class AdminBoard implements MenuCommand{
	private MallController mCon;
	private BoardDAO bDao;
	@Override
	public void init() {
		mCon = MallController.getInstance();
		bDao = BoardDAO.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.println("\n______________ADMIN 게시판관리________________");
			bDao.printBoard2();
			System.out.println("\n[0]ADMIN 메인 [1]게시글 읽기 [2]공지작성 [3]게시글삭제");
			int sel = Util.getValue(0, 3);
			if(sel ==0) {
				//mCon.changeMenu("AdminMain");
				break;
			}else if(sel==1) {
				mCon.changeMenu("AdminPrintBoard");
			}else if(sel==2) {
				mCon.changeMenu("AdminWriteNotic");
			}else if(sel==3) {
				mCon.changeMenu("AdminDeleteBoard");
			}
		}
		
	}

}
