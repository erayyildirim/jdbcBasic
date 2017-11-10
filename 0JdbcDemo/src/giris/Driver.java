package giris;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbcschema?autoReconnect=true&useSSL=false";
		String user = "forjdbc";
		String password = "ab2ef";
		
		try{
			//1. Get a connection to	database
			Connection myConn = DriverManager.getConnection(url, user, password);
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3. Execute sql query
			ResultSet myRs = myStmt.executeQuery("select * from jdbcschema.student");
			//4. Process the result set
			
			while(myRs.next()){
				System.out.println(myRs.getString("student_id") + ":" + myRs.getString("student_name") + " " + myRs.getString("student_surname"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
