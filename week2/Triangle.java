package triangle;

import java.util.Scanner;

public class triangle {
	public static void main(String[] args) {
		int n;

		System.out.println("Please input the number of lines");
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		for (int i = 1; i <= n; i++) { // 第一行
			for (int j = 0; j < n - i; j++) { // 打空格
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("* "); // 打*
			}
			System.out.println();
		}
	}
}
