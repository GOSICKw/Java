package week10;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validate val = new Validate();
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入一个用户名：");
		String s = scan.nextLine();
		while(!val.isusername(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个密码：");
		s = scan.nextLine();
		while(!val.ispassword(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个手机号码：");
		s = scan.nextLine();
		while(!val.isshouphoneNum(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个电话号码：");
		s = scan.nextLine();
		while(!val.isguphoneNum(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个QQ号码：");
		s = scan.nextLine();
		while(!val.isQQNumber(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个身份证号：");
		s = scan.nextLine();
		while(!val.isID(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个邮政编码：");
		s = scan.nextLine();
		while(!val.ispostCode(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个邮箱地址：");
		s = scan.nextLine();
		while(!val.isEmail(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个网络地址：");
		s = scan.nextLine();
		while(!val.isWebsit(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个出生日期：");
		s = scan.nextLine();
		while(!val.isbirthday(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");
		
		System.out.print("请输入一个中文名：");
		s = scan.nextLine();
		while(!val.ischineseName(s)) {
			System.out.println("格式有误,请重新输入");
			s = scan.nextLine();
		}
		System.out.println("输入正确");

		
	}
}
