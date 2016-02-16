/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * @author i1
 */
public class Srpt_ar_aging2 {

    public final List<field> fields;
    public final String business_name;
    public final String printed_by;
    public final String date;
    public final double amount;
    public final double f_quarter;
    public final double second_quarter;
    public final double third_quarter;
    public final double fourth_quarter;
    public final double above;

    public Srpt_ar_aging2(String business_name, String printed_by, String date, double amount, double f_quarter, double second_quarter, double third_quarter, double fourth_quarter, double above) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.printed_by = printed_by;
        this.date = date;
        this.amount = amount;
        this.f_quarter = f_quarter;
        this.second_quarter = second_quarter;
        this.third_quarter = third_quarter;
        this.fourth_quarter = fourth_quarter;
        this.above = above;
    }

    public static class field {

//         "CI NO", "T.R.", "CUSTOMER", "TERM", "AMOUNT", "DAYS", "1-30", "31-60", "61-90", "91-120", "ABOVE"
        String ci_no;
        String tr;
        String customer_name;
        int term;
        String amount;
        int days;
        String f_quarter;
        String second_quarter;
        String third_quarter;
        String fourth_quarter;
        String above;

        public field() {
        }

        public field(String ci_no, String tr, String customer_name, int term, String amount, int days, String f_quarter, String second_quarter, String third_quarter, String fourth_quarter, String above) {
            this.ci_no = ci_no;
            this.tr = tr;
            this.customer_name = customer_name;
            this.term = term;
            this.amount = amount;
            this.days = days;
            this.f_quarter = f_quarter;
            this.second_quarter = second_quarter;
            this.third_quarter = third_quarter;
            this.fourth_quarter = fourth_quarter;
            this.above = above;
        }

        public String getAbove() {
            return above;
        }

        public void setAbove(String above) {
            this.above = above;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCi_no() {
            return ci_no;
        }

        public void setCi_no(String ci_no) {
            this.ci_no = ci_no;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public String getF_quarter() {
            return f_quarter;
        }

        public void setF_quarter(String f_quarter) {
            this.f_quarter = f_quarter;
        }

        public String getFourth_quarter() {
            return fourth_quarter;
        }

        public void setFourth_quarter(String fourth_quarter) {
            this.fourth_quarter = fourth_quarter;
        }

        public String getSecond_quarter() {
            return second_quarter;
        }

        public void setSecond_quarter(String second_quarter) {
            this.second_quarter = second_quarter;
        }

        public int getTerm() {
            return term;
        }

        public void setTerm(int term) {
            this.term = term;
        }

        public String getThird_quarter() {
            return third_quarter;
        }

        public void setThird_quarter(String third_quarter) {
            this.third_quarter = third_quarter;
        }

        public String getTr() {
            return tr;
        }

        public void setTr(String tr) {
            this.tr = tr;
        }
    }

    public static void main(String[] args) {
        double tamount = 0;
        double tf_quarter = 0;
        double tsecond_quarter = 0;
        double tthird_quarter = 0;
        double tfourth_quarter = 0;
        double tabove = 0;

        List<Srpt_ar_aging2.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String ci_no = "ci no";
            String tr = "tr";
            String customer_name = "customer name";
            int term = 0;
            String amount = "" + 1000 + i;
            int days = 1;
            String f_quarter = "" + 1;
            String second_quarter = "" + 2;
            String third_quarter = "" + 2;
            String fourth_quarter = "" + 2;
            String above = "" + 2;
            Srpt_ar_aging2.field to = new Srpt_ar_aging2.field(ci_no, tr, customer_name, term, amount, days, f_quarter, second_quarter, third_quarter, fourth_quarter, above);
            fields.add(to);
        }

        String business_name = "Algorithm";
        String printed_by = "Ronald Pascua";
        String date = "Date Printed: [November 18,2013]";

        Srpt_ar_aging2 rpt = new Srpt_ar_aging2(business_name, printed_by, date, tamount, tf_quarter, tsecond_quarter, tthird_quarter, tfourth_quarter, tabove);
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_ar_aging2 to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_ar_aging2.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_ar_aging2 to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_ar_aging.jrxml";
            InputStream is = Srpt_ar_aging2.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

  

}
