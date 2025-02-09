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

@WebServlet("/bookDashboard")
public class bookDashboard extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String subject = req.getParameter("subject");
			
			String query = String.format("SELECT TId FROM subject_topic WHERE TopicName = '%s'",subject);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			int TId= Integer.parseInt(rs.getString(1));
			String query2 = String.format("SELECT IdBook,BookName,AuthorName,BookImageURL FROM book WHERE TId = '%s'",TId);
			Statement st2 = con.createStatement();
			ResultSet rs2 = st.executeQuery(query2);
			
			if(rs2.next()) {
				resp.setContentType("text/html");
				PrintWriter pw = resp.getWriter();		
				
				pw.println("<!DOCTYPE html>");
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<meta charset=\"utf-8\">");
				pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
				pw.println("<title></title>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\">");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<h1>E-BOOKS</h1><hr>");
				pw.println("<div class=\"area\">");
				pw.println("<figure class=\"book\">");
				pw.println("<form class=\"something\" action=\"BookDownload\" method=\"post\">");
				pw.println("<input type=\"hidden\" name=\"bookName\" value=\""+rs2.getString(2)+"\">");
				pw.println("<input type=\"image\" class=\"image\" src=\""+rs2.getString(4)+"\" width=\"100%\" height=\"100%\">");
				pw.println("</form>");
				pw.println("<figcaption class=\"caption\">\""+rs2.getString(2)+"\"</figcaption>");
				pw.println("</figure>");
				
				while(rs2.next()){
					pw.println("<figure class=\"book\">");
					pw.println("<form class=\"something\" action=\"BookDownload\" method=\"post\">");
					pw.println("<input type=\"hidden\" name=\"bookName\" value=\""+rs2.getString(2)+"\">");
					pw.println("<input type=\"image\" class=\"image\" src=\""+rs2.getString(4)+"\" width=\"100%\" height=\"100%\">");
					pw.println("</form>");
					pw.println("<figcaption class=\"caption\">"+rs2.getString(2)+"</figcaption>");
					pw.println("</figure>");
				}
				pw.println("</div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
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

