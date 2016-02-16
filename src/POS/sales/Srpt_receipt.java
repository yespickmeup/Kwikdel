/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.util.DateType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author i1
 */
public class Srpt_receipt {

    public final List<field> fields;
    public final String business_name;
    public final String operated_by;
    public final String address;
    public final String tin_no;
    public final String serial_no;
    public final String permit_no;
    public final String datetime;
    public final String or_no;
    public final String items;
    public final double total_due;
    public final double cash;
    public final double change_due;
    public final String receipt_infos;
    public final String receipt_footer;
    public final double discount;
    public final String customer_name;
    public final String cashier_name;
    public final String discount_name;
    public final String pos_no;
    public final int total_qty;
    public final double vatable_sale;
    public final double zero_rate_sale;
    public final double vat_exempt_sale;
    public final double vat_percent;
    public final String acct_no;
    public final String trans_no;
    public final String check_bank;
    public final double check_amount;
    public final String telephone_number;
    public final String discount_customer_name;
    public final String discount_customer_id;
    public final String min_no;
    public final double addtl_service;
    public final String customer_address;
    public final String reference_no;
    public final double amount_due;
    public final String check_no;
    public Srpt_receipt(String business_name, String operated_by, String address, String tin_no, String serial_no, String permit_no, String datetime
            , String or_no, String items, double total_due, double cash, double change_due, String receipt_infos, String receipt_footer
            , double discount, String customer_name, String cashier_name, String discount_name, String pos_no, int total_qty
            , double vatable_sale, double zero_rate_sale, double vat_exempt_sale, double vat_percent, String acct_no, String trans_no
            , String check_bank, double check_amount, String telephone_number
            , String discount_customer_name, String discount_customer_id,String min_no,double addtl_service,String customer_address,String reference_no
            ,double amount_due,String check_no) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.operated_by = operated_by;
        this.address = address;
        this.tin_no = tin_no;
        this.serial_no = serial_no;
        this.permit_no = permit_no;
        this.datetime = datetime;
        this.or_no = or_no;
        this.items = items;
        this.total_due = total_due;
        this.cash = cash;
        this.change_due = change_due;
        this.receipt_infos = receipt_infos;
        this.receipt_footer = receipt_footer;
        this.discount = discount;
        this.customer_name = customer_name;
        this.cashier_name = cashier_name;
        this.discount_name = discount_name;
        this.pos_no = pos_no;
        this.total_qty = total_qty;
        this.vatable_sale = vatable_sale;
        this.zero_rate_sale = zero_rate_sale;
        this.vat_exempt_sale = vat_exempt_sale;
        this.vat_percent = vat_percent;
        this.acct_no = acct_no;
        this.trans_no = trans_no;
        this.check_bank = check_bank;
        this.check_amount = check_amount;
        this.telephone_number = telephone_number;
        this.discount_customer_name = discount_customer_name;
        this.discount_customer_id = discount_customer_id;
        this.min_no=min_no;
        this.addtl_service=addtl_service;
        this.customer_address=customer_address;
        this.reference_no=reference_no;
        this.amount_due=amount_due;
        this.check_no=check_no;
    }

    public static class field {

        String desc;
        Date date_added;
        double total;
        double qty;
        double selling_price;
        public field() {
        }

        public field(String desc, Date date_added, double total, double qty,double selling_price) {
            this.desc = desc;
            this.date_added = date_added;
            this.total = total;
            this.qty = qty;
            this.selling_price=selling_price;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        
        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
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
