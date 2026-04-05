package com.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutputImage {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		String query = "select * from ImageTable where image_id=?";
		String driver_path = "com.mysql.jdbc.Driver";
		String folder_Path = "C:\\Users\\Abu Bakar\\OneDrive\\Pictures\\Saved Pictures\\Abu.jpg";

		Class.forName(driver_path);
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, 4);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			byte[] image_Data = resultSet.getBytes("image_Data");
			OutputStream stream = new FileOutputStream(folder_Path);
			stream.write(image_Data);
			System.out.println("Image Written Successfully!! ");

		} else
			System.out.println("Image Written Failed !! ");

	}

}
