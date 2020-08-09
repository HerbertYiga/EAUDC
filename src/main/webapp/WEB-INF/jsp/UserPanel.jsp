
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script>
function show(input) {
    debugger;
    var validExtensions = ['jpg','png','jpeg']; //array of valid extensions
    var fileName = input.files[0].name;
    var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);
    if ($.inArray(fileNameExt, validExtensions) == -1) {
        input.type = ''
        input.type = 'file'
        $('#user_img').attr('src',"");
        alert("Only these file types are accepted : "+validExtensions.join(', '));
    }
    else
    	
    	if((input.files && input.files[0])==null){
    		alert("Please Upload Photo")
    	}
    	else
    {
    if (input.files && input.files[0]) {
        var filerdr = new FileReader();
        filerdr.onload = function (e) {
            $('#user_img').attr('src', e.target.result);
        }
        filerdr.readAsDataURL(input.files[0]);
    }
    }
}


</script>

<script>

function Checkfiles()
{
var fup = document.getElementById('file');
var fileName = fup.value;
var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "doc")
{
return true;
} 
else
{
alert("please make sure that you have uploaded a photo");
fup.focus();
return false;
}
}

</script>


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
					<a style="color: green"><strong><i class=""></i> put
							user names</strong></a>
				</h4>

				<hr style="border-right: 1px solid black">

				<ul class="list-unstyled">
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#userMenu"> </a>
						<ul class="list-unstyled collapse in" id="userMenu"
							style="border-right: 1px solid black">
							<li class="active"><a href="<c:url value="/UserPanel"/>"><i
									class="glyphicon glyphicon-home"></i> Home</a></li>



							<li><a href="<c:url value="/viewPersonDetails"/>"><i
									class="glyphicon glyphicon-print"></i>  Print Tag</a></li>
							<li><a href="<c:url value="/viewStaffDetails"/>"><i
									class="glyphicon glyphicon-book"></i> Manage Staff</a></li>


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

				<!-- -Form    -->




				<hr>



				<hr>


				<hr>
			</div>
			<!-- /col-3 -->
			<div class="col-md-9">


				<a href="#"><strong><i
						class="glyphicon glyphicon-dashboard"></i> My Dashboard</strong></a>

				<hr>

				<div class="row">

					<form:form id="" action="savePersonDetails"
						enctype="multipart/form-data" method="POST"
						class="form-horizontal" commandName="person">
						<fieldset>


							<div class="form-group">
								<label class="col-lg-1 control-label" for="firstName"></label>
								<div class="col-lg-10">
									<form:input path="sirName" class="form-control"
										placeholder="Sir Name" id="one" type="text" />
									<form:errors path="sirName" cssStyle="color: #ff0000;" />
								</div>

							</div>
							<br>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="firstName"></label>
								<div class="col-lg-10">
									<form:input path="otherName" class="form-control"
										placeholder="Other Name" id="one" type="text" />
									<form:errors path="otherName" cssStyle="color: #ff0000;" />
								</div>

							</div>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="firstName"></label>
								<div class="col-lg-10">
									<form:input path="university" class="form-control"
										placeholder="University" id="one" type="text" />
									<form:errors path="university" cssStyle="color: #ff0000;" />
								</div>

							</div>
							<br> <br>
							<div class="form-group">
								<label class="col-lg-1 control-label" for="firstName"></label>

								<div class="col-lg-5">

									<form:select path="category" class="form-control">

										<option value="" disabled selected>Category</option>
										<option value="Debator">Debator</option>
										<option value="Adjudicator">Adjudicator</option>
										<option value="observer">Observer</option>
										<option value="councilMember">Council Member</option>
										<option value="Org.com.offical">Org.com.offical</option>
										<option value="sponsor">Sponsor</option>
										<option value="sponsor">Volunteer</option>



									</form:select>

								</div>

								<div class="col-lg-5">

									<form:select path="country" class="form-control">

										<option value="" disabled selected>Country</option>
										<option value="Uganda">Uganda</option>
										<option value="Tanzania">Tanzania</option>
										<option value="Rwanda">Rwanda</option>
										<option value="Kenya">Kenya</option>
										<option value="southSudan">South Sudan</option>
										<option value="Burundi">Burundi</option>
										<option value="Burundi">Other Countries</option>




									</form:select>

								</div>


							</div>





							<br>
							<div class="form-group">
								<label class="col-lg-2 control-label" for="images">Image</label>
								<div class="col-md-4">
									<div>
										<img id="user_img" height="130" width="130"
											style="border: solid" /><br> <br>
									</div>
									<div>
										<form:input path="images" class="" type="file" id="file"
											name="file" onchange="show(this)" />

										<form:errors path="images" cssStyle="color: #ff0000;" />
									</div>
								</div>
							</div>








							<br> <br> <br>








							<div class="modal-footer">
								<button class="btn btn-primary" type="submit" onClick="return Checkfiles()">Submit</button>
								<button class="btn btn-default" data-dismiss="modal"
									type="button">Cancel</button>
							</div>
							<!-- end modal-footer -->
						</fieldset>
					</form:form>



					<br> <br>
					<!-- center left-->
					<!--/col-->


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