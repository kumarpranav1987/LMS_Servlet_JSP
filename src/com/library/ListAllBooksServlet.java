package com.library;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livetechstudy.library.dao.BookDao;
import com.livetechstudy.library.dao.BookDaoImpl;
import com.livetechstudy.library.model.Book;

@WebServlet("/secure/ListAllBooksServlet")
public class ListAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDaoImpl();
		List<Book> books = dao.getAllBooks();
		request.setAttribute("allbooks", books);
		request.getRequestDispatcher("showallbooks.jsp").forward(request, response);
	}
}
