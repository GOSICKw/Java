package Work2;

import java.util.Scanner;

public class Frame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 1.定义变量
		double Length, Width, Area;// 画的长&宽&面积

		int Frame; // 框架
		int Colour; // 画是否上色
		int Crown; // 镶嵌的王冠数量

		double cost = 0;// 总价钱

		// 2.为变量赋值
		System.out.println("请输入画的长和宽");
		System.out.print("长:");
		Length = scan.nextDouble();
		System.out.print("宽:");
		Width = scan.nextDouble();

		System.out.println("请选择框架的类型（0:regular,1:fancy）");
		System.out.print("选择：");
		Frame = scan.nextInt();

		System.out.println("是否对框架上色（0：否，1：是）");
		System.out.print("请选择：");
		Colour = scan.nextInt();

		System.out.print("请输入放置王冠的数量：");
		Crown = scan.nextInt();

		// 3.运算处理
		Area = Length * Width;// 框架面积

		cost += Area * (0.02 + 0.07);// 硬纸板和玻璃费用

		if (Frame == 1) {
			cost += (Length + Width) * 2 * 0.25;// 高档框架
		} else {
			cost += (Length + Width) * 2 * 0.15;// 普通框架
		}

		if (Colour == 1) { // 上色的价钱
			cost += (Length + Width) * 2 * 0.1;
		}

		cost += Crown * 0.35; // 王冠的价钱

		// 4.数据输出
		System.out.println("框架的费用为：" + cost);
	}
}
