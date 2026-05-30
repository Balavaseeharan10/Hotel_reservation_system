package com.management;
import java.sql.*;


public class DBConnectionManager {
	
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","vasee10");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}
