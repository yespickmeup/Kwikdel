/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

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
public class S1_purchase_order_items {

    public static class to_purchase_order_items {

        public final int id;
        public final String po_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public final double conversion;
        public final String unit;

        public to_purchase_order_items(int id, String po_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, double conversion, String unit) {
            this.id = id;
            this.po_no = po_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.conversion = conversion;
            this.unit = unit;
        }
    }

    public static void add_purchase_order_items(List<to_purchase_order_items> to_purchase_order_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_purchase_order_items to_purchase_order_items : to_purchase_order_items1) {
                String s0 = "insert into purchase_order_items("
                        + "po_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",conversion"
                        + ",unit"
                        + ")values("
                        + ":po_no"
                        + ",:user_name"
                        + ",:session_no"
                        + ",:date_added"
                        + ",:supplier"
                        + ",:supllier_id"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:cost"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ",:conversion"
                        + ",:unit"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("po_no", to_purchase_order_items.po_no).
                        setString("user_name", to_purchase_order_items.user_name).
                        setString("session_no", to_purchase_order_items.session_no).
                        setString("date_added", to_purchase_order_items.date_added).
                        setString("supplier", to_purchase_order_items.supplier).
                        setString("supllier_id", to_purchase_order_items.supllier_id).
                        setString("remarks", to_purchase_order_items.remarks).
                        setString("barcode", to_purchase_order_items.barcode).
                        setString("description", to_purchase_order_items.description).
                        setNumber("qty", to_purchase_order_items.qty).
                        setNumber("cost", to_purchase_order_items.cost).
                        setString("category", to_purchase_order_items.category).
                        setString("category_id", to_purchase_order_items.category_id).
                        setString("classification", to_purchase_order_items.classification).
                        setString("classification_id", to_purchase_order_items.classification_id).
                        setString("sub_class", to_purchase_order_items.sub_class).
                        setString("sub_class_id", to_purchase_order_items.sub_class_id).
                        setNumber("conversion", to_purchase_order_items.conversion).
                        setString("unit", to_purchase_order_items.unit).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_purchase_order_items.class, "Successfully Added");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_purchase_order_items(to_purchase_order_items to_purchase_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_order_items set "
                    + "po_no= '" + to_purchase_order_items.po_no + "'"
                    + ",user_name= '" + to_purchase_order_items.user_name + "'"
                    + ",session_no= '" + to_purchase_order_items.session_no + "'"
                    + ",date_added= '" + to_purchase_order_items.date_added + "'"
                    + ",supplier= '" + to_purchase_order_items.supplier + "'"
                    + ",supllier_id= '" + to_purchase_order_items.supllier_id + "'"
                    + ",remarks= '" + to_purchase_order_items.remarks + "'"
                    + ",barcode= '" + to_purchase_order_items.barcode + "'"
                    + ",description= '" + to_purchase_order_items.description + "'"
                    + ",qty= '" + to_purchase_order_items.qty + "'"
                    + ",cost= '" + to_purchase_order_items.cost + "'"
                    + ",category= '" + to_purchase_order_items.category + "'"
                    + ",category_id= '" + to_purchase_order_items.category_id + "'"
                    + ",classification= '" + to_purchase_order_items.classification + "'"
                    + ",classification_id= '" + to_purchase_order_items.classification_id + "'"
                    + ",sub_class= '" + to_purchase_order_items.sub_class + "'"
                    + ",sub_class_id= '" + to_purchase_order_items.sub_class_id + "'"
                    + ",conversion= '" + to_purchase_order_items.conversion + "'"
                    + ",unit= '" + to_purchase_order_items.unit + "'"
                    + "where "
                    + " id ='" + to_purchase_order_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_order_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_purchase_order_items(to_purchase_order_items to_purchase_order_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from purchase_order_items where "
                    + " id ='" + to_purchase_order_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_order_items.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_purchase_order_items> ret_data(String po_no1) {
        List<to_purchase_order_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + " from purchase_order_items where "
                    + " po_no ='" + po_no1 + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String po_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);

                to_purchase_order_items to = new to_purchase_order_items(id, po_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit);
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
