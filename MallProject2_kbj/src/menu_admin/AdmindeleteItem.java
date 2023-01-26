package menu_admin;

import _mall.MenuCommand;
import item.ItemDAO;

public class AdmindeleteItem implements MenuCommand{
	private	ItemDAO iDao;
	@Override
	public void init() {
		iDao = ItemDAO.getInstance();
	}

	@Override
	public void update() {
		iDao.deleteAdminItem();
	}

}
