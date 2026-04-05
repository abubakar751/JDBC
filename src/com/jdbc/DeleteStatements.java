package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driverPath="com.mysql.jdbc.Driver";
		String ur="jdbc:mysql://localhost:3306/employee";
		String username="root";
		String password="root";
		String query="delete from Emp_details where Emp_id=5";
   Class.forName(driverPath);
	Connection connection = DriverManager.getConnection(ur, username, password);
	Statement statement = connection.createStatement();
	long executeLargeUpdate = statement.executeLargeUpdate(query);
	statement.close();
	statement.close();
	
	}

}
