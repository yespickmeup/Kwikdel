/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.discounts;

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
 * @author i1
 */
public class S1_discounts {

    public static class to_discounts {

        public final int id;
        public final String discount_name;
        public final double discount_rate;

        public to_discounts(int id, String discount_name, double discount_rate) {
            this.id = id;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
        }
    }

    public static void add_discounts(to_discounts to_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into discounts("
                    + "discount_name"
                    + ",discount_rate"
                    + ")values("
                    + ":discount_name"
                    + ",:discount_rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("discount_name", to_discounts.discount_name).
                    setNumber("discount_rate", to_discounts.discount_rate).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discounts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_discounts(to_discounts to_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update discounts set "
                    + "discount_name= '" + to_discounts.discount_name + "'"
                    + ",discount_rate= '" + to_discounts.discount_rate + "'"
                    + "where "
                    + " id ='" + to_discounts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discounts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_discounts(to_discounts to_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from discounts where "
                    + " id ='" + to_discounts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discounts.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_discounts> ret_data(String search) {
        List<to_discounts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",discount_name"
                    + ",discount_rate"
                    + " from discounts where "
                    + " discount_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String discount_name = rs.getString(2);
                double discount_rate = rs.getDouble(3);

                to_discounts to = new to_discounts(id, discount_name, discount_rate);
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

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select discount_name from discounts";
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

    public static to_discounts ret_data2(String search) {
        to_discounts to1 = null;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",discount_name"
                    + ",discount_rate"
                    + " from discounts where discount_name like '" + search + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String discount_name = rs.getString(2);
                double discount_rate = rs.getDouble(3);

                to1 = new to_discounts(id, discount_name, discount_rate);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_discounts> ret_data3(String where) {
        List<to_discounts> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",discount_name"
                    + ",discount_rate"
                    + " from discounts "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String discount_name = rs.getString(2);
                double discount_rate = rs.getDouble(3);

                to_discounts to1 = new to_discounts(id, discount_name, discount_rate);
                datas.add(to1);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
