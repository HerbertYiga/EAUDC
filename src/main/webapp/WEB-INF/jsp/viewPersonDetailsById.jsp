
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

<style>
#printcard {
    margin: auto;
    width: 40%;
    border: 3px solid #73AD21;
    padding: 10px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>





<!-- Script for printing the card -->
<Script type="text/javascript">
	function printCard(printcard) {

		var printCard = document.getElementById("printcard");
		w = window.open();
		w.document.write(printCard.outerHTML);
		w.print();
		w.close();

	}
</Script>

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

						<li class="active"><a href="<c:url value="/UserPanel"/>"><i
								class="glyphicon glyphicon-home"></i> Home</a></li>



						<li><a href="<c:url value="/viewPersonDetails"/>"><i
								class="glyphicon glyphicon-book"></i> Print tag</a></li>
						<li><a href="<c:url value="/addStaff"/>"><i
								class="glyphicon glyphicon-plus"></i>Add</a></li>


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
		<div class="panel-heading">
			<h4>
				<b></b>
			</h4>
		</div>
		<div class="panel-body">

			<!-- PRINTING REDIRECTION FORM -->
			<form:form id="" action="search" method="POST"
				class="form-horizontal" commandName="print">
				<fieldset>

					<div class="modal-footer">
						<input type="submit" id="register" onclick="printCard()"
							value="print"></input>

					</div>
				</fieldset>
			</form:form>
			<!-- -Form    -->
<hr>
			<br> <br>
			<br>>
		  <!--Card image-->
		  <div id="printcard">
		
		  <c:forEach var="person" items="${list}">
		     <table border="1" cellpadding=""  width="400"  class="libcard">     

	<tbody><tr>
	
		<th style="text-align:center" >EAST AFICAN UNIVERSITY DEBATE CHAMPION SHIP</th>
		
	</tr>
	<tr  height="200px">
			<td> <b>Sur Name:&nbsp;&nbsp;</b><b style="color: #ff0000;">${person.sirName}</b><img width="150" height="150" src="<c:url value='/resources/image/${studentdetails.imageLink}'/>" alt="Photo of Youthful William" id="pic" align="right" style="  padding-top: 10px;
    padding-right: 10px;
 
    "  />
		<br> <br><b>Other Name:</b><b style="color: #ff0000;">${person.otherName}</b>
		
		
		
		<br> <br><b>StartDate:</b><b style="color: #ff0000;">${person.university}</b>
		
		<br> <br><b>Expiry date:</b><b style="color: #ff0000;">${person.category}}</b>
		
		
		</b><br><br><b >Reg No:</b>
		
		
		<img width="50" height="50"
								src="<c:url value='/resources/image/${person.imageLink}'/>"
								alt="no image found" id="pic" />
		
		

		
		</td>
		
		
		

	</tr>
	

      
     </tbody>
                </table>
                <br><br>     <br><br>  <br><br>      
            </c:forEach>
        
            <!--/.Card--



</div>
</div>
			<br> <br>









		</div>

	</div>
	<!--/panel-body-->
	</div>
	<!--/panel-->




</body>
</html>