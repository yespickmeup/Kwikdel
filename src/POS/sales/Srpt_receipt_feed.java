/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.util.DateType;
import java.io.InputStream;
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

/**
 *
 * @author Guinness
 */
public class Srpt_receipt_feed {

    public final List<Srpt_receipt_feed.field> fields;
    public final String sold_to;
    public final String date;
    public final String tin_no;
    public final String terms;
    public final String address;
    public final String id_no;
    public final String business_style;

    public final double total_sales_vat_inclusive;
    public final double less_vat;
    public final double net_of_vat;
    public final double discount;
    public final double amount_due;
    public final double add_vat;
    public final double total_amount_due;

    public final double vatable_sales;
    public final double vat_exempt_sales;
    public final double zero_rated_sales;
    public final double vat_amount;

    public Srpt_receipt_feed(String sold_to, String date, String tin_no, String terms, String address, String id_no, String business_style, double total_sales_vat_inclusive, double less_vat, double net_of_vat, double discount, double amount_due, double add_vat, double total_amount_due, double vatable_sales, double vat_exempt_sales, double zero_rated_sales, double vat_amount) {
        this.fields = new ArrayList();
        this.sold_to = sold_to;
        this.date = date;
        this.tin_no = tin_no;
        this.terms = terms;
        this.address = address;
        this.id_no = id_no;
        this.business_style = business_style;
        this.total_sales_vat_inclusive = total_sales_vat_inclusive;
        this.less_vat = less_vat;
        this.net_of_vat = net_of_vat;
        this.discount = discount;
        this.amount_due = amount_due;
        this.add_vat = add_vat;
        this.total_amount_due = total_amount_due;
        this.vatable_sales = vatable_sales;
        this.vat_exempt_sales = vat_exempt_sales;
        this.zero_rated_sales = zero_rated_sales;
        this.vat_amount = vat_amount;
    }

    public static class field {

        double qty;
        String unit;
        String description;
        double unit_price;
        double amount;
        
        public field() {
        }
        public field(double qty, String unit, String description, double unit_price, double amount) {
            this.qty = qty;
            this.unit = unit;
            this.description = description;
            this.unit_price = unit_price;
            this.amount = amount;
        }
    }
    
      public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_receipt.jrxml";
            InputStream is = Srpt_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        
        List<Srpt_receipt.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_receipt.field tbar = new Srpt_receipt.field("desc" + i, new Date(),  9, 20.5 + i,2+i);
            fields.add(tbar);
        }
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");        
       
        String tin_no = System.getProperty("tin_no", "TIN no: 000000");
        String serial_no = System.getProperty("serial_no", "SN 000001");
        String permit_no = System.getProperty("permit_no", "Permit No 00000011");
        String datetime = DateType.slash_w_time.format(new Date());
        String or_no = System.getProperty("or_no", "OR NO. 000000000001");
        String items = System.getProperty("items", "");
        double total_due = 0;
        double cash = 0;
        double change_due = 0;
        String receipt_infos = System.getProperty("receipt_infos", "");
        String receipt_footer = System.getProperty("receipt_footer", "This is an unofficial receipt");
        double discount = 0;
        String customer_name = "Ronald Pascua";
        String cashier_name = "cashier";
        String discount_name = "SENIOR CIT";
        String pos_no = "POS 1";
        int total_qty = 100;
        double vatable_sale = 10;
        double zero_rate_sale = 20;
        double vat_exempt_sale = 30;
        double vat_percent = 40;
        String accreditation_no = "Accreditation No. 000-0000000000-000000";
        String trans_no = "0000000001";
        String check_bank = "bank";
        double check_amount = 100;
        String telephone_number = "please call:asdasd";
        String discount_customer_name = "customer";
        String discount_customer_id = "-0000001";
        String min_no="";
        double addtl_service=20;
        String customer_address="";
        double amount_due=0;
        Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash
                , change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale
                , zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number
                , discount_customer_name, discount_customer_id,min_no,addtl_service,customer_address,"",amount_due,"");
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_receipt.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_receipt to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_receipt.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_receipt to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
