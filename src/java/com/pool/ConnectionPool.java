package com.pool;

import java.sql.*;
import java.util.*;

public class ConnectionPool {

    static final int MAX_CONNECTIONS = 18;
    static Vector connections = null;
    static ConnectionPool instance = null;

    public synchronized void removeAllConnections() {
        try {
            if (connections == null) {
                return;
            }
            int sz = connections.size();
            for (int i = 0; i < sz; i++) {
                Connection c = (Connection) connections.elementAt(i);
                c.close();
            }
            connections.removeAllElements();
            connections = null;
        } catch (SQLException sqlE) {
            System.out.println(sqlE);
        }

    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized void initialize() {
        if (connections == null) {
            try {
                String dbUrl = System.getenv("JDBC_DATABASE_URL");
                //  String userName="postgres";
                //  String password="root";
                Class.forName("org.postgresql.Driver");
                connections = new Vector();
                int count = 0;
                while (count < MAX_CONNECTIONS) {
                    Connection c = DriverManager.getConnection(dbUrl);
                    // Connection c =  DriverManager.getConnection(dbUrl, userName, password);
                    connections.addElement(c);
                    count++;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public synchronized Connection getConnection() {
        Connection c = null;
        if (connections == null) {
            return null;
        }
        if (connections.size() > 0) {
            c = (Connection) connections.elementAt(0);
            connections.removeElementAt(0);
        }
        return c;
    }

    public synchronized void putConnection(Connection c) {
        connections.addElement(c);
        notifyAll();
    }
}
