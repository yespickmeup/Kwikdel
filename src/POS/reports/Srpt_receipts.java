/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * @author Maytopacka
 */
public class Srpt_receipts {

    public final List<field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;

    public Srpt_receipts(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.business_owner = business_owner;
        this.business_address = business_address;
        this.date_printed = date_printed;
        this.sales_date = sales_date;
        this.printed_by = printed_by;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
    }

    public static class field {

        String date_added;
        String barcode;
        String description;
        double product_qty;
        double selling_price;
        String category;
        String unit;
        double total;

        public field() {
        }

        public field(String date_added, String barcode, String description, double product_qty, double selling_price, String category, String unit, double total) {
            this.date_added = date_added;
            this.barcode = barcode;
            this.description = description;
            this.product_qty = product_qty;
            this.selling_price = selling_price;
            this.category = category;
            this.unit = unit;
            this.total = total;
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

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static void main(String[] args) {

        List<Srpt_receipts.field> fields = new ArrayList();
        for (int i = 0; i < 50; i++) {

            String date_added = "June 23,2013";
            String barcode = "Barcode " + i;
            String description = "Description " + i;
            double product_qty = 1 + i;
            double selling_price = 100 + i;
            String category = "cate";
            String unit = "pc";
            double total = 100 * i;
            if (i >= 10 && i <= 20) {
                date_added = "June 24,2013";
            }
            if (i >= 21 && i <= 30) {
                date_added = "June 25,2013";
            }
            if (i >= 31 && i <= 40) {
                date_added = "June 26,2013";
            }
            if (i >= 41 && i <= 50) {
                date_added = "June 27,2013";
            }
            Srpt_receipts.field to = new field(date_added, barcode, description, product_qty, selling_price, category, unit, total);
            fields.add(to);
        }

        String business_name = "Fortune Three Enterprises";
        String business_owner = "Ernesto C.Quiamco";
        String business_address = "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_receipts rpt = new Srpt_receipts(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_receipts.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_receipts.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_receipts to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_receipts.field> ret_data(String date_from, String date_to) {
        List<Srpt_receipts.field> datas = new ArrayList();

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
                    + ",sum(qty)"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + " from receipt_items where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " group by barcode,unit order by date_added asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = DateType.convert_jan_1_2013_datetime2(rs.
                        getString(5));
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
                int conversion = rs.getInt(19);
                String unit = rs.getString(20);

                double product_qty = qty;
                double selling_price = cost;

                double total = product_qty * selling_price;
                Srpt_receipts.field to = new Srpt_receipts.field(date_added, barcode, description, product_qty, selling_price, category, unit, total);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_receipts.field> ret_data_by_supplier(String date_from, String date_to, String supplier1) {
        List<Srpt_receipts.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_delivered"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",sum(qty)"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + " from receipt_items where "
                    + " date(date_delivered) between '" + date_from + "' and '" + date_to + "'"
                    + " and supplier like '%" + supplier1 + "%'"
                    + " group by barcode,unit order by date_added asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = DateType.convert_jan_1_2013_sf(rs.
                        getString(5));
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
                int conversion = rs.getInt(19);
                String unit = rs.getString(20);
                category = supplier;

                double product_qty = qty;
                double selling_price = cost;

                double total = product_qty * selling_price;
                Srpt_receipts.field to = new Srpt_receipts.field(date_added, barcode, description, product_qty, selling_price, category, unit, total);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
