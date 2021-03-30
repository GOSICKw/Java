package Address;

public class Address {
	private String country;
	private String province;
	private String city;
	private String street;
	private int postCode;

	public Address(String country, String province,
			String city, String street, int postCode) {
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public void displayAddress() {
		String info = "";
		info = "country="+ this.country + ",province=" + this.province + ",city=" + this.city + ",street="
				+ this.street+",postCode="+this.postCode;
		System.out.println(info);
	}
}
public class AddressDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address add1 = new Address("中国", "湖北省", "武汉市", "江夏大道",430200);
		add1.displayAddress();
	}

}
