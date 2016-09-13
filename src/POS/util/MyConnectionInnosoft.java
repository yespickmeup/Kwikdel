/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

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

        String host = System.getProperty("pool_host_innosoft", "localhost:1433");
        String user = System.getProperty("pool_user_innosoft", "synsoft");
        String password = System.getProperty("pool_password_innosoft", "synapse246");
        String mydb = System.getProperty("mydb_innosoft", "pos13");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnectionInnosoft.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://" + host + "/" + mydb;
        String connectionString = "jdbc:sqlserver://" + host
                + ";databaseName=" + mydb + ";user=" + user
                + ";password=" + password
                + ";integratedSecurity=true;";
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
            String user = System.getProperty("pool_user_innosoft", "synsoft");
            String password = System.getProperty("pool_password_innosoft", "synapse246");
            String mydb = System.getProperty("mydb_innosoft", "pos13");
            String connectionString = "jdbc:sqlserver://" + host
                    + ";databaseName=" + mydb + ""
                    + ";user=" + user
                    + ";password=" + password
                    + ";integratedSecurity=true;";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyConnectionInnosoft.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(connectionString);

            Connection conn1 = DriverManager.getConnection(connectionString);
            Statement st = conn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM dbo.MstUser ");
            if (rs.next()) {
                connected = 1;
            }
            return connected;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public static void main2(String[] args) {
        try {
            Connection conn2 = MyConnectionInnosoft.connect();
            String StockInDate = DateType.sf.format(new Date()) + " 00:00:00.000";
            String LastStockInNumber = MyConnectionInnosoft.getLastStockInNumber();
            LastStockInNumber = ReceiptIncrementor.increment(LastStockInNumber);
            System.out.println("Transaction Number: " + LastStockInNumber);

            String s6 = " insert into dbo.TrnStockInLine ("
                    + " StockInId"
                    + ",ItemId"
                    + ",UnitId"
                    + ",Quantity"
                    + ",Cost"
                    + ",Amount"
                    + ",ExpiryDate"
                    + ",LotNumber"
                    + ",AssetAccountId"
                    + ")values("
                    + " :StockInId"
                    + ",:ItemId"
                    + ",:UnitId"
                    + ",:Quantity"
                    + ",:Cost"
                    + ",:Amount"
                    + ",:ExpiryDate"
                    + ",:LotNumber"
                    + ",:AssetAccountId"
                    + ")";

            s6 = SqlStringUtil.parse(s6).
                    setString("StockInId", "2127").
                    setString("ItemId", "33700").
                    setString("UnitId", "1").
                    setString("Quantity", "10.00000").
                    setString("Cost", "10.00000").
                    setString("Amount", "10.00000").
                    setString("ExpiryDate", null).
                    setString("LotNumber", null).
                    setString("AssetAccountId", "1").
                    ok();
            PreparedStatement stmt6 = conn2.prepareStatement(s6);
            stmt6.execute();
            System.out.println(s6);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getLastStockInNumber() {
        String LastStockInNumber = "0001-0000000";
        try {
            String host = System.getProperty("pool_host_innosoft", "localhost:1433");
            String user = System.getProperty("pool_user_innosoft", "synsoft");
            String password = System.getProperty("pool_password_innosoft", "synapse246");
            String mydb = System.getProperty("mydb_innosoft", "pos13");

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyConnectionInnosoft.class.getName()).log(Level.SEVERE, null, ex);
            }

            String url = "jdbc:mysql://" + host + "/" + mydb;
            String connectionString = "jdbc:sqlserver://" + host
                    + ";databaseName=" + mydb + ";user=" + user
                    + ";password=" + password
                    + ";integratedSecurity=true;";

            Connection conn1 = DriverManager.getConnection(connectionString);
            Statement st = conn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT StockInNumber FROM dbo.TrnStockIn order by Id desc  ");
            if (rs.next()) {
                LastStockInNumber = rs.getString("StockInNumber");
            }

            return LastStockInNumber;
        } catch (SQLException e) {
            throw new RuntimeException(e);
//            return "0001-000000";
        }
    }

    public static String getLastStockInId() {
        String LastStockInNumber = "";
        try {
            String host = System.getProperty("pool_host_innosoft", "localhost:1433");
            String user = System.getProperty("pool_user_innosoft", "synsoft");
            String password = System.getProperty("pool_password_innosoft", "synapse246");
            String mydb = System.getProperty("mydb_innosoft", "pos13");
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyConnectionInnosoft.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://" + host + "/" + mydb;
            String connectionString = "jdbc:sqlserver://" + host
                    + ";databaseName=" + mydb + ";user=" + user
                    + ";password=" + password
                    + ";integratedSecurity=true;";
            Connection conn1 = DriverManager.getConnection(connectionString);
            Statement st = conn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT Id FROM dbo.TrnStockIn order by Id desc  ");
            if (rs.next()) {
                LastStockInNumber = rs.getString("Id");
            }

            return LastStockInNumber;
        } catch (SQLException e) {
            throw new RuntimeException(e);
//            return "0001-000000";
        }
    }

}
