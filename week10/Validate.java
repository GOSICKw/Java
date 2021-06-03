package week10;

import java.util.regex.Pattern;

public class Validate {
	public static boolean isusername(String s) {
		String regx = "[a-zA-Z0-9]*";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean ispassword(String s) {
		String regx = ".{6,}";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isshouphoneNum(String s) {
		String regx = "0?(13|14|15|17|18)[0-9]{9}";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isguphoneNum(String s) {
		String regx = "(0\\d{2,3}-?)?[1-9]\\d{6,7}";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isQQNumber(String s) {
		String regx = "[1-9]([0-9]{5,11})";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isID(String s) {
		String regx = "\\d{17}(x|\\d)";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean ispostCode(String s) {
		String regx = "\\d{6}";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isEmail(String s) {
		String regx = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isWebsit(String s) {
		String regx = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean isbirthday(String s) {
		String regx = "\\d{4}(-|\\.)\\d{2}(-|\\.)d{2}(-|\\.)";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	public static boolean ischineseName(String s) {
		String regx = "[\\u4e00-\\u9fa5]{2,12}";
		if(Pattern.compile(regx).matcher(s).matches()){
			return true;
		}
		else
			return false;
	}
	

}
