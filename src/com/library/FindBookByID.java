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


@WebServlet("/secure/FindBookByID")
public class FindBookByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("bookid");
		BookDao dao = new BookDaoImpl();
		Book book = dao.findBookByID(id);
		PrintWriter out = response.getWriter();
		if(book == null) {
			out.append("No book found with id="+id);
			out.append("<br><a href='menu.jsp'>Show Menu</a>");
		}else {
			request.setAttribute("foundbook", book);
			request.getRequestDispatcher("displaybook.jsp").forward(request, response);
		}
	}

}
