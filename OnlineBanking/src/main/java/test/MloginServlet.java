package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/mlogin")
public class MloginServlet extends HttpServlet{
          protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
          {
        	  PrintWriter pw = res.getWriter();
        	  res.setContentType("text/html");
        	  String fname = new MLoginDAO().mlogin(req);
        	  if(fname==null)
        	  {
        		  pw.println("Invalid Login.....");
        		  RequestDispatcher rd = req.getRequestDispatcher("mlogin.html");
        		  rd.include(req, res);
        	  }
        	  else
        	  {
        		  // Add the attribute to session
        		  HttpSession hs = req.getSession();
        		  hs.setAttribute("fname", fname);
        		  pw.println("<h1 style='text-align:center'>Page of :"+fname+"</h1>");
        		  RequestDispatcher rd = req.getRequestDispatcher("mpage.html");
        		  rd.include(req, res);
        	  }
          }
}
