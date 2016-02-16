/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

/**
 *
 * @author i1
 */
public class S1_sales_orders {

    public static class to_sales_items {

        public final int id;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public double product_qty;
        public final String unit;
        public final double conversion;
        public  double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String session_no;
        public String item_discount;
        public double discount;
        public double discount_amount;
        public String sales_no;
        public final int fixed_price;
        public final String supplier;
        public final String supplier_id;
        public final int vatable;
        public to_sales_items(int id, String barcode, String description, String generic_name, String category, String category_id
                , String classification, String classification_id, String sub_classification, String sub_classification_id
                , double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name
                , String item_type, int status, String session_no, String item_discount, double discount
                , double discount_amount, String sales_no,int fixed_price,String supplier,String supplier_id
                ,int vatable) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.session_no = session_no;
            this.item_discount = item_discount;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.sales_no = sales_no;
            this.fixed_price=fixed_price;
            this.supplier=supplier;
            this.supplier_id=supplier_id;
            this.vatable=vatable;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getItem_discount() {
            return item_discount;
        }

        public void setItem_discount(String item_discount) {
            this.item_discount = item_discount;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public String getSales_no() {
            return sales_no;
        }

        public void setSales_no(String sales_no) {
            this.sales_no = sales_no;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }
        
    }
}
