<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"
    import="java.sql.*" %>
<!DOCTYPE html>
<html>




<head>

<title>welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<style>

html {
  background-color: #10151B;
  background: url(https://images.unsplash.com/photo-1530347927633-5f393ff7abd0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=667&q=80) no-repeat center center fixed;
 
  background-size: cover;
}

body {
  font-family: "Oswald", sans-serif;
  -webkit-font-smoothing: antialiased;
  font-smoothing: antialiased;
}

h1 {
  line-height: .95;
  color: #66fcf1;
  font-weight: 900;
  font-size: 150px;
  text-transform: uppercase;
  
}

.center {
  position: absolute;
  margin: auto;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 581px;
  height: 50%;
}

.btn {
  margin: 0 auto;
  width: 170px;
  height: 60px;
  padding: 6px 0 0 3px;
  border: 2px solid #66fcf1;
  border-radius: 2px;
  background: none;
  font-size: 16px;
  line-height: 54px;
  color: #fff;
  letter-spacing: .25em;
  text-decoration: none;
  font-weight: 600;
  text-transform: uppercase;
  vertical-align: middle;
  text-align: center;

  cursor: pointer;
}

.btn:hover {
  background: #66fcf1;
  color: #10151B;
}
.eg{
color:#248f24;
font-size:25px;

}
.multiSelect {
  background-color: #4F6877;
  border: 0;
  color: #fff;
  display: none;
  left: 0px;
  padding: 2px 15px 2px 5px;
  position: absolute;
  top: 2px;
  width: 280px;
  list-style: none;
  height: 100px;
  overflow: auto;
}
button {
  background-color: #6BBE92;
  width: 302px;
  border: 0;
  padding: 10px 0;
  margin: 5px 0;
  text-align: center;
  color: #fff;
  font-weight: bold;
}


</style>

</head>


<body>
<%ResultSet student=(ResultSet)request.getAttribute("student"); %>
<form method="post" action="MentorHomeS">
<div class="center">
  <h1>MENTOR SPACE</h1>
<div class="eg">
<br></br>

<select name="usn">
<option value=0>USN</option>
	
<%do{ %>
<option value=<%=student.getString("usn") %>><%=student.getString("usn")%></option>
<%}while(student.next()); %>			


</select>
<br><br>
<input type="radio" name="info" value="personal info"> personal info<br>
<input type="radio" name="info" value="academic details"> academic details<br>
<input type="radio" name="info" value="results"> results<br>
<input type="radio" name="info" value="project"> project<br>
<input type="radio" name="info" value="extra activities"> extra activities<br>

  <input type="submit" class="btn"></div>




</form>



</body>


</html>