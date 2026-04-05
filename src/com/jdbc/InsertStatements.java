package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/employee";
		String username="root";
		String password="root";
		String query="insert into Emp_details (Emp_name,Emp_age,Emp_Gender) values('Abubakar',24,'Male')";
		String driver_path="com.mysql.jdbc.Driver";
		Class.forName(driver_path);
		Connection connection = DriverManager.getConnection(url,username,password);
		Statement statement = connection.createStatement();
		int executeUpdate = statement.executeUpdate(query);
		
		
		System.out.println(executeUpdate);
		statement.close();
		connection.close();
		
		
		

	}

}
