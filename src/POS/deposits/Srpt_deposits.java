/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.deposits;

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
public class Srpt_deposits {

    public final List<Srpt_deposits.field> fields;
    public final String business_name;
    public final String address;
    public final String date;

    public Srpt_deposits(String business_name, String address, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
    }

    public static class field {

        String date;
        String customer_id;
        String customer;
        double qty;
        double returned;
        String barcode;
        String description;
        double amount;
        String type;

        public field() {
        }

        public field(String date, String customer_id, String customer, double qty, double returned, String barcode, String description, double amount, String type) {
            this.date = date;
            this.customer_id = customer_id;
            this.customer = customer;
            this.qty = qty;
            this.returned = returned;
            this.barcode = barcode;
            this.description = description;
            this.amount = amount;
            this.type = type;
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

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getReturned() {
            return returned;
        }

        public void setReturned(double returned) {
            this.returned = returned;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public static void main(String[] args) {
        String where = "";
        List<Srpt_deposits.field> fields = Srpt_deposits.ret_data(where);
        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
        String date = "";
        Srpt_deposits rpt = new Srpt_deposits(business_name, address, date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_deposits.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_deposits.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_deposits to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_deposits.field> ret_data(String where) {
        List<Srpt_deposits.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",user_id"
                    + ",date_added"
                    + ",status"
                    + ",customer_id"
                    + ",customer_name"
                    + ",qty"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",vatable"
                    + ",discount_amount"
                    + ",addtl_amount"
                    + ",location_name"
                    + ",location_id"
                    + ",is_deposit"
                    + " from deposits  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_id = rs.getString(3);
                String date_added = rs.getString(4);
                int status = rs.getInt(5);
                String customer_id = rs.getString(6);
                String customer_name = rs.getString(7);
                double qty = rs.getDouble(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                String category = rs.getString(11);
                String category_id = rs.getString(12);
                String classification = rs.getString(13);
                String classification_id = rs.getString(14);
                String sub_classification = rs.getString(15);
                String sub_classification_id = rs.getString(16);
                String unit = rs.getString(17);
                double conversion = rs.getDouble(18);
                double selling_price = rs.getDouble(19);
                int vatable = rs.getInt(20);
                double discount_amount = rs.getDouble(21);
                double addtl_amount = rs.getDouble(22);
                String location_name = rs.getString(23);
                String location_id = rs.getString(24);
                int is_deposit = rs.getInt(25);

                String date = DateType.convert_slash_datetime(date_added);

                String customer = customer_name;

                double returned = discount_amount;

                double amount = (qty - discount_amount) * selling_price;
                String type = "Deposit";
                if (is_deposit == 0) {
                    type = "On Loan";
                }

                Srpt_deposits.field field = new field(date, customer_id, customer, qty, returned, barcode, description, amount, type);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
