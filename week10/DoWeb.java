package week10;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoWeb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "<html><head><title>欢迎访问武汉纺织大学首页</title></head>"
				+ "\n<body><img src='1.jpg'/>"
				+"\n<a href='1.htm'>首页</a>"
				+ "\n<a href='2.htm'>教务处</a>"
				+ "\\n<a href='3.htm'>数计学院</a>"
				+ "\n<img src='2.jpg'/>"
				+ "\n<img src='3.jpg'/>"
				+ "\n</body></html>";
		ArrayList<String> srcList = new ArrayList<String>();
		ArrayList<Hyperlink> aList = new ArrayList<Hyperlink>();
		Pattern title = Pattern.compile("(<title>)(.*?)(</title>)",Pattern.CASE_INSENSITIVE);
		Matcher tmatcher = title.matcher(content);
		System.out.print("网页标题：");
		while(tmatcher.find()) {
			System.out.println(tmatcher.group(2));
		}
		Pattern p = Pattern.compile("<(img)(.*?)(>|></img>|/>)",Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(content);
		boolean hasPic = matcher.find();
		int picNum = 0;
		int aNum = 0;
		if(hasPic == true) {
			while(hasPic) {
				String group = matcher.group(2);
				//System.out.println(group);
				Pattern srcText = Pattern.compile("(src)=(\"|\')(.*?)(\"|\')",Pattern.CASE_INSENSITIVE);
				Matcher matcher2 = srcText.matcher(group);
				if(matcher2.find()) {
					srcList.add(matcher2.group(3));
					picNum++;
				}
				hasPic = matcher.find();
			}
		}
		System.out.print("网页中共包含"+picNum+"个图片,文件名为：");
		for(String pic:srcList) {
			System.out.print(pic+",");
		}
		System.out.println();
		Pattern a = Pattern.compile("<(a)(.*?)>(.*?)(</a>)",Pattern.CASE_INSENSITIVE);
		Matcher amatcher = a.matcher(content);
		boolean hasa = amatcher.find();
		if(hasa == true) {
			while(hasa) {
				String group = amatcher.group(2)+amatcher.group(3);
				//System.out.println(group);
				Pattern aText = Pattern.compile("(href)=(\"|\')(.*?)(\"|\')(.*)",Pattern.CASE_INSENSITIVE);
				Matcher matcher2 = aText.matcher(group);
				if(matcher2.find()) {
					Hyperlink info = new Hyperlink(matcher2.group(5),matcher2.group(3));
					aList.add(info);
					aNum++;
				}
				hasa = amatcher.find();
			}
		}
		System.out.println("网页中包含"+aNum+"个超链接，超链接信息如下:");
		System.out.println("名称\t地址\t");
		for(Hyperlink hy:aList) {
			System.out.println(hy.toString());
		}
		//System.out.println(content);

	}

}
