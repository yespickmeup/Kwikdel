/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.statement_of_accounts;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_statement_of_account_reading_payments {

    public static class to_statement_of_account_reading_payments {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String user_id;
        public final String user_name;
        public final String date_added;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double price;
        public final double previous_reading;
        public final double current_reading;
        public final String sar_id;
        public final double amount;
        public final double paid;
        public final String soa_reading_id;

        public to_statement_of_account_reading_payments(int id, String customer_id, String customer_name, String user_id, String user_name, String date_added, String item_code, String barcode, String description, double qty, double price, double previous_reading, double current_reading, String sar_id, double amount, double paid, String soa_reading_id) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.user_id = user_id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.price = price;
            this.previous_reading = previous_reading;
            this.current_reading = current_reading;
            this.sar_id = sar_id;
            this.amount = amount;
            this.paid = paid;
            this.soa_reading_id = soa_reading_id;
        }
    }

    public static void add_statement_of_account_reading_payments(to_statement_of_account_reading_payments to_statement_of_account_reading_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into statement_of_account_reading_payments("
                    + "customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",previous_reading"
                    + ",current_reading"
                    + ",sar_id"
                    + ",amount"
                    + ",paid"
                    + ",soa_reading_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:user_id"
                    + ",:user_name"
                    + ",:date_added"
                    + ",:item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:price"
                    + ",:previous_reading"
                    + ",:current_reading"
                    + ",:sar_id"
                    + ",:amount"
                    + ",:paid"
                    + ",:soa_reading_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_statement_of_account_reading_payments.customer_id)
                    .setString("customer_name", to_statement_of_account_reading_payments.customer_name)
                    .setString("user_id", to_statement_of_account_reading_payments.user_id)
                    .setString("user_name", to_statement_of_account_reading_payments.user_name)
                    .setString("date_added", to_statement_of_account_reading_payments.date_added)
                    .setString("item_code", to_statement_of_account_reading_payments.item_code)
                    .setString("barcode", to_statement_of_account_reading_payments.barcode)
                    .setString("description", to_statement_of_account_reading_payments.description)
                    .setNumber("qty", to_statement_of_account_reading_payments.qty)
                    .setNumber("price", to_statement_of_account_reading_payments.price)
                    .setNumber("previous_reading", to_statement_of_account_reading_payments.previous_reading)
                    .setNumber("current_reading", to_statement_of_account_reading_payments.current_reading)
                    .setString("sar_id", to_statement_of_account_reading_payments.sar_id)
                    .setNumber("amount", to_statement_of_account_reading_payments.amount)
                    .setNumber("paid", to_statement_of_account_reading_payments.paid)
                    .setString("soa_reading_id", to_statement_of_account_reading_payments.soa_reading_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_reading_payments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_statement_of_account_reading_payments(to_statement_of_account_reading_payments to_statement_of_account_reading_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update statement_of_account_reading_payments set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",user_id= :user_id"
                    + ",user_name= :user_name"
                    + ",date_added= :date_added"
                    + ",item_code= :item_code"
                    + ",barcode= :barcode"
                    + ",description= :description"
                    + ",qty= :qty"
                    + ",price= :price"
                    + ",previous_reading= :previous_reading"
                    + ",current_reading= :current_reading"
                    + ",sar_id= :sar_id"
                    + ",amount= :amount"
                    + ",paid= :paid"
                    + ",soa_reading_id= :soa_reading_id"
                    + " where "
                    + " id ='" + to_statement_of_account_reading_payments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_statement_of_account_reading_payments.customer_id)
                    .setString("customer_name", to_statement_of_account_reading_payments.customer_name)
                    .setString("user_id", to_statement_of_account_reading_payments.user_id)
                    .setString("user_name", to_statement_of_account_reading_payments.user_name)
                    .setString("date_added", to_statement_of_account_reading_payments.date_added)
                    .setString("item_code", to_statement_of_account_reading_payments.item_code)
                    .setString("barcode", to_statement_of_account_reading_payments.barcode)
                    .setString("description", to_statement_of_account_reading_payments.description)
                    .setNumber("qty", to_statement_of_account_reading_payments.qty)
                    .setNumber("price", to_statement_of_account_reading_payments.price)
                    .setNumber("previous_reading", to_statement_of_account_reading_payments.previous_reading)
                    .setNumber("current_reading", to_statement_of_account_reading_payments.current_reading)
                    .setString("sar_id", to_statement_of_account_reading_payments.sar_id)
                    .setNumber("amount", to_statement_of_account_reading_payments.amount)
                    .setNumber("paid", to_statement_of_account_reading_payments.paid)
                    .setString("soa_reading_id", to_statement_of_account_reading_payments.soa_reading_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_reading_payments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_statement_of_account_reading_payments(to_statement_of_account_reading_payments to_statement_of_account_reading_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from statement_of_account_reading_payments where "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_reading_payments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_statement_of_account_reading_payments> ret_data(String where) {
        List<to_statement_of_account_reading_payments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",previous_reading"
                    + ",current_reading"
                    + ",sar_id"
                    + ",amount"
                    + ",paid"
                    + ",soa_reading_id"
                    + " from statement_of_account_reading_payments  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String item_code = rs.getString(7);
                String barcode = rs.getString(8);
                String description = rs.getString(9);
                double qty = rs.getDouble(10);
                double price = rs.getDouble(11);
                double previous_reading = rs.getDouble(12);
                double current_reading = rs.getDouble(13);
                String sar_id = rs.getString(14);
                double amount = rs.getDouble(15);
                double paid = rs.getDouble(16);
                String soa_reading_id = rs.getString(17);

                to_statement_of_account_reading_payments to = new to_statement_of_account_reading_payments(id, customer_id, customer_name, user_id, user_name, date_added, item_code, barcode, description, qty, price, previous_reading, current_reading, sar_id, amount, paid, soa_reading_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_soa_reading(String soa_reading_id, double amount) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update statement_of_account_readings set "
                    + "paid= :paid"
                    + " where "
                    + " id ='" + soa_reading_id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("paid", amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_readings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
