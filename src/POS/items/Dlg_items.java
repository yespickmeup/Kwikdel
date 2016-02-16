/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.category.S1_inv_categories;
import POS.category.S1_inv_classifications;
import POS.category.S1_inv_sub_classifications;
import POS.items.S1_item_multi_level_pricing.to_item_multi_level_pricing;
import POS.items.S1_items.to_items;
import POS.locations.S1_locations;
import static POS.locations.S1_locations.get_default_location;
import POS.main.Main;
import POS.receipts.Dlg_item_receipts;
import POS.suppliers.S1_suppliers;
import POS.uom.S1_uom;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author Maytopacka
 */
public class Dlg_items extends javax.swing.JDialog {

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
    private Dlg_items(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_items(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_items() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_items myRef;

    private void setThisRef(Dlg_items myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_items> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_items create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_items create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_items dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_items((java.awt.Frame) parent, false);
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
            Dlg_items dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_items((java.awt.Dialog) parent, false);
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

        Dlg_items dialog = Dlg_items.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
//        dialog.setVisible(true);
        dialog.setSize(xSize, ySize);
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
        view_receipts = new javax.swing.JMenuItem();
        view_sales = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_items = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        tf_search = new javax.swing.JTextField();
        btn_new = new org.jdesktop.swingx.JXLabel();
        btn_edit = new org.jdesktop.swingx.JXLabel();
        btn_delete = new org.jdesktop.swingx.JXLabel();
        btn_add = new org.jdesktop.swingx.JXLabel();
        jLabel12 = new javax.swing.JLabel();
        cb_category2 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cb_supplier2 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cb_classification = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cb_sub_class = new javax.swing.JComboBox();
        tf_product_qty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_unit = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        tf_conversion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_selling_price = new javax.swing.JTextField();
        cb_active = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb_supplier = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        cb_fixed_price = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        tf_cost = new javax.swing.JTextField();
        cb_multi_pricing = new javax.swing.JCheckBox();
        pnl_multi_level = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_item_multi_level_pricing = new javax.swing.JTable();
        cb_multi_unit = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_multi_conversion = new javax.swing.JTextField();
        tf_multi_price = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btn_new1 = new org.jdesktop.swingx.JXLabel();
        btn_add1 = new org.jdesktop.swingx.JXLabel();
        btn_edit1 = new org.jdesktop.swingx.JXLabel();
        btn_delete1 = new org.jdesktop.swingx.JXLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_multi_desc = new javax.swing.JTextField();
        cb_vatable = new javax.swing.JCheckBox();
        tf_reorder_level = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        view_receipts.setBackground(new java.awt.Color(51, 153, 255));
        view_receipts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        view_receipts.setForeground(new java.awt.Color(255, 255, 255));
        view_receipts.setText("VIEW RECEIPTS");
        view_receipts.setOpaque(true);
        view_receipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_receiptsActionPerformed(evt);
            }
        });
        jPopupMenu1.add(view_receipts);

