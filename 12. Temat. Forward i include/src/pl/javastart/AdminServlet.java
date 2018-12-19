package pl.javastart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	HttpSession session=request.getSession(true);
    	String username = request.getParameter("username");  	
//    	session.setAttribute("username",username);  
        //response.sendRedirect("LoginServlet");
        System.out.println("AdminServlet POST " + username );
        request.getRequestDispatcher("LoginServlet").include(request, response);//przechodzi do serwletu LoginServlet i wraca po wykonaniu zadania
        response.getWriter().println("Tekst odpowiedzi po operacji include");
//        request.getRequestDispatcher("LoginServlet").forward(request, response);//przechodzi do serwletu LoginServlet i nie wraca
//        response.getWriter().println("Tekst odpowiedzi po operacji forward()");
    }

}