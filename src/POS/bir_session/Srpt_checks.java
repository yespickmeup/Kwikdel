/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir_session;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_checks {

    public static List<field> fields;

    public Srpt_checks() {
        Srpt_checks.fields = new ArrayList();
    }

    public static class field {

        String check_bank;
        String check_holder;
        String check_no;
        double check_amount;
        String date;

        public field() {
        }

        public field(String check_bank, String check_holder, String check_no, double check_amount, String date) {
            this.check_bank = check_bank;
            this.check_holder = check_holder;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.date = date;
        }

        public double getCheck_amount() {
            return check_amount;
        }

        public void setCheck_amount(double check_amount) {
            this.check_amount = check_amount;
        }

        public String getCheck_bank() {
            return check_bank;
        }

        public void setCheck_bank(String check_bank) {
            this.check_bank = check_bank;
        }

        public String getCheck_holder() {
            return check_holder;
        }

        public void setCheck_holder(String check_holder) {
            this.check_holder = check_holder;
        }

        public String getCheck_no() {
            return check_no;
        }

        public void setCheck_no(String check_no) {
            this.check_no = check_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static void main(String[] args) {

        List<Srpt_checks.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            String check_bank = "BANK " + i;
            String check_holder = "HOLDER " + i;
            String check_no = "0000000" + i;
            double check_amount = 10000 + i;
            String date = "July 1,2013";
            if (i >= 1 && i <= 5) {
                date = "July 1,2013";
            }
            if (i >= 6 && i <= 10) {
                date = "July 2,2013";
            }
            if (i >= 11 && i <= 15) {
                date = "July 3,2013";
            }
            if (i >= 16 && i <= 20) {
                date = "July 4,2013";
            }
            Srpt_checks.field t = new field(check_bank, check_holder, check_no, check_amount, date);
            fields.add(t);
        }
        Srpt_checks rpt = new Srpt_checks();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_checks.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_checks.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_checks to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
