/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

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
 * @author Maytopacka
 */
public class Srpt_stocks_left_supplier {

    public final List<field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;

    public Srpt_stocks_left_supplier(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR) {
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

        String barcode;
        String description;
        String category;
        double product_qty;
        String unit;
        double conversion;
        double selling_price;
        double total;

        public field() {
        }

        public field(String barcode, String description, String category, double product_qty, String unit, double conversion, double selling_price, double total) {
            this.barcode = barcode;
            this.description = description;
            this.category = category;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
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

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
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

        List<Srpt_stocks_left_supplier.field> fields = ret_data("");
      
        String business_name = "Fortune Three Enterprises";
        String business_owner = "Ernesto C.Quiamco";
        String business_address = "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_stocks_left_supplier rpt = new Srpt_stocks_left_supplier(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_stock_left_supplier.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_stocks_left_supplier.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stocks_left_supplier to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_stocks_left_supplier.field> ret_data(String supplier11) {
        List<Srpt_stocks_left_supplier.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",supplier"
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
                    + " from items where "
                    + " supplier like '%" + supplier11 + "%' and status='"+"1"+"' "
                    + "  "
                    + " order by supplier asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);

                String category = rs.getString(5);

                double product_qty = rs.getDouble(11);
//                double unit = rs.getDouble(12);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);

                int status = rs.getInt(18);

                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double total = product_qty * selling_price;
                Srpt_stocks_left_supplier.field to = new field(barcode, description, category, product_qty, unit, conversion, cost, total);

                datas.add(to);
                List<Srpt_stocks_left_supplier.field> multi = new ArrayList();
                if (multi_level_pricing == 1) {
                    String s2 = "select "
                            + "id"
                            + ",barcode"
                            + ",description"
                            + ",unit"
                            + ",conversion"
                            + ",price"
                            + " from item_multi_level_pricing where "
                            + " barcode ='" + barcode + "' and unit<>'" + "PC" + "'"
                            + " ";
                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(s2);
                    while (rs2.next()) {
                        String unit1 = rs2.getString(4);
                        double conversion1 = rs2.getDouble(5);
                        double price1 = rs2.getDouble(6);
                        double p_qty = product_qty / conversion1;
                        int idd = 0;
                        double qtyy = p_qty;
                        String unitt = unit1;
                        double pricee = price1;
                        double inv_qty = 0;
                        double conversionn = conversion1;
                        double total2 = qtyy * cost;
                        Srpt_stocks_left_supplier.field mu = new field(barcode, description
                                , category, p_qty, unitt, conversionn, cost, total2);
                        datas.add(mu);
                    }
                }

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
