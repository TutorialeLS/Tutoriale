package pl.javastart.controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/calc")
public class CalcController extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double result = a + b;
        request.setAttribute("a", a);
        request.setAttribute("b", b);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").include(request, response);
        System.out.println("Koniec zadania");
    }
}