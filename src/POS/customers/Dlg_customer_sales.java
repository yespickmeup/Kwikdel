/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.delivery.Dlg_delivery;
import POS.delivery.Srpt_delivery_receipt;
import POS.sales.S1_sales;
import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items;
import POS.sales.S1_sales_items.to_sales_items;
import POS.sales.Srpt_receipt;
import POS.sales_dr.S1_sales_dr;
import POS.sales_dr.S1_sales_dr_items;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
 * @author Ronald
 */
public class Dlg_customer_sales extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_customer_accounts
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
    private Dlg_customer_sales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_customer_sales(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_customer_sales() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_customer_sales myRef;

    private void setThisRef(Dlg_customer_sales myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customer_sales> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customer_sales create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customer_sales create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customer_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_sales((java.awt.Frame) parent, false);
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
            Dlg_customer_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_sales((java.awt.Dialog) parent, false);
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

        Dlg_customer_sales dialog = Dlg_customer_sales.create(new javax.swing.JFrame(), true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sales_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jMenuItem1.setText("Print Receipt");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Print Guide");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_salesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_salesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        tbl_sales_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_sales_items);

        jLabel1.setText("Search OR:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer Orders");

        jLabel3.setText("Trans #:");

        jLabel4.setText("No. of Orders:");

        jLabel5.setText("0");

        jLabel6.setText("0");

        jLabel7.setText("Total Amount:");

        jLabel8.setText("Transaction Type:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("Walkin");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setText("Delivery");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Payment Type:");

        buttonGroup2.add(jCheckBox4);
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox5);
        jCheckBox5.setText("Cash");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setText("Charge");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel10.setText("0");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("0");

        jLabel12.setText("Total Amount:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(jCheckBox2)
                                .addComponent(jCheckBox3))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox4)
                                .addComponent(jCheckBox5)
                                .addComponent(jCheckBox6))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
