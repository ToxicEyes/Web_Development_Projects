<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="java.sql.*"%>
<%@ include file="CSSComponents/CSSComponent.jsp"%>
<%@ include file="CSSComponents/Navbar.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Management System</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Dancing+Script:wght@600&family=IBM+Plex+Mono:wght@300;400&family=Montserrat:ital@0;1&family=Prata&family=Roboto+Mono:wght@400;600&display=swap')
	;

.container {
	padding: 20px 32px;
	display: flex;
	flex-direction: row;
	gap: 20px;
	display: flex;
}

.img{
background-position: center;
background-repeat: no-repeat;
background-size: contain;
}

.card {
	padding: 20px 30px;
	border: 1px solid black;
	box-shadow: 5px 5px 20px black;
	width: 400px;
	border-radius: 12px;
	border: 1px solid black;
}

.cards_new {
	padding: 20px 40px;
	display: flex;
	gap: 20px;
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	referrerpolicy="no-referrer" />
</head>
<body>
	<%
	Connection con = DBConnect.getConn();
	%>


	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/img1.jpg" class="d-block w-100" alt="img1"
					height="500px" style="background-position: cover;">
			</div>
			<div class="carousel-item">
				<img src="images/img2.jpg" class="d-block w-100" alt="img2"
					height="500px" style="background-position: cover;">
			</div>
			<div class="carousel-item">
				<img src="images/img3.jpg" class="d-block w-100" alt="img3"
					height="500px" style="background-position: cover;">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>


	</div>

	<!-- Hero  Section-->
		<h2 style="text-align: center; text-decoration: underline;">Our HealthCare Services</h2>
	

	<div class="container">
		<div class="card">
			<p style="font-weight: bold">EMERGENCY AND TRAUMA</p>
			<p>Harmony offers comprehensive solutions for initial evaluation, revitalization, treatment, investigation, stabilization, monitoring, and disposition. We believe in delivering quick, potent, effective, and patient-centered quality care for the best outcome in any kind of emergency.</p>
		</div>

		<div class="card">
			<p style="font-weight: bold">INTENSIVE AND CRITICAL CARE UNIT</p>
			<p>The ICU & critical care units at Harmony Hospital is staffed with a multidisciplinary team of doctors that are capable of administering life-saving treatment across several different branches of medicine.</p>
		</div>

		<div class="card">
			<p style="font-weight: bold">CARDIOLOGY CARE</p>
			<p>At Harmony Hospital Cardiology unit we dedicate our efforts, time, and expertise to people suffering from heart disease enabling them to lead productive and healthy lives.</p>
		</div>

	</div>

	<h2 style="text-align: center; text-decoration: underline;">Clinics</h2>

	<!-- Cards Section -->
	<div class="container">

		<div class="card">
			<div class="card-body">
				<p style="font-weight: bold">
					Heart Rhythm Clinic
				</p>
				<p class="card-text">A good heart beats regularly.Irregular
					Heartbeats are ground for concern.At Heart Rhythm Clinic , get the
					finest advice from our specialists.</p>
			</div>
		</div>

		<div class="card">

			<div class="card-body">
				<p style="font-weight: bold">
					Allergy Clinic
				</p>
				<p class="card-text">Allergies are painful.At our allergy clinic, with a single 
				serum sample, we detect around 300 allergens.
				</p>
			</div>
		</div>

		<div class="card">
			<div class="card-body">
			<p style="font-weight: bold">
					Skin and Hair Clinic
				</p>
				<p class="card-text">Hair and Skin are final addition to good looks.Our Skin and Hair clinic
				,by treating skin and hair issues,tops one's good looks and complements the efforts of our Aesthetic Clinic.
				</p>
			</div>
		</div>
	</div>

	<footer>
		<p
			style="background-color: green; color: white; text-align: center; margin: 0; padding: 4px 6px;">@
			Copyrights Dev's MultiSpeciality Hospital 2023-24</p>
	</footer>
</body>
</html>