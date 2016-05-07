package createPaper;

import java.util.*;
import java.sql.*;


public class QuestionPaper {
	//JDBC driver name and database URL
	  // final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   final String DB_URL = "jdbc:mysql://localhost/Proj1";
	
	//  Database credentials
	   final String USER = "root";
	   final String PASS = "pass";

	   Connection conn = null;
	   Statement stmt = null;
	   int totalq= 0;
	   
	   /*
	    * Method to read values from database
	    * 
	    */
	   public void readDatabase(){
	   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		     
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      
		      
		      //STEP 4: Execute a query
		     
		      stmt = conn.createStatement();
		      
		      ResultSet rs = null;
			  String  sql = "Select count(*) from Questions";
			  rs = stmt.executeQuery(sql);   
			  ArrayList <String> question = new ArrayList<String>();  
			  while (rs.next()){
				  question.add(rs.getString(2));
			  }
			  System.out.println(question);
			 // int totalq=question.size();
		     
		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			 
			
	   }
	
	
	
		//--------------------------------------------------------------------
		public ArrayList<String>  getQuestionPaper(int num) {
			
			
		    //Array list declared to store integer for storing index
			ArrayList<Integer> templist = new ArrayList<Integer>();
	        //Array list declared to store questions at specific index
	        ArrayList<String> templist1 = new ArrayList<String>(num);
	        //ArrayList<String> templist2 = new ArrayList<String>(num);
	        try{
	           Class.forName("com.mysql.jdbc.Driver");
		       conn = DriverManager.getConnection(DB_URL, USER, PASS);
		       stmt = conn.createStatement();
		      
		       ResultSet rs = null;
			   String  sql = "Select * from Questions";
			   rs = stmt.executeQuery(sql); 
			   ArrayList <String> question = new ArrayList<String>();  
			   while (rs.next()){
				  question.add(rs.getString(2));
				  totalq= totalq+1;
			   }
			 // System.out.println(question);
			  Random rn = new Random();
              //random number generating index from where question can be picked
              while (templist.size() < num) {
       	
			        int random = rn.nextInt(totalq);
			            // make sure same number is not generated twice
					 if (!templist.contains(random)) {
					  	templist.add(random);
					 }
			     }
		         //for each index add questions and save to another ArrayList
		     for (Integer i:templist) {
			     templist1.add(question.get(i));
		}
			 
	       }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	         	       
		return templist1;
		
			
		}
		//-----------------------------------------------------------------------------------
		//method to print questions with number of questions and set specified
		public ArrayList<ArrayList<String>> getQuestionSet(int num, int set) {
			 ArrayList<ArrayList<String>> questionSet = new ArrayList<ArrayList<String>>(set);
					     
		     try{
		    	   
		          Class.forName("com.mysql.jdbc.Driver");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      stmt = conn.createStatement();
			      
			      ResultSet rs = null;
				  String  sql = "Select * from Questions";
				  rs = stmt.executeQuery(sql); 
				  ArrayList <String> question = new ArrayList<String>();  
				  while (rs.next()){
					  question.add(rs.getString(2));
					  totalq= totalq+1;
				  }
				
	              //random number generating index from where question can be picked
				  if((set ==2) && (num*set < totalq) ){
					    List<Integer> set1 = new ArrayList<Integer>();
					    List<Integer> set2 = new ArrayList<Integer>();
					    //Array list declared to store even questions at specific index
				        ArrayList<String> templist1 = new ArrayList<String>(num);
				        //Array list declared to store odd questions at specific index
				        ArrayList<String> templist2 = new ArrayList<String>(num);
				  while ((set1.size() < num) || (set2.size() < num )) {
				    	Random rn = new Random();
			               //random number generating index from where question can be picked
			            int random = rn.nextInt(totalq);
				            if((random % 2 == 0) & (!set2.contains(random)) & (set2.size() < num)){
				            	set2.add(random);
						    }
				            else if ((random % 2 == 1) & (!set1.contains(random)) & (set1.size() < num)){
				            	set1.add(random);
				            }
				     }
				  for (Integer i:set1) {
						templist1.add(question.get(i));
					}
				    for (Integer i:set2) {
						templist2.add(question.get(i));
					}
				    questionSet.add(templist1);
				    questionSet.add(templist2);
		       		     
				  }
		       else if ((set ==3) && (num*set < totalq)){
					
				    List<Integer> set1 = new ArrayList<Integer>();
				    List<Integer> set2 = new ArrayList<Integer>();
				    List<Integer> set3 = new ArrayList<Integer>();
				    //Array list declared to store questions at k position at specific index
			        ArrayList<String> templist1 = new ArrayList<String>(num);
			      //Array list declared to store questions at k+1 position at specific index
			        ArrayList<String> templist2 = new ArrayList<String>(num);
			      //Array list declared to store questions at k+2 position at specific index
			        ArrayList<String> templist3 = new ArrayList<String>(num);
			        while ((set1.size() < num) || (set2.size() < num ) || (set3.size() < num))  {
			        	for(int k = 0 ; k < totalq ; k++){   
				    	Random rn = new Random();
			               //random number generating index from where question can be picked
			            int random = rn.nextInt(totalq);
			                if(((random % (3)) == 0) & (!set1.contains(random)) & (set1.size() < num)){
				            	set1.add(random);
						    }
				            else if (((random % (3))==1) & (!set2.contains(random)) & (set2.size() < num)){
				            	set2.add(random);
				            }
				            else if (((random % (3))==2) & (!set3.contains(random)) & (set3.size() < num)){
				            	set3.add(random);
				            }
				     }    
			    }
			        for (Integer i:set1) {
						templist1.add(question.get(i));
					}
				    for (Integer i:set2) {
						templist2.add(question.get(i));
					}
				    for (Integer i:set3) {
						templist3.add(question.get(i));
					}
				    questionSet.add(templist1);
				    questionSet.add(templist2);
				    questionSet.add(templist3);
				    
				}
					
				else if((num*set) > totalq)
				{System.out.println("Database contains less questions");}		
				
				else
				{System.out.println("only 1, 2 or 3 sets are allowed");}		
		      				
				
		       }	
						       
			catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
			}catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
			 }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            conn.close();
			  }catch(SQLException se){
				      }// do nothing
				      try{
				         if(conn!=null)
				            conn.close();
			 }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
			 }//end try			
		      
		     
		 return questionSet;
					   
		} 
	}
