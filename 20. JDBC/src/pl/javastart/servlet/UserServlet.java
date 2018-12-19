package pl.javastart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.DAOFactory;
import pl.javastart.dao.UserDAO;
import pl.javastart.model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pesel = request.getParameter("pesel");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String option = request.getParameter("option");
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO);
		UserDAO dao = factory.getUserDAO();
		User user = null;
		String operation = null;
		boolean result = false;
		if("search".equals(option)) {
			user = dao.read(pesel);
			result = user!=null? true:false;
			operation = "search";
		} else if("add".equals(option)) {
			user = new User(pesel, firstname, lastname);
			result = dao.create(user);
			operation = "add";
		} else if("update".equals(option)) {
			user = new User(pesel, firstname, lastname);
			result = dao.update(user);
			operation = "update";
		} else if("delete".equals(option)) {
			user = new User(pesel, firstname, lastname);
			result = dao.delete(user);
			operation = "delete";
		}
		if(user != null && result) {
			request.setAttribute("option", operation);
			request.setAttribute("user", user);
			request.getRequestDispatcher("result2.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}