//        init_customers();
        data_cols();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
        data_cols_items();
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void tbl_salesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMousePressed
        // TODO add your handling code here:
        show_popup(evt);
    }//GEN-LAST:event_tbl_salesMousePressed

    private void tbl_salesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseReleased
        // TODO add your handling code here:
        show_popup(evt);
    }//GEN-LAST:event_tbl_salesMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        print_all();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        print_deliver_all();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTable tbl_sales_items;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        jTextField2.setVisible(false);
        focus();

        init_tbl_sales();
        init_tbl_sales_items();
    }

    private void focus() {
        JTextField[] tf = {jTextField1};
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
        int[] tbl_widths_sales = {120, 110, 100, 60, 60, 100,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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

        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 5);
    }

    private void loadData_sales(List<S1_sales.to_sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "OR/DR #", "Date", "Customer", "Disc", "Service", "Amount", "Status", " ", "I", "D", "C", " ", "check_bank", "check_no", "check_amount", "discount_customer_name", "discount_customer_id", "status", "or_no", "check_holder", "services", "service_amount", "customer_id", "transaction_type", "transaction_type_id", "payment_type", "payment_type_id", "vehicle_name", "vehicle_id", "driver_name", "driver_id"
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
//                    if (tt.transaction_type_id.equals("2")) {
//                        if (tt.time_delivered != null) {
//                            return " " + DateType.convert_slash_datetime2(tt.date_added);
//                        } else {
//                            return " ";
//                        }
//                    } else {
//                         return " " + DateType.convert_slash_datetime2(tt.date_added);
//                    }
                    if (tt.date_added != null) {
                        return " " + DateType.convert_slash_datetime2(tt.date_added);
                    } else {
                        return " ";
                    }

                case 2:
                    return " " + tt.customer_name;
                case 3:
                    return " " + FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 4:

                    return " " + FitIn.fmt_wc_0(tt.service_amount) + " ";
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
                    return tt.selected;
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
                String customer_id = jTextField1.getText();
                String where = " where or_no like '%" + customer_id + "%' ";
//                String where = " where customer_id like '%" + "" + "%' ";
                if (jCheckBox2.isSelected()) {
                    where = where + " and transaction_type_id=1 ";
                }
                if (jCheckBox3.isSelected()) {
                    where = where + " and transaction_type_id=2 ";
                }
                if (jCheckBox5.isSelected()) {
                    where = where + " and payment_type_id=1 ";
                }
                if (jCheckBox6.isSelected()) {
                    where = where + " and payment_type_id=2 ";
                }
                where = where + " order by Date(date_added) desc ";
                List<S1_sales.to_sales> datas = S1_sales.ret_data(where);
                List<S1_sales.to_sales> datas2 = S1_sales_dr.ret_data2(where);
                datas.addAll(datas2);
                loadData_sales(datas);
                double amount = 0;
                double unpaid = 0;
                double paid = 0;
                for (S1_sales.to_sales t : datas) {
                    double am = (t.amount_due + t.service_amount) - t.discount_amount;
                    amount += am;
                }

                jLabel10.setText("" + datas.size());
                jLabel11.setText(FitIn.fmt_wc_0(amount));
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
                Object[][] obj = new Object[customer_list.size()][2];
                int i = 0;
                for (Customers.to_customers to : customer_list) {
                    obj[i][0] = to.first_name + " " + to.last_name;
                    obj[i][1] = to.address;
                    i++;
                }
                JLabel[] labels = {};
                int[] tbl_widths_customers = {150, 200};
                int width = 0;
                String[] col_names = {"", ""};
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

    private ArrayListModel tbl_sales_items_ALM;
    private Tblsales_itemsModel tbl_sales_items_M;

    private void init_tbl_sales_items() {
        tbl_sales_items_ALM = new ArrayListModel();
        tbl_sales_items_M = new Tblsales_itemsModel(tbl_sales_items_ALM);
        tbl_sales_items.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_sales_items.setModel(tbl_sales_items_M);
        tbl_sales_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales_items.setRowHeight(25);
        int[] tbl_widths_sales_items = {50, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_sales_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales_items, i, tbl_widths_sales_items[i]);
        }
        Dimension d = tbl_sales_items.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_sales_items.getTableHeader().setPreferredSize(d);
        tbl_sales_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_sales_items.setRowHeight(25);
        tbl_sales_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_sales_items(List<to_sales_items> acc) {
        tbl_sales_items_ALM.clear();
        tbl_sales_items_ALM.addAll(acc);
    }

    public static class Tblsales_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", "Amount", "generic_name", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "session_no", "item_discount", "discount", "discount_amount", "sales_no", "fixed_price", "supplier", "supplier_id", "vatable", "or_no", "customer_name", "customer_id", "metered"
        };

        public Tblsales_itemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

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
            to_sales_items tt = (to_sales_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return "" + tt.description;
                case 2:
                    return " " + FitIn.fmt_woc(tt.product_qty * tt.selling_price);
                case 3:
                    return tt.generic_name;
                case 4:
                    return tt.category;
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.session_no;
                case 19:
                    return tt.item_discount;
                case 20:
                    return tt.discount;
                case 21:
                    return tt.discount_amount;
                case 22:
                    return tt.sales_no;
                case 23:
                    return tt.fixed_price;
                case 24:
                    return tt.supplier;
                case 25:
                    return tt.supplier_id;
                case 26:
                    return tt.vatable;
                case 27:
                    return tt.or_no;
                case 28:
                    return tt.customer_name;
                case 29:
                    return tt.customer_id;
                default:
                    return tt.metered;
            }
        }
    }

    private void data_cols_items() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(to.or_no);
        clipboard.setContents(strSel, null);
        String result = "";

        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
        } catch (IOException e) {
        }
        String where = " where sales_no='" + to.or_no + "'";
        List<to_sales_items> datas = new ArrayList();// S1_sales_items.ret_data3(where);
