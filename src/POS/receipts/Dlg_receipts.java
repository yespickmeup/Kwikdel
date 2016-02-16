/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.items.S1_items;
import POS.main.Main;
import POS.receipts.S1_receipt_orders.to_receipt_items;
import POS.suppliers.S1_suppliers;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author Maytopacka
 */
public class Dlg_receipts extends javax.swing.JDialog {

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
    private Dlg_receipts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_receipts(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_receipts() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_receipts myRef;

    private void setThisRef(Dlg_receipts myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_receipts> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_receipts create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_receipts create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_receipts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_receipts((java.awt.Frame) parent, false);
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
            Dlg_receipts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_receipts((java.awt.Dialog) parent, false);
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


        Dlg_receipts dialog = Dlg_receipts.create(new javax.swing.JFrame(), true);
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
        tbl_items = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        tf_search = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_remarks = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb_supplier = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        dp_date_delivered = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dp_date_received = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_receipt_items = new org.jdesktop.swingx.JXTable();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setOpaque(false);

        jXPanel3.setBackground(new java.awt.Color(240, 237, 223));

        jScrollPane2.setOpaque(false);

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_items.setOpaque(false);
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_items);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel1.setBackground(new java.awt.Color(240, 237, 223));

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("SEARCH (F1):");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(240, 237, 223));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SUPPLIER:");

        tf_remarks.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_remarks.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("REMARKS:");

        cb_supplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_supplier.setFocusable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/s_reload.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DATE OF DELIVERY:");

        dp_date_delivered.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DATE RECEIVED:");

