package com.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.entity.User;

import java.sql.*;
import java.io.*;

public class AdminLogin extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		//Admin can access any page, as new User
		//if email and password is not for admin,then he/she is normal user
		if(email.equals("admin12@gmail.com") && password.equals("123456")) {
			session.setAttribute("adminObj",new User());
			res.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("errorMsg","invalid email or password");
			res.sendRedirect("AdminLoginPage.jsp");
		}
	}
}
