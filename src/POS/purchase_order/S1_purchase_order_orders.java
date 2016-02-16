/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.purchase_order;

/**
 *
 * @author Maytopacka
 */
public class S1_purchase_order_orders {

    public static class to_purchase_order_orders {

        public final int id;
        public final String po_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String barcode;
        public final String description;
        public double qty;
        public double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public final double conversion;
        public final String unit;
        public double total;

        public to_purchase_order_orders(int id, String po_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, double conversion, String unit, double total) {
            this.id = id;
            this.po_no = po_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.conversion = conversion;
            this.unit = unit;
            this.total = total;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }
}
