

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class forgetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<head><link rel='stylesheet' href='styles.css'");
		out.println("<body bgcolor='#C0C0C0'>");
		out.println("<form action='./redirect' method='POST'>");
		out.println("<center>");
		out.println("<table>");
		out.println("<tr><td>Enter OTP</td>");
		out.println("<td><input type='text' name='otp'</td></tr>");
		out.println("<td><br></td>");
		out.println("<tr><td><input id='p02' type='submit' value='Submit'</td></tr>");
		out.println("</table></center></form></body>");
		
	}

}
