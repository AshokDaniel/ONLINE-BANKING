package test;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/viewC")
public class ViewCustomersServlet extends HttpServlet{
        @SuppressWarnings("unchecked")
		protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
        {
        	PrintWriter pw = res.getWriter();
        	res.setContentType("text/html");
        	
        	ArrayList<UserBean> al = new RetrieveDAO().Retrive();
        	
        	if(al.size()==0)
        	{
        		pw.println("No records are avilable.....");
        		RequestDispatcher rd = req.getRequestDispatcher("mpage.html");
        		rd.include(req, res);
        	}
        	else
        	{
        		HttpSession hs = req.getSession(false);
      		  String fname = (String)hs.getAttribute("fname");
      		  pw.println("<h1 style='text-align:center'>Page of :"+fname+"</h1>");
      		  RequestDispatcher rd = req.getRequestDispatcher("mpage.html");
      		  rd.include(req, res);
        	   pw.println("<html><body>");
 			   String s = "Customer Details";
 			   pw.println("<head><style>");
 			   pw.println("td {background-color:powderblue;border: 1px solid black;}");
 			   pw.println("th {background-color:pink;border: 1px solid black;}");
 			   pw.println("h1 {color:orange;font-size:300%;}");
 			  pw.println("body {background-color:red;}");
 			   pw.println("table{text-align:center;margin:auto;}");
 			   pw.println("</style></head>");
 			   
 			   pw.println("<table border=1 width=60% height=30%>");
 			   pw.println("<caption><h1>"+s+"</h1></caption>");
 			  Iterator<UserBean> it = al.iterator();
 			   pw.println("<tr><th>User Name </th><th>Password </th><th>Fisrt Name</th><th>Last Name</th>"
 			   		+ "<th>Address</th><th>Mail ID</th><th>Phone No</th><th>Balance</th><th>AccNo</th>"
 			   		+ "<th>Type of Acc</th><th>Pin Number</th>");
 			   while(it.hasNext())
 			   {
 				  UserBean ub = (UserBean)it.next();
 				   pw.println("<tr><td>"+ub.getuName()+"</td><td>"+ub.getpWord()+"</td><td>"+
 				   ub.getfName()+"</td><td>"+ub.getlName()+
 						   "</td><td>"+ub.getAddr()+"</td><td>"+ub.getmId()+"</td><td>"+ub.getPhNo()
 						   +"</td><td>"+ub.getBal()+"</td><td>"+ub.getAccNo()+"</td><td>"+ub.getToA()+"</td><td>"+ub.getPin()+"</td></tr>");
 			   }
 			   pw.println("</table>");
 			   pw.println("</body></html>");
        	}
        }
}
