/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author i1
 */
public class Srpt_ar_ledger {

    public final List<field> fields;
    public final String business_name;
    public final String printed_by;
    public final String date;
    public final String customer_name;
    public final String customer_address;

    public Srpt_ar_ledger(String business_name, String printed_by, String date, String customer_name, String customer_address) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.printed_by = printed_by;
        this.date = date;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
    }

    public static class field {

        public field() {
        }
//        "Date", "Trans #", "OR #", "Amount", "Payment", "Balance"
        String date;
        String trans_no;
        String or_no;
        String amount;
        String payment;
        double balance;

        public field(String date, String trans_no, String or_no, String amount, String payment, double balance) {
            this.date = date;
            this.trans_no = trans_no;
            this.or_no = or_no;
            this.amount = amount;
            this.payment = payment;
            this.balance = balance;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public String getTrans_no() {
            return trans_no;
        }

        public void setTrans_no(String trans_no) {
            this.trans_no = trans_no;
        }
    }

    public static void main(String[] args) {

        List<Srpt_ar_ledger.field> fields = new ArrayList();
        for (int i = 0; i < 120; i++) {
            String date = "11/18/13";
            String trans_no = "1000" + i;
            String or_no = "0000" + i;
            String amount = (i + 1) + "00.00";
            String payment = "200";
            double balance = 100;
            Srpt_ar_ledger.field to = new field(date, trans_no, or_no, amount, payment, balance);
            fields.add(to);
        }

        String business_name = "Algorithm";
        String printed_by = "Ronald Pascua";
        String date = "Date Printed: [November 18,2013]";
        String customer_name = "Lee Super Plaza";
        String customer_address = "Address";
        Srpt_ar_ledger rpt = new Srpt_ar_ledger(business_name, printed_by, date, customer_name, customer_address);
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_ar_ledger.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_ar_ledger to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_ar_ledger.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_ar_ledger to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_ar_ledger.jrxml";
            InputStream is = Srpt_ar_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
