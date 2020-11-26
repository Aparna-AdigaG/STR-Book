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
 * Servlet implementation class AssignProject
 */
@WebServlet("/AssignProject")
public class AssignProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignProject() {
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
		String usn=request.getParameter("usn");
		String projid=request.getParameter("proj_id");
		int proj_id=Integer.parseInt(projid);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 
			 String sql="insert into works_on(proj_id,usn) values(?,?)";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1,proj_id );
			 ps.setString(2,usn );
			 int rs=ps.executeUpdate();
			 request.setAttribute("usn", usn);
			 RequestDispatcher requestdispatcher=request.getRequestDispatcher("MentorProject.jsp");
			 requestdispatcher.forward(request, response);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
