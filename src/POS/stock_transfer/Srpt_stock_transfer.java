/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

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
public class Srpt_stock_transfer {
    
    public final List<Srpt_stock_transfer.field> fields;
    public final String from_location;
    public final String to_location;
    public final String reference_no;
    public final String remarks;
    public final String date_transfered;
    public final String business_name;
    public final String address;
    
    public Srpt_stock_transfer(String from_location, String to_location, String reference_no, String remarks, String date_transfered, String business_name, String address) {
        this.fields = new ArrayList();
        this.from_location = from_location;
        this.to_location = to_location;
        this.reference_no = reference_no;
        this.remarks = remarks;
        this.date_transfered = date_transfered;
        this.business_name = business_name;
        this.address = address;
    }
    
    public static class field {
        
        double qty;
        String barcode;
        String description;
        String unit;
        double cost;
        double amount;
        
        public field() {
        }
        
        public field(double qty, String barcode, String description, String unit, double cost, double amount) {
            this.qty = qty;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.cost = cost;
            this.amount = amount;
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
        
        public String getUnit() {
            return unit;
        }
        
        public void setUnit(String unit) {
            this.unit = unit;
        }
        
        public double getCost() {
            return cost;
        }
        
        public void setCost(double cost) {
            this.cost = cost;
        }
        
        public double getAmount() {
            return amount;
        }
        
        public void setAmount(double amount) {
            this.amount = amount;
        }
        
    }
    
    public static void main(String[] args) {
        String where = "";
        List<Srpt_stock_transfer.field> fields = ret_data(where);
        String from_location = "";
        String to_location = "";
        String reference_no = "";
        String remarks = "";
        String date_transfered = "";
        String business_name = "";
        String address = "";
        
        Srpt_stock_transfer rpt = new Srpt_stock_transfer(from_location, to_location, reference_no, remarks, date_transfered, business_name, address);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_stock_transfer.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static JasperReport compileJasper(String jrxml) {
        try {
            
            InputStream is = Srpt_stock_transfer.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static JRViewer get_viewer(Srpt_stock_transfer to, String jrxml) {
        
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
    
    public static List<Srpt_stock_transfer.field> ret_data(String where) {
        List<Srpt_stock_transfer.field> datas = new ArrayList();
        
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
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from stock_transfer_items"
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
                String conversion = rs.getString(19);
                String unit = rs.getString(20);
                int status = rs.getInt(21);
                String reference_no = rs.getString(22);
                String from_location_name = rs.getString(23);
                String from_location_id = rs.getString(24);
                String to_location_name = rs.getString(25);
                String to_location_id = rs.getString(26);
                
                double amount = qty * cost;
                Srpt_stock_transfer.field field = new Srpt_stock_transfer.field(qty, barcode, description, unit, cost, amount);
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
