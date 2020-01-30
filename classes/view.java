import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class view extends HttpServlet {

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
    
     String query="Select * from reserve where password='"+psd+"'  ";
   
     ResultSet rs = st.executeQuery( query );
   
     if(rs.next()){

String dest = rs.getString("destination");
String pack = rs.getString("package");
String person = rs.getString("person");
String date = rs.getString("date");

    
	    out.println("<center><h1><b>Welcome To Karvan</b></h1></center> <br>"); 
 	    out.println("<h1><strong>Your Reservation Details</strong></h1><br>");
            out.println("<h1>Destination: "+dest+" </h1>");
	    out.println("<h1>Package: "+ pack+ " </h1>");
            out.println("<h1>No. of Persons: "+person+" </h1>");
	    out.println("<h1>Date: "+ date+ " </h1>");
	    out.println("<a href='./home.html'><input type='button' value='Home' ></a>");
            out.println("<a href='./main.html'><input type='button' value='Logout' ></a>");

	  }
     
     else{
    	 out.println("<h1>Record not Found</h1>");
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
