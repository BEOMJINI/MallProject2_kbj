package item;

public class Item {
	private int num;
	private String categoryName;
	private String name;
	private int price;
	public Item(int num, String categoryName, String name, int price) {
		super();
		this.num = num;
		this.categoryName = categoryName;
		this.name = name;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		String s = String.format("[NUM]%-6d [CATEGORY]%10s [NAME]%10s [PRICE]%10d", num, categoryName, name, price);
		return s;
	}
	
	
}
