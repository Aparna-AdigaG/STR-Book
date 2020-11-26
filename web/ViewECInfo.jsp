<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"
    import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ExtraCurricular Details</h1>
<%
ResultSet student=(ResultSet)request.getAttribute("student");
%>
 <h3>USN : <%=student.getString("usn") %></h3>
			 <h3>Club name : <%=student.getString("club_name") %></h3>
			 <h3>Event name : <%=student.getString("event_name") %></h3>
			 <h3>Awards or Certificate : <%=student.getString("awards_certificate") %></h3>
			 <h3>Sports : <%= student.getString("sports") %></h3>
			 <h3>Cultural Activity : <%= student.getString("cult_activity") %></h3>

</body>
</html>