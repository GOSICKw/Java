package week12;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] argv){
		Dao dao = new Dao();
		ArrayList<Student> stuList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		//stuList = dao.inputStuInfo();              //直接从键盘输入创建集合
		//courseList = dao.inputCourseInfo();
		
		/*for(Student s:stuList)
			System.out.println(s.toString());*/
		
		/*for(Course c:courseList)
			System.out.println(c.toString());*/
		
		stuList = dao.ReadStuFromXLS();            //从xls表格读入 创建集合
		courseList = dao.ReadCourseFromXLS();
		
		/*stuList = dao.ReadStuInfoFromFile();            //从文件读入 创建集合
		courseList= dao.ReadCourseInfoFromFile();*/
		
		
		ArrayList<Student> NstuList = dao.processByStu(stuList,courseList);
		ArrayList<Result> ReList = dao.processByCourse(courseList);
		
		dao.writeStuToFile(NstuList);           //写到文件里
		dao.writeResultToFile(ReList);
		
		dao.WriteStudentToXLS(NstuList);           //写到表格里
		dao.WriteResultToXLS(ReList);
		
		dao.display(NstuList, ReList);            //最后的显示
		
		
	}

}
