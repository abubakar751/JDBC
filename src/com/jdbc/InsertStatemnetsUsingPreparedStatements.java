package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStatemnetsUsingPreparedStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		String query = "insert into Emp_details (Emp_name,Emp_age,Emp_Gender) values(?,?,?)";
		String driver_path = "com.mysql.jdbc.Driver";

		Class.forName(driver_path);
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement statement = connection.prepareStatement(query);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Emp_name ");
		String Emp_name = scanner.nextLine();
		System.out.println("Enter Emp_age");
		int Emp_age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Eneter Emp_Gender");
		String Emp_Gender = scanner.nextLine();
		System.out.println("Inserted IN Db Successfullly");
		statement.setString(1, Emp_name);

		statement.setInt(2, Emp_age);

		statement.setString(3, Emp_Gender);

		statement.executeUpdate();

	}

}
