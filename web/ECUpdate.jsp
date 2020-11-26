<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" java.io.IOException"
import= " java.sql.DriverManager"
import= " java.sql.Connection"
import= "java.sql.PreparedStatement"
import= " java.sql.ResultSet"
import= "java.sql.SQLException"
import=" javax.servlet.RequestDispatcher"	

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
</head>
<body>

<%
 //HttpSession session = request.getSession(false);
 //out.println("inside jsp");
 String id=(String)session.getAttribute("stud_id");
 //out.println(id);
 Connection conn=null;
 PreparedStatement ps1=null,ps2=null,ps3=null,ps4=null;
 ResultSet rs1=null,rs2=null,rs3=null,rs4=null;
 
 //String usn=request.getParameter("usn");
 String club_name=request.getParameter("club_name");
 String event_name=request.getParameter("event_name");
 String awards_certificate=request.getParameter("awards_certificate");
 String sports=request.getParameter("sports");
 String cult_activity=request.getParameter("cult_activity");
 String usn=new String();
 String newusn=new String();

 %>

<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
	String sql="select e.usn from student_personal_info p,student_academic_details d,extra_curricular e where p.stud_id=d.stud_id and d.usn=e.usn and p.stud_id = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,id);
	ResultSet rs=ps.executeQuery();
	String sql5="select usn from student_personal_info s,student_academic_details d where s.stud_id=d.stud_id and d.stud_id=?";
	ps4=conn.prepareStatement(sql5);
	ps4.setString(1,id);
	rs4=ps4.executeQuery();
	
	if(rs.next()){
		usn=rs.getString("usn");
		//out.println(usn);
	}
	else{
		rs4.next();
		newusn=rs4.getString("usn");
	}
	String sql1="select * from extra_curricular where usn = ?";
	ps1=conn.prepareStatement(sql1);
	ps1.setString(1,usn);
	rs1=ps1.executeQuery();
	RequestDispatcher requestdispatcher=request.getRequestDispatcher("ExtraCurricular.html");
	if(rs1.next()){
		String sql2="update extra_curricular set club_name=? , event_name=? ,awards_certificate=? , sports=?,cult_activity=? where usn=?";
		ps2=conn.prepareStatement(sql2);
		
		ps2.setString(1,club_name);
		ps2.setString(2,event_name);
		ps2.setString(3,awards_certificate);
		ps2.setString(4,sports);
		ps2.setString(5,cult_activity);
		ps2.setString(6,usn);
		int p=ps2.executeUpdate();
		
		if(p==0)
		{%>
		<h3>failed to update</h3>
		<%
			
		} else{
			%>
			<h3> updated</h3>
			<% 
			
		}
		requestdispatcher.forward(request, response);
		
	}else{
		String sql3="insert into extra_curricular values(?,?,?,?,?,?)";
		ps3=conn.prepareStatement(sql3);
		ps3.setString(1,newusn);
		ps3.setString(2,club_name);
		ps3.setString(3,event_name);
		ps3.setString(4,awards_certificate);
		ps3.setString(5,sports);
		ps3.setString(6,cult_activity);
		int p1=ps3.executeUpdate();
		if(p1==0)
		{%>
		<h3>failed to insert </h3>
		<%
			
		} else{
			%>
			<h3>inserted</h3>
			<% 
			
		}
	}
	
rs.close();
rs1.close();
rs2.close();
rs3.close();
rs4.close();
ps.close();
ps1.close();
ps2.close();
ps3.close();
ps4.close();
conn.close();



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