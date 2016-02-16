/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales_dr;

import POS.sales.S1_sales_items;
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
public class S1_sales_dr_items {

    public static class to_sales_dr_items {

        public final int id;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String session_no;
        public final String item_discount;
        public final double discount;
        public final double discount_amount;
        public final String sales_no;
        public final int fixed_price;
        public final String supplier;
        public final String supplier_id;
        public final int vatable;
        public final String or_no;
        public final String customer_name;
        public final String customer_id;
        public final int metered;
        public final String location_id;
        public final String location_name;

        public to_sales_dr_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String session_no, String item_discount, double discount, double discount_amount, String sales_no, int fixed_price, String supplier, String supplier_id, int vatable, String or_no, String customer_name, String customer_id, int metered, String location_id, String location_name) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.session_no = session_no;
            this.item_discount = item_discount;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.sales_no = sales_no;
            this.fixed_price = fixed_price;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.vatable = vatable;
            this.or_no = or_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.metered = metered;
            this.location_id = location_id;
            this.location_name = location_name;
        }
    }

    public static void add_sales_dr_items(List<S1_sales_items.to_sales_items> to_sales_dr_items1, String sales_no) {
        try {
            Connection conn = MyConnection.connect();
            for (S1_sales_items.to_sales_items to_sales_dr_items : to_sales_dr_items1) {
                String s0 = "insert into sales_dr_items("
                        + "barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",session_no"
                        + ",item_discount"
                        + ",discount"
                        + ",discount_amount"
                        + ",sales_no"
                        + ",fixed_price"
                        + ",supplier"
                        + ",supplier_id"
                        + ",vatable"
                        + ",or_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",metered"
                        + ",location_id"
                        + ",location_name"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:session_no"
                        + ",:item_discount"
                        + ",:discount"
                        + ",:discount_amount"
                        + ",:sales_no"
                        + ",:fixed_price"
                        + ",:supplier"
                        + ",:supplier_id"
                        + ",:vatable"
                        + ",:or_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:metered"
                        + ",:location_id"
                        + ",:location_name"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("barcode", to_sales_dr_items.barcode)
                        .setString("description", to_sales_dr_items.description)
                        .setString("generic_name", to_sales_dr_items.generic_name)
                        .setString("category", to_sales_dr_items.category)
                        .setString("category_id", to_sales_dr_items.category_id)
                        .setString("classification", to_sales_dr_items.classification)
                        .setString("classification_id", to_sales_dr_items.classification_id)
                        .setString("sub_classification", to_sales_dr_items.sub_classification)
                        .setString("sub_classification_id", to_sales_dr_items.sub_classification_id)
                        .setNumber("product_qty", to_sales_dr_items.product_qty)
                        .setString("unit", to_sales_dr_items.unit)
                        .setNumber("conversion", to_sales_dr_items.conversion)
                        .setNumber("selling_price", to_sales_dr_items.selling_price)
                        .setString("date_added", to_sales_dr_items.date_added)
                        .setString("user_name", to_sales_dr_items.user_name)
                        .setString("item_type", to_sales_dr_items.item_type)
                        .setNumber("status", to_sales_dr_items.status)
                        .setString("session_no", to_sales_dr_items.session_no)
                        .setString("item_discount", to_sales_dr_items.item_discount)
                        .setNumber("discount", to_sales_dr_items.discount)
                        .setNumber("discount_amount", to_sales_dr_items.discount_amount)
                        .setString("sales_no", sales_no)
                        .setNumber("fixed_price", to_sales_dr_items.fixed_price)
                        .setString("supplier", to_sales_dr_items.supplier)
                        .setString("supplier_id", to_sales_dr_items.supplier_id)
                        .setNumber("vatable", to_sales_dr_items.vatable)
                        .setString("or_no", to_sales_dr_items.or_no)
                        .setString("customer_name", to_sales_dr_items.customer_name)
                        .setString("customer_id", to_sales_dr_items.customer_id)
                        .setNumber("metered", to_sales_dr_items.metered)
                        .setString("location_id", to_sales_dr_items.location_id)
                        .setString("location_name", to_sales_dr_items.location_name)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_sales_dr_items.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S1_sales_items.to_sales_items> ret_data(String where) {
        List<S1_sales_items.to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",metered"
                    + ",location_id"
                    + ",location_name"
                    + " from sales_dr_items  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);
                S1_sales_items.to_sales_items to = new S1_sales_items.to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, metered, location_id, location_name);
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
