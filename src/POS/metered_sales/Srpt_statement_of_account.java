/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

import POS.customers.S1_customers.to_customers;
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
 * @author Guinness
 */
public class Srpt_statement_of_account {

    public final List<field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String customer_name;
    public final String customer_address;
    public final String note;
    public final String owner;

    public Srpt_statement_of_account(String business_name, String address, String contact_no, String date, String customer_name, String customer_address, String note, String owner) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.note = note;
        this.owner = owner;

    }

    public static class field {

        String meter_type;
        String description;
        double cubic_used;
        double volume_density;
        double pcf;
        double total_consumption;
        double price_per_kilogram;
        double total_billing;
        String department;

        public field() {
        }

        public field(String meter_type, String description, double cubic_used, double volume_density, double pcf, double total_consumption, double price_per_kilogram, double total_billing, String department) {
            this.meter_type = meter_type;
            this.description = description;
            this.cubic_used = cubic_used;
            this.volume_density = volume_density;
            this.pcf = pcf;
            this.total_consumption = total_consumption;
            this.price_per_kilogram = price_per_kilogram;
            this.total_billing = total_billing;
            this.department = department;
        }

        public String getMeter_type() {
            return meter_type;
        }

        public void setMeter_type(String meter_type) {
            this.meter_type = meter_type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getCubic_used() {
            return cubic_used;
        }

        public void setCubic_used(double cubic_used) {
            this.cubic_used = cubic_used;
        }

        public double getVolume_density() {
            return volume_density;
        }

        public void setVolume_density(double volume_density) {
            this.volume_density = volume_density;
        }

        public double getPcf() {
            return pcf;
        }

        public void setPcf(double pcf) {
            this.pcf = pcf;
        }

        public double getTotal_consumption() {
            return total_consumption;
        }

        public void setTotal_consumption(double total_consumption) {
            this.total_consumption = total_consumption;
        }

        public double getPrice_per_kilogram() {
            return price_per_kilogram;
        }

        public void setPrice_per_kilogram(double price_per_kilogram) {
            this.price_per_kilogram = price_per_kilogram;
        }

        public double getTotal_billing() {
            return total_billing;
        }

        public void setTotal_billing(double total_billing) {
            this.total_billing = total_billing;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

    }

    public static void main(String[] args) {

        List<Srpt_statement_of_account.field> fields = new ArrayList();
        for (int i = 0; i < 3; i++) {
            String meter_type = "HIGH PRESSURE";
            String description = "Meter #1 (Meter#DH6-00700514) - F&B";
            double cubic_used = 76.15;
            double volume_density = 2.27;
            double pcf = 1.986;
            double total_consumption = 343.30;
            double price_per_kilogram = 67.72;
            double total_billing = 23248.28;
            Srpt_statement_of_account.field f = new Srpt_statement_of_account.field(meter_type, description, cubic_used, volume_density, pcf, total_consumption, price_per_kilogram, total_billing, "");
            fields.add(f);
        }

        String business_name = "DUMAGUETE KWIKDEL INC.";
        String address = "Corner Colon & Sta Catalina Street, Dumaguete City 6200";
        String contact_no = "Tel. No. (035) 422 - 7888/Fax: 023423423";
        String date = "May 12, 2014";
        String customer_name = "BETHEL GUEST HOUSE";
        String customer_address = "Rizal Blvd., Dumaguete";
        String note = "This is to bill you for the Solane LPG consumed for the period May 6 to 12,2014:";
        String owner = "ERNESTO C. QUIAMCO";
        Srpt_statement_of_account rpt = new Srpt_statement_of_account(business_name, address, contact_no, date, customer_name, customer_address, note, owner);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_statement_of_account.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_statement_of_account.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_statement_of_account to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_statement_of_account.field> ret_data(String where, String meter_type) {
        List<Srpt_statement_of_account.field> fields = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",balance"
                    + ",paid"
                    + ",status"
                    + ",remarks"
                    + ",metered_sale_id"
                    + ",department"
                    + " from metered_sale_readings  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            String where1 = " where id=1";
            S1_metered_sales_settings.to_metered_sales_settings density = S1_metered_sales_settings.ret_data2(where1);

            String where4 = " where id=6";
            S1_metered_sales_settings.to_metered_sales_settings kg_price = S1_metered_sales_settings.ret_data2(where4);

            double volume_density = density.rate;
            double pcf = 0;
            if (meter_type.equalsIgnoreCase("Low Pressure")) {
                String where2 = " where id=4";
                S1_metered_sales_settings.to_metered_sales_settings lp_pcf = S1_metered_sales_settings.ret_data2(where2);
                pcf = lp_pcf.rate;
            } else {

                String where3 = " where id=5";
                S1_metered_sales_settings.to_metered_sales_settings hp_pcf = S1_metered_sales_settings.ret_data2(where3);
                pcf = hp_pcf.rate;
            }
            double price_per_kilogram = kg_price.rate;

            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String description = rs.getString(7);
                double qty = rs.getDouble(8);
                double price = rs.getDouble(9);
                double balance = rs.getDouble(10);
                double paid = rs.getDouble(11);
                int status = rs.getInt(12);
                String remarks = rs.getString(13);
                String metered_sale_id = rs.getString(14);
                String department = rs.getString(15);

                double total_consumption = (qty * volume_density) * pcf;

                String s=FitIn.fmt_wc_0(total_consumption);
                double total_billing = FitIn.toDouble(s) * price_per_kilogram;

                Srpt_statement_of_account.field f = new Srpt_statement_of_account.field(meter_type, description, qty, volume_density, pcf, total_consumption, price_per_kilogram, total_billing, department);
                fields.add(f);
            }
            return fields;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_customers ret_data(String where) {
        to_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",account"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",deposit"
                    + " from customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                int term = rs.getInt(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                String account = rs.getString(11);
                String first_name = rs.getString(12);
                String last_name = rs.getString(13);
                String mi = rs.getString(14);
                double deposit=rs.getDouble(15);
                to1 = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi,deposit);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
