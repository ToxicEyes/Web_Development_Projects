package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDAO;
import com.db.DBConnect;
import com.entity.Doctor;
public class AddDoctor extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			String fullname = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String specialist = req.getParameter("spec");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			Doctor d = new Doctor(fullname, dob, qualification, specialist, email, dob, password);
			DoctorDAO dao = new DoctorDAO(DBConnect.getConn());
			HttpSession session = req.getSession();
			boolean doctorObj = dao.registerDoctor(d);
			
			if(doctorObj) {
				session.setAttribute("successMsg", "Doctor Added");
				res.sendRedirect("add_doctor.jsp");
			}else {
				session.setAttribute("errorMsg", "Something went Wrong");
				res.sendRedirect("add_doctor.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
