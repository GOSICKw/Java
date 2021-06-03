package week12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Dao {
	public static Scanner scan = new Scanner(System.in);
	public ArrayList<Student> inputStuInfo(){
		ArrayList<Student> stuList = new ArrayList<Student>();
		System.out.println("请输入学生基本信息，每个学生一行，输入格式为“学号，姓名，性别”，当输入“end”时结束输入");
		String stuInfo = scan.nextLine();
		while(!stuInfo.equals("end")){
			String info[] = stuInfo.split(",|，");
			Student stu = new Student(info[0],info[1],info[2]);
			stuList.add(stu);
			stuInfo = scan.nextLine();
		}
		return stuList;
	}
	
	public void writeStuToFile(ArrayList<Student> stuList){
		File file = new File("./NStuInfo.txt");
		try{
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			for(Student s:stuList)
				pw.println(s.toString());
			fw.close();
			pw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("写入成功");
	}
	public ArrayList<Student> ReadStuInfoFromFile(){
		ArrayList<Student> stuList = new ArrayList<Student>();
		try{
			File infl = new File("./StuInfo.txt");
			FileReader frdr = new FileReader(infl);
			BufferedReader abfrd = new BufferedReader(frdr);
			String aLine = abfrd.readLine();
			while(aLine!=null){
				String info[] = aLine.split(",|，");
				Student stu = new Student(info[0],info[1],info[2]);
				stuList.add(stu);
				aLine = abfrd.readLine();
			}				
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return stuList;
	}
	public ArrayList<Course> inputCourseInfo(){
		ArrayList<Course> crList = new ArrayList<Course>();
		System.out.println("请输入学生成绩，每个成绩一行，输入格式为“学号，课程名称，成绩”，当输入“end”时结束输入");
		String CourseInfo = scan.nextLine();
		while(!CourseInfo.equals("end")){
			String info[] = CourseInfo.split(",|，");
			Course cr = new Course(info[0],info[1],Float.parseFloat(info[2]));
			crList.add(cr);
			CourseInfo = scan.nextLine();
		}
		return crList;
	}
	
	public void writeCourseToFile(ArrayList<Course> couList){
		File file = new File("./CourseInfo.txt");
		try{
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			for(Course c:couList)
				pw.println(c.toString());
			fw.close();
			pw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("写入文件成功");
	}
	
	public ArrayList<Course> ReadCourseInfoFromFile(){
		ArrayList<Course> couList = new ArrayList<Course>();
		try{
			File infl = new File("./courseInfo.txt");
			FileReader frdr = new FileReader(infl);
			BufferedReader abfrd = new BufferedReader(frdr);
			String aLine = abfrd.readLine();
			while(aLine!=null){
				String info[] = aLine.split(",|，");
				Course stu = new Course(info[0],info[1],Float.parseFloat(info[2]));
				couList.add(stu);
				aLine = abfrd.readLine();
			}				
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return couList;
	}
	public void writeResultToFile(ArrayList<Result> reList){
		File file = new File("./ResultInfo.txt");
		try{
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			for(Result r:reList)
				pw.println(r.toString());
			fw.close();
			pw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("写入文件成功");
	}
	public ArrayList<Student> processByStu(ArrayList<Student> SList,ArrayList<Course> CList){
		for(Student s:SList){
			String no = s.getNo();
			int count = 0;
			float allScore = 0.0f;
			for(Course c:CList){
				if(c.getNo().equals(no)){
					count++;
					allScore += c.getScore();
				}
			}
			s.setAvg(allScore/count);
		}
		return SList; 
	}
	
	public ArrayList<Result> processByCourse(ArrayList<Course> CList){
		ArrayList<Result> RList = new ArrayList<Result>();
		for(Course c:CList){
			int index = findIndex(RList,c.getCourseName());
			if(index == -1) {
				Result result = new Result(c.getCourseName(),0);
				RList.add(result);
			}
		}
		for(Result r:RList) {
			String name = r.getCoursename();
			int count = 0;
			float allscore = 0.0f;
			for(int i=0;i<CList.size();i++) {
				if(CList.get(i).getCourseName().equals(name)) {
					count++;
					allscore += CList.get(i).getScore();
				}
			}
			r.setAvg(allscore/count);
		}
		return RList;
	}
	
	public int findIndex(ArrayList<Result> CList,String courseName){
		for(int i=0;i<CList.size();i++){
			if(CList.get(i).getCoursename().equals(courseName)){
				return i;
			}
		}
		return -1;
	}
	public void display(ArrayList<Student> SList,ArrayList<Result> RList) {
		System.out.println("输出结果:");
		System.out.println("按学生统计:");
		System.out.println("学号\t姓名\t性别\t平均分");
		for(Student s:SList)
			System.out.println(s.toString());
		System.out.println("按课程统计:");
		System.out.println("课程\t平均分");
		for(Result r:RList)
			System.out.println(r.toString());
	}
	public ArrayList<Student> ReadStuFromXLS(){
		ArrayList<Student> StuList = new ArrayList<Student>();
		try{
			File xls = new File("./stuInfo.xls");
			Workbook workbook = Workbook.getWorkbook(xls);
			Sheet sheet = workbook.getSheet(0);
			for(int i = 1;i<sheet.getRows();i++){
				String str[] = new String[3];
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j,i);
					str[j] = cell.getContents();
				}
				Student stu = new Student(str[0],str[1],str[2]);
				StuList.add(stu);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return StuList;
	}
	public ArrayList<Course> ReadCourseFromXLS(){
		ArrayList<Course> coList = new ArrayList<Course>();
		try{
			File xls = new File("./courseInfo.xls");
			Workbook workbook = Workbook.getWorkbook(xls);
			Sheet sheet = workbook.getSheet(0);
			for(int i = 1;i<sheet.getRows();i++){
				String str[] = new String[3];
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j,i);
					str[j] = cell.getContents();
				}
				Course stu = new Course(str[0],str[1],Float.parseFloat(str[2]));
				coList.add(stu);
			}
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return coList;
	}
	public void WriteStudentToXLS(ArrayList<Student> stuList){
		try{
			File xls = new File("./StudentInfo.xls");
			WritableWorkbook workbook = Workbook.createWorkbook(xls);
			WritableSheet sheet = workbook.createSheet("按照学生统计",0);
			String[] titles = {"学号","姓名","性别","平均分"};
			Label label = null;
			for(int i=0;i<titles.length;i++) {
				label = new Label(i,0,titles[i]);
				sheet.addCell(label);
			}
			for(int i = 1;i<=stuList.size();i++){     
				label = new Label(0,i,stuList.get(i-1).getNo());
				sheet.addCell(label);
				
				label = new Label(1,i,stuList.get(i-1).getName());
				sheet.addCell(label);
				
				label = new Label(2,i,stuList.get(i-1).getGender());
				sheet.addCell(label);
				
				label = new Label(3,i,String.valueOf(stuList.get(i-1).getAvg()));
				sheet.addCell(label);
			}
			workbook.write();
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("写入表格成功");
	}
	
	public void WriteResultToXLS(ArrayList<Result> reList){
		try{
			File xls = new File("./ResultInfo.xls");
			WritableWorkbook workbook = Workbook.createWorkbook(xls);
			WritableSheet sheet = workbook.createSheet("按照课程统计",0);
			String[] titles = {"课程","平均分"};
			Label label = null;
			for(int i=0;i<titles.length;i++) {
				label = new Label(i,0,titles[i]);
				sheet.addCell(label);
			}
			for(int i = 1;i<=reList.size();i++){
				label = new Label(0,i,reList.get(i-1).getCoursename());
				sheet.addCell(label);
				
				label = new Label(1,i,String.valueOf(reList.get(i-1).getAvg()));
				sheet.addCell(label);
				
			}
			workbook.write();
			workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("写入表格成功");
	}

}
