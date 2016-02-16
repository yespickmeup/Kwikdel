/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

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
        String description;
        String period;

        public field() {
        }

        public field(String date, double previous_reading, double current_reading, double consumption, double total, String status, double balance, String description, String period) {
            this.date = date;
            this.previous_reading = previous_reading;
            this.current_reading = current_reading;
            this.consumption = consumption;
            this.total = total;
            this.status = status;
            this.balance = balance;
            this.description = description;
            this.period = period;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
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
        String jrxml = "rpt_reading_ledger.jrxml";
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
                    + ",description"
                    + ",qty"
                    + ",price"
                    + ",balance"
                    + ",paid"
                    + ",status"
                    + ",remarks"
                    + ",metered_sale_id"
                    + ",department"
                    + ",period_from"
                    + ",period_to"
                    + " from metered_sale_readings  "
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
                String description = rs.getString(7);
                double qty = rs.getDouble(8);
                double price = rs.getDouble(9);
                double balance = rs.getDouble(10);
                double paid = rs.getDouble(11);
                int status = rs.getInt(12);
                String remarks = rs.getString(13);
                String metered_sale_id = rs.getString(14);
                String department = rs.getString(15);
                String period_from=rs.getString(16);
                String period_to=rs.getString(17);
                String date = DateType.convert_slash_datetime(date_added);
                double previous_reading = balance;
                double current_reading = paid;
                double consumption = qty;
                double total = qty * price;
                String status1 = "-----";
                if (status == 1) {
                    status1 = "Paid";
                }
                double balance1 = qty;
                String description1 = description;
                String period = DateType.to_period(period_from, period_to);

                Srpt_readings.field rpt = new field(date, previous_reading, current_reading, consumption, total, status1, balance
                        , description, period);
                datas.add(rpt);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
