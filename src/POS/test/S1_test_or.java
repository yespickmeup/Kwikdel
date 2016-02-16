/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_test_or {

    public static class to_test_or {

        public final int id;
        public final String or_no;

        public to_test_or(int id, String or_no) {
            this.id = id;
            this.or_no = or_no;
        }
    }

    public static void add_test_or(to_test_or to_test_or) {
        String or = S1_test_or.increment_id();
        boolean exists = false;
        try {
            Connection conn = MyConnection.connect();
            String s2 = "select "
                    + "id"
                    + ",or_no"
                    + " from test_or where "
                    + " or_no ='" + or + "' order by id desc limit 1"
                    + " ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            if (rs.next()) {
                exists = true;
            }

            if (exists == false) {
                String s0 = "insert into test_or("
                        + "or_no"
                        + ")values("
                        + ":or_no"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("or_no", or)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(increment_id());
    }

    public static String increment_id() {
        String ids = "0000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from test_or";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "0000";
            } else {
                String s2 = "select or_no from test_or where id='" + ids + "'";
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
}
