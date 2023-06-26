

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final123.Emp;
import final123.EmpDao;



/**
 * Servlet implementation class Editservlet
 */
@WebServlet("/Editservlet")
public class Editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	       PrintWriter out=response.getWriter();
	       
	       out.print("<h1>update Employee</h1>");
	       String phone=request.getParameter("phone");
	      
	       
	       Emp e=EmpDao.getEmployeeByid(phone);
	       
	       out.print("<form action ='EditServlet2' method='Post'>");
	       out.print("<table>");
	       out.print("<tr><td>FirstName:</td><td><input type='text' name='fname' value='"+e.getFname()+"'/></td></tr>");
	       out.print("<tr><td>MiddleName:</td><td><input type='text' name='mname' value='"+e.getMname()+"'/></td></tr>");
	       out.print("<tr><td>LastName:</td><td><input type='text' name='lname' value='"+e.getLname()+"'/></td></tr>");
	       out.print("<tr><td>UserId:</td><td><input type='text' name='uid' value='"+e.getUid()+"'/></td></tr>");
	       out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+e.getGender()+"'/></td></tr>");
	    //   out.print("<tr><td>Phone:</td><td><input type='hidden' name='phone' value='"+e.getPhone()+"'/></td></tr>");
	       out.print("<input type='hidden' name='phone' value='"+e.getPhone()+"'/>");
	       out.print("<tr><td>Address:</td><td><input type='text' name='add' value='"+e.getAdd()+"'/></td></tr>");
	       out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
	       out.print("<tr><td>Password:</td><td><input type='text' name='pass' value='"+e.getPass()+"'/></td></tr>");
	       
	       
	       out.print("<tr><td colspan='2'><input type='submit' value='Edit & save'/><td></tr>");
	       out.print("</table>");
	       out.print("</form>");
	       out.close();
	       
	}

}
