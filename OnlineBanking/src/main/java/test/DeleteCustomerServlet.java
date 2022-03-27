package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/deleteC")
public class DeleteCustomerServlet extends HttpServlet {
                protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
                {
                	HttpSession hs = req.getSession(false);
                	if(hs==null)
          		  {
          			  req.setAttribute("msg", "Session Expired.....");
          			  req.getRequestDispatcher("Fail.jsp").forward(req, res);
          		  }
          		  else
          		  {
                	try
                	{
                		
                		Long accno = Long.parseLong(req.getParameter("accno"));
                		Connection con = DBConnection.getCon();
                		PreparedStatement ps = con.prepareStatement("delete from UserReg where accno=?");
                		ps.setLong(1, accno);
                		int k = ps.executeUpdate();
                	if(k>0)
                	{
                		req.setAttribute("msg", "Customer record deleted Successfully....");
                		
                	}
                	else
                	{
                		req.setAttribute("msg", "Invalid Account Number....");
                	}
                	RequestDispatcher rd = req.getRequestDispatcher("adminfail.jsp");
            		rd.forward(req, res);
                	}
                	catch(Exception e) {e.printStackTrace();}
                  }//end of else
                }
}
