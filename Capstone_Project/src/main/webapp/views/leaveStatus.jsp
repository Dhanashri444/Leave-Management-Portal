<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <title>Admin | Check Status</title>
</head>
<body>
<%@ include file="/views/adminDashboard.jsp" %>
 <div id="content">
                <!-- dashboard inner -->
                 <p class="text-center text-dark" style="font-size: 30px;">My Leave Status</p>
                    <br>
                    <hr>
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th>Emp Id</th>
                    		<th>Name</th>
	                    	<th>Leave Type</th>
	                    	<th>Start Date</th>
	                    	<th>End Date</th>
	                    	<th>Period</th>
	                    	<th>Status</th>
	                    	
                    	</tr>
					</thead>
					<tbody>
						<c:forEach items="${hrLeaveList}" var="leaveList">
                    			<tr>
                    				<td>${leaveList.empId}</td>
                    				<td>${leaveList.firstName} ${leaveList.lastname}</td>
                    				<td>${leaveList.leaveType}</td>
                    				<td>${leaveList.startDate}</td>
                    				<td>${leaveList.endDate}</td>
                    				<td>${leaveList.period}</td>
                    				<td>${leaveList.status}</td>
                    				
                    			</tr>
                    		</c:forEach>
					</tbody>
				</table>
            </div>
   

    <!--linking the bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>