

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String s=request.getParameter("unames");
		String s1=request.getParameter("upasss");
		String s2=request.getParameter("mob");
		String s3=request.getParameter("gm");
		String s4=request.getParameter("ad");
		database db=new database();
		out.println("<html><center></center></html>");
		try {
			db.conn();
			db.check(s);
			if(db.bo==false)
			{
			db.signup(s,s1,s2,s3,s4);
			if(db.i==1)
			{
				out.println("<h2>Successfully Signeup</h2>");
				
			}
			else
			{
				out.println("<h2>Fail to Signeup</h2>");
			}
			}
			else
			{
				out.println("<h3>Fail to Signeup : UsernameAlready exist</h3>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
