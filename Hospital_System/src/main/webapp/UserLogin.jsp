<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="CSSComponents/CSSComponent.jsp"%>
<%@ include file="CSSComponents/Navbar.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
<style>
.paint-card {
	margin-top: 25px;
	box-shadow: 0px 0px 10px blue;
}
</style>

</head>
<body>

	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">User Login</p>

					<c:if test="${not empty successMsg }">
						<p class="text-center text-success fs-3">${successMsg}</p>
						<c:remove var="successMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>

					<form action="UserLogin" method="post">
						<div class="mb-3">
							<label class="form-label">Email address</label> <input required
								name="email" type="email" class="form-control">
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label> <input required
								name="password" type="password" class="form-control">
						</div>

						<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						<br> Don't have an account? <a href="signup.jsp"
							class="text-decoration-none"> create one</a>
					</form>

				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>