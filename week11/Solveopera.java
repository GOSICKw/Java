package week11;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solveopera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String opera = "add(max(doubleMe(sub(8,10))),sub(15,3))";
		Scanner scan = new Scanner(System.in);
		String opera = scan.nextLine();
		String pat = "((add)|(sub)|(max)|(min)|(doubleMe))\\(-?\\d{1,}(,-?\\d{1,})?\\)";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(opera);
		String result = opera;
		while(m.find()){
			/*System.out.println(m.group());
			System.out.println(cal(m.group()));*/
			String basicExpress = m.group();
			String s = cal(basicExpress);
			System.out.println(basicExpress+"="+s);
			basicExpress = basicExpress.replaceAll("\\(", "\\\\(");
			//System.out.println(basicExpress);
			basicExpress = basicExpress.replaceAll("\\)", "\\\\)");
			//System.out.println(basicExpress);
			System.out.println("±í´ïÊ½Îª:"+result);
			result = result.replaceAll(basicExpress, s);
			System.out.println("Ìæ»»ºó:"+result);
			m = p.matcher(result);
		}

	}
	
	public static String cal(String ope){
		String result = "";
		String code = ope.substring(0,ope.indexOf("("));
		switch(code){
		case "add":{
			String num1 = ope.substring(ope.indexOf("(")+1,ope.indexOf(","));
			String num2 = ope.substring(ope.indexOf(",")+1,ope.indexOf(")"));
			int rnum1 = Integer.valueOf(num1);
			int rnum2 = Integer.valueOf(num2);
			result = String.valueOf(rnum1+rnum2);
			break;
		}
		
		case "sub":{
			String num1 = ope.substring(ope.indexOf("(")+1,ope.indexOf(","));
			String num2 = ope.substring(ope.indexOf(",")+1,ope.indexOf(")"));
			int rnum1 = Integer.valueOf(num1);
			int rnum2 = Integer.valueOf(num2);
			result = String.valueOf(rnum1-rnum2);
			break;
		}
		case "max":{
			String num1 = ope.substring(ope.indexOf("(")+1,ope.indexOf(","));
			String num2 = ope.substring(ope.indexOf(",")+1,ope.indexOf(")"));
			int rnum1 = Integer.valueOf(num1);
			int rnum2 = Integer.valueOf(num2);
			result = String.valueOf(rnum1>rnum2?rnum1:rnum2);
			break;
		}
		case "min":{
			String num1 = ope.substring(ope.indexOf("(")+1,ope.indexOf(","));
			String num2 = ope.substring(ope.indexOf(",")+1,ope.indexOf(")"));
			int rnum1 = Integer.valueOf(num1);
			int rnum2 = Integer.valueOf(num2);
			result = String.valueOf(rnum1<rnum2?rnum1:rnum2);
			break;
		}
		case "doubleMe":{
			String num = ope.substring(ope.indexOf("(")+1,ope.indexOf(")"));
			int rnum = Integer.valueOf(num);
			result = String.valueOf(rnum*2);
		}
		}
		return result;
	}

}
