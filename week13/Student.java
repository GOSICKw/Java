package Week13;

public class Student {
	private String Id;
	private String Name;
	private String Gender;
	private String Birth;
	private double score;

	public Student() {
		super();
	}

	public Student(String id, String name, String gender, String birth, double score) {
		super();
		Id = id;
		Name = name;
		Gender = gender;
		Birth = birth;
		this.score = score;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getBirth() {
		return Birth;
	}

	public void setBirth(String birth) {
		Birth = birth;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Gender=" + Gender + ", Birth=" + Birth + ", score=" + score
				+ "]";
	}

}
