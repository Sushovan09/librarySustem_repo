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

@WebServlet("/OpenBook")
public class BookInsertDatabase extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String TopicName = req.getParameter("topic");
			String query = String.format("SELECT Tid FROM subject_topic WHERE TopicName= '%s'",TopicName);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(rs.next()) {
				resp.setContentType("text/html");
				String Tid = rs.getString(1);
				
				String BookName = req.getParameter("bookname");
				String AuthorName = req.getParameter("authorname");
				String BookImageURL = req.getParameter("image");
				String BookDownloadURL = req.getParameter("download");
				String BookDescription = req.getParameter("descreiption");
				String TotalPage = req.getParameter("totalPage");
				
				String query2 = String.format("INSERT INTO book(BookName,AuthorName,BookImageURL,BookDownloadURL,BookDescription,TotalPage,Tid) VALUES('%s','%s','%s','%s','%s','%s','%s')",BookName,AuthorName,BookImageURL,BookDownloadURL,BookDescription,TotalPage,Tid);
				Statement st2 = con.createStatement();
				st2.executeUpdate(query2);

				
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<h2>book inserted sucessfully</h2>");
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
