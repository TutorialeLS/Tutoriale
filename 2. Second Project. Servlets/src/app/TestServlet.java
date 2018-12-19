package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/TestServlet") // dowolony url, 
							//adnotacja dodana z mapowanie w pliku web.xml -> tu musi byc usunieta zeby uniknac precedensu
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("¯¹danie GET przetworzono pomyœlnie");

	}

}
