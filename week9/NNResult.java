package week9.vo;

public class NNResult {
	private String Lname;
	private int count;
	private float score;
	public NNResult(String lname, int count,float score) {
		super();
		Lname = lname;
		this.count = count;
		this.score = score;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public NNResult() {
		super();
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String toString() {
		return Lname+"\t"+score/count;
	}

}
