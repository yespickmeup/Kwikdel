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
public class S1_metered_sales {

    public static class to_metered_sales {

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
        public boolean selected;
        public final String meter_type;

        public to_metered_sales(int id, String customer_id, String customer_name, String user_id, String user_name, String date_added, String description, double qty, double price, double balance, double paid, int status, String remarks, boolean selected, String meter_type
        ) {
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
            this.selected = selected;
            this.meter_type = meter_type;

        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_metered_sales(to_metered_sales to_metered_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into metered_sales("
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
                    + ",meter_type"
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
                    + ",:meter_type"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_metered_sales.customer_id)
                    .setString("customer_name", to_metered_sales.customer_name)
                    .setString("user_id", to_metered_sales.user_id)
                    .setString("user_name", to_metered_sales.user_name)
                    .setString("date_added", to_metered_sales.date_added)
                    .setString("description", to_metered_sales.description)
                    .setNumber("qty", to_metered_sales.qty)
                    .setNumber("price", to_metered_sales.price)
                    .setNumber("balance", to_metered_sales.balance)
                    .setNumber("paid", to_metered_sales.paid)
                    .setNumber("status", to_metered_sales.status)
                    .setString("remarks", to_metered_sales.remarks)
                    .setString("meter_type", to_metered_sales.meter_type)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_metered_sales(to_metered_sales to_metered_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update metered_sales set "
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
                    + ",meter_type= :meter_type"
                    + " where "
                    + " id ='" + to_metered_sales.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_metered_sales.customer_id)
                    .setString("customer_name", to_metered_sales.customer_name)
                    .setString("user_id", to_metered_sales.user_id)
                    .setString("user_name", to_metered_sales.user_name)
                    .setString("date_added", to_metered_sales.date_added)
                    .setString("description", to_metered_sales.description)
                    .setNumber("qty", to_metered_sales.qty)
                    .setNumber("price", to_metered_sales.price)
                    .setNumber("balance", to_metered_sales.balance)
                    .setNumber("paid", to_metered_sales.paid)
                    .setNumber("status", to_metered_sales.status)
                    .setString("remarks", to_metered_sales.remarks)
                    .setString("meter_type", to_metered_sales.meter_type)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_metered_sales(to_metered_sales to_metered_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from metered_sales where "
                    + " id ='" + to_metered_sales.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_metered_sales> ret_data(String where) {
        List<to_metered_sales> datas = new ArrayList();

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
                    + ",meter_type"
                    + " from metered_sales  "
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
                String meter_type = rs.getString(14);
                to_metered_sales to = new to_metered_sales(id, customer_id, customer_name, user_id, user_name, date_added, description, qty, price, balance, paid, status, remarks, false, meter_type);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_metered_sales ret_balance(String where) {
        to_metered_sales to1 = null;

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
                    + ",meter_type"
                    + " from metered_sales  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
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
                String meter_type = rs.getString(14);
                to1 = new to_metered_sales(id, customer_id, customer_name, user_id, user_name, date_added, description, qty, price, balance, paid, status, remarks, false, meter_type);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_department(List<to_metered_sales> to_metered_sales1, String department) {
        try {
            Connection conn = MyConnection.connect();
            for (to_metered_sales to_metered_sales : to_metered_sales1) {
                if (to_metered_sales.selected == true) {
                    String s0 = "update metered_sales set "
                            + "remarks= :remarks"
                            + " where "
                            + " id ='" + to_metered_sales.id + "' "
                            + " ";

                    s0 = SqlStringUtil.parse(s0)
                            .setString("remarks", department)
                            .ok();

                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S1_metered_sales.class, "Successfully Updated");

                    String s2 = "update metered_sale_readings set "
                            + "department= :department"
                            + " where "
                            + " metered_sale_id ='" + to_metered_sales.id + "' and status='" + "0" + "'"
                            + " ";

                    s2 = SqlStringUtil.parse(s2)
                            .setString("department", department)
                            .ok();

                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();
                    Lg.s(S1_metered_sale_readings.class, "Successfully Updated");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
