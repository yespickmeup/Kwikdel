/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

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
public class Srpt_expenses {

    public final List<Srpt_expenses.field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;

    public Srpt_expenses(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR) {
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

        String name;
        double amount;

        public field() {
        }

        public field(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

        List<Srpt_expenses.field> fields = Srpt_expenses.ret_data("");
        String business_name = "Fortune Three Enterprises";
        String business_owner = "Ernesto C.Quiamco";
        String business_address = "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_expenses rpt = new Srpt_expenses(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_expenses.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_expenses.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_expenses to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_expenses.field> ret_data(String where) {
        List<Srpt_expenses.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",date_added"
                    + " from cash_drawer_expenses  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                String date_added = rs.getString(11);
                Srpt_expenses.field to = new field(bank, amount);
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
