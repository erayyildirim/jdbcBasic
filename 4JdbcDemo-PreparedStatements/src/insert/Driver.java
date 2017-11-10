package insert;

import java.sql.*;
public class Driver {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "forjdbc" , "ab2ef");
			String sql = "insert into employee"
					+ "(last_name, first_name , email , salary)"
					+ "values('Yildirim', 'Eray' , 'eray.yildiriim@gmail.com', 75000.00)";
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}

		

	}
	
	public static void display(ResultSet myRs) throws SQLException{
		while(myRs.next()){
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}

}
