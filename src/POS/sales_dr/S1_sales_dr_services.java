/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales_dr;

import POS.services.S1_sales_services;
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
public class S1_sales_dr_services {

    public static class to_sales_dr_services {

        public final int id;
        public final String or_no;
        public final String service_name;
        public final double service_amount;
        public final String date_added;
        public final String user_name;
        public final int status;
        public final String session_no;

        public to_sales_dr_services(int id, String or_no, String service_name, double service_amount, String date_added, String user_name, int status, String session_no) {
            this.id = id;
            this.or_no = or_no;
            this.service_name = service_name;
            this.service_amount = service_amount;
            this.date_added = date_added;
            this.user_name = user_name;
            this.status = status;
            this.session_no = session_no;
        }
    }

    public static void add_sales_dr_services(List<S1_sales_services.to_sales_services> to_sales_services1, String sa) {
        try {
            Connection conn = MyConnection.connect();

            for (S1_sales_services.to_sales_services to_sales_dr_services : to_sales_services1) {
                String s0 = "insert into sales_dr_services("
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

                s0 = SqlStringUtil.parse(s0)
                        .setString("or_no", to_sales_dr_services.or_no)
                        .setString("service_name", to_sales_dr_services.service_name)
                        .setNumber("service_amount", to_sales_dr_services.service_amount)
                        .setString("date_added", to_sales_dr_services.date_added)
                        .setString("user_name", to_sales_dr_services.user_name)
                        .setNumber("status", to_sales_dr_services.status)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_sales_dr_services.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_dr_services> ret_data(String where) {
        List<to_sales_dr_services> datas = new ArrayList();

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
                    + ",session_no"
                    + " from sales_dr_services  "
                    + " " + where;

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
                String session_no = rs.getString(8);

                to_sales_dr_services to = new to_sales_dr_services(id, or_no, service_name, service_amount, date_added, user_name, status, session_no);
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
