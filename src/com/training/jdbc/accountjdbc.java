package com.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class accountjdbc {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/testdb";
		String username = "postgres";
		String password = "pass123";

		try {
			Class.forName("org.postgresql.Driver");
			// ** Connect DB
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement start = connection.createStatement();
			ResultSet rs = start.executeQuery("Select * from bank_account");
			while(rs.next()) {
				System.out.println("ID:" +rs.getString(1)+ "Name: "+rs.getString(2));
			
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

