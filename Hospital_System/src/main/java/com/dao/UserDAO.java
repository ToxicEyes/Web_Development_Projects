package com.dao;
import java.sql.*;

import javax.servlet.ServletException;

import com.entity.User;

public class UserDAO {
	
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean userRegister(User u) throws Exception{
		boolean f = false;
		
//		Insert records
		String insert_query = "INSERT INTO user_details1 VALUES (?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(insert_query);
		pst.setInt(1,u.getId());
		pst.setString(2, u.getFullname());
		pst.setString(3, u.getEmail());
		pst.setString(4, u.getPassword());
		
		int icount = pst.executeUpdate();
		
		if(icount >= 1) {
			//if db is updated, f = true.
			f = true;
		}
		
		return f;
	}
	
	
	public User User_Login(String em,String ps){
		User u = null;
		try {
		//Select Query 
		String select_query = "SELECT * FROM user_details1 WHERE email = ? AND pass = ?";
		PreparedStatement pst = conn.prepareStatement(select_query);
		pst.setString(1, em);
		pst.setString(2, ps);
		
		ResultSet rs = pst.executeQuery();
		 
		while(rs.next()) {
			u = new User();
			u.setId(rs.getInt(1));
			u.setFullname(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
}
