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
<%
String sid=(String)session.getAttribute("stud_id");
int id=Integer.parseInt(sid);
Connection con;
String usn=null;
PreparedStatement ps=null,ps1=null,ps2=null;
ResultSet rs=null,rs1=null,rs2=null;

%>

<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
	String update=request.getParameter("info");
	String sql1="select usn from student_academic_details where stud_id=?";
	ps2=con.prepareStatement(sql1);
	ps2.setInt(1,id);
	rs2=ps2.executeQuery();
	while(rs2.next()){
		usn=rs2.getString("usn");

	}
		String q="select w.usn from works_on w,student_academic_details s where w.usn=s.usn and w.usn=?";
	ps=con.prepareStatement(q);
	ps.setString(1,usn);
	rs=ps.executeQuery();
	RequestDispatcher requestdispatcher=request.getRequestDispatcher("Project.html");
	
	
	if(rs.next()){
		
		String sql="update works_on set proj_updates=? where usn=?";
		ps1=con.prepareStatement(sql);
		ps1.setString(1,update);
		ps1.setString(2,usn);
		int p=ps1.executeUpdate();
		requestdispatcher.forward(request, response);

		
	}else{
		%>
		<h2>register into some project <br>contact your mentor</h2>
		<% 
	}
	
	
	
}catch(SQLException e){
	e.printStackTrace();
}
catch(Exception e){
	e.printStackTrace();
}


%>
</body>
</html>