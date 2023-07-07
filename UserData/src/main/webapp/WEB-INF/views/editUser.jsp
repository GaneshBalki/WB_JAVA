<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<form action="modifyuser" method="get">
  <div class="container">
    <h1>Register User</h1>
  
    <hr>

    <label for="sid"><b></b></label>
    <input type="text" placeholder="User Number " name="id" id="id" value=${user.id} readonly >

    <label for="sname"><b>User Name</b></label>
    <input type="text" placeholder="Enter User name" name="name" id="name" value=${user.name}>

    <label for="sname"><b>User Address</b></label>
    <input type="text" placeholder="Enter User name" name="address" id="addr" value=${user.address}>
    <label><b>User Gender</b></label><br>
   <label for="psw1">Male</label> <input type="radio" name="gender" id="psw1" value="Male"/>
   <label for="psw2">Female</label><input type="radio" name="gender" id="psw2" value="Female"/>
    <br><br>
    <label ><b>User City</b></label>
    <input type="text" placeholder="Enter city" name="city" id="psw" value=${user.city}>
    
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Update User</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>
