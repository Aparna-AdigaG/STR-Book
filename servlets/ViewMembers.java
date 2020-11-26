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
 * Servlet implementation class ViewMembers
 */
@WebServlet("/ViewMembers")
public class ViewMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMembers() {
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
		String id=(String)session.getAttribute("stud_id");
		Connection con;
		PreparedStatement ps=null,ps1=null;
		ResultSet rs=null,rs1=null;
		try {
				
			
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
				String sql="select usn from student_academic_details  where  stud_id=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,id);
				rs=ps.executeQuery();
				rs.next() ;
				String usn=rs.getString("usn");
				int proj_id=0;
				//out.println(usn);
				String sql1="select p.proj_id from project p,works_on w where p.proj_id=w.proj_id and usn=?";
					ps1=con.prepareStatement(sql1);
					
					ps1.setString(1,usn);
					rs1=ps1.executeQuery();
					if(rs1.next()) {
					proj_id=rs1.getInt("proj_id");
					
					String s="select usn,proj_updates from works_on where proj_id=?";
					PreparedStatement ps2=con.prepareStatement(s);
					ps2.setInt(1, proj_id);
					ResultSet rs2=ps2.executeQuery();
					RequestDispatcher requestdispatcher=request.getRequestDispatcher("ViewMembers.jsp");
					
					if(rs2.next()) {
						request.setAttribute("members", rs2);
						requestdispatcher.forward(request, response);
					}
				}
					else {
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("NoInfo.html");
						requestDispatcher.forward(request, response);

					}

		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
