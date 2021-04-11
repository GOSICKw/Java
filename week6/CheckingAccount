package Bank;

public class CheckingAccount extends BankAccount {
	private float serviceFee;

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(String accountNum, float balance, float serviceFee) {
		super(accountNum, balance);
		this.serviceFee = serviceFee;
	}

	public float getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(float serviceFee) {
		this.serviceFee = serviceFee;
	}

	@Override
	public String toString() {
		return super.toString() + ",fee=" + this.serviceFee;
	}

	// 收取信用卡的费用
	public void assessFee() {
		super.setBalance(super.getBalance() - this.serviceFee);

	}

}
