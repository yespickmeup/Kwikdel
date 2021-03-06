/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import POS.sales.Srpt_receipt;
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
public class Srpt_collections {

    public final List<Srpt_collections.field> fields;
    public final double cash_direct;
    public final double cash_charge;
    public final double cash_total;
    public final double walkin;
    public final double delivery;
    public final String business_name;
    public final String address;
    public final String date;
    public final String cashier;
    public final String transaction_type;
    public final String payment_type;
    public final double check_total;

    public Srpt_collections(double cash_direct, double cash_charge, double cash_total, double walkin, double delivery, String business_name, String address, String date, String cashier, String transaction_type, String payment_type, double check_total) {
        this.fields = new ArrayList();
        this.cash_direct = cash_direct;
        this.cash_charge = cash_charge;
        this.cash_total = cash_total;
        this.walkin = walkin;
        this.delivery = delivery;
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.cashier = cashier;
        this.transaction_type = transaction_type;
        this.payment_type = payment_type;
        this.check_total = check_total;
    }

    public static class field {

        String or_no;
        String dr_no;
        String date;
        String customer;
        String transaction_type;
        String payment_type;
        double service_amount;
        double discount_amount;
        double amount_due;
        String user;
        double cash;
        double service_charge;
        double check_amount;
        double discount;
        double gross_amount;
        int status;
        public field() {
        }

        public field(String or_no, String dr_no, String date, String customer, String transaction_type, String payment_type, double service_amount
                , double discount_amount, double amount_due, String user, double cash, double service_charge, double check_amount, double discount,double gross_amount,int status) {
            this.or_no = or_no;
            this.dr_no = dr_no;
            this.date = date;
            this.customer = customer;
            this.transaction_type = transaction_type;
            this.payment_type = payment_type;
            this.service_amount = service_amount;
            this.discount_amount = discount_amount;
            this.amount_due = amount_due;
            this.user = user;
            this.cash = cash;
            this.service_charge = service_charge;
            this.check_amount = check_amount;
            this.discount = discount;
            this.gross_amount=gross_amount;
            this.status=status;
        }
        
        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getService_charge() {
            return service_charge;
        }

        public void setService_charge(double service_charge) {
            this.service_charge = service_charge;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getDr_no() {
            return dr_no;
        }

        public void setDr_no(String dr_no) {
            this.dr_no = dr_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }

        public double getService_amount() {
            return service_amount;
        }

        public void setService_amount(double service_amount) {
            this.service_amount = service_amount;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

    }

    public static void main(String[] args) {

        List<Srpt_collections.field> datas = ret_data(" where Date(date_added)='" + "2015-07-02" + "' ");
        double cash_direct = 0;
        double cash_charge = 0;
        double cash_total = 0;
        double walkin = 0;
        double delivery = 0;
        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "Kwikdel Trading");
        String date = "";
        String cashier = "";
        String transaction_type = "";
        String payment_type = "";
        double check_total = 0;
        for (Srpt_collections.field to : datas) {
            check_total += to.check_amount;
            if (!to.dr_no.isEmpty()) {
                cash_charge += to.amount_due;
            } else {
                cash_direct += to.amount_due;
            }
            if (to.transaction_type.equalsIgnoreCase("walkin")) {
                walkin += to.amount_due;
            } else {
                delivery += to.amount_due;
            }
        }
        cash_total = cash_direct + cash_charge;

        Srpt_collections rpt = new Srpt_collections(cash_direct, cash_charge, cash_total, walkin, delivery, business_name, address, date, cashier, transaction_type, payment_type, check_total);
        rpt.fields.addAll(datas);
        JRViewer viewer = Srpt_collections.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void pdf_view(Srpt_collections to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_collections to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_collections.jrxml";
            InputStream is = Srpt_collections.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_collections.field> ret_data(String where) {
        List<Srpt_collections.field> datas = new ArrayList();

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
                    + " from sales"
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

                String dr_no = "";
                dr_no = session_no;
                try {
                    dr_no = session_no;
                } catch (Exception e) {
                    dr_no = "";
                }
                if (dr_no != null) {
                    if (dr_no.contains("CD-")) {
                        dr_no = "";
                    }
                } else {
                    dr_no = "";
                }
                String date = DateType.convert_slash_datetime(date_added);
                double due = (amount_due + service_amount) - (discount_amount);
                String customer = customer_name;
                String user = user_name;
                double cash = 0;
                double check = 0;
                double service_charge = service_amount;
                if (check_amount == 0) {
                    cash += (amount_due + service_amount) - discount_amount;
                } else {
                    check = (check_amount + service_amount) - discount_amount;
                }
                
                Srpt_collections.field field = new field(sales_no, dr_no, date, customer, transaction_type, payment_type, service_amount, discount_amount
                        , due, user, cash, service_charge, check, discount_amount,gross_amount,status);
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
