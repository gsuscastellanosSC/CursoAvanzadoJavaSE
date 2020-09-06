package com.sc.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.sc.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+BD, USER, PASSWORD);
			if (connection != null) {
//				System.out.println("Connection Successful !"+connection);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		return connection;
	}
	
}
