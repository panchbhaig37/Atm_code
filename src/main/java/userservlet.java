

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class userservlet
 */
@WebServlet("/userservlet")
public class userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
			Statement st=con.createStatement(); 
			ResultSet rs=st.executeQuery("select * from reg where uid1='"+uid+"' and pass='"+pass+"' ");
			//boolean b=rs.next();
			if(rs.next())
			{
				pw.print("successuly login");
				RequestDispatcher requestDispatcher =request.getRequestDispatcher("Property.html");
				requestDispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher requestDispatcher =request.getRequestDispatcher("registration.html");
				requestDispatcher.forward(request, response);
			}
			
			
			
	    	
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    	
	    }
	    
	}

}
