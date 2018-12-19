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
        HttpSession session = request.getSession(true);//utworzenie obiektu session poprzez wywolanie metody .getSession z parametrem true
        session.setMaxInactiveInterval(10); //ustawienie czasu przechowywania ciasteczka JSESSIONID w sekundach 
        User user = (User) session.getAttribute("user"); //pobranie z sesji atrybutu o kluczu "user", session.getAttribute(String) zwraca Object, konieczne rzutowanie
        if(user == null || (user.getFirstName() == null || user.getLastName() == null)) { // jezeli nie ma usera lub user nie ma ktoregos z parametrow
            user = createUser(request);													//wywolanie metod createUser do utworzenia usera
            session.setAttribute("user", user);											//ustawienie sesji wg klucza "user", dla obiektu user
        }
         
        sendResponse(response, user);
    }
     
    private User createUser(HttpServletRequest request) {
        User user = new User();//utworzenie usera
        String firstName = request.getParameter("firstname");//pobranie imienia
        String lastName = request.getParameter("lastname");//pobarnie nazwiska
        user.setFirstName(firstName);//ustawienie imienia
        user.setLastName(lastName);//ustawienie nazwiska
        return user;//zwrocenie usera
    }
     
    private void sendResponse(HttpServletResponse response, User user) 
            throws IOException {
        PrintWriter writer = response.getWriter();//utworzenie obiektu ktory bedzie drukowal elementy na stronie
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