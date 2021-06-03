package week10;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dofont {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "<font face='Arial Serif' size='10px' color='red' />"
				+ "<font id='Headword' align='center' />";
		ArrayList<String> fList = new ArrayList<String>();
		Pattern p = Pattern.compile("<\\s*font\\s*(.*)\\s*/>");
		Matcher matcher = p.matcher(content);
		boolean hasfont = matcher.find();
		while(hasfont) {
			String group = matcher.group(1);
			//System.out.println(group);
			//Pattern fontText = Pattern.compile("([a-z]+)\s*=\s*(\"|\')([^\"]+)(\"|\')",Pattern.CASE_INSENSITIVE);
			Pattern fontText = Pattern.compile("([a-z]+)=(\"|\')(.*?)(\"|\')",Pattern.CASE_INSENSITIVE);
			Matcher matcher2 = fontText.matcher(group);
			boolean hasky = matcher2.find();
			while(hasky) {
				String info = matcher2.group(1)+":"+matcher2.group(3);
				fList.add(info);
				hasky = matcher2.find();
			}
			hasfont = matcher.find();
		}
		for(String a:fList) {
			System.out.println(a);
		}
	}

}
