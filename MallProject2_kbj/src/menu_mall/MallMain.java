package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MallMain implements MenuCommand{
	private MallController mCon;
	
	@Override
	public void init() {
		mCon = MallController.getInstance();
	}

	@Override
	public void update() {
		while (true) {
			System.out.println("\n________SHOPPING2________");
			System.out.println("[0]종료 [1]로그인 [2]회원가입");
			int sel = Util.getValue(0, 2);
			if(sel ==0) {
				break;
			}else if (sel==1) {
				mCon.changeMenu("MallLogin");
			}else if (sel ==2) {
				mCon.changeMenu("MallJoin");
			}
		}
	}

}
