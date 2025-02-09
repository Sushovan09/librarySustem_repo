package com.suhovan;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteA")
public class DeleteAdmin extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("</head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<form action=\"deleteA2\" method = \"POST\">");
				pw.println("<h2>Enter Valid Details Of The Admin</h2>");
				pw.println("<input type = \"text\" class =\"text\" name= \"username\" placeholder = \"Enter Username\"><br><br>");
				pw.println("<input type =\"password\" class = \"text\" name = \"passwd\" placeholder = \"Enter Password\"><br><br>");
				pw.println("<input type = \"submit\" class = \"signin\" value = \"Delete user\">");
				pw.println("<form></div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("</body></html>");
		
	}
}


