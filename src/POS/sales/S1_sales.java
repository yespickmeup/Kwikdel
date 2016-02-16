/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.items.S1_items;
import POS.sales.S1_sales_items.to_sales_items;
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
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_sales {

    public static class to_sales {

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
        public boolean selected;
        public final String time_delivered;
        public final String time_received;
        public final String customer_address;
        public final String customer_contact_no;
        public final int charge_status;
        public final int is_sales;

        public to_sales(int id, String sales_no, String date_added, String user_name, String session_no, double gross_amount, double amount_paid, double amount_due, String discount_name, double discount, double discount_amount, String customer_name, String check_bank, String check_no, double check_amount, String discount_customer_name, String discount_customer_id, int status, String or_no, String check_holder, String services, double service_amount, String customer_id, String transaction_type, String transaction_type_id, String payment_type, String payment_type_id, String vehicle_name, String vehicle_id, String driver_name, String driver_id, boolean selected, String time_delivered, String time_received, String customer_address, String customer_contact_no, int charge_status, int is_sales) {
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
            this.selected = selected;
            this.time_delivered = time_delivered;
            this.time_received = time_received;
            this.customer_address = customer_address;
            this.customer_contact_no = customer_contact_no;
            this.charge_status = charge_status;
            this.is_sales = is_sales;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_sales(to_sales to_sales, String sa) {
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
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
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
                    .setNumber("charge_status", to_sales.charge_status)
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

    public static void edit_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set "
                    + "sales_no= :sales_no"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",session_no= :session_no"
                    + ",gross_amount= :gross_amount"
                    + ",amount_paid= :amount_paid"
                    + ",amount_due= :amount_due"
                    + ",discount_name= :discount_name"
                    + ",discount= :discount"
                    + ",discount_amount= :discount_amount"
                    + ",customer_name= :customer_name"
                    + ",check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",check_amount= :check_amount"
                    + ",discount_customer_name= :discount_customer_name"
                    + ",discount_customer_id= :discount_customer_id"
                    + ",status= :status"
                    + ",or_no= :or_no"
                    + ",check_holder= :check_holder"
                    + ",services= :services"
                    + ",service_amount= :service_amount"
                    + ",customer_id= :customer_id"
                    + ",transaction_type= :transaction_type"
                    + ",transaction_type_id= :transaction_type_id"
                    + ",payment_type= :payment_type"
                    + ",payment_type_id= :payment_type_id"
                    + ",vehicle_name= :vehicle_name"
                    + ",vehicle_id= :vehicle_id"
                    + ",driver_name= :driver_name"
                    + ",driver_id= :driver_id"
                    + ",customer_address= :customer_address"
                    + ",customer_contact_no= :customer_contact_no"
                    + ",charge_status= :charge_status"
                    + " where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sales.sales_no)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", to_sales.or_no)
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
                    .setNumber("charge_status", to_sales.charge_status)
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

    public static void delete_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales2(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Deleted");
            String s2 = "delete from sales_items where "
                    + " sales_no ='" + to_sales.sales_no + "' "
                    + " ";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_sales_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data(String date_from, String date_to, String user_names) {
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
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + user_names + "%' "
                    + " ";

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
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, false, time_delivered, time_received, customer_address, customer_contact_no, charge_status, 1);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_or(String date_from, String date_to, String or_nos) {
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
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and or_no like '%" + or_nos + "%' "
                    + " ";

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
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, false, time_delivered, time_received, customer_address, customer_contact_no, charge_status, 1);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data(String where) {
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
                    + ",customer_contact_no "
                    + ",charge_status"
                    + " from sales  "
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
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, false, time_delivered, time_received, customer_address, customer_contact_no, charge_status, 1);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_dr(String where) {
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
                    + ",customer_contact_no "
                    + ",charge_status"
                    + " from sales  "
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
                if (!session_no.startsWith("DR")) {
                    to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, false, time_delivered, time_received, customer_address, customer_contact_no, charge_status, 1);
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

    public static String check_or_if_exists(String or_no) {
        boolean exist = true;
        try {
            Connection conn = MyConnection.connect();

            while (exist == true) {
                String s0 = "select "
                        + " sales_no"
                        + " from sales  "
                        + " where or_no='" + or_no + "' order by id desc limit 1";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                    exist = false;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
        return "";

    }

    public static void main(String[] args) {
        String or = increment_id();

    }

    public static String increment_id() {
        String ids = "00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from sales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "SN-00000000001";
            } else {
                String s2 = "select sales_no from sales where id='" + ids + "'";
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

    public static int count_sales() {
        int count = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select count(id) from sales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void void_sales(to_sales to_sales, int status, List<to_sales_items> items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set "
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

            String s2 = "update sales_items set "
                    + "status= :status"
                    + " where "
                    + " sales_no ='" + to_sales.sales_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", status)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_sales_items.class, "Successfully Updated");

            for (to_sales_items it : items) {
                S1_items.to_items tt = S1_items.ret_data2(it.barcode, it.location_id);

                double new_qty = tt.product_qty - (it.conversion * it.product_qty);
                if (status == 1) {
                    new_qty = tt.product_qty + (it.conversion * it.product_qty);
                }
                String s3 = "update items set "
                        + "product_qty='" + new_qty + "' "
                        + " where barcode = '" + it.barcode + "' and location_id='" + it.location_id + "' "
                        + "";
                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void void_sales2(to_sales to_sales, int status, List<to_sales_items> items) {
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

            String s2 = "update sales_dr_items set "
                    + "status= :status"
                    + " where "
                    + " sales_no ='" + to_sales.sales_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", status)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_sales_items.class, "Successfully Updated");

            for (to_sales_items it : items) {
                System.out.println("Barcode: " + it.barcode);
                S1_items.to_items tt = S1_items.ret_data2(it.barcode, it.location_id);
//                JOptionPane.showMessageDialog(null, ""+it.barcode + " "+tt.product_qty);
                double new_qty = tt.product_qty - (it.conversion * it.product_qty);
                if (status == 1) {
                    new_qty = tt.product_qty + (it.conversion * it.product_qty);
                }
                String s3 = "update items set "
                        + "product_qty='" + new_qty + "' "
                        + " where barcode = '" + it.barcode + "' and location_id='" + it.location_id + "'"
                        + "";
                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_status(to_sales to_sales, int status) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set "
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

    public static void edit_sales_delivery(String id, String discount_name, double discount, double discount_amount, String discount_customer_name, String discount_customer_id, String customer_id, String vehicle_name, String vehicle_id, String driver_name, String driver_id, String time_delivered, String time_received, String customer_name, String customer_address, String customer_contact_no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set "
                    + "discount_name= :discount_name"
                    + ",discount= :discount"
                    + ",discount_amount= :discount_amount"
                    + ",discount_customer_name= :discount_customer_name"
                    + ",discount_customer_id= :discount_customer_id"
                    + ",customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",vehicle_name= :vehicle_name"
                    + ",vehicle_id= :vehicle_id"
                    + ",driver_name= :driver_name"
                    + ",driver_id= :driver_id"
                    + ",time_delivered= :time_delivered"
                    + ",time_received= :time_received"
                    + ",customer_address= :customer_address"
                    + ",customer_contact_no= :customer_contact_no"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("discount_name", discount_name)
                    .setNumber("discount", discount)
                    .setNumber("discount_amount", discount_amount)
                    .setString("discount_customer_name", discount_customer_name)
                    .setString("discount_customer_id", discount_customer_id)
                    .setString("customer_id", customer_id)
                    .setString("customer_name", customer_name)
                    .setString("vehicle_name", vehicle_name)
                    .setString("vehicle_id", vehicle_id)
                    .setString("driver_name", driver_name)
                    .setString("driver_id", driver_id)
                    .setString("time_delivered", time_delivered)
                    .setString("time_received", time_received)
                    .setString("customer_address", customer_address)
                    .setString("customer_contact_no", customer_contact_no)
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

    public static void edit_sales_delivery3(String id, String discount_name, double discount, double discount_amount, String discount_customer_name, String discount_customer_id, String customer_id, String vehicle_name, String vehicle_id, String driver_name, String driver_id, String time_delivered, String time_received, String customer_name, String customer_address, String customer_contact_no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_dr set "
                    + "discount_name= :discount_name"
                    + ",discount= :discount"
                    + ",discount_amount= :discount_amount"
                    + ",discount_customer_name= :discount_customer_name"
                    + ",discount_customer_id= :discount_customer_id"
                    + ",customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",vehicle_name= :vehicle_name"
                    + ",vehicle_id= :vehicle_id"
                    + ",driver_name= :driver_name"
                    + ",driver_id= :driver_id"
                    + ",time_delivered= :time_delivered"
                    + ",time_received= :time_received"
                    + ",customer_address= :customer_address"
                    + ",customer_contact_no= :customer_contact_no"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("discount_name", discount_name)
                    .setNumber("discount", discount)
                    .setNumber("discount_amount", discount_amount)
                    .setString("discount_customer_name", discount_customer_name)
                    .setString("discount_customer_id", discount_customer_id)
                    .setString("customer_id", customer_id)
                    .setString("customer_name", customer_name)
                    .setString("vehicle_name", vehicle_name)
                    .setString("vehicle_id", vehicle_id)
                    .setString("driver_name", driver_name)
                    .setString("driver_id", driver_id)
                    .setString("time_delivered", time_delivered)
                    .setString("time_received", time_received)
                    .setString("customer_address", customer_address)
                    .setString("customer_contact_no", customer_contact_no)
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

    public static void edit_sales_delivery2(List<to_sales> datas, String vehicle_id, String vehicle_name, String driver_id, String driver_name, String time_delivered) {
        try {
            Connection conn = MyConnection.connect();
            for (to_sales sales : datas) {

                time_delivered = DateType.datetime.format(new Date());
                System.out.println("S2 " + time_delivered);
                if (sales.is_sales == 1) {
                    String s0 = "update sales set "
                            + "vehicle_name= :vehicle_name"
                            + ",vehicle_id= :vehicle_id"
                            + ",driver_name= :driver_name"
                            + ",driver_id= :driver_id"
                            + ",time_delivered= :time_delivered"
                            + " where "
                            + " id ='" + sales.id + "' "
                            + " ";
                    s0 = SqlStringUtil.parse(s0)
                            .setString("vehicle_name", vehicle_name)
                            .setString("vehicle_id", vehicle_id)
                            .setString("driver_name", driver_name)
                            .setString("driver_id", driver_id)
                            .setString("time_delivered", time_delivered)
                            .ok();
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S1_sales.class, "Successfully Updated");
                } else {
                    String s0 = "update sales_dr set "
                            + "vehicle_name= :vehicle_name"
                            + ",vehicle_id= :vehicle_id"
                            + ",driver_name= :driver_name"
                            + ",driver_id= :driver_id"
                            + ",time_delivered= :time_delivered"
                            + " where "
                            + " id ='" + sales.id + "' "
                            + " ";
                    s0 = SqlStringUtil.parse(s0)
                            .setString("vehicle_name", vehicle_name)
                            .setString("vehicle_id", vehicle_id)
                            .setString("driver_name", driver_name)
                            .setString("driver_id", driver_id)
                            .setString("time_delivered", time_delivered)
                            .ok();
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S1_sales.class, "Successfully Updated");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void charge_payment(String id, double check_amount, String check_bank, String check_no) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update sales set "
                    + " check_bank= :check_bank"
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

            PreparedStatement stmt1 = conn.prepareStatement(s0);
            stmt1.addBatch(s0);

            stmt1.executeBatch();
            conn.commit();
            Lg.s(S1_sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
