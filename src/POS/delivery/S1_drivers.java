/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class S1_drivers {

    public static class to_drivers {

        public final int id;
        public final String driver_id;
        public final String first_name;
        public final String last_name;
        public final String mi;
        public final String address;
        public final String contact;
        public final int is_active;
        public final String created;
        public final String modified;

        public to_drivers(int id, String driver_id, String first_name, String last_name, String mi, String address, String contact, int is_active, String created, String modified) {
            this.id = id;
            this.driver_id = driver_id;
            this.first_name = first_name;
            this.last_name = last_name;
            this.mi = mi;
            this.address = address;
            this.contact = contact;
            this.is_active = is_active;
            this.created = created;
            this.modified = modified;
        }
    }

    public static void main(String[] args) {
        List<to_drivers> datas = ret_data2("");
        for (to_drivers to : datas) {
            int id = -1;
            String fname = to.first_name;
            String mi = to.mi;
            String lname = to.last_name;
            String contact_no = to.contact;
            String address = to.address;
            S1_delivery_man.to_delivery_man t = new S1_delivery_man.to_delivery_man(id, fname, mi, lname, contact_no, address);
            S1_delivery_man.add_delivery_man(t);
        }
    }

    public static List<to_drivers> ret_data2(String where) {
        List<to_drivers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "id"
                    + ",driver_id"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",address"
                    + ",contact"
                    + ",is_active"
                    + ",created"
                    + ",modified"
                    + " from drivers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String driver_id = rs.getString(2);
                String first_name = rs.getString(3);
                String last_name = rs.getString(4);
                String mi = rs.getString(5);
                String address = rs.getString(6);
                String contact = rs.getString(7);
                int is_active = rs.getInt(8);
                String created = rs.getString(9);
                String modified = rs.getString(10);
                System.out.println(first_name);
                to_drivers to = new to_drivers(id, driver_id, first_name, last_name, mi, address, contact, is_active, created, modified);
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
