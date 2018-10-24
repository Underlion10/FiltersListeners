package com.filterlisteners.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter("/logIn")
public class FilterLog implements Filter {

    /**
     * Default constructor. 
     */
    public FilterLog() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String nombre = (String) request.getParameter("nombre");
		System.out.println(nombre + ", verificando a través del filtro");
		Connection conn = (Connection) request.getServletContext().getAttribute("dbConn");
		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from users where nombre = '" + nombre + "'");
			if(rs.next()) {
				request.setAttribute("incorrect", true);
				request.setAttribute("type", 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
