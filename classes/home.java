import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class home extends HttpServlet{
 public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
 {

String reserve = req.getParameter("action");
String view = req.getParameter("action");
String update = req.getParameter("update");
String del = req.getParameter("del"); 

        if("Reservation".equals(reserve)) {
            RequestDispatcher rs = req.getRequestDispatcher("reservation.html"); 
            rs.forward(req, res);
        }
        else if("View Reservation".equals(view)) { 
            RequestDispatcher rs = req.getRequestDispatcher("view.html"); 
            rs.forward(req, res);
        }
	else if(update != null) { 
            RequestDispatcher rs = req.getRequestDispatcher("update.html"); 
            rs.forward(req, res);
        }
	else if(del != null) { 
            RequestDispatcher rs = req.getRequestDispatcher("delete.html"); 
            rs.forward(req, res);
        }

  

  

 }
}