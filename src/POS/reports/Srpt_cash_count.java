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
public class Srpt_cash_count {

    public final List<Srpt_cash_count.field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;

    public Srpt_cash_count(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.business_owner = business_owner;
        this.business_address = business_address;
        this.date_printed = date_printed;
        this.sales_date = sales_date;
        this.printed_by = printed_by;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
    }

    public static class field {

        String user_name;
        String screen_name;
        String timein;
        String timeout;
        double amount;
        double cashout;
        double thousand;
        double five_hundred;
        double two_hundred;
        double fifty;
        double twenty;
        double coins;
        double one_hundred;

        public field() {
        }

        public field(String user_name, String screen_name, String timein, String timeout, double amount, double cashout, double thousand, double five_hundred, double two_hundred, double fifty, double twenty, double coins, double one_hundred) {
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.timein = timein;
            this.timeout = timeout;
            this.amount = amount;
            this.cashout = cashout;
            this.thousand = thousand;
            this.five_hundred = five_hundred;
            this.two_hundred = two_hundred;
            this.fifty = fifty;
            this.twenty = twenty;
            this.coins = coins;
            this.one_hundred = one_hundred;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public String getTimein() {
            return timein;
        }

        public void setTimein(String timein) {
            this.timein = timein;
        }

        public String getTimeout() {
            return timeout;
        }

        public void setTimeout(String timeout) {
            this.timeout = timeout;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getCashout() {
            return cashout;
        }

        public void setCashout(double cashout) {
            this.cashout = cashout;
        }

        public double getThousand() {
            return thousand;
        }

        public void setThousand(double thousand) {
            this.thousand = thousand;
        }

        public double getFive_hundred() {
            return five_hundred;
        }

        public void setFive_hundred(double five_hundred) {
            this.five_hundred = five_hundred;
        }

        public double getTwo_hundred() {
            return two_hundred;
        }

        public void setTwo_hundred(double two_hundred) {
            this.two_hundred = two_hundred;
        }

        public double getFifty() {
            return fifty;
        }

        public void setFifty(double fifty) {
            this.fifty = fifty;
        }

        public double getTwenty() {
            return twenty;
        }

        public void setTwenty(double twenty) {
            this.twenty = twenty;
        }

        public double getCoins() {
            return coins;
        }

        public void setCoins(double coins) {
            this.coins = coins;
        }

        public double getOne_hundred() {
            return one_hundred;
        }

        public void setOne_hundred(double one_hundred) {
            this.one_hundred = one_hundred;
        }

    }

    public static void main(String[] args) {

        List<Srpt_cash_count.field> fields = ret_data("");
        String business_name = "Fortune Three Enterprises";
        String business_owner = "Ernesto C.Quiamco";
        String business_address = "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_cash_count rpt = new Srpt_cash_count(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cashcount.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cash_count.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cash_count to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cash_count.field> ret_data(String where) {
        List<Srpt_cash_count.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + " from cash_drawer  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = DateType.convert_slash_datetime2(rs.getString(5));
                String time_out = rs.getString(6);
                if (time_out != null) {
                    time_out = DateType.convert_slash_datetime2(rs.getString(6));
                }
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);

                Srpt_cash_count.field to = new field(user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred);
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
