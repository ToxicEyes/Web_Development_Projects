package com.doctor.servlet;
import javax.servlet.http.*;

import com.dao.DoctorDAO;
import com.dao.UserDAO;
import com.db.DBConnect;
import com.entity.Doctor;
import com.entity.User;

import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class doctor_login extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			DoctorDAO dao = new DoctorDAO(DBConnect.getConn());
			Doctor doctor = dao.login(email, password);
			
			
			//if user exists in database then he/she can process further
			if(doctor != null) {
				session.setAttribute("doctorObj",doctor );
				res.sendRedirect("doctor_index.jsp");
			}else {
				session.setAttribute("errorMsg","invalid email or password");
				res.sendRedirect("Doctor_LoginPage.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
