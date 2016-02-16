/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

import POS.metered_sales.S1_metered_sales_payments.to_metered_sales_payments;
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
 * @author Ronald
 */
public class Srpt_metered_sales_payments {

    public final List<field> fields;

    public Srpt_metered_sales_payments() {
        this.fields = new ArrayList();
    }

    public static class field {

        String or_no;
        String date;
        double cash;
        double check;
        double amount;

        public field() {
        }

        public field(String or_no, String date, double cash, double check, double amount) {
            this.or_no = or_no;
            this.date = date;
            this.cash = cash;
            this.check = check;
            this.amount = amount;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

        List<Srpt_metered_sales_payments.field> datas = ret_data("");
        String business_name = System.getProperty("business_name", "Kwekdel");
        String address = System.getProperty("address", "Dumaguete City");

        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_metered_sales_payments rpt = new Srpt_metered_sales_payments();
        rpt.fields.addAll(datas);
        String jrxml = "rpt_metered_sales_payments.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_metered_sales_payments.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_metered_sales_payments to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_metered_sales_payments.field> ret_data(String where) {
        List<Srpt_metered_sales_payments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",or_no"
                    + ",amount_due"
                    + ",cash"
                    + ",check_amount"
                    + ",check_bank"
                    + ",check_no"
                    + ",status"
                    + ",metered_sales_ids"
                    + " from metered_sales_payments  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String or_no = rs.getString(7);
                double amount_due = rs.getDouble(8);
                double cash = rs.getDouble(9);
                double check_amount = rs.getDouble(10);
                String check_bank = rs.getString(11);
                String check_no = rs.getString(12);
                int status = rs.getInt(13);
                String metered_sales_ids = rs.getString(14);

                String date = DateType.convert_slash_datetime(date_added);
                double check = check_amount;
                double amount = amount_due;
                Srpt_metered_sales_payments.field rpt = new Srpt_metered_sales_payments.field(or_no, date, cash, check, amount);
                datas.add(rpt);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
