/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Ronald
 */
public class S3_suppliers {

    public static class to_product_category {

        public final int PRODUCT_CATEGORY_ID;
        public final String NAME;
        public final String CREATED;
        public final String MODIFIED;

        public to_product_category(int PRODUCT_CATEGORY_ID, String NAME, String CREATED, String MODIFIED) {
            this.PRODUCT_CATEGORY_ID = PRODUCT_CATEGORY_ID;
            this.NAME = NAME;
            this.CREATED = CREATED;
            this.MODIFIED = MODIFIED;
        }
    }

    public static void main(String[] args) {
        ret_data("");
    }
    public static List<to_product_category> ret_data(String where) {
        List<to_product_category> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "PRODUCT_CATALOG_ID"
                    + ",name"
                    + ",CREATED"
                    + ",MODIFIED"
                    + " from overall_pos_db.product_catalog "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int PRODUCT_CATEGORY_ID = rs.getInt(1);
                String NAME = rs.getString(2);
                String CREATED = rs.getString(3);
                String MODIFIED = rs.getString(4);

                String s2 = "insert into db_coop.suppliers("
                        + "supplier"
                        + ",contact_no"
                        + ",address"
                        + ")values("
                        + ":supplier"
                        + ",:contact_no"
                        + ",:address"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("supplier", NAME)
                        .setString("contact_no", "")
                        .setString("address", "")
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(S1_suppliers.class, "Successfully Added " + " "+NAME);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
