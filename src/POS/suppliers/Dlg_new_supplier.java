/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.suppliers;

import POS.suppliers.S1_suppliers.to_suppliers;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_new_supplier extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_supplier
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
    private Dlg_new_supplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_supplier(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_supplier() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_supplier myRef;

    private void setThisRef(Dlg_new_supplier myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_supplier> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_supplier create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_supplier create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_supplier dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_supplier((java.awt.Frame) parent, false);
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
            Dlg_new_supplier dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_supplier((java.awt.Dialog) parent, false);
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

        Dlg_new_supplier dialog = Dlg_new_supplier.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_suppliers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_supplier = new Field.Input();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_address = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tf_contact_no = new Field.Input();
        jButton3 = new Button.Primary();
        jButton2 = new Button.Info();
        jButton1 = new Button.Warning();
        jTextField3 = new Field.Search();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_suppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_suppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_suppliersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_suppliers);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        tf_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Address:");

        tf_address.setColumns(20);
        tf_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_address.setLineWrap(true);
        tf_address.setRows(5);
        jScrollPane2.setViewportView(tf_address);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Contact:");

        tf_contact_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setText("No. of Suppliers:");

        jLabel5.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_contact_no, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tf_supplier))
                            .addComponent(jScrollPane1))
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
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

    private void tbl_suppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_suppliersMouseClicked
        select_suppliers();
    }//GEN-LAST:event_tbl_suppliersMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_suppliers();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update_suppliers();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_suppliers();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_suppliers;
    private javax.swing.JTextArea tf_address;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_supplier;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_suppliers(tbl_suppliers);
        data_suppliers();
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

    //<editor-fold defaultstate="collapsed" desc=" suppliers "> 
    public static ArrayListModel tbl_suppliers_ALM;
    public static TblsuppliersModel tbl_suppliers_M;

    public static void init_tbl_suppliers(JTable tbl_suppliers) {
        tbl_suppliers_ALM = new ArrayListModel();
        tbl_suppliers_M = new TblsuppliersModel(tbl_suppliers_ALM);
        tbl_suppliers.setModel(tbl_suppliers_M);
        tbl_suppliers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_suppliers.setRowHeight(25);
        int[] tbl_widths_suppliers = {100, 150, 150, 0};
        for (int i = 0, n = tbl_widths_suppliers.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_suppliers, i, tbl_widths_suppliers[i]);
        }
        Dimension d = tbl_suppliers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_suppliers.getTableHeader().setPreferredSize(d);
        tbl_suppliers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_suppliers.setRowHeight(25);
        tbl_suppliers.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_suppliers(List<to_suppliers> acc) {
        tbl_suppliers_ALM.clear();
        tbl_suppliers_ALM.addAll(acc);
    }

    public static class TblsuppliersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Name", "Address", "Contact", "address"
        };

        public TblsuppliersModel(ListModel listmodel) {
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
            to_suppliers tt = (to_suppliers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.supplier;
                case 1:
                    return " " + tt.address;
                case 2:
                    return " " + tt.contact_no;
                default:
                    return tt.address;
            }
        }
    }
//</editor-fold> 

    private void add_suppliers() {

        int id = 0;
        String supplier = tf_supplier.getText();
        String contact_no = tf_contact_no.getText();
        String address = tf_address.getText();

        to_suppliers to = new to_suppliers(id, supplier, contact_no, address);
        S1_suppliers.add_suppliers(to);
        tf_supplier.setText("");
        tf_contact_no.setText("");
        tf_address.setText("");
        tf_supplier.grabFocus();
        data_suppliers();
    }

    private void select_suppliers() {

        int row = tbl_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_suppliers to = (to_suppliers) tbl_suppliers_ALM.get(row);
        tf_supplier.setText(to.supplier);
        tf_contact_no.setText(to.contact_no);
        tf_address.setText(to.address);

    }

    private void update_suppliers() {

        int row = tbl_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_suppliers to = (to_suppliers) tbl_suppliers_ALM.get(row);
        int id = to.id;
        String supplier = tf_supplier.getText();
        String contact_no = tf_contact_no.getText();
        String address = tf_address.getText();

        to_suppliers to1 = new to_suppliers(id, supplier, contact_no, address);
        S1_suppliers.update_data(to1);
        tf_supplier.setText("");
        tf_contact_no.setText("");
        tf_address.setText("");
        tf_supplier.grabFocus();
        data_suppliers();
    }

    private void delete_suppliers() {

        int row = tbl_suppliers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_suppliers to = (to_suppliers) tbl_suppliers_ALM.get(row);
        S1_suppliers.delete_suppliers(to);
        tf_supplier.setText("");
        tf_contact_no.setText("");
        tf_address.setText("");
        tf_supplier.grabFocus();
        data_suppliers();
    }

    private void data_suppliers() {
        String where = " where supplier like '%" + jTextField3.getText() + "%' order by supplier asc";
        List<S1_suppliers.to_suppliers> datas = S1_suppliers.ret_where(where);
        loadData_suppliers(datas);
        jLabel5.setText("" + tbl_suppliers_ALM.size());
    }

}
