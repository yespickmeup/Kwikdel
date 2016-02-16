/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1
 */
public class MyConnectionInnosoft {

    private MyConnectionInnosoft() {
    }
    private static MyConnectionInnosoft connection;

    private static void init() {
        if (connection == null) {
            connection = new MyConnectionInnosoft();
        }
    }

    private static Connection conn;

    public static Connection connect() {
        try {
            //        init();
            String host = System.getProperty("pool_host_innosoft", "localhost:1433");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String mydb = System.getProperty("mydb_innosoft", "pos13");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:mysql://" + host + "/" + mydb;

            try {
                conn = DriverManager.getConnection("jdbc:sqlserver://" + host + ";databaseName=" + mydb + ";integratedSecurity=true;");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnectionInnosoft.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnectionInnosoft.class.getName()).
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

    public static void main(String[] args) throws SQLException {
        int connected = check_connection();
        System.out.println("Connected: " + connected);
    }

    public static int check_connection() {
        int connected = 0;
        try {
            String host = System.getProperty("pool_host_innosoft", "localhost:1433");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String mydb = System.getProperty("mydb_innosoft", "pos13");
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyConnectionInnosoft.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://" + host + "/" + mydb;

            Connection conn1 = DriverManager.getConnection("jdbc:sqlserver://" + host + ";databaseName=" + mydb + ";integratedSecurity=true;");
            Statement st = conn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM dbo.MstUser ");
            if (rs.next()) {
                connected = 1;
            }
            return connected;
        } catch (SQLException e) {
            return 0;
        }

    }
}
