package pl.javastart.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String option = request.getParameter("option");
		try {
			BookDao bookDao = new BookDao();
			Book book = null;
			String operation = null;
			if ("create".equals(option)) {
				book = new Book(isbn, title, description);
				bookDao.create(book);
				operation = "create";
			}
			if ("read".equals(option)) {
				book = new Book(isbn, title, description);
				bookDao.read(book.getIsbn());
				operation = "read";
			}
			if ("update".equals(option)) {
				book = new Book(isbn, title, description);
				bookDao.update(book);
				operation = "update";
			}
			if ("delete".equals(option)) {
				book = new Book(isbn, title, description);
				bookDao.delete(book);
				operation = "delete";
			}
			request.setAttribute("book", book);
			request.setAttribute("option", operation);
			request.getRequestDispatcher("result.jsp").forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
