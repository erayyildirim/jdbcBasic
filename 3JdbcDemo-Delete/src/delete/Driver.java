package delete;

import java.sql.*;

public class Driver {
	public static void main(String[] args){
		
		String url = "jdbc:mysql://localhost:3306/jdbcschema?autoReconnect=true&useSSL=false";
		String user= "forjdbc";
		String password = "ab2ef";
		
		try{
			Connection myConn = DriverManager.getConnection(url,user,password);
			
			Statement myStmt = myConn.createStatement();
			
			String sql = "delete from student where student_surname = 'Soykan'";
			
			int row = myStmt.executeUpdate(sql);
			
			System.out.println("Deleting is succes: " + ""+ row);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
