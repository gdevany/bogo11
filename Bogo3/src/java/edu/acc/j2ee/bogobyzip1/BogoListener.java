package edu.acc.j2ee.bogobyzip1;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BogoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String dbProtocol = sc.getInitParameter("db.protocol");
        String dbHost = sc.getInitParameter("db.host");
        String dbPort = sc.getInitParameter("db.port");
        String dbName = sc.getInitParameter("db.name");
        String dbUser = sc.getInitParameter("db.user");
        String dbPass = sc.getInitParameter("db.pass");
        String jdbcUrl = String.format(
            "%s://%s:/%s;user=%s;password=%s",
                dbProtocol, dbHost, dbPort, dbName, dbUser, dbPass
        );
        BogoDAO db = new BogoDAO(jdbcUrl);
        sc.setAttribute("db", db);
        sc.setAttribute("version", sc.getInitParameter("version"));
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        BogoDAO db = (BogoDAO)sce.getServletContext().getAttribute("db");
        db.close();
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
