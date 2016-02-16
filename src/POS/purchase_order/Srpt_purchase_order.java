/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_purchase_order {

    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String po_no;
    public final List<field> fields;

    public Srpt_purchase_order(String business_name, String business_owner, String business_address, String date_printed, String sales_date
            , String printed_by, String po_no) {
        this.business_name = business_name;
        this.business_owner = business_owner;
        this.business_address = business_address;
        this.date_printed = date_printed;
        this.sales_date = sales_date;
        this.printed_by = printed_by;
        this.po_no = po_no;
        this.fields = new ArrayList();

    }

    public static class field {

        String date_added;
        String supplier;
        String barcode;
        String description;
        double qty;
        double cost;
        String category;
        double conversion;
        String unit;
        double total;

        public field() {
        }

        public field(String date_added, String supplier, String barcode, String description, double qty, double cost, String category
                , double conversion, String unit,double total) {
            this.date_added = date_added;
            this.supplier = supplier;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.conversion = conversion;
            this.unit = unit;
            this.total=total;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
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

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
        
    }

    public static void main(String[] args) {

        List<field> fields = new ArrayList();
        for (int i = 0; i < 30; i++) {
            String date_added = "date";
            String supplier = "";
            if (i >= 0 && i <= 10) {
                supplier = "Supplier 1";
            }
            if (i >=11 && i <= 20) {
                supplier = "Supplier 2";
            }
            if (i >=21 && i <= 30) {
                supplier = "Supplier 3";
            }
            if (i > 31 && i == 40) {
                supplier = "Supplier 4";
            }
            if (i > 41 && i == 50) {
                supplier = "Supplier 5";
            }
            String barcode = "barcode" + i;
            String description = "description " + i;
            double qty = i + 1;
            double cost = 50 + i;
            String category = "category " + i;
            double conversion = 1;
            String unit = "asd";
            double total=qty*cost;
            field to = new field(date_added, supplier, barcode, description, qty, cost, category, conversion, unit,total);
            fields.add(to);
        }

        String business_name = "Fortune Three Enterprises";
        String business_owner = "Ernesto C.Quiamco";
        String business_address = "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String po_no = "po-1";
        Srpt_purchase_order rpt = new Srpt_purchase_order(business_name, business_owner, business_address, date_printed, sales_date, printed_by, po_no);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_purchase_order.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_purchase_order.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_purchase_order to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
