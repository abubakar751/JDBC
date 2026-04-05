package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		String query = "select * from Emp_details where Emp_id=? ";
		String withdrawQuery = "UPDATE account SET ammount = ammount - ? WHERE account_number = ?";
		String depositQuery = "UPDATE account SET ammount = ammount + ? WHERE account_number = ?";
		String driver_path = "com.mysql.jdbc.Driver";
		//Driver 
		Class.forName(driver_path);
		
		try {
		//Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.setAutoCommit(false);
		//statements 
		try {
		PreparedStatement withdrawQueryStatement = connection.prepareStatement(withdrawQuery);
		PreparedStatement depositQueryStatement = connection.prepareStatement(depositQuery);
		withdrawQueryStatement.setDouble(1, 500.0);
		withdrawQueryStatement.setInt(2, 1001);
		
		depositQueryStatement.setDouble(1, 500.0);
		depositQueryStatement.setInt(2, 1002);
		
		//execute method 
		int executeUpdate = withdrawQueryStatement.executeUpdate();
		depositQueryStatement.executeUpdate();
		connection.commit();
		System.out.println("Transaction Success ");
       }catch(Exception e) {
			connection.rollback();
			System.out.println("Transaction Failed ");
		}
		}catch(Exception e) {
			
			System.out.println("Transaction Failed ");
		}
		
		
		
		//close connection 
		

	}

}
