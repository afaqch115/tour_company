import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class logout extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();
   try{
 request.getRequestDispatcher("main.html").include(request, response);  
              
            HttpSession session=request.getSession();  
            session.invalidate();    
              
            out.close();  



    }
catch(Exception e){

      out.println(e);
    }

  }

}
