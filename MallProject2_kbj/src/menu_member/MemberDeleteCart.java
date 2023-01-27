package menu_member;

import _mall.MenuCommand;
import cart.CartDAO;

public class MemberDeleteCart implements MenuCommand {
	private CartDAO cDao;
	@Override
	public void init() {
		cDao = CartDAO.getInstance();
	}

	@Override
	public void update() {
	}

}
