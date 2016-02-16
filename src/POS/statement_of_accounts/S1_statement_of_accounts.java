/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.statement_of_accounts;

import POS.statement_of_accounts.S1_statement_of_account_readings.to_statement_of_account_readings;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_statement_of_accounts {

    public static class to_statement_of_accounts {

        public final int id;
        public final String customer_id;
        public final String customer_no;
        public final String user_id;
        public final String user_name;
        public final String date_added;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double price;
        public final double balance;
        public final double paid;

        public to_statement_of_accounts(int id, String customer_id, String customer_no, String user_id, String user_name, String date_added, String item_code, String barcode, String description, double qty, double price, double balance, double paid) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_no = customer_no;
            this.user_id = user_id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.price = price;
            this.balance = balance;
            this.paid = paid;
        }
    }

    public static void add_statement_of_accounts(to_statement_of_accounts to_statement_of_accounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into statement_of_accounts("
                    + "customer_id"
                    + ",customer_no"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",balance"
                    + ",paid"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_no"
                    + ",:user_id"
                    + ",:user_name"
                    + ",:date_added"
                    + ",:item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:price"
                    + ",:balance"
                    + ",:paid"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_statement_of_accounts.customer_id)
                    .setString("customer_no", to_statement_of_accounts.customer_no)
                    .setString("user_id", to_statement_of_accounts.user_id)
                    .setString("user_name", to_statement_of_accounts.user_name)
                    .setString("date_added", to_statement_of_accounts.date_added)
                    .setString("item_code", to_statement_of_accounts.item_code)
                    .setString("barcode", to_statement_of_accounts.barcode)
                    .setString("description", to_statement_of_accounts.description)
                    .setNumber("qty", to_statement_of_accounts.qty)
                    .setNumber("price", to_statement_of_accounts.price)
                    .setNumber("balance", to_statement_of_accounts.balance)
                    .setNumber("paid", to_statement_of_accounts.paid)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_accounts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_statement_of_accounts(to_statement_of_accounts to_statement_of_accounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update statement_of_accounts set "
                    + "customer_id= :customer_id"
                    + ",customer_no= :customer_no"
                    + ",user_id= :user_id"
                    + ",user_name= :user_name"
                    + ",date_added= :date_added"
                    + ",item_code= :item_code"
                    + ",barcode= :barcode"
                    + ",description= :description"
                    + ",qty= :qty"
                    + ",price= :price"
                    + ",balance= :balance"
                    + ",paid= :paid"
                    + " where "
                    + " id ='" + to_statement_of_accounts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_statement_of_accounts.customer_id)
                    .setString("customer_no", to_statement_of_accounts.customer_no)
                    .setString("user_id", to_statement_of_accounts.user_id)
                    .setString("user_name", to_statement_of_accounts.user_name)
                    .setString("date_added", to_statement_of_accounts.date_added)
                    .setString("item_code", to_statement_of_accounts.item_code)
                    .setString("barcode", to_statement_of_accounts.barcode)
                    .setString("description", to_statement_of_accounts.description)
                    .setNumber("qty", to_statement_of_accounts.qty)
                    .setNumber("price", to_statement_of_accounts.price)
                    .setNumber("balance", to_statement_of_accounts.balance)
                    .setNumber("paid", to_statement_of_accounts.paid)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_accounts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_statement_of_accounts(to_statement_of_accounts to_statement_of_accounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from statement_of_accounts where "
                    + " id ='" + to_statement_of_accounts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_accounts.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_statement_of_accounts> ret_data(String where) {
        List<to_statement_of_accounts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_no"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",balance"
                    + ",paid"
                    + " from statement_of_accounts  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_no = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String item_code = rs.getString(7);
                String barcode = rs.getString(8);
                String description = rs.getString(9);
                double qty = rs.getDouble(10);
                double price = rs.getDouble(11);
                double balance = rs.getDouble(12);
                double paid = rs.getDouble(13);

                to_statement_of_accounts to = new to_statement_of_accounts(id, customer_id, customer_no, user_id, user_name, date_added, item_code, barcode, description, qty, price, balance, paid);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_qty(to_statement_of_accounts to_statement_of_accounts, double qty) {
        try {
            Connection conn = MyConnection.connect();
            double new_qty = to_statement_of_accounts.qty + qty;
            String s0 = "update statement_of_accounts set "
                    + "qty= :qty"
                    + " where "
                    + " id ='" + to_statement_of_accounts.id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("qty", new_qty)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_accounts.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_qty3(to_statement_of_account_readings to_statement_of_accounts, double qty) {
        try {
            Connection conn = MyConnection.connect();
            double new_qty = (to_statement_of_accounts.previous_reading - to_statement_of_accounts.current_reading) + qty;
            System.out.println(to_statement_of_accounts.previous_reading + " - "+to_statement_of_accounts.current_reading + " = "+qty + " : "+ new_qty);
            String s0 = "update statement_of_accounts set "
                    + "qty= :qty"
                    + " where "
                    + " id ='" + to_statement_of_accounts.sar_id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("qty", new_qty)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_accounts.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_qty2(to_statement_of_accounts to_statement_of_accounts, double qty) {
        try {
            Connection conn = MyConnection.connect();
            double new_qty = to_statement_of_accounts.qty - qty;
            String s0 = "update statement_of_accounts set "
                    + "qty= :qty"
                    + " where "
                    + " id ='" + to_statement_of_accounts.id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("qty", new_qty)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_statement_of_accounts.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
