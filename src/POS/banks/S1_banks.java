/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.banks;

import POS.main.Main.MyDB;
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
 * @author Maytopacka
 */
public class S1_banks {

    public static class to_banks {

        public final int id;
        public final String bank_name;

        public to_banks(int id, String bank_name) {
            this.id = id;
            this.bank_name = bank_name;
        }
    }

    public static void add_banks(to_banks to_banks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into banks("
                    + "bank_name"
                    + ")values("
                    + ":bank_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("bank_name", to_banks.bank_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_banks.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_banks(to_banks to_banks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update banks set "
                    + "bank_name= '" + to_banks.bank_name + "'"
                    + "where "
                    + " id ='" + to_banks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_banks.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_banks(to_banks to_banks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from banks where "
                    + " id ='" + to_banks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_banks.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_banks> ret_data(String search) {
        List<to_banks> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",bank_name"
                    + " from banks where "
                    + " bank_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String bank_name = rs.getString(2);

                to_banks to = new to_banks(id, bank_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_banks> ret_data2(String where) {
        List<to_banks> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",bank_name"
                    + " from banks  "
                    + " "+where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String bank_name = rs.getString(2);

                to_banks to = new to_banks(id, bank_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select bank_name from banks";
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
