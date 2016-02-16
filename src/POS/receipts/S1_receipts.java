/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

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
 * @author Maytopacka
 */
public class S1_receipts {

    public static class to_receipts {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String date_delivered;
        public final String date_received;
        public final int status;
        public final String reference_no;
        public final String from_location_name;
        public final String from_location_id;
        public final String to_location_name;
        public final String to_location_id;

        public to_receipts(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id
                , String remarks, String date_delivered, String date_received, int status, String reference_no
                , String from_location_name, String from_location_id, String to_location_name, String to_location_id) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.date_delivered = date_delivered;
            this.date_received = date_received;
            this.status = status;
            this.reference_no = reference_no;
            this.from_location_name = from_location_name;
            this.from_location_id = from_location_id;
            this.to_location_name = to_location_name;
            this.to_location_id = to_location_id;

        }
    }

    public static void add_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into receipts("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
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
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:status"
                    + ",:reference_no"
                    + ",:from_location_name"
                    + ",:from_location_id"
                    + ",:to_location_name"
                    + ",:to_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_no", to_receipts.receipt_no).
                    setString("user_name", to_receipts.user_name).
                    setString("session_no", to_receipts.session_no).
                    setString("date_added", to_receipts.date_added).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setNumber("status", to_receipts.status).
                    setString("reference_no", to_receipts.reference_no).
                    setString("from_location_name", to_receipts.from_location_name).
                    setString("from_location_id", to_receipts.from_location_id).
                    setString("to_location_name", to_receipts.to_location_name).
                    setString("to_location_id", to_receipts.to_location_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipts set "
                    + "receipt_no= '" + to_receipts.receipt_no + "'"
                    + ",user_name= '" + to_receipts.user_name + "'"
                    + ",session_no= '" + to_receipts.session_no + "'"
                    + ",date_added= '" + to_receipts.date_added + "'"
                    + ",supplier= '" + to_receipts.supplier + "'"
                    + ",supllier_id= '" + to_receipts.supllier_id + "'"
                    + ",remarks= '" + to_receipts.remarks + "'"
                    + ",date_delivered= '" + to_receipts.date_delivered + "'"
                    + ",date_received= '" + to_receipts.date_received + "'"
                    + ",status= '" + to_receipts.status + "' "
                    + ",reference_no= '" + to_receipts.reference_no + "' "
                    + ",from_location_name= '" + to_receipts.from_location_name + "' "
                    + ",from_location_id= '" + to_receipts.from_location_id + "' "
                    + ",to_location_name= '" + to_receipts.to_location_name + "' "
                    + ",to_location_id= '" + to_receipts.to_location_id + "' "
                    + " where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipts.class, "Successfully Updated");

            String s2 = "update receipt_items set "
                    + "supplier= :supplier "
                    + ",supllier_id= :supllier_id "
                    + ",remarks= :remarks "
                    + ",date_delivered= :date_delivered "
                    + ",date_received= :date_received "
                    + ",reference_no= :reference_no "
                    + ",from_location_name= :from_location_name "
                    + ",from_location_id= :from_location_id "
                    + ",to_location_name= :to_location_name "
                    + ",to_location_id= :to_location_id "
                    + " where receipt_no='" + to_receipts.receipt_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("supplier", to_receipts.supplier)
                    .setString("supllier_id", to_receipts.supllier_id)
                    .setString("remarks", to_receipts.remarks)
                    .setString("date_delivered", to_receipts.date_delivered)
                    .setString("date_received", to_receipts.date_received)
                    .setString("reference_no", to_receipts.reference_no)
                    .setString("from_location_name", to_receipts.from_location_name)
                    .setString("from_location_id", to_receipts.from_location_id)
                    .setString("to_location_name", to_receipts.to_location_name)
                    .setString("to_location_id", to_receipts.to_location_id)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from receipts where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipts.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data(String search) {
        List<to_receipts> datas = new ArrayList();

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
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipts where "
                    + " receipt_no like'%" + search + "%' "
                    + " ";

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
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                int status = rs.getInt(11);
                String reference_no = rs.getString(12);
                String from_location_name = rs.getString(13);
                String from_location_id = rs.getString(14);
                String to_location_name = rs.getString(15);
                String to_location_id = rs.getString(16);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received
                        , status, reference_no, from_location_name, from_location_name, to_location_name, to_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data2(String search, String date_from, String date_to) {
        List<to_receipts> datas = new ArrayList();

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
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipts where "
                    + " date(date_received) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

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
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                int status = rs.getInt(11);
                String reference_no = rs.getString(12);
                String from_location_name = rs.getString(13);
                String from_location_id = rs.getString(14);
                String to_location_name = rs.getString(15);
                String to_location_id = rs.getString(16);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, status, reference_no, from_location_name, from_location_name, to_location_name, to_location_id);
                datas.add(to);
            }
//            System.out.println(datas.size());
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "RN-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from receipts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "RN-00000000001";
            } else {
                String s2 = "select receipt_no from receipts where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_where(String where) {
        List<to_receipts> datas = new ArrayList();

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
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipts"
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
                String date_delivered = rs.getString(9);
                String date_received = rs.getString(10);
                int status = rs.getInt(11);
                String reference_no = rs.getString(12);
                String from_location_name = rs.getString(13);
                String from_location_id = rs.getString(14);
                String to_location_name = rs.getString(15);
                String to_location_id = rs.getString(16);
                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, status, reference_no, from_location_name, from_location_name, to_location_name, to_location_id);
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
