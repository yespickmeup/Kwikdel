/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import POS.sales.Srpt_receipt;
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
public class Srpt_collections_items {

    public final List<Srpt_collections_items.field> fields;
    public final String business_name;
    public final String address;
    public final String date;
    public final String cashier;
    public final String transaction_type;
    public final String payment_type;

    public Srpt_collections_items(String business_name, String address, String date, String cashier, String transaction_type, String payment_type) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.cashier = cashier;
        this.transaction_type = transaction_type;
        this.payment_type = payment_type;
    }

    public static class field {

        String barcode;
        String description;
        double qty;
        double selling_price;
        double amount;
        String or_no;
        String dr_no;
        String status;
        String payment_type;
        String transaction_type;
        int stat;
        public field() {
        }

        public field(String barcode, String description, double qty, double selling_price, double amount, String or_no, String dr_no, String status
                , String payment_type, String transaction_type,int stat) {
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.amount = amount;
            this.or_no = or_no;
            this.dr_no = dr_no;
            this.status = status;
            this.payment_type = payment_type;
            this.transaction_type = transaction_type;
            this.stat=stat;
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

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getDr_no() {
            return dr_no;
        }

        public void setDr_no(String dr_no) {
            this.dr_no = dr_no;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }
    }

    public static void main(String[] args) {

        List<Srpt_collections_items.field> datas = Srpt_collections_items.ret_data_sales_items(" where Date(si.date_added)='" + "2015-07-05" + "' group by description ");
        List<Srpt_collections_items.field> datas2 = Srpt_collections_items.ret_data_sales_dr_items(" where Date(date_added)='" + "2015-07-05" + "' group by description "); String business_name=System.getProperty("business_name","Kwikdel Trading");
        String address=System.getProperty("address","Kwikdel Trading");
        String date="";
        String cashier="";
        String transaction_type="";
        String payment_type="";
        
        Srpt_collections_items rpt = new Srpt_collections_items(business_name, address, date, cashier, transaction_type, payment_type);
        rpt.fields.addAll(datas);
        rpt.fields.addAll(datas2);
        JRViewer viewer = Srpt_collections_items.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void pdf_view(Srpt_collections_items to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_collections_items to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_collections_items.jrxml";
            InputStream is = Srpt_collections_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_collections_items.field> ret_data_sales_items(String where) {
        List<Srpt_collections_items.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "si.id"
                    + ",si.barcode"
                    + ",si.description"
                    + ",si.generic_name"
                    + ",si.category"
                    + ",si.category_id"
                    + ",si.classification"
                    + ",si.classification_id"
                    + ",si.sub_classification"
                    + ",si.sub_classification_id"
                    + ",sum(si.product_qty)"
                    + ",si.unit"
                    + ",si.conversion"
                    + ",si.selling_price"
                    + ",si.date_added"
                    + ",si.user_name"
                    + ",si.item_type"
                    + ",s.status"
                    + ",si.session_no"
                    + ",si.item_discount"
                    + ",si.discount"
                    + ",si.discount_amount"
                    + ",si.sales_no"
                    + ",si.fixed_price"
                    + ",si.supplier"
                    + ",si.supplier_id"
                    + ",si.vatable"
                    + ",si.or_no"
                    + ",si.customer_name"
                    + ",si.customer_id"
                    + ",si.metered"
                    + ",si.location_id"
                    + ",si.location_name"
                    + ",s.charge_status"
                    + " from sales_items si "
                    + " join sales s "
                    + " on si.sales_no=s.sales_no"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);
                int charge_status = rs.getInt(34);
                double qty = product_qty;
                double amount = qty * selling_price;
                String dr_no = "";
                String statuses = "Paid";
                String payment_type = "Cash Payment";
                String transaction_type = "Walkin";
                
                if (charge_status == 0) {
                    Srpt_collections_items.field field = new field(barcode, description, qty, selling_price, amount, or_no, dr_no, statuses, payment_type, transaction_type,status);
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

    public static List<Srpt_collections_items.field> ret_data_sales_dr_items(String where) {
        List<Srpt_collections_items.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "si.id"
                    + ",si.barcode"
                    + ",si.description"
                    + ",si.generic_name"
                    + ",si.category"
                    + ",si.category_id"
                    + ",si.classification"
                    + ",si.classification_id"
                    + ",si.sub_classification"
                    + ",si.sub_classification_id"
                    + ",sum(si.product_qty)"
                    + ",si.unit"
                    + ",si.conversion"
                    + ",si.selling_price"
                    + ",si.date_added"
                    + ",si.user_name"
                    + ",si.item_type"
                    + ",si.status"
                    + ",si.session_no"
                    + ",si.item_discount"
                    + ",si.discount"
                    + ",si.discount_amount"
                    + ",si.sales_no"
                    + ",si.fixed_price"
                    + ",si.supplier"
                    + ",si.supplier_id"
                    + ",si.vatable"
                    + ",si.or_no"
                    + ",si.customer_name"
                    + ",si.customer_id"
                    + ",si.metered"
                    + ",si.location_id"
                    + ",si.location_name"
                    + " from sales_dr_items si"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);

                double qty = product_qty;
                double amount = qty * selling_price;
                String dr_no = "";
                String statuses = "Paid";
                String payment_type = "Charge Payment";
                String transaction_type = "Walkin";

                Srpt_collections_items.field field = new field(barcode, description, qty, selling_price, amount, or_no, dr_no, statuses, payment_type, transaction_type,status);
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
