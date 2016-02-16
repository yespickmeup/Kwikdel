/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

import POS.cash_drawer.S1_cash_drawer_expenses;
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
public class S1_disbursements {

    public static class to_cash_drawer_expenses {

        public final int id;
        public final String session_no;
        public final String user_name;
        public final String screen_name;
        public final String time_in;
        public final String time_out;
        public final String bank;
        public final String check_no;
        public final String check_holder;
        public final double amount;
        public final String date_added;

        public to_cash_drawer_expenses(int id, String session_no, String user_name, String screen_name, String time_in, String time_out, String bank, String check_no, String check_holder, double amount, String date_added) {
            this.id = id;
            this.session_no = session_no;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.time_in = time_in;
            this.time_out = time_out;
            this.bank = bank;
            this.check_no = check_no;
            this.check_holder = check_holder;
            this.amount = amount;
            this.date_added = date_added;
        }
    }

    public static void add_cash_drawer_expenses(to_cash_drawer_expenses to_cash_drawer_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer_expenses("
                    + "session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",date_added"
                    + ")values("
                    + ":session_no"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:time_in"
                    + ",:time_out"
                    + ",:bank"
                    + ",:check_no"
                    + ",:check_holder"
                    + ",:amount"
                    + ",:date_added"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("session_no", to_cash_drawer_expenses.session_no)
                    .setString("user_name", to_cash_drawer_expenses.user_name)
                    .setString("screen_name", to_cash_drawer_expenses.screen_name)
                    .setString("time_in", to_cash_drawer_expenses.time_in)
                    .setString("time_out", to_cash_drawer_expenses.time_out)
                    .setString("bank", to_cash_drawer_expenses.bank)
                    .setString("check_no", to_cash_drawer_expenses.check_no)
                    .setString("check_holder", to_cash_drawer_expenses.check_holder)
                    .setNumber("amount", to_cash_drawer_expenses.amount)
                    .setString("date_added", to_cash_drawer_expenses.date_added)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_expenses.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_cash_drawer_expenses(to_cash_drawer_expenses to_cash_drawer_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_expenses set "
                    + "session_no= :session_no"
                    + ",user_name= :user_name"
                    + ",screen_name= :screen_name"
                    + ",time_in= :time_in"
                    + ",time_out= :time_out"
                    + ",bank= :bank"
                    + ",check_no= :check_no"
                    + ",check_holder= :check_holder"
                    + ",amount= :amount"
                    + ",date_added= :date_added"
                    + " where "
                    + " id ='" + to_cash_drawer_expenses.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("session_no", to_cash_drawer_expenses.session_no)
                    .setString("user_name", to_cash_drawer_expenses.user_name)
                    .setString("screen_name", to_cash_drawer_expenses.screen_name)
                    .setString("time_in", to_cash_drawer_expenses.time_in)
                    .setString("time_out", to_cash_drawer_expenses.time_out)
                    .setString("bank", to_cash_drawer_expenses.bank)
                    .setString("check_no", to_cash_drawer_expenses.check_no)
                    .setString("check_holder", to_cash_drawer_expenses.check_holder)
                    .setNumber("amount", to_cash_drawer_expenses.amount)
                    .setString("date_added", to_cash_drawer_expenses.date_added)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_expenses.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_cash_drawer_expenses(to_cash_drawer_expenses to_cash_drawer_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_expenses where "
                    + " id ='" + to_cash_drawer_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_expenses.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_expenses> ret_data(String where) {
        List<to_cash_drawer_expenses> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",date_added"
                    + " from cash_drawer_expenses  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                String date_added = rs.getString(11);

                to_cash_drawer_expenses to = new to_cash_drawer_expenses(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount, date_added);
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