        dp_date_received.setFocusable(false);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_remarks))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dp_date_delivered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dp_date_received, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_remarks)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_date_delivered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_date_received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setOpaque(false);

        jXPanel4.setBackground(new java.awt.Color(240, 237, 223));

        jScrollPane3.setOpaque(false);

        tbl_receipt_items.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_receipt_items.setOpaque(false);
        tbl_receipt_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receipt_itemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_receipt_items);

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel6.setBackground(new java.awt.Color(240, 237, 223));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("OK (CTRL)");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("CLEAR ALL (F5)");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SELECT LIST (F2), DELETE LIST (DEL)");

        javax.swing.GroupLayout jXPanel6Layout = new javax.swing.GroupLayout(jXPanel6);
        jXPanel6.setLayout(jXPanel6Layout);
        jXPanel6Layout.setHorizontalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jXPanel6Layout.setVerticalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jXPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        add_items();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_receipt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_receipt_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMouseClicked
        edit_items();
    }//GEN-LAST:event_tbl_receipt_itemsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        init_supplier();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_supplier;
    private com.toedter.calendar.JDateChooser dp_date_delivered;
    private com.toedter.calendar.JDateChooser dp_date_received;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private org.jdesktop.swingx.JXTable tbl_items;
    private org.jdesktop.swingx.JXTable tbl_receipt_items;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        tf_search.grabFocus();
        focus();
        init_key();
        hover();
        search();
        init();
        init_supplier();

        init_tbl_items();
        data_cols();

        init_tbl_receipt_items();
        dp_date_delivered.setDate(new Date());
        dp_date_received.setDate(new Date());
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                tf_search.requestFocus();
            }
        });
    }

    private void focus() {
        JTextField[] tf = {tf_search};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_supplier() {
        cb_supplier.setModel(new ListComboBoxModel(S1_suppliers.ret_cb_data()));
    }
    // <editor-fold defaultstate="collapsed" desc="settings">

    private void hover() {
//        btn_edit.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/b_edit.png")));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/bd_edit.png")));
//            }
//        });
//
//        btn_delete.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/b_drop.png")));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/bd_drop.png")));
//            }
//        });
//        btn_add.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/b_snewtbl.png")));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/bd_new.png")));
//            }
//        });
//        btn_new.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/s_reload.png")));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
//                        getResource("/POS/img/bd_reload.png")));
//            }
//        });
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
//        SearchField sf = (SearchField) tf_search;
//        sf.setFont(new java.awt.Font("Tahoma", 1, 12));
//        sf.set_instruction1("Type To Search");
//        sf.set_searcher(new SearchField.ISearcher() {
//
//            @Override
//            public List get_entered(String starts_with) {
//                // your search list here coming from svc for example.
//
//                return new ArrayList();
//
//            }
//        });
//        sf.setCallbackDisplay(new SearchField.CallbackDisplay() {
//
//            @Override
//            public void display(Object o) {
//            }
//        });
//        sf.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//            }
//        });
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
                disposed();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_CONTROL, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_search.grabFocus();
                tf_search.selectAll();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbl_receipt_items_ALM.isEmpty()) {
                    tbl_receipt_items.setRowSelectionInterval(0, 0);
                    tbl_receipt_items.grabFocus();
                }
            }
        });
        tf_search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbl_items_ALM.size() == 1) {
                    tbl_items.setRowSelectionInterval(0, 0);
                    add_items();
//                    e.consume();
//                    tf_search.selectAll();
//                    tf_search.grabFocus();
                }
            }
        });
        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_items_ALM.isEmpty()) {
                        tbl_items.setRowSelectionInterval(0, 0);
                        tbl_items.grabFocus();
                    }
                }
                 if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                   add_receipt();
                }
            }
        });
        tbl_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add_items();
                    e.consume();

                }
                 if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                   add_receipt();
                }
            }
        });
        tbl_receipt_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    edit_items();
                }
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    delete_items();
                }
                 if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                   add_receipt();
                }
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_items_ALM;
    private TblitemsModel tbl_items_M;

    private void init_tbl_items() {
        tbl_items_ALM = new ArrayListModel();
        tbl_items_M = new TblitemsModel(tbl_items_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_items_M);
        tbl_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        int[] tbl_widths_items = {50, 60, 100, 0, 0, 0, 0, 0, 0, 0, 0, 60, 60, 60, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 1, 11));
        tbl_items.setRowHeight(35);
        tbl_items.setFont(new java.awt.Font("Arial", 1, 11));
    }

    private void loadData_items(List<S1_items.to_items> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "BARCODE", "DESCRIPTION", "generic_name", "CATEGORY", "category_id", "CLASSIFICATION", "classification_id", "SUB-CLASS", "sub_classification_id", "id", "UNIT", "COST", "SELL. PRICE", "date_added", "user_name", "item_type", "ACTIVE"
        };

        public TblitemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 111) {
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
            S1_items.to_items tt = (S1_items.to_items) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_wc_0(tt.product_qty);
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
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
                    return tt.id;
                case 11:
                    return tt.unit;
                case 12:
                    return FitIn.fmt_wc_0(tt.cost);
                case 13:
                    return FitIn.fmt_wc_0(tt.selling_price);
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                default:
                    if (tt.status == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }

            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        loadData_items(S1_items.ret_data3(search, "", "", "", ""));
    }
    private ArrayListModel tbl_receipt_items_ALM;
    private Tblreceipt_itemsModel tbl_receipt_items_M;

    private void init_tbl_receipt_items() {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);
        int[] tbl_widths_receipt_items = {70, 0, 0, 0, 0, 0, 0, 0, 80, 100, 0, 80, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipt_items.length; i < n; i++) {
            if (i == 9) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_items, i, tbl_widths_receipt_items[i]);
        }
        Dimension d = tbl_receipt_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipt_items.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_items.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        tbl_receipt_items.setRowHeight(35);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 1, 11));
    }

    private void loadData_receipt_items(List<to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "receipt_no", "user_name", "session_no", "date_added", "supplier", "supllier_id", "remarks", "BARCODE", "DESCRIPTION", "id", "COST", "category", "category_id", "classification", "classification_id", "sub_class", "TOTAL"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            to_receipt_items tt = (to_receipt_items) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_woc(tt.qty);
                case 1:
                    return tt.receipt_no;
                case 2:
                    return tt.user_name;
                case 3:
                    return tt.session_no;
                case 4:
                    return tt.date_added;
                case 5:
                    return tt.supplier;
                case 6:
                    return tt.supllier_id;
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.barcode;
                case 9:
                    return tt.description;
                case 10:
                    return tt.qty;
                case 11:
                    return FitIn.fmt_wc_0(tt.cost);
                case 12:
                    return tt.category;
                case 13:
                    return tt.category_id;
                case 14:
                    return tt.classification;
                case 15:
                    return tt.classification_id;
                case 16:
                    return tt.sub_class;
                default:
                    return FitIn.fmt_wc_0(tt.qty * tt.cost);
            }
        }
    }

    private void data_cols_items() {
//        String search = tf_search.getText();
//        loadData_receipt_items(S1_receipt_items.ret_data(search));
    }

    private void add_items() {
        final List<to_receipt_items> datas = tbl_receipt_items_ALM;
        final List<to_receipt_items> acc = new ArrayList();
        acc.addAll(datas);

        int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final S1_items.to_items to = (S1_items.to_items) tbl_items_ALM.get(tbl_items.
                convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
        nd.setTitle("");
        nd.do_pass2(0,to.cost,to.description,to.unit);
        nd.setCallback(new Dlg_qty_cost.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                closeDialog.ok();
                int id = -1;
                String receipt_no = "0";//S1_re.increment_id();
                String user_name = Users.user_name;
                String session_no = Users.session_no;
                String date_added = DateType.datetime.format(new Date());
                String supplier = to.supplier;
                String supllier_id = "0";
                String remarks = tf_remarks.getText();
                String barcode = to.barcode;
                String description = to.description;
                double qty = data.amount;
                double cost = data.cost;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_class = to.sub_classification;
                String sub_class_id = to.sub_classification_id;
                double total = qty * cost;
                to_receipt_items to2 = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, total, to.conversion, to.unit);
                int naa = 0;
                for (to_receipt_items to3 : datas) {
                    if (to3.barcode.equals(to2.barcode)&& to3.unit.equals(to2.unit)) {
                        naa = 1;
                        double n_qty = data.amount + to3.qty;
                        to3.setQty(n_qty);
                        to3.setCost(cost);
                        tbl_receipt_items_M.fireTableDataChanged();
                        break;
                    } else {
                        naa = 0;
                    }
                }
                if (naa == 0) {
                    acc.add(to2);
                    loadData_receipt_items(acc);
                }
                tf_search.grabFocus();
                tf_search.selectAll();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);


    }

    private void delete_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_receipt_items_ALM.remove(row);
        tbl_receipt_items_M.fireTableDataChanged();
        tf_search.grabFocus();
        tf_search.selectAll();
    }

    private void edit_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.get(tbl_receipt_items.
                convertRowIndexToModel(row));

        Window p = (Window) this;
        Dlg_qty_cost nd = Dlg_qty_cost.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.qty, to.cost,to.description,to.unit);
        nd.setCallback(new Dlg_qty_cost.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_cost.OutputData data) {
                closeDialog.ok();
                double n_qty = data.amount;
                to.setQty(n_qty);
//                to.setCost(cost);
                tbl_receipt_items_M.fireTableDataChanged();
                tf_search.grabFocus();
                tf_search.selectAll();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void add_receipt() {
        if (tbl_receipt_items_ALM.isEmpty()) {
            Alert.set(0, "NO RECORD");
            return;
        }
        int id = -1;
        String receipt_no = S1_receipts.increment_id();
        String user_name = Users.user_name;
        String session_no = Users.session_no;
        String date_added = DateType.datetime.format(new Date());
        String supplier = cb_supplier.getSelectedItem().
                toString();
        String supllier_id = "0";
        String remarks = tf_remarks.getText();
        String date_delivered = DateType.sf.format(dp_date_delivered.getDate());
        String date_received = DateType.sf.format(dp_date_received.getDate());
//        S1_receipts.to_receipts to1 = new S1_receipts.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received,"");
//
//        S1_receipts.add_receipts(to1);

        List<S1_receipt_orders.to_receipt_items> datas = tbl_receipt_items_ALM;
        List<S1_receipt_items.to_receipt_items> acc = new ArrayList();

        for (S1_receipt_orders.to_receipt_items to3 : datas) {
            String barcode = to3.barcode;
            String description = to3.description;
            double qty = to3.qty;
            double cost = to3.cost;
            String category = to3.category;
            String category_id = to3.category_id;
            String classification = to3.classification;
            String classification_id = to3.classification_id;
            String sub_class = to3.sub_class;
            String sub_class_id = to3.sub_class_id;
            String sup = to3.supplier;
            String sup_id = to3.supllier_id;
//            S1_receipt_items.to_receipt_items to4 = new S1_receipt_items.to_receipt_items(id, receipt_no, user_name, session_no
//                    , date_added, sup, sup_id, remarks, barcode, description, qty, cost, category, category_id, classification
//                    , classification_id, sub_class, sub_class_id, to3.conversion, to3.unit,date_delivered,date_received);
//            acc.add(to4);
        }
        S1_receipt_items.add_receipt_items(acc, receipt_no);
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
        Alert.set(1, remarks);
        data_cols();
        tf_search.grabFocus();
        tf_search.selectAll();
    }
}
