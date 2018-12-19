package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
         
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
         
        PrintWriter writer = response.getWriter();
         
        writer.println("<html>");
        for (String key : parameterMap.keySet()) {
            writer.println("<div>");
            writer.println(key);
            writer.println("</div>");
            for (String value : parameterMap.get(key)) {
                writer.println("<div>");
                writer.println("&nbsp&nbsp-" + value);
                writer.println("</div>");
            }
        }
        writer.println("</html>");
    }
 
}