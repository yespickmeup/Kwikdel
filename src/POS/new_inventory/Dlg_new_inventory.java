/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.new_inventory;

import POS.receipts.*;
import POS.items.S1_items;
import POS.main.Main;
import POS.receipts.S1_receipt_orders.to_receipt_items;
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

/**
 *
 * @author Maytopacka
 */
public class Dlg_new_inventory extends javax.swing.JDialog {

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
    private Dlg_new_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_inventory() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_inventory myRef;

    private void setThisRef(Dlg_new_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_inventory((java.awt.Frame) parent, false);
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
            Dlg_new_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_inventory((java.awt.Dialog) parent, false);
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

        Dlg_new_inventory dialog = Dlg_new_inventory.create(new javax.swing.JFrame(), true);
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
        jLabel8 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_receipt_items = new org.jdesktop.swingx.JXTable();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Search (F1):");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Select List (F2), Delete List (DEL)");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Clear All (F5)");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Ok (CTRL)");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Items:");

        jLabel2.setText("0");

        jLabel3.setText("0");

        jLabel4.setText("Total Qty:");

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jXPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXTable tbl_items;
    private org.jdesktop.swingx.JXTable tbl_receipt_items;
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
//        dp_date_delivered.setDate(new Date());
//        dp_date_received.setDate(new Date());
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
//        cb_supplier.setModel(new ListComboBoxModel(S1_suppliers.ret_cb_data()));
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
                add_receipt();
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
        int[] tbl_widths_items = {50, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_items.setRowHeight(25);
        tbl_items.setFont(new java.awt.Font("Arial", 0, 11));

    }

    private void loadData_items(List<S1_items.to_items> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "generic_name", "Category", "category_id", "Classification", "classification_id", "Sub-Class", "sub_classification_id", "id", "Unit", "Cost", "Price", "date_added", "user_name", "item_type", "Active"
        };

        public TblitemsModel(ListModel listmodel) {
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
            S1_items.to_items tt = (S1_items.to_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_wc_0(tt.product_qty);
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.description;
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
                    return " " + FitIn.fmt_wc_0(tt.cost);
                case 13:
                    return " " + FitIn.fmt_wc_0(tt.selling_price);
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
        int[] tbl_widths_receipt_items = {70, 70, 0, 0, 0, 0, 0, 0, 80, 100, 0, 0, 0, 0, 0, 0, 0, 0};
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
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_receipt_items.setRowHeight(25);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_receipt_items(List<to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "New Qty", "Prev. Qty", "user_name", "session_no", "date_added", "supplier", "supllier_id", "remarks", "Barcode", "Description", "id", "Cost", "category", "category_id", "classification", "classification_id", "sub_class", "Total"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            to_receipt_items tt = (to_receipt_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_wc_0(tt.qty);
                case 1:
                    return " " + FitIn.fmt_wc_0(tt.cost);
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
                    return " " + tt.barcode;
                case 9:
                    return " " + tt.description;
                case 10:
                    return " " + tt.qty;
                case 11:
                    return " " + FitIn.fmt_wc_0(tt.cost);
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

    private void count() {
        final List<to_receipt_items> datas = tbl_receipt_items_ALM;
        int items = datas.size();
        double qty = 0;
        for (to_receipt_items to : datas) {
            qty += to.qty;
        }
        jLabel2.setText("" + items);
        jLabel3.setText("" + FitIn.fmt_wc_0(qty));
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
        Dlg_qty_new_inventory nd = Dlg_qty_new_inventory.create(p, true);
        nd.setTitle("");
        nd.do_pass2(to.product_qty, 0, to.description, to.unit);
        nd.setCallback(new Dlg_qty_new_inventory.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_new_inventory.OutputData data) {
                closeDialog.ok();
                int id = -1;
                String receipt_no = "0";//S1_re.increment_id();
                String user_name = Users.user_name;
                String session_no = Users.session_no;
                String date_added = DateType.datetime.format(new Date());
                String supplier = to.supplier;
                String supllier_id = "0";
                String remarks = "";
                String barcode = to.barcode;
                String description = to.description;
                double qty = data.new_qty;
                double cost = data.prev_qty;
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
                    if (to3.barcode.equals(to2.barcode) && to3.unit.equals(to2.unit)) {
                        naa = 1;
                        double n_qty = data.new_qty + to3.qty;
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
                count();
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
        count();
    }

    private void edit_items() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.get(tbl_receipt_items.
                convertRowIndexToModel(row));

        Window p = (Window) this;
        Dlg_qty_new_inventory nd = Dlg_qty_new_inventory.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.cost, to.qty, to.description, to.unit);
        nd.setCallback(new Dlg_qty_new_inventory.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_new_inventory.OutputData data) {
                closeDialog.ok();
                double n_qty = data.new_qty;
                to.setQty(n_qty);
//                to.setCost(cost);
                tbl_receipt_items_M.fireTableDataChanged();
                tf_search.grabFocus();
                tf_search.selectAll();
                count();
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

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                int id = 0;
                String user_name = Users.user_name;
                String date_added = DateType.datetime.format(new Date());
                String new_inventory_no = S1_new_inventory.increment_id();
                int status = 0;
                S1_new_inventory.to_new_inventory to = new S1_new_inventory.to_new_inventory(id, user_name, date_added, new_inventory_no, status);
                S1_new_inventory.add_new_inventory(to);
                List<S1_receipt_orders.to_receipt_items> datas = tbl_receipt_items_ALM;
                List< S1_new_inventory_items.to_new_inventory_items> acc = new ArrayList();
                for (S1_receipt_orders.to_receipt_items to3 : datas) {
                    String barcode = to3.barcode;
                    String description = to3.description;
                    double previous_qty = to3.cost;
                    double new_qty = to3.qty;
                    double selling_price = to3.total;
                    String unit = to3.unit;
                    double conversion = to3.conversion;
                    String category = to3.category;
                    String category_id = to3.category_id;
                    String classification = to3.classification;
                    String classification_id = to3.classification_id;
                    String sub_class = to3.sub_class;
                    String sub_class_id = to3.sub_class_id;
                    S1_new_inventory_items.to_new_inventory_items t = new S1_new_inventory_items.to_new_inventory_items(id, user_name, date_added, new_inventory_no, unit, barcode, description, previous_qty, new_qty, selling_price, unit, conversion, category, category_id, classification, classification_id, sub_class, sub_class_id);
                    acc.add(t);
                    count();
                }
                S1_new_inventory_items.add_new_inventory_items(acc);
                tbl_receipt_items_ALM.clear();
                tbl_receipt_items_M.fireTableDataChanged();
                Alert.set(1, "");
                data_cols();
                tf_search.grabFocus();
                tf_search.selectAll();

            }
        });
        t.start();

    }
}
