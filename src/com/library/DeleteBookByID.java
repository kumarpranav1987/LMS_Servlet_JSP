package com.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livetechstudy.library.dao.BookDao;
import com.livetechstudy.library.dao.BookDaoImpl;

@WebServlet("/secure/DeleteBookByID")
public class DeleteBookByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String bookId = request.getParameter("bookid");
		BookDao dao = new BookDaoImpl();
		int result = dao.deleteBook(bookId);
		PrintWriter out = response.getWriter();
		if (result == 0) {
			out.append("Book With ID=" + bookId + " not deleted");
		} else {
			out.append("Book With ID=" + bookId + " deleted successfully");
		}
		out.append("<br><a href='menu.jsp'>Show Menu</a>");
	}

}
