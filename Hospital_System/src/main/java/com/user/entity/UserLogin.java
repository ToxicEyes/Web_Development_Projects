package com.user.entity;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entity.User;
import java.sql.*;

public class UserLogin extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		User user =  dao.User_Login(email, password) ;
		
		//if user exists in database then he/she can process further
		if(user != null) {
			session.setAttribute("userObj",user);
			res.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg","invalid email or password");
			res.sendRedirect("UserLogin.jsp");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
