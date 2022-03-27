package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/bal")
public class BalanceServlet extends HttpServlet {
	public long AccNo = 0;
	public double bal = 0;
            protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
            {
            	try
            	{
            		UserBean ub = null;
            		Connection con = DBConnection.getCon();
            		HttpSession hs = req.getSession(false);
            		String fname = (String)hs.getAttribute("fname");
            		PreparedStatement ps = con.prepareStatement("select * from UserReg where fname=?");
            		ps.setString(1, fname);
            		ResultSet rs = ps.executeQuery();
            		if(rs.next())
            		{
            				ub = new UserBean();
            				ub.setlName(rs.getString(4));
            				ub.setfName(rs.getString(3));
            				ub.setAddr(rs.getString(5));
            				ub.setmId(rs.getString(6));
            				ub.setBal(rs.getDouble(8));
            				ub.setAccNo(rs.getLong(9));
            				ub.setToA(rs.getString(10));
            				ub.setPhNo(rs.getLong(7));
            				hs.setAttribute("ubean", ub);
                			req.getRequestDispatcher("profile.jsp").forward(req, res);
            		}
            	}
            	catch(Exception e)
            	{
            		e.printStackTrace();
            	}
            	
            }
}
