package com.training.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class jdbcDemo {
	public static void main(String[] args) {
//		String url = "jdbc:postgresql://localhost:5432/testdb";
//		String username = "postgres";
//		String password = "pass123";

		try {
			Properties props = new Properties();
			FileInputStream input = new FileInputStream("db.properties");
			props.load(input);
			String url = props.getProperty("db.url");
  			String username = props.getProperty("db.user");
 			String password = props.getProperty("db.password");
 		  Class.forName("org.postgresql.Driver");
			// ** Connect DB
			Connection connection = DriverManager.getConnection(url, username, password);
			
//			Statement stmt = connection.createStatement();
			PreparedStatement pstmt = connection.prepareStatement("Select * from employee where name=?");
			pstmt.setString(1, "Ghassa Omar");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID:" +rs.getString(1)+ "Name: "+rs.getString(2));
			
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}