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
import com.livetechstudy.library.model.Book;

@WebServlet("/secure/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		String id = request.getParameter("bookId");
		String title = request.getParameter("bookTitle");
		String author = request.getParameter("author");
		Book book = new Book(id, title, author);
		BookDao dao = new BookDaoImpl();
		int result = dao.insertBook(book);
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.append("Book Not Added");
			out.append("<a href='secure/menu.jsp'>Show Menu</a>");
		}else {
			out.append("Book Added Successfully");
			out.append("<a href='secure/menu.jsp'>Show Menu</a>");
		}
		
	}

}
