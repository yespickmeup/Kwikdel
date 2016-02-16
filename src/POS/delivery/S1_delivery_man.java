/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

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
public class S1_delivery_man {

    public static class to_delivery_man {

        public final int id;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String contact_no;
        public final String address;

        public to_delivery_man(int id, String fname, String mi, String lname, String contact_no, String address) {
            this.id = id;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.contact_no = contact_no;
            this.address = address;
        }
    }

    public static void add_delivery_man(to_delivery_man to_delivery_man) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into delivery_man("
                    + "fname"
                    + ",mi"
                    + ",lname"
                    + ",contact_no"
                    + ",address"
                    + ")values("
                    + ":fname"
                    + ",:mi"
                    + ",:lname"
                    + ",:contact_no"
                    + ",:address"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("fname", to_delivery_man.fname)
                    .setString("mi", to_delivery_man.mi)
                    .setString("lname", to_delivery_man.lname)
                    .setString("contact_no", to_delivery_man.contact_no)
                    .setString("address", to_delivery_man.address)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_delivery_man.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_delivery_man(to_delivery_man to_delivery_man) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update delivery_man set "
                    + "fname= :fname"
                    + ",mi= :mi"
                    + ",lname= :lname"
                    + ",contact_no= :contact_no"
                    + ",address= :address"
                    + " where "
                    + " id ='" + to_delivery_man.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("fname", to_delivery_man.fname)
                    .setString("mi", to_delivery_man.mi)
                    .setString("lname", to_delivery_man.lname)
                    .setString("contact_no", to_delivery_man.contact_no)
                    .setString("address", to_delivery_man.address)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_delivery_man.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_delivery_man(to_delivery_man to_delivery_man) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from delivery_man where "
                    + " id ='" + to_delivery_man.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_delivery_man.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_delivery_man> ret_data(String where) {
        List<to_delivery_man> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",fname"
                    + ",mi"
                    + ",lname"
                    + ",contact_no"
                    + ",address"
                    + " from delivery_man  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String mi = rs.getString(3);
                String lname = rs.getString(4);
                String contact_no = rs.getString(5);
                String address = rs.getString(6);

                to_delivery_man to = new to_delivery_man(id, fname, mi, lname, contact_no, address);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
