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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 * @author Ronald
 */
public class Srpt_customer_ledger {

    public final List<Srpt_customer_ledger.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;
    public final String customer_id;
    public final String customer_name;
    public final double balance;

    public Srpt_customer_ledger(String business_name, String date, String printed_by, String customer_id, String customer_name, double balance) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.balance = balance;
    }

    public static class field {

        String date;
        String transaction_no;
        String or_no;
        String amount;
        String payment;
        String balance;
        Date date_added;

        public field() {
        }

        public field(String date, String transaction_no, String or_no, String amount, String payment, String balance, Date date_added) {
            this.date = date;
            this.transaction_no = transaction_no;
            this.or_no = or_no;
            this.amount = amount;
            this.payment = payment;
            this.balance = balance;
            this.date_added = date_added;
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

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

    }

    public static void main(String[] args) {

        List<Srpt_customer_ledger.field> datas = Srpt_customer_ledger.ret_data("0021");// Srpt_customers.ret_data("");
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String customer_id = "";
        String customer_name = "";
        double balance = 0;

        Srpt_customer_ledger rpt = new Srpt_customer_ledger(business_name, date, printed_by, customer_id, customer_name, balance);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_customer_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_customer_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_customer_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_customer_ledger.field> ret_data(String search) {
        List<Srpt_customer_ledger.field> datas = new ArrayList();
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
                    + ",ci_no"
                    + ",trust_receipt"
                    + " from  accounts_receivable where "
                    + " customer_id ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date = DateType.convert_slash_datetime3(rs.getString(13));
                String date_added = rs.getString(5);
                String transaction_no = rs.getString(20);
                String or_no = rs.getString(18);
                double amount = rs.getDouble(7);
                double payment = 0;
                double balance = 0;
                Date d = DateType.slash.parse(date);

                String amount2 = FitIn.fmt_wc_0(amount);
                if (amount == 0) {
                    amount2 = "";
                }
                String payment2 = FitIn.fmt_wc_0(payment);
                if (payment == 0) {
                    payment2 = "";
                }
                String balance2 = FitIn.fmt_wc_0(balance);
                if (balance == 0) {
                    balance2 = "";
                }
//                if(payment2.isEmpty()){
//                    date=DateType.convert_slash_datetime2(date);
//                }
//                else{
//                      date=DateType.convert_slash_datetime(date_added);
//                }
                Srpt_customer_ledger.field to = new Srpt_customer_ledger.field(date, transaction_no, or_no, amount2, payment2, balance2, d);
                datas.add(to);
            }

            String s2 = "select "
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
                    + " from  accounts_receivable_payments where "
                    + " customer_id ='" + search + "' "
                    + " ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                double paid = rs2.getDouble(7);
                double check_amount = rs2.getDouble(20);
                String date = rs2.getString(13);
                String transaction_no = rs2.getString(25);
                String or_payment_no = rs2.getString(26);
                String or_no = rs2.getString(18);
                double amount = 0;

                double payment = paid + check_amount;
                double balance = 0;
                Date d = DateType.sf.parse(date);
                date=DateType.convert_slash_datetime3(date);
                String amount2 = FitIn.fmt_wc_0(amount);
                if (amount == 0) {
                    amount2 = "";
                }
                String payment2 = FitIn.fmt_wc_0(payment);
                if (payment == 0) {
                    payment2 = "";
                }
                String balance2 = FitIn.fmt_wc_0(balance);
                if (balance == 0) {
                    balance2 = "";
                }
                Srpt_customer_ledger.field to1 = new Srpt_customer_ledger.field(date, transaction_no, or_payment_no, amount2, payment2, balance2, d);
                datas.add(to1);
            }

            Collections.sort(datas, new Comparator<Srpt_customer_ledger.field>() {

                @Override
                public int compare(Srpt_customer_ledger.field o1, Srpt_customer_ledger.field o2) {
                    return o1.getDate_added().
                            compareTo(o2.getDate_added());
                }
            });

            double amount = 0;
            double total = 0;
            List<Srpt_customer_ledger.field> datas2 = new ArrayList();
            for (Srpt_customer_ledger.field to : datas) {
                total += FitIn.toDouble(to.amount) - FitIn.toDouble(to.payment);
                Srpt_customer_ledger.field to1 = new Srpt_customer_ledger.field(to.date, to.transaction_no, to.or_no, to.amount, to.payment, FitIn.fmt_wc_0(total), to.date_added);
                datas2.add(to1);
            }
            return datas2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
