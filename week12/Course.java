package week12;

public class Course {
	private String no;
	private String CourseName;
	private float score;
	public Course(String no, String courseName, float score) {
		super();
		this.no = no;
		CourseName = courseName;
		this.score = score;
	}
	public Course() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return no+"\t"+CourseName+"\t"+score;
	}
	

}
