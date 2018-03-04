

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String po;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		po = request.getParameter("otp");
		database db=new database();
				if(po.equals(midotp.p))
				{
					try {
						db.conn();
						db.updatepass(midotp.s2, midotp.s, midotp.s1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print("success");
					
				}
				else
				{
					out.print("not success");
				}
	}

}
