/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category;

import POS.main.Main.MyDB;
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
public class S1_inv_categories {

    public static class to_inv_categories {

        public final int id;
        public final String category;

        public to_inv_categories(int id, String category) {
            this.id = id;
            this.category = category;
        }
    }

    public static void add_inv_categories(to_inv_categories to_inv_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inv_categories("
                    + "category"
                    + ")values("
                    + ":category"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("category", to_inv_categories.category).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_categories.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inv_categories(to_inv_categories to_inv_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inv_categories set "
                    + "category= '" + to_inv_categories.category + "'"
                    + "where "
                    + " id ='" + to_inv_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_categories.class, "Successfully Updated");

            String s1 = "update inv_classifications set "
                    + "category_name= '" + to_inv_categories.category + "'"
                    + "where "
                    + " category_id ='" + to_inv_categories.id + "' "
                    + " ";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            String s3 = "update inv_sub_classifications set "
                    + "category_name= '" + to_inv_categories.category + "'"
                    + "where "
                    + " category_id ='" + to_inv_categories.id + "' "
                    + " ";

            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inv_categories(to_inv_categories to_inv_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inv_categories where "
                    + " id ='" + to_inv_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_categories.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_categories> ret_data(String search) {
        List<to_inv_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category"
                    + " from inv_categories where "
                    + " category like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category = rs.getString(2);

                to_inv_categories to = new to_inv_categories(id, category);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_categories> ret_where(String where) {
        List<to_inv_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category"
                    + " from inv_categories "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category = rs.getString(2);

                to_inv_categories to = new to_inv_categories(id, category);
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
            String s0 = "select category from inv_categories order by category asc";
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
            String s0 = "select category from inv_categories order by category asc";
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
}
