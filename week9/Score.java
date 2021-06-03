package week9.vo;

public class Score {
	private String  sno;
	private String LectureName;
	private float score;
	public Score(String sno, String lectureName, float score) {
		super();
		this.sno = sno;
		LectureName = lectureName;
		this.score = score;
	}
	public Score() {
		super();
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getLectureName() {
		return LectureName;
	}
	public void setLectureName(String lectureName) {
		LectureName = lectureName;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
