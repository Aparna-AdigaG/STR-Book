<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.io.*"
    import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student Academic Details</h2>
<%
ResultSet student=(ResultSet)request.getAttribute("student");
%>
 <h3>Student ID : <%=student.getInt("stud_id") %></h3>
		 <h3>USN : <%=student.getString("usn") %></h3>
		 <h3>Semester : <%=student.getString("s_sem") %></h3>
		 <h3>Section : <%=student.getString("s_sec") %></h3>
		 <h3>College Email Id : <%=student.getString("clg_email") %></h3>
		 <h3>Mentor Id : <%=student.getString("mentor_id") %></h3>
		 <h3>Password : <%=student.getString("password") %></h3>
		 
</body>
</html>