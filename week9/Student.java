package week9.vo;

public class Student {
	private String sno;
	private String name;
	private String gender;
	private String province;
	public Student(String sno, String name, String gender, String province) {
		super();
		this.sno = sno;
		this.name = name;
		this.gender = gender;
		this.province = province;
	}
	public Student() {
		super();
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	

}
