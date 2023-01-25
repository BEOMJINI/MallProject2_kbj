package cart;

import java.util.ArrayList;

import controller.MallController;
import item.Item;

public class CartDAO {
	private CartDAO () {}
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	private ArrayList<Cart> clist;
	private int cartNum;
	private ArrayList<Cart> buylist;
	private MallController mCon;
	
	public void init() {
		clist = new ArrayList<>();
		cartNum = 0;
		buylist = new ArrayList<>();
		mCon = MallController.getInstance();
	}
	/** 장바구니 목록 번호부여 */
	public int Num() {
		cartNum++;
		return cartNum;
	}
	
	/** member [1]쇼핑 > 선택 > 장바구니리스트에 넣기 */
	public void insertClist(Item i) {
		clist.add(new Cart(Num(),mCon.getLoginId(),i.getName(),i.getPrice()));
	}
	
	
}
