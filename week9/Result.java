package week9.vo;

public class Result {
 	private int salesNum=0;     //销售笔数      
	private int salesVol=0;       //销售数量
	private float allmoney=0;         //销售金额
	public int getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(int salesNum) {
		this.salesNum = salesNum;
	}
	public int getSalesVol() {
		return salesVol;
	}
	public void setSalesVol(int salesVol) {
		this.salesVol = salesVol;
	}
	public float getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(float allmoney) {
		this.allmoney = allmoney;
	}
	public Result() {
		super();
	}
	public Result(int salesNum, int salesVol, float allmoney) {
		super();
		this.salesNum = salesNum;
		this.salesVol = salesVol;
		this.allmoney = allmoney;
	}
	@Override
	public String toString() {
		return "总计：\t销售笔数"+salesNum+ ",销售数量 "+salesVol+",销售金额 "+allmoney;
	}
	

}
