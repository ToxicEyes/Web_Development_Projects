package com.servlet;

import javax.servlet.http.*;

import com.dao.SpecialistDAO;
import com.db.DBConnect;
import com.entity.User;

import java.io.IOException;

import javax.servlet.*;


public class AddSpecialist extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			
			String specName = req.getParameter("specName");
			SpecialistDAO dao = new SpecialistDAO(DBConnect.getConn());
			boolean f = dao.addSpecialist(specName);
			HttpSession session = req.getSession();
			
			
			//add specialist to database and show success msg
			if(f) {
				session.setAttribute("successMsg","Successfully added a specialist");
				res.sendRedirect("admin/index.jsp");
			}else {
				session.setAttribute("errorMsg","Something went wrong");
				res.sendRedirect("admin/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
