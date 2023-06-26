package final123;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forgotpassservlet
 */
@WebServlet("/forgotpassservlet")
public class forgotpassservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String uid=request.getParameter("uid");
		String pass1=request.getParameter("pass1");
		String pass2=request.getParameter("pass2");
		
		if(pass1.equals(pass2))
		{
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
			PreparedStatement pst=con.prepareStatement("update reg set pass=? where uid1=?");
			pst.setString(1, pass1);
			pst.setString(2, uid);
			int i=pst.executeUpdate();
			if(i>0)
			{
				pw.print("update Successsfully....!");
				response.sendRedirect("user.html");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			pw.print("Re-enter the password");
			response.sendRedirect("forgotpassword.html");
			
		}
	}

}
