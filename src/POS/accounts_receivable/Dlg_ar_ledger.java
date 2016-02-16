/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_ar_ledger.to_ar_ledger;
import POS.util.DateType;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author i1
 */
public class Dlg_ar_ledger extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_ledger
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
    private Dlg_ar_ledger(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_ledger(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_ledger() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_ledger myRef;

    private void setThisRef(Dlg_ar_ledger myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_ledger> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_ledger create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_ledger create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_ledger dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_ledger((java.awt.Frame) parent, false);
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
            Dlg_ar_ledger dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_ledger((java.awt.Dialog) parent, false);
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


        Dlg_ar_ledger dialog = Dlg_ar_ledger.create(new javax.swing.JFrame(), true);
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
        tbl_ar_ledger = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf_customer_id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_ar_ledger.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_ar_ledger);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Id No:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name:");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Print");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Address:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_address, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JTable tbl_ar_ledger;
    private javax.swing.JLabel tf_customer_id;
    private javax.swing.JLabel tf_customer_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_ar_ledger();
        setEmployeeTableModel();
    }

    public void do_pass(String account_id, String account_name, String address) {
        tf_customer_id.setText(account_id);
        tf_customer_name.setText(account_name);
        lbl_address.setText(address);
        data_cols();
        setEmployeeTableModel();

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
    private ArrayListModel tbl_ar_ledger_ALM;
    private Tblar_ledgerModel tbl_ar_ledger_M;

    private void init_tbl_ar_ledger() {
        tbl_ar_ledger_ALM = new ArrayListModel();
        tbl_ar_ledger_M = new Tblar_ledgerModel(tbl_ar_ledger_ALM);
        tbl_ar_ledger.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_ar_ledger.setModel(tbl_ar_ledger_M);
        tbl_ar_ledger.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_ar_ledger.setRowHeight(25);
        int[] tbl_widths_ar_ledger = {0, 100, 100, 100, 100, 100, 100};
        for (int i = 0, n = tbl_widths_ar_ledger.length; i < n; i++) {
            if (i == 1 | i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_ar_ledger, i, tbl_widths_ar_ledger[i]);
        }
        Dimension d = tbl_ar_ledger.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_ar_ledger.getTableHeader().
                setPreferredSize(d);
        tbl_ar_ledger.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_ar_ledger.setRowHeight(35);
        tbl_ar_ledger.setFont(new java.awt.Font("Arial", 1, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_ar_ledger, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_ar_ledger, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_ar_ledger, 6);
    }

    private void loadData_ar_ledger(List<to_ar_ledger> acc) {
        tbl_ar_ledger_ALM.clear();
        tbl_ar_ledger_ALM.addAll(acc);
    }

    public static class Tblar_ledgerModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "Date", "Trans #", "OR #", "Amount", "Payment", "Balance"
        };

        public Tblar_ledgerModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            to_ar_ledger tt = (to_ar_ledger) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return DateType.convert_slash_datetime(tt.date);
                case 2:
                    return tt.transaction_no;
                case 3:
                    return tt.or_no;
                case 4:
                    if (tt.amount == 0) {
                        return "";
                    } else {
                        return FitIn.fmt_wc_0(tt.amount);
                    }

                case 5:
                    if (tt.payment == 0) {
                        return "";
                    } else {
                        return FitIn.fmt_wc_0(tt.payment);
                    }

                default:
                    return FitIn.fmt_wc_0(tt.balance);
            }
        }
    }

    private void data_cols() {
        String account_id = tf_customer_id.getText();
        loadData_ar_ledger(S1_ar_ledger.ret_data(account_id));
    }

    
    private void setEmployeeTableModel() {

        double amount = 0;
        double payment = 0;
        double balance = 0;
        List<to_ar_ledger> datas = tbl_ar_ledger_ALM;
        for (to_ar_ledger to : datas) {
            amount += to.amount;
            payment += to.payment;

        }
        balance = amount - payment;
        Object[][] obj = new Object[0][12];
        String[] col_names = {"", "", "", "", FitIn.fmt_wc_0(amount), FitIn.
            fmt_wc_0(payment), FitIn.fmt_wc_0(balance)};
        myModel(jTable2, obj, col_names);
        int[] tbl_widths_accounts_receivable = {0, 100, 100, 100, 100, 100, 100};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 2 | i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(jTable2, i, tbl_widths_accounts_receivable[i]);
        }
        jTable2.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        TableWidthUtilities.setColumnRightRenderer(jTable2, 4);
        TableWidthUtilities.setColumnRightRenderer(jTable2, 5);
        TableWidthUtilities.setColumnRightRenderer(jTable2, 6);

        jTable2.getTableHeader().
                setFont(new java.awt.Font("Arial", 1, 12));
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
        
        List<to_ar_ledger> acc = tbl_ar_ledger_ALM;
        List<Srpt_ar_ledger.field> fields = new ArrayList();
        for (to_ar_ledger to : acc) {
            String date = DateType.convert_slash_datetime(to.date);
            String trans_no = to.transaction_no;
            String or_no = to.or_no;
            String amount = FitIn.fmt_wc_0(to.amount);
            if (to.amount == 0) {
                amount = "";
            }
            String payment = FitIn.fmt_wc_0(to.payment);
            if (to.payment == 0) {
                payment = "";
            }
            double balance = to.balance;
            Srpt_ar_ledger.field to1 = new Srpt_ar_ledger.field(date, trans_no, or_no, amount, payment, balance);
            fields.add(to1);
        }

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String printed_by = Users.screen_name;
        String date = "Date Printed: [" + DateType.day_and_time.format(new Date()) + "]";
        String customer_name = tf_customer_name.getText();
        String customer_address = lbl_address.getText();
        Srpt_ar_ledger rpt = new Srpt_ar_ledger(business_name, printed_by, date, customer_name, customer_address);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_ar_ledger.jrxml";
//        JRViewer viewer = Srpt_ar_ledger.get_viewer(rpt);
//        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InputStream is = Srpt_ar_ledger.class.getResourceAsStream(jrxml);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
        } catch (JRException ex) {
            Logger.getLogger(Srpt_ar_ledger.class.getName()).
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
