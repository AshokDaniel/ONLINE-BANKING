package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		try
		{
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			Connection con = DBConnection.getCon();
			HttpSession hs = req.getSession(false);
			String fname =(String) hs.getAttribute("fname");
			PreparedStatement psa = con.prepareStatement("select * from UserReg where fname=?");
			psa.setString(1,fname);
			ResultSet rsa = psa.executeQuery();
			long paccno = 0;
			if(rsa.next())
			{
		       paccno = rsa.getLong(9); 
			}
			long accno = Long.parseLong(req.getParameter("accno"));
			if(paccno==accno)
			{
				String toa = req.getParameter("toa");
				double amt = Double.parseDouble(req.getParameter("amt"));
				
				if(amt%100==0)
				{
					//Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("select * from UserReg where accno=?");
					ps.setLong(1, accno);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						if(toa.equalsIgnoreCase(rs.getString(10)))
						{
							double  bal = rs.getDouble(8)+amt;
							PreparedStatement ps2 = con.prepareStatement("update UserReg set bal=? where accno=?");
							ps2.setDouble(1, bal);
							ps2.setLong(2, accno);
							int k = ps2.executeUpdate();
							if(k>0)
							{
								
								hs.setAttribute("accno", accno);
								new DepositDAO().Deposit(req);
								pw.println("Your Amount is deposited successfully.....");
								
							}
							else
							{
								pw.println("Deposited Failure.....");
							}
						}
						else
						{
							pw.println("Select correct type of account......");
						}
					}
				}
				else
				{
					pw.println("Invalid Amount.....");
				}
			}
			else
			{
				pw.println("Invalid Account Number....");
			}
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}
