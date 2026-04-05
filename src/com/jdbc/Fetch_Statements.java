package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch_Statements {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/employee";
		String username="root";
		String password="root";
		String query="select * from emp_details";
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connection = DriverManager.getConnection(url,username,password);
		 Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);
         while (resultSet.next()) {
			int Emp_id=resultSet.getInt("Emp_id");
			String Emp_name=resultSet.getString("Emp_name");
			int Emp_age=resultSet.getInt("Emp_age");
			String Emp_Gender=resultSet.getString("Emp_Gender");
			
			System.out.println(Emp_id);
			System.out.println(Emp_name);
			System.out.println(Emp_age);
			System.out.println(Emp_Gender);
			System.out.println("---------------");
			
		}
         resultSet.close();
         statement.close();
         connection.close();

	}

}
