package StrBook.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MentorHomeS
 */
@WebServlet("/MentorHomeS")
public class MentorHomeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorHomeS() {
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
		String usn=(String)request.getParameter("usn");
		System.out.println(usn);
		String id=(String)session.getAttribute("mentor_id");
		try {
		Connection con;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
		PreparedStatement ps=null,ps2=null; 
		ResultSet rs2=null,rs=null;	
		if(choice.equals("personal info")){
			String sql="select * from student_personal_info  where stud_id= (select stud_id from student_academic_details where usn=?)";
			  ps=con.prepareStatement(sql);
			 ps.setString(1,usn);
			 rs=ps.executeQuery();
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewPersonalInfo.jsp");

			if(rs.next()) {
				request.setAttribute("student", rs);
				requestDispatcher.forward(request, response);
			}
			
		}
		else if(choice.equals("academic details")){
			String sql="select * from  student_academic_details where usn=?";
			PreparedStatement ps1=con.prepareStatement(sql);
			ps1.setString(1,usn);
			ResultSet rs1=ps1.executeQuery();
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAcademicInfo.jsp");

				if(rs1.next()) {
					request.setAttribute("student", rs1);
					requestDispatcher.forward(request, response);
				}
		}
		else if(choice.equals("results")) {
			request.setAttribute("usn", usn);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MentorResult.jsp");
			requestDispatcher.forward(request, response);

		}
		else if(choice.equals("project")) {
			request.setAttribute("usn", usn);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MentorProject.jsp");
			requestDispatcher.forward(request, response);


		}
		else {
			String sql="select * from extra_curricular where usn=?";
			PreparedStatement ps5=con.prepareStatement(sql);
			ps5.setString(1,usn);
			ResultSet rs5=ps5.executeQuery();
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewECInfo.jsp");
			if(rs5.next()) {
				request.setAttribute("student", rs5);
				requestDispatcher.forward(request, response);

			}
			else {
				RequestDispatcher requestdispatcher=request.getRequestDispatcher("StudentNoInfo.html");
				requestdispatcher.forward(request, response);
			}
		}
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
	}

}
