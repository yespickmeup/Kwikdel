/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_delivery_report {
//    "Trans #", "Customer", "Vehicle", "Driver", "Status", "Amount", "N", "R", "I", "D", "C", " ",

    public final List<Srpt_delivery_report.field> fields;
    public final String business_name;
    public final String address;
    public final String date;

    public Srpt_delivery_report(String business_name, String address, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
    }

    public static class field {

        String transaction_no;
        String date;
        String customer;
        String vehicle;
        String driver;
        String status;
        double amount;

        public field() {
        }

        public field(String transaction_no, String date, String customer, String vehicle, String driver, String status, double amount) {
            this.transaction_no = transaction_no;
            this.date = date;
            this.customer = customer;
            this.vehicle = vehicle;
            this.driver = driver;
            this.status = status;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public String getVehicle() {
            return vehicle;
        }

        public void setVehicle(String vehicle) {
            this.vehicle = vehicle;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        String where = " where status>1 ";
        List<Srpt_delivery_report.field> fields = Srpt_delivery_report.ret_data2(where);
        List<Srpt_delivery_report.field> fields2 = Srpt_delivery_report.ret_sales(where);
        fields.addAll(fields2);
        String business_name = "";
        String address = "";
        String date = "";
        Srpt_delivery_report rpt = new Srpt_delivery_report(business_name, address, date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_delivery_report.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_delivery_report.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_delivery_report to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_delivery_report.field> ret_sales(String where) {
        List<Srpt_delivery_report.field> datas = new ArrayList();

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
                String statuses = "ASDASDASDDA";
                if (status == 5) {
                    statuses = "New";
                }
                if (status == 6) {
                    statuses = "Ready";
                }
                if (status == 7) {
                    statuses = "In-Transit";
                }
                if (status == 8) {
                    statuses = "Delivered";
                }
                if (status == 9) {
                    statuses = "Cancelled";
                }
                String date = DateType.convert_slash_datetime(date_added);
                double total = amount_due + service_amount;
                if (charge_status == 0) {
                    Srpt_delivery_report.field field = new field(sales_no, date, customer_name, vehicle_name, driver_name, statuses, total);
                    datas.add(field);
                }

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_delivery_report.field> ret_data2(String where) {
        List<Srpt_delivery_report.field> datas = new ArrayList();

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

                String statuses = "ASDASDASDDA";
                if (status == 5) {
                    statuses = "New";
                }
                if (status == 6) {
                    statuses = "Ready";
                }
                if (status == 7) {
                    statuses = "In-Transit";
                }
                if (status == 8) {
                    statuses = "Delivered";
                }
                if (status == 9) {
                    statuses = "Cancelled";
                }

                String date = DateType.convert_slash_datetime(date_added);
                double total = amount_due + service_amount;

                Srpt_delivery_report.field field = new field(sales_no, date, customer_name, vehicle_name, driver_name, statuses, total);
                datas.add(field);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
