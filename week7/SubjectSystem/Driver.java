package SubjectSystem;

import java.util.Scanner;

public class Driver {
	private static Enrollment enrollment;
	public static int count = 0;

	public static void main(String[] args) {
		int choice = menu();
		while (choice != 5) {
			switch (choice) {
			case 1:
				createSubject();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				withDraw();
				break;
			case 4:
				printDetail();
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
		System.out.println("==================欢迎使用WTU选课系统==================");
		System.out.println("1.创建课程createSubject");
		System.out.println("2.选课addStudent");
		System.out.println("3.退课withDraw");
		System.out.println("4.打印printDetail");
		System.out.println("5.退出exit");
		System.out.println("请选择(1-5):");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}

	public static void createSubject() {
		Scanner scan = new Scanner(System.in);
		if (enrollment != null) {
			System.out.println("课程已经创建&存在,是否重新创建(y/n):");
			String choice = scan.next();
			if (choice.equalsIgnoreCase("n")) {
				return;
			}
		}
		System.out.println("请依次输入课程的课程号subID:");
		String subID = scan.next();
		System.out.println("请依次输入课程的名称subName:");
		String subName = scan.next();
		System.out.println("请依次输入课程的(最大)人数maxNum:");
		int maxNum = scan.nextInt();

		Subject sub = new Subject(subID, subName, maxNum);
		enrollment = new Enrollment(sub);

		System.out.println("创建课程成功,信息如下:");
		System.out.println(sub.toString());
	}

	public static void addStudent() {
		if (enrollment == null) {
			System.out.println("没有检测到课程的信息,请先执行创建课程的步骤!");
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("请先输入正确的选课学生的学生号id:");
		String id = scan.next();
		System.out.println("请先输入正确的选课学生的姓名name:");
		String name = scan.next();
		Student student = new Student(id, name);
		if (enrollment.add(student)) {
			System.out.println("恭喜您,已经成功完成选课!");
			System.out.println("目前的选课信息如下:");
			System.out.println(enrollment.toString());
		}
		else {
			System.out.println("很遗憾已达到最大人数,您未能成功选课!");
		}
	}

	public static void withDraw() {
		if (enrollment == null) {
			System.out.println("没有检测到课程的信息,请先执行创建课程的步骤!");
			return;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入退选学生的学生号id:");
		int id = scan.nextInt();
		if (id != -1) {
			if (enrollment.remove(id)) {
				System.out.println("退选成功!新的选课信息如下:");
				System.out.println(enrollment.toString());
			} else {
				System.out.println("学号为" + id + "的学生并没有选课!");
			}
		}
	}

	public static void printDetail() {
		if (enrollment == null) {
			System.out.println("没有检测到课程的信息,请先执行创建课程的步骤!");
			return;
		}
		System.out.println(enrollment.toString());
	}

}
