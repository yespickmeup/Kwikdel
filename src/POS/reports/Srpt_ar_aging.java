/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.util.DateType;
import POS.util.DateUtils1;
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
public class Srpt_ar_aging {

    public final List<Srpt_ar_aging.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;
    public final double one;
    public final double two;
    public final double three;
    public final double four;
    public final double five;
    public final double six;

    public Srpt_ar_aging(String business_name, String date, String printed_by, double one, double two, double three, double four, double five, double six) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public static class field {

        String ci_no;
        String transaction_no;
        String customer;
        String term;
        String amount;
        String days;
        String one;
        String two;
        String three;
        String four;
        String above;
        String applied;

        public field() {
        }

        public field(String ci_no, String transaction_no, String customer, String term, String amount, String days, String one, String two, String three, String four, String above, String applied) {
            this.ci_no = ci_no;
            this.transaction_no = transaction_no;
            this.customer = customer;
            this.term = term;
            this.amount = amount;
            this.days = days;
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
            this.above = above;
            this.applied = applied;
        }

        public String getCi_no() {
            return ci_no;
        }

        public void setCi_no(String ci_no) {
            this.ci_no = ci_no;
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

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getOne() {
            return one;
        }

        public void setOne(String one) {
            this.one = one;
        }

        public String getTwo() {
            return two;
        }

        public void setTwo(String two) {
            this.two = two;
        }

        public String getThree() {
            return three;
        }

        public void setThree(String three) {
            this.three = three;
        }

        public String getFour() {
            return four;
        }

        public void setFour(String four) {
            this.four = four;
        }

        public String getAbove() {
            return above;
        }

        public void setAbove(String above) {
            this.above = above;
        }

        public String getApplied() {
            return applied;
        }

        public void setApplied(String applied) {
            this.applied = applied;
        }

    }

    public static void main(String[] args) {

        List<Srpt_ar_aging.field> fields = Srpt_ar_aging.ret_aging("");
        String business_name = "Algorithm";
        String printed_by = "Ronald Pascua";
        String date = "Date Printed: [November 18,2013]";
        double one = 0;
        double two = 0;
        double three = 0;
        double four = 0;
        double five = 0;
        double six = 0;
        for (Srpt_ar_aging.field to : fields) {
            int day = DateUtils1.ar_aging(DateType.convert_slash_datetime_sf(to.applied), FitIn.toInt("" + to.term));
            one += FitIn.toDouble(to.one);
            two += FitIn.toDouble(to.two);
            three += FitIn.toDouble(to.three);
            four += FitIn.toDouble(to.four);
            five += FitIn.toDouble(to.above);
        }
        six = one + two + three + four + five;
        Srpt_ar_aging rpt = new Srpt_ar_aging(business_name, printed_by, date, one, two, three, four, five, six);
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_ar_aging to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_ar_aging.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_ar_aging to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_ar_aging.jrxml";
            InputStream is = Srpt_ar_aging.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_ar_aging.field> ret_aging(String where) {
        List<Srpt_ar_aging.field> datas = new ArrayList();
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
                    + " from  accounts_receivable  "
                    + " "+ where;
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
                double term = rs.getDouble(12);
                String date_applied = rs.getString(13);
                double paid = rs.getDouble(14);
                String date_paid = rs.getString(15);
                String remarks = rs.getString(16);
                String type = rs.getString(17);
                String or_no = rs.getString(18);
                String ci_no = rs.getString(19);
                String trust_receipt = rs.getString(20);

                int day = DateUtils1.ar_aging(date_applied, FitIn.toInt("" + term));
                String t_amount = FitIn.fmt_wc_0(amount - paid);
                String one = "";
                if (day > 0 && day <= 30) {
                    one = t_amount;
                }

                String two = "";
                if (day > 31 && day < 60) {
                    two = t_amount;
                }

                String three = "";
                if (day > 61 && day < 90) {
                    three = t_amount;
                }
                String four = "";
                if (day > 91 && day < 121) {
                    four = t_amount;
                }
                String above = "";
                if (day > 120) {
                    above = t_amount;
                }
                String applied = DateType.convert_dash_date2(date_applied);
                Srpt_ar_aging.field to = new field(ci_no, trust_receipt, customer_name, "" + FitIn.fmt_woc(term), "" + FitIn.fmt_wc_0(amount), "" + day, one, two
                        , three, four, above, applied);
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
