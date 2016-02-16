/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_customers {

    public static class to_customers {

        public final int id;
        public final String customer_name;
        public final String customer_no;
        public final String contact_no;
        public final double credit_limit;
        public final String address;
        public final double term;
        public final String location;
        public final double balance;
        public final double discount;
        public final String account;
        public final String first_name;
        public final String last_name;
        public final String mi;
        public final double deposit;

        public to_customers(int id, String customer_name, String customer_no, String contact_no, double credit_limit, String address, double term, String location, double balance, double discount, String account, String first_name, String last_name, String mi, double deposit) {
            this.id = id;
            this.customer_name = customer_name;
            this.customer_no = customer_no;
            this.contact_no = contact_no;
            this.credit_limit = credit_limit;
            this.address = address;
            this.term = term;
            this.location = location;
            this.balance = balance;
            this.discount = discount;
            this.account = account;
            this.first_name = first_name;
            this.last_name = last_name;
            this.mi = mi;
            this.deposit = deposit;

        }
    }

    public static void add_customers(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  customers("
                    + "customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",account"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",deposit"
                    + ")values("
                    + ":customer_name"
                    + ",:customer_no"
                    + ",:contact_no"
                    + ",:credit_limit"
                    + ",:address"
                    + ",:term"
                    + ",:location"
                    + ",:balance"
                    + ",:discount"
                    + ",:account"
                    + ",:first_name"
                    + ",:last_name"
                    + ",:mi"
                    + ",:deposit"
                    + ")";
            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", to_customers.customer_name).
                    setString("customer_no", to_customers.customer_no).
                    setString("contact_no", to_customers.contact_no).
                    setNumber("credit_limit", to_customers.credit_limit).
                    setString("address", to_customers.address).
                    setNumber("term", to_customers.term).
                    setString("location", to_customers.location).
                    setNumber("balance", to_customers.balance).
                    setNumber("discount", to_customers.balance).
                    setString("account", to_customers.account).
                    setString("first_name", to_customers.first_name).
                    setString("last_name", to_customers.last_name).
                    setString("mi", to_customers.mi).
                    setNumber("deposit", to_customers.deposit).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_customers(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  customers set "
                    + "customer_name= :customer_name"
                    + ",customer_no= :customer_no"
                    + ",contact_no= :contact_no"
                    + ",credit_limit= :credit_limit"
                    + ",address= :address"
                    + ",term= :term"
                    + ",location= :location"
                    + ",discount= :discount"
                    + ",last_name= :last_name"
                    + ",mi= :mi"
                    + ",first_name= :first_name"
                    + ",deposit= :deposit"
                    + " where "
                    + " id ='" + to_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", to_customers.customer_name).
                    setString("customer_no", to_customers.customer_no).
                    setString("contact_no", to_customers.contact_no).
                    setNumber("credit_limit", to_customers.credit_limit).
                    setString("address", to_customers.address).
                    setNumber("term", to_customers.term).
                    setString("location", to_customers.location).
                    setNumber("discount", to_customers.discount).
                    setString("last_name", to_customers.last_name).
                    setString("mi", to_customers.mi).
                    setString("first_name", to_customers.first_name).
                    setNumber("deposit", to_customers.deposit).
                    ok();
            System.out.println("" + to_customers.location);
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_customers(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  customers where "
                    + " id ='" + to_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_customers> ret_data(String search) {
        List<to_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",account"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",deposit"
                    + " from  customers where "
                    + " customer_name like'%" + search + "%' order by customer_name asc"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);
                String account = rs.getString(11);
                String first_name = rs.getString(12);
                String last_name = rs.getString(13);
                String mi = rs.getString(14);
                double deposit=rs.getDouble(15);
                to_customers to = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi,deposit);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_customers> ret_data2(String where) {
        List<to_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",customer_no"
                    + ",contact_no"
                    + ",credit_limit"
                    + ",address"
                    + ",term"
                    + ",location"
                    + ",balance"
                    + ",discount"
                    + ",account"
                    + ",first_name"
                    + ",last_name"
                    + ",mi"
                    + ",deposit"
                    + " from  customers  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String customer_no = rs.getString(3);
                String contact_no = rs.getString(4);
                double credit_limit = rs.getDouble(5);
                String address = rs.getString(6);
                double term = rs.getDouble(7);
                String location = rs.getString(8);
                double balance = rs.getDouble(9);
                double discount = rs.getDouble(10);

                String account = rs.getString(11);
                String first_name = rs.getString(12);
                String last_name = rs.getString(13);
                String mi = rs.getString(14);
                double deposit=rs.getDouble(15);
                to_customers to = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi,deposit);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select customer_name from  customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "0000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from  customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "0000";
            } else {
                String s2 = "select customer_no from  customers where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
