/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.bir_session.Srpt_checks;
import POS.util.DateType;
import java.io.InputStream;
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
 * @author Maytopacka
 */
public class Srpt_cash_count {

    public final String business_name;
    public final String address;
    public final String operated_by;
    public final double cash_in;
    public final double thousand;
    public final double five_hundred;
    public final double two_hundred;
    public final double one_hundred;
    public final double fifty;
    public final double twenty;
    public final double coins;
    public final double cash_total;
    public final String cashier_name;
    public final double net_total;
    public final String date;
    public final List<Srpt_checks.field> rpt_checks;
    public final String SUBREPORT_DIR;
    public final List<Srpt_checks.field> rpt_expenses;
    public final double grand_sales;
    public final double grand_checks;
    public final double grand_expenses;

    public Srpt_cash_count(String business_name, String address, String operated_by, double cash_in, double thousand, double five_hundred, double two_hundred, double one_hundred, double fifty, double twenty, double coins, double cash_total, String cashier_name, double net_total, String date, List<Srpt_checks.field> rpt_checks, String SUBREPORT_DIR, List<Srpt_checks.field> rpt_expenses, double grand_sales, double grand_checks, double grand_expenses) {

        this.business_name = business_name;
        this.address = address;
        this.operated_by = operated_by;
        this.cash_in = cash_in;
        this.thousand = thousand;
        this.five_hundred = five_hundred;
        this.two_hundred = two_hundred;
        this.one_hundred = one_hundred;
        this.fifty = fifty;
        this.twenty = twenty;
        this.coins = coins;
        this.cash_total = cash_total;
        this.cashier_name = cashier_name;
        this.net_total = net_total;
        this.date = date;
        this.rpt_checks = rpt_checks;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_expenses = rpt_expenses;
        this.grand_sales = grand_sales;
        this.grand_checks = grand_checks;
        this.grand_expenses = grand_expenses;
    }

    public static void main(String[] args) {

        String business_name = "asdad";
        String address = "dasdads";
        String operated_by = "asdad";
        double cash_in = 1000;
        double thousand = 0;
        double five_hundred = 1;
        double two_hundred = 1;
        double one_hundred = 1;
        double fifty = 1;
        double twenty = 1;
        double coins = 1;
        double cash_total = 1;
        String cashier_name = "";
        double net_total = 2;
        String date = DateType.month_date.format(new Date());
        List<Srpt_checks.field> fields = new ArrayList();
        double grand_sales = 0;
        double grand_checks = 0;
        double grand_expenses = 0;
        for (int i = 0; i < 5; i++) {
            String check_bank = "BANK " + i;
            String check_holder = "HOLDER " + i;
            String check_no = "0000000" + i;
            double check_amount = 10000 + i;
            String date1 = "July 1,2013";
            if (i >= 1 && i <= 5) {
                date1 = "July 1,2013";
            }
            if (i >= 6 && i <= 10) {
                date1 = "July 2,2013";
            }
            if (i >= 11 && i <= 15) {
                date1 = "July 3,2013";
            }
            if (i >= 16 && i <= 20) {
                date1 = "July 4,2013";
            }
            Srpt_checks.field t = new Srpt_checks.field(check_bank, check_holder, check_no, check_amount, date1);
            fields.add(t);
        }
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt\\";
        Srpt_cash_count rpt = new Srpt_cash_count(business_name, address, operated_by, cash_in, thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, coins, cash_total, cashier_name, net_total, date, fields, SUBREPORT_DIR, fields, grand_sales, grand_checks, grand_expenses);
        String jrxml = "rpt_cash_count.jrxml";
        JRViewer viewer = Srpt_cash_count.get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_cash_count to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_cash_count.class),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JRViewer get_viewer(Srpt_cash_count to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cash_count.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
