package week11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AboutWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		//1.×°Ë®Ïä
		//File f = new File("d:\\JAVA\\info.txt");
		File f = new File("info2.txt");
		FileWriter fwt = new FileWriter(f);
		PrintWriter pwt = new PrintWriter(fwt);
		String aLine = "asfasfa";
		pwt.println(aLine);
		pwt.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
