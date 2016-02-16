/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.expenses;

import POS.main.Main.MyDB;
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
 * @author Maytopacka
 */
public class S1_expenses {

    public static class to_expenses {

        public final int id;
        public final String expense_name;

        public to_expenses(int id, String expense_name) {
            this.id = id;
            this.expense_name = expense_name;
        }
    }

    public static void add_expenses(to_expenses to_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into expenses("
                    + "expense_name"
                    + ")values("
                    + ":expense_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("expense_name", to_expenses.expense_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_expenses(to_expenses to_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update expenses set "
                    + "expense_name= '" + to_expenses.expense_name + "'"
                    + "where "
                    + " id ='" + to_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_expenses(to_expenses to_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from expenses where "
                    + " id ='" + to_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_expenses> ret_data(String search) {
        List<to_expenses> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",expense_name"
                    + " from expenses where "
                    + " expense_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String expense_name = rs.getString(2);

                to_expenses to = new to_expenses(id, expense_name);
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

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select expense_name from expenses";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
