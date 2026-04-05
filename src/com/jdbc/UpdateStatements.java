package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String  driver_path= "com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/employee";
		String username= "root";
		String password= "root";
		String query= "update Emp_details set emp_name='Sadis' where Emp_id=2";
		
		Class.forName(driver_path);
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		int executeUpdate = statement.executeUpdate(query);
		System.out.println(executeUpdate);
		statement.close();
		connection.close();
		
	}

}
