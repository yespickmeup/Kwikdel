/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir_sales_ors;

import POS.my_reports.Srpt_collections;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Sales_ors {

    public static class to_bir_sales_ors {

        public final int id;
        public final int issuance_refid;
        public final String orno;
        public final String trn;
        public final String leu_orno;
        public final double tendered;
        public final double disc_by_total;
        public final String sc_id;
        public final int disc_type;
        public final String paymt_type;
        public final String cust_addr;
        public final String cust_tin;
        public final String customer_name;
        public final String clerk_name;
        public final int status;
        public final String created;
        public final String modified;
        public final String modified_by;
        public final String terminal;
        public final String cashier_name;
        public final String entity_name;
        public final String check_number;

        public to_bir_sales_ors(int id, int issuance_refid, String orno, String trn, String leu_orno, double tendered, double disc_by_total, String sc_id, int disc_type, String paymt_type, String cust_addr, String cust_tin, String customer_name, String clerk_name, int status, String created, String modified, String modified_by, String terminal, String cashier_name, String entity_name, String check_number) {
            this.id = id;
            this.issuance_refid = issuance_refid;
            this.orno = orno;
            this.trn = trn;
            this.leu_orno = leu_orno;
            this.tendered = tendered;
            this.disc_by_total = disc_by_total;
            this.sc_id = sc_id;
            this.disc_type = disc_type;
            this.paymt_type = paymt_type;
            this.cust_addr = cust_addr;
            this.cust_tin = cust_tin;
            this.customer_name = customer_name;
            this.clerk_name = clerk_name;
            this.status = status;
            this.created = created;
            this.modified = modified;
            this.modified_by = modified_by;
            this.terminal = terminal;
            this.cashier_name = cashier_name;
            this.entity_name = entity_name;
            this.check_number = check_number;
        }
    }

    public static List<Srpt_collections.field> ret_data(String where) {
        List<Srpt_collections.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect_bir();
            String s0 = "select "
                    + "id"
                    + ",issuance_refid"
                    + ",orno"
                    + ",trn"
                    + ",leu_orno"
                    + ",tendered"
                    + ",disc_by_total"
                    + ",sc_id"
                    + ",disc_type"
                    + ",paymt_type"
                    + ",cust_addr"
                    + ",cust_tin"
                    + ",customer_name"
                    + ",clerk_name"
                    + ",status"
                    + ",created"
                    + ",modified"
                    + ",modified_by"
                    + ",terminal"
                    + ",cashier_name"
                    + ",entity_name"
                    + ",check_number"
                    + " from bir_sales_ors"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int issuance_refid = rs.getInt(2);
                String orno = rs.getString(3);
                String trn = rs.getString(4);
                String leu_orno = rs.getString(5);
                double tendered = rs.getDouble(6);
                double disc_by_total = rs.getDouble(7);
                String sc_id = rs.getString(8);
                int disc_type = rs.getInt(9);
                String paymt_type = rs.getString(10);
                String cust_addr = rs.getString(11);
                String cust_tin = rs.getString(12);
                String customer_name = rs.getString(13);
                String clerk_name = rs.getString(14);
                int status = rs.getInt(15);
                String created = rs.getString(16);
                String modified = rs.getString(17);
                String modified_by = rs.getString(18);
                String terminal = rs.getString(19);
                String cashier_name = rs.getString(20);
                String entity_name = rs.getString(21);
                String check_number = rs.getString(22);

                String or_no = orno.replaceAll("T1-", "");
                String dr_no = "";
                String date = DateType.convert_slash_datetime(created);
                String customer = customer_name;
                String transaction_type = "Walkin";
                String payment_type = paymt_type;
                double service_amount = 0;
                double discount_amount = disc_by_total;
                double amount_due = tendered;
                String user = cashier_name;
                double cash = 0;
                double service_charge = 0;
                double check_amount = 0;
                if (paymt_type.equalsIgnoreCase("cash")) {
                    cash = tendered;
                } else {
                    check_amount = tendered;
                }

                double discount = disc_by_total;
                double gross_amount = tendered;
                 Srpt_collections.field field = new Srpt_collections.field(or_no, dr_no, date, customer, transaction_type, payment_type, service_amount, discount_amount
                        , tendered, user, cash, service_charge, check_amount, discount_amount,gross_amount,status);
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
