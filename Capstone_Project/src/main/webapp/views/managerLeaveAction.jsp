<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--linking bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
     `integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="assets/js/script.js"></script>
 <title>Manager | Manage Leaves</title>
</head>
<body>
<%@ include file="/views/managerDashboard.jsp" %>

<div id="content">
                <!-- dashboard inner -->
				<div>
                    <p class="text-center text-dark" style="font-size: 30px;">Approve/Reject Leaves</p>
                    <br>
                    <hr>
                    <form action="/managerUpdateStatus" >
                        <div>
                            <br>
                            <!--first row-->
                            <div class="row">
                            	
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empId" value="<c:out value='${EmpApplyLeave.empId}'/>" readonly>
                                        <label for="EmployeeId">Employee Id</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpFirstName"
                                            placeholder="First Name" name="firstName" value="<c:out value='${EmpApplyLeave.firstName}'/>" readonly>
                                        <label for="EmpFirstName">First Name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="floatingInput"
                                            placeholder="Last Name" name="lastname" value="<c:out value='${EmpApplyLeave.lastname}'/>" readonly>
                                        <label for="floatingInput">Last Name</label>
                                    </div>
                                </div>

                            </div>
                            <!--Second row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="floatingInput"
                                            placeholder="Leave Type" name="leaveType" value="<c:out value='${EmpApplyLeave.leaveType}'/>" readonly>
                                        <label for="floatingInput">Leave Type</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="startDate" placeholder="Start Date"
                                             name="startDate" onchange="cal()" value="<c:out value='${EmpApplyLeave.startDate}'/>" readonly>
                                        <label for="startDate">Start Date</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="endDate" placeholder="End Date"
                                            name="endDate" onchange="cal()" value="<c:out value='${EmpApplyLeave.endDate}'/>" readonly>
                                        <label for="endDate">End Date</label>
                                    </div>
                                </div>
                            </div>
                            <!--Third row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="number" class="form-control" id="period" placeholder="Leave Period"
                                            name="period" value="<c:out value='${EmpApplyLeave.period}'/>" readonly>
                                        <label for="period">Leave Period</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="id" value="<c:out value='${EmpApplyLeave.id}'/>" hidden>
                                        
                                    </div>
                                </div>
                                <div class="col">

                                    <div style="display: flex; flex-direction: row; column-gap: 20px;">
                                        <div>
                                            <lable>Action</lable>
                                        </div>
                                        <div class="form-check mb-0">
                                            <input class="form-check-input me-2" type="radio" name="status" value="Approved"
                                                id="approve" required/>
                                            <label class="form-check-label" for=""approve"">
                                                <b class="text-success">Approve</b>
                                            </label>
                                        </div>
                                        <div class="form-check mb-0">
                                            <input class="form-check-input me-2" type="radio" name="status"
                                                value="Rejected" id="reject" />
                                            <label class="form-check-label" for="reject">
                                                <b class="text-danger">Reject</b>
                                            </label>
                                        </div>
                                      
                                    </div>
                                </div>
                            </div>
                        </div>

                        <br>
                        <button class="btn btn-primary" type="submit"
                            style="padding-left: 2.5cm;  padding-right: 2.5cm;">Submit
                        </button>
                    </form>
                </div>
            </div>
        </div>
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