        view_sales.setBackground(new java.awt.Color(51, 153, 255));
        view_sales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        view_sales.setForeground(new java.awt.Color(255, 255, 255));
        view_sales.setText("VIEW SALES");
        view_sales.setOpaque(true);
        view_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_salesActionPerformed(evt);
            }
        });
        jPopupMenu1.add(view_sales);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setOpaque(false);

        jXPanel3.setBackground(new java.awt.Color(51, 153, 255));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_itemsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseReleased(evt);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel1.setBackground(new java.awt.Color(51, 153, 255));

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SEARCH:");

        cb_category2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_category2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category2.setFocusable(false);
        cb_category2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_category2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("CATEGORY:");

        cb_supplier2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_supplier2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_supplier2.setFocusable(false);
        cb_supplier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_supplier2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("SUPPLIER:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_category2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_supplier2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search)
                        .addComponent(jLabel12)
                        .addComponent(cb_category2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_supplier2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(240, 237, 223));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("BARCODE:");

        tf_barcode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_barcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DESCRIPTION:");

        tf_description.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_description.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CATEGORY:");

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CLASSIFICATION:");

        cb_classification.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_classification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_classification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_classificationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("SUB - CLASS:");

        cb_sub_class.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_sub_class.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_sub_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sub_classActionPerformed(evt);
            }
        });

        tf_product_qty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_product_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_product_qty.setText("0");
        tf_product_qty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PRODUCT QUANTITY");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("UNIT:");

        cb_unit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CONVERSION:");

        tf_conversion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_conversion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_conversion.setText("1");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("SELLING PRICE:");

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_selling_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_selling_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_selling_priceActionPerformed(evt);
            }
        });

        cb_active.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_active.setSelected(true);
        cb_active.setText("ACTIVE/INACTIVE");
        cb_active.setFocusable(false);
        cb_active.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/s_reload.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/s_reload.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("SUPPLIER:");

        cb_supplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_supplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_supplier.setFocusable(false);
        cb_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_supplierActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/s_reload.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cb_fixed_price.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_fixed_price.setSelected(true);
        cb_fixed_price.setText("FIX PRICE");
        cb_fixed_price.setFocusable(false);
        cb_fixed_price.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("COST:");

        tf_cost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_cost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

        cb_multi_pricing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_multi_pricing.setText("MULTI LEVEL PRICING");
        cb_multi_pricing.setFocusable(false);
        cb_multi_pricing.setOpaque(false);
        cb_multi_pricing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_multi_pricingActionPerformed(evt);
            }
        });

        pnl_multi_level.setBackground(new java.awt.Color(255, 204, 255));

        tbl_item_multi_level_pricing.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_item_multi_level_pricing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_item_multi_level_pricingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_item_multi_level_pricing);

        cb_multi_unit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_multi_unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("UNIT:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("CONVERSION:");

        tf_multi_conversion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_multi_conversion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_multi_conversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_multi_conversionActionPerformed(evt);
            }
        });

        tf_multi_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_multi_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_multi_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_multi_priceActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("PRICE:");

        btn_new1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_reload.png"))); // NOI18N
        btn_new1.setText("NEW");
        btn_new1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_new1MouseClicked(evt);
            }
        });

        btn_add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new.png"))); // NOI18N
        btn_add1.setText("ADD");
        btn_add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add1MouseClicked(evt);
            }
        });

        btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_edit.png"))); // NOI18N
        btn_edit1.setText("EDIT");
        btn_edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit1MouseClicked(evt);
            }
        });

        btn_delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_drop.png"))); // NOI18N
        btn_delete1.setText("DELETE");
        btn_delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete1MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("DESCRIPTION:");

        tf_multi_desc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_multi_desc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_multi_desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_multi_descActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_multi_levelLayout = new javax.swing.GroupLayout(pnl_multi_level);
        pnl_multi_level.setLayout(pnl_multi_levelLayout);
        pnl_multi_levelLayout.setHorizontalGroup(
            pnl_multi_levelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnl_multi_levelLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_multi_desc, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_multi_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_multi_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_multi_price, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_new1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_multi_levelLayout.setVerticalGroup(
            pnl_multi_levelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_multi_levelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_multi_levelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_multi_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_multi_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_multi_levelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_multi_unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_multi_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_new1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_multi_levelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        cb_vatable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_vatable.setSelected(true);
        cb_vatable.setText("VATABLE");
        cb_vatable.setFocusable(false);
        cb_vatable.setOpaque(false);
        cb_vatable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vatableActionPerformed(evt);
            }
        });

        tf_reorder_level.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_reorder_level.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_reorder_level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reorder_levelActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("REORDER LEVEL:");

        jButton4.setText("INACTIVE ALL ITEMS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_supplier, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_sub_class, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_selling_price)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cost)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_unit, 0, 197, Short.MAX_VALUE)
                                    .addComponent(cb_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_conversion)
                                    .addComponent(cb_classification, 0, 153, Short.MAX_VALUE))
                                .addGap(59, 59, 59))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(cb_fixed_price, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_multi_pricing, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_vatable, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jXPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_active, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_reorder_level, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_description, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(tf_product_qty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(pnl_multi_level, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_reorder_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_active))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_description)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tf_product_qty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_classification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_conversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_sub_class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_fixed_price)
                        .addComponent(cb_multi_pricing))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_vatable)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(pnl_multi_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
//        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        delete_items();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newMouseClicked
        clear_items();
    }//GEN-LAST:event_btn_newMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        edit_items();
    }//GEN-LAST:event_btn_editMouseClicked

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        select_items();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        add_items();
    }//GEN-LAST:event_btn_addMouseClicked

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void cb_classificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_classificationActionPerformed
    }//GEN-LAST:event_cb_classificationActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        init_cb();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_selling_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_selling_priceActionPerformed
        add_items();
    }//GEN-LAST:event_tf_selling_priceActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        uom();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        init_supplier();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_sub_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sub_classActionPerformed
    }//GEN-LAST:event_cb_sub_classActionPerformed

    private void cb_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_supplierActionPerformed
        // TODO add your handling code here:
