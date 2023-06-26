package final123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpDao {
	public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int save(Emp e) {
		int status=0;
		try {
			Connection con=EmpDao.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into reg values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1,e.getFname());
			pst.setString(2, e.getMname());
			pst.setString(3,e.getLname());
			pst.setString(4, e.getUid());
			pst.setString(5, e.getGender());
			pst.setString(6,e.getPhone());
			pst.setString(7,e.getAdd());
			pst.setString(8,e.getEmail());
			pst.setString(9,e.getPass());
			
			status=pst.executeUpdate();
			con.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public static int update(Emp e)
	{
		int status=0;
		try {
			Connection con=EmpDao.getConnection();
			PreparedStatement pst=con.prepareStatement("update reg set fname=?,mname=?,lname=?,uid1=?,gender=?,address=?,email=?,pass=? where phone=?");
			pst.setString(1, e.getFname());
			pst.setString(2, e.getMname());
			pst.setString(3, e.getLname());
			pst.setString(4, e.getUid());
			pst.setString(5, e.getGender());
			pst.setString(6, e.getAdd());
			pst.setString(7, e.getEmail());
			pst.setString(8, e.getPass());
			pst.setString(9, e.getPhone());
			
			status =pst.executeUpdate();
			con.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();			
		}
		return status;
	}
	public static int delete(String phone)
	{
		int status=0;
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from reg where phone=?");
			pst.setString(1, phone);
			
			status=pst.executeUpdate();
			
			con.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	return status;	
	}
	
	public static Emp getEmployeeByid(String phone)
	{
		Emp e=new Emp();
		try {
			Connection con=EmpDao.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from reg where phone=?");
			pst.setString(1, phone);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				e.setFname(rs.getString(1));
				e.setMname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setUid(rs.getString(4));
				e.setGender(rs.getString(5));
				e.setPhone(rs.getString(6));
				e.setAdd(rs.getString(7));
				e.setEmail(rs.getString(8));
				e.setPass(rs.getString(9));
			//	e.setGender(rs.getString(5));
			}
			con.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return e;
	}
	public static List<Emp> getAllEmployees()
	{
		List<Emp> list=new ArrayList<Emp>();
		
		try
		{
			Connection con=EmpDao.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from reg");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Emp e=new Emp();
				e.setFname(rs.getString(1));
				e.setMname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setUid(rs.getString(4));
				e.setGender(rs.getString(5));
				e.setPhone(rs.getString(6));
				e.setAdd(rs.getString(7));
				e.setEmail(rs.getString(8));
				e.setPass(rs.getString(9));
				list.add(e);
				
			}
			
			con.close();
		}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list;
		}
		

}
