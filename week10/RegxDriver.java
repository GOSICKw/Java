package week10;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String regx = "1[3578]\\d{9}";
		//String regx = "(0\\d{2,3}-?)?[1-9]\\d{6,7}";
		
		/*String regx = "\\w+@\\w+(.\\w+)+";
		Scanner scan = new Scanner(System.in);
		String phone = scan.nextLine();
		if(Pattern.compile(regx).matcher(phone).matches()){
			System.out.println("输入格式正确");
		}
		else
			System.out.println("输入格式不正确");*/
		
		/*Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(phone);
		if(m.matches())	
			System.out.println("输入格式正确");
		else
			System.out.println("输入格式不正确");*/
		
		
		/*String regx = "-?[1-9]\\d*.\\d*[\\+\\-\\*\\/][1-9]\\d*.\\d*";
		Scanner scan = new Scanner(System.in);
		String operate = scan.nextLine();
		while(true){
			if(Pattern.compile(regx).matcher(operate).matches()){
				break;
			}
			else{
				System.out.println("输入的表达式有误，请重新输入");
				operate = scan.nextLine();
			}
				
		}
		System.out.println(operate);*/
		
		String str = "https://a";
		String pattern = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
		
		

	}

}
