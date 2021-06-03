package Week13;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class mis2_0 {
	public static void main(String[] args) {
		// 1.从excel表中读取数据
		ArrayList<Student> student = GetInfo();
		// 2.将数据写入到数据库中
		inputDataBase(student);
		// 3.查询
		System.out.println("请输入学号，查询学生相关信息(输入“end”结束查询)：");
		Scanner scan = new Scanner(System.in);
		String item = scan.next();
		while (!item.equals("end")) {
			String msg = Inquire(item);// 返回结果
			System.out.println(msg);
			System.out.println("请输入学号，查询学生相关信息(输入“end”结束查询)：");
			item = scan.next();
		}

	}

	// 1.从excel表中读取数据
	public static ArrayList<Student> GetInfo() {
		ArrayList<Student> student = new ArrayList<Student>();
		try {
			File file = new File("d:/class/mysqlData.xls");
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();

			for (int i = 1; i < rows; i++) {
				Cell cell1 = sheet.getCell(0, i);
				Cell cell2 = sheet.getCell(1, i);
				Cell cell3 = sheet.getCell(2, i);
				Cell cell4 = sheet.getCell(3, i);
				Cell cell5 = sheet.getCell(4, i);
				String id = cell1.getContents();
				String name = cell2.getContents();
				String gender = cell3.getContents();
				String birth = cell4.getContents();
				double score = Double.parseDouble(cell5.getContents());
				Student stu = new Student(id, name, gender, birth, score);
				student.add(stu);
			}

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	// 2.将数据写入到数据库中
	public static void inputDataBase(ArrayList<Student> student) {
		try {
			// 1.加载驱动
			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);
			// 2.建立连接
			String url = "jdbc:mysql://localhost:3306/ygw? useUnicode=true & characterEncoding=utf-8 & serverTimezone=UTC";
			String userName = "root";
			String password = "ldxgn2426";
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3.创建更新语句
			String sql = "insert into tstudent(id,name,gender,birth,score) values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			// 4.执行语句，将数据输入数据库中
			for (int i = 0; i < student.size(); i++) {
				Student stu = student.get(i);
				pst.setString(1, stu.getId());
				pst.setString(2, stu.getName());
				pst.setString(3, stu.getGender());
				pst.setString(4, stu.getBirth());
				pst.setDouble(5, stu.getScore());

				pst.executeUpdate();
			}

			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3.查询
	public static String Inquire(String s) {
		String msg = "";
		try {
			// 1.加载驱动
			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);
			// 2.建立连接
			String url = "jdbc:mysql://localhost:3306/ygw? useUnicode=true & characterEncoding=utf-8 &serverTimezone=UTC";
			String userName = "root";
			String password = "ldxgn2426";
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3.查询语句
			String sql = "select * from tstudent where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s);
			// 返回结果
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {// 如果返回有内容
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				double score = rs.getDouble("score");
				msg += "学号：" + id + "\n姓名:" + name + "\n性别:" + gender + "\n出生日期:" + birth + "\n成绩:" + score;
			} else {
				msg += "该学号不存在，请重新输入！";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}
}
