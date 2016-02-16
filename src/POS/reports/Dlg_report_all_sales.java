/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

import POS.main.Main;

import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items;
import POS.sales.Srpt_receipt;
import POS.users.S1_users;
import POS.util.DateType;
import POS.util.TextHighlighter1;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author Maytopacka
 */
public class Dlg_report_all_sales extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_report_all_sales
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
    private Dlg_report_all_sales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_report_all_sales(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_report_all_sales() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_report_all_sales myRef;

    private void setThisRef(Dlg_report_all_sales myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_all_sales> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_all_sales create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_all_sales create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_all_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_all_sales((java.awt.Frame) parent, false);
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
            Dlg_report_all_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_all_sales((java.awt.Dialog) parent, false);
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

        Dlg_report_all_sales dialog = Dlg_report_all_sales.create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jm_reprint = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        pnl_report = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_cashier = new javax.swing.JComboBox();
        cb_report = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pnl_items = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbl_count = new javax.swing.JLabel();
        lbl_amount_due = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_service = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_check = new javax.swing.JLabel();
        pnl_sales_item = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sales_items = new javax.swing.JTable();

        jm_reprint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jm_reprint.setText("REPRINT");
        jm_reprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_reprintActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jm_reprint);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Date to:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date to:");

        jButton1.setText("SEARCH");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cashier:");

        cb_cashier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_report.setSelected(true);
        cb_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_reportActionPerformed(evt);
            }
        });

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel1.setText("State:");

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_report, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dp_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dp_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(cb_cashier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pnl_items.setBackground(new java.awt.Color(255, 255, 255));

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        jLabel6.setText("SEARCH:");

        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Record Count:");

        lbl_count.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_count.setText("0");

        lbl_amount_due.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_amount_due.setText("0.00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Total Sales:");

        lbl_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_discount.setText("0.00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Discount:");

        lbl_service.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_service.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Service:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Check:");

        lbl_check.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_check.setText("0.00");

        javax.swing.GroupLayout pnl_itemsLayout = new javax.swing.GroupLayout(pnl_items);
        pnl_items.setLayout(pnl_itemsLayout);
        pnl_itemsLayout.setHorizontalGroup(
            pnl_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_itemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_itemsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(pnl_itemsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_search)
                        .addContainerGap())
                    .addGroup(pnl_itemsLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_amount_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_service, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))))
        );
        pnl_itemsLayout.setVerticalGroup(
            pnl_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_itemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_count)
                    .addComponent(jLabel10)
                    .addComponent(lbl_amount_due)
                    .addComponent(jLabel12)
                    .addComponent(lbl_discount)
                    .addComponent(jLabel14)
                    .addComponent(lbl_service)
                    .addComponent(jLabel15)
                    .addComponent(lbl_check))
                .addContainerGap())
        );

        pnl_sales_item.setBackground(new java.awt.Color(255, 255, 255));

        tbl_sales_items.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_sales_items);

        javax.swing.GroupLayout pnl_sales_itemLayout = new javax.swing.GroupLayout(pnl_sales_item);
        pnl_sales_item.setLayout(pnl_sales_itemLayout);
        pnl_sales_itemLayout.setHorizontalGroup(
            pnl_sales_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_sales_itemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnl_sales_itemLayout.setVerticalGroup(
            pnl_sales_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_sales_itemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_sales_item, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnl_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_sales_item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        do_report();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_reportActionPerformed
        // TODO add your handling code here:
        select_report();
    }//GEN-LAST:event_cb_reportActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_cols2();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
        data_cols_items();
        pm_tbl_menu(evt);
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void jm_reprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_reprintActionPerformed
        // TODO add your handling code here:
        reprint();
    }//GEN-LAST:event_jm_reprintActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        print();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cashier;
    private javax.swing.JCheckBox cb_report;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jm_reprint;
    private javax.swing.JLabel lbl_amount_due;
    private javax.swing.JLabel lbl_check;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_service;
    private javax.swing.JPanel pnl_items;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JPanel pnl_sales_item;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTable tbl_sales_items;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        Main.MyDB.setNames("db_fortune_three");
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        set_cashier();
        pnl_items.setVisible(false);
        pnl_sales_item.setVisible(false);
        init_tbl_sales();
        init_tbl_sales_items();
