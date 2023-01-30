package file;

import _mall.MenuCommand;
import cart.CartDAO;
import controller.MallController;
import item.ItemDAO;
import member.MemberDAO;
import util.Util;

public class ManagementData implements MenuCommand{
	private MallController mCon;
	private ItemDAO iDao;
	private CartDAO cDao;
	private MemberDAO mDao;
	
	@Override
	public void init() {
		iDao = ItemDAO.getInstance();
		mCon = MallController.getInstance();
		cDao = CartDAO.getInstance();
		mDao = MemberDAO.getInstance();
	}

	@Override
	public void update() {
		System.out.println("\n[데이터관리]\n회원목록,상품목록,구매목록을 저장하거나 불러옵니다.\n[0]뒤로가기 [1]저장 [2]불러오기");
		int sel = Util.getValue(0, 2);
		if(sel ==0) {
			return;
		}else if (sel==1) {
			iDao.saveItemList();
			mDao.saveMemberList();
			cDao.saveBuyList();
		}else if (sel==2) {
			iDao.loadItemList();
			mDao.loadMemberList();
			cDao.loadBuyList();
		}
	}

}
