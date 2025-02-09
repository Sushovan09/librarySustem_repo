package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
			resp.setContentType("text/html");
				
			PrintWriter pw = resp.getWriter();
			pw.println("<html><head>");
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
			pw.println("<head><body>");
			pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
			pw.println("<h2><b>Select filds To Update of the book</b></h2>");
			pw.println("<form action=\"updateBook2\" method =\"POST\">");
			pw.println("<select name=\"field\" id=\"subject\">");	
			pw.println("<option value=\"BookName\">Book Name</option>");
			pw.println("<option value=\"AuthorName\">Author Name</option>");
			pw.println("<option value=\"BookImageURL\">Book Image URL</option>");
			pw.println("<option value=\"BookDownloadURL\">Book Download URL</option>");
			pw.println("<option value=\"BookDescription\">Book Description</option>");
			pw.println("<option value=\"TotalPage\">Total Page</option>");
			pw.println("<option value=\"TId\">book Subject & Topic</option>");
			pw.println("</select><br><input type = \"submit\" class = \"signin\" value = \"Continue\"></form></div><br>");
			pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
			pw.println("<body></html>");

	}
}
