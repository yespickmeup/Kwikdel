/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.discount_customers;

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
public class S1_discount_customers {

    public static class to_discount_customers {

        public final int id;
        public final String customer_name;
        public final String id_no;

        public to_discount_customers(int id, String customer_name, String id_no) {
            this.id = id;
            this.customer_name = customer_name;
            this.id_no = id_no;
        }
    }

    public static void add_discount_customers(to_discount_customers to_discount_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into discount_customers("
                    + "customer_name"
                    + ",id_no"
                    + ")values("
                    + ":customer_name"
                    + ",:id_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", to_discount_customers.customer_name).
                    setString("id_no", to_discount_customers.id_no).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discount_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_discount_customers(to_discount_customers to_discount_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update discount_customers set "
                    + "customer_name= '" + to_discount_customers.customer_name + "'"
                    + ",id_no= '" + to_discount_customers.id_no + "'"
                    + "where "
                    + " id ='" + to_discount_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discount_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_discount_customers(to_discount_customers to_discount_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from discount_customers where "
                    + " id ='" + to_discount_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discount_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_discount_customers> ret_data(String search) {
        List<to_discount_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers where "
                    + " customer_name like'%" + search + "%' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to_discount_customers to = new to_discount_customers(id, customer_name, id_no);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_discount_customers> ret_data2(String where) {
        List<to_discount_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to_discount_customers to = new to_discount_customers(id, customer_name, id_no);
                if(!customer_name.isEmpty()){
                    datas.add(to);
                }
                
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
            String s0 = "select customer_name from discount_customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_discount_customers ret_id_no(String customer) {
        to_discount_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers where "
                    + " customer_name like'%" + customer + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to1 = new to_discount_customers(id, customer_name, id_no);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
