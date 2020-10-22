package com.cts.truyum.util;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class ConnectionHandler {
     
	public static Connection getConn() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/lch_marketplace";
			try {
				con=DriverManager.getConnection(url,"root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
     }
     
}
