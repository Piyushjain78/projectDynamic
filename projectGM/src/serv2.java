

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class serv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String s;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    s=request.getParameter("uname");
		String s1=request.getParameter("upass");
		database db=new database();
		out.println("<html><center></center></html>");
		try {
			db.conn();
			db.checklog(s, s1);
			if(db.bo==true)
			{
				out.println("<h2>Login Sussecss</h2>");
				out.println("<a href='./edit.html'>Edit</a>");
			}
			else
			{
			out.println("<h2>Login Fail : Invalid Username And Password</h2>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
