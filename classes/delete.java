import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class delete extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String psd=request.getParameter("password");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body background='33.jpg'>");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/javaproject";

    Connection con=DriverManager.getConnection(url,"root","1126");

    Statement st=con.createStatement();
    
     String query="Delete  from reserve where password='"+psd+"'  ";
   
    int rs = st.executeUpdate( query );
   
     if (rs!=0){

    
	    out.println("<center><h1><b>Welcome To Karvan</b></h1></center> <br>"); 
 	    out.println("<center><h1><strong>Your Reservation has been cancelled</strong></h1></center><br>");
	    out.println("<a href='./home.html'><input type='button' value='Home' ></a>");
            out.println("<a href='./main.html'><input type='button' value='Logout' ></a>");
        

	  }
     
     else{
    	 out.println("<center><h1>No Reservation </h1></center>");
         out.println("<a href='./view.html'><input type='button' value='Back' ></a>");
          out.println("<a href='./main.html'><input type='button' value='Logout' ></a>");
          }


out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
