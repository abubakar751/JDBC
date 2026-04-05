package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserImage {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		String query = "insert into ImageTable (Image_Data) values(?)";
		String driver_path = "com.mysql.jdbc.Driver";
		String image_path = "C:\\Users\\Abu Bakar\\Downloads\\Photograph.jpg";

		Class.forName(driver_path);
		Connection connection = DriverManager.getConnection(url, username, password);

		FileInputStream stream = new FileInputStream(image_path);
		byte[] imageData = new byte[stream.available()];
		stream.read(imageData);
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setBytes(1, imageData);
		statement.executeUpdate();
		System.out.println("Image Inserted");

	}

}
