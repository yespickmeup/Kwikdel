/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_sales_by_item {

    public final List<field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;

    public Srpt_sales_by_item(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR) {
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
        String date_added;
        String user_name;
        String item_type;
        String item_discount;
        double discount_amount;
        int fixed_price;
        String supplier;
        int vatable;
        double total;

        public field() {
        }

        public field(String barcode, String description, String category, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, String item_discount, double discount_amount, int fixed_price, String supplier, int vatable, double total) {
            this.barcode = barcode;
            this.description = description;
            this.category = category;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.item_discount = item_discount;
            this.discount_amount = discount_amount;
            this.fixed_price = fixed_price;
            this.supplier = supplier;
            this.vatable = vatable;
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

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public int getFixed_price() {
            return fixed_price;
        }

        public void setFixed_price(int fixed_price) {
            this.fixed_price = fixed_price;
        }

        public String getItem_discount() {
            return item_discount;
        }

        public void setItem_discount(String item_discount) {
            this.item_discount = item_discount;
        }

        public String getItem_type() {
            return item_type;
        }

        public void setItem_type(String item_type) {
            this.item_type = item_type;
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

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
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

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getVatable() {
            return vatable;
        }

        public void setVatable(int vatable) {
            this.vatable = vatable;
        }

    }

    public static void main(String[] args) {

        List<Srpt_sales_by_item.field> fields = new ArrayList();
        for (int i = 0; i < 50; i++) {
            String barcode = "barcode" + i;
            String description = "description " + i;
            String category = "category1";
            double product_qty = i;
            String unit = "pc";
            double conversion = 1;
            double selling_price = 100;
            String date_added = "01/01/1992";
            String user_name = "user_name";
            String item_type = "item type";
            String item_discount = "discount";
            double discount_amount = 10 + i;
            int fixed_price = 1;
            String supplier = "supplier" + i;
            int vatable = 1;
            double total = 100 + i;
            if (i >= 10 && i <= 20) {
                category = "category2";
            }
            if (i >= 21 && i <= 30) {
                category = "category3";
            }
            if (i >= 31 && i <= 40) {
                category = "category4";
            }
            if (i >= 41 && i <= 50) {
                category = "category5";
            }

            Srpt_sales_by_item.field to = new field(barcode, description, category, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, item_discount, discount_amount, fixed_price, supplier, vatable, total);

            fields.add(to);
        }

        String business_name = "St. Ezekiel Multipurpose Cooperative";
        String business_owner = "Satellite Office: SEMCO Building, Caidiocan, Valencia";
        String business_address = "Main Office: Valencia Training Center, South Pob., Valencia. Telephone No. (035) 423-8007";
        String date_printed = "JUNE 24,2013";
        String sales_date = "JUNE 24,2013";
        String printed_by = "USER NAME";
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_sales_by_item rpt = new Srpt_sales_by_item(business_name, business_owner, business_address
                , date_printed, sales_date, printed_by,SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_by_item.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_by_item.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_by_item to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_sales_by_item.field> ret_data(String date_from, String date_to, String category1) {
        List<Srpt_sales_by_item.field> datas = new ArrayList();

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
                    + ",sum(product_qty)"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + " from sales_items where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and category like'%" + category1 + "%' and status='"+"0"+"' group by description,selling_price order by category asc "
                    + " ";

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
                String unit = "";//rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                double total = (product_qty * selling_price) - discount_amount;
//                if (fixed_price == 0) {
//                    total = selling_price - discount_amount;
//                }
                Srpt_sales_by_item.field to = new field(barcode, description, category, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, item_discount, discount_amount, fixed_price, supplier, vatable, total);

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
