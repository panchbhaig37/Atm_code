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
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String  gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String add=request.getParameter("add");
		String email=request.getParameter("email");
		String aname=request.getParameter("aname");
		String ptype=request.getParameter("ptype");
		String location=request.getParameter("location");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
			PreparedStatement pst=con.prepareStatement("insert into buyproperty values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fname);
			pst.setString(2, mname);
			pst.setString(3, lname);
			pst.setString(4, gender);
			pst.setString(5, phone);
			pst.setString(6, add);
			pst.setString(7, email);
			pst.setString(8, aname);
			pst.setString(9, ptype);
			pst.setString(10, location);
			
		
			int i=pst.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Property.html");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
