package test;import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	     @Override
         protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
         {
	    	 try
	    	 {
	    	 PrintWriter pw = res.getWriter();
	    	 res.setContentType("text/html"); 
	    	 long baccno = Long.parseLong(req.getParameter("baccno"));
	    	 long phno = Long.parseLong(req.getParameter("phno"));
	    	 double amt = Double.parseDouble(req.getParameter("amt"));
	    	 ArrayList<Integer> al = new ArrayList<Integer>();
             Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement("select * from UserReg where accno=?");
             ps.setLong(1, baccno);
             ResultSet rs = ps.executeQuery();
             if(rs.next())
             {
            	 double bal = rs.getLong(8)+amt;
            	 
            	 PreparedStatement ps2 = con.prepareStatement("update UserReg set bal=? where accno=?");
            	 ps2.setDouble(1,bal); 
            	 ps2.setLong(2, baccno);
            	 int k = ps2.executeUpdate();
            	 if(k>0)
            	 {
            		 pw.println("Transfer Amount Successfully.......");
            	 }
            	 else
            	 {
            		 pw.println("Tranfer amount Failure........");
            	 }
            	 HttpSession hs = req.getSession(false);
            	 String fname =(String)hs.getAttribute("fname");
            	 PreparedStatement ps3 = con.prepareStatement("select * from UserReg where uname=?");
            	 ps3.setString(1, fname);
            	 ResultSet rs2 = ps3.executeQuery();
            	 if(rs2.next())
            	 {
            		 bal = rs.getDouble(8);
            	 }
            	 bal = bal-amt;
            	 PreparedStatement ps4 = con.prepareStatement("update UserReg set bal=? where uname=?");
            	 ps4.setDouble(1, bal);
            	 ps4.setString(2, fname);
            	 k = ps4.executeUpdate();
            	 if(k>0)
            	 {
            		 pw.println("Transfer Amount Successfully.......");
            	 }
            	 else
            	 {
            		 pw.println("Tranfer amount Failure........");
            	 }
             }
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
         }
}
