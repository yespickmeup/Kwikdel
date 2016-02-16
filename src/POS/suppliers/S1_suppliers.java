/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.suppliers;

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
 * @author Maytopacka
 */
public class S1_suppliers {

    public static class to_suppliers {

        public final int id;
        public final String supplier;
        public final String contact_no;
        public final String address;

        public to_suppliers(int id, String supplier, String contact_no, String address) {
            this.id = id;
            this.supplier = supplier;
            this.contact_no = contact_no;
            this.address = address;
        }
    }

    public static void add_suppliers(to_suppliers to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into suppliers("
                    + "supplier"
                    + ",contact_no"
                    + ",address"
                    + ")values("
                    + ":supplier"
                    + ",:contact_no"
                    + ",:address"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("supplier", to_suppliers.supplier).
                    setString("contact_no", to_suppliers.contact_no).
                    setString("address", to_suppliers.address).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_suppliers to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update suppliers set "
                    + "supplier= :supplier "
                    + ",contact_no= :contact_no "
                    + ",address= :address "
                    + " where id='" + to_suppliers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("supplier", to_suppliers.supplier)
                    .setString("contact_no", to_suppliers.contact_no)
                    .setString("address", to_suppliers.address)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_suppliers to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update suppliers set "
                    + "supplier= :supplier "
                    + ",contact_no= :contact_no "
                    + ",address= :address "
                    + " where id='" + to_suppliers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("supplier", to_suppliers.supplier)
                    .setString("contact_no", to_suppliers.contact_no)
                    .setString("address", to_suppliers.address)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_suppliers(to_suppliers to_suppliers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from suppliers where "
                    + " id ='" + to_suppliers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_suppliers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_suppliers> ret_data(String search) {
        List<to_suppliers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",supplier"
                    + ",contact_no"
                    + ",address"
                    + " from suppliers where "
                    + " supplier like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String supplier = rs.getString(2);
                String contact_no = rs.getString(3);
                String address = rs.getString(4);

                to_suppliers to = new to_suppliers(id, supplier, contact_no, address);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        datas.add("");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select supplier from suppliers order by supplier asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data_report() {
        List<String> datas = new ArrayList();
        datas.add("ALL");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select supplier from suppliers order by supplier asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_suppliers> ret_where(String where) {
        List<to_suppliers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",supplier"
                    + ",contact_no"
                    + ",address"
                    + " from suppliers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String supplier = rs.getString(2);
                String contact_no = rs.getString(3);
                String address = rs.getString(4);

                to_suppliers to = new to_suppliers(id, supplier, contact_no, address);
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
