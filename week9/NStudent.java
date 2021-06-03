package week9.vo;

public class NStudent {
	private String sno;
	private String name;
	private String gender;
	private float avescore;
	public NStudent(String sno, String name, String gender) {
		super();
		this.sno = sno;
		this.name = name;
		this.gender = gender;
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
	public float getScore() {
		return avescore;
	}
	public void setScore(float score) {
		this.avescore = score;
	}
	public String toString() {
		return sno+"\t"+name+"\t"+gender+"\t"+avescore+"\t";
	}

}
