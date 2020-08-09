
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EAUDC</title>
<!-- booot strap,css and java script files -->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/js/theadmin.js"/>">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/theadmin.js"/>"></script>

</head>
<body>



	<!------ Include the above in your HEAD tag ---------->

	<!-- Header -->
	<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-toggle"></span>
				</button>
				<a class="navbar-brand" href="#" style="color: #1E90FF;">EAST
					AFRICAN UNIVERSITY DEBATE CHAMPIONSHIP</a>

			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">


				<li><a href="<c:url value="/Logout"/>"><i
								class="glyphicon glyphicon-off"></i> Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /Header -->

	<!-- Main -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<!-- Left column -->
				<h4>
					<a style="color: green"><strong><i class=""></i> ADMIN</strong></a>
				</h4>

				<hr style="border-right: 1px solid black">

				<ul class="list-unstyled">
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#userMenu"> </a>
						<ul class="list-unstyled collapse in" id="userMenu"
							style="border-right: 1px solid black">
							<li class="active"><a href="<c:url value="/AdminPanel"/>"><i
									class="glyphicon glyphicon-home"></i> Home</a></li>
							<li><a href="<c:url value="/viewUsers"/>"><i
									class="glyphicon glyphicon-book"></i> Manage Users</a></li>
							<li><a href="<c:url value="/viewStaffDetails"/>"><i
									class="glyphicon glyphicon-plus"></i> Add to Archive</a></li>


							<!--  <li><a href="<c:url value="/addStudent"/>"><i class="glyphicon glyphicon-comment"></i>  Verify Students</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Register Student</a></li>
             -->
							<li><a href="<c:url value="/adminLogout"/>"><i
									class="glyphicon glyphicon-off"></i> Logout</a></li>




						</ul></li>
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#menu2"> <br> <a href="#"><strong>
									View Reports</strong></a>

					</a>

						<ul class="list-unstyled collapse" id="menu2">
							<li><a href="#">Information & Stats</a></li>
							<li><a href="#">Views</a></li>
							<li><a href="#">Requests</a></li>
							<li><a href="#">Timetable</a></li>
							<li><a href="#">Alerts</a></li>
						</ul></li>

				</ul>

				<hr>

				<!-- Form  -->



				<hr>



				<hr>


				<hr>
			</div>
			<!-- /col-3 -->
			<div class="col-md-9">


				<a href="#"><strong><i
						class="glyphicon glyphicon-dashboard"></i> Dashboard,Edit User</strong></a> <BR>
				<hr>

				<div class="row">


					<br> <br>
					<form:form id="" action="/eaudcSytsem/updateDetails" method="POST"
						class="form-horizontal" commandName="edituser">
						<fieldset>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="firstName"> </label>
								<div class="col-lg-10">
									<form:input path="fullName" class="form-control"
										placeholder="Full Name" id="one" type="text"
										value="${user.fullName}" />
									<form:errors path="fullName" cssStyle="color: #ff0000;" />
								</div>

							</div>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="firstName"> </label>
								<div class="col-lg-10">
									<form:input path="userName" class="form-control"
										placeholder="userName" id="one" type="text"
										value="${user.userName}" />
									<form:errors path="userName" cssStyle="color: #ff0000;" />
								</div>

							</div>

							<br>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="otherName"></label>
								<div class="col-lg-10">
									<form:select path="authority" class="form-control">
										<option value="" disabled selected>SELECT AUTHORITY</option>
										<form:option value="ROLE USER">ROLE USER</form:option>

									</form:select>
								</div>

							</div>

							<br>

							<div class="form-group">
								<label class="col-lg-1 control-label" for="otherName"> </label>
								<div class="col-lg-10">
									<form:input path="phoneNumber" class="form-control"
										placeholder="Phone Number" type="text"
										value="${user.phoneNumber}" />
									<form:errors path="phoneNumber" cssStyle="color: #ff0000;" />
								</div>

							</div>



							<div class="form-group">
								<label class="col-lg-1 control-label" for="otherName"></label>
								<div class="col-lg-10">
									<form:input path="email" class="form-control"
										placeholder="Email" type="email" value="${user.email}" />
									<form:errors path="email" cssStyle="color: #ff0000;" />
									<h5 style="color: #ff0000;">${error}</h5>
								</div>

							</div>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="otherName"></label>
								<div class="col-lg-10">
									<form:input path="userId" class="form-control"
										placeholder="Email" type="hidden" value="${user.userId}" />
									<form:errors path="userId" cssStyle="color: #ff0000;" />
									<h5 style="color: #ff0000;">${error}</h5>
								</div>

							</div>









							<br> <br> <br>








							<div class="modal-footer">
								<button class="btn btn-primary" type="submit"
									onClick="return Checkfiles()">Submit</button>
								<button class="btn btn-default" data-dismiss="modal"
									type="button">Cancel</button>
							</div>
							<!-- end modal-footer -->
						</fieldset>
					</form:form>


					<hr>


					<hr>


				</div>
				<!--/col-span-9-->
			</div>
		</div>
		<!-- /Main -->

		<h5 style="text-align: center;">
			All rights reserved <a href=""><strong>Kyambogo
					University Debate Association</strong></a>
		</h5>

		<!-- /.modal -->
</body>
</html>