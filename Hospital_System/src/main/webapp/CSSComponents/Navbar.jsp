<%--  <%@ include file="CSSComponent.jsp"%> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-light bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"
			style="text-decoration: underline"><i
			class="fa-thin fa-right-to-bracket"></i>Dev's Multi-speciality
			Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">


				<!-- if user is not logged in, then show default options -->
				
				<c:if test="${ empty userObj}">
				<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="AdminLoginPage.jsp">ADMIN</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="Doctor_LoginPage.jsp">DOCTOR</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="UserLogin.jsp">USER</a></li>
				</c:if>
				
				
					<!-- Navbar Links -->
					
					<c:if test="${not empty userObj }">
					
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="view_appointment.jsp">VIEW APPOINTMENT</a></li>

					<li class="nav-item dropdown active"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							${userObj.fullname} </a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						
						
						<li><a class="dropdown-item" href="UserLogout">Logout</a></li>
					</ul>
					</c:if>
			</ul>
		</div>
	</div>
</nav>
