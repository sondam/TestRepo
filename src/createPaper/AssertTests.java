package createPaper;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class AssertTests {
	QuestionPaper q1= new QuestionPaper();
	@Test      // test the number of questions generated is equal to specified
	public void testNoOfQuestions() {
		ArrayList<String> qlist= q1.getQuestionPaper(20);
		
		assertEquals(qlist.size(),20);
	}
	//--------------------------------------------------------------------------------------------------
	@Test       // test the number of questions generated are unique
	public void testUniqueQuestions() {
		ArrayList<String> qlist= q1.getQuestionPaper(10);
		Set<String> set = new HashSet<String>();
		for(String s: qlist){
			set.add(s);
	    	//	System.out.println(s);
		}
		assertTrue(qlist.size()==set.size());
	}
	//--------------------------------------------------------------------------------------------------
	@Test       // test the number of question in 2 set generated are unique
	public void testUniqueQuestionSet2() {
		int ques= 20;// specify number of questions in a set
		ArrayList<ArrayList<String>> qlist= q1.getQuestionSet(ques, 2);
		
		for (ArrayList<String> s:qlist) {
			Set<String> set = new HashSet<String>();
			for(String q: s){
				set.add(q);
			    //System.out.println(q);
			    assertEquals(s.size(),ques); // assert set contains 10 elements
			
			}   //System.out.println(s);
			
			assertTrue(s.size() == set.size());// assert set contains no duplicate elements
		}
		 /*
		  *	System.out.println(qlist.get(0));
		  *	System.out.println(qlist.get(1));
		 */
			//assertEquals
			List<String> List1 = new ArrayList<String>(qlist.get(0));
		    List<String> List2 = new ArrayList<String>(qlist.get(1));
		    assertNotEquals(List1,List2);
		
	}
	//--------------------------------------------------------------------------------------------------
	@Test       // test the number of question in 3 set generated are unique
	public void testUniqueQuestionSet3() {
		int ques= 20;// specify number of questions in a set
		ArrayList<ArrayList<String>> qlist= q1.getQuestionSet(ques, 3);
		
			for (ArrayList<String> s:qlist) {
				Set<String> set = new HashSet<String>();
				for(String q: s){
					set.add(q);
				//System.out.println(q);
				    assertEquals(s.size(),ques); // assert set contains 10 elements
	 			}
				assertTrue(s.size() == set.size());// assert set contains no duplicate elements
	
			}
				/*
				 * System.out.println(qlist.get(0));
				 * System.out.println(qlist.get(1));
				 * System.out.println(qlist.get(2));
				*/
				//assertEquals
				List<String> List1 = new ArrayList<String>(qlist.get(0));
			    List<String> List2 = new ArrayList<String>(qlist.get(1));
			    List<String> List3 = new ArrayList<String>(qlist.get(2));
			    assertNotEquals(List1,List2); // assert set contains no duplicate Lists of Questions
			    assertNotEquals(List1,List3);
			    assertNotEquals(List2,List3);
			
		}
	}



