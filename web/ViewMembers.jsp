<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"
    import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>
Members in team and their updates
</h2> 

<%ResultSet members=(ResultSet)request.getAttribute("members"); 

do{
	%>
	
	<h3>USN : <%=members.getString("usn") %> </h3>
	<h3>Updates : <%=members.getString("proj_updates") %></h3>
	
	<% 
}while(members.next());

%>

</body>
</html>