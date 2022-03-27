package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	            @Override
                protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
                {
	            	PrintWriter pw = res.getWriter();
	            	res.setContentType("text/html");
                    String fname = new LoginDAO().login(req);
                    if(fname==null)
                    {
                    	pw.println("Invalid Login.....");
                        RequestDispatcher rd = req.getRequestDispatcher("login.html");
                        rd.include(req, res);
                    }
                    else
                    {
                    	HttpSession hs = req.getSession(); //Session Creation
                    	hs.setAttribute("fname", fname);
                    	pw.println("<html>");
                    	pw.println("<body>");
                    	pw.println("<h1 style='text-align:center;background-color:powderblue;padding:30px;'>Welcome :"+fname+"</h1>");
                    	pw.println("</body>");
                    	pw.println("</html>");
                    	 RequestDispatcher rd = req.getRequestDispatcher("process.html");
                         rd.include(req, res);
                    }
                }
}