//        data_cols();
    }//GEN-LAST:event_cb_supplierActionPerformed

    private void cb_category2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_category2ActionPerformed
        // TODO add your handling code here:
//         data_cols();
    }//GEN-LAST:event_cb_category2ActionPerformed

    private void cb_supplier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_supplier2ActionPerformed
        // TODO add your handling code here:
//         data_cols();
    }//GEN-LAST:event_cb_supplier2ActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_costActionPerformed

    private void view_receiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_receiptsActionPerformed
//        items();
        view_receipts();
    }//GEN-LAST:event_view_receiptsActionPerformed

    private void view_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_salesActionPerformed
//        items();
    }//GEN-LAST:event_view_salesActionPerformed

    private void tbl_itemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_itemsMousePressed

    private void tbl_itemsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_itemsMouseReleased

    private void tf_multi_conversionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_multi_conversionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_multi_conversionActionPerformed

    private void tf_multi_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_multi_priceActionPerformed
        // TODO add your handling code here:
        add_item_multi_level_pricing();
    }//GEN-LAST:event_tf_multi_priceActionPerformed

    private void btn_new1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_new1MouseClicked

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
        add_item_multi_level_pricing();
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_edit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseClicked
        // TODO add your handling code here:
        edit_item_multi_level_pricing();
    }//GEN-LAST:event_btn_edit1MouseClicked

    private void btn_delete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseClicked
        // TODO add your handling code here:
        delete_item_multi_level_pricing();
    }//GEN-LAST:event_btn_delete1MouseClicked

    private void cb_multi_pricingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_multi_pricingActionPerformed
        set_multi();
    }//GEN-LAST:event_cb_multi_pricingActionPerformed

    private void tf_multi_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_multi_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_multi_descActionPerformed

    private void tbl_itemsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_itemsMouseEntered

    private void tbl_item_multi_level_pricingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_item_multi_level_pricingMouseClicked
        select_item_multi_level_pricing();
    }//GEN-LAST:event_tbl_item_multi_level_pricingMouseClicked

    private void cb_vatableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vatableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_vatableActionPerformed

    private void tf_reorder_levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reorder_levelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_reorder_levelActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        inactive_all();
    }//GEN-LAST:event_jButton4ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel btn_add;
    private org.jdesktop.swingx.JXLabel btn_add1;
    private org.jdesktop.swingx.JXLabel btn_delete;
    private org.jdesktop.swingx.JXLabel btn_delete1;
    private org.jdesktop.swingx.JXLabel btn_edit;
    private org.jdesktop.swingx.JXLabel btn_edit1;
    private org.jdesktop.swingx.JXLabel btn_new;
    private org.jdesktop.swingx.JXLabel btn_new1;
    private javax.swing.JCheckBox cb_active;
    private javax.swing.JComboBox cb_category;
    private javax.swing.JComboBox cb_category2;
    private javax.swing.JComboBox cb_classification;
    private javax.swing.JCheckBox cb_fixed_price;
    private javax.swing.JCheckBox cb_multi_pricing;
    private javax.swing.JComboBox cb_multi_unit;
    private javax.swing.JComboBox cb_sub_class;
    private javax.swing.JComboBox cb_supplier;
    private javax.swing.JComboBox cb_supplier2;
    private javax.swing.JComboBox cb_unit;
    private javax.swing.JCheckBox cb_vatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JPanel pnl_multi_level;
    private javax.swing.JTable tbl_item_multi_level_pricing;
    private org.jdesktop.swingx.JXTable tbl_items;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_conversion;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_multi_conversion;
    private javax.swing.JTextField tf_multi_desc;
    private javax.swing.JTextField tf_multi_price;
    private javax.swing.JLabel tf_product_qty;
    private javax.swing.JTextField tf_reorder_level;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_selling_price;
    private javax.swing.JMenuItem view_receipts;
    private javax.swing.JMenuItem view_sales;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        tf_search.grabFocus();
        init_key();
        focus();
        hover();
        search();
        init();
        init_cb();
        init_supplier();
        init_tbl_items();
        init_tbl_item_multi_level_pricing();
        data_cols();
        uom();
        set_barcode();
        tf_barcode.grabFocus();
        tf_barcode.selectAll();
        pnl_multi_level.setVisible(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);

    }

    private void focus() {
        JTextField[] tf = {tf_barcode, tf_description, tf_selling_price, tf_cost, tf_conversion, tf_multi_desc, tf_multi_conversion, tf_multi_price, tf_search};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    private void set_multi() {
        if (cb_multi_pricing.isSelected()) {
            pnl_multi_level.setVisible(true);

        } else {
            pnl_multi_level.setVisible(false);

        }
    }

    private void init_supplier() {
        cb_supplier.setModel(new ListComboBoxModel(S1_suppliers.ret_cb_data()));
        cb_supplier2.setModel(new ListComboBoxModel(S1_suppliers.ret_cb_data()));
    }

    private void set_barcode() {
        tf_barcode.setText(S1_barcodes.increment_id());
    }

    private void uom() {
        cb_unit.setModel(new ListComboBoxModel(S1_uom.ret_cb_data()));
        cb_multi_unit.setModel(new ListComboBoxModel(S1_uom.ret_cb_data()));
    }

    private void init_cb() {
        cb_category.setModel(new ListComboBoxModel(S1_inv_categories.ret_cb_data()));
        init_classification();
        cb_category2.setModel(new ListComboBoxModel(S1_inv_categories.
                ret_cb_data()));
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
        btn_edit1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_edit.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().
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
        btn_delete1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_delete1.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_drop.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_delete1.setIcon(new javax.swing.ImageIcon(getClass().
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
        btn_add1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_add1.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_snewtbl.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_add1.setIcon(new javax.swing.ImageIcon(getClass().
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
        btn_new1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_new1.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/s_reload.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_new1.setIcon(new javax.swing.ImageIcon(getClass().
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
        cb_category.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                init_classification();
//                data_cols();
            }
        });
        cb_classification.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                init_sub_class();
//                data_cols();
            }
        });
        cb_sub_class.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                data_cols();
            }
        });

        cb_supplier.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                init_classification();
