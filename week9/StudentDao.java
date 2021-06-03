package week9.dao;

import java.util.ArrayList;
import java.util.Scanner;

import week9.vo.Product;
import week9.vo.Result;
import week9.vo.NResult;
import week9.vo.Student;
public class StudentDao {
	public static ArrayList<Student> inputFromKeyboard(){
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生基本信息，每个学生一行，输入格式为“学号，姓名，性别，省份”，当输入“end”时结束输入");
		String info = scan.nextLine();
		while(!info.equals("end")) {
			String array[] = info.split(",|，");
			String sno = array[0];
			String name = array[1];
			String gender = array[2];
			String province = array[3];
			Student stu = new Student(sno,name,gender,province);
			list.add(stu);
			info = scan.nextLine();
		}
		return list;
	}
	public static int ifExist(String province,ArrayList<NResult> resultList) {
		int item = -1;
		for(int i=0;i<resultList.size();i++) {
			NResult result = resultList.get(i);
			if(result.getProvince().equals(province))
				item = i;
		}
		return item;
	}
	
	public static ArrayList<NResult> calculateProvince(ArrayList<Student> list){
		ArrayList<NResult> resultList = new ArrayList<NResult>();
		for(int i=0;i<list.size();i++) {
			Student stu = list.get(i);
			String name = stu.getName();
			String province = stu.getProvince();
			int Exist = ifExist(province,resultList);
			if(Exist != -1) {
				NResult oldresult = resultList.get(Exist);
				int count = oldresult.getCount();
				oldresult.setCount(count+1);
				String Name = oldresult.getNames()+","+name;
				oldresult.setNames(Name);
				resultList.set(Exist, oldresult);
			}
			else {
				NResult result = new NResult(province,1,name);
				resultList.add(result);
			}
		}	
		return resultList;
	}
	public static int calculateBygender(ArrayList<Student> list,String gender) {
		int index = 0;
		for(Student stu:list) {
			if(stu.getGender().equals(gender)) {
				index++;
			}
		}
		return index;
	}
	public static void display(ArrayList<Student> list,ArrayList<NResult> resultList) {
		int allNum = list.size();
		System.out.println("总人数： "+allNum+"人");
		int manNum = calculateBygender(list, "男");
		int womanNum = calculateBygender(list, "女");
		float manIndex = manNum*100.0f/allNum;
		float womanIndex = womanNum*100.0f/allNum;
		System.out.print("其中男："+manNum+"人，"+manIndex+"%,");
		System.out.println("女："+womanNum+"人，"+womanIndex+"%,");
		System.out.println("学生来自以下省份：");
		for(NResult result:resultList)
			System.out.println(result.toString());
	}

}
