/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.statement_of_accounts;

import POS.util.DateType;
import POS.util.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
public class Srpt_readings {

    public final List<Srpt_readings.field> fields;
    public final String business_name;
    public final String address;
    public final String customer_id;
    public final String customer_name;
    public final String item_code;
    public final String description;

    public Srpt_readings(String business_name, String address, String customer_id, String customer_name, String item_code, String description) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.item_code = item_code;
        this.description = description;
    }

    public static class field {

        String date;
        double previous_reading;
        double current_reading;
        double consumption;
        double total;
        String status;
        double balance;

        public field() {
        }

        public field(String date, double previous_reading, double current_reading, double consumption, double total, String status, double balance) {
            this.date = date;
            this.previous_reading = previous_reading;
            this.current_reading = current_reading;
            this.consumption = consumption;
            this.total = total;
            this.status = status;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getConsumption() {
            return consumption;
        }

        public double getCurrent_reading() {
            return current_reading;
        }

        public String getDate() {
            return date;
        }

        public double getPrevious_reading() {
            return previous_reading;
        }

        public String getStatus() {
            return status;
        }

        public double getTotal() {
            return total;
        }

        public void setConsumption(double consumption) {
            this.consumption = consumption;
        }

        public void setCurrent_reading(double current_reading) {
            this.current_reading = current_reading;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setPrevious_reading(double previous_reading) {
            this.previous_reading = previous_reading;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

    public static void main(String[] args) {

        List<Srpt_readings.field> datas = ret_data("");
        String business_name = System.getProperty("business_name", "Kwekdel");
        String address = System.getProperty("address", "Dumaguete City");
        String customer_id = "1585";
        String customer_name = "Go Gold ";
        String item_code = "0009";
        String description = "1 SET ASAHI STOVE(DBLE BRNR)";
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        Srpt_readings rpt = new Srpt_readings(business_name, address, customer_id, customer_name, item_code, description);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_reading_1.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_readings.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_readings to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_readings.field> ret_data(String where) {
        List<Srpt_readings.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",user_id"
                    + ",user_name"
                    + ",date_added"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",previous_reading"
                    + ",current_reading"
                    + ",sar_id"
                    + ",amount"
                    + ",paid"
                    + " from statement_of_account_readings  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String item_code = rs.getString(7);
                String barcode = rs.getString(8);
                String description = rs.getString(9);
                double qty = rs.getDouble(10);
                double price = rs.getDouble(11);
                double previous_reading = rs.getDouble(12);
                double current_reading = rs.getDouble(13);
                String sar_id = rs.getString(14);
                date_added = DateType.convert_slash_datetime(date_added);
                double total = previous_reading - current_reading;
                double amount = rs.getDouble(15);
                double paid = rs.getDouble(16);
                double balance = amount - paid;
                String status = "  --  ";
                if (balance == 0) {
                    status = "Paid";
                }
                Srpt_readings.field to = new field(date_added, previous_reading, current_reading, total, total * price, status, balance);
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
