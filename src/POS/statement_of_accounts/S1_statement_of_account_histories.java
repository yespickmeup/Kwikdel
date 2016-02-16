/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.statement_of_accounts;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_statement_of_account_histories {

    public static class to_statement_of_account_histories {

        public final int id;
        public final String soa_id;
        public final double qty;
        public final String date_added;

        public to_statement_of_account_histories(int id, String soa_id, double qty, String date_added) {
            this.id = id;
            this.soa_id = soa_id;
            this.qty = qty;
            this.date_added = date_added;
        }
    }

    public static void add_statement_of_account_histories(to_statement_of_account_histories to_statement_of_account_histories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into statement_of_account_histories("
                    + "soa_id"
                    + ",qty"
                    + ",date_added"
                    + ")values("
                    + ":soa_id"
                    + ",:qty"
                    + ",:date_added"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("soa_id", to_statement_of_account_histories.soa_id)
                    .setNumber("qty", to_statement_of_account_histories.qty)
                    .setString("date_added", to_statement_of_account_histories.date_added)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_histories.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_statement_of_account_histories(to_statement_of_account_histories to_statement_of_account_histories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update statement_of_account_histories set "
                    + "soa_id= :soa_id"
                    + ",qty= :qty"
                    + ",date_added= :date_added"
                    + " where "
                    + " id ='" + to_statement_of_account_histories.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("soa_id", to_statement_of_account_histories.soa_id)
                    .setNumber("qty", to_statement_of_account_histories.qty)
                    .setString("date_added", to_statement_of_account_histories.date_added)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_histories.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_statement_of_account_histories(to_statement_of_account_histories to_statement_of_account_histories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from statement_of_account_histories where "
                    + " id ='" + to_statement_of_account_histories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_account_histories.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_statement_of_account_histories> ret_data(String where) {
        List<to_statement_of_account_histories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",soa_id"
                    + ",qty"
                    + ",date_added"
                    + " from statement_of_account_histories  "
                    + " "+where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String soa_id = rs.getString(2);
                double qty = rs.getDouble(3);
                String date_added = rs.getString(4);
                to_statement_of_account_histories to = new to_statement_of_account_histories(id, soa_id, qty, date_added);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
