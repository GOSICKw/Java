package Bank;

public class BankAccount {
	private String accountNum;
	private float balance;
	public BankAccount() {
		super();
	}
	public BankAccount(String accountNum, float balance) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		String info;
		info="";
		info+="accountNum="+this.accountNum+",balance="+this.balance;
		return info;
	}
	
	
}
