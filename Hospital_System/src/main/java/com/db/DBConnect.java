package com.db;
import java.sql.*;

public class DBConnect {
	public static Connection getConn(){
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","Dp@121202");
		}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}

}
