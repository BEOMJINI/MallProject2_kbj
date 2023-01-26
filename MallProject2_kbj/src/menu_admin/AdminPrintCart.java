package menu_admin;

import _mall.MenuCommand;
import cart.CartDAO;

public class AdminPrintCart implements MenuCommand{
	private CartDAO cDao;
	@Override
	public void init() {
		cDao = CartDAO.getInstance();
	}

	@Override
	public void update() {
		cDao.printAdminCart();
	}

}
