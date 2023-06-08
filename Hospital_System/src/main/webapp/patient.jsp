<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.dao.DoctorDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Appointment"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.dao.SpecialistDAO"%>
<%@ page import="com.dao.AppointmentDAO"%>
<%@ page import="com.entity.Specialist"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Patient</title>
</head>
<body>

	<%@ include file="outer_navbar.jsp"%>
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						 <%
						AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
						List<Appointment> list = dao.getAllAppointment();
						DoctorDAO dao2 = new DoctorDAO(DBConnect.getConn());
						for(Appointment ap : list){
							Doctor d = dao2.getDoctorById(ap.getDocid());
						%>
						<tr>
							<th><%= ap.getFullname() %></th>
							<td><%= ap.getGender()%></td>
							<td><%= ap.getAge() %></td>
							<td><%= ap.getAppointDate() %></td>
							<td><%= ap.getEmail() %></td>
							<td><%= ap.getPhoneNo() %></td>
							<td><%= ap.getDiseases() %></td>
							<td><%= d.getFullname()%></td>
							<td><%= ap.getAddress() %></td>
							<td><%= ap.getStatus() %></td>
						</tr>
						<% 	
						}
						%>
						
						


					</tbody>
				</table>

			</div>
		</div>
	</div>
	
</body>
</html>