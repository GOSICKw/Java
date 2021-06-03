package iot.week14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import iot.week14.tools.DbConnection;
import iot.week14.vo.Student;

public class StudentDao {
	//按关键字进行查询
	static Scanner scan = new Scanner(System.in);
	public static Student get(String id){
		Student stu = null;
		DbConnection db = new DbConnection();
		Connection con = db.getcon();
		String sql = "select * from t_student where id = ?";
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				stu = new Student(rs.getString("id"),rs.getString("name"),
						rs.getString("birth"),rs.getString("gender"),
						rs.getFloat("score"));
			}
		}catch(Exception e){
			e.printStackTrace();
			db.close();
		}
		return stu;
	}
	
	//得到所有学生的信息
	public void displayAllInfo(){
		DbConnection db = new DbConnection();
		Connection con = db.getcon();
		String sql = "select * from t_student";
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Student stu = new Student(rs.getString("id"),rs.getString("name"),
						rs.getString("birth"),rs.getString("gender"),
						rs.getFloat("score"));
				System.out.println(stu.toString());
				
			}
		}catch(Exception e){
			e.printStackTrace();
			db.close();
		}
	}
	
	
	//按照指定的字段进行查询 存放结果在集合中
	public ArrayList<Student> query(String fieldName,String value,String flux){
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		Student stu = null;
		DbConnection db = new DbConnection();
		Connection con = db.getcon();		
		String sql = "";
		String condition = "";
		if(flux.equals("y")){
			sql =  "select * from t_student where " + fieldName +" like ?";
			condition = "%"+value+"%";
		}
		else{
			sql = "select * from t_student where " + fieldName +"=?";
			condition = value;
		}
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, condition);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				stu = new Student(rs.getString("id"),rs.getString("name"),
						rs.getString("birth"),rs.getString("gender"),
						rs.getFloat("score"));
				stuList.add(stu);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			db.close();
		}
			
		return stuList;
	}
	//键盘中输入若干个学生数据，存放在集合中
	public ArrayList<Student> readStuFromKeyboard(){
		ArrayList<Student> stuList = new ArrayList<Student>();
		int count;
		String info;
		System.out.println("输入学生信息-----格式（'1001,小红,2001-05-18,男,89.2'），以“end”为结束标识:");
		info = scan.nextLine();
		while(!info.equals("end")){
			String s[] = info.split(",|，");
			if(get(s[0]) != null){
				System.out.println("数据库中已经存在该学号，请重新输入！");
			}
			else{
			Student stu = new Student(s[0],s[1],s[2],s[3],Float.parseFloat(s[4]));
			stuList.add(stu);
			}
			info = scan.nextLine();
		}
		
		return stuList;
	}
	//将学生对象插入到数据库中 返回成功插入记录的条数
	public int insert(ArrayList<Student> list){
		int iRet = 0;
		DbConnection db = new DbConnection();
		Connection con = db.getcon();
		String sql = "insert into t_student(id,name,birth,gender,score)"
				+ "values(?,?,?,?,?)";
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			for(int i=0;i<list.size();i++){
				Student stu = list.get(i);
				pst.setString(1, stu.getId());
				pst.setString(2, stu.getName());
				pst.setString(3, stu.getBirth());
				pst.setString(4, stu.getGender());
				pst.setFloat(5,stu.getScore());
				iRet += pst.executeUpdate();
			}	

		}catch(Exception e){
			e.printStackTrace();
			db.close();
		}
		return iRet;
	}
	//删除指定关键字的记录 返回成功删除记录的条数
	public int delete(String id){
		int iRet = 0;
		
		DbConnection db = new DbConnection();
		Connection con = db.getcon();
		String sql = "delete from t_student where id = ?";
		try{
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			iRet = pst.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
			db.close();
		}
		return iRet;
	}
	
	public Student updateFromKeyboard(){
		System.out.print("请输入要修改学生的学号：");
		String id = scan.nextLine();
		Student stu  = get(id);
		if(stu==null){
			System.out.println("数据库中无该学生对应的学号!");
		}
		else{
			System.out.println("原id为："+stu.getId()+",新的id号为:(不修改直接按回车)");
			String nid = scan.nextLine();
			stu.setId(nid);
			System.out.println("原姓名为："+stu.getName()+",新的姓名为:(不修改直接按回车)");
			String nName = scan.nextLine();
			stu.setName(nName);
			System.out.println("原生日为："+stu.getBirth()+",新的生日为:(不修改直接按回车)");
			String nbirth = scan.nextLine();
			stu.setBirth(nbirth);
			System.out.println("原性别为："+stu.getGender()+",新的性别为:(不修改直接按回车)");
			String ngender = scan.nextLine();
			stu.setGender(ngender);
			System.out.println("原分数为："+stu.getScore()+",新的分数为:(不修改输入-1)");
			Float nscore = scan.nextFloat();
			stu.setScore(nscore);
		}
		return stu;
	}
	
	public int update(){
		int iRet = 0;
		Student stu = updateFromKeyboard();
		System.out.println(stu.toString());
		DbConnection db = new DbConnection();
		Connection con = db.getcon();
		StringBuffer sql = new StringBuffer("update t_student set ");
		
		if(!stu.getId().equals("")) {
			sql.append("id = '"+stu.getId()+"'");
		}
		if(!stu.getName().equals("")) {
			sql.append("name = '"+stu.getName()+"'");
		}
		if(!stu.getBirth().equals("")) {
			sql.append("bitrh = '"+stu.getBirth()+"'");
		}
		if(!stu.getGender().equals("")) {
			sql.append("gender = '"+stu.getGender()+"'");
		}
		if(!(stu.getScore()==-1f)) {
			sql.append("score = '"+stu.getScore()+"'");
		}
		
		String Nsql = sql.toString();
		
		try {
			PreparedStatement pst = con.prepareStatement(Nsql);
			iRet = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return iRet;
	}
	
}
