package com.user.entity;
import javax.servlet.http.*;

import com.dao.AppointmentDAO;
import com.db.DBConnect;
import com.entity.Appointment;

import javax.servlet.*;

import java.io.IOException;
import java.sql.*;
public class AppointmentServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		int userid = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointDate = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phoneNo = req.getParameter("phoneNo");
		String diseases = req.getParameter("diseases");
		int docid = Integer.parseInt(req.getParameter("docid"));
		String address = req.getParameter("address");
		
		Appointment ap = new Appointment(userid, fullname, gender, age, appointDate, email, phoneNo, diseases, docid, address, "Pending");
		
		AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
		
		HttpSession session = req.getSession();
		
		
		if(dao.addAppointment(ap)) {
			session.setAttribute("successMsg", "Appointment Done!");
			res.sendRedirect("user_appointment.jsp");
		}else {
			session.setAttribute("errorMsg", "Something went wrong!");
			res.sendRedirect("user_appointment.jsp");
		}
	}
}
