<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.io.*"
   import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Student Personal Info</h1>
	<%
		
		ResultSet student= (ResultSet)request.getAttribute("student");
		
	%>
	<h3>Student ID : <%=student.getInt("stud_id") %></h3>
		 <h3>First Name : <%=student.getString("s_fname") %></h3>
		 <h3>Last Name : <%=student.getString("s_lname") %></h3>
		 <h3>Address : <%=student.getString("s_address") %></h3>
		 <h3>Date Of Birth : <%=student.getString("s_dob") %></h3>
		 <h3>Gender : <%=student.getString("s_gender") %></h3>
		 <h3>Phone Number : <%=student.getLong("s_phoneno") %></h3>
		 <h3>Personal Email : <%=student.getString("s_email") %></h3>
		 	 
	</body>
</html>