//        jPanel2.set
    }

    private void select_report() {
        if (cb_report.isSelected()) {

            pnl_report.setVisible(true);
            pnl_items.setVisible(false);
            pnl_sales_item.setVisible(false);
        } else {
            pnl_items.setVisible(true);
            pnl_sales_item.setVisible(true);
            pnl_report.setVisible(false);
        }
    }

    private void set_cashier() {
        cb_cashier.setModel(new ListComboBoxModel(S1_users.
                ret_cashier_names_w_admin()));
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

    private void do_report() {
        if (cb_report.isSelected()) {
            get_data();
        } else {
            data_cols();
        }
    }

    private void get_data() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date_from = DateType.sf.format(dp_from.getDate());
                String date_to = DateType.sf.format(dp_to.getDate());
                String cashier_name = cb_cashier.getSelectedItem().toString();
                S1_users.to_users to = S1_users.ret_data_w_screen_name(cashier_name);
                if (to == null) {
                    cashier_name = "";
                } else {
                    cashier_name = to.user_name;
                }

                if (cb_cashier.getSelectedIndex() == 0) {
                    cashier_name = "";
                }
                String where = " where Date(date_added) between '"+date_from+"' and '"+date_to+"'  order by or_no asc";

                List<Srpt_all_sales_report.field> fields = Srpt_all_sales_report.ret_data2(where);
                String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
                String business_owner = System.getProperty("operated_by", "Ernesto C.QUiamco");
                String business_address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
                String date_printed = DateType.day_and_time.format(new Date());
                String sales_date = "Sales Date: [" + DateType.slash.format(dp_from.getDate()) + "]" + " - " + "[" + DateType.slash.
                        format(dp_to.getDate()) + "]";
                String printed_by = "";
                if (Users.screen_name != null) {
                    printed_by = Users.screen_name.toUpperCase();
                }
                double walkin_collected = 0;
                double walkin_receivables = 0;
                double delivery_collected = 0;
                double delivery_receivables = 0;
                double net_sales = 0;
                for (Srpt_all_sales_report.field s : fields) {
                    double amount = (s.amount_due + s.service_amount) - s.discount_amount;
                    if (s.transaction_type == 1) {
                        if (s.status == 0) {

                            if (s.payment_type == 1) {
                                walkin_collected += amount;
                            } else {
                                if (s.charge_status == 1) {
                                    walkin_collected += amount;
                                } else {
                                    walkin_receivables += amount;
                                }
                            }
                        }
                        if (s.status >= 0 && s.status <= 8) {
                            if (s.payment_type == 1) {
                                walkin_collected += amount;
                            } else {
                                if (s.charge_status == 1) {
                                    walkin_collected += amount;
                                } else {
                                    walkin_receivables += amount;
                                }
                            }
                        }
                    } else {
                        if (s.status == 0) {

                            if (s.payment_type == 1) {
                                delivery_collected += amount;
                            } else {
                                if (s.charge_status == 1) {
                                    delivery_collected += amount;
                                } else {
                                    delivery_receivables += amount;
                                }
                            }
                        }
                        if (s.status >= 0 && s.status <= 8) {
                            if (s.payment_type == 1) {
                                delivery_collected += amount;
                            } else {
                                if (s.charge_status == 1) {
                                    delivery_collected += amount;
                                } else {
                                    delivery_receivables += amount;
                                }
                            }
                        }
                    }

                }
                net_sales=walkin_collected+delivery_collected;
                String SUBREPORT_DIR = System.getProperty("user.home");
                Srpt_all_sales_report rpt = new Srpt_all_sales_report(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR, walkin_collected, walkin_receivables, delivery_collected, delivery_receivables, net_sales);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_all_sales_report.jrxml";
                report_sales_items(rpt, jrxml);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }

    private void report_sales_items(final Srpt_all_sales_report to, String jrxml_name) {
        pnl_report.removeAll();
        pnl_report.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_all_sales(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report.add(viewer);
            pnl_report.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_all_sales(Srpt_all_sales_report to, String rpt_name) {
//        Connection con11 = null;
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint = null;

    private void print() {
        try {
            JasperPrintManager.printReport(jasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
    private ArrayListModel tbl_sales_ALM;
    private TblsalesModel tbl_sales_M;

    private void init_tbl_sales() {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {0, 150, 100, 100, 100, 100, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }
        Dimension d = tbl_sales.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_sales.getTableHeader().
                setPreferredSize(d);
        tbl_sales.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_sales.setRowHeight(35);
        tbl_sales.setFont(new java.awt.Font("Arial", 1, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 7);
    }

    private void loadData_sales(List<to_sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "OR NO", "DATE", "AMOUNT DUE", "DISCOUNT", "CHECK", "SERVICE", "STATUS", "discount_name", "discount", "discount_amount", "customer_name", "check_bank", "check_no", "check_amount", "discount_customer_name", "discount_customer_id", "status", "or_no", "check_holder", "services", "service_amount"
        };

        public TblsalesModel(ListModel listmodel) {
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
            to_sales tt = (to_sales) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.sales_no;
                case 2:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
                case 3:
                    return FitIn.fmt_wc_0(tt.amount_due);
                case 4:
                    return FitIn.fmt_wc_0(tt.discount_amount);
                case 5:
                    return FitIn.fmt_wc_0(tt.check_amount);
                case 6:
                    return FitIn.fmt_wc_0(tt.service_amount);
                case 7:
                    if (tt.status == 0) {

                        return "COUNTED";
//                        return TextHighlighter1.highlight("VOID", "VOID", "RED");
                    } else {
                        return TextHighlighter1.highlight("VOID", "VOID", "RED");
                    }
                case 8:
                    return tt.discount_name;
                case 9:
                    return tt.discount;
                case 10:
                    return tt.discount_amount;
                case 11:
                    return tt.customer_name;
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
                default:
                    return tt.service_amount;
            }
        }
    }

    private void data_cols() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String cashier_name = cb_cashier.getSelectedItem().
                toString();
        S1_users.to_users to = S1_users.ret_data_w_screen_name(cashier_name);
        if (to == null) {
            cashier_name = "";
        } else {
            cashier_name = to.user_name;
        }
        if (cb_cashier.getSelectedIndex() == 0) {
            cashier_name = "";
        }

        loadData_sales(Srpt_all_sales_report.ret_data_report(date_from, date_to, cashier_name));
        List<to_sales> datas = tbl_sales_ALM;
        double amount_due = 0;
        double discount = 0;
        double service = 0;
        double check = 0;
        for (to_sales to1 : datas) {
            amount_due += to1.amount_due;
            discount += to1.discount_amount;
            service += to1.service_amount;
            check += to1.check_amount;
        }

        lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due));
        lbl_discount.setText(FitIn.fmt_wc_0(discount));
        lbl_service.setText(FitIn.fmt_wc_0(service));
        lbl_check.setText(FitIn.fmt_wc_0(check));
        lbl_count.setText("" + datas.size());
    }

    private void data_cols2() {
        String search = tf_search.getText();
        loadData_sales(Srpt_all_sales_report.ret_data_report_or(search));
        List<to_sales> datas = tbl_sales_ALM;
        double amount_due = 0;
        double discount = 0;
        double service = 0;
        double check = 0;
        for (to_sales to1 : datas) {
            amount_due += to1.amount_due;
            discount += to1.discount_amount;
            service += to1.service_amount;
            check += to1.check_amount;
        }
        lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due));
        lbl_discount.setText(FitIn.fmt_wc_0(discount));
        lbl_service.setText(FitIn.fmt_wc_0(service));
        lbl_check.setText(FitIn.fmt_wc_0(check));
        lbl_count.setText("" + datas.size());
    }
    private ArrayListModel tbl_sales_items_ALM;
    private Tblsales_itemsModel tbl_sales_items_M;

    private void init_tbl_sales_items() {
        tbl_sales_items_ALM = new ArrayListModel();
        tbl_sales_items_M = new Tblsales_itemsModel(tbl_sales_items_ALM);
        tbl_sales_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_sales_items.setModel(tbl_sales_items_M);
        tbl_sales_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales_items.setRowHeight(25);
        int[] tbl_widths_sales_items = {50, 70, 100, 50, 50, 60, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales_items, i, tbl_widths_sales_items[i]);
        }
        Dimension d = tbl_sales_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_sales_items.getTableHeader().
                setPreferredSize(d);
        tbl_sales_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_sales_items.setRowHeight(35);
        tbl_sales_items.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 4);
    }

    private void loadData_sales_items(List<S1_sales_items.to_sales_items> acc) {
        tbl_sales_items_ALM.clear();
        tbl_sales_items_ALM.addAll(acc);
    }

    public static class Tblsales_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "BARCODE", "DESCRIPTION", "UNIT", "DISC.", "PRICE", "TOTAL", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "session_no", "item_discount", "discount", "discount_amount", "sales_no", "fixed_price", "supplier", "supplier_id", "vatable", "or_no"
        };

        public Tblsales_itemsModel(ListModel listmodel) {
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
            S1_sales_items.to_sales_items tt = (S1_sales_items.to_sales_items) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_wc_0(tt.product_qty);
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.discount_amount);
                case 5:
                    return FitIn.fmt_wc_0(tt.selling_price);
                case 6:
                    return FitIn.fmt_wc_0(tt.product_qty * tt.selling_price);
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
                default:
                    return tt.or_no;
            }
        }
    }

    private void data_cols_items() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.
                convertRowIndexToModel(row));
        loadData_sales_items(S1_sales_items.ret_data(to.sales_no));
    }

    private void reprint() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.
                convertRowIndexToModel(row));
        List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_receipt.field> fields = new ArrayList();
        int qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;
        double vat_percent = 0;

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

            Srpt_receipt.field tbar = new Srpt_receipt.field(to1.description + add, new Date(), to1.selling_price * to1.product_qty, to1.product_qty, to1.selling_price);
            fields.add(tbar);
        }
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        String status = System.getProperty("status", "NV");
        String tin_no = System.getProperty("tin_no", "") + " " + status;
        String serial_no = System.getProperty("serial_no", "");
        String permit_no = System.getProperty("permit_no", "");
        String datetime = DateType.slash_w_time.format(new Date());
        String or_no = "OR NO. " + to.sales_no;
        String items = System.getProperty("items", "");
        double total_due = to.amount_due + to.service_amount;
        double cash = to.amount_paid;
        String check_bank = to.check_bank;
        double check_amount = to.check_amount;
        double change_due = (to.amount_paid + to.check_amount) - (total_due - to.discount_amount);
        System.out.println(change_due + " - - ");
        String receipt_infos = System.getProperty("receipt_infos", "");
        String receipt_footer = System.getProperty("receipt_footer", "This is not an Official Receipt ");
        double discount = to.discount_amount;
