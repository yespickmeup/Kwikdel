/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.disbursements;

import POS.expenses.S1_expenses;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.*;
import java.text.ParseException;
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
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_disbursements extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_location
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
    private Dlg_disbursements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_disbursements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_disbursements() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_disbursements myRef;

    private void setThisRef(Dlg_disbursements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_disbursements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_disbursements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_disbursements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_disbursements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursements((java.awt.Frame) parent, false);
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
            Dlg_disbursements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_disbursements((java.awt.Dialog) parent, false);
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

        Dlg_disbursements dialog = Dlg_disbursements.create(new javax.swing.JFrame(), true);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cash_drawer_expenses = new org.jdesktop.swingx.JXTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        btn_new = new org.jdesktop.swingx.JXLabel();
        btn_edit = new org.jdesktop.swingx.JXLabel();
        btn_delete = new org.jdesktop.swingx.JXLabel();
        btn_add = new org.jdesktop.swingx.JXLabel();
        jLabel1 = new javax.swing.JLabel();
        dp_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_bank = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dp_timein = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setOpaque(false);

        jXPanel3.setBackground(new java.awt.Color(240, 237, 223));

        jScrollPane2.setOpaque(false);

        tbl_cash_drawer_expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_cash_drawer_expenses.setOpaque(false);
        tbl_cash_drawer_expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_expensesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_cash_drawer_expenses);

        jLabel4.setText("Total Amount:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("0.00");

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        jXPanel1.setBackground(new java.awt.Color(240, 237, 223));

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_reload.png"))); // NOI18N
        btn_new.setText("NEW");
        btn_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_newMouseClicked(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_edit.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_drop.png"))); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new.png"))); // NOI18N
        btn_add.setText("ADD");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        jLabel1.setText("From:");

        dp_date.setDate(new Date());

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dp_to.setDate(new Date());

        jLabel6.setText("To:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dp_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dp_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(240, 237, 223));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name:");

        tf_bank.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_bank.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bankActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Amount:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setText("Date:");

        dp_timein.setDate(new Date());

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_bank)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_timein, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_bank)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_amount)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dp_timein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newMouseClicked
        clear_cash_drawer_expenses();
        tf_bank.grabFocus();
    }//GEN-LAST:event_btn_newMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        add_cash_drawer_expenses();
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        edit_cash_drawer_expenses();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        delete_cash_drawer_expenses();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void tbl_cash_drawer_expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_expensesMouseClicked
        select_cash_drawer_expenses();
    }//GEN-LAST:event_tbl_cash_drawer_expensesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_cols();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bankActionPerformed
        init_printing_assembly(tf_bank);
    }//GEN-LAST:event_tf_bankActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel btn_add;
    private org.jdesktop.swingx.JXLabel btn_delete;
    private org.jdesktop.swingx.JXLabel btn_edit;
    private org.jdesktop.swingx.JXLabel btn_new;
    private com.toedter.calendar.JDateChooser dp_date;
    private com.toedter.calendar.JDateChooser dp_timein;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable tbl_cash_drawer_expenses;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_bank;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        init_key();
        hover();
        search();
        init();
        init_tbl_cash_drawer_expenses();
        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_bank, tf_amount};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }
    // <editor-fold defaultstate="collapsed" desc="settings">

    private void hover() {
        btn_edit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_edit.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_edit.png")));
            }
        });

        btn_delete.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_drop.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_drop.png")));
            }
        });
        btn_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_snewtbl.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_new.png")));
            }
        });
        btn_new.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/s_reload.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_reload.png")));
            }
        });

    }
    int posX = 0, posY = 0;

    private void init() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }

    private void search() {

    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    private void exit2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(153, 153, 153));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    // </editor-fold>

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

    private ArrayListModel tbl_cash_drawer_expenses_ALM;
    private Tblcash_drawer_expensesModel tbl_cash_drawer_expenses_M;

    private void init_tbl_cash_drawer_expenses() {
        tbl_cash_drawer_expenses_ALM = new ArrayListModel();
        tbl_cash_drawer_expenses_M = new Tblcash_drawer_expensesModel(tbl_cash_drawer_expenses_ALM);
        tbl_cash_drawer_expenses.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_cash_drawer_expenses.setModel(tbl_cash_drawer_expenses_M);
        tbl_cash_drawer_expenses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_expenses.setRowHeight(25);
        int[] tbl_widths_cash_drawer_expenses = {100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_expenses.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_expenses, i, tbl_widths_cash_drawer_expenses[i]);
        }
        Dimension d = tbl_cash_drawer_expenses.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_cash_drawer_expenses.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer_expenses.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_cash_drawer_expenses.setRowHeight(35);
        tbl_cash_drawer_expenses.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer_expenses, 2);
    }

    private void loadData_cash_drawer_expenses(List<S1_disbursements.to_cash_drawer_expenses> acc) {
        tbl_cash_drawer_expenses_ALM.clear();
        tbl_cash_drawer_expenses_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_expensesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Name", "Amount", "screen_name", "time_in", "time_out", "bank", "check_no", "check_holder", "amount", "date_added"
        };

        public Tblcash_drawer_expensesModel(ListModel listmodel) {
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
            S1_disbursements.to_cash_drawer_expenses tt = (S1_disbursements.to_cash_drawer_expenses) getRow(row);
            switch (col) {
                case 0:
                    return DateType.convert_dash_date(tt.time_in);
                case 1:
                    return tt.bank;
                case 2:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 3:
                    return tt.screen_name;
                case 4:
                    return tt.time_in;
                case 5:
                    return tt.time_out;
                case 6:
                    return tt.bank;
                case 7:
                    return tt.check_no;
                case 8:
                    return tt.check_holder;
                case 9:
                    return tt.amount;
                default:
                    return tt.date_added;
            }
        }
    }

    private void data_cols() {
        String date_from = DateType.sf.format(dp_date.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String where = "where date(time_in) between '" + date_from + "' and '" + date_to + "'";
        List<S1_disbursements.to_cash_drawer_expenses> datas = S1_disbursements.ret_data(where);
        loadData_cash_drawer_expenses(datas);
        double amount = 0;
        for (S1_disbursements.to_cash_drawer_expenses to : datas) {
            amount += to.amount;
        }
        jLabel5.setText(FitIn.fmt_wc_0(amount));
    }

    private void add_cash_drawer_expenses() {
        int id = -1;
        String session_no = "";
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = DateType.datetime.format(dp_timein.getDate());
        String time_out = DateType.datetime.format(dp_timein.getDate());
        String bank = tf_bank.getText();
        String check_no = "";
        String check_holder = "";
        double amount = FitIn.toDouble(tf_amount.getText());
        String date_added = DateType.datetime.format(new Date());
        if (bank.isEmpty() || amount == 0) {
            Alert.set(0, "Empty Fields");
        }
        S1_disbursements.to_cash_drawer_expenses to = new S1_disbursements.to_cash_drawer_expenses(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount, date_added);

        S1_disbursements.add_cash_drawer_expenses(to);
        data_cols();
        clear_cash_drawer_expenses();
        Alert.set(1, bank);
    }

    private void select_cash_drawer_expenses() {
        int row = tbl_cash_drawer_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_disbursements.to_cash_drawer_expenses to = (S1_disbursements.to_cash_drawer_expenses) tbl_cash_drawer_expenses_ALM.get(tbl_cash_drawer_expenses.convertRowIndexToModel(row));

        tf_bank.setText(to.bank);

        tf_amount.setText(FitIn.fmt_wc_0(to.amount));
        try {
            Date d = DateType.datetime.parse(to.time_in);
            dp_timein.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_disbursements.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void edit_cash_drawer_expenses() {
        int row = tbl_cash_drawer_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_disbursements.to_cash_drawer_expenses to = (S1_disbursements.to_cash_drawer_expenses) tbl_cash_drawer_expenses_ALM.get(tbl_cash_drawer_expenses.convertRowIndexToModel(row));
        int id = to.id;
        String session_no = "";
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = DateType.datetime.format(dp_timein.getDate());
        String time_out = DateType.datetime.format(dp_timein.getDate());
        String bank = tf_bank.getText();
        String check_no = "";
        String check_holder = "";
        double amount = FitIn.toDouble(tf_amount.getText());
        String date_added = DateType.datetime.format(new Date());
        if (bank.isEmpty() || amount == 0) {
            Alert.set(0, "Empty Fields");
        }
        S1_disbursements.to_cash_drawer_expenses to1 = new S1_disbursements.to_cash_drawer_expenses(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount, date_added);

        S1_disbursements.edit_cash_drawer_expenses(to1);
        data_cols();
        clear_cash_drawer_expenses();
        Alert.set(2, bank);
    }

    private void clear_cash_drawer_expenses() {

        tf_bank.setText("");

        tf_amount.setText("");

    }

    private void delete_cash_drawer_expenses() {
        int row = tbl_cash_drawer_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_disbursements.to_cash_drawer_expenses to = (S1_disbursements.to_cash_drawer_expenses) tbl_cash_drawer_expenses_ALM.get(tbl_cash_drawer_expenses.convertRowIndexToModel(row));
        S1_disbursements.delete_cash_drawer_expenses(to);
        data_cols();
        clear_cash_drawer_expenses();
        Alert.set(3, "");
    }

    List<S1_expenses.to_expenses> expenses_list = new ArrayList();

    private void init_printing_assembly(final JTextField tf1) {
        String search = tf1.getText();
        expenses_list.clear();
        String where = "";
        where = " where expense_name like '%" + search + "%' order by expense_name asc";
        expenses_list = S1_expenses.ret_data(search);
        if (!expenses_list.isEmpty()) {
            Object[][] obj = new Object[expenses_list.size()][2];
            int i = 0;
            for (S1_expenses.to_expenses to : expenses_list) {
                obj[i][0] = to.id;
                obj[i][1] = to.expense_name;
                i++;
            }
            JLabel[] labels = {};
            int[] tbl_widths_customers = {70, 200};
            int width = 0;
            String[] col_names = {"ID #", "Name"};
            TableRenderer tr = new TableRenderer();
            TableRenderer.setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
            tr.setCallback(new TableRenderer.Callback() {
                @Override
                public void ok(TableRenderer.OutputData data) {
                    S1_expenses.to_expenses to = expenses_list.get(data.selected_row);
                    tf1.setText("" + to.expense_name);
                    tf_amount.grabFocus();
                }
            });
        } else {

        }

    }
}
