package Week13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class mis {
	public static void main(String[] args) {
		try {
			// 1.加载驱动
			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);

			// 2.建立与数据库的链接
			String url = "jdbc:mysql://localhost:3306/ygw? useUnicode=true & characterEncoding=utf-8 & serverTimezone=UTC";
			String userName = "root";
			String password = "ldxgn2426";
			Connection con = DriverManager.getConnection(url, userName, password);

			// 3.创建更新语句
			String sql = "insert into tstudent(id,name,gender,birth,score) values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);

			// 4.执行语句，输入数据，end结束
			System.out.println("请依次输入学号、姓名、性别、出生日期、成绩（输出“end”结束输入）");
			Scanner scan = new Scanner(System.in);
			String id = scan.next();
			while (!id.equals("end")) {
				String name = scan.next();
				String gender = scan.next();
				String birth = scan.next();
				double score = scan.nextDouble();
				pst.setString(1, id);
				pst.setString(2, name);
				pst.setString(3, gender);
				pst.setString(4, birth);
				pst.setDouble(5, score);
				pst.executeUpdate();

				id = scan.next();
			}

			// 5.查询返回结果
			String sql1 = "select * from tstudent";
			PreparedStatement pst1 = con.prepareStatement(sql1);
			ResultSet rs = pst1.executeQuery();
			System.out.println("学号\t姓名\t性别\t出生日期\t成绩");
			while (rs.next()) {
				String Id = rs.getString("id");
				String Name = rs.getString("name");
				String Gender = rs.getString("gender");
				String Birth = rs.getString("birth");
				double Score = rs.getDouble("score");
				System.out.println(Id + "\t" + Name + "\t" + Gender + "\t" + Birth + "\t" + Score);
			}

			// 6.输入学号，返回相应结果
			System.out.println("请输入学号，查询学生相关信息：");
			String idNum = scan.next();
			String sql2 = "select * from tstudent where id=?";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst2.setString(1, idNum);
			ResultSet rs2 = pst2.executeQuery();
			while (rs2.next()) {
				String Id = rs2.getString("id");
				String Name = rs2.getString("name");
				String Gender = rs2.getString("gender");
				String Birth = rs2.getString("birth");
				double Score = rs2.getDouble("score");
				System.out.println(Id + "\t" + Name + "\t" + Gender + "\t" + Birth + "\t" + Score);
			}

			// 关闭连接
			rs.close();
			pst.close();
			pst1.close();
			rs2.close();
			pst2.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
