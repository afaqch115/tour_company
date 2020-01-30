import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class signup1 extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String city=request.getParameter("city");
    String type="u";

    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/javaproject";

    Connection con=DriverManager.getConnection(url, "root", "1126");

    Statement st=con.createStatement();

     
     String query = "INSERT INTO karvan(name,email,password,city,type)VALUES('"+ name + "','"+ email + "','" + password+ "','"+ city + "','"+type+ "') ";

     System.out.println(query);

      int rs = st.executeUpdate( query );

     if(rs==1){	response.sendRedirect("main.html"); 		}
	else{	out.println("<h1>Record could not be inserted.</h1>"); 		}

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}