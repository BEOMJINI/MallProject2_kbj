package menu_member;

import _mall.MenuCommand;
import cart.CartDAO;
import controller.MallController;
import util.Util;

public class MemberCart implements MenuCommand {
	private CartDAO cDao;
	private MallController mCon;

	@Override
	public void init() {
		cDao = CartDAO.getInstance();
		mCon = MallController.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.printf("\n[%s 장바구니 목록]\n",mCon.getLoginId());
			cDao.printMemberCart(mCon.getLoginId());
			System.out.println("\n[0]뒤로가기 [1]구매 [2]장바구니삭제");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				//mCon.changeMenu("MemberBuyItem");
				cDao.insertBuylist(mCon.getLoginId());
			} else if (sel == 2) {
				//mCon.changeMenu("MemberDeleteCart");
				cDao.removeOneCart(cDao.printMemberCart(mCon.getLoginId()));
			}
		}
		// cDao.getmemberCartList(mCon.getLoginId());
		// cDao.printMemberCart(mCon.getLoginId());

		// cDao.memberCartFunction(cDao.printMemberCart());
		// cDao.printMemberCart();
	}

}
