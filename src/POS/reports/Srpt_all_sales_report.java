/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.sales.S1_sales.to_sales;
import POS.util.DateType;
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

/**
 *
 * @author Maytopacka
 */
public class Srpt_all_sales_report {

    public final List<field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;
    public final double walkin_collected;
    public final double walkin_receivables;
    public final double delivery_collected;
    public final double delivery_receivables;
    public final double net_sales;

    public Srpt_all_sales_report(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR, double walkin_collected, double walkin_receivables, double delivery_collected, double delivery_receivables, double net_sales) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.business_owner = business_owner;
        this.business_address = business_address;
        this.date_printed = date_printed;
        this.sales_date = sales_date;
        this.printed_by = printed_by;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.walkin_collected = walkin_collected;
        this.walkin_receivables = walkin_receivables;
        this.delivery_collected = delivery_collected;
        this.delivery_receivables = delivery_receivables;
        this.net_sales = net_sales;
    }

    public static class field {

        String sales_no;
        String date_added;
        String user_name;
        double gross_amount;
        double amount_paid;
        double amount_due;
        String discount_name;
        double discount;
        double discount_amount;
        String customer_name;
        String check_bank;
        String check_no;
        double check_amount;
        double total;
        String services;
        double service_amount;
        int status;
        int transaction_type;
        int payment_type;
        int charge_status;

        public field() {
        }

        public field(String sales_no, String date_added, String user_name, double gross_amount, double amount_paid, double amount_due, String discount_name, double discount, double discount_amount, String customer_name, String check_bank, String check_no, double check_amount, double total, String services, double service_amount, int status, int transaction_type, int payment_type, int charge_status) {
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_name = user_name;
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
            this.total = total;
            this.services = services;
            this.service_amount = service_amount;
            this.status = status;
            this.transaction_type = transaction_type;
            this.payment_type = payment_type;
            this.charge_status = charge_status;
        }

        public double getService_amount() {
            return service_amount;
        }

        public void setService_amount(double service_amount) {
            this.service_amount = service_amount;
        }

        public String getServices() {
            return services;
        }

        public void setServices(String services) {
            this.services = services;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getAmount_paid() {
            return amount_paid;
        }

        public void setAmount_paid(double amount_paid) {
            this.amount_paid = amount_paid;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public String getCheck_bank() {
            return check_bank;
        }

        public void setCheck_bank(String check_bank) {
            this.check_bank = check_bank;
        }

        public String getCheck_no() {
            return check_no;
        }

        public void setCheck_no(String check_no) {
            this.check_no = check_no;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getDiscount_name() {
            return discount_name;
        }

        public void setDiscount_name(String discount_name) {
            this.discount_name = discount_name;
        }

        public double getGross_amount() {
            return gross_amount;
        }

        public void setGross_amount(double gross_amount) {
            this.gross_amount = gross_amount;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }

    public static void main(String[] args) {

        List<Srpt_all_sales_report.field> fields = new ArrayList();
        double walkin_collected = 0;
        double walkin_receivables = 0;
        double delivery_collected = 0;
        double delivery_receivables = 0;
        double net_sales = 0;
        for (int i = 0; i < 50; i++) {
            String sales_no = "0000000000" + i;
            String date_added = "January 31, 2012";
            String user_name = "user name";
            double gross_amount = 0;
            double amount_paid = 0;
            double amount_due = 0;
            String discount_name = "Senior Citizen";
            double discount = 0;
            double discount_amount = 0;
            String customer_name = "Customer Name";
            String check_bank = "Bank";
            String check_no = "00000000001";
            double check_amount = 0;
            double total = 100 + i;
            String services = "a";
            double service_amount = 100;
            Srpt_all_sales_report.field to = new Srpt_all_sales_report.field(sales_no, date_added, user_name, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, total, services, service_amount, 0, 0, 0, 0);
            fields.add(to);
        }

        String business_name = "St. Ezekiel Multipurpose Cooperative";
        String business_owner = "Satellite Office: SEMCO Building, Caidiocan, Valencia";
        String business_address = "Main Office: Valencia Training Center, South Pob., Valencia. Telephone No. (035) 423-8007";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");

        Srpt_all_sales_report rpt = new Srpt_all_sales_report(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR, walkin_collected, walkin_receivables, delivery_collected, delivery_receivables, net_sales);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_all_sales_report.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_all_sales_report to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_all_sales_report.field> ret_data(String date_from, String date_to, String cashier_name) {
        List<Srpt_all_sales_report.field> datas = new ArrayList();
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
                    + ",services"
                    + ",service_amount"
                    + ",status"
                    + ",transaction_type_id"
                    + ",payment_type_id"
                    + ",charge_status"
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like '%" + cashier_name + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = DateType.convert_jan_1_2013_datetime(rs.
                        getString(3));
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
                double total = amount_due - discount_amount;
                String services = rs.getString(16);
                double service_amount = rs.getDouble(17);
                int status = rs.getInt(18);
                int transaction_type_id = rs.getInt(19);
                int payment_type_id = rs.getInt(20);
                int charge_status = rs.getInt(21);
                if (status == 0) {
                    amount_due = amount_due - check_amount;

                    Srpt_all_sales_report.field to = new field(sales_no, date_added, customer_name, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, total, services, service_amount, status, transaction_type_id, payment_type_id, charge_status);
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

    public static List<Srpt_all_sales_report.field> ret_data2(String where) {
        List<Srpt_all_sales_report.field> datas = new ArrayList();
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
                    + ",status"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",services"
                    + ",service_amount"
                    + ",status"
                    + ",transaction_type_id"
                    + ",payment_type_id"
                    + ",charge_status"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = DateType.convert_slash_datetime2(rs.
                        getString(3));
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);

                if (discount_name.equals("9")) {
                    discount_name = "Void";
                } else if (discount_name.equals("1")) {
                    discount_name = "Void";
                } else {
                    discount_name = "";
                }

                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String services = rs.getString(16);
                double service_amount = rs.getDouble(17);
                double total = (amount_due + service_amount) - discount_amount;
                amount_due = (amount_due + service_amount);
                int status = rs.getInt(18);
                int transaction_type_id = rs.getInt(19);
                int payment_type_id = rs.getInt(20);
                int charge_status = rs.getInt(21);
                Srpt_all_sales_report.field to = new field(sales_no, date_added, customer_name, gross_amount, amount_paid
                        , amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no
                        , check_amount, total, services, service_amount, status, transaction_type_id, payment_type_id,charge_status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_report(String date_from, String date_to, String cashier_name) {
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
                    + ",time_delivered"
                    + ",time_received"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + cashier_name + "%' "
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
                String time_delivered = rs.getString(24);
                String time_received = rs.getString(25);
                String customer_address = rs.getString(26);
                String customer_contact_no = rs.getString(27);
                int charge_status = rs.getInt(28);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, "", "", "", "", "", "", "", "", false, time_delivered, time_received, customer_address, customer_contact_no, charge_status,1);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_report_or(String sales_no1) {
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
                    + ",time_delivered"
                    + ",time_received"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + " from sales where "
                    + " sales_no like'%" + sales_no1 + "%' or customer_name like '%" + sales_no1 + "%'"
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
                String time_delivered = rs.getString(24);
                String time_received = rs.getString(25);
                String customer_address = rs.getString(26);
                String customer_contact_no = rs.getString(27);
                int charge_status = rs.getInt(28);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, "", "", "", "", "", "", "", "", false, time_delivered, time_received, customer_address, customer_contact_no, charge_status,1);
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
