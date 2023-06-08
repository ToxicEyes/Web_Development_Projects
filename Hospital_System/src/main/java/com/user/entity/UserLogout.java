package com.user.entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UserLogout extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		HttpSession session = req.getSession();
		session.removeAttribute("userObj");
		session.setAttribute("successMsg", "USER Loggedout Successfully!");
		res.sendRedirect("UserLogin.jsp");
	}
}
