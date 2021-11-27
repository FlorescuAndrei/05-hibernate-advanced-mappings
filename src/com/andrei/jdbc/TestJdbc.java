package com.andrei.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {


		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate-advanced-mappings?useSSL=false&serverTimezone=UTC";
		String user = "student";
		String pass="student";
				
				try {
					System.out.println("Connecting to database: " +jdbcUrl);
					Connection con= DriverManager.getConnection(jdbcUrl, user, pass);
					
					System.out.println("Connection successful");
				}catch(Exception e) {
					e.printStackTrace();
				}

	}

}
