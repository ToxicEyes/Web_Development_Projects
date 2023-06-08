package com.doctor.servlet;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.dao.*;
import com.db.DBConnect;

public class UpdateStatus extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		int docid = Integer.parseInt(req.getParameter("did"));
		String comment = req.getParameter("comm");
		
		AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
		HttpSession session = req.getSession();
		
		if(dao.updateCommentStatus(id, docid, comment)) {
			session.setAttribute("successMsg", "Status Updated");
			res.sendRedirect("doc_patient.jsp");
		}else {
			session.setAttribute("errorMsg", "Something went wrong");
			res.sendRedirect("doc_patient.jsp");
		}
	}
}
