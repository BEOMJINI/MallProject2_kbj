package cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controller.MallController;
import item.Item;
import item.ItemDAO;
import member.MemberDAO;
import menu_admin.AdminCart;
import menu_admin.AdminPrintCart;
import util.Util;

public class CartDAO {
	private CartDAO() {
	}

	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	private ArrayList<Cart> clist;
	private int cartNum;
	private ArrayList<Cart> buylist;
	private MallController mCon;
	private MemberDAO mDao;
	private ItemDAO iDao;

	public void init() {
		clist = new ArrayList<>();
		cartNum = 0;
		buylist = new ArrayList<>();
		mCon = MallController.getInstance();
		mDao = MemberDAO.getInstance();
		sampleCart();
		iDao = ItemDAO.getInstance();
	}

	/** 장바구니 목록 번호부여 */
	public int Num() {
		cartNum++;
		return cartNum;
	}
	
	public void sampleCart() {
		clist.add(new Cart(0, "a", "콜라", 1000));
		clist.add(new Cart(0, "a", "사이다", 2000));
		clist.add(new Cart(0, "b", "나초", 3000));
		clist.add(new Cart(0, "b", "새우깡", 4000));
	}

	/** member [1]쇼핑 > 선택 > 장바구니리스트에 넣기 */
	public void insertClist(Item i) {
		clist.add(new Cart(i.getNum(), mCon.getLoginId(), i.getName(), i.getPrice()));
		System.out.printf("[%s] 장바구니에 담겼습니다.\n", i.getName());
	}

	/** member 별 장바구니 출력 [2] 장바구니 */
	// integer : order idx integer: cartListIdx
	public Map<Integer[], Cart> printMemberCart() {
		Map<Integer[], Cart> myCartList = new HashMap<>();
		// myCartList.clear();
		System.out.println("\n[장바구니 목록]");
		// ArrayList<Cart> memberCartlist = new ArrayList<>();
		int num = 1;
		for (int i = 0; i < clist.size(); i++) {
			if (mCon.getLoginId().equals(clist.get(i).getId())) {
				// System.out.println(clist.get(i).toString());
				Integer idxs[] = { num, i };
				myCartList.put(idxs, clist.get(i));
				num++;
			}

		}
		if (myCartList.size() == 0) {
			System.out.println("장바구니가 비었습니다.");
			return myCartList;
		}
		// System.out.println(myCartList.toString());
//		for(Cart c : memberCartlist) {
//			System.out.println(c.toString());
//		}
		return myCartList;
	}

