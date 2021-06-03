package week12;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Readxls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File xls = new File("./stuInfo.xls");
			Workbook workbook = Workbook.getWorkbook(xls);
			Sheet sheet = workbook.getSheet(0);
			System.out.println("ÁÐ:"+sheet.getColumns());
			System.out.println("ÐÐ:"+sheet.getRows());
			for(int i = 1;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j,i);
					System.out.print(cell.getContents()+"\t");
				}
				System.out.println();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
