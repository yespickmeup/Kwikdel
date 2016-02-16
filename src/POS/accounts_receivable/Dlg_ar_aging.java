/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.main.Main;
import POS.util.DateType;
import POS.util.DateUtils1;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author i1
 */
public class Dlg_ar_aging extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_aging
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">

    private Dlg_ar_aging(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_aging(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_aging() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_aging myRef;

    private void setThisRef(Dlg_ar_aging myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_aging> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_aging create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_aging create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_aging dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_aging((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_ar_aging dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_aging((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc=" main ">

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_ar_aging dialog = Dlg_ar_aging.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" added ">

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
            initComponents();
            myInit();
            repaint();
        }


    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_accounts_receivable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_accounts_receivable);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        print();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl_accounts_receivable;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_algorithm");
        init_key();
        init_tbl_accounts_receivable();
        data_cols();
    }

    public void do_pass() {
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_accounts_receivable_ALM;
    private Tblaccounts_receivableModel tbl_accounts_receivable_M;

    private void init_tbl_accounts_receivable() {
        tbl_accounts_receivable_ALM = new ArrayListModel();
        tbl_accounts_receivable_M = new Tblaccounts_receivableModel(tbl_accounts_receivable_ALM);
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable.setModel(tbl_accounts_receivable_M);
        tbl_accounts_receivable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable.setRowHeight(25);
        int[] tbl_widths_accounts_receivable = {50, 50, 100, 50, 80, 50, 80, 80, 80, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable, i, tbl_widths_accounts_receivable[i]);
        }

        Dimension d = tbl_accounts_receivable.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable.setRowHeight(35);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 7);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 8);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 9);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 10);

//        tbl_accounts_receivable.getColumnModel().
//                getColumn(6).
//                setCellRenderer(new CustomRenderer());


    }

    public class CustomRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 6) {
                cellComponent.setBackground(Color.LIGHT_GRAY);
            } else {
                cellComponent.setBackground(Color.CYAN);
            }
            return cellComponent;
        }
    }

    private void loadData_accounts_receivable(List<to_accounts_receivable> acc) {
        tbl_accounts_receivable_ALM.clear();
        tbl_accounts_receivable_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "CI NO", "T.R.", "CUSTOMER", "TERM", "AMOUNT", "DAYS", "1-30", "31-60", "61-90", "91-120", "ABOVE", "APPLIED", "date_applied", "paid", "date_paid", "remarks", "type", "or_no", "ci_no", "trust_receipt"
        };

        public Tblaccounts_receivableModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_accounts_receivable tt = (to_accounts_receivable) getRow(row);
            switch (col) {
                case 0:
                    return tt.ci_no;
                case 1:
                    return tt.trust_receipt;
                case 2:
                    return tt.customer_name;
                case 3:
                    return FitIn.fmt_woc(tt.term);
                case 4:
                    return FitIn.fmt_wc_0(tt.amount);
                case 5:
                    int day = DateUtils1.ar_aging(tt.date_applied, FitIn.toInt("" + tt.term));
                    return day;
                case 6:
                    day = DateUtils1.ar_aging(tt.date_applied, FitIn.toInt("" + tt.term));
                    if (day > 0 && day <= 30) {
                        return FitIn.fmt_wc_0(tt.amount - tt.paid);
                    } else {
                        return "";
                    }
                case 7:
                    day = DateUtils1.ar_aging(tt.date_applied, FitIn.toInt("" + tt.term));
                    if (day > 31 && day < 60) {
                        return FitIn.fmt_wc_0(tt.amount - tt.paid);
                    } else {
                        return "";
                    }

                case 8:
                    day = DateUtils1.ar_aging(tt.date_applied, FitIn.toInt("" + tt.term));
                    if (day > 61 && day < 90) {
                        return FitIn.fmt_wc_0(tt.amount - tt.paid);
                    } else {
                        return "";
                    }

                case 9:
                    day = DateUtils1.ar_aging(tt.date_applied, FitIn.toInt("" + tt.term));
                    if (day > 91 && day < 121) {
                        return FitIn.fmt_wc_0(tt.amount - tt.paid);
                    } else {
                        return "";
                    }

                case 10:
                    day = DateUtils1.ar_aging(tt.date_applied, FitIn.toInt("" + tt.term));
                    if (day > 120) {
                        return FitIn.fmt_wc_0(tt.amount - tt.paid);
                    } else {
                        return "";
                    }

                case 11:
                    return DateType.convert_dash_date2(tt.date_applied);
                case 12:
                    return tt.date_applied;
                case 13:
                    return tt.paid;
                case 14:
                    return tt.date_paid;
                case 15:
                    return tt.remarks;
                case 16:
                    return tt.type;
                case 17:
                    return tt.or_no;
                case 18:
                    return tt.ci_no;
                default:
                    return tt.trust_receipt;
            }
        }
    }

    private void data_cols() {
        String search = "";
        loadData_accounts_receivable(S1_accounts_receivable.ret_aging(search));
        setEmployeeTableModel();
    }

    private void init_popup() {
    }

    private void setEmployeeTableModel() {
        double third = 0;
        double sixty = 0;
        double ninety = 0;
        double one_twenty = 0;
        double above = 0;
        double amount=0;
        List<to_accounts_receivable> datas = tbl_accounts_receivable_ALM;
        for (to_accounts_receivable to : datas) {
            amount+=to.amount;
            int day = DateUtils1.ar_aging(to.date_applied, FitIn.toInt("" + to.term));
            if (day > 0 && day <= 30) {
                third += to.amount - to.paid;
            } else if (day > 31 && day < 60) {
                sixty += to.amount - to.paid;
            } else if (day > 61 && day < 90) {
                ninety += to.amount - to.paid;
            } else if (day > 91 && day < 121) {
                one_twenty += to.amount - to.paid;
            } else {
                above += to.amount - to.paid;
            }
        }
        Object[][] obj = new Object[0][12];
        String[] col_names = {"", "", "", "",FitIn.fmt_wc_0(amount), "", FitIn.fmt_wc_0(third), FitIn.
            fmt_wc_0(sixty), FitIn.fmt_wc_0(ninety), FitIn.fmt_wc_0(one_twenty), FitIn.
            fmt_wc_0(above)};
        myModel(jTable1, obj, col_names);
        int[] tbl_widths_accounts_receivable = {50, 50, 100, 50, 80, 50, 80, 80, 80, 80, 80};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(jTable1, i, tbl_widths_accounts_receivable[i]);
        }
    }

    private void myModel(JTable tbl, Object[][] obj, String[] col_names) {
        tbl.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                col_names) {

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tbl.setRowHeight(30);
        tbl.setFont(new java.awt.Font("Arial", 0, 11));
    }
    JasperPrint jasperPrint = null;

    private void print() {


        List<Srpt_ar_aging2.field> fields = new ArrayList();
        double tamount = 0;
        double tf_quarter = 0;
        double tsecond_quarter = 0;
        double tthird_quarter = 0;
        double tfourth_quarter = 0;
        double tabove = 0;

        int rows = tbl_accounts_receivable.getRowCount();
        for (int i = 0; i < rows; i++) {
            String ci_no = tbl_accounts_receivable.getModel().
                    getValueAt(i, 0).
                    toString();
            String tr = tbl_accounts_receivable.getModel().
                    getValueAt(i, 1).
                    toString();
            String customer_name = tbl_accounts_receivable.getModel().
                    getValueAt(i, 2).
                    toString();
            int term = FitIn.toInt(tbl_accounts_receivable.getModel().
                    getValueAt(i, 3).
                    toString());
            double amount = FitIn.toDouble(tbl_accounts_receivable.getModel().
                    getValueAt(i, 4).
                    toString());
           
            int days = FitIn.toInt(tbl_accounts_receivable.getModel().
                    getValueAt(i, 5).
                    toString());
            double f_quarter = FitIn.toDouble(tbl_accounts_receivable.getModel().
                    getValueAt(i, 6).
                    toString());
              System.out.println(f_quarter);
            double second_quarter = FitIn.toDouble(tbl_accounts_receivable.
                    getModel().
                    getValueAt(i, 7).
                    toString());
            double third_quarter = FitIn.toDouble(tbl_accounts_receivable.
                    getModel().
                    getValueAt(i, 8).
                    toString());
            double fourth_quarter = FitIn.toDouble(tbl_accounts_receivable.
                    getModel().
                    getValueAt(i, 9).
                    toString());
            double above = FitIn.toDouble(tbl_accounts_receivable.getModel().
                    getValueAt(i, 10).
                    toString());
           

            tamount += amount;
            tf_quarter += f_quarter;
            tsecond_quarter += second_quarter;
            tthird_quarter += third_quarter;
            tfourth_quarter += fourth_quarter;
            tabove += above;


            String lamount = FitIn.fmt_wc_0(amount);
            if (amount == 0) {
                lamount = "";
            }
            String lf_quarter = FitIn.fmt_wc_0(f_quarter);
            if (f_quarter == 0) {
                lf_quarter = "";
            }
            String lsecond_quarter = FitIn.fmt_wc_0(second_quarter);
            if (second_quarter == 0) {
                lsecond_quarter = "";
            }
            String lthird_quarter = FitIn.fmt_wc_0(third_quarter);
            if (third_quarter == 0) {
                lthird_quarter = "";
            }
            String lfourth_quarter = FitIn.fmt_wc_0(fourth_quarter);
            if (fourth_quarter == 0) {
                lfourth_quarter = "";
            }
            String labove = FitIn.fmt_wc_0(above);
            if (above == 0) {
                labove = "";
            }
            Srpt_ar_aging2.field to = new Srpt_ar_aging2.field(ci_no, tr, customer_name, term, lamount, days, lf_quarter, lsecond_quarter, lthird_quarter, lfourth_quarter, labove);
            fields.add(to);
        }


          System.out.println(tf_quarter + " total");
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String printed_by = Users.screen_name;
        String date = "Date Printed: [" + DateType.day_and_time.format(new Date()) + "]";

        Srpt_ar_aging2 rpt = new Srpt_ar_aging2(business_name, printed_by, date, tamount, tf_quarter, tsecond_quarter, tthird_quarter, tfourth_quarter, tabove);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_ar_aging.jrxml";
//        JRViewer viewer = Srpt_ar_aging2.get_viewer(rpt);
//        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InputStream is = Srpt_ar_aging2.class.getResourceAsStream(jrxml);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
        } catch (JRException ex) {
            Logger.getLogger(Srpt_ar_aging2.class.getName()).
                    log(Level.SEVERE, null, ex);
        }


        try {
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
}
