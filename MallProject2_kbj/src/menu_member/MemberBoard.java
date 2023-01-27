package menu_member;

import _mall.MenuCommand;
import board.BoardDAO;
import controller.MallController;
import util.Util;

public class MemberBoard implements MenuCommand{
	private MallController mCon;
	private BoardDAO bDao;
	@Override
	public void init() {
		mCon = MallController.getInstance();
		bDao = BoardDAO.getInstance();
	}

	@Override
	public void update() {
		while(true) {
			System.out.println("\n____________MEMBER 게시판____________");
			bDao.printBoard2();
			System.out.println("\n[0]MEMBER 메인 [1]게시글 읽기 [2]게시글 작성 [3]게시글 삭제");
			int sel = Util.getValue(0, 3);
			if(sel==0) {
				break;
			}else if (sel==1) {
				mCon.changeMenu("MemberReadBoard");
			}else if(sel==2) {
				mCon.changeMenu("MemberWriteBoard");
			}else if (sel==3) {
				mCon.changeMenu("MemberDeleteBoard");
			}
		}
		
	}

}
