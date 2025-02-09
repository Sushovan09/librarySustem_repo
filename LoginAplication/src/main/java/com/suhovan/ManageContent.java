package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageContent")
public class ManageContent extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("</head><body>");
				pw.println("<br><br><br><br><br><br><br><br><div class=\"log\">");
				pw.println("<form action=\"SelectBookSubject\" method = \"GET\">");
				pw.println("<input type = \"submit\" class = \"signin\" value = \"Create Book\">");
				pw.println("</form>");
				pw.println("<form action=\"updateBook\" method = \"GET\">");
				pw.println("<input type = \"submit\" class = \"signin\" value = \"Update Book\">");
				pw.println("</form>");				
				pw.println("<form action=\"deleteBook\" method = \"GET\">");
				pw.println("<input type = \"submit\" class = \"signin\" value = \"Delete Book\">");
				pw.println("</form></div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("</body></html>");
		
	}
}

