package createPaper;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.ArrayList;


public class MainClass {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * Create table with number of questions specified 
		 */
		//InsertIntoDatabase idb= new InsertIntoDatabase();
		//idb.createTable(100);
		 //	qp1.readDatabase();
		QuestionPaper qp1= new QuestionPaper();
		
		ArrayList<String> questionSet1 = new ArrayList<String>(1);
	  	questionSet1= qp1.getQuestionPaper(20);
	    System.out.println(questionSet1);
	    System.out.println("********************************************************");
	    QuestionPaper qp2= new QuestionPaper();
		ArrayList<ArrayList<String>> questionSet2 = new ArrayList<ArrayList<String>>(2);
		questionSet2 = qp2.getQuestionSet(20,2);
		for (ArrayList<String> s:questionSet2) {
			System.out.println(s);}
		System.out.println("********************************************************");
	    QuestionPaper qp3= new QuestionPaper();
	    ArrayList<ArrayList<String>> questionSet3 = new ArrayList<ArrayList<String>>(3);
		questionSet3 = qp3.getQuestionSet(30,3);
		for (ArrayList<String> s:questionSet3) {
    	 	  System.out.println(s);
	    }
	
	}

}
