<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Dashboard</title>
<style type="text/css">
.paint-card {
	margin-top: 25px;
	box-shadow: 0px 0px 10px blue;
}


</style>
</head>
<body>

	<c:if test="${empty doctorObj}">
		<c:redirect url="Doctor_LoginPage.jsp"></c:redirect>
	</c:if>
	<%@ include file="doctor_navbar.jsp"%>

<p class = "text-center fs-3">Doctor Dashboard</p>
	<div class="container p-5">
	<div class="row">
		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fas fa-user-md fa-3x"></i><br>
					<p class="fs-4 text-center">
						Doctor <br>5
					</p>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fa-regular fa-calendar-check fa-3x"></i><br>
					<p class="fs-4 text-center">
						Total Appointment <br>5
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>