package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteS2")
public class DeleteStudentDatabase extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String username = req.getParameter("username");
			String passwd = req.getParameter("passwd");
			
			String query = String.format("DELETE FROM student WHERE SUserName = '%s' AND SPassword = '%s'",username,passwd);
			Statement st = con.createStatement();
			st.execute(query);
			
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("</head><body>");
				pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h2><u>user deleted successfully</u></h2><br>");
				pw.println("<br><a href = \"manageS\">Go back</a>");
				pw.println("</div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("<body></html>");
		}		
		catch(Exception ex) {
			resp.setContentType("text/html");
			
			PrintWriter pw = resp.getWriter();
			pw.println("<html><head>");
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
			pw.println("</head><body>");
			pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
			pw.println("<h2><u>error occurd</u></h2><br>");
			pw.println("<a href = \"LogIn.html\">Go back to login page</a>");
			pw.println("</div>");
			pw.println("</body></html>");
			ex.printStackTrace();
		}
	}
}

