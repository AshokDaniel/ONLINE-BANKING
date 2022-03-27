package test;
import java.sql.*;
public class DBConnection {
 private static Connection con=null;
 private DBConnection() {}
 static {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection
					 ("jdbc:oracle:thin:@localhost:1521:XE","system","orcl");
		 }
		 catch(Exception e) 
		 {
			 e.printStackTrace();
		 }
      }//end of static
     public static Connection getCon() {
        return con;
      }
}