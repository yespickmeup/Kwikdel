/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items.to_sales_items;
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
public class Srpt_sales_summary {

    public final double total_gross_sales;
    public final double total_vat_sales;
    public final double total_no_vat_sales;
    public final double total_void_sales;
    public final double total_discount;
    public final double no_of_qty_sold;
    public final double no_of_transactions;
    public final double no_no_void_transactions;
    public final double no_void_transactions;
    public final double cash_payments;
    public final double ar_cash_payments;
    public final double cheque_payments;
    public final double ar_cheque_payments;
    public final double total_cash_on_hand;
    public final String date;
    public final double total_services;
    public Srpt_sales_summary(double total_gross_sales, double total_vat_sales, double total_no_vat_sales, double total_void_sales, double total_discount, double no_of_qty_sold, double no_of_transactions
            , double no_no_void_transactions, double no_void_transactions, double cash_payments, double ar_cash_payments, double cheque_payments, double ar_cheque_payments, double total_cash_on_hand
            ,String date,double total_services) {
        this.total_gross_sales = total_gross_sales;
        this.total_vat_sales = total_vat_sales;
        this.total_no_vat_sales = total_no_vat_sales;
        this.total_void_sales = total_void_sales;
        this.total_discount = total_discount;
        this.no_of_qty_sold = no_of_qty_sold;
        this.no_of_transactions = no_of_transactions;
        this.no_no_void_transactions = no_no_void_transactions;
        this.no_void_transactions = no_void_transactions;
        this.cash_payments = cash_payments;
        this.ar_cash_payments = ar_cash_payments;
        this.cheque_payments = cheque_payments;
        this.ar_cheque_payments = ar_cheque_payments;
        this.total_cash_on_hand = total_cash_on_hand;
        this.date=date;
        this.total_services=total_services;
    }

    public static class field {

        public field() {
        }

    }

    public static void main(String[] args) {

        String date = "";
        double total_gross_sales = 0;
        double total_vat_sales = 0;
        double total_no_vat_sales = 0;
        double total_void_sales = 0;
        double total_discount = 0;
        double no_of_qty_sold = 0;
        double no_of_transactions = 0;
        double no_no_void_transactions = 0;
        double no_void_transactions = 0;
        double cash_payments = 0;
        double ar_cash_payments = 0;
        double cheque_payments = 0;
        double ar_cheque_payments = 0;
        double total_cash_on_hand = 0;
        double total_services=0;
        String where = " where Date(date_added) between '" + "2014-09-11" + "' and '" + "2014-09-11" + "' ";
        List<to_sales> sales = ret_data(where);
        for (to_sales to : sales) {
            if (to.status > 1) {
                if (to.status != 9) {
                    total_services+=to.service_amount;
                    ar_cash_payments += to.amount_due;
                    ar_cheque_payments += to.check_amount;
                } else {
                    total_void_sales += to.amount_due;
                    no_void_transactions++;
                }
                
            } else {
                if (to.status == 0) {
                    cash_payments += to.amount_due;
                } else {
                    total_discount += to.discount_amount;
                    no_no_void_transactions++;
                }
            }
            no_of_transactions++;
        }
        List<to_sales_items> items = ret_data_items(where);
        for (to_sales_items item : items) {
            total_gross_sales += item.product_qty * item.selling_price;
            if (item.vatable == 1) {
                total_vat_sales += item.product_qty * item.selling_price;
            } else {
                total_no_vat_sales += item.product_qty * item.selling_price;
            }

            if (item.status == 0) {
                no_of_qty_sold += item.product_qty;
            }
        }
       
        Srpt_sales_summary rpt = new Srpt_sales_summary(total_gross_sales, total_vat_sales, total_no_vat_sales, total_void_sales, total_discount, no_of_qty_sold, no_of_transactions, no_no_void_transactions, no_void_transactions, cash_payments, ar_cash_payments, cheque_payments, ar_cheque_payments, total_cash_on_hand,date,total_services);
       
        JRViewer viewer = Srpt_sales_summary.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_sales_summary to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_sales_summary.class),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JRViewer get_viewer(Srpt_sales_summary to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_summary.jrxml";
            InputStream is = Srpt_sales_summary.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<to_sales> ret_data(String where) {
        List<to_sales> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",transaction_type"
                    + ",transaction_type_id"
                    + ",payment_type"
                    + ",payment_type_id"
                    + ",vehicle_name"
                    + ",vehicle_id"
                    + ",driver_name"
                    + ",driver_id"
                    + ",time_delivered"
                    + ",time_received"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String customer_id = rs.getString(23);
                String transaction_type = rs.getString(24);
                String transaction_type_id = rs.getString(25);
                String payment_type = rs.getString(26);
                String payment_type_id = rs.getString(27);
                String vehicle_name = rs.getString(28);
                String vehicle_id = rs.getString(29);
                String driver_name = rs.getString(30);
                String driver_id = rs.getString(31);
                String time_delivered = rs.getString(32);
                String time_received = rs.getString(33);
                String customer_address = rs.getString(34);
                String customer_contact_no = rs.getString(35);
                int charge_status = rs.getInt(36);

                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, true, time_delivered, time_received, customer_address, customer_contact_no, charge_status, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data_items(String where) {
        List<to_sales_items> datas = new ArrayList();

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
                    + ",location_id"
                    + ",location_name"
                    + " from sales_items  "
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
                String location_id=rs.getString(32);
                String location_name=rs.getString(33);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, metered,location_id,location_name);
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
