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

@WebServlet("/SelectSubject")
public class BookInsert extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String SubjectName = req.getParameter("subject");
			String query = String.format("SELECT TopicName FROM subject_topic WHERE SubjectName= '%s'",SubjectName);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(rs.next()) {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<h2><b><u>Insert Book</u></b></h2>");
				pw.println("<form action=\"OpenBook\" method =\"POST\">");
				pw.println("<>choose topic:</>");
				pw.println("<select name=\"topic\" id=\"topic\">");	
				pw.println("<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>");
				while(rs.next()) {
					pw.println("<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>");
				}
				pw.println("</select><br><br>");
				pw.println("<input type = \"text\" class =\"text\" name= \"bookname\" placeholder = \"Enter Bookname\"><br><br>");
				pw.println("<input type =\"text\" class = \"text\" name = \"authorname\" placeholder = \"Enter AuthorName\"><br><br>");
				pw.println("<input type = \"text\" class =\"text\" name= \"image\" placeholder = \"Enter Book image URL\"><br><br>");
				pw.println("<input type = \"url\" class =\"text\" name= \"download\" placeholder = \"Enter Download link URL\"><br><br>");
				pw.println("<input type =\"text\" class = \"text\" name = \"descreiption\" placeholder = \"Enter book Description\"><br><br>");
				pw.println("<input type = \"number\" class =\"text\" name= \"totalPage\" placeholder = \"Enter total page number\"><br><br>");
				pw.println("</select><input type = \"submit\" class = \"signin\" value = \"Submit\"></form>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("<body></html>");
		
			}
			else {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h1>Something Went Wrong.</h1>");
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

