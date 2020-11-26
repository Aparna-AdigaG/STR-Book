package StrBook.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatePoints
 */
@WebServlet("/CalculatePoints")
public class CalculatePoints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatePoints() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usn=(String)request.getAttribute("usn");
		Connection con;
		int total=0,pt=0,count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			String sql="select * from result where usn=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usn);
			ResultSet rs=ps.executeQuery();			
			while(rs.next()) {
				String sub_code=rs.getString("subcode");
				total=rs.getInt("total");
				if(total>0 && total<10){
					pt=1;}
			else if(total>=10 && total<20){
				pt=2;}
			else if(total>=20 && total<30){
				pt=3;}
			else if(total>=30 && total<40){
				pt=4;}
			else if(total>=40 && total<50){
				pt=5;}
			else if(total>=50 && total<60){
				pt=6;}
			else if(total>=60 && total<70){
				pt=7;}
			else if(total>=70 && total<80){
				pt=8;}
			else if(total>=80 && total<90){
				pt=9;}
			else
				pt=10;
				
			String point="update result set points=? where usn=? and subcode=? ";	
			PreparedStatement ps4=con.prepareStatement(point);
			ps4.setInt(1,pt);
			ps4.setString(2,usn);
			ps4.setString(3,sub_code);
			int a=ps4.executeUpdate();	
			
			count=count+total;
			
			}
			
			String query="insert into finalResult values(?,?)";
			PreparedStatement ps3=con.prepareStatement(query);
			ps3.setString(1,usn);
			ps3.setInt(2,count);
			
			int up=ps3.executeUpdate();

			RequestDispatcher requestdispatcher=request.getRequestDispatcher("MentorResult.jsp");
			
			requestdispatcher.forward(request, response);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
