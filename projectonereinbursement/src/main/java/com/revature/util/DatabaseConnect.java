package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnect {

	private static Connection connection;

	public static Connection getEnvConnection() throws SQLException
	{

		String url = System.getenv("URL");
		String username = System.getenv("USER_NAME");
		String password = System.getenv("PASSWORD");

		if(connection == null || connection.isClosed()) {
		connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}

}
