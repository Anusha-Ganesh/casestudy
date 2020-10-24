package com.cts.truyum.util;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
public class ConnectionHandler {
	private static Connection con=null;
	private static Properties prop=new Properties();
	public static Connection getConnection() throws SQLException, FileNotFoundException {
		
		try {
			FileInputStream fis=null;
			fis=new FileInputStream("connection.properties");
			prop.load(fis);
		    //Class.forName(prop.getProperty("driver"));
		    con=DriverManager.getConnection(prop.getProperty("connection-url"),prop.getProperty("user"),prop.getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection not established");
			e.printStackTrace();
		}
		return con;
     }
     
}
