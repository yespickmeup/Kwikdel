/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

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
 * @author Ronald
 */
public class Srpt_delivery_receipt {

    public final List<field> fields;
    public final String transaction_no;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String operated_by;

    public Srpt_delivery_receipt(String transaction_no, String business_name, String address, String contact_no, String operated_by) {
        this.fields = new ArrayList();
        this.transaction_no = transaction_no;
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.operated_by = operated_by;
    }

    public static class field {

        double qty;
        String description;
        double price;
        double amount;
        String customer_name;
        String customer_id;
        String customer_contact_no;
        String customer_address;
        String dispatch_time;
        String driver;
        String checked_by;
        String released_by;
        String clearance_no;
        String released_date;
        double amount_due;
        double discount;
        double addtl_service;
        String discount_customer_name;
        double total_due;
        String or_no;
        String vehicle_no;

        public field(double qty, String description, double price, double amount, String customer_name, String customer_id, String customer_contact_no, String customer_address, String dispatch_time, String driver, String checked_by, String released_by, String clearance_no, String released_date, double amount_due, double discount, double addtl_service, String discount_customer_name, double total_due, String or_no, String vehicle_no) {
            this.qty = qty;
            this.description = description;
            this.price = price;
            this.amount = amount;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.customer_contact_no = customer_contact_no;
            this.customer_address = customer_address;
            this.dispatch_time = dispatch_time;
            this.driver = driver;
            this.checked_by = checked_by;
            this.released_by = released_by;
            this.clearance_no = clearance_no;
            this.released_date = released_date;
            this.amount_due = amount_due;
            this.discount = discount;
            this.addtl_service = addtl_service;
            this.discount_customer_name = discount_customer_name;
            this.total_due = total_due;
            this.or_no = or_no;
            this.vehicle_no = vehicle_no;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
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

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_contact_no() {
            return customer_contact_no;
        }

        public void setCustomer_contact_no(String customer_contact_no) {
            this.customer_contact_no = customer_contact_no;
        }

        public String getCustomer_address() {
            return customer_address;
        }

        public void setCustomer_address(String customer_address) {
            this.customer_address = customer_address;
        }

        public String getDispatch_time() {
            return dispatch_time;
        }

        public void setDispatch_time(String dispatch_time) {
            this.dispatch_time = dispatch_time;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getChecked_by() {
            return checked_by;
        }

        public void setChecked_by(String checked_by) {
            this.checked_by = checked_by;
        }

        public String getReleased_by() {
            return released_by;
        }

        public void setReleased_by(String released_by) {
            this.released_by = released_by;
        }

        public String getClearance_no() {
            return clearance_no;
        }

        public void setClearance_no(String clearance_no) {
            this.clearance_no = clearance_no;
        }

        public String getReleased_date() {
            return released_date;
        }

        public void setReleased_date(String released_date) {
            this.released_date = released_date;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getAddtl_service() {
            return addtl_service;
        }

        public void setAddtl_service(double addtl_service) {
            this.addtl_service = addtl_service;
        }

        public String getDiscount_customer_name() {
            return discount_customer_name;
        }

        public void setDiscount_customer_name(String discount_customer_name) {
            this.discount_customer_name = discount_customer_name;
        }

        public double getTotal_due() {
            return total_due;
        }

        public void setTotal_due(double total_due) {
            this.total_due = total_due;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public String getVehicle_no() {
            return vehicle_no;
        }

        public void setVehicle_no(String vehicle_no) {
            this.vehicle_no = vehicle_no;
        }

    }

    public static void main(String[] args) {

        List<Srpt_delivery_receipt.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            double qty = 1;
            String description = "Description ";
            double price = 1;
            double amount = 1;
            String customer_name = "";
            String customer_id = "";
            String customer_contact_no = "";
            String customer_address = "";
            String dispatch_time = "";
            String driver = "";
            String checked_by = "";
            String released_by = "";
            String clearance_no = "";
            String released_date = "";
            double amount_due = 0;
            double discount = 0;
            double addtl_service = 0;
            String discount_customer_name = "";
            double total_due = 0;
            String or_no = "0000000" + i;
            String vehicle_no = "";
            Srpt_delivery_receipt.field f = new Srpt_delivery_receipt.field(qty, description, price, amount, customer_name, customer_id, customer_contact_no
                    , customer_address, dispatch_time, driver, checked_by, released_by, clearance_no, released_date, amount_due, discount, addtl_service
                    , discount_customer_name, total_due,or_no, vehicle_no);

            fields.add(f);
        }
        String transaction_no = "No. 281567";
        String business_name = "Kwikdel";
        String address = "25 Dr Locsin, Dumaguete, Negros Oriental, Philippines";
        String contact_no = "Phone: +63(35)4226888";
        String customer_name = "St. Paul University";
        String customer_id = "00001";
        String customer_contact_no = "";
        String customer_address = "Dumaguete, Negros Oriental, Philippines";
        String checked_by = "";
        String dispatch_time = "";
        String vehicle_no = "";
        String driver = "";
        String released_by = "";
        String clearance_no = "";
        String released_date = "";
        double amount_due = 0;
        String operated_by = "";
        double discount = 0;
        double addtl_service = 0;
        String discount_customer_name = "";
        double total_duel = 0;
        Srpt_delivery_receipt rpt = new Srpt_delivery_receipt(transaction_no, business_name, address, contact_no, operated_by);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_delivery_receipt_1.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_delivery_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_delivery_receipt to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
