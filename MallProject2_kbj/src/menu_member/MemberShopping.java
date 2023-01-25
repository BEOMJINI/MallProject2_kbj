package menu_member;

import _mall.MenuCommand;
import controller.MallController;

public class MemberShopping implements MenuCommand{
	private MallController mCon;
	
	@Override
	public void init() {
		mCon = MallController.getInstance();
	}

	@Override
	public void update() {
		
	}

}
