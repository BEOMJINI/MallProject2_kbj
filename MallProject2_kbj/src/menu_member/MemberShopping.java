package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import item.ItemDAO;

public class MemberShopping implements MenuCommand{
	//private MallController mCon;
	private ItemDAO iDao;
	
	@Override
	public void init() {
		//mCon = MallController.getInstance();
		iDao =ItemDAO.getInstance();
	}

	@Override
	public void update() {
		iDao.shoppingMember();
	}

}
