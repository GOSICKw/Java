package WeekTest3;
import java.util.Scanner;

public class Numbers {
	public static int First, Second, flag = 0;

	public static void main(String[] args) {
		int choose = menu(args);
		while (choose != 7) {
			switch (choose) {
			case 1:
				input();
				break;
			case 2:
				if (flag == 0) {
					System.out.println("Please input two integers before performing this function");
					break;
					}
				OutputAllOdd();
				break;
			case 3:
				if (flag == 0) {
					System.out.println("Please input two integers before performing this function");
					break;
					}
				OutputAllEvenSum();
				break;
			case 4:
				if (flag == 0) {
					System.out.println("Please input two integers before performing this function");
					break;
					}
				OutputSquare();
				break;
			case 5:
				if (flag == 0) {
					System.out.println("Please input two integers before performing this function");
					break;
				}
				OutputAllOddSquareSum();
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("Invalid input, reselect!");
			}
			choose = menu(args);
		}
		System.out.println("Program exited, welcome to use again!");

	}

	/*
	 * Complete the display of the menu and return the user's input selection(1-7)
	 */
	public static int menu(String[] args) {
		int choice = 0;
		System.out.println("======Number Menu======");
		System.out.println("1.Input Two Number(First<Second)");
		System.out.println("2.Output All Odd");
		System.out.println("3.Output All Even Sum");
		System.out.println("4.Output 1~10 Plus 1~10 Square ");
		System.out.println("5.Output All Odd Square Sum");
		System.out.println("6.Output All Capital Letter(ASCII Code)");
		System.out.println("7.Exit");
		System.out.println("Please choose(1-7):");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}

	public static void input() {
		flag = 1;
		Scanner scan = new Scanner(System.in);
		boolean ok = false;
		while (!ok) {
			System.out.println("Please Input First Integer:");
			First = scan.nextInt();
			System.out.println("Please Input Second Integer:");
			Second = scan.nextInt();
			if (First < Second) {
				ok = true;
			} else {
				System.out.println("The first integer is not bigger than the second integer, please re-input!");
			}
		}
	}

	public static void OutputAllOdd() {
		System.out.println("Output All the odd numbers between them are:");
		for (int i = First; i <= Second; i++) {
			if (i % 2 != 0) 
				System.out.print(" " + i);
				}
		System.out.println("");
	}

	public static void OutputAllEvenSum() {
		System.out.println(" Output All the even numbers sum between them :");
		int sum = 0;
		for (int i = First; i <= Second; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
			System.out.println("All the even numbers sum:" + sum);
		}
	}

	public static void OutputSquare() {
		System.out.println("1~10:");
		for (int i = 1; i <= 10; i++) 
		{
		System.out.println("" +i);
		}
		System.out.println("1~10 Square Sum：");
		for (int i = 1; i <= 10; i++) {
			System.out.println(Math.pow(i, 2) + " ");
		}
	}
	public static void OutputAllOddSquareSum() {
		int sum = 0;
		for (int i = First; i <= Second; i++) {
			if (i % 2 != 0) {
				sum += Math.pow(i, 2);
			}
		}
		System.out.println("Odd number Sum：" + sum);
	}
}
