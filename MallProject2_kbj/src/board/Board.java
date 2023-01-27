package board;

public class Board {
	private String title;
	private String info;
	private String id;
	@Override
	public String toString() {
		return "[Title] " + title + " [Writer]" + id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Board(String title, String info,String id) {
		super();
		this.title = title;
		this.info = info;
		this.id = id;
	}
}
