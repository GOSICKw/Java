package iot.week14.tools;

import java.sql.Connection;
import java.sql.DriverManager;

//该类封装驱动的加载 连接的建立 连接释放 、关闭
public class DbConnection {
	private Connection con;
	//关心的是连接对象
	public DbConnection(){
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/wtu?useUnicode=true&characterEncoding=utf-8";
		String userName= "root";
		String password= "990428";
		try{
			Class.forName(className);
			con = DriverManager.getConnection(url,userName,password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Connection getcon(){
		return con;
	}
	
	public void close(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
