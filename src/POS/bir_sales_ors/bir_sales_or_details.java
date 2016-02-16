/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir_sales_ors;

import POS.my_reports.Srpt_collections_items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class bir_sales_or_details {

    public static class to_bir_sales_or_details {

        public final int id;
        public final int bir_sales_or_id;
        public final int issuance_detail_refid;
        public final String dscr;
        public final String lookup_code;
        public final String brand;
        public final String generic;
        public final String catalog;
        public final String category;
        public final double qty;
        public final double prc;
        public final double disc;
        public final int disc_type;
        public final int is_vat;
        public final int status;

        public to_bir_sales_or_details(int id, int bir_sales_or_id, int issuance_detail_refid, String dscr, String lookup_code, String brand, String generic, String catalog, String category, double qty, double prc, double disc, int disc_type, int is_vat, int status) {
            this.id = id;
            this.bir_sales_or_id = bir_sales_or_id;
            this.issuance_detail_refid = issuance_detail_refid;
            this.dscr = dscr;
            this.lookup_code = lookup_code;
            this.brand = brand;
            this.generic = generic;
            this.catalog = catalog;
            this.category = category;
            this.qty = qty;
            this.prc = prc;
            this.disc = disc;
            this.disc_type = disc_type;
            this.is_vat = is_vat;
            this.status = status;
        }
    }

    public static List<Srpt_collections_items.field> ret_data(String where) {
        List<Srpt_collections_items.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect_bir();
            String s0 = "select "
                    + "i.id"
                    + ",i.bir_sales_or_id"
                    + ",i.issuance_detail_refid"
                    + ",i.dscr"
                    + ",i.lookup_code"
                    + ",i.brand"
                    + ",i.generic"
                    + ",i.catalog"
                    + ",i.category"
                    + ",sum(i.qty)"
                    + ",i.prc"
                    + ",i.disc"
                    + ",i.disc_type"
                    + ",i.is_vat"
                    + ",i.status"
                    + " from bir_sales_or_details i"
                    + " join bir_sales_ors bir "
                    + " on i.bir_sales_or_id = bir.id "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int bir_sales_or_id = rs.getInt(2);
                int issuance_detail_refid = rs.getInt(3);
                String dscr = rs.getString(4);
                String lookup_code = rs.getString(5);
                String brand = rs.getString(6);
                String generic = rs.getString(7);
                String catalog = rs.getString(8);
                String category = rs.getString(9);
                double qty = rs.getDouble(10);
                double prc = rs.getDouble(11);
                double disc = rs.getDouble(12);
                int disc_type = rs.getInt(13);
                int is_vat = rs.getInt(14);
                int status = rs.getInt(15);

                String barcode = lookup_code;
                String description = dscr;

                double selling_price = prc;
                double amount = selling_price * qty;
                String or_no = "" + bir_sales_or_id;
                String dr_no = "";

                String payment_type = "Cash";
                String transaction_type = "Walkin";
                int stat = status;

                Srpt_collections_items.field field = new Srpt_collections_items.field(barcode, description, qty, selling_price, amount, or_no, dr_no, catalog, payment_type, transaction_type, stat);
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
