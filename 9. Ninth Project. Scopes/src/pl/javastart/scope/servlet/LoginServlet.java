//package pl.javastart.scope.servlet;
// 
//import java.io.IOException;
//import java.io.PrintWriter;
// 
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
// 
//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
// 
//    protected void doGet(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//// ----------------------------------------------------------------> zasieg request, po kazdym wywolaniu ponownie 
////    protected void doPost(HttpServletRequest request, 			 potrzebne ponowne wywolanie
////            HttpServletResponse response) throws ServletException, IOException {
////        String login = request.getParameter("login");
////        if(request.getAttribute("login") == null)
////            request.setAttribute("login", login);
////         
////        response.setCharacterEncoding("UTF-8");
////        response.setContentType("text/html");
////        PrintWriter writer = response.getWriter();
////        writer.println("<html>");
////        writer.println("<head><title>Witaj " + request.getAttribute("login") + "</title></head>");
////        writer.println("<body>");
////        writer.println("<h1>Witaj " + request.getAttribute("login") + "</h1>");
////        writer.println("</body>");
////        writer.println("</html>");
////    }
//    
////------------------------------------------------------------------> zasieg atrybutu w sesji    
////    protected void doPost(HttpServletRequest request,
////            HttpServletResponse response) throws ServletException, IOException {
////        String login = request.getParameter("login");
////        if (request.getSession().getAttribute("login") == null)
////            request.getSession().setAttribute("login", login);
//// 
////        response.setCharacterEncoding("UTF-8");
////        response.setContentType("text/html");
////        PrintWriter writer = response.getWriter();
////        writer.println("<html>");
////        writer.println("<head><title>Witaj "
////                + request.getSession().getAttribute("login")
////                + "</title></head>");
////        writer.println("<body>");
////        writer.println("<h1>Witaj "
////                + request.getSession().getAttribute("login") + "</h1>");
////        writer.println("</body>");
////        writer.println("</html>");
////    }
////    
//    
//    
//// -----------------------------------------------------------------------> application Scope, 
////                                                                          zapamietuje atrybuty nawet z innych sesji   
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("login");
//        if (getServletContext().getAttribute("login") == null)
//            getServletContext().setAttribute("login", login);
// 
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<head><title>Witaj "
//                + getServletContext().getAttribute("login")
//                + "</title></head>");
//        writer.println("<body>");
//        writer.println("<h1>Witaj "
//                + getServletContext().getAttribute("login") + "</h1>");
//        writer.println("</body>");
//        writer.println("</html>");
//    }
// 
//}