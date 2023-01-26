package menu_admin;

import _mall.MenuCommand;
import cart.CartDAO;
import util.Util;

public class AdminSerchCart implements MenuCommand{
	private CartDAO cDao;
	@Override
	public void init() {
		cDao = CartDAO.getInstance();
	}

	@Override
	public void update() {
		System.out.println("\n[회원 장바구니 출력]\n검색할 회원 ID를 입력해주세요.");
		System.out.print("# ID ->  ");
		String id = Util.sc.next();
		cDao.serchAdminCart(id);
	}

}
