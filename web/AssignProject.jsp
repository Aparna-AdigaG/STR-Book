<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"
    import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom checkbox */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
  left: 9px;
  top: 5px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}

input[type=button], input[type=submit], input[type=reset] {
  background-color: #2196F3;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}


</style>
</head>
<body>
<%String usn=request.getParameter("usn");
String id=(String)session.getAttribute("mentor_id");
int mentor_id=Integer.parseInt(id);
Connection con;
%>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
	String sql="select proj_id,proj_title from project where mentor_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1,mentor_id);
	ResultSet rs=ps.executeQuery();
	%>
	<form method="post" action="AssignProject">
	<input type="hidden" name="usn" value="<%=usn %>">
	<label class="container">Project List </label>
	<% 
	while(rs.next()){
		
		%>
		  <label class="container"><%=rs.getString("proj_title") %>
		  <input type="radio" name="proj_id" value="<%=rs.getInt("proj_id")%>">
 				 <span class="checkmark"></span>
			</label>
		
		<% 
	}
	%>

<input type="submit" value="submit">
</form>
	<% 
}catch(SQLException e){
	e.printStackTrace();
}catch(Exception e){
	e.printStackTrace();
}

%>
</body>
</html>