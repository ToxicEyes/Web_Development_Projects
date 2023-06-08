package com.user.entity;
import com.dao.UserDAO;
import com.db.DBConnect;
import com.entity.User;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

//@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		try {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
//		get details from signup
		int id = Integer.parseInt(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password=  req.getParameter("password");
		
			User u = new User(id,fullname,email,password);
			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			HttpSession session = req.getSession();
			boolean f = dao.userRegister(u);
			
			if(f == true) {
				session.setAttribute("successMsg", "Registered Succesfully");
				res.sendRedirect("signup.jsp");
			}else {
				session.setAttribute("errorMsg", "Something went wrong!");
				res.sendRedirect("signup.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
