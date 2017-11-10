package increaseSalary;

import java.sql.*;

// Stored produces with IN PARAM

public class IncreaseSalariesForDepartment {
	public static void main (String [] args) throws Exception{
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "forjdbc" , "ab2ef");
			
			String department = "Engineering";
			int increaseAmount = 10000;
			
			System.out.println("Salaries before");
			showSalaries(myConn,department);
			
			//Prepare the stored procedure call
			
			myStmt = myConn.prepareCall("{call increase_salaries_for_department(? , ?)}");
			myStmt.setString(1,department);
			myStmt.setInt(2,increaseAmount);
			
			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  increase_salaries_for_department('" + department + "', " + increaseAmount + ")");
			myStmt.execute();
			
			System.out.println("Finished stored procedure \n \n Salaries AFTER");
			showSalaries(myConn,department);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(myConn,myStmt,null);
		}
		
	}
	
	private static void showSalaries(Connection myConn , String department) throws SQLException{
		PreparedStatement myStmt = null;
		ResultSet myRs =null;
		
		try{
			myStmt = myConn.prepareStatement("select * from employee where department = ?");
			myStmt.setString(1, department);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()){
				String name = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String edepartment = myRs.getString("department");
				double salary = myRs.getDouble("salary");
				System.out.printf("%s,	%s, %s %.2s\n", name , lastName , edepartment , salary);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(myStmt,myRs);
		}
		
	}
	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
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

	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}

}
