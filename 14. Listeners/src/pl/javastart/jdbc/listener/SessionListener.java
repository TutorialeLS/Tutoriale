package pl.javastart.jdbc.listener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed");
    }
}