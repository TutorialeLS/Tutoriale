package pl.javastart.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false)!=null) {//sprawdza czy sesja istnieje, parametr false zapobiega utworzenia nowej
			System.out.println("Logout");
			request.getSession().invalidate();//usuwa sesjê
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("Nie odnaleziono sesji");
		}
		
	}



}
