/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir_session;

import POS.main.Main;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;

/**
 *
 * @author Maytopacka
 */
public class S1_bir_session {
    public static String increment_id() {
        String ids = "0000000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from " + "db_bir" + ".bir_sales_ors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "0000000000000000";
            } else {
                String s2 = "select orno from " + "db_bir" + ".bir_sales_ors where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
