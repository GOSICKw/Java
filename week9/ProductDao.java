package week9.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import week9.vo.Product;
import week9.vo.Result;

public class ProductDao {
	public ArrayList<Product> inputFromKeyBoard(){
		ArrayList<Product> list = new ArrayList<Product>();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入销售信息，以此为商品名称，商品单价，销售数量，以逗号分隔");
		String aLine = scan.nextLine();
		int seq = 0;
		while(!aLine.equals("0000")){
			String arr[] = aLine.split(",|，");
			String name = arr[0];
			float price = Float.parseFloat(arr[1]);
			int number = Integer.parseInt(arr[2]);
			float totalMoney = price*number;
			String sno = generateSno(String.valueOf(seq));
			seq++;
			Product product = new Product(sno,name,price,number,totalMoney);
			list.add(product);
			 aLine = scan.nextLine();
		}
		return list;
	}
	public Result process(ArrayList<Product> list){
		//Result result = new Result();
		int salesNum=list.size();     //销售笔数      
		int salesVol=0;       //销售数量
		float allmoney=0;         //销售金额
		for(int i=0;i<list.size();i++){
			Product product = list.get(i);
			salesVol += product.getNumber();
			allmoney += product.getTotalMoney();
		}
		Result result = new Result(salesNum,salesVol,allmoney);
		return result;
	}
	
	public void output(ArrayList<Product> list,Result result){
		System.out.println("流水号\t\t商品名称\t\t单价\t\t商品数量\t\t总价");
		for(Product product:list){
			System.out.println(product.toString());
		}
		System.out.println(result.toString());
		
	}
	public static String generateSno(String beforeNo){
		String sno = "";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String prefic = df.format(new Date());
		
		String newNo = String.valueOf(Integer.parseInt(beforeNo)+1);
		String zero = "";
		int zeroCount = 4-newNo.length();
		for(int i =0;i<zeroCount;i++){
			zero = "0"+zero;
		}
		sno = prefic+zero+newNo;
		return sno;
	}

}
