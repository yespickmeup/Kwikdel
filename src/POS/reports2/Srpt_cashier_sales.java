/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports2;

import static POS.reports2.Srpt_deposits.deposits;
import static POS.reports2.Srpt_sales_items.ret_data;
import java.io.InputStream;
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
public class Srpt_cashier_sales {

    public final String SUBREPORT_DIR;
    public final List<Srpt_sales_transaction_by_cashier.field> rpt_transactions;
    public final List<Srpt_sales_items.field> rpt_items;
    public final List<Srpt_deposits.field> rpt_deposits;
    public final String date;
    public final double walkin_sales;
    public final double delivery_sales;
    public Srpt_cashier_sales(String SUBREPORT_DIR, List<Srpt_sales_transaction_by_cashier.field> rpt_transactions, List<Srpt_sales_items.field> rpt_items
            , String date, List<Srpt_deposits.field> rpt_deposits,double walkin_sales,double delivery_sales) {
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_transactions = rpt_transactions;
        this.rpt_items = rpt_items;
        this.date = date;
        this.rpt_deposits = rpt_deposits;
        this.walkin_sales=walkin_sales;
        this.delivery_sales=delivery_sales;
    }

    public static void main(String[] args) {
        String where2 = " where Date(date_added) between '" + "2015-01-07" + "' and '" + "2015-01-07" + "' order by user_name,payment_type";
        List<Srpt_sales_transaction_by_cashier.field> transactions = Srpt_sales_transaction_by_cashier.ret_data(where2);
        String where = " where Date(date_added) between '" + "2015-01-07" + "' and '" + "2015-01-07" + "' "
                + " group by barcode,selling_price order by description asc limit 10";
        List<Srpt_sales_items.field> items = ret_data(where);

        List<Srpt_deposits.field> deposits = deposits("");
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt\\";
        String date = "";
        double walkin_sales=0;
        double delivery_sales=0;
        
        Srpt_cashier_sales rpt = new Srpt_cashier_sales(SUBREPORT_DIR, transactions, items, date, deposits,walkin_sales,delivery_sales);

        JRViewer viewer = Srpt_cashier_sales.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JRViewer get_viewer(Srpt_cashier_sales to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_cashier_sales.jrxml";
            InputStream is = Srpt_cashier_sales.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

}
