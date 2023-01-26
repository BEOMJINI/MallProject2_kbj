package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCart implements MenuCommand{
	private MallController mCon;
	
	@Override
	public void init() {
		mCon = MallController.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.println("\n_____ADMIN 장바구니관리______");
			System.out.println("[0]ADMIN 메인 [1]전체 장바구니목록 [2]회원검색");
			int sel = Util.getValue(0, 2);
			if(sel==0) {
				mCon.changeMenu("AdminMain");
				break;
			}else if (sel==1) {
				mCon.changeMenu("AdminPrintCart");
			}else if (sel==2) {
				mCon.changeMenu("AdminSerchCart");
			}
		}
	}

}
