package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/pinc")
public class PinchangeServlet extends HttpServlet {
             protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
             {
            	 long npin = Long.parseLong(req.getParameter("npin"));
            	 long cpin = Long.parseLong(req.getParameter("cpin"));
            	 PrintWriter pw = res.getWriter();
        		 res.setContentType("text/html");
            	 if(npin!=cpin)
            	 {
            		 pw.println("Enter correct Pin.....");
            		 RequestDispatcher rd = req.getRequestDispatcher("pinchange.html");
            		 rd.include(req, res);
            	 }
            	 try
            	 {
            		 Connection con = DBConnection.getCon();
            		 HttpSession hs=req.getSession(false);
            		 String fname = (String)hs.getAttribute("fname");
            		 PreparedStatement ps = con.prepareStatement("update UserReg set pin=? where fname=?");
            		 ps.setLong(1, cpin);
            		 ps.setString(2, fname);
            		 int k = ps.executeUpdate();
            		 
            		 if(k>0)
            		 {
            			 pw.println("Pin Updated Successfully.....");
            		 }
            		 else
            		 {
            			 pw.println("Pin change is Failure......");
            		 }
            	 }
            	 catch(Exception e)
            	 {
            		 e.printStackTrace();
            	 }
             }
}
