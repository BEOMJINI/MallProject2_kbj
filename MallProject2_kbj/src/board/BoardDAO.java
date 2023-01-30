package board;

import java.util.ArrayList;

import controller.MallController;
import util.Util;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	private ArrayList<Board> blist;
	private MallController mCon;
	
	public void init() {
		blist = new ArrayList<>();
		mCon = MallController.getInstance();
		sampleBoard();
	}

	public void printBoard() {
		while (true) {
			System.out.println("\n[게시판 목록]");
			if (blist.size() == 0) {
				System.out.println("게시글이 없습니다.");
			} else {
				for (int i = 0; i < blist.size(); i++) {
					System.out.println(i + 1 + ") " + blist.get(i).toString());
				}
			}
			System.out.println("\n[0]뒤로가기 [1]게시글작성 [2]게시글보기");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				System.out.print("\nTitle : ");
				String t = Util.sc.next();
				String c = "";
				String con = "";
				System.out.println("Content :\n'작성완료'을 입력하시면 작성이 완료됩니다.");
				while (true) {
					c = Util.sc.nextLine();
					if (c.equals("작성완료")) {
						break;
					}
					con += c + "\n";
				}
				blist.add(new Board(t, con,mCon.getLoginId()));
			} else if (sel == 2) {
				if (blist.size() == 0) {
					System.out.println("게시글이 없습니다.");
					break;
				}
				System.out.println("\n[게시글선택]\n게시글 번호로 선택해주세요.");
				int choice = Util.getValue(1, blist.size()) - 1;
				if (choice >= 0 && choice <= blist.size() - 1) {
					System.out
							.println("제목 : " + blist.get(choice).getTitle() + "\n내용 : " + blist.get(choice).getInfo());
				}
			}
		}
	}

	public void printBoard2() {
		System.out.println("\n[게시판 목록]");
		if (isBlistSize() == true) {
		} else {
			for (int i = 0; i < blist.size(); i++) {
				System.out.println(i + 1 + ") " + blist.get(i).toString());
			}
		}
	}

	public void writeBoard() {
		System.out.print("\nTitle : ");
		String t = Util.sc.next();
		String c = "";
		String con = "";
		System.out.println("Content :\n'작성완료'을 입력하시면 작성이 완료됩니다.");
		while (true) {
			c = Util.sc.nextLine();
			if (c.equals("작성완료")) {
				break;
			}
			con += c;
		}
		blist.add(new Board(t, con,mCon.getLoginId()));
	}

	public void readBoard() {
		if (isBlistSize() == true) {
			return;
		}
		System.out.println("\n[게시글선택]\n게시글 번호로 선택해주세요.");
		int choice = Util.getValue(1, blist.size()) - 1;
		if (choice >= 0 && choice <= blist.size() - 1) {
			System.out.println("제목 : " + blist.get(choice).getTitle() + "\n내용 : " + blist.get(choice).getInfo());
		}
	}

	public void addNotice() {
		System.out.print("\nTitle : ");
		String n = "[Notice]";
		String t = Util.sc.next();
		n += t;
		String c = "";
		String con = "";
		System.out.println("Content :\n'작성완료'을 입력하시면 작성이 완료됩니다.");
		while (true) {
			c = Util.sc.nextLine();
			if (c.equals("작성완료")) {
				break;
			}
			con += c;
		}
		blist.add(0,new Board(n, con,mCon.getLoginId()));
	}

	public void deleteBoard() {
		if (isBlistSize() == true) {
			return;
		}
		System.out.println("\n[게시글삭제]");
		int sel = Util.getValue(1, blist.size()) - 1;
		if (sel >= 0 && sel <= blist.size() - 1) {
			blist.remove(sel);
			System.out.println(sel + 1 + " 번 게시글 삭제 완료");
		}
	}

	public boolean isBlistSize() {
		if (blist.size() == 0) {
			System.out.println("게시글이 없습니다.");
			return true;
		}
		return false;
	}
	
	public void deleteBoard2() {
		ArrayList<Board> temp = new ArrayList<>();
		int cnt = 0;
		for(int i =0 ; i<blist.size(); i++) {
			if(mCon.getLoginId().equals(blist.get(i).getId())) {
				cnt++;
				temp.add(blist.get(i));
				blist.remove(i);
				i--;
				//System.out.println(i+1+") "+blist.get(i).toString());
			}
		}
		if(cnt == 0) {
			System.out.println("작성한 글이 없습니다.");
			return;
		}
		for(int i = 0; i<temp.size(); i++) {
			System.out.println(i+1+") "+temp.get(i).toString());
		}
		System.out.println("삭제 번호선택");
		int sel = Util.getValue(1, cnt)-1;
		temp.remove(sel);
		blist.addAll(temp);
		
//		for(int i =0 ; i<blist.size(); i++) {
//			if(mCon.getLoginId().equals(blist.get(i).getId())) {
//				blist.remove(sel);
//				//System.out.println(i+1+") "+blist.get(i).toString());
//			}
//		}
	}
	
	public void sampleBoard() {
		blist.add(new Board("MemberDeleteTest", "test", "a"));
		blist.add(new Board("AdminDeleteTest", "test", "b"));
		blist.add(new Board("ReadTest", "test", "b"));
	}

}
