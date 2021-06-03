package week11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AboutRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		//1.×°Ë®Ïä
		//File f = new File("d:\\JAVA\\info.txt");
		File f = new File("./info.txt");
		//2.×°Ë®¹Ü
		FileReader fr = new FileReader(f);
		//3.×°Ë®ÁúÍ·
		BufferedReader bf = new BufferedReader(fr);
		//4.´ò¿ªË®ÁúÍ·
		String aLine = "";
		while((aLine = bf.readLine())!=null){
			System.out.println(aLine);
		}
		bf.close();
		fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}


	}

}
