

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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
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
		String uid=request.getParameter("uid");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String add=request.getParameter("add");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		Emp e=new Emp();
		e.setFname(fname);
		e.setMname(mname);
		e.setLname(lname);
		e.setUid(uid);
		e.setGender(gender);
		e.setPhone(phone);
		e.setAdd(add);
		e.setEmail(email);
		e.setPass(pass);
		
		int status=EmpDao.update(e);
		
		if(status>0)
		{
			pw.print("successfulyy done");
			response.sendRedirect("Displaylistservlet");
		}else
		{
			pw.println("Sorry ! unable to update record");
		}
		pw.close();
		
	}

}
