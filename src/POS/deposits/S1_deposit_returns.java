/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.deposits;

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
public class S1_deposit_returns {

    public static class to_deposit_returns {

        public final int id;
        public final String deposit_id;
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
        public final String date_returned;
        public to_deposit_returns(int id, String deposit_id, String user_name, String user_id, String date_added, int status
                , String customer_id, String customer_name, double qty, String barcode, String description, String category
                , String category_id, String classification, String classification_id, String sub_classification
                , String sub_classification_id, String unit, double conversion, double selling_price, int vatable
                , double discount_amount, double addtl_amount, String location_name, String location_id, int is_deposit,String date_returned) {
            this.id = id;
            this.deposit_id = deposit_id;
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
            this.is_deposit = is_deposit;
            this.date_returned=date_returned;
        }
    }

    public static void add_data(to_deposit_returns to_deposit_returns) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into deposit_returns("
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

            s0 = SqlStringUtil.parse(s0)
                    .setString("deposit_id", to_deposit_returns.deposit_id)
                    .setString("user_name", to_deposit_returns.user_name)
                    .setString("user_id", to_deposit_returns.user_id)
                    .setString("date_added", to_deposit_returns.date_added)
                    .setNumber("status", to_deposit_returns.status)
                    .setString("customer_id", to_deposit_returns.customer_id)
                    .setString("customer_name", to_deposit_returns.customer_name)
                    .setNumber("qty", to_deposit_returns.qty)
                    .setString("barcode", to_deposit_returns.barcode)
                    .setString("description", to_deposit_returns.description)
                    .setString("category", to_deposit_returns.category)
                    .setString("category_id", to_deposit_returns.category_id)
                    .setString("classification", to_deposit_returns.classification)
                    .setString("classification_id", to_deposit_returns.classification_id)
                    .setString("sub_classification", to_deposit_returns.sub_classification)
                    .setString("sub_classification_id", to_deposit_returns.sub_classification_id)
                    .setString("unit", to_deposit_returns.unit)
                    .setNumber("conversion", to_deposit_returns.conversion)
                    .setNumber("selling_price", to_deposit_returns.selling_price)
                    .setNumber("vatable", to_deposit_returns.vatable)
                    .setNumber("discount_amount", to_deposit_returns.discount_amount)
                    .setNumber("addtl_amount", to_deposit_returns.addtl_amount)
                    .setString("location_name", to_deposit_returns.location_name)
                    .setString("location_id", to_deposit_returns.location_id)
                    .setNumber("is_deposit",to_deposit_returns.is_deposit)
                    .setString("date_returned",to_deposit_returns.date_returned)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposit_returns.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_deposit_returns to_deposit_returns) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update deposit_returns set "
                    + "deposit_id= :deposit_id "
                    + ",user_name= :user_name "
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
                    + ",date_returned= :date_returned"
                    + " where id='" + to_deposit_returns.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("deposit_id", to_deposit_returns.deposit_id)
                    .setString("user_name", to_deposit_returns.user_name)
                    .setString("user_id", to_deposit_returns.user_id)
                    .setString("date_added", to_deposit_returns.date_added)
                    .setNumber("status", to_deposit_returns.status)
                    .setString("customer_id", to_deposit_returns.customer_id)
                    .setString("customer_name", to_deposit_returns.customer_name)
                    .setNumber("qty", to_deposit_returns.qty)
                    .setString("barcode", to_deposit_returns.barcode)
                    .setString("description", to_deposit_returns.description)
                    .setString("category", to_deposit_returns.category)
                    .setString("category_id", to_deposit_returns.category_id)
                    .setString("classification", to_deposit_returns.classification)
                    .setString("classification_id", to_deposit_returns.classification_id)
                    .setString("sub_classification", to_deposit_returns.sub_classification)
                    .setString("sub_classification_id", to_deposit_returns.sub_classification_id)
                    .setString("unit", to_deposit_returns.unit)
                    .setNumber("conversion", to_deposit_returns.conversion)
                    .setNumber("selling_price", to_deposit_returns.selling_price)
                    .setNumber("vatable", to_deposit_returns.vatable)
                    .setNumber("discount_amount", to_deposit_returns.discount_amount)
                    .setNumber("addtl_amount", to_deposit_returns.addtl_amount)
                    .setString("location_name", to_deposit_returns.location_name)
                    .setString("location_id", to_deposit_returns.location_id)
                    .setNumber("is_deposit",to_deposit_returns.is_deposit)
                    .setString("date_returned",to_deposit_returns.date_returned)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposit_returns.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_deposit_returns to_deposit_returns) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from deposit_returns  "
                    + " where id='" + to_deposit_returns.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_deposit_returns.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_deposit_returns> ret_data(String where) {
        List<to_deposit_returns> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",deposit_id"
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
                    + " from deposit_returns"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String deposit_id = rs.getString(2);
                String user_name = rs.getString(3);
                String user_id = rs.getString(4);
                String date_added = rs.getString(5);
                int status = rs.getInt(6);
                String customer_id = rs.getString(7);
                String customer_name = rs.getString(8);
                double qty = rs.getDouble(9);
                String barcode = rs.getString(10);
                String description = rs.getString(11);
                String category = rs.getString(12);
                String category_id = rs.getString(13);
                String classification = rs.getString(14);
                String classification_id = rs.getString(15);
                String sub_classification = rs.getString(16);
                String sub_classification_id = rs.getString(17);
                String unit = rs.getString(18);
                double conversion = rs.getDouble(19);
                double selling_price = rs.getDouble(20);
                int vatable = rs.getInt(21);
                double discount_amount = rs.getDouble(22);
                double addtl_amount = rs.getDouble(23);
                String location_name = rs.getString(24);
                String location_id = rs.getString(25);
                int is_deposit=rs.getInt(26);
                String date_returned=rs.getString(27);
                to_deposit_returns to = new to_deposit_returns(id, deposit_id, user_name, user_id, date_added, status, customer_id
                        , customer_name, qty, barcode, description, category, category_id, classification, classification_id, sub_classification
                        , sub_classification_id, unit, conversion, selling_price, vatable, discount_amount, addtl_amount, location_name
                        , location_id,is_deposit,date_returned);
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
