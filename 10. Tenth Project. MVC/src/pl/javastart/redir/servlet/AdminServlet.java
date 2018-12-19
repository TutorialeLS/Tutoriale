//package pl.javastart.redir.servlet;
// 
//import java.io.IOException;
// 
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
// 


//-------------------------------------------------------------->przekierowanie, bez zachowania przesylanych parametrow
//@WebServlet("/AdminServlet")
//public class AdminServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
// 
//    protected void doGet(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        System.out.println("AdminServlet GET " + username );
//        response.sendRedirect("LoginServlet");
//    }
// 
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        System.out.println("AdminServlet POST " + username );
//        response.sendRedirect("LoginServlet");
//    }
// 
//}




//---------------------------------------------------------->foward przekazanie parametru z servletu do servletu
//package pl.javastart.redir.servlet;
// 
//import java.io.IOException;
// 
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
// 
//@WebServlet("/AdminServlet")
//public class AdminServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
// 
//    public AdminServlet() {
//        super();
//    }
// 
//    protected void doGet(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        System.out.println("AdminServlet GET " + username );
//        request.getRequestDispatcher("LoginServlet").forward(request, response);
//        response.getWriter().println("Tekst odpowiedzi po operacji forward()");
//    }
// 
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        System.out.println("AdminServlet POST " + username );
//        request.getRequestDispatcher("LoginServlet").forward(request, response);
//        response.getWriter().println("Tekst odpowiedzi po operacji forward()");
//    }
//}



//--------------------------------------------------------> include()
//request.getRequestDispatcher("LoginServlet").include(request, response);
//przechodzi do serwleta: LoginServlet wykonuje tam wszystko co jest zawarte 
//w metodzie (w naszym przypadku - ze wzglêdu na to, ¿e w znaczniku form ustawiliœmy atrybut method na wartoœæ post)
//doPost() i po zrealizowaniu metody, jak gdyby nigdy nic wraca sobie do serwleta:
//AdminServlet i kontynuuje wykonywanie kolejnych instrukcji w metodzie doPost()? 
//W wypadku forward() - nie wyst¹pi ten powrót do AdminServlet?

package pl.javastart.redir.servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AdminServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("AdminServlet GET " + username );
        request.getRequestDispatcher("LoginServlet").include(request, response);
        response.getWriter().println("GET Tekst odpowiedzi po operacji include()");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("AdminServlet POST " + username );
        request.getRequestDispatcher("LoginServlet").include(request, response);
        response.getWriter().println("POST Tekst odpowiedzi po operacji include()");
    }
}