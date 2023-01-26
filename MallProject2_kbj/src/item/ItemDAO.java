package item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import cart.CartDAO;
import util.Util;

public class ItemDAO {
	private ItemDAO() {
	}

	private static ItemDAO instance = new ItemDAO();

	public static ItemDAO getInstance() {
		return instance;
	}

	private ArrayList<Item> ilist;
	private int cNum;
	private TreeSet<String> categoryset;
	private CartDAO cDao;

	public void init() {
		ilist = new ArrayList<>();
		cNum = 100;
		categoryset = new TreeSet<>();
		sampleItem();
		cDao = CartDAO.getInstance();
	}

	/** 상품 번호부여 */
	public int Num() {
		cNum++;
		return cNum;
	}

	/** 아이템추가시 중복 방지 */
	public boolean checkIname(String name) {
		for (Item m : ilist) {
			if (name.equals(m.getName())) {
				return true;
			}
		}
		return false;
	}

	/** 아이템 0개 체크 */
	public boolean checkSize() {
		if (ilist.size() == 0) {
			return true;
		}
		return false;
	}

	/** 카테고리이름 어레이리스트 */
	public ArrayList<String> setCategoryList() {
		for (int i = 0; i < ilist.size(); i++) {
			categoryset.add(ilist.get(i).getCategoryName());
		}
		ArrayList<String> cglist = new ArrayList<>();
		Iterator<String> iter = categoryset.iterator();
		while (iter.hasNext()) {
			cglist.add(iter.next());
		}
		return cglist;
	}

	/** 카테고리별 아이템리스트 */
	public ArrayList<Item> selCategoryItemList(String categoryname) {
		ArrayList<Item> selCategoryItemList = new ArrayList<>();
		for (int i = 0; i < ilist.size(); i++) {
			if (ilist.get(i).getCategoryName().equals(categoryname)) {
				selCategoryItemList.add(ilist.get(i));
			}
		}
		return selCategoryItemList;
	}

	/** 상품리스트에 넣기 */
	public void insertIlist(Item i) {
		ilist.add(i);
	}

	/** 상품리스트에서 빼기 */
	public void deleteIlist(int idx) {
		ilist.remove(idx);
	}

	/** 상품 샘플데이터 */
	public void sampleItem() {
		Item i = new Item(Num(), "음료", "콜라", 1000);
		insertIlist(i);
		i = new Item(Num(), "음료", "사이다", 2000);
		insertIlist(i);
		i = new Item(Num(), "과자", "나초", 3000);
		insertIlist(i);
		i = new Item(Num(), "과자", "새우깡", 4000);
		insertIlist(i);
		i = new Item(Num(), "과일", "키위", 5000);
		insertIlist(i);
		i = new Item(Num(), "과일", "딸기", 6000);
		insertIlist(i);
	}

	/** admin 상품관리 [1]상품 전체출력 */
	public void printAdminItem() {
		System.out.println("\n[전체 상품목록]");
		for (Item i : ilist) {
			System.out.println(i.toString());
		}
	}

	/** admin 상품관리 [2]상품추가 */
	public void addAdminItem() {
		System.out.println("\n[상품추가]");
		while (true) {
			System.out.print("# NAME ->  ");
			String name = Util.sc.next();
			if (checkIname(name) == true) {
				System.out.println("[중복된 상품이름]\n다른 상품이름을 사용해주세요.");
				continue;
			}
			System.out.print("# CategoryName ->  ");
			String cName = Util.sc.next();
			// System.out.print("# Price -> ");
			int price = Util.getPrice();
			Item i = new Item(Num(), cName, name, price);
			insertIlist(i);
			System.out.printf("\n[%s 상품추가 완료]\n", name);
			break;
		}
	}

	/** admin 상품관리 [3]상품삭제 */
	public void deleteAdminItem() {
		System.out.println("\n[상품삭제]");
		if (checkSize() == true) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		while (true) {
			System.out.print("# Name ->  ");
			String name = Util.sc.next();
			if (checkIname(name) == false) {
				System.out.println("[목록에 없는 상품]\n상품이름을 확인해주세요.");
				continue;
			}
			int idx = -1;
			for (int i = 0; i < ilist.size(); i++) {
				if (name.equals(ilist.get(i).getName())) {
					idx = i;
				}
			}
			deleteIlist(idx);
			System.out.printf("\n[%s 상품삭제 완료]\n", name);
			break;
		}
	}

	/** member main [1]쇼핑 */
	public void shoppingMember() {
		ArrayList<String> category = setCategoryList();
		while (true) {
			System.out.println("\n[카테고리]\n[0]뒤로가기");
			for (int i = 0; i < category.size(); i++) {
				System.out.printf("[%d]%s\n", i + 1, category.get(i));
			}
			int sel = Util.getValue(0, category.size()) - 1;
			if (sel == -1) {
				break;
			} else if (sel >= 0 && sel <= category.size() - 1) {
				while (true) {
					System.out.println("\n[0]뒤로가기");
					ArrayList<Item> list = selCategoryItemList(category.get(sel));
					for (int i = 0; i < list.size(); i++) {
						System.out.println(i + 1 + ") " + list.get(i).toString());
					}
					int choice = Util.getValue(0, list.size()) - 1;
					if (choice == -1) {
						break;
					} else if (choice >= 0 && choice <= list.size() - 1) {
						Item i = list.get(choice);
						cDao.insertClist(i);
					}
				}
			}
		}
	}
}
