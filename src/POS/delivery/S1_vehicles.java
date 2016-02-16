/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

import POS.delivery.S1_delivery_trucks.to_delivery_trucks;
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
public class S1_vehicles {

    public static class to_vehicles {

        public final int id;
        public final String vehicle_plate;
        public final String description;
        public final int is_active;
        public final String created;
        public final String modified;

        public to_vehicles(int id, String vehicle_plate, String description, int is_active, String created, String modified) {
            this.id = id;
            this.vehicle_plate = vehicle_plate;
            this.description = description;
            this.is_active = is_active;
            this.created = created;
            this.modified = modified;
        }
    }

    public static void main(String[] args) {
        List<to_vehicles> datas = ret_data("");
        for (to_vehicles to : datas) {
            to_delivery_trucks t = new to_delivery_trucks(0, to.description, to.vehicle_plate);
            S1_delivery_trucks.add_delivery_trucks(t);
        }
    }

    public static List<to_vehicles> ret_data(String where) {
        List<to_vehicles> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "id"
                    + ",vehicle_plate"
                    + ",description"
                    + ",is_active"
                    + ",created"
                    + ",modified"
                    + " from vehicles  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String vehicle_plate = rs.getString(2);
                String description = rs.getString(3);
                int is_active = rs.getInt(4);
                String created = rs.getString(5);
                String modified = rs.getString(6);
                System.out.println(vehicle_plate);
                to_vehicles to = new to_vehicles(id, vehicle_plate, description, is_active, created, modified);
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
