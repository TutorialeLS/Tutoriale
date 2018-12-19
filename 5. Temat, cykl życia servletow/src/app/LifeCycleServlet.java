package app;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifecycleServlet")
public class LifeCycleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LifeCycleServlet() {
        super();
        System.out.println("Konstruktor TestServlet()");
    }

    @Override
    public void init(ServletConfig config) {
        System.out.println("metoda init()");
    }

    @Override
    public void destroy() {
        System.out.println("metoda destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) {
        System.out.println("Metoda doGet()");
    }

}