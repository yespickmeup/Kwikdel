/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.innosoft;

import POS.items.S1_items;
import POS.users.S1_users.to_users;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.MyConnectionInnosoft;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;


/**
 *
 * @author Guinness
 */
public class Users {

    public static void main(String[] args) {
        update_innosoft();
    }

    public static void update_innosoft() {
        String where = " order by screen_name asc";
        List<to_users> datas = ret_data(where);
        System.out.println("Total Items: " + datas.size());

        try {
            Connection conn = MyConnectionInnosoft.connect();

            String datetime = DateType.datetime2.format(new Date());

            String s2 = "delete from dbo.MstUser where IsLocked=0";
            PreparedStatement stmt = conn.prepareStatement(s2);
            stmt.execute();
            Lg.s(S1_items.class, "Successfully Deleted");

            for (to_users to : datas) {

                String s0 = " insert into dbo.MstUser ("
                        + "UserName"
                        + ",Password"
                        + ",FullName"
                        + ",UserCardNumber"
                        + ",EntryUserId"
                        + ",EntryDateTime"
                        + ",UpdateUserId"
                        + ",UpdateDateTime"
                        + ",IsLocked"
                        + ")values("
                        + " :UserName"
                        + ",:Password"
                        + ",:FullName"
                        + ",:UserCardNumber"
                        + ",:EntryUserId"
                        + ",:EntryDateTime"
                        + ",:UpdateUserId"
                        + ",:UpdateDateTime"
                        + ",:IsLocked"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("UserName", to.user_name).
                        setString("Password", to.password).
                        setString("FullName", to.screen_name).
                        setString("UserCardNumber", null).
                        setString("EntryUserId", "1").
                        setString("EntryDateTime", datetime).
                        setString("UpdateUserId", "1").
                        setString("UpdateDateTime", datetime).
                        setNumber("IsLocked", 0).
                        ok();
                PreparedStatement stmt2 = conn.prepareStatement(s0);
                stmt2.execute();
            }

            Lg.s(Items.class, "Successfully Added");

        } catch (SQLException e) {
            System.out.println("DB error : " + e);
        }
    }

    public static List<to_users> ret_data(String where) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + " from users"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);

                to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
