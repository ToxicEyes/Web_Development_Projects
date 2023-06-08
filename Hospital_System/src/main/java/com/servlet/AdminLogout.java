package com.servlet;

import javax.servlet.http.*;

import java.io.IOException;

import javax.servlet.*;


public class AdminLogout extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		HttpSession session = req.getSession();
		session.removeAttribute("adminObj");
		session.setAttribute("successMsg", "ADMIN Loggedout Successfully!");
		res.sendRedirect("AdminLoginPage.jsp");
	}

}
