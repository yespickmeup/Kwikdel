/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales_dr;

import POS.sales.S1_sales;
import POS.sales.S1_sales.to_sales;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_sales_dr {

    public static class to_sales_dr {

        public final int id;
        public final String sales_no;
        public final String date_added;
        public final String user_name;
        public final String session_no;
        public final double gross_amount;
        public final double amount_paid;
        public final double amount_due;
        public final String discount_name;
        public final double discount;
        public final double discount_amount;
        public final String customer_name;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final int status;
        public final String or_no;
        public final String check_holder;
        public final String services;
        public final double service_amount;
        public final String customer_id;
        public final String transaction_type;
        public final String transaction_type_id;
        public final String payment_type;
        public final String payment_type_id;
        public final String vehicle_name;
        public final String vehicle_id;
        public final String driver_name;
        public final String driver_id;
        public final String time_delivered;
        public final String time_received;
        public final String customer_address;
        public final String customer_contact_no;
        public final int charge_status;

        public to_sales_dr(int id, String sales_no, String date_added, String user_name, String session_no, double gross_amount, double amount_paid, double amount_due, String discount_name, double discount, double discount_amount, String customer_name, String check_bank, String check_no, double check_amount, String discount_customer_name, String discount_customer_id, int status, String or_no, String check_holder, String services, double service_amount, String customer_id, String transaction_type, String transaction_type_id, String payment_type, String payment_type_id, String vehicle_name, String vehicle_id, String driver_name, String driver_id, String time_delivered, String time_received, String customer_address, String customer_contact_no, int charge_status) {
            this.id = id;
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.session_no = session_no;
            this.gross_amount = gross_amount;
            this.amount_paid = amount_paid;
            this.amount_due = amount_due;
            this.discount_name = discount_name;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.customer_name = customer_name;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.status = status;
            this.or_no = or_no;
            this.check_holder = check_holder;
            this.services = services;
            this.service_amount = service_amount;
            this.customer_id = customer_id;
            this.transaction_type = transaction_type;
            this.transaction_type_id = transaction_type_id;
            this.payment_type = payment_type;
            this.payment_type_id = payment_type_id;
            this.vehicle_name = vehicle_name;
            this.vehicle_id = vehicle_id;
            this.driver_name = driver_name;
            this.driver_id = driver_id;
            this.time_delivered = time_delivered;
            this.time_received = time_received;
            this.customer_address = customer_address;
            this.customer_contact_no = customer_contact_no;
            this.charge_status = charge_status;
        }
    }

    public static void add_sales_dr(to_sales to_sales_dr, String sa) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sales_dr("
                    + "sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",transaction_type"
                    + ",transaction_type_id"
                    + ",payment_type"
                    + ",payment_type_id"
                    + ",vehicle_name"
                    + ",vehicle_id"
                    + ",driver_name"
                    + ",driver_id"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:gross_amount"
                    + ",:amount_paid"
                    + ",:amount_due"
                    + ",:discount_name"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:customer_name"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:status"
                    + ",:or_no"
                    + ",:check_holder"
                    + ",:services"
                    + ",:service_amount"
                    + ",:customer_id"
                    + ",:transaction_type"
                    + ",:transaction_type_id"
                    + ",:payment_type"
                    + ",:payment_type_id"
                    + ",:vehicle_name"
                    + ",:vehicle_id"
                    + ",:driver_name"
                    + ",:driver_id"
                    + ",:customer_address"
                    + ",:customer_contact_no"
                    + ",:charge_status"
                    + ")";
            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", sa)
                    .setString("date_added", to_sales_dr.date_added)
                    .setString("user_name", to_sales_dr.user_name)
                    .setString("session_no", to_sales_dr.session_no)
                    .setNumber("gross_amount", to_sales_dr.gross_amount)
                    .setNumber("amount_paid", to_sales_dr.amount_paid)
                    .setNumber("amount_due", to_sales_dr.amount_due)
                    .setString("discount_name", to_sales_dr.discount_name)
                    .setNumber("discount", to_sales_dr.discount)
                    .setNumber("discount_amount", to_sales_dr.discount_amount)
                    .setString("customer_name", to_sales_dr.customer_name)
                    .setString("check_bank", to_sales_dr.check_bank)
                    .setString("check_no", to_sales_dr.check_no)
                    .setNumber("check_amount", to_sales_dr.check_amount)
                    .setString("discount_customer_name", to_sales_dr.discount_customer_name)
                    .setString("discount_customer_id", to_sales_dr.discount_customer_id)
                    .setNumber("status", to_sales_dr.status)
                    .setString("or_no", sa)
                    .setString("check_holder", to_sales_dr.check_holder)
                    .setString("services", to_sales_dr.services)
                    .setNumber("service_amount", to_sales_dr.service_amount)
                    .setString("customer_id", to_sales_dr.customer_id)
                    .setString("transaction_type", to_sales_dr.transaction_type)
                    .setString("transaction_type_id", to_sales_dr.transaction_type_id)
                    .setString("payment_type", to_sales_dr.payment_type)
                    .setString("payment_type_id", to_sales_dr.payment_type_id)
                    .setString("vehicle_name", to_sales_dr.vehicle_name)
                    .setString("vehicle_id", to_sales_dr.vehicle_id)
                    .setString("driver_name", to_sales_dr.driver_name)
                    .setString("driver_id", to_sales_dr.driver_id)
                    .setString("customer_address", to_sales_dr.customer_address)
                    .setString("customer_contact_no", to_sales_dr.customer_contact_no)
                    .setNumber("charge_status", to_sales_dr.charge_status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_dr.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_dr> ret_data(String where) {
        List<to_sales_dr> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",transaction_type"
                    + ",transaction_type_id"
                    + ",payment_type"
                    + ",payment_type_id"
                    + ",vehicle_name"
                    + ",vehicle_id"
                    + ",driver_name"
                    + ",driver_id"
                    + ",time_delivered"
                    + ",time_received"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + " from sales_dr "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String customer_id = rs.getString(23);
                String transaction_type = rs.getString(24);
                String transaction_type_id = rs.getString(25);
                String payment_type = rs.getString(26);
                String payment_type_id = rs.getString(27);
                String vehicle_name = rs.getString(28);
                String vehicle_id = rs.getString(29);
                String driver_name = rs.getString(30);
                String driver_id = rs.getString(31);
                String time_delivered = rs.getString(32);
                String time_received = rs.getString(33);
                String customer_address = rs.getString(34);
                String customer_contact_no = rs.getString(35);
                int charge_status = rs.getInt(36);

                to_sales_dr to = new to_sales_dr(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, time_delivered, time_received, customer_address, customer_contact_no, charge_status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data2(String where) {
        List<to_sales> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",transaction_type"
                    + ",transaction_type_id"
                    + ",payment_type"
                    + ",payment_type_id"
                    + ",vehicle_name"
                    + ",vehicle_id"
                    + ",driver_name"
                    + ",driver_id"
                    + ",time_delivered"
                    + ",time_received"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + " from sales_dr "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String customer_id = rs.getString(23);
                String transaction_type = rs.getString(24);
                String transaction_type_id = rs.getString(25);
                String payment_type = rs.getString(26);
                String payment_type_id = rs.getString(27);
                String vehicle_name = rs.getString(28);
                String vehicle_id = rs.getString(29);
                String driver_name = rs.getString(30);
                String driver_id = rs.getString(31);
                String time_delivered = rs.getString(32);
                String time_received = rs.getString(33);
                String customer_address = rs.getString(34);
                String customer_contact_no = rs.getString(35);
                int charge_status = rs.getInt(36);

                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, false, time_delivered, time_received, customer_address, customer_contact_no, charge_status, 0);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(increment_id());
    }

    public static String increment_id() {
        String ids = "DR-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from sales_dr";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "DR-00000000001";
            } else {
                String s2 = "select sales_no from sales_dr where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }
            ids = ReceiptIncrementor.increment(ids);
//            boolean exist = false;
//            do {
//                String s2 = "select "
//                        + " sales_no"
//                        + " from sales  "
//                        + " where or_no='" + ids + "' order by id desc limit 1";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs.next()) {
//                    ids = ReceiptIncrementor.increment(rs2.getString(1));
//                    exist = false;
//                }
//            } while (exist == true);
            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void charge_payment(String id, double check_amount, String check_bank, String check_no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_dr set "
                    + "check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",check_amount= :check_amount"
                    + ",charge_status= :charge_status"
                    + ",date_added= :date_added"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("check_bank", check_bank)
                    .setString("check_no", check_no)
                    .setNumber("check_amount", check_amount)
                    .setNumber("charge_status", 1)
                    .setString("date_added", DateType.datetime.format(new Date()))
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_status(to_sales to_sales, int status) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_dr set "
                    + "status= :status"
                    + " where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_sales(to_sales to_sales, String sa, double check_amount, String bank, String check_no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sales("
                    + "sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",transaction_type"
                    + ",transaction_type_id"
                    + ",payment_type"
                    + ",payment_type_id"
                    + ",vehicle_name"
                    + ",vehicle_id"
                    + ",driver_name"
                    + ",driver_id"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:gross_amount"
                    + ",:amount_paid"
                    + ",:amount_due"
                    + ",:discount_name"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:customer_name"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:status"
                    + ",:or_no"
                    + ",:check_holder"
                    + ",:services"
                    + ",:service_amount"
                    + ",:customer_id"
                    + ",:transaction_type"
                    + ",:transaction_type_id"
                    + ",:payment_type"
                    + ",:payment_type_id"
                    + ",:vehicle_name"
                    + ",:vehicle_id"
                    + ",:driver_name"
                    + ",:driver_id"
                    + ",:customer_address"
                    + ",:customer_contact_no"
                    + ",:charge_status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", sa)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.or_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", bank)
                    .setString("check_no", check_no)
                    .setNumber("check_amount", check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", sa)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("services", to_sales.services)
                    .setNumber("service_amount", to_sales.service_amount)
                    .setString("customer_id", to_sales.customer_id)
                    .setString("transaction_type", to_sales.transaction_type)
                    .setString("transaction_type_id", to_sales.transaction_type_id)
                    .setString("payment_type", to_sales.payment_type)
                    .setString("payment_type_id", to_sales.payment_type_id)
                    .setString("vehicle_name", to_sales.vehicle_name)
                    .setString("vehicle_id", to_sales.vehicle_id)
                    .setString("driver_name", to_sales.driver_name)
                    .setString("driver_id", to_sales.driver_id)
                    .setString("customer_address", to_sales.customer_address)
                    .setString("customer_contact_no", to_sales.customer_contact_no)
                    .setNumber("charge_status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
