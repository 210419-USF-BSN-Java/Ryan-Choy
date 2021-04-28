package com.revature.shop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	private static Connection connection;
	
	private DatabaseConnect() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "R3v@ture"; // DB user name and password.
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

}
