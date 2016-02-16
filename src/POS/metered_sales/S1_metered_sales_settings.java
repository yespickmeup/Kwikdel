/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

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
 * @author Ronald
 */
public class S1_metered_sales_settings {

    public static class to_metered_sales_settings {

        public final int id;
        public final String name;
        public final double rate;

        public to_metered_sales_settings(int id, String name, double rate) {
            this.id = id;
            this.name = name;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        to_metered_sales_settings to = new to_metered_sales_settings(2, "", 67.72);
        add_metered_sales_settings(to);
    }

    public static void add_metered_sales_settings(to_metered_sales_settings to_metered_sales_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into metered_sales_settings("
                    + "name"
                    + ",rate"
                    + ")values("
                    + ":name"
                    + ",:rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_metered_sales_settings.name)
                    .setNumber("rate", to_metered_sales_settings.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_settings.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_metered_sales_settings(to_metered_sales_settings to_metered_sales_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update metered_sales_settings set "
                    + "name= :name"
                    + ",rate= :rate"
                    + " where "
                    + " id ='" + to_metered_sales_settings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_metered_sales_settings.name)
                    .setNumber("rate", to_metered_sales_settings.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_settings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_metered_sales_settings2(to_metered_sales_settings to_metered_sales_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update metered_sales_settings set "
                    + "name= :name"
                    + ",rate= :rate"
                    + " where "
                    + " id ='" + to_metered_sales_settings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_metered_sales_settings.name)
                    .setNumber("rate", to_metered_sales_settings.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_settings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_metered_sales_settings(to_metered_sales_settings to_metered_sales_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from metered_sales_settings where "
                    + " id ='" + to_metered_sales_settings.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_settings.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_metered_sales_settings> ret_data(String where) {
        List<to_metered_sales_settings> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",rate"
                    + " from metered_sales_settings  "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);

                to_metered_sales_settings to = new to_metered_sales_settings(id, name, rate);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_metered_sales_settings ret_data2(String where) {
        to_metered_sales_settings to = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",rate"
                    + " from metered_sales_settings  "
                    + " "+where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);

                to = new to_metered_sales_settings(id, name, rate);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
