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
public class S1_inv_sub_classifications {

    public static class to_inv_sub_classifications {

        public final int id;
        public final String category_id;
        public final String category_name;
        public final String classification_id;
        public final String classification_name;
        public final String sub_classification;

        public to_inv_sub_classifications(int id, String category_id, String category_name, String classification_id, String classification_name, String sub_classification) {
            this.id = id;
            this.category_id = category_id;
            this.category_name = category_name;
            this.classification_id = classification_id;
            this.classification_name = classification_name;
            this.sub_classification = sub_classification;
        }
    }

    public static void add_inv_sub_classifications(to_inv_sub_classifications to_inv_sub_classifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inv_sub_classifications("
                    + "category_id"
                    + ",category_name"
                    + ",classification_id"
                    + ",classification_name"
                    + ",sub_classification"
                    + ")values("
                    + ":category_id"
                    + ",:category_name"
                    + ",:classification_id"
                    + ",:classification_name"
                    + ",:sub_classification"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("category_id", to_inv_sub_classifications.category_id).
                    setString("category_name", to_inv_sub_classifications.category_name).
                    setString("classification_id", to_inv_sub_classifications.classification_id).
                    setString("classification_name", to_inv_sub_classifications.classification_name).
                    setString("sub_classification", to_inv_sub_classifications.sub_classification).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_sub_classifications.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inv_sub_classifications(to_inv_sub_classifications to_inv_sub_classifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inv_sub_classifications set "
                    + "category_id= '" + to_inv_sub_classifications.category_id + "'"
                    + ",category_name= '" + to_inv_sub_classifications.category_name + "'"
                    + ",classification_id= '" + to_inv_sub_classifications.classification_id + "'"
                    + ",classification_name= '" + to_inv_sub_classifications.classification_name + "'"
                    + ",sub_classification= '" + to_inv_sub_classifications.sub_classification + "'"
                    + "where "
                    + " id ='" + to_inv_sub_classifications.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_sub_classifications.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inv_sub_classifications(to_inv_sub_classifications to_inv_sub_classifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inv_sub_classifications where "
                    + " id ='" + to_inv_sub_classifications.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_sub_classifications.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_sub_classifications> ret_data(String sub_classifications, String classification_names) {
        List<to_inv_sub_classifications> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_id"
                    + ",category_name"
                    + ",classification_id"
                    + ",classification_name"
                    + ",sub_classification"
                    + " from inv_sub_classifications where "
                    + " sub_classification like'%" + sub_classifications + "%' "
                    + " and classification_name like'" + classification_names + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_id = rs.getString(2);
                String category_name = rs.getString(3);
                String classification_id = rs.getString(4);
                String classification_name = rs.getString(5);
                String sub_classification = rs.getString(6);

                to_inv_sub_classifications to = new to_inv_sub_classifications(id, category_id, category_name, classification_id, classification_name, sub_classification);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_sub_classifications> ret_where(String where) {
        List<to_inv_sub_classifications> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_id"
                    + ",category_name"
                    + ",classification_id"
                    + ",classification_name"
                    + ",sub_classification"
                    + " from inv_sub_classifications  "
                    + " "+where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_id = rs.getString(2);
                String category_name = rs.getString(3);
                String classification_id = rs.getString(4);
                String classification_name = rs.getString(5);
                String sub_classification = rs.getString(6);

                to_inv_sub_classifications to = new to_inv_sub_classifications(id, category_id, category_name, classification_id, classification_name, sub_classification);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data(String classification) {
        List<String> datas = new ArrayList();
        datas.add("");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select sub_classification from inv_sub_classifications where classification_name like '" + classification + "'";
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
