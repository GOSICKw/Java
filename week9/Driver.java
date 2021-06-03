package week9;

import java.util.ArrayList;

import week9.dao.ProductDao;
import week9.dao.StudentAndLectureDao;
import week9.dao.StudentDao;
import week9.vo.Product;
import week9.vo.Result;
import week9.vo.Score;
import week9.vo.NNResult;
import week9.vo.NResult;
import week9.vo.NStudent;
import week9.vo.Student;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ProductDao dao = new ProductDao();
		ArrayList<Product> list = dao.inputFromKeyBoard();
		Result result = dao.process(list);
		dao.output(list, result);*/
		
		/*StudentDao dao = new StudentDao();
		ArrayList<Student> list = dao.inputFromKeyboard();
		ArrayList<NResult> resultlist = dao.calculateProvince(list);
		dao.display(list, resultlist);
		*/
		
		StudentAndLectureDao dao = new StudentAndLectureDao();
		ArrayList<NStudent> list = dao.inputFromKeyboard();
		ArrayList<Score> list2 = dao.NinputFromKeyboard();
		ArrayList<NStudent> list3 = dao.process(list, list2);
		ArrayList<NNResult> list4 = dao.Nprocess(list2);
		dao.display(list3, list4);
		
		
		
	}

}
