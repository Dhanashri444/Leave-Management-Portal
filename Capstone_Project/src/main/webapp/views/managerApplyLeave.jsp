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
<title>Manager | Apply Leave</title>
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
<%@ include file="/views/managerDashboard.jsp" %>
 <div id="content">
                <!-- dashboard inner -->
                <div>
                    <p class="text-center text-dark" style="font-size: 30px;">Apply Leave</p>
                    <br>
                    <hr>
                    <form action="/managerApplyLeave" method="post">
                        <div>
                            <br>
                            <!--first row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empId" value="<%= session.getAttribute("empId") %>" readonly>
                                        <label for="EmployeeId">Employee Id</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpFirstName"
                                            placeholder="First Name" name="firstName" value="<%= session.getAttribute("empFirst") %>" readonly>
                                        <label for="EmpFirstName">First Name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="floatingInput"
                                            placeholder="Last Name" name="lastname" value="<%= session.getAttribute("empLast") %>" readonly>
                                        <label for="floatingInput">Last Name</label>
                                    </div>
                                </div>

                            </div>
                            <!--Second row-->
                            <div class="row">
                                <div class="col">
                                    <select class="form-select pb-4" id="selectLeaveType" aria-label="Default select example"
                                        name="leaveType" required>
                                        <option value="" >Select Leave Type</option>
                                        <p>Common Leaves</p>
                                        <option value="sickLeave">Sick Leave</option>
                                        <option value="casualLeave">Casual Leave</option>
                                        <option value="personalLeave">Personal Leave</option>
                                        <p>Other Leaves</p>
                                        <option value="maternityLeave">Maternity Leave</option>
                                        <option value="paternityLeave">Paternity Leave</option>
                                        <option value="marriageLeave">Marriage Leave</option>
                                        <option value="adoptionLeave">Adoption Leave</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="startDate" placeholder="Start Date"
                                             name="startDate" onchange="cal()" required>
                                        <label for="startDate">Start Date</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="endDate" placeholder="End Date"
                                            name="endDate" onchange="cal()" required>
                                        <label for="endDate">End Date</label>
                                    </div>
                                </div>
                            </div>
                            <!--Third row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="number" class="form-control" id="leaveperiod" placeholder="Leave Period"
                                            name="period" >
                                        <label for="period">Leave Period</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating">
                                        <textarea class="form-control" placeholder="Leave a comment here" id="comment"
                                            name="leaveComment" required></textarea>
                                        <label for="floatingTextarea">Comments</label>
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
    
    <script type="text/javascript">
    /** for Starting Date */
    const startPicker = document.getElementById('startDate');
    startPicker.addEventListener('input', function (e) {
        var day = new Date(this.value).getUTCDay();
        if ([6, 0].includes(day)) {
            e.preventDefault();
            this.value = '';
            alert('Weekends not allowed');
        }
    });

    

    /** for Ending Date */
    const endPicker = document.getElementById('endDate');
    endPicker.addEventListener('input', function (e) {
        var day = new Date(this.value).getUTCDay();
        if ([6, 0].includes(day)) {
            e.preventDefault();
            this.value = '';
            alert('Weekends not allowed');
        }
    });

    

    /** for period calculation */
    function GetDays() {
        var endDate = new Date(document.getElementById("endDate").value);
        var startDate = new Date(document.getElementById("startDate").value);
        if(endDate < startDate){
            alert("Start Date must be Before End Date");
            return false;
        }
        return parseInt(((endDate - startDate) / (24 * 3600 * 1000))+1);
    }

    function cal() {
        if (document.getElementById("endDate")) {
            document.getElementById("leaveperiod").value = GetDays();
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