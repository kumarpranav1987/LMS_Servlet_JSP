package com.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.AuthenticationService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		AuthenticationService as = new AuthenticationService();
		boolean result = as.authenticate(name, password);
		if(result) {
			request.getSession().setAttribute("username", name);
			//request.getRequestDispatcher("secure/menu.jsp").forward(request, response);
			response.sendRedirect("secure/menu.jsp");
		}else {
			request.getRequestDispatcher("welcome.jsp").include(request, response);
			response.getWriter().append("Wrong UserName/Password");
		}
	}

}
