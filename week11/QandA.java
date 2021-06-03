package week11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QandA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		File f = new File("./question.txt");
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader(fr);
		
		File af = new File("./answer.txt");
		FileWriter fwt = new FileWriter(af);
		PrintWriter pwt = new PrintWriter(fwt);
		
		String aLine = "";
		while((aLine = bf.readLine())!=null){
			int answer = getanswer(aLine);
			System.out.println(answer);
			String ope = aLine+"="+answer;
			pwt.println(ope);
		}
		bf.close();
		fr.close();
		pwt.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public static int getanswer(String S) {
		// TODO Auto-generated method stub
		//String opera = "add(max(doubleMe(sub(8,10))),sub(15,3))";
		String pat = "((add)|(sub)|(max)|(min)|(doubleMe))\\(-?\\d{1,}(,-?\\d{1,})?\\)";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(S);
		String result = S;
		while(m.find()){
			String basicExpress = m.group();
			String s = cal(basicExpress);
			basicExpress = basicExpress.replaceAll("\\(", "\\\\(");
			basicExpress = basicExpress.replaceAll("\\)", "\\\\)");
			result = result.replaceAll(basicExpress, s);
			m = p.matcher(result);
		}
		return Integer.valueOf(result);

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
