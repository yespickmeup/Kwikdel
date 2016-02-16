/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.new_inventory;

import POS.items.S1_items;
import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_new_inventory_items {

    public static class to_new_inventory_items {

        public final int id;
        public final String user_name;
        public final String date_added;
        public final String new_inventory_no;
        public final String status;
        public final String barcode;
        public final String description;
        public final double previous_qty;
        public final double new_qty;
        public final double selling_price;
        public final String unit;
        public final double conversion;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;

        public to_new_inventory_items(int id, String user_name, String date_added, String new_inventory_no, String status, String barcode, String description, double previous_qty, double new_qty, double selling_price, String unit, double conversion, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id) {
            this.id = id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.new_inventory_no = new_inventory_no;
            this.status = status;
            this.barcode = barcode;
            this.description = description;
            this.previous_qty = previous_qty;
            this.new_qty = new_qty;
            this.selling_price = selling_price;
            this.unit = unit;
            this.conversion = conversion;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
        }
    }

    public static void add_new_inventory_items(List<to_new_inventory_items> to_new_inventory_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_new_inventory_items to_new_inventory_items : to_new_inventory_items1) {
                String s0 = "insert into new_inventory_items("
                        + "user_name"
                        + ",date_added"
                        + ",new_inventory_no"
                        + ",status"
                        + ",barcode"
                        + ",description"
                        + ",previous_qty"
                        + ",new_qty"
                        + ",selling_price"
                        + ",unit"
                        + ",conversion"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ")values("
                        + ":user_name"
                        + ",:date_added"
                        + ",:new_inventory_no"
                        + ",:status"
                        + ",:barcode"
                        + ",:description"
                        + ",:previous_qty"
                        + ",:new_qty"
                        + ",:selling_price"
                        + ",:unit"
                        + ",:conversion"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("user_name", to_new_inventory_items.user_name).
                        setString("date_added", to_new_inventory_items.date_added).
                        setString("new_inventory_no", to_new_inventory_items.new_inventory_no).
                        setString("status", to_new_inventory_items.status).
                        setString("barcode", to_new_inventory_items.barcode).
                        setString("description", to_new_inventory_items.description).
                        setNumber("previous_qty", to_new_inventory_items.previous_qty).
                        setNumber("new_qty", to_new_inventory_items.new_qty).
                        setNumber("selling_price", to_new_inventory_items.selling_price).
                        setString("unit", to_new_inventory_items.unit).
                        setNumber("conversion", to_new_inventory_items.conversion).
                        setString("category", to_new_inventory_items.category).
                        setString("category_id", to_new_inventory_items.category_id).
                        setString("classification", to_new_inventory_items.classification).
                        setString("classification_id", to_new_inventory_items.classification_id).
                        setString("sub_class", to_new_inventory_items.sub_class).
                        setString("sub_class_id", to_new_inventory_items.sub_class_id).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_new_inventory_items.class, "Successfully Added");

//                System.out.println(" "+to_new_inventory_items.new_qty);
                double new_qty =(to_new_inventory_items.conversion * to_new_inventory_items.new_qty);
                String s2 = "update items set "
                        + "product_qty='" + new_qty + "' "
                        + " where barcode = '" + to_new_inventory_items.barcode + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_new_inventory_items(to_new_inventory_items to_new_inventory_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update new_inventory_items set "
                    + "user_name= '" + to_new_inventory_items.user_name + "'"
                    + ",date_added= '" + to_new_inventory_items.date_added + "'"
                    + ",new_inventory_no= '" + to_new_inventory_items.new_inventory_no + "'"
                    + ",status= '" + to_new_inventory_items.status + "'"
                    + ",barcode= '" + to_new_inventory_items.barcode + "'"
                    + ",description= '" + to_new_inventory_items.description + "'"
                    + ",previous_qty= '" + to_new_inventory_items.previous_qty + "'"
                    + ",new_qty= '" + to_new_inventory_items.new_qty + "'"
                    + ",selling_price= '" + to_new_inventory_items.selling_price + "'"
                    + ",unit= '" + to_new_inventory_items.unit + "'"
                    + ",conversion= '" + to_new_inventory_items.conversion + "'"
                    + ",category= '" + to_new_inventory_items.category + "'"
                    + ",category_id= '" + to_new_inventory_items.category_id + "'"
                    + ",classification= '" + to_new_inventory_items.classification + "'"
                    + ",classification_id= '" + to_new_inventory_items.classification_id + "'"
                    + ",sub_class= '" + to_new_inventory_items.sub_class + "'"
                    + ",sub_class_id= '" + to_new_inventory_items.sub_class_id + "'"
                    + "where "
                    + " id ='" + to_new_inventory_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_inventory_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_new_inventory_items(to_new_inventory_items to_new_inventory_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from new_inventory_items where "
                    + " id ='" + to_new_inventory_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_inventory_items.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_new_inventory_items> ret_data(String barcodes) {
        List<to_new_inventory_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",date_added"
                    + ",new_inventory_no"
                    + ",status"
                    + ",barcode"
                    + ",description"
                    + ",previous_qty"
                    + ",new_qty"
                    + ",selling_price"
                    + ",unit"
                    + ",conversion"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + " from new_inventory_items where "
                    + " new_inventory_no ='" + barcodes + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String date_added = rs.getString(3);
                String new_inventory_no = rs.getString(4);
                String status = rs.getString(5);
                String barcode = rs.getString(6);
                String description = rs.getString(7);
                double previous_qty = rs.getDouble(8);
                double new_qty = rs.getDouble(9);
                double selling_price = rs.getDouble(10);
                String unit = rs.getString(11);
                double conversion = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);

                to_new_inventory_items to = new to_new_inventory_items(id, user_name, date_added, new_inventory_no, status, barcode, description, previous_qty, new_qty, selling_price, unit, conversion, category, category_id, classification, classification_id, sub_class, sub_class_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
