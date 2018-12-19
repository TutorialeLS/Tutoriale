package pl.javastart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet") - > zasieg typu request, tylko servlet
//public class LoginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("login");
//        if(request.getAttribute("login") == null)
//            request.setAttribute("login", login);
//        
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<head><title>Witaj " + request.getAttribute("login") + "</title></head>");
//        writer.println("<body>");
//        writer.println("<h1>Witaj " + request.getAttribute("login") + "</h1>");
//        writer.println("</body>");
//        writer.println("</html>");
//    }
//    @WebServlet("/LoginServlet") -> zasieg sesji, do zamkniecia przegladarki lub przy uzyciu innej sie zmieni
//    public class LoginServlet extends HttpServlet {
//        private static final long serialVersionUID = 1L;
//
//        protected void doPost(HttpServletRequest request,
//                HttpServletResponse response) throws ServletException, IOException {
//            String login = request.getParameter("login");
//            if (request.getSession().getAttribute("login") == null)
//                request.getSession().setAttribute("login", login);
//
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html");
//            PrintWriter writer = response.getWriter();
//            writer.println("<html>");
//            writer.println("<head><title>Witaj "
//                    + request.getSession().getAttribute("login")
//                    + "</title></head>");
//            writer.println("<body>");
//            writer.println("<h1>Witaj "
//                    + request.getSession().getAttribute("login") + "</h1>");
//            writer.println("</body>");
//            writer.println("</html>");
//        }
//}


// zasieg aplikacj- do momentu restartu serwera lub aplikacji
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        if (getServletContext().getAttribute("login") == null)
            getServletContext().setAttribute("login", login);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Witaj "
                + getServletContext().getAttribute("login")
                + "</title></head>");
        writer.println("<body>");
        writer.println("<h1>Witaj "
                + getServletContext().getAttribute("login") + "</h1>");
        writer.println("</body>");
        writer.println("</html>");
    }
}