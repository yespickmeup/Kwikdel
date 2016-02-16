/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.accounts_receivable.S1_accounts_receivable_payments.to_accounts_receivable_payments;
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
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_ar_payments {

    public final List<Srpt_ar_payments.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;

    public Srpt_ar_payments(String business_name, String date, String printed_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
    }

    public static class field {

        String date;
        String customer_id;
        String customer_name;
        double cash;
        double check;

        public field() {
        }

        public field(String date, String customer_id, String customer_name, double cash, double check) {
            this.date = date;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.cash = cash;
            this.check = check;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getCheck() {
            return check;
        }

        public void setCheck(double check) {
            this.check = check;
        }

    }

    public static void main(String[] args) {

        List<Srpt_ar_payments.field> datas = Srpt_ar_payments.ret_data("");
        String business_name = System.getProperty("business_name", "Kwikdel");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_ar_payments rpt = new Srpt_ar_payments(business_name, date, printed_by);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_ar_payments.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_ar_payments.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_ar_payments to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_ar_payments.field> ret_data(String where) {
        List<Srpt_ar_payments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + " from accounts_receivable_payments  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_no = rs.getString(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);
                double amount = rs.getDouble(7);
                double discount_amount = rs.getDouble(8);
                double discount_rate = rs.getDouble(9);
                String discount = rs.getString(10);
                int status = rs.getInt(11);
                int term = rs.getInt(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                double prev_balance = rs.getDouble(19);
                double check_amount = rs.getDouble(20);
                String check_holder = rs.getString(21);
                String check_bank = rs.getString(22);
                String check_no = rs.getString(23);
                String ci_no = rs.getString(24);
                String trust_receipt = rs.getString(25);
                String or_payment_no = rs.getString(26);
                date_applied=DateType.convert_dash_date2(date_applied);
                Srpt_ar_payments.field to = new field(date_applied, customer_id, customer_name, amount, check_amount);
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
