package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import board.BoardDAO;
import cart.CartDAO;
import file.ManagementData;
import item.ItemDAO;
import member.MemberDAO;
import menu_admin.AdminAddItem;
import menu_admin.AdminBoard;
import menu_admin.AdminCart;
import menu_admin.AdminDeleteBoard;
import menu_admin.AdminMain;
import menu_admin.AdminMember;
import menu_admin.AdminPrintBoard;
import menu_admin.AdminPrintBuyList;
import menu_admin.AdminPrintCart;
import menu_admin.AdminPrintItem;
import menu_admin.AdminPrintMember;
import menu_admin.AdminSerchCart;
import menu_admin.AdminShopping;
import menu_admin.AdminWriteNotic;
import menu_admin.AdmindeleteItem;
import menu_mall.MallJoin;
import menu_mall.MallLogin;
import menu_mall.MallMain;
import menu_member.MemberBoard;
import menu_member.MemberCart;
import menu_member.MemberDeleteBoard;
import menu_member.MemberMain;
import menu_member.MemberReadBoard;
import menu_member.MemberShopping;
import menu_member.MemberWriteBoard;

public class MallController {
	private MallController() {}
	private static MallController instance = new MallController();
	public static MallController getInstance() {
		return instance;
	}
	
	private Map<String, MenuCommand> mapCon;
	private String loginId;
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void init() {
		MemberDAO.getInstance().init();
		ItemDAO.getInstance().init();
		CartDAO.getInstance().init();
		BoardDAO.getInstance().init();
		mapCon = new HashMap<>();
		mapCon.put("MallMain", new MallMain());
		mapCon.put("MallLogin", new MallLogin());
		mapCon.put("MallJoin", new MallJoin());
		mapCon.put("MemberMain", new MemberMain());
		mapCon.put("AdminMain", new AdminMain());
		mapCon.put("AdminMember", new AdminMember());
		mapCon.put("AdminShopping", new AdminShopping());
		mapCon.put("MemberShopping", new MemberShopping());
		mapCon.put("AdminPrintItem", new AdminPrintItem());
		mapCon.put("AdminAddItem", new AdminAddItem());
		mapCon.put("AdmindeleteItem", new AdmindeleteItem());
		mapCon.put("MemberCart", new MemberCart());
		mapCon.put("AdminCart", new AdminCart());
		mapCon.put("AdminPrintCart", new AdminPrintCart());
		mapCon.put("AdminSerchCart", new AdminSerchCart());
		mapCon.put("AdminPrintMember", new AdminPrintMember());
		mapCon.put("AdminPrintBuyList", new AdminPrintBuyList());
		mapCon.put("AdminPrintBoard", new AdminPrintBoard());
		mapCon.put("AdminWriteNotic", new AdminWriteNotic());
		mapCon.put("AdminDeleteBoard", new AdminDeleteBoard());
		mapCon.put("AdminBoard", new AdminBoard());
		mapCon.put("MemberBoard", new MemberBoard());
		mapCon.put("MemberWriteBoard", new MemberWriteBoard());
		mapCon.put("MemberReadBoard", new MemberReadBoard());
		mapCon.put("MemberDeleteBoard", new MemberDeleteBoard());
		mapCon.put("ManagementData", new ManagementData());
		loginId = "";
		changeMenu("MallMain");
		
		
	}
	
	public void changeMenu(String mapName) {
//		mapName.init();
//		mapName.update();
//		for(int i =0; i<mapCon.size(); i++) {
//			//System.out.println(mapCon.get);
//			if(mapName.equals(mapCon.get(i))) {
//				mapCon.get(i).init();
//				mapCon.get(i).update();
//			}
//		}
		mapCon.get(mapName).init();
		mapCon.get(mapName).update();
		
	}
}
