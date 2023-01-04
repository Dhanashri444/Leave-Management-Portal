<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="/css/login.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--Linking the bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!--linking the css file-->
    <link href="/css/login.css" rel="stylesheet" type="text/css">
    <title>Login</title>
</head>
<body>
   <div class="sidenav">
         <div class="login-main-text">
            <h2><strong>Leave Management Portal</strong> <br> Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
              <form action="login" method="post" onsubmit="return validate()">
                  <div class="form-group">
                      <div class="form-floating mb-3">
                                    <input type="email" class="form-control" id="username" placeholder="Username" name="username" required>
                                    <label for="username">Username</label>
                                </div>

                                <!-- Password input -->
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" id="Password" placeholder="Password" name="password" required>
                                    <label for="Password">Password</label>
                                </div>

                                <div class="d-flex justify-content-between align-items-center">
                                    <!-- Checkbox -->
                                    <div class="form-check mb-0">
                                        <input class="form-check-input me-2" type="checkbox" id="showPassword" onclick="showpassword()"/>
                                        <label class="form-check-label" for="form2Example3">
                                            Show Password
                                        </label>
                                    </div>
                                   
                                </div>

                                <div class="login-signup text-center text-lg-start mt-4 pt-2">
                                    <div>
                                        <button type="submit" class="btn btn-primary btn-lg"
                                            style="padding-left: 3.5cm; padding-right: 3.5cm;">Login</button>
                                    </div>
                                    
                                    <div>
                                    <p class="text-center text-danger"><b>Invalid Username or Password</b></p>
                                    </div>
                                </div>
               </form>
            </div>
         </div>
      </div>
     
	
	<script type="text/javascript">
	/** mathod to mak show password checkbox*/

	function showpassword() {
		var x = document.getElementById("Password");

		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}

	}

	function validate() {
		/**Validation for Username / email */
		var username = document.getElementById("username").value;
		var emailRegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

		if (!emailRegExp.test(username) ) {
			window.alert("Enter a valid Username (Example1234@xyz.com)");
			return false;
		}
		
		if(username == "" || username == " " || username == "  "){
			window.alert("Please Enter Username");
			return false;
		}
		
		var password = document.getElementById("Password").value;
		
		if(password == "" || password == " " || password == "  "){
			window.alert("Please Enter Password");
			return false;
		}

		if(password.length() < 8 || password.length() > 14){
			window.alert("Password length should be between 8 to 14 digits");
			return false;
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