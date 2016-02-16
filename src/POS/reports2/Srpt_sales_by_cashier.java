/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

import POS.sales.Srpt_receipt;
import static POS.sales.Srpt_receipt.compileJasper;
import java.io.InputStream;
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
public class Srpt_sales_by_cashier {

    public final List<Srpt_sales_by_cashier.field> fields;

    public Srpt_sales_by_cashier() {
        this.fields = new ArrayList();
    }

    public static class field {

        double qty;
        String barcode;
        String description;
        double price;
        double amount;
        String cashier;

        public field() {
        }

        public field(double qty, String barcode, String description, double price, double amount, String cashier) {
            this.qty = qty;
            this.barcode = barcode;
            this.description = description;
            this.price = price;
            this.amount = amount;
            this.cashier = cashier;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCashier() {
            return cashier;
        }

        public void setCashier(String cashier) {
            this.cashier = cashier;
        }
    }

    public static void main(String[] args) {

        List<Srpt_sales_by_cashier.field> datas = new ArrayList();
        for (int i = 0; i < 5; i++) {

            double qty = 10;
            String barcode = "";
            String description = "Fortress";
            double price = 100;
            double amount = qty * price;
            String cashier = "";
            Srpt_sales_by_cashier.field to = new field(qty, barcode, description, price, amount, cashier);
            datas.add(to);
        }
        Srpt_sales_by_cashier rpt = new Srpt_sales_by_cashier();
        rpt.fields.addAll(datas);

        JRViewer viewer = Srpt_sales_by_cashier.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void pdf_view(Srpt_sales_by_cashier to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_sales_by_cashier to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_receipt.jrxml";
            InputStream is = Srpt_sales_by_cashier.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

}
