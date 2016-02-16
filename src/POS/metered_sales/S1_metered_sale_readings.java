/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

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
public class S1_metered_sale_readings {

    public static class to_metered_sale_readings {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String user_id;
        public final String user_name;
        public final String date_added;
        public final String description;
        public final double qty;
        public final double price;
        public final double balance;
        public final double paid;
        public final int status;
        public final String remarks;
        public final String metered_sale_id;
        public final String department;
        public final String period_from;
        public final String period_to;

        public to_metered_sale_readings(int id, String customer_id, String customer_name, String user_id, String user_name, String date_added, String description, double qty, double price, double balance, double paid, int status, String remarks, String metered_sale_id, String department, String period_from, String period_to) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.user_id = user_id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.description = description;
            this.qty = qty;
            this.price = price;
            this.balance = balance;
            this.paid = paid;
            this.status = status;
            this.remarks = remarks;
            this.metered_sale_id = metered_sale_id;
            this.department = department;
            this.period_from = period_from;
            this.period_to = period_to;
        }
    }

    public static void add_metered_sale_readings(to_metered_sale_readings to_metered_sale_readings, String meter_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into metered_sale_readings("
                    + "customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",balance"
                    + ",paid"
                    + ",status"
                    + ",remarks"
                    + ",metered_sale_id"
                    + ",department"
                    + ",period_from"
                    + ",period_to"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:user_id"
                    + ",:user_name"
                    + ",:date_added"
                    + ",:description"
                    + ",:qty"
                    + ",:price"
                    + ",:balance"
                    + ",:paid"
                    + ",:status"
                    + ",:remarks"
                    + ",:metered_sale_id"
                    + ",:department"
                    + ",:period_from"
                    + ",:period_to"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_metered_sale_readings.customer_id)
                    .setString("customer_name", to_metered_sale_readings.customer_name)
                    .setString("user_id", to_metered_sale_readings.user_id)
                    .setString("user_name", to_metered_sale_readings.user_name)
                    .setString("date_added", to_metered_sale_readings.date_added)
                    .setString("description", to_metered_sale_readings.description)
                    .setNumber("qty", to_metered_sale_readings.qty)
                    .setNumber("price", to_metered_sale_readings.price)
                    .setNumber("balance", to_metered_sale_readings.balance)
                    .setNumber("paid", to_metered_sale_readings.paid)
                    .setNumber("status", to_metered_sale_readings.status)
                    .setString("remarks", to_metered_sale_readings.remarks)
                    .setString("metered_sale_id", meter_id)
                    .setString("department", to_metered_sale_readings.department)
                    .setString("period_from", to_metered_sale_readings.period_from)
                    .setString("period_to", to_metered_sale_readings.period_to)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sale_readings.class, "Successfully Added");

            String where = " where id='" + meter_id + "' ";
            S1_metered_sales.to_metered_sales meter = S1_metered_sales.ret_balance(where);

            double new_balance = (meter.balance) - to_metered_sale_readings.qty;

            String s2 = "update metered_sales set "
                    + " balance= :balance"
                    + " where "
                    + " id ='" + meter_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setNumber("balance", new_balance)
                    .ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_metered_sale_readings.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_metered_sale_readings(to_metered_sale_readings to_metered_sale_readings, String meter_id, double previous_qty) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update metered_sale_readings set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",user_id= :user_id"
                    + ",user_name= :user_name"
                    + ",date_added= :date_added"
                    + ",description= :description"
                    + ",qty= :qty"
                    + ",price= :price"
                    + ",balance= :balance"
                    + ",paid= :paid"
                    + ",status= :status"
                    + ",remarks= :remarks"
                    + ",metered_sale_id= :metered_sale_id"
                    + ",department= :department"
                    + ",period_from= :period_from"
                    + ",period_to= :period_to"
                    + " where "
                    + " id ='" + to_metered_sale_readings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_metered_sale_readings.customer_id)
                    .setString("customer_name", to_metered_sale_readings.customer_name)
                    .setString("user_id", to_metered_sale_readings.user_id)
                    .setString("user_name", to_metered_sale_readings.user_name)
                    .setString("date_added", to_metered_sale_readings.date_added)
                    .setString("description", to_metered_sale_readings.description)
                    .setNumber("qty", to_metered_sale_readings.qty)
                    .setNumber("price", to_metered_sale_readings.price)
                    .setNumber("balance", to_metered_sale_readings.balance)
                    .setNumber("paid", to_metered_sale_readings.paid)
                    .setNumber("status", to_metered_sale_readings.status)
                    .setString("remarks", to_metered_sale_readings.remarks)
                    .setString("metered_sale_id", to_metered_sale_readings.metered_sale_id)
                    .setString("department", to_metered_sale_readings.department)
                    .setString("period_from", to_metered_sale_readings.period_from)
                    .setString("period_to", to_metered_sale_readings.period_to)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sale_readings.class, "Successfully Updated");

            String where = " where id='" + meter_id + "' ";
            S1_metered_sales.to_metered_sales meter = S1_metered_sales.ret_balance(where);

            double new_balance = (meter.balance + previous_qty) - to_metered_sale_readings.qty;

            String s2 = "update metered_sales set "
                    + " balance= :balance"
                    + " where "
                    + " id ='" + meter_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setNumber("balance", new_balance)
                    .ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_metered_sale_readings.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_metered_sale_readings(to_metered_sale_readings to_metered_sale_readings, String meter_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from metered_sale_readings where "
                    + " id ='" + to_metered_sale_readings.id + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sale_readings.class, "Successfully Deleted");

            String where = " where id='" + meter_id + "' ";
            S1_metered_sales.to_metered_sales meter = S1_metered_sales.ret_balance(where);

            double new_balance = meter.balance + to_metered_sale_readings.qty;

            String s2 = "update metered_sales set "
                    + " balance= :balance"
                    + " where "
                    + " id ='" + meter_id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setNumber("balance", new_balance)
                    .ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_metered_sale_readings.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_metered_sale_readings> ret_data(String where) {
        List<to_metered_sale_readings> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",balance"
                    + ",paid"
                    + ",status"
                    + ",remarks"
                    + ",metered_sale_id"
                    + ",department"
                    + ",period_from"
                    + ",period_to"
                    + " from metered_sale_readings "
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
                String description = rs.getString(7);
                double qty = rs.getDouble(8);
                double price = rs.getDouble(9);
                double balance = rs.getDouble(10);
                double paid = rs.getDouble(11);
                int status = rs.getInt(12);
                String remarks = rs.getString(13);
                String metered_sale_id = rs.getString(14);
                String department = rs.getString(15);
                String period_from = rs.getString(16);
                String period_to = rs.getString(17);

                to_metered_sale_readings to = new to_metered_sale_readings(id, customer_id, customer_name, user_id
                        , user_name, date_added, description, qty, price, balance, paid, status, remarks
                        , metered_sale_id, department,period_from,period_to);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_status(List<to_metered_sale_readings> to_metered_sale_readings1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_metered_sale_readings to_metered_sale_readings : to_metered_sale_readings1) {
                String s0 = "update metered_sale_readings set "
                        + "status= :status"
                        + " where "
                        + " id ='" + to_metered_sale_readings.id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setNumber("status", 1)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_metered_sale_readings.class, "Successfully Updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
