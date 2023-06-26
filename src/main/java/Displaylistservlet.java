

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final123.Emp;
import final123.EmpDao;



/**
 * Servlet implementation class Displaylistservlet
 */
@WebServlet("/Displaylistservlet")
public class Displaylistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<a href='registration.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<Emp>list=EmpDao.getAllEmployees();
		out.print("<table border='1' width='100%'");
		
		out.print("<tr><th>FirstName:</th><th>MiddleName:</th><th>LastName:</th><th>UserId:</th><th>Gender:</th><th>Phone:</th><th>Address:</th><th>Email:</th><th>Password:</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list)
		{
			out.print("<tr><td>"+e.getFname()+"</td><td>"+e.getMname()+"</td><td>"+e.getLname()+"</td><td>"+e.getUid()+"</td><td>"+e.getGender()+"</td><td>"+e.getPhone()+"</td><td>"+e.getAdd()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPass()+"</td><td><a href='Editservlet?phone="+e.getPhone()+"'>edit</a></td><td><a href='DeleteServlet?phone="+e.getPhone()+"'>delete</a></td></tr>");
		}
		out.print("</table");
		out.close();
	}

}
