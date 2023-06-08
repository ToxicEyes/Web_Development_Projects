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
<title>Patient</title>
</head>
<body>
	<c:if test="${empty doctorObj}">
		<c:redirect url="Doctor_LoginPage.jsp"></c:redirect>
	</c:if>
	<%@ include file="doctor_navbar.jsp"%>
	
	
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				
				<c:if test="${not empty successMsg }">
						<p class="text-center text-success fs-3">${successMsg}</p>
						<c:remove var="successMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
				
				
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
							<th scope="col">Status</th>
							<th scope="col">Action</th>
							
						</tr>
					</thead>
					<tbody>
						 <%
						Doctor d =  (Doctor)session.getAttribute("doctorObj");
						 AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
						 List<Appointment> list = dao.getAllAppointmentByDoctor(d.getId());
						 for(Appointment ap : list) 
						 {%>
						 <tr> 
							<th><%=ap.getFullname()%></th>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getAppointDate()%></td>
							<td><%=ap.getEmail()%></td>
							<td><%=ap.getPhoneNo()%></td>
							<td><%=ap.getDiseases()%></td>
							<td><%=ap.getStatus()%></td>
							<td>
							
							
							<%
							if("Pending".equals(ap.getStatus()))
							{%>
							<a href = "doc_comment.jsp?id=<%=ap.getId()%>" class = "btn btn-success btn-small">Comment</a>
							<%}else{%>
							<a href = "doc_comment.jsp?id=<%=ap.getId()%>" class = "btn btn-success btn-small disabled">Comment</a>
							<%}
							%>
							
							</td>
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