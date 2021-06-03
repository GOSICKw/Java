package week12;

public class Student {
	private String no;
	private String name;
	private String gender;
	private float avg;
	public Student() {
		super();
	}
	public Student(String no, String name, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
	}
	public Student(String no, String name, String gender, float avg) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.avg = avg;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return no+"\t"+name+"\t"+gender+"\t"+avg;
	}
	

}
