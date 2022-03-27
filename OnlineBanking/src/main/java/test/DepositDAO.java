package test;
import java.sql.*;
import java.util.Date;
import javax.servlet.http.*;
public class DepositDAO {
            @SuppressWarnings("deprecation")
			public void Deposit(HttpServletRequest req)
            {
            	try
            	{
            	Connection con = DBConnection.getCon();
            	HttpSession hs = req.getSession(false);
            	long accno = (long)hs.getAttribute("accno");
            	PreparedStatement ps = con.prepareStatement("insert into Deposit values(?,?,?)");
            	ps.setLong(1, accno);
            	ps.setString(2, "Deposited");
            	Date d = new Date();
            	java.sql.Date d2 = new java.sql.Date(d.getTime());
            	ps.setDate(3, d2);
            	ps.executeUpdate();
            	}
            	catch(Exception e)
            	{
            		e.printStackTrace();
            	}
            }
}
