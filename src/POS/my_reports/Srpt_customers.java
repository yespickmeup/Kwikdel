/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

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
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_customers {

    public final List<Srpt_customers.field> fields;
    public final String business_name;
    public final String address;
    public final String date;

    public Srpt_customers(String business_name, String address, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
    }

    public static class field {

        String customer_name;
        String address;
        String contact_no;

        public field() {
        }

        public field(String customer_name, String address, String contact_no) {
            this.customer_name = customer_name;
            this.address = address;
            this.contact_no = contact_no;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContact_no() {
            return contact_no;
        }

        public void setContact_no(String contact_no) {
            this.contact_no = contact_no;
        }

    }

    public static void main(String[] args) {
        String where = " order by concat(last_name,first_name) asc";
        List<Srpt_customers.field> datas = ret_data(where);
        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
        String date = DateType.slash.format(new Date());
        Srpt_customers rpt = new Srpt_customers(business_name, address, date);
        rpt.fields.addAll(datas);
        JRViewer viewer = Srpt_customers.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void pdf_view(Srpt_customers to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_customers.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_customers to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_customers.jrxml";
            InputStream is = Srpt_customers.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_customers.field> ret_data(String where) {
        List<Srpt_customers.field> datas = new ArrayList();

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
                    + ",lname"
                    + ",fname"
                    + ",client_id"
                    + ",deposit"
                    + " from customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
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
                String lname = rs.getString(15);
                String fname = rs.getString(16);
                String client_id = rs.getString(17);
                double deposit = rs.getDouble(18);

                String name = last_name + ", " + first_name;
                if (name.startsWith(", ")) {
                    name = name.replaceAll(", ", "");
                }
                if (!name.isEmpty()) {
                    Srpt_customers.field field = new field(name, address, contact_no);
                    datas.add(field);
                }

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_customers.field> ret_data2(String where) {
        List<Srpt_customers.field> datas = new ArrayList();

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
                    + ",lname"
                    + ",fname"
                    + ",client_id"
                    + ",deposit"
                    + " from customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
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
                String lname = rs.getString(15);
                String fname = rs.getString(16);
                String client_id = rs.getString(17);
                double deposit = rs.getDouble(18);

                String name = last_name + ", " + first_name;
                if (name.startsWith(", ")) {
                    name = name.replaceAll(", ", "");
                }
                if (!address.isEmpty()) {
                    Srpt_customers.field field = new field(name, address, contact_no);
                    datas.add(field);
                }

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
