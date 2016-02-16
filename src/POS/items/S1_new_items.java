/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.locations.S1_locations;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_new_items {

    public static class to_items {

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
        public final String supplier;
        public final int fixed_price;
        public final double cost;
        public final String supplier_id;
        public final int multi_level_pricing;
        public final int vatable;
        public final double reorder_level;
        public final String location_name;
        public final String location_id;

        public to_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, String location_name, String location_id) {
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
            this.supplier = supplier;
            this.fixed_price = fixed_price;
            this.cost = cost;
            this.supplier_id = supplier_id;
            this.multi_level_pricing = multi_level_pricing;
            this.vatable = vatable;
            this.reorder_level = reorder_level;
            this.location_name = location_name;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_items to_items) {
        try {
            Connection conn = MyConnection.connect();
            List<S1_locations.to_locations> locations = S1_locations.ret_data("");
            for (S1_locations.to_locations loc : locations) {
                String s0 = "insert into items("
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
                        + ",supplier"
                        + ",fixed_price"
                        + ",cost"
                        + ",supplier_id"
                        + ",multi_level_pricing"
                        + ",vatable"
                        + ",reorder_level"
                        + ",location_name"
                        + ",location_id"
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
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:location_name"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("barcode", to_items.barcode).
                        setString("description", to_items.description).
                        setString("generic_name", to_items.generic_name).
                        setString("category", to_items.category).
                        setString("category_id", to_items.category_id).
                        setString("classification", to_items.classification).
                        setString("classification_id", to_items.classification_id).
                        setString("sub_classification", to_items.sub_classification).
                        setString("sub_classification_id", to_items.sub_classification_id).
                        setNumber("product_qty", to_items.product_qty).
                        setString("unit", to_items.unit).
                        setNumber("conversion", to_items.conversion).
                        setNumber("selling_price", to_items.selling_price).
                        setString("date_added", to_items.date_added).
                        setString("user_name", to_items.user_name).
                        setString("item_type", to_items.item_type).
                        setNumber("status", to_items.status).
                        setString("supplier", to_items.supplier).
                        setNumber("fixed_price", to_items.fixed_price).
                        setNumber("cost", to_items.cost).
                        setString("supplier_id", to_items.supplier).
                        setNumber("multi_level_pricing", to_items.multi_level_pricing).
                        setNumber("vatable", to_items.vatable).
                        setNumber("reorder_level", to_items.reorder_level).
                        setString("location_name", loc.name).
                        setString("location_id", "" + loc.id).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_items.class, "Successfully Added");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_items to_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update items set "
                    + "description= :description "
                    + ",generic_name= :generic_name "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",date_added= :date_added "
                    + ",user_name= :user_name "
                    + ",item_type= :item_type "
                    + ",status= :status "
                    + ",supplier= :supplier "
                    + ",fixed_price= :fixed_price "
                    + ",cost= :cost "
                    + ",supplier_id= :supplier_id "
                    + ",multi_level_pricing= :multi_level_pricing "
                    + ",vatable= :vatable "
                    + ",reorder_level= :reorder_level "
                    + " where barcode='" + to_items.barcode + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_items.description)
                    .setString("generic_name", to_items.generic_name)
                    .setString("category", to_items.category)
                    .setString("category_id", to_items.category_id)
                    .setString("classification", to_items.classification)
                    .setString("classification_id", to_items.classification_id)
                    .setString("sub_classification", to_items.sub_classification)
                    .setString("sub_classification_id", to_items.sub_classification_id)
                    .setNumber("product_qty", to_items.product_qty)
                    .setString("unit", to_items.unit)
                    .setNumber("conversion", to_items.conversion)
                    .setNumber("selling_price", to_items.selling_price)
                    .setString("date_added", to_items.date_added)
                    .setString("user_name", to_items.user_name)
                    .setString("item_type", to_items.item_type)
                    .setNumber("status", to_items.status)
                    .setString("supplier", to_items.supplier)
                    .setNumber("fixed_price", to_items.fixed_price)
                    .setNumber("cost", to_items.cost)
                    .setString("supplier_id", to_items.supplier_id)
                    .setNumber("multi_level_pricing", to_items.multi_level_pricing)
                    .setNumber("vatable", to_items.vatable)
                    .setNumber("reorder_level", to_items.reorder_level)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_items to_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from items  "
                    + " where barcode='" + to_items.barcode + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_data(String where) {
        List<to_items> datas = new ArrayList();

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
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",location_name"
                    + ",location_id"
                    + " from items"
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
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                String location_name = rs.getString(26);
                String location_id = rs.getString(27);

                to_items to = new to_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, location_name, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from items";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select barcode from items where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("ID: " + id());
    }

    public static int id() {
        
        int id = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from items ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            id++;
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
        
    }
}
