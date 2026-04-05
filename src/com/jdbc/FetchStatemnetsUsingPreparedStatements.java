package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchStatemnetsUsingPreparedStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		String query = "select * from Emp_details where Emp_id=? ";
		String driver_path = "com.mysql.jdbc.Driver";

		Class.forName(driver_path);
		Connection connection = DriverManager.getConnection(url, username, password);
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter Id ");
		
		int Emp_id =sc.nextInt();
		System.out.println("---------------");
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, Emp_id);
		ResultSet executeQuery = statement.executeQuery();
		while(executeQuery.next()) {
			int Emp_id1=executeQuery.getInt("Emp_id");
			String Emp_name=executeQuery.getString("Emp_name");
			int Emp_age=executeQuery.getInt("Emp_age");
			String Emp_Gender=executeQuery.getString("Emp_Gender");
			
			System.out.println("Emp ID :"+Emp_id);
			System.out.println("Emp Name :"+Emp_name);
			System.out.println("Emp Age :"+Emp_age);
			System.out.println("Emp Gender :"+Emp_Gender);
			System.out.println("---------------");
			
		}
		System.out.println("Fetch Data Successfully");
		
	}

}
