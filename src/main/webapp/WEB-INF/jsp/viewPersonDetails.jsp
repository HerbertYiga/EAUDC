
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EAUDC</title>
<!-- booot strap,css and java script files -->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>





<!-- Script for validating that an image is captured -->

</head>
<body>

<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                   
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                       
                              <li class="active"> <a href="<c:url value="/UserPanel"/>"><i class="glyphicon glyphicon-home"></i> Home</a></li>
                 
                
                
                <li><a href="<c:url value="/addStaff"/>"><i class="glyphicon glyphicon-plus"></i>Add</a></li>
                 <li><a href="<c:url value="/viewStaffDetails"/>"><i class="glyphicon glyphicon-book"></i> Manage Staff</a></li>
              
                
                <!--  <li><a href="<c:url value="/addStudent"/>"><i class="glyphicon glyphicon-comment"></i>  Verify Students</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Register Student</a></li>
             -->
                 <li><a href="<c:url value="/adminLogout"/>"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
                            
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
<br><br><br>
<div class="panel panel-default" >
                  <div class="panel-heading"><h4><b></b></h4></div>
                  <div class="panel-body">
                     <!-- -Form    -->
                      <form:form id="yourForm" action="viewPersonDetailsById" method="POST" commandName="studentsemailmodel" >    
                 
                   <input type="submit" value="select items for printing" />
                   <h6 style="color:#ff0000;">${error}</h6>
             
                  <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                    <td></td>
                    <th>Sir Name</th>
                    <th>Other Name</th>
                       <th>Universty</th>
                 
                    <th>Category</th>
                    
                       <th>Image</th>
                     
                 
                    </tr> 
                  </thead>
                  <tbody id="myTable">
               <c:forEach var="person" items="${list}"> 
                          <tr>
                          <td><input type="checkbox" name="checkedIds" value="${person.personId}"> </td>
                            <td> ${person.sirName}</td>
                            <td> ${person.otherName}</td>
                    <td> ${person.university}</td>
                     <td> ${person.category}</td>
    
                          <td>
                     <img width="50" height="50" src="<c:url value='/resources/image/${person.imageLink}'/>" alt="no image found" id="pic" />
 
                          </td>
                         
                 
             
                          </tr>
                             </c:forEach>
                          
                        </tbody>
                </table>
           
                                                            
    </form:form>

<br><br>


  

        
        
        
        
                <!--  -->
                    
                    
                    
                    </div>

                  </div><!--/panel-body-->
              </div><!--/panel-->   



  
</body>
</html>