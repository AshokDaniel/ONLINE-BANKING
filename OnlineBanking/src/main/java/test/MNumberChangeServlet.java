package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
@SuppressWarnings("serial")
@WebServlet("/mchange")
public class MNumberChangeServlet extends HttpServlet {
             protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
             {
            	 long ophno = Long.parseLong(req.getParameter("ophno"));
            	 long nphno = Long.parseLong(req.getParameter("nphno"));
            	 PrintWriter pw = res.getWriter();
        		 res.setContentType("text/html");
            	 try
            	 {
            		 Connection con = DBConnection.getCon();
            		 HttpSession hs=req.getSession(false);
            		 String fname = (String)hs.getAttribute("fname");
            		 PreparedStatement ps = con.prepareStatement("select * from UserReg  where fname=?");
            		 ps.setString(1, fname);
                     
            		 ResultSet rs = ps.executeQuery();
            		 if(rs.next())
            		 {
            			 if(ophno==rs.getLong(7))
            			 {
            				 PreparedStatement ps2 = con.prepareStatement("update UserReg set phno=? where fname=?");
            				 ps2.setLong(1, nphno);
                    		 ps2.setString(2, fname);
                    		 int k = ps2.executeUpdate();
                    	     
                    		 if(k>0)
                    		 {
                    			 pw.println("Mobile Number Updated Successfully.....");
                    		 }
                    		 else
                    		 {
                    			 pw.println("Mobile Number change is Failure......");
                    		 }
            			 }
            			 
            		 }
            		 
            		 
            	 }
            	 catch(Exception e)
            	 {
            		 e.printStackTrace();
            	 }
             }
}
