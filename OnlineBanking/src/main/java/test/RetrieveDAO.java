package test;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
public class RetrieveDAO {
          @SuppressWarnings("rawtypes")
		public ArrayList<UserBean> al = new ArrayList<UserBean>();
          @SuppressWarnings({ "rawtypes", "unchecked" })
		public ArrayList Retrive()
          {
        	  try
        	  {
        		  Connection con = DBConnection.getCon();
        		  PreparedStatement ps = con.prepareStatement("select * from UserReg");
        		  ResultSet rs = ps.executeQuery();
        		  while(rs.next())
        		  {
        			  UserBean ub = new UserBean();
        			  ub.setuName(rs.getString(1));
        			  ub.setpWord(rs.getString(2));
        			  ub.setfName(rs.getString(3));
        			  ub.setlName(rs.getString(4));
        			  ub.setAddr(rs.getString(5));
        			  ub.setmId(rs.getString(6));
        			  ub.setPhNo(rs.getLong(7));
        			  ub.setBal(rs.getDouble(8));
        			  ub.setAccNo(rs.getLong(9));
        			  ub.setToA(rs.getString(10));
        			  ub.setPin(rs.getLong(11));
        			  al.add(ub); // JCF
        		  }
        	  }
        	  catch(Exception e)
        	  {
        		  e.printStackTrace();
        	  }
        	  return al;
          }
}
