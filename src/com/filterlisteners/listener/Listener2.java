package com.filterlisteners.listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class Listener2
 *
 */
@WebListener
public class Listener2 implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public Listener2() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {
    	Connection conn = (Connection) se.getSession().getServletContext().getAttribute("dbConn");
    	String username = (String) se.getSession().getAttribute("nombre");
    	Statement stm;
		try {
			stm = conn.createStatement();
			stm.executeUpdate("update users set actual_session = '" + 
			se.getSession().getId() + "' where nombre = '" + username + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    }
	
}
