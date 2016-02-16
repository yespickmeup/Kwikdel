/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Srpt_beginning_inventory {

    public final List<Srpt_beginning_inventory.field> fields;
    public final String business_name;
    public final String address;
    public final String barcode;
    public final String description;
    public final String date;

    public Srpt_beginning_inventory(String business_name, String address, String barcode, String description, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.barcode = barcode;
        this.description = description;
        this.date = date;
    }

    public static class field implements Comparable<field> {

        String date_added;
        String transaction_type;
        double debit;
        double credit;
        double balance;
        Date date;

        public field() {
        }

        public field(String date_added, String transaction_type, double debit, double credit, double balance, Date date) {
            this.date_added = date_added;
            this.transaction_type = transaction_type;
            this.debit = debit;
            this.credit = credit;
            this.balance = balance;
            this.date = date;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public double getDebit() {
            return debit;
        }

        public void setDebit(double debit) {
            this.debit = debit;
        }

        public double getCredit() {
            return credit;
        }

        public void setCredit(double credit) {
            this.credit = credit;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public int compareTo(field o) {
            return getDate().compareTo(o.getDate());
        }
    }

    public static void main(String[] args) {
        String where = " where barcode='" + "00048" + "' ";
        List<Srpt_beginning_inventory.field> receipts = Srpt_beginning_inventory.receipts(where);
        List<Srpt_beginning_inventory.field> sales = Srpt_beginning_inventory.sales(where);
        List<Srpt_beginning_inventory.field> drs = Srpt_beginning_inventory.drs(where);

        List<Srpt_beginning_inventory.field> all = new ArrayList();
        all.addAll(receipts);
        all.addAll(sales);
        all.addAll(drs);

        Collections.sort(all);
        double balance = 0;
        for (Srpt_beginning_inventory.field to : all) {
            if (to.credit > 0) {
                balance -= to.credit;
            } else {
                balance += to.debit;
            }
            to.setBalance(balance);
        }
        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
        String barcode = "00048";
        String description = "# 232 STANDARD BURNER";
        String date = "01/01/2014";
        Srpt_beginning_inventory rpt = new Srpt_beginning_inventory(business_name, address, barcode, description, date);
        rpt.fields.addAll(all);
        String jrxml = "rpt_beginning_inventory.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_beginning_inventory.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_beginning_inventory to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_beginning_inventory.field> sales(String where) {
        List<Srpt_beginning_inventory.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
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
                    + ",product_qty"
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
                    + ",metered"
                    + " from sales_items"
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

                String date_added1 = DateType.convert_slash_datetime4(date_added);
                String transaction_type = "Sales";
                double debit = 0;
                double credit = (product_qty);
                double balance = 0;
                Date date = new Date();
                try {
                    date = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_beginning_inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
                Srpt_beginning_inventory.field field = new field(date_added1, transaction_type, debit, credit, balance, date);
                datas.add(field);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_beginning_inventory.field> drs(String where) {
        List<Srpt_beginning_inventory.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
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
                    + ",product_qty"
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
                    + ",metered"
                    + " from sales_dr_items"
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

                String date_added1 = DateType.convert_slash_datetime4(date_added);
                String transaction_type = "DR";
                double debit = 0;
                double credit = (product_qty);
                double balance = 0;
                Date date = new Date();
                try {
                    date = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_beginning_inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
                Srpt_beginning_inventory.field field = new field(date_added1, transaction_type, debit, credit, balance, date);
                datas.add(field);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_beginning_inventory.field> receipts(String where) {
        List<Srpt_beginning_inventory.field> datas = new ArrayList();

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

                String date_added1 = DateType.convert_slash_datetime4(date_added);
                String transaction_type = "Receipt";
                double debit = (qty);
                double credit = 0;
                double balance = 0;
                Date date = new Date();
                try {
                    date = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_beginning_inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
                Srpt_beginning_inventory.field field = new field(date_added1, transaction_type, debit, credit, balance, date);
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
