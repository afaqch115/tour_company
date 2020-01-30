import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class login1 extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String eml=request.getParameter("email");
    String psd=request.getParameter("password");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/javaproject";

    Connection con=DriverManager.getConnection(url,"root","1126");

    Statement st=con.createStatement();
    
     String query="Select * from karvan where email='"+eml+"' AND password='"+psd+"'  ";
   
     ResultSet rs = st.executeQuery( query );
   
     if(rs.next()){

String type = rs.getString("type");
out.println("<h1>afaq</h1>");
if(type.equals("u")){
	 response.sendRedirect("home.html");
		}
else{
	response.sendRedirect("home.html");
}
	  }
     
     else{
    	 out.println("<h1>Email or password not match</h1>");
          out.println("<a href='./login1.html'><input type='button' value='Back' ></a>");
          }


out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
