/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.new_inventory;

import POS.main.Main;
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
public class S1_new_inventory {

    public static class to_new_inventory {

        public final int id;
        public final String user_name;
        public final String date_added;
        public final String new_inventory_no;
        public final int status;

        public to_new_inventory(int id, String user_name, String date_added, String new_inventory_no, int status) {
            this.id = id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.new_inventory_no = new_inventory_no;
            this.status = status;
        }
    }

    public static void add_new_inventory(to_new_inventory to_new_inventory) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into new_inventory("
                    + "user_name"
                    + ",date_added"
                    + ",new_inventory_no"
                    + ",status"
                    + ")values("
                    + ":user_name"
                    + ",:date_added"
                    + ",:new_inventory_no"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("user_name", to_new_inventory.user_name).
                    setString("date_added", to_new_inventory.date_added).
                    setString("new_inventory_no", to_new_inventory.new_inventory_no).
                    setNumber("status", to_new_inventory.status).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_inventory.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_new_inventory(to_new_inventory to_new_inventory) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update new_inventory set "
                    + "user_name= '" + to_new_inventory.user_name + "'"
                    + ",date_added= '" + to_new_inventory.date_added + "'"
                    + ",new_inventory_no= '" + to_new_inventory.new_inventory_no + "'"
                    + ",status= '" + to_new_inventory.status + "'"
                    + "where "
                    + " id ='" + to_new_inventory.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_inventory.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_new_inventory(to_new_inventory to_new_inventory) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from new_inventory where "
                    + " id ='" + to_new_inventory.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_new_inventory.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_new_inventory> ret_data(String date_from, String date_to) {
        List<to_new_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",date_added"
                    + ",new_inventory_no"
                    + ",status"
                    + " from new_inventory where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String date_added = rs.getString(3);
                String new_inventory_no = rs.getString(4);
                int status = rs.getInt(5);

                to_new_inventory to = new to_new_inventory(id, user_name, date_added, new_inventory_no, status);
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
        String ids = "NI-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from new_inventory";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "NI-00000000000";
            } else {
                String s2 = "select new_inventory_no from new_inventory where id='" + ids + "'";
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
