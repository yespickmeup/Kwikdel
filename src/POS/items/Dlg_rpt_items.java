/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.category.S1_inv_categories;
import POS.category.S1_inv_classifications;
import POS.category.S1_inv_sub_classifications;
import POS.template.*;
import POS.main.Main;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author Maytopacka
 */
public class Dlg_rpt_items extends javax.swing.JDialog {

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
    private Dlg_rpt_items(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_rpt_items(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_rpt_items() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_rpt_items myRef;

    private void setThisRef(Dlg_rpt_items myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_rpt_items> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_rpt_items create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_rpt_items create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_rpt_items dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rpt_items((java.awt.Frame) parent, false);
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
            Dlg_rpt_items dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_rpt_items((java.awt.Dialog) parent, false);
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


        Dlg_rpt_items dialog = Dlg_rpt_items.create(new javax.swing.JFrame(), true);
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
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lbl_net = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_classification = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cb_sub_class = new javax.swing.JComboBox();

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
        jScrollPane2.setViewportView(tbl_items);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(240, 237, 223));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CATEGORY:");

        cb_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cb_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_categoryMouseClicked(evt);
            }
        });
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_net.setBackground(new java.awt.Color(51, 204, 255));
        lbl_net.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_net.setForeground(new java.awt.Color(255, 255, 255));
        lbl_net.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_net.setText("0.00");
        lbl_net.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CLASSIFICATION:");

        cb_classification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_classification.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cb_classification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_classificationMouseClicked(evt);
            }
        });
        cb_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_classificationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("SUB CLASS:");

        cb_sub_class.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_sub_class.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cb_sub_class.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_sub_classMouseClicked(evt);
            }
        });
        cb_sub_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sub_classActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_sub_class, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_net, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_classification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_sub_class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void cb_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_categoryMouseClicked
//        data_cols();
    }//GEN-LAST:event_cb_categoryMouseClicked

    private void cb_classificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_classificationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_classificationMouseClicked

    private void cb_sub_classMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_sub_classMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sub_classMouseClicked

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        init_classification();
        data_cols();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void cb_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_classificationActionPerformed
        // TODO add your handling code here:
        init_sub_class();
        data_cols();
    }//GEN-LAST:event_cb_classificationActionPerformed

    private void cb_sub_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sub_classActionPerformed
        data_cols();
    }//GEN-LAST:event_cb_sub_classActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_category;
    private javax.swing.JComboBox cb_classification;
    private javax.swing.JComboBox cb_sub_class;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JLabel lbl_net;
    private org.jdesktop.swingx.JXTable tbl_items;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");

        init_key();
        init_cb();

        init_tbl_items();
//        data_cols();
    }

    public void do_pass() {
    }

    private void init_cb() {
        cb_category.setModel(new ListComboBoxModel(S1_inv_categories.ret_cb_data()));
        init_classification();
    }

    private void init_classification() {

        String category = cb_category.getSelectedItem().
                toString();
        if (category == null) {
            cb_classification.setSelectedIndex(0);
        } else {
            cb_classification.setModel(new ListComboBoxModel(S1_inv_classifications.
                    ret_cb_data(category)));
            init_sub_class();
        }


    }

    private void init_sub_class() {
        String classification = cb_classification.getSelectedItem().
                toString();
        if (classification == null) {
            cb_sub_class.setSelectedIndex(0);
        } else {
            cb_sub_class.setModel(new ListComboBoxModel(S1_inv_sub_classifications.
                    ret_cb_data(classification)));
        }
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
        int[] tbl_widths_items = {50, 0, 100, 0, 110, 0, 110, 0, 110, 0, 0, 100, 0, 100, 0, 0, 0, 60};
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
                setFont(new java.awt.Font("Arial", 0, 12));
        tbl_items.setRowHeight(35);
        tbl_items.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_items(List<S1_items.to_items> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "barcode", "DESCRIPTION", "generic_name", "CATEGORY", "category_id", "CLASSIFICATION", "classification_id", "SUB-CLASS", "sub_classification_id", "id", "UNIT", "conversion", "SELL. PRICE", "date_added", "user_name", "item_type", "ACTIVE"
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
                    return FitIn.fmt_woc(tt.product_qty);
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
                    return tt.conversion;
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
        String category = cb_category.getSelectedItem().
                toString();
        String classification = cb_classification.getSelectedItem().
                toString();
        String sub_class = cb_sub_class.getSelectedItem().
                toString();
        loadData_items(S1_items.ret_data2(category, classification, sub_class));
        
        List<S1_items.to_items> datas=tbl_items_ALM;
        double total=0;
        for(S1_items.to_items to:datas){
            total+=to.product_qty* to.selling_price;
        }
        lbl_net.setText(FitIn.fmt_wc_0(total));
    }
}
