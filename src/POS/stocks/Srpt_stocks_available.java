/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stocks;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Srpt_stocks_available {

    public final List<Srpt_stocks_available.field> fields;
    public final String business_name;
    public final String address;
    public final String date;

    public Srpt_stocks_available(String business_name, String address, String date) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
    }

    public static class field {

        double qty;
        String barcode;
        String description;
        double cost;
        double selling_price;
        double amount;
        String location_name;

        public field() {
        }

        public field(double qty, String barcode, String description, double cost, double selling_price, double amount, String location_name) {
            this.qty = qty;
            this.barcode = barcode;
            this.description = description;
            this.cost = cost;
            this.selling_price = selling_price;
            this.amount = amount;
            this.location_name = location_name;
        }

        public String getLocation_name() {
            return location_name;
        }

        public void setLocation_name(String location_name) {
            this.location_name = location_name;
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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
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
        List<Srpt_stocks_available.field> fields = ret_data(where);

        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
        String date = DateType.slash.format(new Date());
        Srpt_stocks_available rpt = new Srpt_stocks_available(business_name, address, date);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_stocks_available.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_stocks_available.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stocks_available to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_stocks_available.field> ret_data(String where) {
        List<Srpt_stocks_available.field> datas = new ArrayList();

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
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",location_name"
                    + ",location_id"
                    + " from items"
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
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                String location_name = rs.getString(26);
                String location_id = rs.getString(27);

                double qty = product_qty;
                double amount = (qty * selling_price);

                Srpt_stocks_available.field field = new field(qty, barcode, description, cost, selling_price, amount, location_name);
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
