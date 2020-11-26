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
<h1>Project Details </h1>
<% ResultSet student=(ResultSet)request.getAttribute("student");
%>
			<h3>Project title : <%=student.getString("proj_title") %></h3>
			
			<h3>Start date : <%=student.getString("start_date") %></h3>
			<h3>End date : <%=student.getString("end_date") %></h3>
			<h3>Project Description : <%=student.getString("proj_desc") %></h3>
			<h3>Status of the project : <%=student.getString("proj_updates") %></h3>
			<%
			Connection con;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
				int mentor_id=student.getInt("mentor_id");
				int proj_id=student.getInt("proj_id");
				String sql="select mentor_fname,mentor_lname from mentor m,project p where m.mentor_id=p.mentor_id and proj_id =? and m.mentor_id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,proj_id);
				ps.setInt(2,mentor_id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				%>
				<h3>Guide : <%=rs.getString("mentor_fname") %> <%=rs.getString("mentor_lname") %></h3>
				<% 
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			%>


</body>
</html>