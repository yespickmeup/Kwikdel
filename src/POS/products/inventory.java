/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.products;

import POS.items.S1_items;
import POS.sales.S1_multi_pricing;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class inventory {

    public static class to_inventory {

        public final int id;
        public final int is_active;
        public final int is_transient;
        public final int is_assembly;
        public final double price;
        public final String lookup_code;
        public final String description;
        public final String s_description;
        public final double quantity;
        public final double reorder;
        public final double cost;
        public final int auto_compute_price;
        public final String sreg_disc;
        public final int with_sc_disc;
        public final String measured_in;
        public final String category;
        public final String brand;
        public final String generic;
        public final String catalog;
        public final String markup;
        public final String deductible_tax;
        public final String created;
        public final String modified;
        public final int product_id;

        public to_inventory(int id, int is_active, int is_transient, int is_assembly, double price, String lookup_code, String description, String s_description, double quantity, double reorder, double cost, int auto_compute_price, String sreg_disc, int with_sc_disc, String measured_in, String category, String brand, String generic, String catalog, String markup, String deductible_tax, String created, String modified, int product_id) {
            this.id = id;
            this.is_active = is_active;
            this.is_transient = is_transient;
            this.is_assembly = is_assembly;
            this.price = price;
            this.lookup_code = lookup_code;
            this.description = description;
            this.s_description = s_description;
            this.quantity = quantity;
            this.reorder = reorder;
            this.cost = cost;
            this.auto_compute_price = auto_compute_price;
            this.sreg_disc = sreg_disc;
            this.with_sc_disc = with_sc_disc;
            this.measured_in = measured_in;
            this.category = category;
            this.brand = brand;
            this.generic = generic;
            this.catalog = catalog;
            this.markup = markup;
            this.deductible_tax = deductible_tax;
            this.created = created;
            this.modified = modified;
            this.product_id = product_id;
        }
    }

    public static void main2(String[] args) {
        List<to_inventory> datas = ret_data("");
        for (to_inventory to : datas) {
            int id=-1;
            String barcode=to.lookup_code;
            String description=to.description;
            String generic_name="";
            String category="";
            String category_id="";
            String classification="";
            String classification_id="";
            String sub_classification="";
            String sub_classification_id="";
            double product_qty=0;
            String unit=to.measured_in;
            double conversion=1;
            double selling_price=to.price;
            String date_added=DateType.datetime.format(new Date());
            String user_name="";
            String item_type="";
            int status=1;
            String supplier="";
            int fixed_price=1;
            double cost=to.cost;
            String supplier_id="";
            int multi_level_pricing=0;
            List<S1_multi_pricing.to_multi_pricing> multi=new ArrayList();
            int vatable=1;
            double reorder_level=to.reorder;
            S1_items.to_items to1=new S1_items.to_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, multi, vatable, reorder_level,"","");
            S1_items.add_items(to1);
        }
    }

    public static List<to_inventory> ret_data(String where) {
        List<to_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "is_active"
                    + ",is_active"
                    + ",is_transient"
                    + ",is_assembly"
                    + ",price"
                    + ",lookup_code"
                    + ",description"
                    + ",s_description"
                    + ",quantity"
                    + ",reorder"
                    + ",cost"
                    + ",auto_compute_price"
                    + ",sreg_disc"
                    + ",with_sc_disc"
                    + ",measured_in"
                    + ",category"
                    + ",brand"
                    + ",generic"
                    + ",catalog"
                    + ",markup"
                    + ",deductible_tax"
                    + ",created"
                    + ",modified"
                    + ",product_id"
                    + " from product_inv_view  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int is_active = rs.getInt(2);
                int is_transient = rs.getInt(3);
                int is_assembly = rs.getInt(4);
                double price = rs.getDouble(5);
                String lookup_code = rs.getString(6);
                String description = rs.getString(7);
                String s_description = rs.getString(8);
                double quantity = rs.getDouble(9);
                double reorder = rs.getDouble(10);
                double cost = rs.getDouble(11);
                int auto_compute_price = rs.getInt(12);
                String sreg_disc = rs.getString(13);
                int with_sc_disc = rs.getInt(14);
                String measured_in = rs.getString(15);
                String category = rs.getString(16);
                String brand = rs.getString(17);
                String generic = rs.getString(18);
                String catalog = rs.getString(19);
                String markup = rs.getString(20);
                String deductible_tax = rs.getString(21);
                String created = rs.getString(22);
                String modified = rs.getString(23);
                int product_id = rs.getInt(24);

                to_inventory to = new to_inventory(id, is_active, is_transient, is_assembly, price, lookup_code, description, s_description, quantity, reorder, cost, auto_compute_price, sreg_disc, with_sc_disc, measured_in, category, brand, generic, catalog, markup, deductible_tax, created, modified, product_id);
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