//            System.out.println("------- " + cash + " - " + total_due + " (" + discount + ") = " + change_due);
        String customer_name = to.customer_name;
        String cashier_name = Users.user_name;
        String discount_name = to.discount_name;
        if (discount_name.equalsIgnoreCase("NO DISCOUNT")) {
            discount_name = "";
        }
        String pos_no = "POS 1";
        int total_qty = datas.size();

        String accreditation_no = System.getProperty("acct_no", "Accreditation No. 000-0000000000-000000");
        String trans_no = to.sales_no;
        String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
        String discount_customer_name = to.discount_customer_name;
//            System.out.println(discount_customer_name+ " asdasd");
        String discount_customer_id = to.discount_customer_id;
        discount_customer_name = discount_customer_name + " - " + discount_customer_id;
        String min_no = System.getProperty("min_no", "MIN NO: 130321854");

        double addtl_service = to.service_amount;
        String customer_address = to.customer_address;
//            System.out.println(""+discount_customer_id + " ----");
        Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address,"",to.amount_due,"");
        rpt.fields.addAll(fields);
        String l = "rpt_receipt.jrxml";
        JasperReport jasperReport = null;
        InputStream is = Srpt_receipt.class.getResourceAsStream(l);
        try {
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

            JasperPrintManager.printReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Dlg_report_all_sales.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    private void pm_tbl_menu(MouseEvent evt) {
//        if (evt.isPopupTrigger()) {
        jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
//        }
    }

}
