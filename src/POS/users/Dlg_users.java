/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.innosoft.Users;
import POS.main.Main;
import POS.users.S1_users.to_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm_action;
import POS.util.MyConnectionInnosoft;
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
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.SearchField;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;

/**
 *
 * @author Maytopacka
 */
public class Dlg_users extends javax.swing.JDialog {

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
    private Dlg_users(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_users(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_users() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_users myRef;

    private void setThisRef(Dlg_users myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_users> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_users create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_users create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_users dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_users((java.awt.Frame) parent, false);
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
            Dlg_users dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_users((java.awt.Dialog) parent, false);
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

        Dlg_users dialog = Dlg_users.create(new javax.swing.JFrame(), true);
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
        tbl_users = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        tf_search = new SearchField();
        btn_new = new org.jdesktop.swingx.JXLabel();
        btn_edit = new org.jdesktop.swingx.JXLabel();
        btn_delete = new org.jdesktop.swingx.JXLabel();
        btn_add = new org.jdesktop.swingx.JXLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_screen_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_lvl = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tf_user_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_active = new javax.swing.JCheckBox();
        tf_password = new javax.swing.JPasswordField();
        jButton5 = new Button.Default();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cb_t_sales = new javax.swing.JCheckBox();
        cb_t_receipts = new javax.swing.JCheckBox();
        cb_t_stock_transfer = new javax.swing.JCheckBox();
        cb_t_inventory_adjuster = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        cb_m_items = new javax.swing.JCheckBox();
        cb_m_category = new javax.swing.JCheckBox();
        cb_m_users = new javax.swing.JCheckBox();
        cb_m_uom = new javax.swing.JCheckBox();
        cb_m_suppliers = new javax.swing.JCheckBox();
        cb_m_customers = new javax.swing.JCheckBox();
        cb_m_discount = new javax.swing.JCheckBox();
        cb_m_banks = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        cb_r_sales = new javax.swing.JCheckBox();
        cb_r_cash_count = new javax.swing.JCheckBox();
        cb_r_receipts = new javax.swing.JCheckBox();
        cb_r_stock_transferred = new javax.swing.JCheckBox();
        cb_r_stock_take = new javax.swing.JCheckBox();
        cb_r_stock_left_supplier = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel1.setOpaque(false);

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setOpaque(false);

        tbl_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_users.setOpaque(false);
        tbl_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_users);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(tf_search)
                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SCREEN NAME:");

        tf_screen_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_screen_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("USER LEVEL:");

        cb_lvl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_lvl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CASHIER", "ADMINISTRATOR" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("USER NAME:");

        tf_user_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_user_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("PASSWORD:");

        cb_active.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_active.setSelected(true);
        cb_active.setText("ACTIVE/INACTIVE");
        cb_active.setOpaque(false);

        tf_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton5.setText("Update Innosoft Database!");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cb_active, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_screen_name)
                                    .addComponent(tf_password)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_lvl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_user_name)))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_screen_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_lvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_active)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PREVILEGES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRANSACTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cb_t_sales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_sales.setSelected(true);
        cb_t_sales.setText("SALES");
        cb_t_sales.setOpaque(false);

        cb_t_receipts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_receipts.setText("RECEIPTS");
        cb_t_receipts.setOpaque(false);

        cb_t_stock_transfer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_stock_transfer.setText("STOCK TRANSFER");
        cb_t_stock_transfer.setOpaque(false);

        cb_t_inventory_adjuster.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_t_inventory_adjuster.setText("INVENTORY ADJUSTER");
        cb_t_inventory_adjuster.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_t_receipts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_stock_transfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_t_inventory_adjuster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_t_sales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_t_receipts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_t_stock_transfer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_t_inventory_adjuster)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MAINTENANCE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cb_m_items.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_items.setText("ITEMS");
        cb_m_items.setOpaque(false);

        cb_m_category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_category.setText("CATEGORY");
        cb_m_category.setOpaque(false);

        cb_m_users.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_users.setText("USERS");
        cb_m_users.setOpaque(false);

        cb_m_uom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_uom.setText("UOM");
        cb_m_uom.setOpaque(false);

        cb_m_suppliers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_suppliers.setText("SUPPLIERS");
        cb_m_suppliers.setOpaque(false);

        cb_m_customers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_customers.setText("CUSTOMERS");
        cb_m_customers.setOpaque(false);

        cb_m_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_discount.setText("DISCOUNTS");
        cb_m_discount.setOpaque(false);

        cb_m_banks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_m_banks.setText("BANKS");
        cb_m_banks.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_m_category, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_users, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_uom, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_customers, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_m_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cb_m_items, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_m_banks, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_m_items)
                    .addComponent(cb_m_banks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_m_category)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_m_users)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_m_uom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_m_suppliers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_m_customers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb_m_discount))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cb_r_sales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_sales.setText("SALES");
        cb_r_sales.setOpaque(false);

        cb_r_cash_count.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_cash_count.setText("CASH COUNT");
        cb_r_cash_count.setOpaque(false);

        cb_r_receipts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_receipts.setText("RECEIPTS");
        cb_r_receipts.setOpaque(false);

        cb_r_stock_transferred.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_stock_transferred.setText("STOCK TRANSFERRED");
        cb_r_stock_transferred.setOpaque(false);

        cb_r_stock_take.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_stock_take.setText("STOCK LEFT (Category)");
        cb_r_stock_take.setOpaque(false);
        cb_r_stock_take.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_takeActionPerformed(evt);
            }
        });

        cb_r_stock_left_supplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_r_stock_left_supplier.setText("STOCK LEFT (Supplier)");
        cb_r_stock_left_supplier.setOpaque(false);
        cb_r_stock_left_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_r_stock_left_supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_r_cash_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_receipts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_stock_transferred, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_stock_take, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_r_stock_left_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_r_sales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_r_cash_count)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_r_receipts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_r_stock_transferred)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_r_stock_take)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_r_stock_left_supplier)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        add_users();
    }//GEN-LAST:event_btn_addMouseClicked

    private void tbl_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseClicked
        select_users();
    }//GEN-LAST:event_tbl_usersMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        edit_users();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        delete_users();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newMouseClicked
        clear_users();
    }//GEN-LAST:event_btn_newMouseClicked

    private void cb_r_stock_takeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_takeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_r_stock_takeActionPerformed

    private void cb_r_stock_left_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_r_stock_left_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_r_stock_left_supplierActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        update_innosoft();
    }//GEN-LAST:event_jButton5ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel btn_add;
    private org.jdesktop.swingx.JXLabel btn_delete;
    private org.jdesktop.swingx.JXLabel btn_edit;
    private org.jdesktop.swingx.JXLabel btn_new;
    private javax.swing.JCheckBox cb_active;
    private javax.swing.JComboBox cb_lvl;
    private javax.swing.JCheckBox cb_m_banks;
    private javax.swing.JCheckBox cb_m_category;
    private javax.swing.JCheckBox cb_m_customers;
    private javax.swing.JCheckBox cb_m_discount;
    private javax.swing.JCheckBox cb_m_items;
    private javax.swing.JCheckBox cb_m_suppliers;
    private javax.swing.JCheckBox cb_m_uom;
    private javax.swing.JCheckBox cb_m_users;
    private javax.swing.JCheckBox cb_r_cash_count;
    private javax.swing.JCheckBox cb_r_receipts;
    private javax.swing.JCheckBox cb_r_sales;
    private javax.swing.JCheckBox cb_r_stock_left_supplier;
    private javax.swing.JCheckBox cb_r_stock_take;
    private javax.swing.JCheckBox cb_r_stock_transferred;
    private javax.swing.JCheckBox cb_t_inventory_adjuster;
    private javax.swing.JCheckBox cb_t_receipts;
    private javax.swing.JCheckBox cb_t_sales;
    private javax.swing.JCheckBox cb_t_stock_transfer;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable tbl_users;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_screen_name;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_user_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        tf_search.grabFocus();
        init_key();
        hover();
        search();
        init();
        init_tbl_users();
        data_cols();
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
        SearchField sf = (SearchField) tf_search;
        sf.setFont(new java.awt.Font("Tahoma", 0, 10));
        sf.set_instruction1("Type To Search");
        sf.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                // your search list here coming from svc for example.

                return new ArrayList();

            }
        });

        sf.setCallbackDisplay(new SearchField.CallbackDisplay() {

            @Override
            public void display(Object o) {
            }
        });
        sf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });
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
    private ArrayListModel tbl_users_ALM;
    private TblusersModel tbl_users_M;

    private void init_tbl_users() {
        tbl_users_ALM = new ArrayListModel();
        tbl_users_M = new TblusersModel(tbl_users_ALM);
        tbl_users.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_users.setModel(tbl_users_M);
        tbl_users.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_users.setRowHeight(25);
        int[] tbl_widths_users = {0, 100, 0, 0, 100, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_users.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_users, i, tbl_widths_users[i]);
        }
        Dimension d = tbl_users.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_users.getTableHeader().
                setPreferredSize(d);
        tbl_users.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_users.setRowHeight(35);
        tbl_users.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_users(List<to_users> acc) {
        tbl_users_ALM.clear();
        tbl_users_ALM.addAll(acc);
    }

    public static class TblusersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "SCREEN NAME", "user_name", "password", "LEVEL", "date_added", "ACTIVE", "t_sales", "t_receipts", "t_stock_transfer", "m_items", "m_category", "m_users", "m_uom", "m_suppliers", "r_sales", "r_cash_count", "r_receipts", "r_stock_transferred", "r_stock_take"
        };

        public TblusersModel(ListModel listmodel) {
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
            to_users tt = (to_users) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return " " + tt.screen_name;
                case 2:
                    return tt.user_name;
                case 3:
                    return tt.password;
                case 4:
                    if (tt.user_level == 0) {
                        return "ADMIN";
                    } else {
                        return "CASHIER";
                    }

                case 5:
                    return tt.date_added;
                case 6:
                    if (tt.is_active == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }

                case 7:
                    return tt.t_sales;
                case 8:
                    return tt.t_receipts;
                case 9:
                    return tt.t_stock_transfer;
                case 10:
                    return tt.m_items;
                case 11:
                    return tt.m_category;
                case 12:
                    return tt.m_users;
                case 13:
                    return tt.m_uom;
                case 14:
                    return tt.m_suppliers;
                case 15:
                    return tt.r_sales;
                case 16:
                    return tt.r_cash_count;
                case 17:
                    return tt.r_receipts;
                case 18:
                    return tt.r_stock_transferred;
                default:
                    return tt.r_stock_take;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        loadData_users(S1_users.ret_data(search));
    }

    private void add_users() {
        int id = -1;
        String screen_name = tf_screen_name.getText();
        String user_name = tf_user_name.getText();
        String password = tf_password.getText();
        int user_level = 0;
        if (cb_lvl.getSelectedIndex() == 0) {
            user_level = 1;
        }
        String date_added = DateType.datetime.format(new Date());
        int is_active = 0;
        if (cb_active.isSelected()) {
            is_active = 1;
        }
        String t_sales = "0";
        if (cb_t_sales.isSelected()) {
            t_sales = "1";
        }
        String t_receipts = "0";
        if (cb_t_receipts.isSelected()) {
            t_receipts = "1";
        }
        String t_stock_transfer = "0";
        if (cb_t_stock_transfer.isSelected()) {
            t_stock_transfer = "1";
        }
        String m_items = "0";
        if (cb_m_items.isSelected()) {
            m_items = "1";
        }
        String m_category = "0";
        if (cb_m_category.isSelected()) {
            m_category = "1";
        }
        String m_users = "0";
        if (cb_m_users.isSelected()) {
            m_users = "1";
        }
        String m_uom = "0";
        if (cb_m_uom.isSelected()) {
            m_uom = "1";
        }
        String m_suppliers = "0";
        if (cb_m_suppliers.isSelected()) {
            m_suppliers = "1";
        }
        String r_sales = "0";
        if (cb_r_sales.isSelected()) {
            r_sales = "1";
        }
        String r_cash_count = "0";
        if (cb_r_cash_count.isSelected()) {
            r_cash_count = "1";
        }
        String r_receipts = "0";
        if (cb_r_receipts.isSelected()) {
            r_receipts = "1";
        }
        String r_stock_transferred = "0";
        if (cb_r_stock_transferred.isSelected()) {
            r_stock_transferred = "1";
        }
        String r_stock_take = "0";
        if (cb_r_stock_take.isSelected()) {
            r_stock_take = "1";
        }
        String m_customers = "0";
        if (cb_m_customers.isSelected()) {
            m_customers = "1";
        }
        String m_discount = "0";
        if (cb_m_discount.isSelected()) {
            m_discount = "1";
        }
        String m_banks = "0";
        if (cb_m_banks.isSelected()) {
            m_banks = "1";
        }
        String r_stock_left_supplier = "0";
        if (cb_r_stock_left_supplier.isSelected()) {
            r_stock_left_supplier = "1";
        }
        String t_inventory_adjuster = "0";
        if (cb_t_inventory_adjuster.isSelected()) {
            t_inventory_adjuster = "1";
        }
        to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster);

        S1_users.add_users(to);
        data_cols();
        clear_users();
        Alert.set(1, "");
    }

    private void select_users() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_users to = (to_users) tbl_users_ALM.get(tbl_users.
                convertRowIndexToModel(row));
        tf_screen_name.setText(to.screen_name);
        tf_user_name.setText(to.user_name);
        tf_password.setText(to.password);
        if (to.user_level == 0) {
            cb_lvl.setSelectedIndex(1);
        } else {
            cb_lvl.setSelectedIndex(0);
        }
        if (to.is_active == 0) {
            cb_active.setSelected(false);
        } else {
            cb_active.setSelected(true);
        }

        if (to.t_sales.equals("0")) {
            cb_t_sales.setSelected(false);
        } else {
            cb_t_sales.setSelected(true);
        }

        if (to.t_receipts.equals("0")) {
            cb_t_receipts.setSelected(false);
        } else {
            cb_t_receipts.setSelected(true);
        }

        if (to.t_stock_transfer.equals("0")) {
            cb_t_stock_transfer.setSelected(false);
        } else {
            cb_t_stock_transfer.setSelected(true);
        }

        if (to.m_items.equals("0")) {
            cb_m_items.setSelected(false);
        } else {
            cb_m_items.setSelected(true);
        }

        if (to.m_category.equals("0")) {
            cb_m_category.setSelected(false);
        } else {
            cb_m_category.setSelected(true);
        }

        if (to.m_users.equals("0")) {
            cb_m_users.setSelected(false);
        } else {
            cb_m_users.setSelected(true);
        }

        if (to.m_uom.equals("0")) {
            cb_m_uom.setSelected(false);
        } else {
            cb_m_uom.setSelected(true);
        }

        if (to.m_suppliers.equals("0")) {
            cb_m_suppliers.setSelected(false);
        } else {
            cb_m_suppliers.setSelected(true);
        }

        if (to.r_sales.equals("0")) {
            cb_r_sales.setSelected(false);
        } else {
            cb_r_sales.setSelected(true);
        }

        if (to.r_cash_count.equals("0")) {
            cb_r_cash_count.setSelected(false);
        } else {
            cb_r_cash_count.setSelected(true);
        }

        if (to.r_receipts.equals("0")) {
            cb_r_receipts.setSelected(false);
        } else {
            cb_r_receipts.setSelected(true);
        }

        if (to.r_stock_transferred.equals("0")) {
            cb_r_stock_transferred.setSelected(false);
        } else {
            cb_r_stock_transferred.setSelected(true);
        }
        if (to.r_stock_take.equals("0")) {
            cb_r_stock_take.setSelected(false);
        } else {
            cb_r_stock_take.setSelected(true);
        }
        if (to.m_customers.equals("0")) {
            cb_m_customers.setSelected(false);
        } else {
            cb_m_customers.setSelected(true);
        }
        if (to.m_discount.equals("0")) {
            cb_m_discount.setSelected(false);
        } else {
            cb_m_discount.setSelected(true);
        }
        if (to.m_banks.equals("0")) {
            cb_m_banks.setSelected(false);
        } else {
            cb_m_banks.setSelected(true);
        }
        if (to.r_stock_left_supplier.equals("0")) {
            cb_r_stock_left_supplier.setSelected(false);
        } else {
            cb_r_stock_left_supplier.setSelected(true);
        }
        if (to.t_inventory_adjuster.equals("0")) {
            cb_t_inventory_adjuster.setSelected(false);
        } else {
            cb_t_inventory_adjuster.setSelected(true);
        }
    }

    private void edit_users() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_users to = (to_users) tbl_users_ALM.get(tbl_users.
                convertRowIndexToModel(row));
        int id = to.id;
        String screen_name = tf_screen_name.getText();
        String user_name = tf_user_name.getText();
        String password = tf_password.getText();
        int user_level = 0;
        if (cb_lvl.getSelectedIndex() == 0) {
            user_level = 1;
        }
        String date_added = DateType.datetime.format(new Date());
        int is_active = 0;
        if (cb_active.isSelected()) {
            is_active = 1;
        }
        String t_sales = "0";
        if (cb_t_sales.isSelected()) {
            t_sales = "1";
        }
        String t_receipts = "0";
        if (cb_t_receipts.isSelected()) {
            t_receipts = "1";
        }
        String t_stock_transfer = "0";
        if (cb_t_stock_transfer.isSelected()) {
            t_stock_transfer = "1";
        }
        String m_items = "0";
        if (cb_m_items.isSelected()) {
            m_items = "1";
        }
        String m_category = "0";
        if (cb_m_category.isSelected()) {
            m_category = "1";
        }
        String m_users = "0";
        if (cb_m_users.isSelected()) {
            m_users = "1";
        }
        String m_uom = "0";
        if (cb_m_uom.isSelected()) {
            m_uom = "1";
        }
        String m_suppliers = "0";
        if (cb_m_suppliers.isSelected()) {
            m_suppliers = "1";
        }
        String r_sales = "0";
        if (cb_r_sales.isSelected()) {
            r_sales = "1";
        }
        String r_cash_count = "0";
        if (cb_r_cash_count.isSelected()) {
            r_cash_count = "1";
        }
        String r_receipts = "0";
        if (cb_r_receipts.isSelected()) {
            r_receipts = "1";
        }
        String r_stock_transferred = "0";
        if (cb_r_stock_transferred.isSelected()) {
            r_stock_transferred = "1";
        }
        String r_stock_take = "0";
        if (cb_r_stock_take.isSelected()) {
            r_stock_take = "1";
        }
        String m_customers = "0";
        if (cb_m_customers.isSelected()) {
            m_customers = "1";
        }
        String m_discount = "0";
        if (cb_m_discount.isSelected()) {
            m_discount = "1";
        }
        String m_banks = "0";
        if (cb_m_banks.isSelected()) {
            m_banks = "1";
        }
        String r_stock_left_supplier = "0";
        if (cb_r_stock_left_supplier.isSelected()) {
            r_stock_left_supplier = "1";
        }
        String t_inventory_adjuster = "0";
        if (cb_t_inventory_adjuster.isSelected()) {
            t_inventory_adjuster = "1";
        }
        to_users to1 = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster);

        S1_users.edit_users(to1);
        data_cols();
        clear_users();
        Alert.set(2, "");
    }

    private void clear_users() {
        tf_screen_name.setText("");
        tf_user_name.setText("");
        tf_password.setText("");
    }

    private void delete_users() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_users to = (to_users) tbl_users_ALM.get(tbl_users.
                convertRowIndexToModel(row));
        S1_users.delete_users(to);
        data_cols();
        clear_users();
        Alert.set(3, "");
    }

    private void update_innosoft() {

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                int connected = MyConnectionInnosoft.check_connection();
                if (connected == 0) {
                    Alert.set(0, "Cannot connect to innosoft, please check connection!");
                    return;
                }
                Users.update_innosoft();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
