package pl.javastart.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.beans.User;
/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    User user = createUserFromRequest(request);
        sendResponse(user, response);
	}


	private void sendResponse(User user, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.print("<h2>Dane odebrano pomyœlnie</h2>");
		writer.print("<div>");
		writer.println(user.getFirstName() + "<br>");
		writer.println("<%!String gender;%>");
		writer.println("<%if(user.getFirstName().charAt(user.getFirstName().length()-1)=='a')%>");
		writer.println("<%gender=kobieta;%>");
		writer.println("<%else%>");
		writer.println("<%gender=mezczyzna;%>");
		writer.println("Plec to "+"<%=gender%>"+"<br>");
		
		writer.println(user.getLastName() + "<br>");
		writer.println(user.getAge() + "<br>");
		writer.print("</div>");
		writer.println("</body>");
		writer.println("</html>");
		
	}


	private User createUserFromRequest(HttpServletRequest request) {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String age=request.getParameter("age");		
		User user=new User(firstName, lastName, age);
		
		return user;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    User user = createUserFromRequest(request);
        sendResponse(user, response);
	}

}
