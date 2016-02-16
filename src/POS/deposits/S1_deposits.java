/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.deposits;

import POS.customers.S1_customers;
import POS.items.S1_items;
import POS.util.MyConnection;
import POS.util.Users;
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
public class S1_deposits {

    public static class to_deposits {

        public final int id;
        public final String user_name;
        public final String user_id;
        public final String date_added;
        public final int status;
        public final String customer_id;
        public final String customer_name;
        public final double qty;
        public final String barcode;
        public final String description;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final int vatable;
        public final double discount_amount;
        public final double addtl_amount;
        public final String location_name;
        public final String location_id;
        public final int is_deposit;
        public to_deposits(int id, String user_name, String user_id, String date_added, int status, String customer_id
                , String customer_name, double qty, String barcode, String description, String category, String category_id
                , String classification, String classification_id, String sub_classification, String sub_classification_id
                , String unit, double conversion, double selling_price, int vatable, double discount_amount, double addtl_amount
                , String location_name, String location_id,int is_deposit) {
            this.id = id;
            this.user_name = user_name;
            this.user_id = user_id;
            this.date_added = date_added;
            this.status = status;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.qty = qty;
            this.barcode = barcode;
            this.description = description;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.vatable = vatable;
            this.discount_amount = discount_amount;
            this.addtl_amount = addtl_amount;
            this.location_name = location_name;
            this.location_id = location_id;
            this.is_deposit=is_deposit;
        }
    }

    public static void add_data(to_deposits to_deposits) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into deposits("
                    + "user_name"
                    + ",user_id"
                    + ",date_added"
                    + ",status"
                    + ",customer_id"
                    + ",customer_name"
                    + ",qty"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",vatable"
                    + ",discount_amount"
                    + ",addtl_amount"
                    + ",location_name"
                    + ",location_id"
                    + ",is_deposit"
                    + ")values("
                    + ":user_name"
                    + ",:user_id"
                    + ",:date_added"
                    + ",:status"
                    + ",:customer_id"
                    + ",:customer_name"
                    + ",:qty"
                    + ",:barcode"
                    + ",:description"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_classification"
                    + ",:sub_classification_id"
                    + ",:unit"
                    + ",:conversion"
                    + ",:selling_price"
                    + ",:vatable"
                    + ",:discount_amount"
                    + ",:addtl_amount"
                    + ",:location_name"
                    + ",:location_id"
                    + ",:is_deposit"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_name", to_deposits.user_name)
                    .setString("user_id", to_deposits.user_id)
                    .setString("date_added", to_deposits.date_added)
                    .setNumber("status", to_deposits.status)
                    .setString("customer_id", to_deposits.customer_id)
                    .setString("customer_name", to_deposits.customer_name)
                    .setNumber("qty", to_deposits.qty)
                    .setString("barcode", to_deposits.barcode)
                    .setString("description", to_deposits.description)
                    .setString("category", to_deposits.category)
                    .setString("category_id", to_deposits.category_id)
                    .setString("classification", to_deposits.classification)
                    .setString("classification_id", to_deposits.classification_id)
                    .setString("sub_classification", to_deposits.sub_classification)
                    .setString("sub_classification_id", to_deposits.sub_classification_id)
                    .setString("unit", to_deposits.unit)
                    .setNumber("conversion", to_deposits.conversion)
                    .setNumber("selling_price", to_deposits.selling_price)
                    .setNumber("vatable", to_deposits.vatable)
                    .setNumber("discount_amount", to_deposits.discount_amount)
                    .setNumber("addtl_amount", to_deposits.addtl_amount)
                    .setString("location_name", to_deposits.location_name)
                    .setString("location_id", to_deposits.location_id)
                    .setNumber("is_deposit",to_deposits.is_deposit)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposits.class, "Successfully Added");

