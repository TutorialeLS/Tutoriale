package pl.javastart.datasource.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.jdbc.util.DbUtil;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("city");
        String country = request.getParameter("country");
        String district = request.getParameter("district");
        String populationString = request.getParameter("population");
        int population = 0;
        if (populationString != null && !populationString.isEmpty()) {
            population = Integer.parseInt(populationString);
        }

        String option = request.getParameter("option");
        String message = null;
        if ("add".equals(option)) {
            try {
                DbUtil.insert(name, country, district, population);
                message = "Do bazy dodano miasto " + name;
            } catch (SQLException e) {
                message = "Nie uda³o siê dodaæ miasta " + name;
                e.printStackTrace();
            }
            
        } else if ("delete".equals(option)) {
            try {
                DbUtil.delete(name);
                message = "Z bazy usuniêto miasto " + name;
            } catch (SQLException e) {
                e.printStackTrace();
                message = "Nie uda³o siê usun¹æ miasta " + name;
            }
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("message.jsp").forward(request, response);
    }

}