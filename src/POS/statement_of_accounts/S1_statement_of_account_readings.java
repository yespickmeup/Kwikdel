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
 * @author Ronald
 */
public class S1_statement_of_account_readings {

    public static class to_statement_of_account_readings {

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

        public to_statement_of_account_readings(int id, String customer_id, String customer_name, String user_id, String user_name, String date_added, String item_code, String barcode, String description, double qty, double price, double previous_reading, double current_reading, String sar_id, double amount, double paid) {
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
        }
    }

    public static void add_statement_of_account_readings(to_statement_of_account_readings to_statement_of_account_readings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into statement_of_account_readings("
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
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_statement_of_account_readings.customer_id)
                    .setString("customer_name", to_statement_of_account_readings.customer_name)
                    .setString("user_id", to_statement_of_account_readings.user_id)
                    .setString("user_name", to_statement_of_account_readings.user_name)
                    .setString("date_added", to_statement_of_account_readings.date_added)
                    .setString("item_code", to_statement_of_account_readings.item_code)
                    .setString("barcode", to_statement_of_account_readings.barcode)
                    .setString("description", to_statement_of_account_readings.description)
                    .setNumber("qty", to_statement_of_account_readings.qty)
                    .setNumber("price", to_statement_of_account_readings.price)
                    .setNumber("previous_reading", to_statement_of_account_readings.previous_reading)
                    .setNumber("current_reading", to_statement_of_account_readings.current_reading)
                    .setString("sar_id", to_statement_of_account_readings.sar_id)
                    .setNumber("amount", to_statement_of_account_readings.amount)
                    .setNumber("paid", to_statement_of_account_readings.paid)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_readings.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_statement_of_account_readings(to_statement_of_account_readings to_statement_of_account_readings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update statement_of_account_readings set "
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
                    + " where "
                    + " id ='" + to_statement_of_account_readings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_statement_of_account_readings.customer_id)
                    .setString("customer_name", to_statement_of_account_readings.customer_name)
                    .setString("user_id", to_statement_of_account_readings.user_id)
                    .setString("user_name", to_statement_of_account_readings.user_name)
                    .setString("date_added", to_statement_of_account_readings.date_added)
                    .setString("item_code", to_statement_of_account_readings.item_code)
                    .setString("barcode", to_statement_of_account_readings.barcode)
                    .setString("description", to_statement_of_account_readings.description)
                    .setNumber("qty", to_statement_of_account_readings.qty)
                    .setNumber("price", to_statement_of_account_readings.price)
                    .setNumber("previous_reading", to_statement_of_account_readings.previous_reading)
                    .setNumber("current_reading", to_statement_of_account_readings.current_reading)
                    .setString("sar_id", to_statement_of_account_readings.sar_id)
                    .setNumber("amount", to_statement_of_account_readings.amount)
                    .setNumber("paid", to_statement_of_account_readings.paid)
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

    public static void delete_statement_of_account_readings(to_statement_of_account_readings to_statement_of_account_readings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from statement_of_account_readings where "
                    + " id ='" + to_statement_of_account_readings.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_readings.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_statement_of_account_readings> ret_data(String where) {
        List<to_statement_of_account_readings> datas = new ArrayList();

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
                    + " from statement_of_account_readings  "
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
                to_statement_of_account_readings to = new to_statement_of_account_readings(id, customer_id, customer_name, user_id, user_name
                        , date_added, item_code, barcode, description, qty, price, previous_reading, current_reading, sar_id,amount,paid);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
