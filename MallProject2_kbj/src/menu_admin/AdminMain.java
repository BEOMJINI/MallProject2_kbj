package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminMain implements MenuCommand{
	private MallController mCon;
	@Override
	public void init() {
		mCon= MallController.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.println("\n_____________________ADMIN_____________________");
			System.out.println("[0]종료 [1]회원관리 [2]상품관리 [3]장바구니관리 [4]게시판관리");
			int sel = Util.getValue(0, 4);
			if(sel ==0) {
				mCon.changeMenu("MallMain");
			}else if(sel==1) {
				mCon.changeMenu("AdminMember");
			}else if (sel ==2) {
				mCon.changeMenu("AdminShopping");
			}else if(sel==3) {
				
			}else if (sel==4) {
				
			}
		}
	}

}
