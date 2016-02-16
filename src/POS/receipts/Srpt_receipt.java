/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

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
 * @author Guinness
 */
public class Srpt_receipt {

    public final List<field> fields;
    public final String supplier;
    public final String date_of_delivery;
    public final String date_received;
    public final String remarks;
    public final String reference_no;
    public final String business_name;
    public final String address;
    public final String date;

    public Srpt_receipt(String supplier, String date_of_delivery, String date_received, String remarks, String reference_no, String business_name, String address, String date) {
        this.fields = new ArrayList();
        this.supplier = supplier;
        this.date_of_delivery = date_of_delivery;
        this.date_received = date_received;
        this.remarks = remarks;
        this.reference_no = reference_no;
        this.business_name = business_name;
        this.address = address;
        this.date = date;
    }

    public static class field {

        double qty;
        String barcode;
        String description;
        double cost;
        double amount;

        public field() {
        }

        public field(double qty, String barcode, String description, double cost, double amount) {
            this.qty = qty;
            this.barcode = barcode;
            this.description = description;
            this.cost = cost;
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescribe() {
            return description;
        }

        public void setDescribe(String description) {
            this.description = description;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        String where = "";
        List<Srpt_receipt.field> fields = ret_data(where);
        String supplier = "Lee Super Plaze";
        String date_of_delivery = "01/10/2014";
        String date_received = "01/10/2014";
        String remarks = "Remarks";
        String reference_no = "000000001";
        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
        String date = "01/01/2014";
        Srpt_receipt rpt = new Srpt_receipt(supplier, date_of_delivery, date_received, remarks, reference_no, business_name, address, date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_receipt.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_receipt to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_receipt.field> ret_data(String where) {
        List<Srpt_receipt.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + " from receipt_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                int status = rs.getInt(23);
                String reference_no = rs.getString(24);

                double amount = qty * cost;
                Srpt_receipt.field field = new field(qty, barcode, description, cost, amount);
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
