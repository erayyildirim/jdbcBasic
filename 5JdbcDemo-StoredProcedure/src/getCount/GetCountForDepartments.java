package getCount;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class GetCountForDepartments {
	public static void main (String [] args) throws Exception{
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "forjdbc" , "ab2ef");
			String theDepartment = "Engineering";
			
			myStmt = myConn.prepareCall("{call get_count_for_department(?,?)}");
			
			myStmt.setString(1,theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);
			
			System.out.println("\n\nCalling stored procedure.  get_count_for_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished stored procedure");
			
			System.out.println("Count: " + myStmt.getInt(2));
					
					
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		
	}

}
