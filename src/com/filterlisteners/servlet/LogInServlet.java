package com.filterlisteners.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("jsp/registered.jsp");
		
		if (request.getAttribute("incorrect") == null) {
			String nombre = (String) request.getParameter("nombre");
			String password = (String) request.getParameter("password");
			Connection conn = (Connection) request.getServletContext().getAttribute("dbConn");
			Statement stm;
			try {
				stm = conn.createStatement();
				stm.executeUpdate("insert into users (nombre, password, actual_session) values "
						+ "('" + nombre + "', '" + password + "', '')");
				request.getSession().setAttribute("nombre", nombre);
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
