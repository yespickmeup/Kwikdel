/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.statement_of_accounts;

import POS.customers.Customers;
import POS.items.S1_items;
import POS.statement_of_accounts.S1_statement_of_account_readings.to_statement_of_account_readings;
import POS.statement_of_accounts.S1_statement_of_accounts.to_statement_of_accounts;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
 * @author Ronald
 */
public class Dlg_statement_of_account extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_statement_of_account
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
    private Dlg_statement_of_account(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_statement_of_account(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_statement_of_account() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_statement_of_account myRef;

    private void setThisRef(Dlg_statement_of_account myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_statement_of_account> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_statement_of_account create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_statement_of_account create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_statement_of_account dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_statement_of_account((java.awt.Frame) parent, false);
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
            Dlg_statement_of_account dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_statement_of_account((java.awt.Dialog) parent, false);
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

        Dlg_statement_of_account dialog = Dlg_statement_of_account.create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pm_update = new javax.swing.JMenuItem();
        pm_view_history = new javax.swing.JMenuItem();
        pm_print = new javax.swing.JMenuItem();
        pm_delete = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_statement_of_account_readings = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_previous_reading = new javax.swing.JTextField();
        tf_current_reading = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_statement_of_accounts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        tf_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        tf_balance = new javax.swing.JTextField();
        tf_paid = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        pm_update.setText("Update");
        pm_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_updateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_update);

        pm_view_history.setText("View History");
        pm_view_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_view_historyActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_view_history);

        pm_print.setText("Print");
        pm_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_printActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_print);

        pm_delete.setText("Delete");
        pm_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_deleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_delete);

        jMenuItem1.setText("Payment");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem1);

        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(65, 136, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_statement_of_account_readings.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_statement_of_account_readings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_statement_of_account_readingsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_statement_of_account_readingsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_statement_of_account_readingsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_statement_of_account_readings);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cubic Consumptions");

        jLabel10.setText("Present Reading:");

        jLabel11.setText("Previous Reading:");

        tf_previous_reading.setFocusable(false);

        tf_current_reading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_current_readingActionPerformed(evt);
            }
        });
        tf_current_reading.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_current_readingKeyReleased(evt);
            }
        });

        jLabel12.setText("Total Reading/s:");

        jLabel13.setText("0");

        jLabel21.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_previous_reading, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_current_reading, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_previous_reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_current_reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(8, 8, 8))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_statement_of_accounts.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_statement_of_accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_statement_of_accountsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_statement_of_accountsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_statement_of_accountsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_statement_of_accountsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_statement_of_accounts);

        jLabel1.setText("Search Customer:");

        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Statement of Account");

        jLabel6.setText("Search Item:");

        tf_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_barcodeActionPerformed(evt);
            }
        });

        tf_price.setFocusable(false);

        jLabel7.setText("Price:");

        jLabel8.setText("Qty:");

        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Accounts:");

        jLabel15.setText("0");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("0.00");

        jLabel17.setText("Balance:");

        jLabel4.setText("Description:");

        tf_description.setFocusable(false);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel18.setText("Balance:");

        tf_balance.setText("0.00");

        tf_paid.setText("0.00");

        jLabel19.setText("Paid:");

        jButton7.setText("New");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_customer_name)
                        .addGap(0, 0, 0)
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(tf_barcode)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(tf_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_price))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4))))
                            .addComponent(tf_description))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jLabel18)
                    .addComponent(tf_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tf_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_barcodeActionPerformed
        // TODO add your handling code here:
        init_item();
    }//GEN-LAST:event_tf_barcodeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        clear_statement_of_accounts();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        add_statement_of_accounts();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        edit_statement_of_accounts();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        delete_statement_of_accounts();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_statement_of_accountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_accountsMouseClicked
        // TODO add your handling code here:
        select_statement_of_accounts();
    }//GEN-LAST:event_tbl_statement_of_accountsMouseClicked

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        // TODO add your handling code here:
        add_statement_of_accounts();
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tbl_statement_of_accountsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_accountsMousePressed
        account_menu(evt);
    }//GEN-LAST:event_tbl_statement_of_accountsMousePressed

    private void tbl_statement_of_accountsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_accountsMouseReleased
        account_menu(evt);
    }//GEN-LAST:event_tbl_statement_of_accountsMouseReleased

    private void pm_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_updateActionPerformed
        update_qty();
    }//GEN-LAST:event_pm_updateActionPerformed

    private void pm_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_deleteActionPerformed
        delete_statement_of_account();
    }//GEN-LAST:event_pm_deleteActionPerformed

    private void tbl_statement_of_accountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_accountsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_statement_of_accountsMouseEntered

    private void tf_current_readingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_current_readingKeyReleased
        compute();
    }//GEN-LAST:event_tf_current_readingKeyReleased

    private void tf_current_readingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_current_readingActionPerformed
        add_statement_of_account_readings();
    }//GEN-LAST:event_tf_current_readingActionPerformed

    private void tbl_statement_of_account_readingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_account_readingsMouseClicked
        delete_reading();
    }//GEN-LAST:event_tbl_statement_of_account_readingsMouseClicked

    private void pm_view_historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_view_historyActionPerformed
        history();
    }//GEN-LAST:event_pm_view_historyActionPerformed

    private void tbl_statement_of_account_readingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_account_readingsMousePressed
        show_soa_menu(evt);
    }//GEN-LAST:event_tbl_statement_of_account_readingsMousePressed

    private void tbl_statement_of_account_readingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_statement_of_account_readingsMouseReleased
        show_soa_menu(evt);
    }//GEN-LAST:event_tbl_statement_of_account_readingsMouseReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        delete_soa_reading();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        soa_payment();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void pm_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_printActionPerformed
        print_soa();
    }//GEN-LAST:event_pm_printActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem pm_delete;
    private javax.swing.JMenuItem pm_print;
    private javax.swing.JMenuItem pm_update;
    private javax.swing.JMenuItem pm_view_history;
    private javax.swing.JTable tbl_statement_of_account_readings;
    private javax.swing.JTable tbl_statement_of_accounts;
    private javax.swing.JTextField tf_balance;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_current_reading;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_paid;
    private javax.swing.JTextField tf_previous_reading;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        focus();
        tf_customer_name.grabFocus();
        init_tbl_statement_of_accounts();
        data_cols();

        init_tbl_statement_of_account_readings();
        data_cols_reading();
