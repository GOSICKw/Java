package Work1;

import java.util.Scanner;

public class Machine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//1.定义变量
		int Cent5Coins = 0;
		int Cent10Coins = 0;
		int Cent20Coins = 0;
		int Cent50Coins = 0;
		
		double money1,money2;
		
		//2.为变量赋值
		System.out.println("请输入金额的大小:");
		money1 = scan.nextDouble();
		money2 = money1;
		
		//3.运算处理
		Cent50Coins = (int) (money1 / 0.5);
		money1 = money1 - Cent50Coins * 0.5;
		
		Cent20Coins = (int) (money1 / 0.2);
		money1 = money1 - Cent20Coins * 0.2;
		
		Cent10Coins = (int) (money1 / 0.1);
		money1 = money1 - Cent10Coins * 0.1;
		
		Cent5Coins = (int) (money1 / (0.05));
		
		//4.数据输出
		System.out.println(money2+ "美元可以分为：");
		System.out.println(Cent50Coins + "*50cent");
		System.out.println(Cent20Coins + "*20cent");
		System.out.println(Cent10Coins + "*10cent");
		System.out.println(Cent5Coins + "*5cent");
	}
}
