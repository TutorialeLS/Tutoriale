package pl.javastart.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.BookDao;
import pl.javastart.dao.DaoFactory;
import pl.javastart.model.Book;
import pl.javastart.util.DbOperationException;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     request.setCharacterEncoding("UTF-8");
	        String isbn = request.getParameter("isbn");
	        String title = request.getParameter("title");
	        String description = request.getParameter("description");
	        String option = request.getParameter("option");
	        try {
	        	DaoFactory factory=DaoFactory.getDaoFactory(DaoFactory.MYSQL_DAO);
	        	BookDao bookDao=factory.getBookDao();
	        	String message="";
	        	Book book=null;
	        	if("create".equals(option)) {
	        		book=new Book(isbn,title,description);
	        		bookDao.create(book);
	        		message="create";
	        	}else if("read".equals(option)) {
	        		book=bookDao.read(isbn);
	        		message="read";
	        	}else if("update".equals(option)) {
	        		book=new Book(isbn,title,description);
	        		bookDao.update(book);
	        		message="update";
	        	}else if ("delete".equals(option)){
	        		book=new Book(isbn,title,description);
	        		bookDao.delete(book);
	        		message="delete";
	        	}
	        	request.setAttribute("book", book);
	        	request.setAttribute("message", message);
	        	request.getRequestDispatcher("result.jsp").forward(request, response);
	        } catch (DbOperationException e) {
	            e.printStackTrace();
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	}

}
