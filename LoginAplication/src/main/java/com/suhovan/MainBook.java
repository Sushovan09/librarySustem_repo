package com.suhovan;

import java.sql.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookDownload")
public class MainBook extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String bookName = req.getParameter("bookName");
			
			String query = String.format("SELECT * FROM book WHERE BookName = '%s'",bookName);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				resp.setContentType("text/html");
				PrintWriter pw = resp.getWriter();		
				
				
				
				pw.println("<!DOCTYPE html>");
				pw.println("<html lang=\"en\" dir=\"ltr\">");
				pw.println("<head>");
				pw.println("<meta charset=\"utf-8\">");
				pw.println("<link rel=\"stylesheet\" href=\"test.css\">");
				pw.println("<title></title>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println(" <h1>"+rs.getString(2)+"</h1><br>");
				pw.println("<div class =newbook>");
				pw.println("<img class=\"image\" src=\""+rs.getString(4)+"\" alt=\""+rs.getString(2)+"\" width=\"30%\" height=\"30%\">");
				pw.println("<br><br><p>By "+rs.getString(3)+"</p>");
				pw.println("<br><br><p>"+rs.getString(6)+"</p>");
				pw.println("<br><br><p>"+rs.getString(7)+"</p>");
				pw.println("<form action=\""+rs.getString(5)+"\">");
				pw.println("<input type = \"submit\"  value = \"Download\"></form>");
				pw.println("</div>");
				pw.println("</body>");
				pw.println("</html>");

		
			}
			else {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h2><u>You<br>have<br>entered<br>wrong<br>username<br>and<br>password.</u></h2><br>");
				pw.println("<a href = \"LogIn.html\">Go back to login page</a>");
				pw.println("</div>");
				pw.println("<body></html>");
				
			}
			
			st.close();
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

