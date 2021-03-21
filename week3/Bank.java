package WeekTest3;
import java.util.Scanner;
public class BankMenu {
	public static void main(String[] args) {
		int choose = menu();
		while(choose!=5)
		{
			switch(choose) {
			case 1:CreateAccount();break;
			case 2:Dispose();break;
			case 3:WithDraw();break;
			case 4:Balance();break;
			default:System.out.println("输入无效，重新选择!");
			}
			choose = menu();
		}
		System.out.println("程序退出，欢迎再次使用!");
		
	}
	/*
	 *完成菜单的显示,返回用户的输入选择(1-5) 
	 */
	public static int menu() {
		int choice = 0;
		System.out.println("======WTU Bank======");
		System.out.println("1.Create Account");
		System.out.println("2.Dispose");
		System.out.println("3.WithDraw");
		System.out.println("4.Balance");
		System.out.println("5.Exit");
		System.out.println("Please choose(1-5):");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}
	public static void CreateAccount() {
		System.out.println("您选择开户！");
	}
	public static void Dispose() {
		System.out.println("您选择存款！");
	}
	public static void WithDraw() {
		System.out.println("您选择取款！");
	}
	public static void Balance() {
		System.out.println("您选择查询余额！");
	} 
}
