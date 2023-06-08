<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dao.DoctorDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN DASHBOARD</title>
<style type="text/css">
.paint-card {
	margin-top: 25px;
	box-shadow: 0px 0px 10px blue;
}
</style>

</head>
<body>
	<%@ include file="navbar.jsp"%>

	<!-- If admin is not logged in, then admin's dashboard can't be accessed -->
	<c:if test="${ empty adminObj }">
		<c:redirect url="../AdminLoginPage.jsp"></c:redirect>
	</c:if>

	<div class="container p-5">

		<c:if test="${not empty errorMsg}">
			<p class="fs-3 text-center text-danger">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<c:if test="${not empty succMsg}">
			<div class="fs-3 text-center text-success" role="alert">${successMsg}</div>
			<c:remove var="succMsg" scope="session" />
		</c:if>


		<%DoctorDAO dao = new DoctorDAO(DBConnect.getConn()); %>
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br><%= dao.countDoctor() %>
						</p>
					</div>
				</div>
			</div>



			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							User <br><%= dao.countUser() %>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br><%=dao.countAppointment() %>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 mt-2">

				<div class="card paint-card " data-bs-toggle="modal"
					data-bs-target="#exampleModal">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Specialist <br><%= dao.countSpecialist() %>
						</p>
					</div>
				</div>

			</div>

		</div>
	</div>


</body>
</html>