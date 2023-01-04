<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="assets/js/script.js"></script>
<title>Insert title here</title>
</head>
<style>

#content{

margin-left: 300px;

}

.form-floating{
width:350px
}

</style>
<body>
<%@ include file="/views/adminDashboard.jsp" %>

<div id="content">
                <!-- dashboard inner -->
				<div>
                    <p class="text-center text-dark" style="font-size: 30px;">Edit Profile Details</p>
                    <br>
                    <hr>
                    <form action="/hrUpdateProfile" method="post" onsubmit="return validate()">
                        <div>
                            <br>
                            <p class="text-center text-dark" style="font-size: 20px;">Personal Details</p>
                            <!--first row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empId" value="<c:out value='${empDetails.empId}'/>" readonly>
                                        <label for="EmployeeId">Employee Id</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpFirstName"
                                            placeholder="First Name" name="empFirstName" value="<c:out value='${empDetails.empFirstName}'/>" readonly>
                                        <label for="EmpFirstName">First Name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpLastName"
                                            placeholder="Last Name" name="empLastName" value="<c:out value='${empDetails.empLastName}'/>" readonly>
                                        <label for="EmpLastName">Last Name</label>
                                    </div>
                                </div>

                            </div>
                            <!--Second row-->
                            <div class="row">
                                <div class="col">
									<div class="form-floating mb-3">
                                        <input type="text" class="form-control" 
                                            placeholder="Gender" name="gender" value="<c:out value='${empDetails.gender}'/>"   readonly>
                                        <label for="floatingInput">Gender</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" 
                                            placeholder="Role" name="empRole" value="<c:out value='${empDetails.empRole}'/>"   readonly>
                                        <label for="floatingInput">Role</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeContact"
                                            placeholder="Contact Number" name="empContact" value="<c:out value='${empDetails.empContact}'/>"  name="empContact" required>
                                        <label for="floatingInput">Contact Number</label>
                                    </div>
                                </div>
                            </div>
                            <!--Third row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" id="EmployeeEmail"
                                            placeholder="Email address" name="empEmail" value="<c:out value='${empDetails.empEmail}'/>" readonly>
                                        <label for="EmployeeEmail">Email address</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="EmployeeDOB"
                                            placeholder="EmployeeDOB" min="1972-01-01" max="2004-01-01" name="empDob" value="<c:out value='${empDetails.empDob}'/>" readonly>
                                        <label for="EmployeeDOB">DOB (Between 18 to 50 years)</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="EmployeeJoiningDate"
                                            placeholder="Joining Date" name="empJoining" value="<c:out value='${empDetails.empJoining}'/>" readonly>
                                        <label for="EmployeeJoiningDate">Joining Date</label>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <p class="text-center text-dark" style="font-size: 20px;">Login Details</p>
                            <!--fourth row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeUsername"
                                            placeholder="Set Username" name="empUsername" value="<c:out value='${empDetails.empUsername}'/>" readonly>
                                        <label for="EmployeeUsername">Set Username</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" id="EmployeePassword"
                                            placeholder="Set Password" name="empPassword" value="<c:out value='${empDetails.empPassword}'/>" required>
                                        <label for="EmployeePassword">Set Password</label>
                                    </div>
                                  
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" id="EmployeeReEnter"
                                            placeholder="Re-enter Password" name="empReEnter" required>
                                        <label for="EmployeeReEnter">Re-enter Password</label>
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
	
	
	<script>
	function validate(){
		/** Validation for Contact Number */
	    var contact = document.getElementById("EmployeeContact").value;
	    var ContactRegExp = /[0-9]/;

	    if (!ContactRegExp.test(contact) || specialChars.test(contact) || contact == " " || contact == "  ") {
	        window.alert("Invalid Contact Number");
	        return false;
	    }
	    if (contact.length != 10) {
	        window.alert("Contact Number Should be of 10 digits.");
	        return false;
	    }

	    /**Validation for Password */
	    var password = document.getElementById("EmployeePassword").value;
	    var passwordRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;

	    if (!passwordRegExp.test(password) || password == " " || password == "  ") {
	        window.alert("Password must contain 1. atlest one UpperCase 2. atlest one LowerCase 3. atlest one Numeric value 4. atlest one special Character");
	        return false;
	    }
	    if (password.length < 8 || password.length > 14) {
	        window.alert("Password must be of 8 to 14 characters");
	        return false;
	    }

	    /** Validatin reEnter Password */
	    var rePassword = document.getElementById("EmployeeReEnter").value;
	    if (rePassword != password || rePassword.length != password.length) {
	        window.alert("Password does not verified");
	        return false;
	    }
		}
	
	function showpassword() {
		var x = document.getElementById("EmployeePassword");

		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}

	}
	</script>

    <!--linking the bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

</body>
</html>