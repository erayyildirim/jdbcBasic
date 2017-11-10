package greetDepartment;

import java.sql.*;
public class GreetTheDepartment {
	public static void main(String[] args) throws Exception {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "forjdbc" , "ab2ef");
			String theDepartment = "Engineering";
			myStmt = myConn.prepareCall("{call greet_the_department(?)");
			
			
			
			// Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(1, Types.VARCHAR);
			
			
			System.out.println("\n\nCalling stored procedure.  call greet_the_department(?)('" + theDepartment + "')");
			myStmt.execute();
			
			//Get the value of  the INOUT param
			String result = myStmt.getString(1);
			
			System.out.println(result);
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
