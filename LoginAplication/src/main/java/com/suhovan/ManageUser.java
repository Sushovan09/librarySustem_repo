package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manageU")
public class ManageUser extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("</head><body>");
				pw.println("<br><br><br><br><br><br><br><br><div class=\"logHere\">");
				pw.println("<form action=\"manageA\" method = \"GET\"><br>");
				pw.println("<input type = \"submit\" class = \"signin\" value = \"manage admin\">");
				pw.println("</form>");
				pw.println("<form action=\"manageS\" method = \"GET\">");
				pw.println("<input type = \"submit\" class = \"signin\" value = \"manage student\">");
				pw.println("</form></div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("</body></html>");
		
	}
}
