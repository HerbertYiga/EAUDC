
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EAUDC</title>
<!-- booot strap,css and java script files -->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>





<!-- Script for validating that an image is captured -->

</head>
<body>

	<div class="navbar-wrapper">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">

						<li class="active"><a href="<c:url value="/AdminPanel"/>"><i
								class="glyphicon glyphicon-home"></i> Home</a></li>
						<li><a href="<c:url value="/viewUsersForEnable"/>"><i
								class="glyphicon glyphicon-book"></i> Enable Users</a></li>
						<li><a href="<c:url value="/ChangeUserPasswords"/>"><i
								class="glyphicon glyphicon-plus"></i> Change Password</a></li>


						<!--  <li><a href="<c:url value="/addStudent"/>"><i class="glyphicon glyphicon-comment"></i>  Verify Students</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Register Student</a></li>
             -->



					</ul>
					<ul class="nav navbar-nav pull-right">
						<li><a href="<c:url value="/Logout"/>"><i
								class="glyphicon glyphicon-off"></i> Logout</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="panel panel-default">



		<div class="panel-body">
			<div class="panel-heading">
				<h4>
					<b></b>
				</h4>
			</div>




			<table class="table table-striped table-bordered table-list">
				<thead>

					<tr>
						<th>Full Names</th>
						<th>User Name</th>
						<th>Email</th>


						<th>Phone Number</th>

						<th>Authority</th>


						<th style="color: #1E90FF; text-align: center">Edit</th>


					</tr>

				</thead>
				<tbody id="myTable">
					<c:forEach var="details" items="${list}">
						<tr>

							<td>${details.fullName}</td>
							<td>${details.userName}</td>
							<td>${details.email}</td>

							<td>${details.phoneNumber}</td>

							<td>${details.authority}</td>


							<td align="center"><a class="btn btn-primary"
								href="<c:url value="/edituserdetails/${details.userId}"/>"><em
									class="glyphicon glyphicon-edit"></em></a></td>




						</tr>
					</c:forEach>

				</tbody>
			</table>


			<br> <br>







			<!--  -->



		</div>

	</div>
	<!--/panel-body-->
	</div>
	<!--/panel-->




</body>
</html>