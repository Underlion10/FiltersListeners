package com.filterlisteners.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    /**
     * 
     */
    public Listener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
    	Connection conn = (Connection) se.getSession().getServletContext().getAttribute("dbConn");
    	String username = (String) se.getSession().getAttribute("nombre");
    	Statement stm;
		try {
			stm = conn.createStatement();
			stm.executeUpdate("update users set actual_session = ''" + " where nombre = '" + username + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	try {
			Connection conn = (Connection) sce.getServletContext().getAttribute("dbConn");
			conn.close();
			sce.getServletContext().removeAttribute("dbConn");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/filters?useLegacyDatetimeCode=" + "false&serverTimezone=GMT", "root", "");
			sce.getServletContext().setAttribute("dbConn", conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
