/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class S2_customers {

    public static class to_customers {

        public final int id;
        public final String account;
        public final String first_name;
        public final String last_name;
        public final String mi;
        public final String company;
        public final String location;
        public final String contact;
        public final int is_active;
        public final String created;
        public final String modified;

        public to_customers(int id, String account, String first_name, String last_name, String mi, String company, String location, String contact, int is_active, String created, String modified) {
            this.id = id;
            this.account = account;
            this.first_name = first_name;
            this.last_name = last_name;
            this.mi = mi;
            this.company = company;
            this.location = location;
            this.contact = contact;
            this.is_active = is_active;
            this.created = created;
            this.modified = modified;
        }
    }

    public static void main2(String[] args) {
        List<to_customers> datas = ret_data("");
        for (to_customers to : datas) {
            int id = 0;
            String customer_name = "";
            String customer_no=to.account;
            String contact_no=to.contact;
            double credit_limit=0;
            String address=to.location;
            double term=0;
            String location=to.location;
            double balance=0;
            double discount=0;
            String account=to.account;
            String first_name=to.first_name;
            String last_name=to.last_name;
            String mi=to.mi;
            
            S1_customers.to_customers to1=new S1_customers.to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi,0);
            S1_customers.add_customers(to1);
        }
    }

    public static List<to_customers> ret_data(String where) {
        List<to_customers> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "id"
                    + ",account"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",company"
                    + ",location"
                    + ",contact"
                    + ",is_active"
                    + ",created"
                    + ",modified"
                    + " from customers  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String first_name = rs.getString(3);
                String last_name = rs.getString(4);
                System.out.println(first_name + " " + last_name);
                String mi = rs.getString(5);
                String company = rs.getString(6);
                String location = rs.getString(7);
                String contact = rs.getString(8);
                int is_active = rs.getInt(9);
                String created = rs.getString(10);
                String modified = rs.getString(11);

                to_customers to = new to_customers(id, account, first_name, last_name, mi, company, location, contact, is_active, created, modified);
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
