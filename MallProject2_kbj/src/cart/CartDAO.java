package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controller.MallController;
import item.Item;
import member.MemberDAO;
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

	public void init() {
		clist = new ArrayList<>();
		cartNum = 0;
		buylist = new ArrayList<>();
		mCon = MallController.getInstance();
		mDao = MemberDAO.getInstance();
	}

	/** 장바구니 목록 번호부여 */
	public int Num() {
		cartNum++;
		return cartNum;
	}

	/** member [1]쇼핑 > 선택 > 장바구니리스트에 넣기 */
	public void insertClist(Item i) {
		clist.add(new Cart(i.getNum(), mCon.getLoginId(), i.getName(), i.getPrice()));
		System.out.printf("[%s] 장바구니에 담겼습니다.\n", i.getName());
	}

	/** member 별 장바구니 출력 [2] 장바구니 */
	  // integer : order idx  integer: cartListIdx
	public Map<Integer[], Cart> printMemberCart() {
		Map<Integer[], Cart> myCartList = new HashMap<>();
		// myCartList.clear();
		System.out.println("\n[장바구니 목록]");
		//ArrayList<Cart> memberCartlist = new ArrayList<>();
		int num = 1;
		for (int i = 0; i < clist.size(); i++) {
			if (mCon.getLoginId().equals(clist.get(i).getId())) {
				// System.out.println(clist.get(i).toString());
				Integer idxs[] = {num,i};
				myCartList.put(idxs, clist.get(i));
				num++;
			}
			
		}
		if (myCartList.size() == 0) {
			System.out.println("장바구니가 비었습니다.");
			return myCartList;
		}
		//System.out.println(myCartList.toString());
//		for(Cart c : memberCartlist) {
//			System.out.println(c.toString());
//		}
		return myCartList;
	}
	
	   public Map<Integer,Integer> getmemberCartList(String memberLoginID) {
	        Map<Integer,Integer> oneCartList = new HashMap();
	        int num =1;
	        for (int i = 0; i < clist.size(); i++) {
	            if(clist.get(i).getId().equals(memberLoginID)) {
	                oneCartList.put(num , i);
	            }
	        }
	        return oneCartList;
	    }
	    
	    public Map<Integer,Integer> printMemberCart(String memberLoginID) {
	        Map<Integer,Integer> list = getmemberCartList( memberLoginID);
	        for(int num : list.keySet()) {
	            System.out.println(num +")" + clist.get(list.get(num)));
	        }
	        return list;
	    }
	    
	    public void removeOneCart(int num , Map<Integer,Integer> list ){
	        
	        for(int number : list.keySet()) {
	            if(num == number) {
	                clist.remove(list.get(num));
	            }
	        }
	        System.out.println("삭제 완료");
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
			for(Integer[] nums : list.keySet()) {
				System.out.print(nums[0] +" ) " + list.get(nums));
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
			
				for(Integer[] nums : list.keySet()) {
					System.out.print(nums[0] +" ) " + list.get(nums));
					System.out.println();
				}
				System.out.println("삭제 번호 입력");
				int delNum = Util.getValue(1, list.keySet().size()+1);
				for(Integer[] nums : list.keySet()) {
					if(nums[0] == delNum) {
						System.err.println("test=" + nums[1]);
						clist.remove(list.get(nums));
					}
				}
			}

		}
	}
	
	

	/** 구매리스트에 넣기 */
	public void insertBuylist(ArrayList<Cart> list) {
		buylist.addAll(list);
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
