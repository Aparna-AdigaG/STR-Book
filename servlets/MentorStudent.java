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
 * Servlet implementation class MentorStudent
 */
@WebServlet("/MentorStudent")
public class MentorStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorStudent() {
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
		HttpSession session = request.getSession(false);

		String choice=(String)request.getParameter("info");
		String id=(String)session.getAttribute("mentor_id");
		Connection con;
		PreparedStatement ps1=null; 
		ResultSet rs1=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			String sql=null;
			RequestDispatcher requestdispatcher=request.getRequestDispatcher("MentorHome.jsp");
			
			sql="select usn from student_academic_details where mentor_id=?";
			ps1=con.prepareStatement(sql);
			ps1.setString(1,id);
			rs1=ps1.executeQuery();
			
			if(rs1.next()) {
				
				request.setAttribute("student",rs1);
				requestdispatcher.forward(request, response);
					}
					else {
						request.setAttribute("error","no student information");
						requestdispatcher.forward(request, response);
						
					}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
