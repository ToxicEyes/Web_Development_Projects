<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.db.DBConnect"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.dao.SpecialistDAO"%>
<%@ page import="com.entity.Specialist"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Doctor</title>
</head>
<body>
	<%@ include file="admin/navbar.jsp"%>
	<!-- Bug: dont access patient when you are in admin/doctor ot admin/Patient
	dont access anything else
	 -->
	<c:if test="${not empty successMsg }">
		<p class="text-center text-success fs-3">${successMsg}</p>
		<c:remove var="successMsg" scope="session" />
	</c:if>
	<c:if test="${not empty errorMsg }">
		<p class="text-center text-danger fs-5">${errorMsg}</p>
		<c:remove var="errorMsg" scope="session" />
	</c:if>

	<form action="AddDoctor" method="post">
		<div class="mb-3">
			<label class="form-label">Full Name</label> <input type="text"
				required name="fullname" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">DOB</label> <input type="date" required
				name="dob" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">Qualification</label> <input required
				name="qualification" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Specialist</label> <select name="spec"
				required class="form-control">
				<option>--select--</option>

				<%
				SpecialistDAO dao = new SpecialistDAO(DBConnect.getConn());
				List<Specialist> list = dao.getAllSpecialist();
				for (Specialist s : list) {
				%>
				<option><%=s.getSpName()%></option>
				<%
				}
				%>

			</select>
		</div>

		<div class="mb-3">
			<label class="form-label">Email</label> <input type="text" required
				name="email" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">Mob No</label> <input type="text" required
				name="mobno" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">Password</label> <input required
				name="password" type="password" class="form-control">
		</div>

		<input type="submit">
	</form>

</body>
</html>