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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_purchase_orders {

    public static class to_purchase_orders {

        public final int id;
        public final String po_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String remarks;

        public to_purchase_orders(int id, String po_no, String user_name, String session_no, String date_added, String remarks) {
            this.id = id;
            this.po_no = po_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.remarks = remarks;
        }
    }

    public static void add_purchase_orders(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into purchase_orders("
                    + "po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",remarks"
                    + ")values("
                    + ":po_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:remarks"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("po_no", to_purchase_orders.po_no).
                    setString("user_name", to_purchase_orders.user_name).
                    setString("session_no", to_purchase_orders.session_no).
                    setString("date_added", to_purchase_orders.date_added).
                    setString("remarks", to_purchase_orders.remarks).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_orders.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_purchase_orders(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update purchase_orders set "
                    + "po_no= '" + to_purchase_orders.po_no + "'"
                    + ",user_name= '" + to_purchase_orders.user_name + "'"
                    + ",session_no= '" + to_purchase_orders.session_no + "'"
                    + ",date_added= '" + to_purchase_orders.date_added + "'"
                    + ",remarks= '" + to_purchase_orders.remarks + "'"
                    + "where "
                    + " id ='" + to_purchase_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_orders.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_purchase_orders(to_purchase_orders to_purchase_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from purchase_orders where "
                    + " id ='" + to_purchase_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_purchase_orders.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_purchase_orders> ret_data(String date_from, String date_to) {
        List<to_purchase_orders> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",po_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",remarks"
                    + " from purchase_orders where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String po_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);

                to_purchase_orders to = new to_purchase_orders(id, po_no, user_name, session_no, date_added, remarks);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "PO-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from purchase_orders";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "PO-00000000001";
            } else {
                String s2 = "select po_no from purchase_orders where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }
            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
