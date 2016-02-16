/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author i1
 */
public class S1_ar_ledger {

    public static class to_ar_ledger implements Comparable<to_ar_ledger> {

        public int id;
        public String date;
        public String transaction_no;
        public String or_no;
        public double amount;
        public double payment;
        public double balance;
        public Date date_added;
        

        public to_ar_ledger(int id, String date, String transaction_no, String or_no, double amount, double payment, double balance, Date date_added) {
            this.id = id;
            this.date = date;
            this.transaction_no = transaction_no;
            this.or_no = or_no;
            this.amount = amount;
            this.payment = payment;
            this.balance = balance;
            this.date_added = date_added;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public double getPayment() {
            return payment;
        }

        public void setPayment(double payment) {
            this.payment = payment;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        @Override
        public int compareTo(to_ar_ledger o) {
            if (getDate_added() == null || o.getDate_added() == null) {
                return 0;
            }
            return getDate_added().
                    compareTo(o.getDate_added());
        }
    }

    public static List<to_ar_ledger> ret_data(String search) {
        List<to_ar_ledger> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + " from  accounts_receivable where "
                    + " customer_id ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date = rs.getString(5);
                String transaction_no = rs.getString(20);
                String or_no = rs.getString(18);
                double amount = rs.getDouble(7);
                double payment = 0;
                double balance = 0;
                Date d = DateType.datetime.parse(date);
                to_ar_ledger to = new to_ar_ledger(id, date, transaction_no, or_no, amount, payment, balance, d);
                datas.add(to);
            }

            String s2 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_no"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",discount_amount"
                    + ",discount_rate"
                    + ",discount"
                    + ",status"
                    + ",term"
                    + ",date_applied"
                    + ",paid"
                    + ",date_paid"
                    + ",remarks"
                    + ",type"
                    + ",or_no"
                    + ",prev_balance"
                    + ",check_amount"
                    + ",check_holder"
                    + ",check_bank"
                    + ",check_no"
                    + ",ci_no"
                    + ",trust_receipt"
                    + ",or_payment_no"
                    + " from  accounts_receivable_payments where "
                    + " customer_id ='" + search + "' "
                    + " ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                double paid = rs2.getDouble(7);
                double check_amount = rs2.getDouble(20);
                String date = rs2.getString(5);
                String transaction_no = rs2.getString(25);
                 String or_payment_no = rs2.getString(26);
                String or_no = rs2.getString(18);
                double amount = 0;
                
                double payment = paid + check_amount;
                double balance = 0;
                Date d = DateType.datetime.parse(date);
                to_ar_ledger to1 = new to_ar_ledger(id, date, transaction_no, or_payment_no, amount, payment, balance, d);
                datas.add(to1);
            }


            Collections.sort(datas, new Comparator<to_ar_ledger>() {

                public int compare(to_ar_ledger o1, to_ar_ledger o2) {
                    return o1.getDate_added().
                            compareTo(o2.getDate_added());
                }
            });

            double amount=0;
            double total = 0;
            List<to_ar_ledger> datas2 = new ArrayList();
            for (to_ar_ledger to : datas) {
                total += to.amount - to.payment;
                to_ar_ledger to1 = new to_ar_ledger(to.id, to.date, to.transaction_no, to.or_no, to.amount, to.payment, total, to.date_added);
                datas2.add(to1);
            }
            return datas2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
