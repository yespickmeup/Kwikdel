/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.terms;

import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_terms {

    public static class to_terms {

        public final int id;
        public final int term_from;
        public final int term_to;

        public to_terms(int id, int term_from, int term_to) {
            this.id = id;
            this.term_from = term_from;
            this.term_to = term_to;
        }
    }

    public static void add_terms(to_terms to_terms) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  terms("
                    + "term_from"
                    + ",term_to"
                    + ")values("
                    + ":term_from"
                    + ",:term_to"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("term_from", to_terms.term_from).
                    setNumber("term_to", to_terms.term_to).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_terms.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_terms(to_terms to_terms) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  terms set "
                    + "term_from= :term_from"
                    + ",term_to= :term_to"
                    + " where "
                    + " id ='" + to_terms.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("term_from", to_terms.term_from).
                    setNumber("term_to", to_terms.term_to).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_terms.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_terms(to_terms to_terms) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  terms where "
                    + " id ='" + to_terms.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_terms.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_terms> ret_data(String search) {
        List<to_terms> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",term_from"
                    + ",term_to"
                    + " from  terms "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String s = "";
            while (rs.next()) {
                int id = rs.getInt(1);
                int term_from = rs.getInt(2);
                int term_to = rs.getInt(3);
                to_terms to = new to_terms(id, term_from, term_to);
                datas.add(to);
               
            }

         
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        String s = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select term_from,term_to from  terms";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String from = rs.getString(1);
                String to = rs.getString(2);
                s = to;
                datas.add(from);
            }
//            datas.add(s + " Over");
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
