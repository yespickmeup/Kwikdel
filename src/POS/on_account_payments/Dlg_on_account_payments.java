/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.on_account_payments;

import POS.customers.Customers;

import POS.sales.S1_sales;
import POS.sales.S1_sales_items;
import POS.sales.Srpt_receipt;

import POS.sales_dr.S1_sales_dr;
import POS.sales_dr.S1_sales_dr_items;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Guinness
 */
public class Dlg_on_account_payments extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_on_account_payments
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
    private Dlg_on_account_payments(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_on_account_payments(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_on_account_payments() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_on_account_payments myRef;

    private void setThisRef(Dlg_on_account_payments myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_on_account_payments> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_on_account_payments create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_on_account_payments create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_on_account_payments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_on_account_payments((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_on_account_payments dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_on_account_payments((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_on_account_payments dialog = Dlg_on_account_payments.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jTextField2.setFocusable(false);

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Amount:");

        jLabel4.setText("0.00");

        jLabel5.setText("Paid:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("0.00");

        jLabel7.setText("Collectible:");

        jLabel8.setText("0.00");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("Search by Dr:");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Search by Customer:");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox2))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_customers();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
        payment();
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:

        jTextField1.setFocusable(true);
        jTextField1.grabFocus();
        jTextField3.setFocusable(false);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        jTextField3.setFocusable(true);
        jTextField3.grabFocus();
        jTextField1.setFocusable(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_sales;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
        init_tbl_sales();
        jTextField1.grabFocus();

    }

    private void focus() {
        JTextField[] tf = {jTextField1, jTextField3};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
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

    private ArrayListModel tbl_sales_ALM;
    private TblsalesModel tbl_sales_M;

    private void init_tbl_sales() {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {120, 150, 100, 100, 100, 100,
            0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }
        Dimension d = tbl_sales.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_sales.getTableHeader().setPreferredSize(d);
        tbl_sales.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_sales.setRowHeight(25);
        tbl_sales.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 5);

        Color ivory = new Color(255, 255, 255);
        tbl_sales.setOpaque(true);
        tbl_sales.setFillsViewportHeight(true);
        tbl_sales.setBackground(ivory);
    }

    private void loadData_sales(List<S1_sales.to_sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "DR #", "Customer", "Address", "Driver", "Vehicle", "Amount", "Status", " ", "I", "D", "C", " ", "check_bank", "check_no", "check_amount", "discount_customer_name", "discount_customer_id", "status", "or_no", "check_holder", "services", "service_amount", "customer_id", "transaction_type", "transaction_type_id", "payment_type", "payment_type_id", "vehicle_name", "vehicle_id", "driver_name", "driver_id"
        };

        public TblsalesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 11) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_sales.to_sales tt = (S1_sales.to_sales) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.sales_no;
                case 1:
                    return " " + tt.customer_name;
                case 2:
                    return " " + tt.customer_address;
                case 3:
                    return " " + tt.driver_name;
                case 4:

                    return " " + tt.vehicle_name;
                case 5:
                    return " " + FitIn.fmt_wc_0((tt.amount_due + tt.service_amount) - tt.discount_amount) + " ";
                case 6:
                    return "  --------";

                case 7:
                    if (tt.charge_status == 0) {
                        return " Payment";
                    } else {
                        return " Ok";
                    }

                case 8:
                    if (tt.status == 7) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 9:
                    if (tt.status == 8) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 10:
                    if (tt.status == 9) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 11:
                    return false;
                case 12:
                    return tt.check_bank;
                case 13:
                    return tt.check_no;
                case 14:
                    return tt.check_amount;
                case 15:
                    return tt.discount_customer_name;
                case 16:
                    return tt.discount_customer_id;
                case 17:
                    return tt.status;
                case 18:
                    return tt.or_no;
                case 19:
                    return tt.check_holder;
                case 20:
                    return tt.services;
                case 21:
                    return tt.service_amount;
                case 22:
                    return tt.customer_id;
                case 23:
                    return tt.transaction_type;
                case 24:
                    return tt.transaction_type_id;
                case 25:
                    return tt.payment_type;
                case 26:
                    return tt.payment_type_id;
                case 27:
                    return tt.vehicle_name;
                case 28:
                    return tt.vehicle_id;
                case 29:
                    return tt.driver_name;
                default:
                    return tt.driver_id;
            }
        }
    }

    private void data_cols() {

        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                String where = " where customer_id='" + jTextField2.getText() + "' and payment_type_id=2 "
                        + " order by payment_type_id,id asc";

                if (jCheckBox1.isSelected()) {
                    where = " where  "
                            + "or_no like '%" + jTextField3.getText() + "%' and payment_type_id=2 order by payment_type_id,id asc";
                }
                List<S1_sales.to_sales> datas = S1_sales.ret_data_dr(where);
                List<S1_sales.to_sales> datas2 = S1_sales_dr.ret_data2(where);
                datas.addAll(datas2);
                loadData_sales(datas);
                double amount = 0;
                double unpaid = 0;
                double paid = 0;
                for (S1_sales.to_sales t : datas) {

                    double am = (t.amount_due + t.service_amount) - t.discount_amount;
                    amount += am;
                    if (t.charge_status == 0) {
                        unpaid += am;
                    } else {
                        paid += am;
                    }
                }

                jLabel4.setText(FitIn.fmt_wc_0(amount));
                jLabel6.setText(FitIn.fmt_wc_0(paid));
                jLabel8.setText(FitIn.fmt_wc_0(unpaid));

                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t2.start();

    }

    private void data_cols2() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                String where = " where customer_id='" + jTextField2.getText() + "' and payment_type_id=2 "
                        + " order by payment_type_id,id asc";

                System.out.println(where);
                List<S1_sales.to_sales> datas = S1_sales_dr.ret_data2(where);
                loadData_sales(datas);
                double amount = 0;
                for (S1_sales.to_sales t : datas) {
                    amount += t.amount_due;
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t2.start();

    }
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String search = jTextField1.getText();
                customer_list.clear();
                String where = " where last_name like '%" + search + "%' or first_name like '%" + search + "%' order by last_name asc";
                customer_list = Customers.ret_data2(where);
                Object[][] obj = new Object[customer_list.size()][1];
                int i = 0;
                for (Customers.to_customers to : customer_list) {
                    obj[i][0] = to.first_name + " " + to.last_name;
                    i++;
                }
                JLabel[] labels = {};
                int[] tbl_widths_customers = {500};
                int width = 0;
                String[] col_names = {""};
                TableRenderer tr = new TableRenderer();
                TableRenderer.setPopup(jTextField1, obj, labels, tbl_widths_customers, col_names);
                tr.setCallback(new TableRenderer.Callback() {
                    @Override
                    public void ok(TableRenderer.OutputData data) {
                        Customers.to_customers to = customer_list.get(data.selected_row);
                        jTextField1.setText(to.first_name + " " + to.last_name);
                        jTextField2.setText("" + to.id);
                        data_cols();
                    }
                });

            }
        });
        t.start();
    }

    private void payment() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_sales.getSelectedColumn();
        if (col == 7) {
            final S1_sales.to_sales to = (S1_sales.to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));

            if (to.charge_status == 1) {
                Alert.set(0, "Already paid!");
                return;
            }

            Window p = (Window) this;
            Dlg_on_account_payment nd = Dlg_on_account_payment.create(p, true);
            nd.setTitle("");
            nd.do_pass(to);
            nd.setCallback(new Dlg_on_account_payment.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_on_account_payment.OutputData data) {
                    closeDialog.ok();
                    if (to.is_sales == 0) {
                        String where2 = " where sales_no ='" + to.sales_no + "'";
                        List<S1_sales_items.to_sales_items> datas2 = S1_sales_dr_items.ret_data(where2);
                        String sa = S1_sales_items.add_sales_items(datas2, "" + to.id, data.check_amount, data.bank, data.check_no, to, data.bank);
                        print_all(to, datas2, sa, data.check_amount, data.bank, data.check_no);
                    } else {
                        System.out.println("Not Here!");
                        S1_sales.charge_payment("" + to.id, data.check_amount, data.bank, data.check_no);
                        String where2 = " where sales_no ='" + to.or_no + "'";
                        List<S1_sales_items.to_sales_items> datas2 = S1_sales_items.ret_data3(where2);
                        print_all(to, datas2, to.or_no, data.check_amount, data.bank, data.check_no);
                    }
                    data_cols();
                }
            });

            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private void print_all(S1_sales.to_sales to, List<S1_sales_items.to_sales_items> datas2, String sa, double check_amounts, String banks, String check_nos) {

        List<S1_sales.to_sales> sales = tbl_sales_ALM;

        String where = " where sales_no='" + to.or_no + "'";
        List<S1_sales_items.to_sales_items> datas = new ArrayList();
        List<Srpt_receipt.field> fields = new ArrayList();
        int qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;
        for (S1_sales_items.to_sales_items to1 : datas2) {
            int id = to1.id;
            String barcode = to1.barcode;
            String description = to1.description;
            String generic_name = to1.generic_name;
            String category = to1.category;
            String category_id = to1.category_id;
            String classification = to1.classification;
            String classification_id = to1.classification_id;
            String sub_classification = to1.sub_classification;
            String sub_classification_id = to1.sub_classification_id;
            double product_qty = to1.product_qty;
            qty += product_qty;
            String unit = to1.unit;
            double conversion = to1.conversion;
            double selling_price = to1.selling_price;
            String date_added = to1.date_added;
            String user_name = to1.user_name;
            String item_type = to1.item_type;
            int status = to1.status;
            String session_no = to1.session_no;
            String item_discount = to1.item_discount;
            double discount = to1.discount;
            double discount_amount = to1.discount_amount;
            String sales_no = to1.sales_no;
            String add = "";
            if (discount_amount > 0) {
                add = " - " + FitIn.fmt_wc_0(discount_amount) + " disc";
            }
            int fixed_price = to1.fixed_price;

            String supplier = to1.supplier;
            String supplier_id = to1.supplier_id;
            int vatable = to1.vatable;
            if (selling_price == 0) {
                zero_rate_sale++;
            }
            if (to1.vatable == 0) {
                vat_exempt_sale += product_qty * selling_price;
            } else {
                vatable_sale += product_qty * selling_price;
            }

            Srpt_receipt.field tbar = new Srpt_receipt.field(to1.description + add, new Date(), (to1.product_qty * to1.selling_price), to1.product_qty, to1.selling_price);
            fields.add(tbar);

        }
        vat_exempt_sale += to.service_amount;
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "");
        String address = System.getProperty("address", "");
        String status = System.getProperty("status", "NV");
        String tin_no = System.getProperty("tin_no", "") + " " + status;
        String serial_no = System.getProperty("serial_no", "");
        String permit_no = System.getProperty("permit_no", "");
        String datetime = DateType.slash_w_time.format(new Date());
        String or_no = "OR NO. " + sa;
        String items = System.getProperty("items", "");
        double net_due = ((to.amount_due + to.service_amount) - to.discount_amount);
        double total_due = net_due;
        double cash = 0;
        String check_bank = banks;
        double check_amount = check_amounts;
        if (check_amount == 0) {
            cash = net_due;
            check_amount = 0;
        } else {
            cash = 0;
            check_amount = net_due;
        }
        System.out.println("Cash: " + cash + " Check: " + check_amount);
        double change_due = 0;

        String receipt_infos = System.getProperty("receipt_infos", "");
        String receipt_footer = System.getProperty("receipt_footer", "");
        double discount = to.discount_amount;
        String cashier_name = Users.user_name;
        String discount_name = to.discount_name;
        if (discount_name.equalsIgnoreCase("NO DISCOUNT")) {
            discount_name = "";
        }
        String pos_no = "POS 1";
        int total_qty = qty;
        String accreditation_no = System.getProperty("acct_no", "Accreditation No. 000-0000000000-000000");
        String trans_no = sa;
        System.out.println("Transaction #: " + trans_no);
        String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
        String discount_customer_name = to.discount_customer_name;
        String discount_customer_id = to.discount_customer_id;
        discount_customer_name = discount_customer_name + " - " + discount_customer_id;
        String min_no = System.getProperty("min_no", "MIN NO: 130321854");
        double addtl_service = to.service_amount;
        vatable_sale = ((to.amount_due + to.service_amount) - to.discount_amount) / 1.12;
        double vat_percent = vatable_sale * .12;
        String customer_address = to.customer_address;
        String reference_no = "Ref #: " + to.or_no;
        String check_no = check_nos;
        Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, to.customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address, reference_no, to.amount_due, check_no);
        rpt.fields.addAll(fields);
        String l = "rpt_receipt.jrxml";
        InputStream is = Srpt_receipt.class.getResourceAsStream(l);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
            String print = System.getProperty("print_to_receipts", "false");
            if (print.equals("true")) {
                JasperPrintManager.printReport(jasperPrint, false);
                JasperPrintManager.printReport(jasperPrint, false);
            }

        } catch (JRException ex) {
            Logger.getLogger(Dlg_on_account_payments.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
    JasperPrint jasperPrint = null;

}
