package StrBook.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewPersonalInfo
 */
@WebServlet("/ViewPersonalInfo")
public class ViewPersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String id=(String)session.getAttribute("stud_id");
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 PreparedStatement ps=null;
			 ResultSet rs=null;
			 
			 
			 String sql="select * from student_personal_info where stud_id = ?";
			  ps=conn.prepareStatement(sql);
			 ps.setString(1,id);
			 rs=ps.executeQuery();
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewPersonalInfo.jsp");
				

			if( rs.next()) {
			 
		//get the student info
		
		request.setAttribute("student",rs);
		requestDispatcher.forward(request, response);
			}
			else {
				request.setAttribute("error","no student information");
				requestDispatcher.forward(request, response);
				
			}
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

}
