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
public class S1_inv_classifications {

    public static class to_inv_classifications {

        public final int id;
        public final String category_id;
        public final String category_name;
        public final String classification;

        public to_inv_classifications(int id, String category_id, String category_name, String classification) {
            this.id = id;
            this.category_id = category_id;
            this.category_name = category_name;
            this.classification = classification;
        }
    }

    public static void add_inv_classifications(to_inv_classifications to_inv_classifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inv_classifications("
                    + "category_id"
                    + ",category_name"
                    + ",classification"
                    + ")values("
                    + ":category_id"
                    + ",:category_name"
                    + ",:classification"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("category_id", to_inv_classifications.category_id).
                    setString("category_name", to_inv_classifications.category_name).
                    setString("classification", to_inv_classifications.classification).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_classifications.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inv_classifications(to_inv_classifications to_inv_classifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inv_classifications set "
                    + "category_id= '" + to_inv_classifications.category_id + "'"
                    + ",category_name= '" + to_inv_classifications.category_name + "'"
                    + ",classification= '" + to_inv_classifications.classification + "'"
                    + "where "
                    + " id ='" + to_inv_classifications.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_classifications.class, "Successfully Updated");

            String s3 = "update inv_sub_classifications set "
                    + "classification_name= '" + to_inv_classifications.classification + "'"
                    + "where "
                    + " classification_id ='" + to_inv_classifications.id + "' "
                    + " ";

            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inv_classifications(to_inv_classifications to_inv_classifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inv_classifications where "
                    + " id ='" + to_inv_classifications.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_classifications.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_classifications> ret_data(String classifications, String category_names) {
        List<to_inv_classifications> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_id"
                    + ",category_name"
                    + ",classification"
                    + " from inv_classifications where "
                    + " classification like'%" + classifications + "%' "
                    + " and category_name ='" + category_names + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_id = rs.getString(2);
                String category_name = rs.getString(3);
                String classification = rs.getString(4);

                to_inv_classifications to = new to_inv_classifications(id, category_id, category_name, classification);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_classifications> ret_where(String where) {
        List<to_inv_classifications> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_id"
                    + ",category_name"
                    + ",classification"
                    + " from inv_classifications  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_id = rs.getString(2);
                String category_name = rs.getString(3);
                String classification = rs.getString(4);
                to_inv_classifications to = new to_inv_classifications(id, category_id, category_name, classification);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data(String category) {
        List<String> datas = new ArrayList();
        datas.add("");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select classification from inv_classifications where category_name like '" + category + "'";
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
