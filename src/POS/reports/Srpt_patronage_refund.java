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
public class Srpt_patronage_refund {

    public final List<field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;


    public Srpt_patronage_refund(String business_name, String business_owner, String business_address, String date_printed, String sales_date
            , String printed_by,String SUBREPORT_DIR) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.business_owner = business_owner;
        this.business_address = business_address;
        this.date_printed = date_printed;
        this.sales_date = sales_date;
        this.printed_by = printed_by;
        this.SUBREPORT_DIR=SUBREPORT_DIR;
    }

    public static class field {

        String customer_id;
        String customer_name;
        double total_items;
        double refund;
        double amount;
        public field() {
        }

        public field(String customer_id, String customer_name, double total_items, double refund,double amount) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.total_items = total_items;
            this.refund = refund;
            this.amount=amount;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getTotal_items() {
            return total_items;
        }

        public void setTotal_items(double total_items) {
            this.total_items = total_items;
        }

        public double getRefund() {
            return refund;
        }

        public void setRefund(double refund) {
            this.refund = refund;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        
    }

    public static void main(String[] args) {

        List<Srpt_patronage_refund.field> fields = new ArrayList();
        for (int i = 0; i < 50; i++) {
            String customer_id = "" + 1;
            String customer_name = "customer";
            double total_item = 1;
            double refund = 2;
            Srpt_patronage_refund.field to = new field(customer_id, customer_name, total_item, refund,0);
            fields.add(to);
        }
        String business_name = "Fortune Three Enterprises";
        String business_owner = "Ernesto C.Quiamco";
        String business_address = "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_patronage_refund rpt = new Srpt_patronage_refund(business_name, business_owner, business_address, date_printed, sales_date, printed_by,SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_patronage_refund.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_patronage_refund.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_patronage_refund to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_patronage_refund.field> ret_data(String where) {
        List<Srpt_patronage_refund.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s2 = "select "
                    + "id"
                    + ",concat(lname,space(1),fname) "
                    + " from customers  "
                    + " " + where;

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                String customer_name = rs2.getString(2);
                String s0 = "select "
                        + "id"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",sum(product_qty)"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",session_no"
                        + ",item_discount"
                        + ",discount"
                        + ",discount_amount"
                        + ",sales_no"
                        + ",fixed_price"
                        + ",supplier"
                        + ",supplier_id"
                        + ",vatable"
                        + ",or_no"
                        + ",customer_name"
                        + ",customer_id"
                        + " from sales_items  "
                        + " where customer_id='" + id + "' group by barcode ";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                double qty = 0;
                double price = 0;
                while (rs.next()) {
                    int id2 = rs.getInt(1);
                    String barcode = rs.getString(2);
                    String description = rs.getString(3);
                    String generic_name = rs.getString(4);
                    String category = rs.getString(5);
                    String category_id = rs.getString(6);
                    String classification = rs.getString(7);
                    String classification_id = rs.getString(8);
                    String sub_classification = rs.getString(9);
                    String sub_classification_id = rs.getString(10);
                    qty = rs.getDouble(11);
                    String unit = rs.getString(12);
                    double conversion = rs.getDouble(13);
                    price = rs.getDouble(14);
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
                    String customer_name1 = rs.getString(29);
                    String customer_id = rs.getString(30);
                }
                Srpt_patronage_refund.field to = new field("" + id, customer_name, qty, price,price);
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
