package update;
import java.sql.*;
public class Driver {
	
	public static void main(String [] args){
		String url = "jdbc:mysql://localhost:3306/jdbcschema?autoReconnect=true&useSSL=false";
		String user = "forjdbc";
		String password = "ab2ef";
		try{
		
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt = myConn.createStatement();
			
			String sql = "update student"
					+ " set student_name = 'Ali' "
					+ " where student_id = 5";
		    myStmt.executeUpdate(sql);
			
			System.out.println("Update complete");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
