package menu_admin;

import _mall.MenuCommand;
import cart.CartDAO;
import util.Util;

public class AdminPrintBuyList implements MenuCommand{
	private CartDAO cDao;
	
	@Override
	public void init() {
		cDao = CartDAO.getInstance();
	}

	@Override
	public void update() {
		System.out.println("\n[0]뒤로가기 [1]전체 구매목록 [2]회원검색");
		int sel = Util.getValue(0, 2);
		if(sel==0) {
			return;
		}else if (sel==1) {
			cDao.printAllBuylist();
		}else if (sel ==2) {
			System.out.println("\n[회원 장바구니 출력]\n검색할 회원 ID를 입력해주세요.");
			System.out.print("# ID ->  ");
			String id = Util.sc.next();
			cDao.serchBuylist(id);
		}
	}

}
