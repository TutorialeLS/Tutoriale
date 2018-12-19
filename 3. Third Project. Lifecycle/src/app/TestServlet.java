package app;
 
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public TestServlet() {//konstruktor wywolany tylko przy uruchomieniu, przed wywolaniem brak dostepu do kontekstu aplikacji
        super();
        System.out.println("Konstruktor TestServlet()");
    }
 
    public void init(ServletConfig config) throws ServletException {//init wywolany tylko przy uruchomieniu, mozliwy dostep poprzez obiekt ServletConfig
        System.out.println("metoda init()");
    }
 
    public void destroy() {//wywolywana przy usunieciu aplikacji lub ponownym wdrozeniu
        System.out.println("metoda destroy()");
    }
 
    protected void doGet(HttpServletRequest request,//wywolywana przy kazdym odswiezeniu
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Metoda doGet()");
    }
 
}