package com.s3s.finalProject.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project",
															"root", "Chinto2045");
			
		} catch(Exception ex) {
			System.out.println("unable to connect to db.");
			return null;
		}
	}
}