            S1_items.to_items tt = S1_items.ret_data3(to_deposits.barcode, to_deposits.location_id);
            double new_qty = tt.product_qty - (to_deposits.conversion * to_deposits.qty);
            String s2 = "update items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to_deposits.barcode + "' and location_id='" + to_deposits.location_id + "' "
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            String where2 = " where id='" + to_deposits.customer_id + "' ";
            S1_customers.to_customers dep = ret_deposit(where2);
            double deposit = dep.deposit + (to_deposits.qty * to_deposits.selling_price);
            String s3 = "update customers set "
                    + "deposit='" + deposit + "' "
                    + " where id = '" + to_deposits.customer_id + "'  "
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static S1_customers.to_customers ret_deposit(String where) {
        S1_customers.to_customers to = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",account"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",lname"
                    + ",fname"
                    + ",client_id"
                    + ",deposit"
                    + " from customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                String account = rs.getString(11);
                String first_name = rs.getString(12);
                String last_name = rs.getString(13);
                String mi = rs.getString(14);
                String lname = rs.getString(15);
                String fname = rs.getString(16);
                String client_id = rs.getString(17);
                double deposit = rs.getDouble(18);

                to = new S1_customers.to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi, deposit);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_deposits to_deposits) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update deposits set "
                    + "user_name= :user_name "
                    + ",user_id= :user_id "
                    + ",date_added= :date_added "
                    + ",status= :status "
                    + ",customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",qty= :qty "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",vatable= :vatable "
                    + ",discount_amount= :discount_amount "
                    + ",addtl_amount= :addtl_amount "
                    + ",location_name= :location_name "
                    + ",location_id= :location_id "
                    + ",is_deposit= :is_deposit"
                    + " where id='" + to_deposits.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_name", to_deposits.user_name)
                    .setString("user_id", to_deposits.user_id)
                    .setString("date_added", to_deposits.date_added)
                    .setNumber("status", to_deposits.status)
                    .setString("customer_id", to_deposits.customer_id)
                    .setString("customer_name", to_deposits.customer_name)
                    .setNumber("qty", to_deposits.qty)
                    .setString("barcode", to_deposits.barcode)
                    .setString("description", to_deposits.description)
                    .setString("category", to_deposits.category)
                    .setString("category_id", to_deposits.category_id)
                    .setString("classification", to_deposits.classification)
                    .setString("classification_id", to_deposits.classification_id)
                    .setString("sub_classification", to_deposits.sub_classification)
                    .setString("sub_classification_id", to_deposits.sub_classification_id)
                    .setString("unit", to_deposits.unit)
                    .setNumber("conversion", to_deposits.conversion)
                    .setNumber("selling_price", to_deposits.selling_price)
                    .setNumber("vatable", to_deposits.vatable)
                    .setNumber("discount_amount", to_deposits.discount_amount)
                    .setNumber("addtl_amount", to_deposits.addtl_amount)
                    .setString("location_name", to_deposits.location_name)
                    .setString("location_id", to_deposits.location_id)
                    .setNumber("is_deposit",to_deposits.is_deposit)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposits.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_deposits to_deposits) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from deposits  "
                    + " where id='" + to_deposits.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposits.class, "Successfully Deleted");

            S1_items.to_items tt = S1_items.ret_data3(to_deposits.barcode, to_deposits.location_id);
            double new_qty = tt.product_qty + (to_deposits.conversion * to_deposits.qty);
            String s2 = "update items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to_deposits.barcode + "' and location_id='" + to_deposits.location_id + "' "
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            String where2 = " where id='" + to_deposits.customer_id + "' ";
            S1_customers.to_customers dep = ret_deposit(where2);
            double deposit = dep.deposit - (to_deposits.qty * to_deposits.selling_price);
            String s3 = "update customers set "
                    + "deposit='" + deposit + "' "
                    + " where id = '" + to_deposits.customer_id + "'  "
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void return_deposit(to_deposits to_deposits, double qty,String date_returned) {
        try {
            Connection conn = MyConnection.connect();
            double dep_qty = to_deposits.discount_amount + qty;
            String s0 = "update  deposits  set "
                    + " discount_amount='" + dep_qty + "' "
                    + " where id='" + to_deposits.id + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposits.class, "Successfully Deleted");

            S1_items.to_items tt = S1_items.ret_data3(to_deposits.barcode, to_deposits.location_id);
            double new_qty = tt.product_qty + (to_deposits.conversion * to_deposits.qty);
            String s2 = "update items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to_deposits.barcode + "' and location_id='" + to_deposits.location_id + "' "
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            String where2 = " where id='" + to_deposits.customer_id + "' ";
            S1_customers.to_customers dep = ret_deposit(where2);
            double deposit = dep.deposit - (qty * to_deposits.selling_price);
            String s3 = "update customers set "
                    + "deposit='" + deposit + "' "
                    + " where id = '" + to_deposits.customer_id + "'  "
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

            String s4 = "insert into deposit_returns("
                    + "deposit_id"
                    + ",user_name"
                    + ",user_id"
                    + ",date_added"
                    + ",status"
                    + ",customer_id"
                    + ",customer_name"
                    + ",qty"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",vatable"
                    + ",discount_amount"
                    + ",addtl_amount"
                    + ",location_name"
                    + ",location_id"
                    + ",is_deposit"
                    + ",date_returned"
                    + ")values("
                    + ":deposit_id"
                    + ",:user_name"
                    + ",:user_id"
                    + ",:date_added"
                    + ",:status"
                    + ",:customer_id"
                    + ",:customer_name"
                    + ",:qty"
                    + ",:barcode"
                    + ",:description"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_classification"
                    + ",:sub_classification_id"
                    + ",:unit"
                    + ",:conversion"
                    + ",:selling_price"
                    + ",:vatable"
                    + ",:discount_amount"
                    + ",:addtl_amount"
                    + ",:location_name"
                    + ",:location_id"
                    + ",:is_deposit"
                    + ",:date_returned"
                    + ")";

            s4 = SqlStringUtil.parse(s4)
                    .setString("deposit_id", "" + to_deposits.id)
                    .setString("user_name", Users.get_username())
                    .setString("user_id", Users.getSession_no())
                    .setString("date_added", to_deposits.date_added)
                    .setNumber("status", to_deposits.status)
                    .setString("customer_id", to_deposits.customer_id)
                    .setString("customer_name", to_deposits.customer_name)
                    .setNumber("qty", qty)
                    .setString("barcode", to_deposits.barcode)
                    .setString("description", to_deposits.description)
                    .setString("category", to_deposits.category)
                    .setString("category_id", to_deposits.category_id)
                    .setString("classification", to_deposits.classification)
                    .setString("classification_id", to_deposits.classification_id)
                    .setString("sub_classification", to_deposits.sub_classification)
                    .setString("sub_classification_id", to_deposits.sub_classification_id)
                    .setString("unit", to_deposits.unit)
                    .setNumber("conversion", to_deposits.conversion)
                    .setNumber("selling_price", to_deposits.selling_price)
                    .setNumber("vatable", to_deposits.vatable)
                    .setNumber("discount_amount", to_deposits.discount_amount)
                    .setNumber("addtl_amount", to_deposits.addtl_amount)
                    .setString("location_name", to_deposits.location_name)
                    .setString("location_id", to_deposits.location_id)
                    .setNumber("is_deposit",to_deposits.is_deposit)
                    .setString("date_returned",date_returned)
                    .ok();

            PreparedStatement stmt4 = conn.prepareStatement(s4);
            stmt4.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_deposits> ret_data(String where) {
        List<to_deposits> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",user_id"
                    + ",date_added"
                    + ",status"
                    + ",customer_id"
                    + ",customer_name"
                    + ",qty"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",vatable"
                    + ",discount_amount"
                    + ",addtl_amount"
                    + ",location_name"
                    + ",location_id"
                    + ",is_deposit"
                    + " from deposits"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_id = rs.getString(3);
                String date_added = rs.getString(4);
                int status = rs.getInt(5);
                String customer_id = rs.getString(6);
                String customer_name = rs.getString(7);
                double qty = rs.getDouble(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                String category = rs.getString(11);
                String category_id = rs.getString(12);
                String classification = rs.getString(13);
                String classification_id = rs.getString(14);
                String sub_classification = rs.getString(15);
                String sub_classification_id = rs.getString(16);
                String unit = rs.getString(17);
                double conversion = rs.getDouble(18);
                double selling_price = rs.getDouble(19);
                int vatable = rs.getInt(20);
                double discount_amount = rs.getDouble(21);
                double addtl_amount = rs.getDouble(22);
                String location_name = rs.getString(23);
                String location_id = rs.getString(24);
                int is_deposit=rs.getInt(25);
                to_deposits to = new to_deposits(id, user_name, user_id, date_added, status, customer_id, customer_name, qty, barcode, description
                        , category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion
                        , selling_price, vatable, discount_amount, addtl_amount, location_name, location_id,is_deposit);
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
