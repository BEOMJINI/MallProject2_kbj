package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import item.ItemDAO;
import util.Util;

public class MemberMain implements MenuCommand{
	private MallController mCon;
	private ItemDAO iDao;
	@Override
	public void init() {
		mCon = MallController.getInstance();
		iDao = ItemDAO.getInstance();
	}

	@Override
	public void update() {
		while(true) {
			System.out.println("\n____________MEMBER____________");
			System.out.println("[0]종료 [1]쇼핑 [2]장바구니 [3]게시판");
			int sel = Util.getValue(0, 3);
			if(sel == 0) {
				mCon.changeMenu("MallMain");
			}else if (sel==1) {
				//mCon.changeMenu("MemberShopping");
				iDao.shoppingMember();
			}else if (sel==2) {
				
			}else if (sel ==3) {
				
			}
		}
		
	}

}
