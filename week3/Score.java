package week3;

import java.util.Scanner;

public class Score {
	public static double score[];
	public static void main(String[] args) {
		int choose = menu();
		double average;
		double Highest;
		double Lowest;
		while(choose!=5)
		{
			switch(choose) {
			case 1:input();break;
			case 2:
				average = GetAverage();
				System.out.println("平均分="+average);
				break;
			case 3:
				Highest=GetHighest();
				System.out.println("最高分="+Highest);
				break;
			case 4:
				Lowest=GetLowest();
				System.out.println("最低分="+Lowest);
				break;
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
		System.out.println("======Score Menu======");
		System.out.println("1.Input");
		System.out.println("2.Average");
		System.out.println("3.Highest");
		System.out.println("4.Lowest");
		System.out.println("5.Exit");
		System.out.println("Please choose(1-5):");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}

	public static void input() {
		score = new double[5];// 使用new 为数组分配大小，指定存储空间
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.println("请输入第" + (i + 1) + "个成绩");
			boolean ok = false;
			while (!ok) {
				score[i] = scan.nextDouble();
				if (score[i] < 0 || score[i] > 100) {
					System.out.println("成绩无效,请重新输入");
				} else {
					ok = true;
				}
			}
		}
	}

	public static double GetAverage() {
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		double average;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			}
		average = sum / score.length;
		return average;
	}
	public static double GetHighest() {
		Scanner scan = new Scanner(System.in);
		double Highest = score[0];
		for (int i = 1; i < score.length; i++) {
				if(score[i]>Highest) {
					Highest=score[i];
					}
				}
		return Highest;
		
	}
	public static double GetLowest() {
		Scanner scan = new Scanner(System.in);
		double Lowest = score[0];
		for (int i = 1; i < score.length; i++) {
				if(score[i]<Lowest) {
					Lowest=score[i];
					}
				}
		return Lowest;
	}
	
}
