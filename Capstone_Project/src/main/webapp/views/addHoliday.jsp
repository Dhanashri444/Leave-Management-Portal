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
  <title>Admin | Holiday List</title>
  <style>

#content{

margin-left: 300px;

}

.form-floating{
width:350px
}

</style>
  
</head>
<body>
<%@ include file="/views/adminDashboard.jsp" %>
   <div id="content">
                <!-- dashboard inner -->
                
                <p class="text-center text-dark" style="font-size: 30px;">Add Holiday Details</p>
                    <br>
                    <hr>
                    
					<form action="/addHoliday" method="post">
					<div class="row">
						<div class="col">
							<div class="form-floating mb-3">
				                <input type="number" class="form-control" id="floatingInput" max=31 placeholder="Date" name="hdate" required>
				                <label for="floatingInput">Date</label>
				              </div>
						</div>
						<div class="col">
							<select class="form-select pb-4" aria-label="Default select example" id="selectMonth" name="month" required>
				                <option value="" >Select Month</option>
				                <option value="January ">January </option>
				                <option value="February">February</option>
				                <option value="March">March</option>
				                <option value="April ">April </option>
				                <option value="May">May</option>
				                <option value="June ">June </option>
				                <option value="July">July</option>
				                <option value="August">August</option>
				                <option value="September">September</option>
				                <option value="October">October</option>
				                <option value="November">November</option>
				                <option value="December">December</option>
				              </select>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-floating">
				                <input type="text" class="form-control" id="floatingPassword" placeholder="year" name="year"
				                  value="2022" readonly>
				                <label for="floatingPassword">Year</label>
				              </div>
						</div>
						<div class="col">
							<div class="form-floating">
				                <input type="text" class="form-control" id="floatingPassword" placeholder="Holiday Name" name="holidays" required>
				                <label for="floatingPassword">Holiday Name</label>
				              </div>
						</div>
					</div>
		              <br><br>
						<button type="Submit" class="btn btn-primary" style="padding-left: 2.5cm; padding-right: 2.5cm;">Submit</button>
	            </form>
            </div>
        </div>
    </div>
    
    <script>
    /* validation for select*/
    var ddlFruits = document.getElementById("selectMonth");
    if (ddlFruits.value == "") {
        //If the "Please Select" option is selected display error.
        window.alert("Please select an option from Select Month!");
        return false;
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