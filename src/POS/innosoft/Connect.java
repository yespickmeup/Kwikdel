/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.innosoft;

import POS.suppliers.S1_suppliers;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Connect {

    //sql server config manager -> tcp/ip-> "yes" & change ports to 1433;
    //sqljdbc_auth.dll - in system32
    public static void main2(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=pos13;integratedSecurity=true;");
//              Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=pos13");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT ItemCode FROM dbo.MstItem name ");
            while (rs.next()) {
                String itemCode = rs.getString(1);
                System.out.println("Item Code:" + itemCode);
            }

            String s2 = "insert into dbo.TrnSalesDraft("
                    + "DocRef"
                    + ",DocDate"
                    + ",ItemCode"
                    + ",ItemId"
                    + ",Price"
                    + ",Quantity"
                    + ",Amount"
                    + ",CustomerCode"
                    + ",Customer"
                    + ",ContactPerson"
                    + ",Address"
                    + ",PhoneNumber"
                    + ",MobilePhoneNumber"
                    + ")values("
                    + ":DocRef"
                    + ",:DocDate"
                    + ",:ItemCode"
                    + ",:ItemId"
                    + ",:Price"
                    + ",:Quantity"
                    + ",:Amount"
                    + ",:CustomerCode"
                    + ",:Customer"
                    + ",:ContactPerson"
                    + ",:Address"
                    + ",:PhoneNumber"
                    + ",:MobilePhoneNumber"
                    + ")";

            s2 = SqlStringUtil.parse(s2).
                    setString("DocRef", "00002").
                    setString("DocDate", "2016-01-01 00:00:00").
                    setString("ItemCode", "1").
                    setString("ItemId", "1").
                    setString("Price", "1").
                    setString("Quantity", "1").
                    setString("Amount", "1").
                    setString("CustomerCode", "1").
                    setString("Customer", "1").
                    setString("ContactPerson", "1").
                    setString("Address", "1").
                    setString("PhoneNumber", "1").
                    setString("MobilePhoneNumber", "1").
                    ok();
            System.out.println(s2);
            PreparedStatement stmt = connection.prepareStatement(s2);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Added");
        } catch (ClassNotFoundException e) {
            System.out.println("DB error : " + e);
        } catch (SQLException e) {
            System.out.println("DB error : " + e);
        }

    }

    public static void main3(String[] args) {
        Connection conn = null;

        try {

            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
            String user = "sa";
            String pass = "innosoft";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        double cost = 8;
        double selling_price = 18;
        double difference = selling_price - 8;
        double markup = difference / cost;
        markup = markup * 100;
        System.out.println(markup);
    }
}
