/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

import POS.sales.S1_sales.to_sales;
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
 * @author Guinness
 */
public class Srpt_sales_transaction_by_cashier {

    public final List<Srpt_sales_transaction_by_cashier.field> fields;
    public final String date;

    public Srpt_sales_transaction_by_cashier(String date) {
        this.fields = new ArrayList();
        this.date = date;
    }

    public static class field {

        String sales_no;
        String date;
        double amount_due;
        double discount;
        double check_amount;
        double service_amount;
        String cashier;
        String payment_type;
        double total;
        String customer_name;
        String selling_type;
        public field() {
        }

        public field(String sales_no, String date, double amount_due, double discount, double check_amount, double service_amount, String cashier
                , String payment_type, double total, String customer_name,String selling_type) {
            this.sales_no = sales_no;
            this.date = date;
            this.amount_due = amount_due;
            this.discount = discount;
            this.check_amount = check_amount;
            this.service_amount = service_amount;
            this.cashier = cashier;
            this.payment_type = payment_type;
            this.total = total;
            this.customer_name = customer_name;
            this.selling_type=selling_type;
        }

        public String getSelling_type() {
            return selling_type;
        }

        public void setSelling_type(String selling_type) {
            this.selling_type = selling_type;
        }
        
        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public double getService_amount() {
            return service_amount;
        }

        public void setService_amount(double service_amount) {
            this.service_amount = service_amount;
        }

        public String getCashier() {
            return cashier;
        }

        public void setCashier(String cashier) {
            this.cashier = cashier;
        }

        public String getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }
    }

    public static void main(String[] args) {

        String where = " where Date(date_added) between '" + "2014-09-05" + "' and '" + "2014-09-05" + "' order by user_name,payment_type";
        List<Srpt_sales_transaction_by_cashier.field> datas = Srpt_sales_transaction_by_cashier.ret_data(where);
        String date = "";
        Srpt_sales_transaction_by_cashier rpt = new Srpt_sales_transaction_by_cashier(date);
        rpt.fields.addAll(datas);

        JRViewer viewer = Srpt_sales_transaction_by_cashier.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void pdf_view(Srpt_sales_transaction_by_cashier to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_sales_transaction_by_cashier.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_sales_transaction_by_cashier to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_transaction_by_cashier.jrxml";
            InputStream is = Srpt_sales_transaction_by_cashier.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_sales_transaction_by_cashier.field> ret_data(String where) {
        List<Srpt_sales_transaction_by_cashier.field> datas = new ArrayList();

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
                
                if (payment_type_id.equals("1")) {
                    payment_type = "Cash Payment";
                } else {
                    payment_type = "Charge Payment";
                }
                
                double total = (amount_due + service_amount) - (discount_amount + check_amount);
                Srpt_sales_transaction_by_cashier.field field = new field(sales_no, date_added, amount_due, discount, check_amount, service_amount, user_name
                        , payment_type, total, customer_name,transaction_type);
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
