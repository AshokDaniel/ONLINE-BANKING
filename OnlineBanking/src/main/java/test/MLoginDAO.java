package test;
import java.sql.*;
import javax.servlet.http.*;
public class MLoginDAO {
	  public String fname = null;
      public String mlogin(HttpServletRequest req)
      {
    	  try
    	  {
    		  Connection con = DBConnection.getCon();
    		  PreparedStatement ps = con.prepareStatement("select * from manager where aname=? and pword=?");
    		  ps.setString(1, req.getParameter("aname"));
    		  ps.setString(2, req.getParameter("pword"));
    		  ResultSet rs = ps.executeQuery();
    		  if(rs.next())
    		  {
    			  fname = rs.getString(3);
    		  }
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }
    	  return fname;
      }
}
