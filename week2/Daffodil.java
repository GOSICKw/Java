package Daffodil;

import java.util.Scanner;

public class Daffodil{
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入水仙花数据的位数:");
		int weishu=scan.nextInt();
		for(int number = (int) Math.pow(10, weishu-1);
			number<Math.pow(10, weishu);number++){
			int sum = 0;
			int data = number;
			while(data!=0) {
				int wei = data%10;
				sum = (int) (sum+Math.pow(wei, weishu));
				//System.out.println(wei);
				data = data/10;
			}
			//System.out.println(sum);
			if(sum == number)
			{
				System.out.println(number);
			}
		}
	}
}
