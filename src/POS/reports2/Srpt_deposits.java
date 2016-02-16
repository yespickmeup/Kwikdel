/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

import static POS.reports2.Srpt_sales_items.ret_data;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_deposits {

    public final List<Srpt_deposits.field> fields;

    public Srpt_deposits() {
        this.fields = new ArrayList();
    }

    public static class field {

        double qty;
        String barcode;
        String description;
        double selling_price;
        double amount;
        String category;

        public field() {
        }

        public field(double qty, String barcode, String description, double selling_price, double amount, String category) {
            this.qty = qty;
            this.barcode = barcode;
            this.description = description;
            this.selling_price = selling_price;
            this.amount = amount;
            this.category = category;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

    }

    public static void main(String[] args) {
        String where = " group by barcode,selling_price order by description asc limit 10";
        List<Srpt_deposits.field> deposits = deposits(where);
        List<Srpt_deposits.field> deposit_returns = deposit_returns(where);

        Srpt_deposits rpt = new Srpt_deposits();
        rpt.fields.addAll(deposits);
        rpt.fields.addAll(deposit_returns);
        JRViewer viewer = Srpt_deposits.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JRViewer get_viewer(Srpt_deposits to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_deposits.jrxml";
            InputStream is = Srpt_deposits.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_deposits.field> deposits(String where) {
        List<Srpt_deposits.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",user_id"
                    + ",date_added"
                    + ",status"
                    + ",customer_id"
                    + ",customer_name"
                    + ",qty"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",vatable"
                    + ",discount_amount"
                    + ",addtl_amount"
                    + ",location_name"
                    + ",location_id"
                    + ",is_deposit"
                    + " from deposits"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_id = rs.getString(3);
                String date_added = rs.getString(4);
                int status = rs.getInt(5);
                String customer_id = rs.getString(6);
                String customer_name = rs.getString(7);
                double qty = rs.getDouble(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                String category = rs.getString(11);
                String category_id = rs.getString(12);
                String classification = rs.getString(13);
                String classification_id = rs.getString(14);
                String sub_classification = rs.getString(15);
                String sub_classification_id = rs.getString(16);
                String unit = rs.getString(17);
                double conversion = rs.getDouble(18);
                double selling_price = rs.getDouble(19);
                int vatable = rs.getInt(20);
                double discount_amount = rs.getDouble(21);
                double addtl_amount = rs.getDouble(22);
                String location_name = rs.getString(23);
                String location_id = rs.getString(24);
                int is_deposit = rs.getInt(25);
                String type = "Deposits".toUpperCase();
                if (is_deposit == 0) {
                    type = "On Loan".toUpperCase();
                }
                Srpt_deposits.field field = new field(qty, barcode, description, selling_price, (selling_price * qty), type);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_deposits.field> deposit_returns(String where) {
        List<Srpt_deposits.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",user_id"
                    + ",date_added"
                    + ",status"
                    + ",customer_id"
                    + ",customer_name"
                    + ",qty"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",vatable"
                    + ",discount_amount"
                    + ",addtl_amount"
                    + ",location_name"
                    + ",location_id"
                    + ",is_deposit"
                    + " from deposit_returns"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_id = rs.getString(3);
                String date_added = rs.getString(4);
                int status = rs.getInt(5);
                String customer_id = rs.getString(6);
                String customer_name = rs.getString(7);
                double qty = rs.getDouble(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                String category = rs.getString(11);
                String category_id = rs.getString(12);
                String classification = rs.getString(13);
                String classification_id = rs.getString(14);
                String sub_classification = rs.getString(15);
                String sub_classification_id = rs.getString(16);
                String unit = rs.getString(17);
                double conversion = rs.getDouble(18);
                double selling_price = rs.getDouble(19);
                int vatable = rs.getInt(20);
                double discount_amount = rs.getDouble(21);
                double addtl_amount = rs.getDouble(22);
                String location_name = rs.getString(23);
                String location_id = rs.getString(24);
                int is_deposit = rs.getInt(25);
                String type = "Deposit Returns".toUpperCase();
                if (is_deposit == 0) {
                    type = "On Loan Returns".toUpperCase();
                }
                Srpt_deposits.field field = new field(qty, barcode, description, selling_price, (selling_price * qty), type);
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
