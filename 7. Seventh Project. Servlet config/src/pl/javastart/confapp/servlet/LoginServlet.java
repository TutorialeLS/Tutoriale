package pl.javastart.confapp.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/LoginServlet")
//(urlPatterns = "/LoginServlet", initParams = {@WebInitParam(name = "defaultUsername", value = "Nieznajomy")}) 
// -> w przypadku braku danych przeslanych przez get, dodane zostana parametry
// ->parametry moga byc wymieniane po przecinku
//@WebServlet(urlPatterns = "/LoginServlet", initParams = {
       // @WebInitParam(name = "defaultUsername", value = "Nieznajomy"),
      //  @WebInitParam(name = "defaultPassword", value = "admin") })



// LUB za pomoca pliku XML

//<?xml version="1.0" encoding="UTF-8"?>
//<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
//  <display-name>06_Config</display-name>
//  <welcome-file-list>
//    <welcome-file>index.html</welcome-file>
//  </welcome-file-list>
//   
//  <servlet>
//    <servlet-name>LoginServlet</servlet-name>
//    <servlet-class>pl.javastart.confapp.servlet.LoginServlet</servlet-class>
//    <init-param>
//        <param-name>defaultUsername</param-name>
//        <param-value>Guest</param-value>
//    </init-param>
//  </servlet>
//   
//  <servlet-mapping>
//    <servlet-name>LoginServlet</servlet-name>
//    <url-pattern>/LoginServlet</url-pattern>
//  </servlet-mapping>
//</web-app>
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if(username == null || "".equals(username)) {
            username = getServletConfig().getInitParameter("defaultUsername");
        } else {
            //jeœli podano nazwê u¿ytkownika, to zapamiêtujemy j¹ na przysz³osæ na poziomie sesji
            request.getSession().setAttribute("username", username);
        }
         
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Witaj " + username + "</title></head>");
        writer.println("<body>");
        writer.println("<h1>Witaj " + username + "</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
 
}