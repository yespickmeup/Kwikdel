/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_sales_ledger {

    public final List<Srpt_sales_ledger.field> fields;
    public final String business_name;
    public final String address;
    public final String date;

    public final double walkin_sales;
    public final double delivered_sales;
    public final double new_delivery;
    public final double intransit;
    public final double delivered;
    public final double cancelled;
    public final double ready;
    public final double walkin_receivables;
    public final double delivery_receivables;

    public Srpt_sales_ledger(String business_name, String address, String date, double walkin_sales, double delivered_sales, double new_delivery, double intransit, double delivered, double cancelled, double ready, double walkin_receivables, double delivery_receivables) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.walkin_sales = walkin_sales;
        this.delivered_sales = delivered_sales;
        this.new_delivery = new_delivery;
        this.intransit = intransit;
        this.delivered = delivered;
        this.cancelled = cancelled;
        this.ready = ready;
        this.walkin_receivables = walkin_receivables;
        this.delivery_receivables = delivery_receivables;
    }

    public static class field {

        String sales_no;
        double amount_due;
        double discount;
        double check_amount;
        String transaction_type;
        String customer_name;
        String status;
        double service;
        int charge_status;
        int payment_type_id;
        String date;

        public field() {
        }

        public field(String sales_no, double amount_due, double discount, double check_amount, String transaction_type, String customer_name, String status, double service, int charge_status, int payment_type_id, String date) {
            this.sales_no = sales_no;
            this.amount_due = amount_due;
            this.discount = discount;
            this.check_amount = check_amount;
            this.transaction_type = transaction_type;
            this.customer_name = customer_name;
            this.status = status;
            this.service = service;
            this.charge_status = charge_status;
            this.payment_type_id = payment_type_id;
            this.date = date;
        }

        public int getCharge_status() {
            return charge_status;
        }

        public void setCharge_status(int charge_status) {
            this.charge_status = charge_status;
        }

        public int getPayment_type_id() {
            return payment_type_id;
        }

        public void setPayment_type_id(int payment_type_id) {
            this.payment_type_id = payment_type_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getService() {
            return service;
        }

        public void setService(double service) {
            this.service = service;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

    public static void main(String[] args) {

        List<Srpt_sales_ledger.field> datas = ret_data("");
        String business_name = System.getProperty("business_name", "Kwekdel");
        String address = System.getProperty("address", "Dumaguete City");

        String date = "Date: " + DateType.month_date.format(new Date());
        String printed_by = "Administrator";

        double walkin_sales = 0;
        double delivered_sales = 0;
        double new_delivery = 0;
        double intransit = 0;
        double delivered = 0;
        double cancelled = 0;
        double ready = 0;
        double walkin_receivables = 0;
        double delivery_receivables = 0;

        for (Srpt_sales_ledger.field t : datas) {
            double cash = (t.amount_due + t.service) - t.check_amount;
            double check = t.check_amount;
            double total = cash + check;
            double amount_due = (t.amount_due + t.service) - t.discount;
            if (t.status.equals("")) {
                if (t.payment_type_id == 2) {
                    walkin_receivables += amount_due;
                } else {
                    walkin_sales += amount_due;
                }

            } else {
                if (t.payment_type_id == 2) {
                    delivery_receivables += amount_due;
                } else {
                    delivered_sales += amount_due;
                }
                if (t.status.equals("New")) {
                    new_delivery += amount_due;

                }
                if (t.status.equals("Intransit")) {
                    intransit += amount_due;

                }
                if (t.status.equals("Delivered")) {
                    delivered += amount_due;

                }
                if (t.status.equals("Canceled")) {
                    cancelled += amount_due;
                }
                if (t.status.equals("Ready")) {
                    ready += amount_due;
                }
            }

        }
        System.out.println("New: " + new_delivery);
        System.out.println("Intransit: " + new_delivery);
        System.out.println("Delivered: " + new_delivery);
        System.out.println("Canceled: " + new_delivery);
        Srpt_sales_ledger rpt = new Srpt_sales_ledger(business_name, address, date, walkin_sales, delivered_sales, new_delivery, intransit, delivered, cancelled, ready, walkin_receivables, delivery_receivables);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_collection_summary_sales_1.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_sales_ledger.field> ret_data(String where) {
        List<Srpt_sales_ledger.field> datas = new ArrayList();

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
                int charge_status = rs.getInt(32);

                String state = "";
                // New - 5 , Intransit - 6, Delivered - 7, Canceled - 8
                if (transaction_type_id.equals("2")) {
                    if (status == 5) {
                        state = "New";
                    }
                    if (status == 6) {
                        state = "Ready";

                    }
                    if (status == 7) {
                        state = "Intransit";

                    }
                    if (status == 8) {
                        state = "Delivered";

                    }
                    if (status == 9) {
                        state = "Canceled";

                    }
                }
                amount_due = ((amount_due + service_amount) - discount_amount);
                String date = DateType.convert_slash_datetime(date_added);
                Srpt_sales_ledger.field to = new field(or_no, amount_due, discount_amount, check_amount, transaction_type, customer_name, state, service_amount, charge_status, FitIn.toInt(payment_type_id), date);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_sales_ledger.field> ret_data2(String where) {
        List<Srpt_sales_ledger.field> datas = new ArrayList();

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
                int charge_status = rs.getInt(32);

                String state = "Collectible";
                if (charge_status == 1) {
                    state = "Paid";
                }

                amount_due = ((amount_due + service_amount) - discount_amount);
                String date = DateType.convert_slash_datetime(date_added);
                Srpt_sales_ledger.field to = new field(sales_no, amount_due, discount_amount, check_amount, transaction_type, customer_name, state, service_amount, charge_status, FitIn.toInt(payment_type_id), date);
                if (session_no.startsWith("CD")) {
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
}
