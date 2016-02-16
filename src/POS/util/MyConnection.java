/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1
 */
public class MyConnection {

    private MyConnection() {
    }
    private static MyConnection connection;

    private static void init() {
        if (connection == null) {
            connection = new MyConnection();
        }
    }
    
    private static Connection conn;

    public static Connection connect() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String mydb = System.getProperty("mydb", "db_kwekdel");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + mydb;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection connect2() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String mydb = System.getProperty("mydb", "overall_pos_receivable_db");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + mydb;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static Connection connect_bir() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String mydb = "db_bir";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + mydb;

            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        connect();
    }
}
