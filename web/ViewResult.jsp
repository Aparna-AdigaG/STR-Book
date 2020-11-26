<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import=" java.io.IOException"
import= " java.sql.DriverManager"
import= " java.sql.Connection"
import= "java.sql.PreparedStatement"
import= " java.sql.ResultSet"
import= "java.sql.SQLException"

import= "javax.servlet.ServletException"
import= "javax.servlet.annotation.WebServlet"
import= "javax.servlet.http.HttpServlet"
import= "javax.servlet.http.HttpServletRequest"
import= "javax.servlet.http.HttpServletResponse"
import= "javax.servlet.http.HttpSession"
     %>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    footer {
      background-color: #f2f2f5;
      padding: 25px;
    }
    table {
  border-collapse: collapse;
  width: 100%;
}

th {
  height: 50px;
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

 tr:nth-child(even){background-color: black;}
 tr:hover {background-color: black;}

 th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color:white;
  color: black;
}

  </style>
</head>


</head>
<body>
<%Connection con;
String usn=request.getParameter("usn");

String sql1=null,sql2=null;
PreparedStatement ps1=null,ps2=null,ps3=null,ps4=null,ps5=null;
ResultSet rs1=null,rs2=null,rs3=null,rs4=null,rs5=null;
String fname=null,lname=null;
int pt=0,total=0;
%>
<%

try{
	
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
	String sql="select usn,s_fname,s_lname from student_personal_info p,student_academic_details d where p.stud_id=d.stud_id and usn=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1,usn);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		usn=rs.getString("usn");
		fname=rs.getString("s_fname");
		lname=rs.getString("s_lname");
		
		sql1="select * from result where usn = ?";
		ps1=con.prepareStatement(sql1);
		ps1.setString(1, usn);
		rs1=ps1.executeQuery();
		%>
		<h3>Name : <%=fname %> <%=lname %> (<%=usn %>) </h3>
		<footer class="container-fluid text-center">
		<table id ="usn" text_center>
		<tr>
		<th>Subject Code </th>
		<th>Subject Name </th>
		<th>Final IAT (40)   </th>
		<th>Externals (60)   </th>
		<th>Total  (100)      </th>
		<th>Points </th>
		</tr>
		
		<% 
		PreparedStatement p=null;
		ResultSet r=null;
		int count=0;
		while(rs1.next()){
				String subname=null,scode=null;
				String q="select sub_name from subject where sub_code=?";
				scode=rs1.getString("subcode");
				
				
				p=con.prepareStatement(q);
				p.setString(1,scode);
				
				r=p.executeQuery();
				r.next();
				subname=r.getString("sub_name");	
		
			%>
			<tr>
			
			<th><%=rs1.getString("subcode") %></th>
			<th><%=subname %></th>
			<th><%=rs1.getInt("finalIAT") %></th>
			<th><%=rs1.getInt("Externals") %></th>
			<th><%=rs1.getInt("Total") %></th>
			<th><%=rs1.getInt("points") %></th>
			
			<% 
			
			
		}
		
		%>
		</tr>
		</table>
		<%
		
				
	
		
		String finalrs="select * from finalResult where usn=?";
		ps5=con.prepareStatement(finalrs);
		ps5.setString(1,usn);
		rs5=ps5.executeQuery();
		while(rs5.next())
		{
			%>
			<h3>Grand Total = <%=rs5.getInt("grandtotal") %></h3>
			
			
	<% 	}
		
		%>
		
		
		
		</footer>
		<% 
		
		
	}
	else{
		%>
		<h2>your result is not updated</h2>
		<%
	}
	
	
	
}
catch(SQLException e){
	e.printStackTrace();
}
catch(Exception e){
	e.printStackTrace();
}
%>


</body>
</html>