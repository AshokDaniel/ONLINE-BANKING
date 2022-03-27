package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/wdraw")
public class WithDrawServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		
		try
		{
		long pin = Long.parseLong(req.getParameter("pin"));
		String toa = req.getParameter("toa");
		double amt = Double.parseDouble(req.getParameter("amt"));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		Connection con = DBConnection.getCon();
		HttpSession hs = req.getSession(false);
		String fname = (String)hs.getAttribute("fname");
		PreparedStatement ps = con.prepareStatement("select * from UserReg where fname=?");
		ps.setString(1, fname);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
				if(pin==rs.getLong(11))
				{
				if(amt%100==0 && amt>0)
				{
			    		if(toa.equalsIgnoreCase(rs.getString(10)))
						{
							double  bal = rs.getDouble(8)-amt;
							PreparedStatement ps2 = con.prepareStatement("update UserReg set bal=? where fname=?");
							ps2.setDouble(1, bal);
							ps2.setString(2, fname);
							int k = ps2.executeUpdate();
							if(k>0)
							{
								new WithDrawDAO().WithDraw(req);
								pw.println("Amount withdrawn successfully.....");
							}
							else
							{
								pw.println("WithDraw Failure.....");
							}
						}
						else
						{
							pw.println("Select correct type of account......");
						}
					
				}
				else
				{
					pw.println("Invalid Amount.....");
				}
				}//end of if
				else {
					pw.println("Invalid Pin....");
				}
		}//end of if
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}
