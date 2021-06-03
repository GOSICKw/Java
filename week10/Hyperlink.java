package week10;

public class Hyperlink {
	private String name;
	private String address;
	public Hyperlink(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Hyperlink() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return this.name+"\t"+this.address+"\t";
	}
	

}
