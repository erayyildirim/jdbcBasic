package insert;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcschema?autoReconnect=true&useSSL=false";
		String user = "forjdbc";
		String password = "ab2ef";
		
		try{
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStmt = myConn.createStatement();
			
			String sql = "insert into student"
					+ "(student_name , student_surname)"
					+ "values('Emre' , 'Soykan')";
			myStmt.executeUpdate(sql);
			System.out.println("Insert complete");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
