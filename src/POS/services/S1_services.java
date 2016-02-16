/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.services;

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
public class S1_services {

    public static class to_services {

        public final int id;
        public final String service_name;
        public final double amount;

        public to_services(int id, String service_name, double amount) {
            this.id = id;
            this.service_name = service_name;
            this.amount = amount;
        }
    }

    public static void add_services(to_services to_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into services("
                    + "service_name"
                    + ",amount"
                    + ")values("
                    + ":service_name"
                    + ",:amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("service_name", to_services.service_name).
                    setNumber("amount", to_services.amount).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_services.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_services(to_services to_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update services set "
                    + "service_name= '" + to_services.service_name + "'"
                    + ",amount= '" + to_services.amount + "'"
                    + "where "
                    + " id ='" + to_services.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_services.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_services(to_services to_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from services where "
                    + " id ='" + to_services.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_services.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_services> ret_data(String search) {
        List<to_services> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",service_name"
                    + ",amount"
                    + " from services where "
                    + " service_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String service_name = rs.getString(2);
                double amount = rs.getDouble(3);

                to_services to = new to_services(id, service_name, amount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_services> ret_data2(String where) {
        List<to_services> datas = new ArrayList();
        to_services to2 = new to_services(0, "", 0);
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",service_name"
                    + ",amount"
                    + " from services  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String service_name = rs.getString(2);
                double amount = rs.getDouble(3);

                to_services to = new to_services(id, service_name, amount);
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
            String s0 = "select service_name from services";
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

    public static to_services ret_data_to(String search) {
        to_services to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",service_name"
                    + ",amount"
                    + " from services where "
                    + " service_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String service_name = rs.getString(2);
                double amount = rs.getDouble(3);

                to1 = new to_services(id, service_name, amount);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
