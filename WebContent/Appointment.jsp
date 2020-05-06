<%@page import="AppointmentModel.Appointment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors' Portal</title>
<link href="myStyle.css" rel="stylesheet" />
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="jquery-3.5.0.min.js"></script>
<script src="Appointment.js"></script>

</head>
<body>
	<div class="container">

		<p class="font-weight-bold">
		<center>
			<h1>Appointment' Portal</h1>
		</center>
		</p>
		<br> <br>
		<fieldset>

			<legend>Add Sessions</legend>
			<form method="post" id="DOC"action="Appointment.jsp">


				Patient NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="nic"
					type="text" class="form-control" name="nic"> <br>
				Doctor's Specialty&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="doc_spec" class="form-control" name="doc_spec">
				 <br> Doctor
				Doctor&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="doctor" class="form-control"
					name="doctor"> <br>

					<br> Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="date" name="date" class="form-control" id="date" >
					<br>
				
				
				<br> Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="time" name="time" class="form-control" id="date" >
					<br>
					<br> Doctor
				Hospital&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="hospital" class="form-control"
					name="hospital"> <br> 

					<br>
				<div id="alertSuccess" class="alert alert-success"></div>
 				<div id="alertError" class="alert alert-danger"></div>
					
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary btn-lg btn-block">

				<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">

					
						
				</div>
			</form>
		</fieldset>
		<br> <br> <br>
		
		

</div>
		
		
		

		<div class="container">
			<fieldset>
				<legend>View session</legend>
				<form method="post" action="Doctor.jsp">
					<%
						Appointment viewDoc = new Appointment();
									out.print(viewDoc.readSession());
					%>



				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>