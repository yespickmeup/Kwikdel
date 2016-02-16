/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.items.S1_items.to_items;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S3_items {

    public static class to_product {

        public final int PRODUCT_ID;
        public final String LOOKUP_CODE;
        public final String DESCRIPTION;
        public final int IS_ACTIVE;
        public final String CREATED;
        public final String MODIFIED;
        public final String S_DESCRIPTION;
        public final int IS_TRANSIENT;

        public to_product(int PRODUCT_ID, String LOOKUP_CODE, String DESCRIPTION, int IS_ACTIVE, String CREATED, String MODIFIED, String S_DESCRIPTION, int IS_TRANSIENT) {
            this.PRODUCT_ID = PRODUCT_ID;
            this.LOOKUP_CODE = LOOKUP_CODE;
            this.DESCRIPTION = DESCRIPTION;
            this.IS_ACTIVE = IS_ACTIVE;
            this.CREATED = CREATED;
            this.MODIFIED = MODIFIED;
            this.S_DESCRIPTION = S_DESCRIPTION;
            this.IS_TRANSIENT = IS_TRANSIENT;
        }
    }

    public static void main(String[] args) {
        ret_data("");
    }

    public static List<to_product> ret_data(String where) {
        List<to_product> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "lookup_code"
                    + ",description"
                    + ",reorder"
                    + ",cost"
                    + ",measured_in"
                    + ",category"
                    + ",catalog"
                    + ",price"
                    + " from overall_pos_db.product_inv_view  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String lookup_code = rs.getString(1);
                String description = rs.getString(2);
                double reorder = rs.getDouble(3);
                double cost = rs.getDouble(4);
                String measure_in = rs.getString(5);
                String category = rs.getString(6);
                String catalog = rs.getString(7);
                double price = rs.getInt(8);

                System.out.println(lookup_code + " " + description + " " + cost + " " + measure_in + " " + category + " " + catalog + " " + price);

                String s2 = "insert into db_coop.items("
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
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("barcode", lookup_code)
                        .setString("description", description)
                        .setString("generic_name", "")
                        .setString("category", category)
                        .setString("category_id", "")
                        .setString("classification", "")
                        .setString("classification_id", "")
                        .setString("sub_classification", "")
                        .setString("sub_classification_id", "")
                        .setNumber("product_qty", 0)
                        .setString("unit", measure_in)
                        .setNumber("conversion", 1)
                        .setNumber("selling_price", price)
                        .setString("date_added", DateType.datetime.format(new Date()))
                        .setString("user_name", "")
                        .setString("item_type", "")
                        .setNumber("status", 1)
                        .setString("supplier", catalog)
                        .setNumber("fixed_price", 0)
                        .setNumber("cost", cost)
                        .setString("supplier_id", "")
                        .setNumber("multi_level_pricing", 0)
                        .setNumber("vatable", 0)
                        .setNumber("reorder_level", reorder)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(S1_items.class, "Successfully Added : " + lookup_code + " " + description + " : " + price);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void inactive() {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update items set "
                    + "status= :status"
                    + " where "
                    + " status ='" + "1" + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 0)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void active(String id,int active) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update items set "
                    + "status= :status"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", active)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
