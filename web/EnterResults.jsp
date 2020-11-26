<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"
    import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>subject</title>

<style>

table#miyazaki { 
  margin: 0 auto;
  border-collapse: collapse;
  font-family: Agenda-Light, sans-serif;
  font-weight: 100; 
  background: #333; color: #fff;
  text-rendering: optimizeLegibility;
  border-radius: 5px; 
}
table#miyazaki caption { 
  font-size: 2rem; color: #444;
  margin: 1rem;
  background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/miyazaki.png), url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/miyazaki2.png);
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center left, center right; 
}
table#miyazaki thead th { font-weight: 600; }
table#miyazaki thead th, table#miyazaki tbody td { 
  padding: .8rem; font-size: 1.4rem;
}
table#miyazaki tbody td { 
  padding: .8rem; font-size: 1.4rem;
  color: #444; background: #eee; 
}
table#miyazaki tbody tr:not(:last-child) { 
  border-top: 1px solid #ddd;
  border-bottom: 1px solid #ddd;  
}

@media screen and (max-width: 600px) {
  table#miyazaki caption { background-image: none; }
  table#miyazaki thead { display: none; }
  table#miyazaki tbody td { 
    display: block; padding: .6rem; 
  }
  table#miyazaki tbody tr td:first-child { 
    background: #666; color: #fff; 
  }
	table#miyazaki tbody td:before { 
    content: attr(data-th); 
    font-weight: bold;
    display: inline-block;
    width: 6rem;  
  }
}






</style>




</head>
<body>
<%
String usn=(String)request.getParameter("usn");
Connection con;
%>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
	String sql="select sub_code,sub_name from subject ";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	//RequestDispatcher requestdispatcher=request.getRequestDispatcher("EnterResult");
	//request.setAttribute("usn",usn);
	//requestdispatcher.forward(request, response);

	%>
	<form method="post" action="EnterResult">
		<input type="hidden" name="usn" value="<%=usn%>">
		
	<table id="miyazaki">
<caption>ENTER RESULTS</caption>
<thead>
<tr><th>SUBJECT CODE<th>SUBJECT NAME<th>INTERNAL<th>EXTERNAL
<tbody>
<tr>
<td>17CS51
<td><input type="hidden" name="MAE" value="17CS51">MANAGEMENT AND ENTREPRENEURSHIP
<td><input name="MAEImarks" type="text" value=""/>
<td><input name="MAEEmarks" type="text" value=""/>
<tr>
<td>17CS52
<td><input type="hidden" name="CN" value="17CS52">COMPUTER NETWORKS
<td><input name="CNImarks" type="text" value=""/>
<td><input  name="CNEmarks" type="text" value=""/>
<tr>
<td>17CS53
<td><input type="hidden" name="DBMS" value="17CS53">DATABASE MANAGEMENT SYSTEM
<td><input name="DBMSImarks" type="text" value=""/>
<td><input name="DBMSEmarks" type="text" value=""/>
<tr>
<td>17CS54
<td><input type="hidden" name="ATAC" value="17CS54">AUTOMATA THEORY AND COMPUTABILITY
<td><input name="ATACImarks" type="text" value=""/>
<td><input name="ATACEmarks" type="text" value=""/>
<tr>
<td>17CSL57
<td><input type="hidden" name="CNL" value="17CSL57" >COMPUTER NETWORKS LAB
<td><input name="CNLImarks" type="text" value=""/>
<td><input name="CNLEmarks" type="text" value=""/>
<tr>
<td>17CSL58
<td><input type="hidden" name="DBMSL" value="17CSL58">DBMS LAB WITH MINI PROJECT
<td><input name="DBMSLABImarks" type="text" value=""/>
<td><input name="DBMSLABEmarks" type="text" value=""/>
<tr>
<td>17CS553
<td><input type="hidden" name="JAVA" value="17CS553">ADVANCED JAVA AND J2EE
<td><input name="AJAJImarks" type="text" value=""/>
<td><input name="AJAJEmarks" type="text" value=""/>
<tr>
<td>17CS564
<td><input type="hidden" name="DOT" value="17CS564">DOT NET FRAMEWORK
<td><input name="DNFImarks" type="text" value=""/>
<td><input name="DNFEmarks" type="text" value=""/>
</table>
	<center><input type="submit" value="submit"></center>
	
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