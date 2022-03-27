package test;
import java.sql.*;
import javax.servlet.http.*;
public class InsertDAO {
 public int k=0;
 public int insert(UserBean ub)
 {
		 try {
		 Connection con = DBConnection.getCon();
		 //Accessing the existing Connection 
		 PreparedStatement ps = con.prepareStatement
		 ("insert into UserReg values(?,?,?,?,?,?,?,?,?,?,?)");
		 ps.setString(1,ub.getuName());
		 ps.setString(2,ub.getpWord());
		 ps.setString(3,ub.getfName());
		 ps.setString(4,ub.getlName());
		 ps.setString(5,ub.getAddr());
		 ps.setString(6,ub.getmId());
		 ps.setLong(7,ub.getPhNo());
		 ps.setDouble(8, ub.getBal());
		 ps.setLong(9,ub.getAccNo());
		 ps.setString(10,ub.getToA());
		 ps.setLong(11, ub.getPin());
		 k = ps.executeUpdate();
		 }catch(Exception e) {e.printStackTrace();}
         return k;
 }
}