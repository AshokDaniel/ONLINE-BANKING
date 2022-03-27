package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class Logout extends HttpServlet{
          public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
          {
        	  HttpSession hs = req.getSession(false);
        	  if(hs==null)
        	  {
        		  req.setAttribute("msg", "Session Expired.....");
        	  }
        	  else
        	  {
        		  hs.invalidate();
        		  req.setAttribute("msg", "Logged out Successfully.....");
        	  }
        	  req.getRequestDispatcher("Fail.jsp").forward(req, res);
          }
}
