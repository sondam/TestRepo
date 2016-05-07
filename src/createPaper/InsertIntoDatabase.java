package createPaper;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;// uncomment to view table rows
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;


public class InsertIntoDatabase {
	public void createTable(int noofQuestions )	throws SQLException{
		final String DB_URL = "jdbc:mysql://localhost/Proj1";
		
		//  Database credentials
		   final String USER = "root";
		   final String PASS = "pass";
		   
		   Connection conn = null;
		   Statement stmt = null;
		 
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			    
			      
			      //STEP 4: Execute a query
			      stmt = conn.createStatement();
			      String sql1 = "Drop table IF EXISTS Questions;";
			      stmt.executeUpdate(sql1);
			      String sql2 = "CREATE table IF NOT EXISTS Questions"
			    		  +"(id INTEGER PRIMARY KEY not NULL, " +
		                   " ques VARCHAR(25))"; 
			      
			      stmt.executeUpdate(sql2);
			      String query = "INSERT INTO "
				      		+ "Questions ( id, ques )"
				      		+ " VALUES ( ?, ?)";
			      PreparedStatement stmt1 = conn.prepareStatement(query);   
				 
			   //   System.out.println("no of questions in database are "+noofQuestions);
				  for(int i=1; i < noofQuestions+1 ; i++){		      
				      stmt1.setInt(1, i);
				      stmt1.setString(2, "Q"+i);
				      stmt1.addBatch();
				      }
			      stmt1.executeBatch();
			      stmt1.close();
			     /*
			      * To view table rows from mysql database
			      */
			   /*
			      ResultSet rs = null;
			     String  sql = "Select * from Questions";
			      	           
			     
			      rs = stmt.executeQuery(sql);
			      while (rs.next()){
			    	  String ques = rs.getString("ques");
			    	  System.out.println(ques);
			      }
			     */ 
			      
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

}