//                data_cols();
            }
        });

        cb_unit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                init_classification();
//                data_cols();
            }
        });
        cb_category2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                data_cols();
            }
        });
        cb_supplier2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                data_cols();
            }
        });

//        SearchField sf = (SearchField) tf_search;
//        sf.setFont(new java.awt.Font("Tahoma", 1, 12));
//        sf.set_instruction1("Type To Search");
//        sf.set_searcher(new SearchField.ISearcher() {
//
//            @Override
//            public List get_entered(String starts_with) {
//                // your search list here coming from svc for example.                
//                return new ArrayList();
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
//                btn_0.doClick();
                disposed();
            }
        });
        tf_search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbl_items_ALM.size() == 1) {
                    tbl_items.setRowSelectionInterval(0, 0);
                    select_items();
//                        e.consume();
                    tf_search.selectAll();
                    tf_search.grabFocus();
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
            }
        });

        tbl_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!tbl_items_ALM.isEmpty()) {
                        select_items();
                        e.consume();
                    }
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
        int[] tbl_widths_items = {50, 100, 100, 0, 110, 0, 0, 0, 100, 0, 0, 100, 0, 100, 0, 0, 60, 60, 60, 60};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_items.setRowHeight(25);
        tbl_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_items(List<to_items> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "generic_name", "Category", "category_id", "Classification", "classification_id", "Supplier", "sub_classification_id", "Supplier", "Cost", "Supplier", "Price", "date_added", "user_name", "Vat", "Active", "Multi", "Fix Price"
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
            to_items tt = (to_items) getRow(row);
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
                    return tt.supplier;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.supplier;
                case 11:
                    return FitIn.fmt_wc_0(tt.cost);
                case 12:
                    return tt.conversion;
                case 13:
                    return FitIn.fmt_wc_0(tt.selling_price);
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    if (tt.vatable == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }
                case 17:
                    if (tt.status == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }
                case 18:

                    if (tt.multi_level_pricing == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }
                default:
                    if (tt.fixed_price == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }

            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        String category = cb_category2.getSelectedItem().
                toString();
        if (cb_category2.getSelectedIndex() == 0) {
            category = "";
        }
        System.out.println(" asdad" + category);
        String classification = cb_classification.getSelectedItem().
                toString();
        String sub_class = cb_sub_class.getSelectedItem().
                toString();
        String supplier = cb_supplier2.getSelectedItem().
                toString();
        if (cb_supplier2.getSelectedIndex() == 0) {
            supplier = "";
        }
        loadData_items(S1_items.ret_data(search, category, classification, sub_class, supplier));
    }

    private void add_items() {
        int id = -1;
        String barcode = tf_barcode.getText();
        String description = tf_description.getText();
        String generic_name = " ";//tf_generic_name.getText();
        String category = cb_category.getSelectedItem().
                toString();
        String category_id = "0";
        String classification = cb_classification.getSelectedItem().
                toString();
        String classification_id = "0";
        String sub_classification = cb_sub_class.getSelectedItem().
                toString();
        String sub_classification_id = "0";
        double product_qty = 0;
        String unit = cb_unit.getSelectedItem().
                toString();
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.datetime.format(new Date());

        String user_name = Users.user_name;
        String item_type = "";
        int status = 0;

        if (cb_active.isSelected()) {
            status = 1;
        }
        String supplier = cb_supplier.getSelectedItem().
                toString();
        int fixed_price = 0;
        if (cb_fixed_price.isSelected()) {
            fixed_price = 1;
        }
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "0";
        int multi_level_pricing = 0;
        if (cb_multi_pricing.isSelected()) {
            multi_level_pricing = 1;
        }
        int vatable = 0;
        if (cb_vatable.isSelected()) {
            vatable = 1;
        }
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        S1_locations.to_locations def_location = get_default_location();
        String location_name = def_location.name;
        String location_id = "" + def_location.id;
        to_items to = new to_items(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                   sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, new ArrayList(), vatable, reorder_level, location_name, location_id);

        S1_items.add_items(to);
        if (cb_multi_pricing.isSelected()) {
            S1_item_multi_level_pricing.add_item_multi_level_pricing(tbl_item_multi_level_pricing_ALM);
            data_cols_multi();
        }
        if (barcode.length() > 2) {
            String aw = barcode.substring(0, 2);
            if (aw.equalsIgnoreCase("CM")) {
                S1_barcodes.to_barcodes to2 = new S1_barcodes.to_barcodes(-1, barcode);
                S1_barcodes.add_barcodes(to2);
            }
        }
        data_cols();
        clear_items();
        btn_edit.setEnabled(true);
        btn_delete.setEnabled(true);
        Alert.set(1, "");
    }

    private void select_items() {
        int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_items.getSelectedColumn();
        if (col == 17) {
            activate();
        } else {
            to_items to = (to_items) tbl_items_ALM.get(tbl_items.
                    convertRowIndexToModel(row));
            code = to.barcode;
            tf_barcode.setText(to.barcode);
            tf_description.setText(to.description);
            cb_category.setSelectedItem(to.category);
            cb_classification.setSelectedItem(to.classification);
            cb_sub_class.setSelectedItem(to.sub_classification);
            tf_product_qty.setText(FitIn.fmt_woc(to.product_qty));
            cb_unit.setSelectedItem(to.unit);
            cb_supplier.setSelectedItem(to.supplier);
            tf_conversion.setText(FitIn.fmt_woc(to.conversion));
            tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
            tf_cost.setText(FitIn.fmt_wc_0(to.cost));
            if (to.status == 0) {
                cb_active.setSelected(false);
            } else {
                cb_active.setSelected(true);
            }
            tf_barcode.grabFocus();
            tf_barcode.selectAll();
            if (to.fixed_price == 0) {
                cb_fixed_price.setSelected(false);
            } else {
                cb_fixed_price.setSelected(true);
            }

            if (to.multi_level_pricing == 0) {
                cb_multi_pricing.setSelected(false);
                pnl_multi_level.setVisible(false);
            } else {
                cb_multi_pricing.setSelected(true);
                pnl_multi_level.setVisible(true);
                data_cols_multi();
            }
            if (to.vatable == 0) {
                cb_vatable.setSelected(false);
            } else {
                cb_vatable.setSelected(true);
            }

            tf_reorder_level.setText(FitIn.fmt_woc(to.reorder_level));
            btn_edit.setEnabled(true);
            btn_delete.setEnabled(true);
        }

    }
    String code = "";

    private void edit_items() {
//        int row = tbl_items.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
//        to_items to = (to_items) tbl_items_ALM.get(tbl_items.
//                convertRowIndexToModel(row));
        int id = -1;
        String barcode = tf_barcode.getText();
        String description = tf_description.getText();
        String generic_name = " ";//tf_generic_name.getText();
        String category = cb_category.getSelectedItem().
                toString();
        String category_id = "0";
        String classification = cb_classification.getSelectedItem().
                toString();
        String classification_id = "0";
        String sub_classification = cb_sub_class.getSelectedItem().
                toString();
        String sub_classification_id = "0";
        double product_qty = 0;
        String unit = cb_unit.getSelectedItem().
                toString();
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        String date_added = DateType.datetime.format(new Date());

        String user_name = Users.user_name;
        String item_type = "";
        int status = 0;
        if (cb_active.isSelected()) {
            status = 1;
        }
        String supplier = cb_supplier.getSelectedItem().
                toString();
        int fixed_price = 0;
        if (cb_fixed_price.isSelected()) {
            fixed_price = 1;
        }
        double cost = FitIn.toDouble(tf_cost.getText());
        String supplier_id = "0";
        int multi_level_pricing = 0;
        if (cb_multi_pricing.isSelected()) {
            multi_level_pricing = 1;
        }
        int vatable = 0;
        if (cb_vatable.isSelected()) {
            vatable = 1;
        }
        double reorder_level = FitIn.toDouble(tf_reorder_level.getText());
        S1_locations.to_locations def_location = get_default_location();
        String location_name = def_location.name;
        String location_id = "" + def_location.id;
        to_items to1 = new to_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, new ArrayList(), vatable, reorder_level, location_name, location_id);
        S1_items.edit_items(to1, code);
        data_cols();
        clear_items();
        btn_edit.setEnabled(true);
        btn_delete.setEnabled(true);
        Alert.set(2, "");
    }

    private void clear_items() {
        tf_barcode.setText("");
        tf_description.setText("");
        tf_product_qty.setText("0");
//        tf_conversion.setText("");
        tf_selling_price.setText("");
        tf_cost.setText("");
        set_barcode();
        tf_barcode.grabFocus();
        tf_barcode.selectAll();
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        tbl_item_multi_level_pricing_ALM.clear();
        tbl_item_multi_level_pricing_M.fireTableDataChanged();
        pnl_multi_level.setVisible(false);
        cb_multi_pricing.setSelected(false);
    }

    private void delete_items() {
        String barcode = tf_barcode.getText();
        S1_items.delete_items(barcode);
        data_cols();
        clear_items();
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        Alert.set(2, "");
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void view_receipts() {
        Window p = (Window) this;
        Dlg_item_receipts nd = Dlg_item_receipts.create(p, true);
        nd.setTitle("");
        String description = tf_description.getText();
        nd.do_pass(code, description);
        nd.setCallback(new Dlg_item_receipts.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_receipts.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
    private ArrayListModel tbl_item_multi_level_pricing_ALM;
    private Tblitem_multi_level_pricingModel tbl_item_multi_level_pricing_M;

    private void init_tbl_item_multi_level_pricing() {
        tbl_item_multi_level_pricing_ALM = new ArrayListModel();
        tbl_item_multi_level_pricing_M = new Tblitem_multi_level_pricingModel(tbl_item_multi_level_pricing_ALM);
        tbl_item_multi_level_pricing.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_item_multi_level_pricing.setModel(tbl_item_multi_level_pricing_M);
        tbl_item_multi_level_pricing.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_item_multi_level_pricing.setRowHeight(25);
        int[] tbl_widths_item_multi_level_pricing = {0, 0, 100, 100, 100, 100};
        for (int i = 0, n = tbl_widths_item_multi_level_pricing.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_item_multi_level_pricing, i, tbl_widths_item_multi_level_pricing[i]);
        }
        Dimension d = tbl_item_multi_level_pricing.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_item_multi_level_pricing.getTableHeader().
                setPreferredSize(d);
        tbl_item_multi_level_pricing.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_item_multi_level_pricing.setRowHeight(35);
        tbl_item_multi_level_pricing.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_item_multi_level_pricing(List<to_item_multi_level_pricing> acc) {
        tbl_item_multi_level_pricing_ALM.clear();
        tbl_item_multi_level_pricing_ALM.addAll(acc);
    }

    public static class Tblitem_multi_level_pricingModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "barcode", "DESCRIPTION", "UNIT", "CONVERSION", "PRICE"
        };

        public Tblitem_multi_level_pricingModel(ListModel listmodel) {
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
            to_item_multi_level_pricing tt = (to_item_multi_level_pricing) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return tt.conversion;
                default:
                    return tt.price;
            }
        }
    }

    private void data_cols_multi() {
        String search = tf_barcode.getText();
        loadData_item_multi_level_pricing(S1_item_multi_level_pricing.ret_data(search));
    }

    private void add_item_multi_level_pricing() {

        int id = -1;
        String barcode = tf_barcode.getText();
        String description = tf_multi_desc.getText();
        String unit = cb_multi_unit.getSelectedItem().
                toString();
        double conversion = FitIn.toDouble(tf_multi_conversion.getText());
        double price = FitIn.toDouble(tf_multi_price.getText());
        to_item_multi_level_pricing to = new to_item_multi_level_pricing(id, barcode, description, unit, conversion, price);

        if (btn_edit.isEnabled()) {
            List<to_item_multi_level_pricing> datas = new ArrayList();
            datas.add(to);
            S1_item_multi_level_pricing.add_item_multi_level_pricing(datas);
            data_cols_multi();
        } else {
            tbl_item_multi_level_pricing_ALM.add(to);
            tbl_item_multi_level_pricing_M.fireTableDataChanged();
        }

        clear_item_multi_level_pricing();
        Alert.set(1, code);
    }

    private void select_item_multi_level_pricing() {
        int row = tbl_item_multi_level_pricing.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_multi_level_pricing to = (to_item_multi_level_pricing) tbl_item_multi_level_pricing_ALM.
                get(tbl_item_multi_level_pricing.convertRowIndexToModel(row));
//        tf_barcode.setText(to.barcode);
        tf_multi_desc.setText(to.description);
        tf_multi_conversion.setText(FitIn.fmt_wc_0(to.conversion));
        tf_multi_price.setText(FitIn.fmt_wc_0(to.price));
        cb_multi_unit.setSelectedItem(to.unit);
    }

    private void edit_item_multi_level_pricing() {
        int row = tbl_item_multi_level_pricing.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_multi_level_pricing to = (to_item_multi_level_pricing) tbl_item_multi_level_pricing_ALM.
                get(tbl_item_multi_level_pricing.convertRowIndexToModel(row));
        int id = to.id;
        String barcode = tf_barcode.getText();
        String description = tf_multi_desc.getText();
        String unit = cb_multi_unit.getSelectedItem().
                toString();
        double conversion = FitIn.toDouble(tf_multi_conversion.getText());
        double price = FitIn.toDouble(tf_multi_price.getText());
        to_item_multi_level_pricing to1 = new to_item_multi_level_pricing(id, barcode, description, unit, conversion, price);
        if (btn_edit.isEnabled()) {
            S1_item_multi_level_pricing.edit_item_multi_level_pricing(to1);
            data_cols_multi();
        } else {
            to.setDescription(description);
            to.setUnit(unit);
            to.setConversion(conversion);
            to.setPrice(price);
            tbl_item_multi_level_pricing_M.fireTableDataChanged();
        }

        clear_item_multi_level_pricing();
        Alert.set(2, code);
    }

    private void clear_item_multi_level_pricing() {
//        tf_barcode.setText("");
        tf_multi_desc.setText("");
        tf_multi_conversion.setText("");
        tf_multi_price.setText("");
    }

    private void delete_item_multi_level_pricing() {
        int row = tbl_item_multi_level_pricing.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_multi_level_pricing to = (to_item_multi_level_pricing) tbl_item_multi_level_pricing_ALM.
                get(tbl_item_multi_level_pricing.convertRowIndexToModel(row));
        if (btn_edit.isEnabled()) {
            S1_item_multi_level_pricing.delete_item_multi_level_pricing(to);
            data_cols_multi();
        } else {
            tbl_item_multi_level_pricing_ALM.remove(row);
            tbl_item_multi_level_pricing_M.fireTableDataChanged();
        }

        clear_item_multi_level_pricing();
        Alert.set(3, code);
    }

    private void inactive_all() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                S3_items.inactive();
                data_cols();
                Alert.set(0, "All Items are Inactive");

            }
        });
        t.start();
    }

    private void activate() {
        int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_items.getSelectedColumn();

        final to_items to = (to_items) tbl_items_ALM.get(tbl_items.convertRowIndexToModel(row));

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                int active = 0;
                if (to.status == 0) {
                    active = 1;
                }
                S3_items.active("" + to.id, active);
                data_cols();
            }
        });
        t.start();

    }
}
