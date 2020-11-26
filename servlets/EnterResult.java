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
 * Servlet implementation class EnterResult
 */
@WebServlet("/EnterResult")
public class EnterResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterResult() {
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
		Connection con;
		String usn=(String)request.getParameter("usn");
		System.out.println(usn);
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
		
			 String sub_code1=request.getParameter("MAE").trim();
			 String MAEImarks=request.getParameter("MAEImarks").trim();
			 String MAEEmarks=request.getParameter("MAEEmarks").trim();
			 int MAEI=Integer.parseInt(MAEImarks);
			 int MAEE=Integer.parseInt(MAEEmarks);
			
			 insert(usn,sub_code1,MAEI,MAEE);

				String sub_code2=request.getParameter("CN").trim();
				String CNImarks=request.getParameter("CNImarks").trim();
				String CNEmarks=request.getParameter("CNEmarks").trim();
				int CNI=Integer.parseInt(CNImarks);
				int CNE=Integer.parseInt(CNEmarks);
				
				insert(usn,sub_code2,CNI,CNE);
			
				String sub_code3=request.getParameter("DBMS").trim();
				 String DBMSImarks=request.getParameter("DBMSImarks").trim();
				 String DBMSEmarks=request.getParameter("DBMSEmarks").trim();
				 int DBMSI=Integer.parseInt(DBMSImarks);
				 int DBMSE=Integer.parseInt(DBMSEmarks);
				
				 insert(usn,sub_code3,DBMSI,DBMSE);
				 
				 String sub_code4=request.getParameter("ATAC").trim();
				 String ATACImarks=request.getParameter("ATACImarks").trim();
				 String ATACEmarks=request.getParameter("ATACEmarks").trim();
				 int ATACI=Integer.parseInt(ATACImarks);
				 int ATACE=Integer.parseInt(ATACEmarks);
				
				 insert(usn,sub_code4,ATACI,ATACE);
				 
				 String sub_code5=request.getParameter("CNL").trim();
				 String CNLImarks=request.getParameter("CNLImarks").trim();
				 String CNLEmarks=request.getParameter("CNLEmarks").trim();
				 int CNLI=Integer.parseInt(CNLImarks);
				 int CNLE=Integer.parseInt(MAEEmarks);
				
				 insert(usn,sub_code5,CNLI,CNLE);
				 
				 String sub_code6=request.getParameter("DBMSL").trim();
				 String DBMSLABImarks=request.getParameter("DBMSLABImarks").trim();
				 String DBMSLABEmarks=request.getParameter("DBMSLABEmarks").trim();
				 int DBMSLI=Integer.parseInt(DBMSLABImarks);
				 int DBMSLE=Integer.parseInt(DBMSLABEmarks);
				
				 insert(usn,sub_code6,DBMSLI,DBMSLE);
				 
				 String sub_code7=request.getParameter("JAVA").trim();
				 String AJAJImarks=request.getParameter("AJAJImarks").trim();
				 String AJAJEmarks=request.getParameter("AJAJEmarks").trim();
				 int JAVAI=Integer.parseInt(AJAJImarks);
				 int JAVAE=Integer.parseInt(AJAJEmarks);
				
				 insert(usn,sub_code7,JAVAI,JAVAE);
				 
				 String sub_code8=request.getParameter("DOT").trim();
				 String DNFImarks=request.getParameter("DNFImarks").trim();
				 String DNFEmarks=request.getParameter("DNFEmarks").trim();
				 int DOTI=Integer.parseInt(DNFImarks);
				 int DOTE=Integer.parseInt(MAEEmarks);
				
				 insert(usn,sub_code8,DOTI,DOTE);
			
			RequestDispatcher requestdispatcher=request.getRequestDispatcher("CalculatePoints");
			request.setAttribute("usn", usn);
			requestdispatcher.forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static void insert(String usn,String sub_code,int Imarks,int Emarks) {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			String sql="call enterMarks(?,?,?,?)";
			 CallableStatement cst=con.prepareCall(sql);
							
		 //String sql="insert into result(usn,subcode,finalIAT,Externals) values(?,?,?,?)";
		 
		// PreparedStatement ps=con.prepareStatement(sql);
		 		cst.setString(1, usn);
		 		cst.setString(2,sub_code);
		 		cst.setInt(3, Imarks);
		 		cst.setInt(4, Emarks);
		
		int p=cst.executeUpdate();

		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
