package week9.vo;

public class Product {
	private String sno;
	private String name;
	private float price;
	private int number;
	private float totalMoney;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Product() {
		super();
	}
	public String toString(){
		return sno+"\t"+name+"\t\t"+price+"\t\t"+number+"\t\t"+totalMoney+"\t\t";
	}
	public Product(String sno, String name, float price, int number, float totalMoney) {
		super();
		this.sno = sno;
		this.name = name;
		this.price = price;
		this.number = number;
		this.totalMoney = totalMoney;
	}


}
