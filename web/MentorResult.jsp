<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.*"
    import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>




<head>

<title>option</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<style>

html {
  background-color: #10151B;
  background: url(https://images.unsplash.com/photo-1427504494785-3a9ca7044f45?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80) no-repeat center center fixed;
 
  background-size: cover;
}

body {
  font-family: "Oswald", sans-serif;
  -webkit-font-smoothing: antialiased;
  font-smoothing: antialiased;
}

h1 {
  line-height: .95;
  color: #C70039 ;
  font-weight: 900;
  font-size: 90px;
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
color:#DAFF33 ;
font-size:30px;

}



</style>

</head>


<body>
<%
String usn=(String)request.getAttribute("usn");

%>

<div class="center">
  <h1>MAKE CHOICE!!</h1>
<div class="eg">
<div>
<form method="post" action="ViewResult.jsp">
<input type="hidden" name="usn" value="<%=usn%>">
 <button type="submit" class="btn btn-success">VIEW</button> 

</form>
<br>

<form method="post" action="EnterResults.jsp">
<input type="hidden" name="usn" value="<%=usn%>">
 <button type="submit" class="btn btn-success">DARK</button> 
</div>
</form>





</body>


</html>