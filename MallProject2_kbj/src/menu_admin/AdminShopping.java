package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import item.ItemDAO;
import util.Util;

public class AdminShopping implements MenuCommand{
	private MallController mCon;
	//private ItemDAO iDao;
	@Override
	public void init() {
		mCon = MallController.getInstance();
		//iDao = ItemDAO.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.println("\n________________ADMIN 상품관리________________");
			System.out.println("[0]ADMIN 메인 [1]전체 상품목록 [2]상품추가 [3]상품삭제");
			int sel = Util.getValue(0, 3);
			if(sel ==0) {
				mCon.changeMenu("AdminMain");
				break;
			}else if (sel ==1) {
				mCon.changeMenu("AdminPrintItem");
				//iDao.printAdminItem();
			}else if (sel ==2) {
				mCon.changeMenu("AdminAddItem");
				//iDao.addAdminItem();
			}else if (sel ==3) {
				mCon.changeMenu("AdmindeleteItem");
				//iDao.deleteAdminItem();
			}
		}
	}

}
