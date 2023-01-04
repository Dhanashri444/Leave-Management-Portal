<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!--Linking the bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!--linking the css file-->
    <link href="/css/admin.css" rel="stylesheet" type="text/css">
 <title>Employee | Dashboard</title>
</head>
<body>

<div class="sidebar active">
        <div class="logo_content">
            <div class="logo">
                   <div class="user_info">
                               <a href="/views/employeeDashboard.jsp"><h3>Hi <%= session.getAttribute("empFirst") %></h3></a> 
                            </div>
            <i class='bx bx-menu-alt-right' id="btn" style="font-size: 25px;"></i>
        </div>
        <ul class="nav_list">
            <li>
            <a href="/employeeMyProfile?email=<%= session.getAttribute("empEmail") %>">
                    <i class='bx bx-grid-alt'></i>
                    <span class="link_names">My Profile</span>
                </a>
                <span class="tooltip">My Profile</span>
            </li>
           
            <li>
                <a href="/views/employeeApplyLeave.jsp">
                    <i class='bx bx-user' ></i>
                    <span class="link_names">Apply Leave</span>
                </a>
                <span class="tooltip">Apply Leave</span>
            </li>
            <li>
                <a href="/empCheckLeaveBalance?email=<%= session.getAttribute("empEmail") %>">
                    <i class='bx bx-chat' ></i>
                    <span class="link_names">Leave Balance</span>
                </a>
                <span class="tooltip">Leave Balance</span>
            </li>
            <li>
                <a href="/empLeaveList">
                    <i class='bx bx-pie-chart-alt-2' ></i>
                    <span class="link_names">Leave Status</span>
                </a>
                <span class="tooltip">Leave Status</span>
            </li>
            <li>
                <a href="/employeeShowProject">
                    <i class='bx bx-folder' ></i>
                    <span class="link_names">Project Details</span>
                </a>
                <span class="tooltip">Project Details</span>
            </li>
           
            <li>
                <a href="/employeeShowHoliday">
                    <i class='bx bx-heart' ></i>
                    <span class="link_names">View Holiday</span>
                </a>
                <span class="tooltip">View Holiday</span>
            </li>
            
            <li>
                <a href="/Logout">
                    <i class='bx bx-cog' ></i>
                    <span class="link_names">Logout Here</span>
                </a>
                <span class="tooltip">Logout Here</span>
            </li>
            
        </ul>
        </div>
    </div>
    <script>
        let btn = document.querySelector("#btn");
        let sidebar = document.querySelector(".sidebar");
        let searchBtn = document.querySelector(".bx-search")

        btn.onclick = function(){
            sidebar.classList.toggle("active");
        }
        searchBtn.onclick = function() {
            sidebar.classList.toggle("active");
        }
    </script>
	


</body>
</html>