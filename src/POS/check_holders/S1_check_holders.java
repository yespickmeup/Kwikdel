/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.check_holders;

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
public class S1_check_holders {

    public static class to_check_holders {

        public final int id;
        public final String holder_name;
        public final String holder_no;

        public to_check_holders(int id, String holder_name, String holder_no) {
            this.id = id;
            this.holder_name = holder_name;
            this.holder_no = holder_no;
        }
    }

    public static void add_check_holders(to_check_holders to_check_holders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into check_holders("
                    + "holder_name"
                    + ",holder_no"
                    + ")values("
                    + ":holder_name"
                    + ",:holder_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("holder_name", to_check_holders.holder_name).
                    setString("holder_no", to_check_holders.holder_no).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_check_holders.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_check_holders(to_check_holders to_check_holders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update check_holders set "
                    + "holder_name= '" + to_check_holders.holder_name + "'"
                    + ",holder_no= '" + to_check_holders.holder_no + "'"
                    + "where "
                    + " id ='" + to_check_holders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_check_holders.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_check_holders(to_check_holders to_check_holders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from check_holders where "
                    + " id ='" + to_check_holders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_check_holders.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_check_holders> ret_data(String search) {
        List<to_check_holders> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",holder_name"
                    + ",holder_no"
                    + " from check_holders where "
                    + " holder_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String holder_name = rs.getString(2);
                String holder_no = rs.getString(3);

                to_check_holders to = new to_check_holders(id, holder_name, holder_no);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_check_holders ret_id_no(String search) {
        to_check_holders to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",holder_name"
                    + ",holder_no"
                    + " from check_holders where "
                    + " holder_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String holder_name = rs.getString(2);
                String holder_no = rs.getString(3);
                to1 = new to_check_holders(id, holder_name, holder_no);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
