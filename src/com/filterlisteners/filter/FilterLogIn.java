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
 * Servlet Filter implementation class FilterLogIn
 */
@WebFilter("/FilterLogIn")
public class FilterLogIn implements Filter {

    /**
     * Default constructor. 
     */
    public FilterLogIn() {
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
		String nombre = (String) request.getAttribute("nombre");
		Connection conn = (Connection) request.getServletContext().getAttribute("dbConn");
		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from users where nombre = '" + nombre + "'");
			while(rs.next()) {
				if(rs.getString(2).equals(request.getAttribute("nombre"))) {
					request.setAttribute("incorrect", true);
				}
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
		// TODO Auto-generated method stub
	}

}
