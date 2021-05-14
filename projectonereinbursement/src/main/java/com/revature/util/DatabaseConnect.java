package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnect {

	private static Connection connection;
	private static final String dbName = "postgres";
	private static final String hostName = System.getenv("URL");
	private static final String userName = System.getenv("NAME");
	private static final String password = System.getenv("PASS");
	private static final String url = "jdbc:postgresql://" + hostName + ":" + 5432 + "/" + dbName + "?user=" + userName
			+ "&password=" + password;

	public static Connection getConnection() throws SQLException {

		if (connection == null || connection.isClosed()) {
			try {
				connection = DriverManager.getConnection(url);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return connection;
	}

}
