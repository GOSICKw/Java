package Bank;

import java.util.Scanner;

public class Driver {
	private static final String Oksa = null;
	public static Customer customer = null;
	public static boolean OKca = false;
	public static boolean OKsa = false;

	public static void main(String[] arags) {
		int choice = menu();
		while (choice != 8) {
			switch (choice) {
			case 1:
				create();
				break;
			case 2:
				save();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				consume();
				break;
			case 5:
				repay();
				break;
			case 6:
				settle();
				break;
			case 7:
				banlance();
				break;
			default:
				System.out.println("无效的选择!");
			}
			choice = menu();
		}
		System.out.println("欢迎下次使用!");
	}

	public static int menu() {
		int choice = 0;
		System.out.println("==================欢迎使用银行管理系统==================");
		System.out.println("1.开户create");
		System.out.println("2.存款save");
		System.out.println("3.取款withdraw");
		System.out.println("4.消费consume");
		System.out.println("5.还款reply");
		System.out.println("6.银行结算settle");
		System.out.println("7.查询余额balance");
		System.out.println("8.退出exit");
		System.out.println("请选择(1-8):");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}

	public static int subMenu() {
		int choice = 0;
		System.out.println("========请选择开卡类型========");
		System.out.println("1.信用卡checkingAccount");
		System.out.println("2.存储卡savingAccount");
		System.out.println("3.返回exit");
		System.out.println("请选择(1-3):");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}

	// 开户
	public static void create() {
		int choice = subMenu();
		while (choice != 3) {
			switch (choice) {
			case 1:
				createCheckingAccount();
				break;
			case 2:
				createSavingAccount();
				break;
			default:
				System.out.println("输入有误,请重新输入!");
			}
			choice = subMenu();
		}
	}

	public static void createCheckingAccount() {
		if (OKca) {
			System.out.println("已经拥有存储卡账户！");
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入身份证号:");
			String ssn = scan.next();
			System.out.println("请输入姓名:");
			String name = scan.next();
			System.out.println("请输入信用卡的卡号:");
			String accountNum = scan.next();
			System.out.println("请输入信用卡的年费:");
			float fee = scan.nextFloat();

			CheckingAccount ca = new CheckingAccount(accountNum, 0, fee);
			if (customer == null) {
				customer = new Customer(ssn, name, ca, null);
				OKca = true;
			} else {
				customer = new Customer(ssn, name, ca, customer.getSa());
				OKca = true;
			}
		}
	}

	public static void createSavingAccount() {
		Scanner scan = new Scanner(System.in);
		if (OKsa) {
			System.out.println("已经拥有信用卡账户！");
		} else {
			System.out.println("请输入身份证号:");
			String ssn = scan.next();
			System.out.println("请输入姓名:");
			String name = scan.next();
			System.out.println("请输入存储卡的卡号:");
			String accountNum = scan.next();
			System.out.println("请输入存储卡的利率:");
			float interestRate = scan.nextFloat();
			SavingAccount sa = new SavingAccount(accountNum, 0, interestRate);
			if (customer == null) {
				customer = new Customer(ssn, name, null, sa);
				OKsa = true;
			} else {
				customer = new Customer(ssn, name, customer.getCa(), sa);
				OKsa = true;
			}
		}
	}

	public static void save() {
		if (!OKsa) {
			System.out.println("没有检测到账户信息&存储卡,请先执行第一步开户!");
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要存钱的金额:");
		float money = scan.nextFloat();
		customer.getSa().setBalance(customer.getSa().getBalance() + money);
		System.out.println("存钱成功,余额为:" + customer.getSa().getBalance());
	}

	public static void withdraw() {
		if (!OKsa) {
			System.out.println("没有检测到账户信息&存储卡,请先执行第一步开户!");
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要取钱的金额");
		float money = scan.nextFloat();
		if (customer.getSa().getBalance() < money)
			System.out.println("您的余额不足,请您重新输入:");
		else {
			customer.getSa().setBalance(customer.getSa().getBalance() - money);
			System.out.println("取钱成功,余额为:" + customer.getSa().getBalance());
		}

	}

	public static void consume() {
		if (!OKca) {
			System.out.println("没有检测到账户信息&信用卡,请先执行第一步开户!");
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入消费的金额");
		float money = scan.nextFloat();
		customer.getCa().setBalance(customer.getCa().getBalance() - money);
		System.out.println("消费成功,余额为:" + customer.getCa().getBalance());
	}

	public static void repay() {
		if (!OKca) {
			System.out.println("没有检测到账户信息&信用卡,请先执行第一步开户!");
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入还款的金额");
		float money = scan.nextFloat();
		customer.getCa().setBalance(customer.getCa().getBalance() + money);
		System.out.println("还款成功,余额为:" + customer.getCa().getBalance());
	}

	public static void settle() {
		Scanner scan = new Scanner(System.in);
		if (customer == null) {
			System.out.println("没有检测到账户信息,请先执行第一步开户!");
			return;
		} else if (customer.getCa() != null && customer.getSa() == null) {
			customer.getCa().assessFee();
			System.out.println("信用卡已结算!");
		} else if (customer.getSa() != null && customer.getCa() == null) {
			customer.getSa().payInterest();
			System.out.println("存储卡已结算!");
		} else {
			customer.getCa().assessFee();
			customer.getSa().payInterest();
			System.out.println("信用卡&存储卡已结算!");
		}

	}

	public static void banlance() {
		if (customer == null) {
			System.out.println("没有检测到账户信息,请先执行第一步开户!");
			return;
		}
		else if (customer.getCa() != null && customer.getSa() == null) {
			System.out.println("信用卡余额:" + customer.getCa().getBalance());
		}
		else if (customer.getSa() != null && customer.getCa() == null) {
			System.out.println("存储卡余额:" + customer.getSa().getBalance());
		}else {
		System.out.println("信用卡余额:" + customer.getCa().getBalance());
		System.out.println("存储卡余额:" + customer.getSa().getBalance());
		}
	}

}
