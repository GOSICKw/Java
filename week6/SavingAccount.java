package Bank;

public class SavingAccount extends BankAccount {
	private float interestRate;

	public SavingAccount() {
		super();
	}

	public SavingAccount(String accountNum, float balance, float interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public String toString() {
		return super.toString() + "rate=" + this.interestRate;
	}

	// 银行付利息
	public void payInterest() {
		super.setBalance(super.getBalance() * (1 + this.interestRate));
	}

}