	public Map<Integer, Integer> getmemberCartList(String memberLoginID) {
		Map<Integer, Integer> oneCartList = new HashMap();
		int num = 1;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).getId().equals(memberLoginID)) {
				oneCartList.put(num, i);
				num++;
			}
		}
		return oneCartList;
	}

	public Map<Integer, Integer> printMemberCart(String memberLoginID) {
		Map<Integer, Integer> list = getmemberCartList(memberLoginID);
		if (list.keySet().size() == 0) {
			System.out.println("장바구니가 비었습니다.\n먼저 쇼핑을 통해 상품을 담아주세요.");
		}
		for (int num : list.keySet()) {
			System.out.println(num + ")" + clist.get(list.get(num)));
		}
		return list;
	}

	public void removeOneCart(Map<Integer, Integer> list) {
		if(list.keySet().size()==0) {
			return;
		}
		// printAdminCart();
		System.out.println("\n[장바구니 상품빼기]\n번호로 선택해주세요.");
		Integer num = Util.getValue(0, list.keySet().size());
		// System.out.println(num);

		for (Integer n : list.keySet()) {
			// System.out.println(list.get(num));
			// System.out.println(n);
			if (n.compareTo(num) == 0) {
				/*
				 * INFO : remove 할때 list.get(num)을 Integer로 저장되어 remove(Object)로 받아옴 : 그래서 삭제가
				 * 안되고 boolean값인 false만 호출함. 삭제되면 삭제도 되고 true 호출함. : 그래서 clist에 맞게 Cart로 저장해서
				 * remove(Cart) 해주던가 : list.get(num)을 다운캐스팅 ? (int)해줘서 삭제 remove(int);
				 * 
				 * [1]. Cart c = clist.get(list.get(num)); System.out.println(c);
				 * clist.remove(c);
				 * 
				 * [2].
				 */
				clist.remove((int) list.get(num));
				System.out.println(num + " 번 삭제 완료");

				// printAdminCart();
			}
		}
	}

	/** member 장바구니 구매 삭제 */
	public void memberCartFunction(Map<Integer[], Cart> list) {
		while (true) {
			if (list.size() == 0) {
				return;
			}
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(i+1+") "+list.get(i).toString());
//		}
			for (Integer[] nums : list.keySet()) {
				System.out.print(nums[0] + " ) " + list.get(nums));
				System.out.println();
			}

			System.out.println("\n[0]뒤로가기 [1]구매 [2]장바구니삭제");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				// insertBuylist(list);
				System.out.println("\n[주문완료]\n장바구니를 비웁니다.");
				for (int i = 0; i < clist.size(); i++) {
					if (clist.get(i).getId().equals(mCon.getLoginId())) {
						clist.remove(i);
						i--;
					}
				}
				break;
			} else if (sel == 2) {

				for (Integer[] nums : list.keySet()) {
					System.out.print(nums[0] + " ) " + list.get(nums));
					System.out.println();
				}
				System.out.println("삭제 번호 입력");
				int delNum = Util.getValue(1, list.keySet().size() + 1);
				for (Integer[] nums : list.keySet()) {
					if (nums[0] == delNum) {
						System.err.println("test=" + nums[1]);
						clist.remove(list.get(nums));
					}
				}
			}

		}
	}

	/** 구매리스트에 넣기 */
	public void insertBuylist(String name) {
		if(getmemberCartList(mCon.getLoginId()).keySet().size()==0){
			System.out.println("장바구니가 비었습니다.\n먼저 쇼핑을 통해 상품을 담아주세요.");
			return;
		}
		// ArrayList<Cart> buy = new ArrayList<>();
		System.out.println("\n[주문완료]\n장바구니를 비웁니다.");
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).getId().equals(name)) {
				// buy.add(clist.get(i));
				buylist.add(clist.get(i));
				clist.remove(i);
				i--;

			}
		}
		// buylist.addAll(buy);
	}

	public void printAllBuylist() {
		System.out.println("\n[전체 주문목록]");
		for (Cart c : buylist) {
			System.out.println(c.toString());
		}
	}

	public void serchBuylist(String id) {
		if (mDao.checkId(id) == false) {
			System.out.println("\n[존재하지 않는 회원입니다.]\nID를 확인해주세요.");
			return;
		}
		ArrayList<Cart> temp = new ArrayList<>();
		System.out.printf("\n[%s 구매 목록]\n", id);
		for (int i = 0; i < buylist.size(); i++) {
			if (id.equals(buylist.get(i).getId())) {
				temp.add(buylist.get(i));
				System.out.println(buylist.get(i).toString());
			}
		}
		int cnt =0;
		for(int i=0; i<iDao.getIlist().size(); i++) {
			cnt = 0;
			for(int j=0; j<temp.size(); j++) {
				if(iDao.getIlist().get(i).getName().equals(temp.get(j).getItemName())) {
					cnt++;
				}
			}
			if(cnt!=0) {
			System.out.println(iDao.getIlist().get(i).getName()+" "+cnt+" 개");
			}
		}
		
		
	}

	/** admin 장바구니 전체 출력 장바구니관리 [2]장바구니출력 */
	public void printAdminCart() {
		System.out.println("\n[전체 장바구니 목록]");
		if (clist.size() == 0) {
			System.out.println("장바구니가 비었습니다.");
			return;
		}
		for (Cart c : clist) {
			System.out.println(c.toString());
		}
	}

	/** admin 장바구니관리 [3]회원검색 */
	public void serchAdminCart(String id) {
		if (mDao.checkId(id) == false) {
			System.out.println("\n[존재하지 않는 회원입니다.]\nID를 확인해주세요.");
			return;
		}
		System.out.printf("\n[%s 장바구니 목록]\n", id);
		for (int i = 0; i < clist.size(); i++) {
			if (id.equals(clist.get(i).getId())) {
				System.out.println(clist.get(i).toString());
			}
		}
	}
	
	
}