//        JOptionPane.showMessageDialog(null, to.or_no);
        if (to.is_sales == 0) {
            where = " where sales_no='" + to.or_no + "'";
            datas = S1_sales_dr_items.ret_data(where);
        } else {
            datas = S1_sales_items.ret_data3(where);
        }

        loadData_sales_items(datas);
        double amount = 0;
        for (to_sales_items to1 : datas) {
            amount += to1.product_qty * to1.selling_price;
        }
        jLabel6.setText(FitIn.fmt_wc_0(amount));
        jLabel5.setText("" + datas.size());
    }

    private void show_popup(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_sales, evt.getX(), evt.getY());
        }
    }

    private void print_all() {

        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(row);

        String where = " where or_no='" + to.or_no + "'";
        List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_receipt.field> fields = new ArrayList();
        int qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;
        for (S1_sales_items.to_sales_items to1 : datas) {
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
        String or_no = "OR NO. " + to.or_no;
        String items = System.getProperty("items", "");
        double total_due = ((to.amount_due + to.service_amount) - to.discount_amount);
        double cash = to.amount_paid;
        String check_bank = to.check_bank;
        double check_amount = to.check_amount;
        if (check_amount == 0) {
            cash = to.check_amount;
        } else {
            cash = 0;
        }

        double change_due = (to.amount_paid) - ((to.amount_due + to.service_amount) - to.discount_amount);
//        System.out.println("Change: "+to.amount_paid +"+"+ to.check_amount+"-("+to.amount_due+"+"+to.service_amount +")-"+ to.discount_amount+ " = "+change_due);
        System.out.println("First: " + to.amount_paid + "+" + to.check_amount + " = " + (to.amount_paid + to.check_amount));
        System.out.println("Second: " + to.amount_due + "+" + to.service_amount + " - " + to.discount_amount + " = " + ((to.amount_due + to.service_amount) - to.discount_amount));
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
        String trans_no = to.or_no;
        String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
        String discount_customer_name = to.discount_customer_name;
        String discount_customer_id = to.discount_customer_id;
        discount_customer_name = discount_customer_name + " - " + discount_customer_id;
        String min_no = System.getProperty("min_no", "MIN NO: 130321854");
        double addtl_service = to.service_amount;
        double net_due = ((to.amount_due + to.service_amount) - to.discount_amount);
        vatable_sale = net_due / 1.12;
        double vat_percent = vatable_sale * .12;
        String customer_address = to.customer_address;
        String reference_no = "";
        if (to.session_no.startsWith("DR")) {
            reference_no = "Ref #: " + to.session_no;
        }
        String check_no = to.check_no;
        Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, to.customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address, reference_no, to.amount_due, check_no);
        rpt.fields.addAll(fields);
        String l = "rpt_receipt.jrxml";
        if (to.is_sales == 0) {
            l = "rpt_receipt_1.jrxml";
        }
        InputStream is = Srpt_receipt.class.getResourceAsStream(l);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

            JasperPrintManager.printReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Dlg_customer_sales.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    JasperPrint jasperPrint = null;

    private void print_deliver_all() {

        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(row);

        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_delivery_receipt.field> fields = new ArrayList();
        String where = " where or_no='" + to.or_no + "'";
        List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
        for (S1_sales_items.to_sales_items to1 : datas) {
            double qty = to1.product_qty;
            String description = to1.description;
            double price = to1.selling_price;
            double amount = qty * price;
            String customer_name = to.customer_name;
            String customer_id = to.customer_id;
            String customer_contact_no = to.customer_contact_no;
            String customer_address = to.customer_address;
            String dispatch_time = "";
            String driver = to.driver_name;
            String checked_by = "";
            if (Users.screen_name != null) {
                checked_by = Users.screen_name.toUpperCase();
            }
            String released_by = "";
            String clearance_no = "";
            String released_date = DateType.convert_jan_1_2013_datetime2(to.date_added);
            if (to.time_delivered != null) {
                dispatch_time = DateType.convert_slash_datetime2(to.time_delivered);
            }
            double amount_due = to.amount_due + to.service_amount;
            double discount = to.discount_amount;
            double addtl_service = to.service_amount;
            String discount_customer_name = to.discount_customer_name;
            double total_duel = (amount_due) - to.discount_amount;
            String or_no = to.or_no;
            String vehicle_no = to.vehicle_name;
            Srpt_delivery_receipt.field f = new Srpt_delivery_receipt.field(qty, description, price, amount, customer_name, customer_id, customer_contact_no, customer_address, dispatch_time, driver, checked_by, released_by, clearance_no, released_date, amount_due, discount, addtl_service, discount_customer_name, total_duel, or_no, vehicle_no);
            fields.add(f);
        }
        String jrxml = "rpt_delivery_receipt_1.jrxml";
        InputStream is = Srpt_delivery_receipt.class.getResourceAsStream(jrxml);
        String transaction_no = "No. 281567";
        String business_name = "Kwikdel";
        String address = "25 Dr Locsin, Dumaguete, Negros Oriental, Philippines";
        String contact_no = "Phone: +63(35)4226888";
        String customer_name = "St. Paul University";
        String customer_id = "00001";
        String customer_contact_no = "";
        String customer_address = "Dumaguete, Negros Oriental, Philippines";
        String checked_by = "";
        String dispatch_time = "";
        String vehicle_no = "";
        String driver = "";
        String released_by = "";
        String clearance_no = "";
        String released_date = "";
        double amount_due = 0;
        String operated_by = "";
        double discount = 0;
        double addtl_service = 0;
        String discount_customer_name = "";
        double total_duel = 0;
        Srpt_delivery_receipt rpt = new Srpt_delivery_receipt(transaction_no, business_name, address, contact_no, operated_by);
        rpt.fields.addAll(fields);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

            JasperPrintManager.printReport(jasperPrint, true);
        } catch (JRException ex) {
            Logger.getLogger(Dlg_customer_sales.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
}
