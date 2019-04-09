package com.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livetechstudy.library.dao.BookDao;
import com.livetechstudy.library.dao.BookDaoImpl;
import com.livetechstudy.library.model.Book;


@WebServlet("/secure/FindBooksByTitle")
public class FindBooksByTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String title = request.getParameter("booktitle");
		BookDao dao = new BookDaoImpl();
		List<Book> books = dao.findBooksByTitle(title);
		PrintWriter out = response.getWriter();
		if (books.size() == 0) {
			out.append("No Book found with Title = "+title);
			out.append("<br><a href='menu.jsp'>Show Menu</a>");
		} else {
			request.setAttribute("allbooks", books);
			request.getRequestDispatcher("showallbooks.jsp").forward(request, response);
		}
	}
}
