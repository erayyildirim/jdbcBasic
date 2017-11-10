package getEmployes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class GetEmployeesForDepartment {
	public static void main (String [] args) throws Exception{
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "forjdbc" , "ab2ef");
			String theDepartment = "Engineering";
			
			myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");
			
			myStmt.setString(1, theDepartment);
			
			myStmt.execute();
			
			myRs = myStmt.getResultSet();
			while(myRs.next()){
				String name = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				System.out.printf("%s,%s \n" , name , lastName);
			}
					
					
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		
	}

}
