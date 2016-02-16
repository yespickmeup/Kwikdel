/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_metered_sales_payments {

    public static class to_metered_sales_payments {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String user_id;
        public final String user_name;
        public final String date_added;
        public final String or_no;
        public final double amount_due;
        public final double cash;
        public final double check_amount;
        public final String check_bank;
        public final String check_no;
        public final int status;
        public final String metered_sales_ids;

        public to_metered_sales_payments(int id, String customer_id, String customer_name, String user_id, String user_name, String date_added, String or_no, double amount_due, double cash, double check_amount, String check_bank, String check_no, int status, String metered_sales_ids) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.user_id = user_id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.or_no = or_no;
            this.amount_due = amount_due;
            this.cash = cash;
            this.check_amount = check_amount;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.status = status;
            this.metered_sales_ids = metered_sales_ids;
        }
    }

    public static void add_metered_sales_payments(to_metered_sales_payments to_metered_sales_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into metered_sales_payments("
                    + "customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",or_no"
                    + ",amount_due"
                    + ",cash"
                    + ",check_amount"
                    + ",check_bank"
                    + ",check_no"
                    + ",status"
                    + ",metered_sales_ids"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:user_id"
                    + ",:user_name"
                    + ",:date_added"
                    + ",:or_no"
                    + ",:amount_due"
                    + ",:cash"
                    + ",:check_amount"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:status"
                    + ",:metered_sales_ids"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_metered_sales_payments.customer_id)
                    .setString("customer_name", to_metered_sales_payments.customer_name)
                    .setString("user_id", to_metered_sales_payments.user_id)
                    .setString("user_name", to_metered_sales_payments.user_name)
                    .setString("date_added", to_metered_sales_payments.date_added)
                    .setString("or_no", to_metered_sales_payments.or_no)
                    .setNumber("amount_due", to_metered_sales_payments.amount_due)
                    .setNumber("cash", to_metered_sales_payments.cash)
                    .setNumber("check_amount", to_metered_sales_payments.check_amount)
                    .setString("check_bank", to_metered_sales_payments.check_bank)
                    .setString("check_no", to_metered_sales_payments.check_no)
                    .setNumber("status", to_metered_sales_payments.status)
                    .setString("metered_sales_ids", to_metered_sales_payments.metered_sales_ids)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_payments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_metered_sales_payments(to_metered_sales_payments to_metered_sales_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update metered_sales_payments set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",user_id= :user_id"
                    + ",user_name= :user_name"
                    + ",date_added= :date_added"
                    + ",or_no= :or_no"
                    + ",amount_due= :amount_due"
                    + ",cash= :cash"
                    + ",check_amount= :check_amount"
                    + ",check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",status= :status"
                    + ",metered_sales_ids= :metered_sales_ids"
                    + " where "
                    + " id ='" + to_metered_sales_payments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_metered_sales_payments.customer_id)
                    .setString("customer_name", to_metered_sales_payments.customer_name)
                    .setString("user_id", to_metered_sales_payments.user_id)
                    .setString("user_name", to_metered_sales_payments.user_name)
                    .setString("date_added", to_metered_sales_payments.date_added)
                    .setString("or_no", to_metered_sales_payments.or_no)
                    .setNumber("amount_due", to_metered_sales_payments.amount_due)
                    .setNumber("cash", to_metered_sales_payments.cash)
                    .setNumber("check_amount", to_metered_sales_payments.check_amount)
                    .setString("check_bank", to_metered_sales_payments.check_bank)
                    .setString("check_no", to_metered_sales_payments.check_no)
                    .setNumber("status", to_metered_sales_payments.status)
                    .setString("metered_sales_ids", to_metered_sales_payments.metered_sales_ids)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_payments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_metered_sales_payments(to_metered_sales_payments to_metered_sales_payments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from metered_sales_payments where "
                    + " id ='" + to_metered_sales_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_metered_sales_payments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_metered_sales_payments> ret_data(String where) {
        List<to_metered_sales_payments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",or_no"
                    + ",amount_due"
                    + ",cash"
                    + ",check_amount"
                    + ",check_bank"
                    + ",check_no"
                    + ",status"
                    + ",metered_sales_ids"
                    + " from metered_sales_payments  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String or_no = rs.getString(7);
                double amount_due = rs.getDouble(8);
                double cash = rs.getDouble(9);
                double check_amount = rs.getDouble(10);
                String check_bank = rs.getString(11);
                String check_no = rs.getString(12);
                int status = rs.getInt(13);
                String metered_sales_ids = rs.getString(14);

                to_metered_sales_payments to = new to_metered_sales_payments(id, customer_id, customer_name, user_id, user_name, date_added, or_no, amount_due, cash, check_amount, check_bank, check_no, status, metered_sales_ids);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from metered_sales_payments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select or_no from metered_sales_payments where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
