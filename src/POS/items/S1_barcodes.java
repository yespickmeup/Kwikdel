/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.main.Main;
import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_barcodes {

    public static class to_barcodes {

        public final int id;
        public final String barcode;

        public to_barcodes(int id, String barcode) {
            this.id = id;
            this.barcode = barcode;
        }
    }

    public static void add_barcodes(to_barcodes to_barcodes) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into barcodes("
                    + "barcode"
                    + ")values("
                    + ":barcode"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_barcodes.barcode).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_barcodes.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "CM0000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from barcodes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "CM0000000000";
            } else {
                String s2 = "select barcode from barcodes where id='" + ids + "'";
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

    public static void main(String[] args) {
        Main.MyDB.setNames("db_fnfo");
        System.out.println(increment_id());
    }
}
