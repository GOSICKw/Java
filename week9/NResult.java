package week9.vo;

public class NResult {
	private String province;
	private int count;
	private String names;
	public NResult() {
		super();
	}
	public NResult(String province, int count, String names) {
		super();
		this.province = province;
		this.count = count;
		this.names = names;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String toString() {
		return province+": "+count+"ÈË "+"("+names+")";
	}
	

}
