/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.locations;

import POS.items.S1_items;
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
 * @author Guinness
 */
public class S1_locations {

    public static class to_locations {

        public final int id;
        public final String name;
        public final int is_default;

        public to_locations(int id, String name, int is_default) {
            this.id = id;
            this.name = name;
            this.is_default = is_default;
        }
    }

    public static void main(String[] args) {
        to_locations def_location = get_default_location();
        System.out.println(def_location.name);
        System.out.println(last_id());
    }

    public static int last_id() {
        int id = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from locations ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data(to_locations to_locations) {
        try {
            Connection conn = MyConnection.connect();

            to_locations def_location = get_default_location();

            String s0 = "insert into locations("
                    + "name"
                    + ",is_default"
                    + ")values("
                    + ":name"
                    + ",:is_default"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_locations.name)
                    .setNumber("is_default", to_locations.is_default)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_locations.class, "Successfully Added");
            int last_id = S1_locations.last_id();

            String where = " where location_id='" + def_location.id + "' ";
            List<S1_items.to_items> items = S1_items.ret_where(where);
            for (S1_items.to_items to_items : items) {
                String s3 = "insert into items("
                        + "barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",supplier"
                        + ",fixed_price"
                        + ",cost"
                        + ",supplier_id"
                        + ",multi_level_pricing"
                        + ",vatable"
                        + ",reorder_level"
                        + ",location_name"
                        + ",location_id"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:location_name"
                        + ",:location_id"
                        + ")";
                s3 = SqlStringUtil.parse(s3).
                        setString("barcode", to_items.barcode).
                        setString("description", to_items.description).
                        setString("generic_name", to_items.generic_name).
                        setString("category", to_items.category).
                        setString("category_id", to_items.category_id).
                        setString("classification", to_items.classification).
                        setString("classification_id", to_items.classification_id).
                        setString("sub_classification", to_items.sub_classification).
                        setString("sub_classification_id", to_items.sub_classification_id).
                        setNumber("product_qty",0).
                        setString("unit", to_items.unit).
                        setNumber("conversion", to_items.conversion).
                        setNumber("selling_price", to_items.selling_price).
                        setString("date_added", to_items.date_added).
                        setString("user_name", to_items.user_name).
                        setString("item_type", to_items.item_type).
                        setNumber("status", to_items.status).
                        setString("supplier", to_items.supplier).
                        setNumber("fixed_price", to_items.fixed_price).
                        setNumber("cost", to_items.cost).
                        setString("supplier_id", to_items.supplier).
                        setNumber("multi_level_pricing", to_items.multi_level_pricing).
                        setNumber("vatable", to_items.vatable).
                        setNumber("reorder_level", to_items.reorder_level).
                        setString("location_name", to_locations.name).
                        setString("location_id", "" + last_id).
                        ok();

                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();
                Lg.s(S1_items.class, "Successfully Added Item: " + to_items.description);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_locations to_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update locations set "
                    + "name= :name "
                    + ",is_default= :is_default "
                    + " where id='" + to_locations.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_locations.name)
                    .setNumber("is_default", to_locations.is_default)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_locations.class, "Successfully Updated");

            String s2 = "update items set "
                    + "location_name= :location_name "
                    + " where location_id='" + to_locations.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("location_name", to_locations.name)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_locations.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void set_default(to_locations to_locations, int is_default) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update locations set "
                    + "is_default= :is_default "
                    + " where id='" + to_locations.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("is_default", is_default)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_locations.class, "Successfully Updated");

            String s2 = "update locations set "
                    + "is_default= :is_default "
                    + " where id<>'" + to_locations.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("is_default", 0)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_locations.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_locations to_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from locations  "
                    + " where id='" + to_locations.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_locations.class, "Successfully Deleted");

            String s2 = "delete from items  "
                    + " where location_id='" + to_locations.id + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_locations.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_locations> ret_data(String where) {
        List<to_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",is_default"
                    + " from locations"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int is_default = rs.getInt(3);

                to_locations to = new to_locations(id, name, is_default);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_locations get_default_location() {
        to_locations to = null;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",is_default"
                    + " from locations"
                    + " where is_default='" + "1" + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int is_default = rs.getInt(3);
                to = new to_locations(id, name, is_default);
            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
