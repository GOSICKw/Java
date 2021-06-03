package week12;

public class Result {
	private String Coursename;
	private float avg;
	public Result() {
		super();
	}
	public Result(String coursename, float avg) {
		super();
		Coursename = coursename;
		this.avg = avg;
	}
	public String getCoursename() {
		return Coursename;
	}
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return Coursename+"\t"+avg;
	}
	

}
