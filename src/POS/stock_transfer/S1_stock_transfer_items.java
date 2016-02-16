/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.items.S1_items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_stock_transfer_items {

    public static class to_stock_transfer_items {

        public final int id;
        public final String receipt_no;
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
        public final String conversion;
        public final String unit;
        public final int status;
        public final String reference_no;
        public final String from_location_name;
        public final String from_location_id;
        public final String to_location_name;
        public final String to_location_id;

        public to_stock_transfer_items(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, String conversion, String unit, int status, String reference_no, String from_location_name, String from_location_id, String to_location_name, String to_location_id) {
            this.id = id;
            this.receipt_no = receipt_no;
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
            this.status = status;
            this.reference_no = reference_no;
            this.from_location_name = from_location_name;
            this.from_location_id = from_location_id;
            this.to_location_name = to_location_name;
            this.to_location_id = to_location_id;
        }
    }

    public static void add_data(List<to_stock_transfer_items> to_stock_transfer_items1, S1_stock_transfers.to_stock_transfers stock_transfer) {
        try {
            Connection conn = MyConnection.connect();
            for (to_stock_transfer_items to_stock_transfer_items : to_stock_transfer_items1) {
                String s0 = "insert into stock_transfer_items("
                        + "receipt_no"
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
                        + ",status"
                        + ",reference_no"
                        + ",from_location_name"
                        + ",from_location_id"
                        + ",to_location_name"
                        + ",to_location_id"
                        + ")values("
                        + ":receipt_no"
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
                        + ",:status"
                        + ",:reference_no"
                        + ",:from_location_name"
                        + ",:from_location_id"
                        + ",:to_location_name"
                        + ",:to_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("receipt_no", stock_transfer.stock_transfer_no)
                        .setString("user_name", stock_transfer.user_name)
                        .setString("session_no", stock_transfer.session_no)
                        .setString("date_added", stock_transfer.date_added)
                        .setString("supplier", stock_transfer.supplier)
                        .setString("supllier_id", stock_transfer.supplier_id)
                        .setString("remarks", stock_transfer.remarks)
                        .setString("barcode", to_stock_transfer_items.barcode)
                        .setString("description", to_stock_transfer_items.description)
                        .setNumber("qty", to_stock_transfer_items.qty)
                        .setNumber("cost", to_stock_transfer_items.cost)
                        .setString("category", to_stock_transfer_items.category)
                        .setString("category_id", to_stock_transfer_items.category_id)
                        .setString("classification", to_stock_transfer_items.classification)
                        .setString("classification_id", to_stock_transfer_items.classification_id)
                        .setString("sub_class", to_stock_transfer_items.sub_class)
                        .setString("sub_class_id", to_stock_transfer_items.sub_class_id)
                        .setString("conversion", to_stock_transfer_items.conversion)
                        .setString("unit", to_stock_transfer_items.unit)
                        .setNumber("status", to_stock_transfer_items.status)
                        .setString("reference_no", stock_transfer.reference_no)
                        .setString("from_location_name", stock_transfer.from_location_name)
                        .setString("from_location_id", stock_transfer.from_location_id)
                        .setString("to_location_name", stock_transfer.to_location_name)
                        .setString("to_location_id", stock_transfer.to_location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_stock_transfer_items.class, "Successfully Added");

                S1_items.to_items tt = S1_items.ret_data3(to_stock_transfer_items.barcode, stock_transfer.from_location_id);
                double new_qty = tt.product_qty - (FitIn.toDouble(to_stock_transfer_items.conversion) * to_stock_transfer_items.qty);
                String s2 = "update items set "
                        + "product_qty='" + new_qty + "',cost='" + to_stock_transfer_items.cost + "' "
                        + " where barcode = '" + to_stock_transfer_items.barcode + "' and location_id='" + stock_transfer.from_location_id + "' "
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

                S1_items.to_items tt3 = S1_items.ret_data3(to_stock_transfer_items.barcode, stock_transfer.to_location_id);
                double new_qty3 = tt3.product_qty + (FitIn.toDouble(to_stock_transfer_items.conversion) * to_stock_transfer_items.qty);
                String s3 = "update items set "
                        + "product_qty='" + new_qty3 + "',cost='" + to_stock_transfer_items.cost + "' "
                        + " where barcode = '" + to_stock_transfer_items.barcode + "' and location_id='" + stock_transfer.to_location_id + "' "
                        + "";
                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_stock_transfer_items to_stock_transfer_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfer_items set "
                    + "receipt_no= :receipt_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supllier_id= :supllier_id "
                    + ",remarks= :remarks "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",qty= :qty "
                    + ",cost= :cost "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_class= :sub_class "
                    + ",sub_class_id= :sub_class_id "
                    + ",conversion= :conversion "
                    + ",unit= :unit "
                    + ",status= :status "
                    + ",reference_no= :reference_no "
                    + ",from_location_name= :from_location_name "
                    + ",from_location_id= :from_location_id "
                    + ",to_location_name= :to_location_name "
                    + ",to_location_id= :to_location_id "
                    + " where id='" + to_stock_transfer_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("receipt_no", to_stock_transfer_items.receipt_no)
                    .setString("user_name", to_stock_transfer_items.user_name)
                    .setString("session_no", to_stock_transfer_items.session_no)
                    .setString("date_added", to_stock_transfer_items.date_added)
                    .setString("supplier", to_stock_transfer_items.supplier)
                    .setString("supllier_id", to_stock_transfer_items.supllier_id)
                    .setString("remarks", to_stock_transfer_items.remarks)
                    .setString("barcode", to_stock_transfer_items.barcode)
                    .setString("description", to_stock_transfer_items.description)
                    .setNumber("qty", to_stock_transfer_items.qty)
                    .setNumber("cost", to_stock_transfer_items.cost)
                    .setString("category", to_stock_transfer_items.category)
                    .setString("category_id", to_stock_transfer_items.category_id)
                    .setString("classification", to_stock_transfer_items.classification)
                    .setString("classification_id", to_stock_transfer_items.classification_id)
                    .setString("sub_class", to_stock_transfer_items.sub_class)
                    .setString("sub_class_id", to_stock_transfer_items.sub_class_id)
                    .setString("conversion", to_stock_transfer_items.conversion)
                    .setString("unit", to_stock_transfer_items.unit)
                    .setNumber("status", to_stock_transfer_items.status)
                    .setString("reference_no", to_stock_transfer_items.reference_no)
                    .setString("from_location_name", to_stock_transfer_items.from_location_name)
                    .setString("from_location_id", to_stock_transfer_items.from_location_id)
                    .setString("to_location_name", to_stock_transfer_items.to_location_name)
                    .setString("to_location_id", to_stock_transfer_items.to_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfer_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_stock_transfer_items to_stock_transfer_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_transfer_items  "
                    + " where id='" + to_stock_transfer_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfer_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfer_items> ret_data(String where) {
        List<to_stock_transfer_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
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
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from stock_transfer_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
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
                String conversion = rs.getString(19);
                String unit = rs.getString(20);
                int status = rs.getInt(21);
                String reference_no = rs.getString(22);
                String from_location_name = rs.getString(23);
                String from_location_id = rs.getString(24);
                String to_location_name = rs.getString(25);
                String to_location_id = rs.getString(26);

                to_stock_transfer_items to = new to_stock_transfer_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
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
