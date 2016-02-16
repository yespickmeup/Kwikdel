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
public class S1_sales_services {

    public static class to_sales_services {

        public final int id;
        public final String or_no;
        public final String service_name;
        public final double service_amount;
        public final String date_added;
        public final String user_name;
        public final int status;

        public to_sales_services(int id, String or_no, String service_name, double service_amount, String date_added, String user_name, int status) {
            this.id = id;
            this.or_no = or_no;
            this.service_name = service_name;
            this.service_amount = service_amount;
            this.date_added = date_added;
            this.user_name = user_name;
            this.status = status;
        }
    }

    public static void add_sales_services(List<to_sales_services> to_sales_services1, String sa) {
        try {
            Connection conn = MyConnection.connect();
            for (to_sales_services to_sales_services : to_sales_services1) {
                String s0 = "insert into sales_services("
                        + "or_no"
                        + ",service_name"
                        + ",service_amount"
                        + ",date_added"
                        + ",user_name"
                        + ",status"
                        + ")values("
                        + ":or_no"
                        + ",:service_name"
                        + ",:service_amount"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:status"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("or_no", sa).
                        setString("service_name", to_sales_services.service_name).
                        setNumber("service_amount", to_sales_services.service_amount).
                        setString("date_added", to_sales_services.date_added).
                        setString("user_name", to_sales_services.user_name).
                        setNumber("status", to_sales_services.status).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_sales_services.class, "Successfully Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sales_services(to_sales_services to_sales_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_services set "
                    + "or_no= '" + to_sales_services.or_no + "'"
                    + ",service_name= '" + to_sales_services.service_name + "'"
                    + ",service_amount= '" + to_sales_services.service_amount + "'"
                    + ",date_added= '" + to_sales_services.date_added + "'"
                    + ",user_name= '" + to_sales_services.user_name + "'"
                    + ",status= '" + to_sales_services.status + "'"
                    + "where "
                    + " id ='" + to_sales_services.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_services.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales_services(to_sales_services to_sales_services) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales_services where "
                    + " id ='" + to_sales_services.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_services.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_services> ret_data(String date_from, String date_to) {
        List<to_sales_services> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",or_no"
                    + ",service_name"
                    + ",service_amount"
                    + ",date_added"
                    + ",user_name"
                    + ",status"
                    + " from sales_services where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String or_no = rs.getString(2);
                String service_name = rs.getString(3);
                double service_amount = rs.getDouble(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                int status = rs.getInt(7);

                to_sales_services to = new to_sales_services(id, or_no, service_name, service_amount, date_added, user_name, status);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
