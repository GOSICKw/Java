package week10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入一个表达式:");
		String s = scan.nextLine();
		//String pattern = "(add|sub|max|min|doubleMe)\\(\\d+(,|，)?\\d*\\)";
		ArrayList<String> opeList = new ArrayList<String>();
		opeList.add(s);
		String pattern = "(add|sub|max|min|doubleMe)\\(\\d*(,|，)?(.*)\\)";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(s);
		boolean hasOpe = matcher.find();
		if(hasOpe == true) {
			while(hasOpe) {
				String group = matcher.group(3);
				//System.out.println(group);
				opeList.add(group);
				matcher = p.matcher(group);
				hasOpe = matcher.find();
			}
		}
		opeList.remove(opeList.size()-1);
		ArrayList<String> opeList2 = new ArrayList<String>();  //副本，方便后面替换
		String ope2;
		int answer = 0;
		for(int i=0;i<opeList.size();i++)
		{
			//System.out.println(opeList.get(i));
			opeList2.add(opeList.get(i));
		}
		/*opeList.set(0, "saff");
		for(int i=opeList.size()-1;i>=0;i--)
		{
			System.out.println(opeList.get(i));
		}
		for(int i=opeList2.size()-1;i>=0;i--)
			System.out.println(opeList2.get(i));*/
		
		//answer = getanswer(opeList.get(1));
		
		for(int i=opeList.size()-1;i>=0;i--) {
			//System.out.println(opeList.get(i));
			String ope = opeList.get(i);
			System.out.print(opeList2.get(i)+"=");
			answer = getanswer(ope);
			System.out.println(answer);
			if(i == 0)
				break;
			String Answer = String.valueOf(answer);
			ope2 = opeList.get(i-1);
			String ope3 = ope2.replace(opeList2.get(i), Answer);	
			opeList.set(i-1, ope3);
		}
		/*String lastOpe = s.replace(opeList2.get(0), String.valueOf(answer));
		System.out.println("该运算表达式的结果为："+getanswer(lastOpe));*/
		System.out.println("该运算表达式的结果为："+s+"="+answer);
		
		/*while(!Pattern.compile(pattern).matcher(s).matches()) {
			System.out.print("格式不正确，请重新输入:");
			s = scan.nextLine();
		}
		System.out.println("输入正确");*/
	}

	public static int getanswer(String s) {
		int pos1 = s.indexOf("(");
		String operateCode = s.substring(0,pos1);
		int pos2,pos3;
		int number1=0,number2=0;
		pos3 = s.indexOf(")");
		if(operateCode.equals("doubleMe")){
			number1 = Integer.parseInt(s.substring(pos1+1,pos3).trim());
		}
		else if(operateCode.equals("add")||operateCode.equals("sub")||operateCode.equals("max")||operateCode.equals("min")){
			pos2 = s.indexOf(",");
			number1 = Integer.parseInt(s.substring(pos1+1,pos2).trim());
			number2 = Integer.parseInt(s.substring(pos2+1,pos3).trim());
		}
		else{}
		int result=0;
		switch(operateCode){
		case "doubleMe":
			result = number1*2;break;
		case "add":
			result = number1+number2;break;
		case "sub":
			result = number1-number2;break;
		case "max":
			result = number1>number2?number1:number2;break;
		case "min":
			result = number1<number2?number1:number2;break;
		}
		return result;
	}

}
