package week9.dao;

import java.util.ArrayList;
import java.util.Scanner;

import week9.vo.NNResult;
import week9.vo.NStudent;
import week9.vo.Score;

public class StudentAndLectureDao {
	public static ArrayList<NStudent> inputFromKeyboard(){
		ArrayList<NStudent> list = new ArrayList<NStudent>();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生基本信息，每个学生一行，输入格式为“学号，姓名，性别”，当输入“end”时结束输入");
		String info = scan.nextLine();
		while(!info.equals("end")) {
			String array[] = info.split(",|，");
			String sno = array[0];
			String name = array[1];
			String gender = array[2];
			NStudent stu = new NStudent(sno,name,gender);
			list.add(stu);
			info = scan.nextLine();
		}
		return list;
	}
	public static ArrayList<Score> NinputFromKeyboard(){
		ArrayList<Score> list = new ArrayList<Score>();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生成绩，每个成绩一行，输入格式为“学号，课程名称，成绩”，当输入“end”时结束输入");
		String info = scan.nextLine();
		while(!info.equals("end")) {
			String array[] = info.split(",|，");
			String sno = array[0];
			String name = array[1];
			String score = array[2];
			Score Lscore = new Score(sno,name,Float.parseFloat(score));
			list.add(Lscore);
			info = scan.nextLine();
		}
		return list;
	}
	public static ArrayList<NStudent> process(ArrayList<NStudent> list,ArrayList<Score> list2){
		ArrayList<NStudent> list3 = list;
		for(int i=0;i<list.size();i++) {
			int count = 0;
			float score = 0f;
			for(int j=0;j<list2.size();j++) {
				if(list.get(i).getSno().equals(list2.get(j).getSno())) {
					count++;
					score += list2.get(j).getScore();
				}
			}
			list3.get(i).setScore(score/count);
		}
		return list3;
	}
	public static int ifExist(ArrayList<NNResult> list,String name) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getLname().equals(name))
				return i;
		}
		return -1;
	}
	
	public static ArrayList<NNResult> Nprocess(ArrayList<Score> list){
		ArrayList<NNResult> resultList  = new ArrayList<NNResult>();
		for(int i=0;i<list.size();i++) {
			String name = list.get(i).getLectureName();
			float score = list.get(i).getScore();
			int item = ifExist(resultList, name);
			if(item!=-1) {
				NNResult oldresult = resultList.get(item);
				int count = oldresult.getCount();
				count++;
				oldresult.setCount(count);
				oldresult.setScore(score+oldresult.getScore());
				resultList.set(item, oldresult);		
			}
			else {
				NNResult result = new NNResult(name,1,score);
				resultList.add(result);
			}
			
		}
		
		return resultList;
	}
	public static void display(ArrayList<NStudent> list,ArrayList<NNResult> list2) {
		System.out.println("输出结果:");
		System.out.println("按学生统计:");
		System.out.println("学号\t姓名\t性别\t平均分\t");
		for(NStudent stu:list) {
			System.out.println(stu.toString());
		}
		System.out.println("按课程统计:");
		System.out.println("课程\t平均分\t");
		for(NNResult res:list2) {
			System.out.println(res);
		}
	}

}