//        tf_customer_id.setVisible(false);
    }

    private void focus() {
        JTextField[] tf = {tf_previous_reading, tf_current_reading, tf_customer_name, tf_barcode, tf_qty};
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
    private ArrayListModel tbl_statement_of_accounts_ALM;
    private Tblstatement_of_accountsModel tbl_statement_of_accounts_M;

    private void init_tbl_statement_of_accounts() {
        tbl_statement_of_accounts_ALM = new ArrayListModel();
        tbl_statement_of_accounts_M = new Tblstatement_of_accountsModel(tbl_statement_of_accounts_ALM);
        tbl_statement_of_accounts.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_statement_of_accounts.setModel(tbl_statement_of_accounts_M);
        tbl_statement_of_accounts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_statement_of_accounts.setRowHeight(25);
        int[] tbl_widths_statement_of_accounts = {100, 100, 50, 70, 0, 70, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_statement_of_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_statement_of_accounts, i, tbl_widths_statement_of_accounts[i]);
        }
        Dimension d = tbl_statement_of_accounts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_statement_of_accounts.getTableHeader().setPreferredSize(d);
        tbl_statement_of_accounts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_statement_of_accounts.setRowHeight(25);
        tbl_statement_of_accounts.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_accounts, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_accounts, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_accounts, 5);
    }

    private void loadData_statement_of_accounts(List<to_statement_of_accounts> acc) {
        tbl_statement_of_accounts_ALM.clear();
        tbl_statement_of_accounts_ALM.addAll(acc);
    }

    public static class Tblstatement_of_accountsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Description", "Qty", "Price", "Amount", "Balance", "item_code", "barcode", "description", "qty", "price", "balance", "paid"
        };

        public Tblstatement_of_accountsModel(ListModel listmodel) {
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
            to_statement_of_accounts tt = (to_statement_of_accounts) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + FitIn.fmt_wc_0(tt.qty);
                case 3:
                    return FitIn.fmt_wc_0(tt.price) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.qty * tt.price) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.balance) + " ";
                case 6:
                    return tt.item_code;
                case 7:
                    return tt.barcode;
                case 8:
                    return tt.description;
                case 9:
                    return tt.qty;
                case 10:
                    return tt.price;
                case 11:
                    return tt.balance;
                default:
                    return tt.paid;
            }
        }
    }

    private void data_cols() {
        String where = " where customer_id='" + tf_customer_id.getText() + "' ";
        System.out.println(where);
        loadData_statement_of_accounts(S1_statement_of_accounts.ret_data(where));
    }
    List<S1_items.to_items> item_list = new ArrayList();

    private void init_item() {
        String search = tf_barcode.getText();
        item_list.clear();
        String where = " where description like '%" + search + "%' order by description asc";
        item_list = S1_items.ret_data5(where);
        Object[][] obj = new Object[item_list.size()][3];
        int i = 0;
        for (S1_items.to_items to : item_list) {
            obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
            obj[i][1] = " " + to.description;
            obj[i][2] = " " + FitIn.fmt_wc_0(to.selling_price);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {30, 300, 70};
        int width = 0;
        String[] col_names = {"Qty", "Description", "Price"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf_barcode, obj, labels, tbl_widths_customers, col_names, 530);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_items.to_items to = item_list.get(data.selected_row);
                tf_description.setText(to.description);
                tf_price.setText(FitIn.fmt_wc_0(to.selling_price));
                tf_barcode.setText(to.barcode);
                tf_qty.grabFocus();
                data_cols();
            }
        });
    }
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {
        String search = tf_customer_name.getText();
        customer_list.clear();
        String where = " where last_name like '%" + search + "%' or first_name like '%" + search + "%' ";
        customer_list = Customers.ret_data2(where);
        Object[][] obj = new Object[customer_list.size()][1];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.first_name + " " + to.last_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {};
        int width = 0;
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf_customer_name, obj, labels, tbl_widths_customers, col_names, tf_customer_name.getWidth());
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_name.setText(to.first_name + " " + to.last_name);
                tf_customer_id.setText("" + to.id);
                tf_barcode.grabFocus();
                data_cols();
            }
        });
    }

    private void add_statement_of_accounts() {
        int id = -1;
        String customer_id = tf_customer_id.getText();
        String customer_no = tf_customer_name.getText();
        String user_id = Users.get_username();
        String user_name = Users.get_username();
        String date_added = DateType.now();
        String item_code = tf_barcode.getText();
        String barcode = tf_barcode.getText();
        String description = tf_description.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        double price = FitIn.toDouble(tf_price.getText());
        double balance = 0;
        double paid = 0;
        to_statement_of_accounts to = new to_statement_of_accounts(id, customer_id, customer_no, user_id, user_name, date_added, item_code, barcode, description, qty, price, balance, paid);
        S1_statement_of_accounts.add_statement_of_accounts(to);
        data_cols();
        clear_statement_of_accounts();
    }

    private void select_statement_of_accounts() {
        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        tf_customer_id.setText(to.customer_id);
        tf_customer_name.setText(to.customer_no);
        tf_barcode.setText(to.barcode);
        tf_description.setText(to.description);
        tf_qty.setText(FitIn.fmt_wc_0(to.qty));
        tf_price.setText(FitIn.fmt_wc_0(to.price));
        tf_balance.setText(FitIn.fmt_wc_0(to.balance));
        tf_paid.setText(FitIn.fmt_wc_0(to.paid));
        tf_current_reading.grabFocus();
        tf_current_reading.setText("");
        tf_total.setText("");
        data_cols_reading();
        
    }

    private void edit_statement_of_accounts() {
        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        int id = to.id;
        String customer_id = tf_customer_id.getText();
        String customer_no = tf_customer_name.getText();
        String user_id = to.user_id;
        String user_name = to.user_name;
        String date_added = to.date_added;
        String item_code = tf_barcode.getText();
        String barcode = tf_barcode.getText();
        String description = tf_description.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        double price = FitIn.toDouble(tf_price.getText());
        double balance = FitIn.toDouble(tf_balance.getText());
        double paid = FitIn.toDouble(tf_paid.getText());
        to_statement_of_accounts to1 = new to_statement_of_accounts(id, customer_id, customer_no, user_id, user_name, date_added, item_code, barcode, description, qty, price, balance, paid);
        S1_statement_of_accounts.edit_statement_of_accounts(to1);
        data_cols();
        clear_statement_of_accounts();
    }

    private void clear_statement_of_accounts() {

        tf_barcode.setText("");
        tf_description.setText("");
        tf_qty.setText("");
        tf_price.setText("");
        tf_balance.setText("0.00");
        tf_paid.setText("0.00");
        tf_barcode.grabFocus();
    }

    private void delete_statement_of_accounts() {
        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        S1_statement_of_accounts.delete_statement_of_accounts(to);
        data_cols();
        clear_statement_of_accounts();
    }
    private ArrayListModel tbl_statement_of_account_readings_ALM;
    private Tblstatement_of_account_readingsModel tbl_statement_of_account_readings_M;

    private void init_tbl_statement_of_account_readings() {
        tbl_statement_of_account_readings_ALM = new ArrayListModel();
        tbl_statement_of_account_readings_M = new Tblstatement_of_account_readingsModel(tbl_statement_of_account_readings_ALM);
        tbl_statement_of_account_readings.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_statement_of_account_readings.setModel(tbl_statement_of_account_readings_M);
        tbl_statement_of_account_readings.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_statement_of_account_readings.setRowHeight(25);
        int[] tbl_widths_statement_of_account_readings = {50, 50, 50, 90, 0, 100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_statement_of_account_readings.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_statement_of_account_readings, i, tbl_widths_statement_of_account_readings[i]);
        }
        Dimension d = tbl_statement_of_account_readings.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_statement_of_account_readings.getTableHeader().setPreferredSize(d);
        tbl_statement_of_account_readings.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_statement_of_account_readings.setRowHeight(25);
        tbl_statement_of_account_readings.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_account_readings, 1);
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_account_readings, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_account_readings, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_statement_of_account_readings, 5);
    }

    private void loadData_statement_of_account_readings(List<to_statement_of_account_readings> acc) {
        tbl_statement_of_account_readings_ALM.clear();
        tbl_statement_of_account_readings_ALM.addAll(acc);
    }

    public static class Tblstatement_of_account_readingsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Prev", "Present", "Total", "Action", "Balance", "item_code", "barcode", "description", "qty", "price", "previous_reading", "current_reading"
        };

        public Tblstatement_of_account_readingsModel(ListModel listmodel) {
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
            to_statement_of_account_readings tt = (to_statement_of_account_readings) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return FitIn.fmt_wc_0(tt.previous_reading) + " ";
                case 2:
                    return FitIn.fmt_wc_0(tt.current_reading) + " ";
                case 3:
                    return FitIn.fmt_wc_0((tt.previous_reading - tt.current_reading) * tt.price) + " ";
                case 4:
                    return "  Delete";
                case 5:
                    return FitIn.fmt_wc_0(tt.amount - tt.paid) + " ";
                case 6:
                    return tt.item_code;
                case 7:
                    return tt.barcode;
                case 8:
                    return tt.description;
                case 9:
                    return tt.qty;
                case 10:
                    return tt.price;
                case 11:
                    return tt.previous_reading;
                default:
                    return tt.current_reading;
            }
        }
    }

    private void data_cols_reading() {

        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        String where = " where sar_id='" + to.id + "'";
        loadData_statement_of_account_readings(S1_statement_of_account_readings.ret_data(where));

        List<to_statement_of_account_readings> datas = tbl_statement_of_account_readings_ALM;
        tf_previous_reading.setText(FitIn.fmt_wc_0(to.qty));

    }

    private void account_menu(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_statement_of_accounts, evt.getX(), evt.getY());
        }

    }

    private void update_qty() {
        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));

        Window p = (Window) this;
        Dlg_update_statement_of_account nd = Dlg_update_statement_of_account.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_update_statement_of_account.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_update_statement_of_account.OutputData data) {
                closeDialog.ok();
                S1_statement_of_accounts.edit_qty(to, data.qty);
                S1_statement_of_account_histories.to_statement_of_account_histories history = new S1_statement_of_account_histories.to_statement_of_account_histories(-1, "" + to.id, data.qty, DateType.now());
                S1_statement_of_account_histories.add_statement_of_account_histories(history);
                data_cols();
                Alert.set(2, "");
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void delete_statement_of_account() {
        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));

        Window p = (Window) this;
        Dlg_delete_statement_of_account nd = Dlg_delete_statement_of_account.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_delete_statement_of_account.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_delete_statement_of_account.OutputData data) {
                closeDialog.ok();
                S1_statement_of_accounts.delete_statement_of_accounts(to);
                data_cols();
                Alert.set(3, "");
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void add_statement_of_account_readings() {

        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        int id = -1;
        String customer_id = tf_customer_id.getText();
        String customer_name = tf_customer_name.getText();
        String user_id = Users.get_username();
        String user_name = Users.get_username();
        String date_added = DateType.now();
        String item_code = to.item_code;
        String barcode = to.barcode;
        String description = tf_description.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        double price = FitIn.toDouble(tf_price.getText());
        double previous_reading = FitIn.toDouble(tf_previous_reading.getText());
        double current_reading = FitIn.toDouble(tf_current_reading.getText());
        String sar_id = "" + to.id;
        double total = FitIn.toDouble(tf_total.getText());
        double current_total = previous_reading - current_reading;
        double amount = current_total * price;
        double paid = 0;
        to_statement_of_account_readings to2 = new to_statement_of_account_readings(id, customer_id, customer_name, user_id, user_name, date_added, item_code, barcode, description, qty, price, previous_reading, current_reading, sar_id, amount, paid);
        S1_statement_of_account_readings.add_statement_of_account_readings(to2);
        S1_statement_of_accounts.edit_qty2(to, total);
        data_cols();
        tbl_statement_of_accounts.setRowSelectionInterval(row, row);
        data_cols_reading();
        tf_current_reading.setText("");
        tf_total.setText("");

    }

    private void compute() {
        double previous = FitIn.toDouble(tf_previous_reading.getText());
        double present = FitIn.toDouble(tf_current_reading.getText());
        double total = previous - present;
        tf_total.setText(FitIn.fmt_wc_0(total));
    }

    private void delete_reading() {

        int row2 = tbl_statement_of_accounts.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_statement_of_accounts to2 = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row2));
        int row = tbl_statement_of_account_readings.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_account_readings to = (to_statement_of_account_readings) tbl_statement_of_account_readings_ALM.get(tbl_statement_of_account_readings.convertRowIndexToModel(row));
        int col = tbl_statement_of_account_readings.getSelectedColumn();
        if (col == 14) {
            S1_statement_of_account_readings.delete_statement_of_account_readings(to);
            S1_statement_of_accounts.edit_qty3(to, to2.qty);
            data_cols();
            tbl_statement_of_accounts.setRowSelectionInterval(row2, row2);
            data_cols_reading();
            Alert.set(3, "");
        }
    }

    private void delete_soa_reading() {
        int row2 = tbl_statement_of_accounts.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_statement_of_accounts to2 = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row2));
        int row = tbl_statement_of_account_readings.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_account_readings to = (to_statement_of_account_readings) tbl_statement_of_account_readings_ALM.get(tbl_statement_of_account_readings.convertRowIndexToModel(row));
        S1_statement_of_account_readings.delete_statement_of_account_readings(to);
        S1_statement_of_accounts.edit_qty3(to, to2.qty);
        data_cols();
        tbl_statement_of_accounts.setRowSelectionInterval(row2, row2);
        data_cols_reading();
        Alert.set(3, "");
    }

    private void history() {
        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_soa_histories nd = Dlg_soa_histories.create(p, true);
        nd.setTitle("");
        nd.do_pass("" + to.id);
        nd.setCallback(new Dlg_soa_histories.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_soa_histories.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void show_soa_menu(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(tbl_statement_of_account_readings, evt.getX(), evt.getY());
        }
    }

    private void soa_payment() {
        final int row = tbl_statement_of_account_readings.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_statement_of_account_readings to = (to_statement_of_account_readings) tbl_statement_of_account_readings_ALM.get(tbl_statement_of_account_readings.convertRowIndexToModel(row));
        double amount_due = to.amount - to.paid;
        Window p = (Window) this;
        Dlg_soa_payment nd = Dlg_soa_payment.create(p, true);
        nd.setTitle("");
        nd.do_pass(amount_due);
        nd.setCallback(new Dlg_soa_payment.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_soa_payment.OutputData data) {
                closeDialog.ok();
                int id = -1;
                String customer_id = to.customer_id;
                String customer_name = to.customer_name;
                String user_id = Users.user_name;
                String user_name = Users.user_name;
                String date_added = DateType.now();
                String item_code = to.item_code;
                String barcode = to.barcode;
                String description = to.description;
                double qty = to.previous_reading - to.current_reading;
                double price = to.price;
                double previous_reading = to.previous_reading;
                double current_reading = to.current_reading;
                String sar_id = to.sar_id;
                double amount = to.amount;
                double paid = to.paid;
                String soa_reading_id = "" + to.id;
                S1_statement_of_account_reading_payments.to_statement_of_account_reading_payments t = new S1_statement_of_account_reading_payments.to_statement_of_account_reading_payments(id, customer_id, customer_name, user_id, user_name, date_added, item_code, barcode, description, qty, price, previous_reading, current_reading, sar_id, amount, paid, soa_reading_id);
                S1_statement_of_account_reading_payments.add_statement_of_account_reading_payments(t);
                S1_statement_of_account_reading_payments.update_soa_reading("" + to.id, amount);
                data_cols_reading();
                tbl_statement_of_account_readings.setRowSelectionInterval(row, row);
                Alert.set(2, sar_id);
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

    private void print_soa() {

        int row = tbl_statement_of_accounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_statement_of_accounts to = (to_statement_of_accounts) tbl_statement_of_accounts_ALM.get(tbl_statement_of_accounts.convertRowIndexToModel(row));
        String where = " where sar_id='" + to.id + "' ";
        Window p = (Window) this;
        Dlg_soa_print nd = Dlg_soa_print.create(p, true);
        nd.setTitle("");
        nd.do_pass(where);
        nd.setCallback(new Dlg_soa_print.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_soa_print.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
