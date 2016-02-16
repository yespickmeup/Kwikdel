/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.items.S1_items;
import POS.stock_transfer.S1_stock_transfer_items.to_stock_transfer_items;
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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_stock_transfers {

    public static class to_stock_transfers {

        public final int id;
        public final String stock_transfer_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supplier_id;
        public final String remarks;
        public final int status;
        public final String reference_no;
        public final String from_location_name;
        public final String from_location_id;
        public final String to_location_name;
        public final String to_location_id;

        public to_stock_transfers(int id, String stock_transfer_no, String user_name, String session_no, String date_added, String supplier, String supplier_id, String remarks, int status, String reference_no, String from_location_name, String from_location_id, String to_location_name, String to_location_id) {
            this.id = id;
            this.stock_transfer_no = stock_transfer_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.remarks = remarks;
            this.status = status;
            this.reference_no = reference_no;
            this.from_location_name = from_location_name;
            this.from_location_id = from_location_id;
            this.to_location_name = to_location_name;
            this.to_location_id = to_location_id;
        }
    }

    public static void add_data(to_stock_transfers to_stock_transfers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into stock_transfers("
                    + "stock_transfer_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",remarks"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + ")values("
                    + ":stock_transfer_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supplier_id"
                    + ",:remarks"
                    + ",:status"
                    + ",:reference_no"
                    + ",:from_location_name"
                    + ",:from_location_id"
                    + ",:to_location_name"
                    + ",:to_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stock_transfer_no", to_stock_transfers.stock_transfer_no)
                    .setString("user_name", to_stock_transfers.user_name)
                    .setString("session_no", to_stock_transfers.session_no)
                    .setString("date_added", to_stock_transfers.date_added)
                    .setString("supplier", to_stock_transfers.supplier)
                    .setString("supplier_id", to_stock_transfers.supplier_id)
                    .setString("remarks", to_stock_transfers.remarks)
                    .setNumber("status", to_stock_transfers.status)
                    .setString("reference_no", to_stock_transfers.reference_no)
                    .setString("from_location_name", to_stock_transfers.from_location_name)
                    .setString("from_location_id", to_stock_transfers.from_location_id)
                    .setString("to_location_name", to_stock_transfers.to_location_name)
                    .setString("to_location_id", to_stock_transfers.to_location_id)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_stock_transfers to_stock_transfers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfers set "
                    + "stock_transfer_no= :stock_transfer_no "
                    + ",user_name= :user_name "
                    + ",session_no= :session_no "
                    + ",date_added= :date_added "
                    + ",supplier= :supplier "
                    + ",supplier_id= :supplier_id "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",reference_no= :reference_no "
                    + ",from_location_name= :from_location_name "
                    + ",from_location_id= :from_location_id "
                    + ",to_location_name= :to_location_name "
                    + ",to_location_id= :to_location_id "
                    + " where id='" + to_stock_transfers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stock_transfer_no", to_stock_transfers.stock_transfer_no)
                    .setString("user_name", to_stock_transfers.user_name)
                    .setString("session_no", to_stock_transfers.session_no)
                    .setString("date_added", to_stock_transfers.date_added)
                    .setString("supplier", to_stock_transfers.supplier)
                    .setString("supplier_id", to_stock_transfers.supplier_id)
                    .setString("remarks", to_stock_transfers.remarks)
                    .setNumber("status", to_stock_transfers.status)
                    .setString("reference_no", to_stock_transfers.reference_no)
                    .setString("from_location_name", to_stock_transfers.from_location_name)
                    .setString("from_location_id", to_stock_transfers.from_location_id)
                    .setString("to_location_name", to_stock_transfers.to_location_name)
                    .setString("to_location_id", to_stock_transfers.to_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_stock_transfers to_stock_transfers, List<to_stock_transfer_items> items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_transfers  "
                    + " where id='" + to_stock_transfers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfers.class, "Successfully Deleted");

            String s2 = "delete from stock_transfer_items  "
                    + " where receipt_no='" + to_stock_transfers.stock_transfer_no + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_stock_transfers.class, "Successfully Deleted");

            for (to_stock_transfer_items to_stock_transfer_items : items) {
                S1_items.to_items tt = S1_items.ret_data3(to_stock_transfer_items.barcode, to_stock_transfers.from_location_id);
                double new_qty = tt.product_qty + (FitIn.toDouble(to_stock_transfer_items.conversion) * to_stock_transfer_items.qty);
                String s4 = "update items set "
                        + "product_qty='" + new_qty + "',cost='" + to_stock_transfer_items.cost + "' "
                        + " where barcode = '" + to_stock_transfer_items.barcode + "' and location_id='" + to_stock_transfers.from_location_id + "' "
                        + "";
                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt4.execute();

                S1_items.to_items tt3 = S1_items.ret_data3(to_stock_transfer_items.barcode, to_stock_transfers.to_location_id);
                double new_qty3 = tt3.product_qty - (FitIn.toDouble(to_stock_transfer_items.conversion) * to_stock_transfer_items.qty);
                String s3 = "update items set "
                        + "product_qty='" + new_qty3 + "',cost='" + to_stock_transfer_items.cost + "' "
                        + " where barcode = '" + to_stock_transfer_items.barcode + "' and location_id='" + to_stock_transfers.to_location_id + "' "
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

    public static List<to_stock_transfers> ret_data(String where) {
        List<to_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",stock_transfer_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",remarks"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from stock_transfers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stock_transfer_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supplier_id = rs.getString(7);
                String remarks = rs.getString(8);
                int status = rs.getInt(9);
                String reference_no = rs.getString(10);
                String from_location_name = rs.getString(11);
                String from_location_id = rs.getString(12);
                String to_location_name = rs.getString(13);
                String to_location_id = rs.getString(14);

                to_stock_transfers to = new to_stock_transfers(id, stock_transfer_no, user_name, session_no, date_added, supplier, supplier_id, remarks, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
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
            String s0 = "select max(id) from stock_transfers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select stock_transfer_no from stock_transfers where id='" + id + "'";
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
}
