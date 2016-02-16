/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import POS.sales.Srpt_receipt;
import java.io.InputStream;
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
public class Srpt_summary {

    public final double total_gross_sales;
    public final double walkin_gross_sales;
    public final double charge_gross_sales;
    public final double total_items_sold;
    public final double walkin_items_sold;
    public final double charge_items_sold;
    public final double total_vatable_sales;
    public final double total_non_vatable_sales;
    public final double total_vat;
    public final double total_cash_collected;
    public final double walkin_cash_payment;
    public final double walkin_check_payment;
    public final double charge_cash_payment;
    public final double total_charge_amount;
    public final double charge_check_payment;
    public final double total_collectible;
    public final double total_no_of_transactions;
    public final double walkin_trans;
    public final double charge_transactions;
    public final String business_name;
    public final String address;
    public final String date;
    public final String cashier;
    public final String printed_by;
    public final double total_delivery_charge;
    public final double total_discount;
    public final double total_check_collected;

    public Srpt_summary(double total_gross_sales, double walkin_gross_sales, double charge_gross_sales, double total_items_sold, double walkin_items_sold, double charge_items_sold, double total_vatable_sales, double total_non_vatable_sales, double total_vat, double total_cash_collected, double walkin_cash_payment, double walkin_check_payment, double charge_cash_payment, double total_charge_amount, double charge_check_payment, double total_collectible, double total_no_of_transactions, double walkin_trans, double charge_transactions, String business_name, String address, String date, String cashier, String printed_by, double total_delivery_charge, double total_discount, double total_check_collected) {
        this.total_gross_sales = total_gross_sales;
        this.walkin_gross_sales = walkin_gross_sales;
        this.charge_gross_sales = charge_gross_sales;
        this.total_items_sold = total_items_sold;
        this.walkin_items_sold = walkin_items_sold;
        this.charge_items_sold = charge_items_sold;
        this.total_vatable_sales = total_vatable_sales;
        this.total_non_vatable_sales = total_non_vatable_sales;
        this.total_vat = total_vat;
        this.total_cash_collected = total_cash_collected;
        this.walkin_cash_payment = walkin_cash_payment;
        this.walkin_check_payment = walkin_check_payment;
        this.charge_cash_payment = charge_cash_payment;
        this.total_charge_amount = total_charge_amount;
        this.charge_check_payment = charge_check_payment;
        this.total_collectible = total_collectible;
        this.total_no_of_transactions = total_no_of_transactions;
        this.walkin_trans = walkin_trans;
        this.charge_transactions = charge_transactions;
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.cashier = cashier;
        this.printed_by = printed_by;
        this.total_delivery_charge = total_delivery_charge;
        this.total_discount = total_discount;
        this.total_check_collected = total_check_collected;
    }

    public static void main(String[] args) {

        double total_gross_sales = 0;
        double walkin_gross_sales = 0;
        double charge_gross_sales = 0;
        double total_items_sold = 0;
        double walkin_items_sold = 0;
        double charge_items_sold = 0;
        double total_vatable_sales = 0;
        double total_non_vatable_sales = 0;
        double total_vat = 0;
        double total_cash_collected = 0;
        double walkin_cash_payment = 0;
        double walkin_check_payment = 0;
        double charge_cash_payment = 0;
        double total_charge_amount = 0;
        double charge_check_payment = 0;
        double total_collectible = 0;
        double total_no_of_transactions = 0;
        double walkin_trans = 0;
        double charge_transactions = 0;
        String business_name = "";
        String address = "";
        String date = "";
        String cashier = "";
        String printed_by = "";
        double total_delivery_charge = 0;
        double total_discount = 0;
        double total_check_collected = 0;

        Srpt_summary rpt=new Srpt_summary(total_gross_sales, walkin_gross_sales, charge_gross_sales, total_items_sold, walkin_items_sold, charge_items_sold, total_vatable_sales, total_non_vatable_sales, total_vat, total_cash_collected, walkin_cash_payment, walkin_check_payment, charge_cash_payment, total_charge_amount, charge_check_payment, total_collectible, total_no_of_transactions, walkin_trans, charge_transactions, business_name, address, date, cashier, printed_by, total_delivery_charge, total_discount, total_check_collected);
        

        JRViewer viewer = Srpt_summary.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void pdf_view(Srpt_summary to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JRViewer get_viewer(Srpt_summary to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_summary.jrxml";
            InputStream is = Srpt_summary.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

}
