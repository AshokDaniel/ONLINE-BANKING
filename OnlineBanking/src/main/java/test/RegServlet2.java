package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegServlet2 extends HttpServlet{
			@Override
			 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
			  {
				 UserBean ub = new UserBean();
				 ub.setuName(req.getParameter("uname"));
				 ub.setpWord(req.getParameter("pword"));
				 ub.setfName(req.getParameter("fname"));
				 ub.setlName(req.getParameter("lname"));
				 ub.setAddr(req.getParameter("addr"));
				 ub.setmId(req.getParameter("mid"));
				 ub.setPhNo(Long.parseLong(req.getParameter("phno")));
				 ub.setBal(Double.parseDouble(req.getParameter("bal")));
				 ub.setAccNo(Long.parseLong(req.getParameter("accno")));
				 ub.setToA(req.getParameter("toa"));
				 ub.setPin(Long.parseLong(req.getParameter("pin")));
				 int k = new InsertDAO().insert(ub);//Bean as Parameter
				 PrintWriter pw = res.getWriter();
				 res.setContentType("text/html");
				 if(k>0)
				 {
					 pw.println("User Registration Successfull...<br>");
					 
			     }
				 else
				 {
					 pw.println("Registration failure......");
					 
				 }
				 RequestDispatcher rd = req.getRequestDispatcher("login.html");
				 rd.include(req, res);
				}
}