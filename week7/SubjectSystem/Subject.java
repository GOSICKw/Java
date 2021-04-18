package SubjectSystem;

public class Subject {
	private String subID;
	private String subName;
	private int maxNum;

	public Subject(String subID, String subName, int maxNum) {
		super();
		this.subID = subID;
		this.subName = subName;
		this.maxNum = maxNum;
	}

	public String getSubID() {
		return subID;
	}

	public void setSubID(String subID) {
		this.subID = subID;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	@Override
	public String toString() {
		return "课程ID:" + subID + ",课程名称Name=" + subName + ",最大人数MaxPerson=" + maxNum;
	}

}
