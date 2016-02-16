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
public class S1_delivery_trucks {

    public static class to_delivery_trucks {

        public final int id;
        public final String description;
        public final String plate_no;

        public to_delivery_trucks(int id, String description, String plate_no) {
            this.id = id;
            this.description = description;
            this.plate_no = plate_no;
        }
    }

    public static void add_delivery_trucks(to_delivery_trucks to_delivery_trucks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into delivery_trucks("
                    + "description"
                    + ",plate_no"
                    + ")values("
                    + ":description"
                    + ",:plate_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_delivery_trucks.description)
                    .setString("plate_no", to_delivery_trucks.plate_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_delivery_trucks.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_delivery_trucks(to_delivery_trucks to_delivery_trucks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update delivery_trucks set "
                    + "description= :description"
                    + ",plate_no= :plate_no"
                    + " where "
                    + " id ='" + to_delivery_trucks.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_delivery_trucks.description)
                    .setString("plate_no", to_delivery_trucks.plate_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_delivery_trucks.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_delivery_trucks(to_delivery_trucks to_delivery_trucks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from delivery_trucks where "
                    + " id ='" + to_delivery_trucks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_delivery_trucks.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_delivery_trucks> ret_data(String where) {
        List<to_delivery_trucks> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",description"
                    + ",plate_no"
                    + " from delivery_trucks  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String description = rs.getString(2);
                String plate_no = rs.getString(3);

                to_delivery_trucks to = new to_delivery_trucks(id, description, plate_no);
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
