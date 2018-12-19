package pl.javastart.sessions.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.javastart.sessions.bean.User;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);//tworzy sesje w przypadku true lub bez parametru
		//session.setMaxInactiveInterval(10);//timeout sesji w sekundach
		User user=(User)session.getAttribute("user");//pobiera atrybut sesji o kluczu "user"
		if(user==null||(user.getFirstName()==null||user.getLastName()==null)) {//jezeli ktorys z parametrow atrybutu jest pusty tworzy go
			user=createUser(request);
			session.setAttribute("user",user);//tworzy atrybut user o nazwie user
		}
		sendResponse(response,user);
		
		
	}
	private User createUser(HttpServletRequest request) {
		User user=new User();
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		user.setFirstName(firstName);//parametr firstname podany w URL zostaje podany obiektowi
		user.setLastName(lastName);
		return user;
	}
	private void sendResponse(HttpServletResponse response, User user) throws IOException{
		PrintWriter writer=response.getWriter();//tworzy obiekt writer dla obiektu response
		writer.println("<html>");
		writer.println("  <body>");
		writer.println("<h1>Test Sesji</h1>");
		if(user.getFirstName() != null && user.getLastName() != null)
			writer.println("<div>Witaj " + user.getFirstName() + " " + user.getLastName() + "</div>");
		else
			writer.println("<div>Witaj nieznajomy</div>");
		writer.println("  </body>");
		writer.println("</html>");
	
	}
}