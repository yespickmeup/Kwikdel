/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.accounts_receivable.S1_accounts_receivable_payments.to_accounts_receivable_payments;
import POS.customers.Dlg_customers;
import POS.customers.Customers;
import POS.main.Main;
import POS.terms.S1_terms;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import POS.util.testOfFaith;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Maytopacka
 */
public class Dlg_ar_encoding extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_encoding
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
    private Dlg_ar_encoding(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_encoding(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_encoding() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_ar_encoding myRef;

    private void setThisRef(Dlg_ar_encoding myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_encoding> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_encoding create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_encoding create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_encoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_encoding((java.awt.Frame) parent, false);
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
            Dlg_ar_encoding dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_encoding((java.awt.Dialog) parent, false);
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

        Dlg_ar_encoding dialog = Dlg_ar_encoding.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        tf_ar_no = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_term = new SearchField();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tf_ar_month = new SearchField();
        tf_ar_day = new SearchField();
        tf_ar_year = new SearchField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_balance = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_ci_no = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tf_trust_receipt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tf_paid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tf_search_customer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_credit_limit = new javax.swing.JLabel();
        tf_customer_id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_accounts_receivable_payments = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        tf_ap_cash = new javax.swing.JTextField();
        btn_new1 = new javax.swing.JLabel();
        btn_add1 = new javax.swing.JLabel();
        btn_edit1 = new javax.swing.JLabel();
        btn_delete1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_ap_check_bank = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_ap_check_holder = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_ap_check_amount = new javax.swing.JTextField();
        tf_ap_check_no = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tf_ap_month = new SearchField();
        tf_ap_day = new SearchField();
        tf_ap_year = new SearchField();
        jLabel24 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tf_or_payment_no = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_total_payments = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(65, 136, 210));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_accounts_receivable.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_accounts_receivable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_accounts_receivable);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("AR No:");

        tf_ar_no.setText("00000001");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Amount:");

        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Term:");

        tf_term.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_termActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Day/s");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tf_ar_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ar_monthActionPerformed(evt);
            }
        });

        tf_ar_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ar_dayActionPerformed(evt);
            }
        });

        tf_ar_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ar_yearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(tf_ar_month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ar_day, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ar_year, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_ar_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ar_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ar_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Balance:");

        jLabel19.setText("0.00");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Date Applied:");

        lbl_balance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_balance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_balance.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Balance:");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("C.I NO:");

        tf_ci_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ci_noActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("T - Receipt:");

        tf_trust_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_trust_receiptActionPerformed(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Paid:");

        tf_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_paidActionPerformed(evt);
            }
        });

        jLabel3.setText("Filter:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("C.I NO:");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("Trust Receipt");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_edit.setText("Update");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(104, 95, 84));
        jPanel2.setOpaque(false);

        tf_search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search_customerActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.Color.black);
        jLabel1.setText("Search Customer:");

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name:");

        tf_customer_name.setBackground(java.awt.Color.black);

        jLabel6.setBackground(java.awt.Color.black);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Credit Limit:");

        lbl_credit_limit.setBackground(java.awt.Color.black);
        lbl_credit_limit.setText("0.00");

        tf_customer_id.setBackground(java.awt.Color.black);

        jLabel4.setBackground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID No:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_search_customer)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_search_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(tf_trust_receipt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_ci_no)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_ar_no, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_term)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_paid, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ar_no, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_ci_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_trust_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_term, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_edit)
                    .addComponent(btn_add)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_accounts_receivable_payments.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_accounts_receivable_payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_accounts_receivable_paymentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_accounts_receivable_payments);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Cash:");

        btn_new1.setBackground(new java.awt.Color(255, 255, 255));
        btn_new1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_new1.setForeground(new java.awt.Color(153, 153, 153));
        btn_new1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_new1.setText("O new");
        btn_new1.setOpaque(true);
        btn_new1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_new1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_new1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_new1MouseExited(evt);
            }
        });

        btn_add1.setBackground(new java.awt.Color(255, 255, 255));
        btn_add1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add1.setForeground(new java.awt.Color(153, 153, 153));
        btn_add1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_add1.setText("+ add");
        btn_add1.setOpaque(true);
        btn_add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add1MouseExited(evt);
            }
        });

        btn_edit1.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_edit1.setForeground(new java.awt.Color(153, 153, 153));
        btn_edit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_edit1.setText("[] update");
        btn_edit1.setOpaque(true);
        btn_edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_edit1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_edit1MouseExited(evt);
            }
        });

        btn_delete1.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_delete1.setForeground(new java.awt.Color(153, 153, 153));
        btn_delete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_delete1.setText("- delete");
        btn_delete1.setOpaque(true);
        btn_delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_delete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_delete1MouseExited(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Check Bank:");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Check Holder:");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Amount:");

        tf_ap_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_check_noActionPerformed(evt);
            }
        });

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Check No:");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tf_ap_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_monthActionPerformed(evt);
            }
        });

        tf_ap_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_dayActionPerformed(evt);
            }
        });

        tf_ap_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ap_yearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(tf_ap_month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ap_day, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ap_year))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_ap_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ap_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tf_ap_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Date Applied:");

        jButton2.setText("jButton2");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("OR No:");

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_total_payments.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_total_payments);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_ap_check_holder)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_ap_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_ap_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_ap_check_bank)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(tf_ap_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_or_payment_no))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_or_payment_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_ap_cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ap_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_edit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_new1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
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

    private void tf_termActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_termActionPerformed
        // TODO add your handling code here:
        tf_ci_no.grabFocus();
//        add_accounts_receivable();
    }//GEN-LAST:event_tf_termActionPerformed

    private void btn_new1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_new1MouseClicked

    private void btn_new1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseEntered
        // TODO add your handling code here:
        hover2(btn_new1);
    }//GEN-LAST:event_btn_new1MouseEntered

    private void btn_new1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new1MouseExited
        // TODO add your handling code here:
        exit2(btn_new1);
    }//GEN-LAST:event_btn_new1MouseExited

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
        add_ar_payment();
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseEntered
        // TODO add your handling code here:
        hover2(btn_add1);
    }//GEN-LAST:event_btn_add1MouseEntered

    private void btn_add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseExited
        // TODO add your handling code here:
        exit2(btn_add1);
    }//GEN-LAST:event_btn_add1MouseExited

    private void btn_edit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseClicked
        // TODO add your handling code here:
        edit_accounts_receivable_payments();
    }//GEN-LAST:event_btn_edit1MouseClicked

    private void btn_edit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseEntered
        // TODO add your handling code here:
        hover2(btn_edit1);
    }//GEN-LAST:event_btn_edit1MouseEntered

    private void btn_edit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit1MouseExited
        // TODO add your handling code here:
        exit2(btn_edit1);
    }//GEN-LAST:event_btn_edit1MouseExited

    private void btn_delete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseClicked
        // TODO add your handling code here:
        delete_accounts_receivable_payments();
    }//GEN-LAST:event_btn_delete1MouseClicked

    private void btn_delete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseEntered
        // TODO add your handling code here:
        hover2(btn_delete1);
    }//GEN-LAST:event_btn_delete1MouseEntered

    private void btn_delete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MouseExited
        // TODO add your handling code here:
        exit2(btn_delete1);
    }//GEN-LAST:event_btn_delete1MouseExited

    private void tf_search_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search_customerActionPerformed
        init_popup();
    }//GEN-LAST:event_tf_search_customerActionPerformed

    private void tf_ar_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ar_monthActionPerformed
        // TODO add your handling code here:
        tf_ar_day.grabFocus();
    }//GEN-LAST:event_tf_ar_monthActionPerformed

    private void tf_ar_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ar_dayActionPerformed
        tf_ar_year.grabFocus();
    }//GEN-LAST:event_tf_ar_dayActionPerformed

    private void tf_ar_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ar_yearActionPerformed
        tf_amount.grabFocus();
    }//GEN-LAST:event_tf_ar_yearActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        tf_term.grabFocus();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tbl_accounts_receivableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseClicked
        select_accounts_receivable();
    }//GEN-LAST:event_tbl_accounts_receivableMouseClicked

    private void tf_ap_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_monthActionPerformed

    private void tf_ap_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_dayActionPerformed
    }//GEN-LAST:event_tf_ap_dayActionPerformed

    private void tf_ap_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ap_yearActionPerformed

    private void tbl_accounts_receivable_paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivable_paymentsMouseClicked
        // TODO add your handling code here:
        select_accounts_receivable_payments();
    }//GEN-LAST:event_tbl_accounts_receivable_paymentsMouseClicked

    private void tf_ap_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ap_check_noActionPerformed
        add_ar_payment();
    }//GEN-LAST:event_tf_ap_check_noActionPerformed

    private void tf_trust_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_trust_receiptActionPerformed
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            add_accounts_receivable();
        } else {
            edit_accounts_receivable();
        }
    }//GEN-LAST:event_tf_trust_receiptActionPerformed

    private void tf_ci_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ci_noActionPerformed
        tf_trust_receipt.grabFocus();
    }//GEN-LAST:event_tf_ci_noActionPerformed

    private void tf_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_paidActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        edit_accounts_receivable();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        add_accounts_receivable();
    }//GEN-LAST:event_btn_addActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear_accounts_receivable();
        init_ar_no();
        btn_add.setEnabled(true);
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row >= 0) {
            tbl_accounts_receivable.removeRowSelectionInterval(row, row);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_accounts_receivable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data_cols2();
    }//GEN-LAST:event_jCheckBox2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JLabel btn_add1;
    private javax.swing.JButton btn_delete;
    private javax.swing.JLabel btn_delete1;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel btn_edit1;
    private javax.swing.JLabel btn_new1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_balance;
    private javax.swing.JLabel lbl_credit_limit;
    private javax.swing.JTable tbl_accounts_receivable;
    private javax.swing.JTable tbl_accounts_receivable_payments;
    private javax.swing.JTable tbl_total_payments;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_ap_cash;
    private javax.swing.JTextField tf_ap_check_amount;
    private javax.swing.JTextField tf_ap_check_bank;
    private javax.swing.JTextField tf_ap_check_holder;
    private javax.swing.JTextField tf_ap_check_no;
    private javax.swing.JTextField tf_ap_day;
    private javax.swing.JTextField tf_ap_month;
    private javax.swing.JTextField tf_ap_year;
    private javax.swing.JTextField tf_ar_day;
    private javax.swing.JTextField tf_ar_month;
    private javax.swing.JLabel tf_ar_no;
    private javax.swing.JTextField tf_ar_year;
    private javax.swing.JTextField tf_ci_no;
    private javax.swing.JLabel tf_customer_id;
    private javax.swing.JLabel tf_customer_name;
    private javax.swing.JTextField tf_or_payment_no;
    private javax.swing.JTextField tf_paid;
    private javax.swing.JTextField tf_search_customer;
    private javax.swing.JTextField tf_term;
    private javax.swing.JTextField tf_trust_receipt;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        init_key();
        init_tbl_accounts_receivable();
        init_search();
        init_ar_no();
        focus();
        enable_ar(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        init_focus();
        init_tbl_accounts_receivable_payments();
        setEmployeeTableModel();
        tf_ci_no.setVisible(false);
        tf_trust_receipt.setVisible(false);
    }

    private void focus() {
        JTextField[] tf = {tf_search_customer, tf_ar_month, tf_ar_day, tf_ar_year, tf_amount, tf_term, tf_ap_month, tf_ap_day, tf_ap_year, tf_ap_cash, tf_ap_check_bank, tf_ap_check_holder, tf_ap_check_amount, tf_ap_check_no, tf_ci_no, tf_trust_receipt, tf_paid, jTextField1};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_focus() {
        Focus_Fire.nextFocus(tf_ap_month, tf_ap_day);
        Focus_Fire.nextFocus(tf_ap_day, tf_ap_year);
        Focus_Fire.nextFocus(tf_ap_year, tf_ap_cash);
        Focus_Fire.nextFocus(tf_ap_cash, tf_ap_check_bank);
        Focus_Fire.nextFocus(tf_ap_check_bank, tf_ap_check_holder);
        Focus_Fire.nextFocus(tf_ap_check_holder, tf_ap_check_amount);
        Focus_Fire.nextFocus(tf_ap_check_amount, tf_ap_check_no);

    }

    private void init_ar_no() {
        tf_ar_no.setText(S1_accounts_receivable.increment_id());
    }

    private void enable_ar(boolean stmt) {
        tf_ar_month.setEnabled(stmt);
        tf_ar_day.setEnabled(stmt);
        tf_ar_year.setEnabled(stmt);
        tf_amount.setEnabled(stmt);
        tf_term.setEnabled(stmt);
//        btn_new.setEnabled(stmt);
//        btn_add.setEnabled(stmt);
//        btn_edit.setEnabled(stmt);
        btn_delete.setEnabled(stmt);
    }

    private void init_search() {
        testOfFaith.set(tf_ar_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_ar_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_ar_year, DateType.listYear(), "Year");
        testOfFaith.set(tf_term, S1_terms.ret_cb_data(), "TERM");

        testOfFaith.set(tf_ap_month, DateType.listMonths(), "Month");
        testOfFaith.set(tf_ap_day, DateType.listDays(), "Day");
        testOfFaith.set(tf_ap_year, DateType.listYear(), "Year");
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
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F1, new KeyAction() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tf_search_customer.grabFocus();
                    }
                });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F2, new KeyAction() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                        if (!tbl_accounts_receivable_ALM.isEmpty()) {
                            tbl_accounts_receivable.setRowSelectionInterval(0, 0);
                            tbl_accounts_receivable.grabFocus();
                        }
                    }
                });

        tbl_accounts_receivable.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    data_cols_ar_payments();
                    tf_ap_month.grabFocus();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    data_cols_ar_payments();
                    e.consume();
                }
            }
        });

    }
    // </editor-fold>

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        if (lbl.isEnabled()) {
            lbl.setBackground(new java.awt.Color(51, 102, 0));
            lbl.setForeground(new java.awt.Color(0, 0, 0));
        }

    }

    private void exit2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }
    List<Customers.to_customers> customer_list = new ArrayList();

    private void init_popup() {

        String search = tf_search_customer.getText();
        customer_list.clear();
        customer_list = Customers.ret_data(search);
        Object[][] obj = new Object[customer_list.size()][4];
        int i = 0;
        for (Customers.to_customers to : customer_list) {
            obj[i][0] = to.customer_no;
            obj[i][1] = to.first_name + " " + to.last_name;
            obj[i][2] = FitIn.fmt_wc_0(to.credit_limit);
            obj[i][3] = FitIn.fmt_wc_0(to.balance);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 100, 0, 100};
        String[] col_names = {"ID", "NAME", "CREDIT LIMIT", "BALANCE"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_search_customer, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_id.setText(""+to.id);
                tf_customer_name.setText(to.first_name + " " + to.last_name);
                lbl_credit_limit.setText(FitIn.fmt_wc_0(to.credit_limit));
                lbl_balance.setText(FitIn.fmt_wc_0(to.balance));
                tf_term.setText(FitIn.fmt_woc(to.term));
                tbl_accounts_receivable_payments_ALM.clear();
                tbl_accounts_receivable_payments_M.fireTableDataChanged();
                data_cols();
                enable_ar(true);
                tf_ar_month.grabFocus();
            }
        });
    }

    String customer_address = "";
    int selected_row = 0;
    private ArrayListModel tbl_accounts_receivable_ALM;
    private Tblaccounts_receivableModel tbl_accounts_receivable_M;

    private void init_tbl_accounts_receivable() {
        tbl_accounts_receivable_ALM = new ArrayListModel();
        tbl_accounts_receivable_M = new Tblaccounts_receivableModel(tbl_accounts_receivable_ALM);
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable.setModel(tbl_accounts_receivable_M);
        tbl_accounts_receivable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable.setRowHeight(25);
        int[] tbl_widths_accounts_receivable = {100, 0, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 0 || i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable, i, tbl_widths_accounts_receivable[i]);
        }
        Dimension d = tbl_accounts_receivable.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable.setRowHeight(25);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable, 5);
    }

    private void loadData_accounts_receivable(List<to_accounts_receivable> acc) {
        tbl_accounts_receivable_ALM.clear();
        tbl_accounts_receivable_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Trust Receipt", "Date", "Term", "Amount", "Balance", "user_name", "amount", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type"
        };

        public Tblaccounts_receivableModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            to_accounts_receivable tt = (to_accounts_receivable) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.or_no;
                case 1:
                    return " " + tt.trust_receipt;
                case 2:
                    return " " + DateType.convert_dash_date2(tt.date_applied);
                case 3:
                    return " " + FitIn.fmt_woc(tt.term) + " Day/s";
                case 4:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.amount - tt.paid) + " ";
                case 6:
                    return tt.user_name;
                case 7:
                    return tt.amount;
                case 8:
                    return tt.discount_amount;
                case 9:
                    return tt.discount_rate;
                case 10:
                    return tt.discount;
                case 11:
                    return tt.status;
                case 12:
                    return tt.term;
                case 13:
                    return tt.date_applied;
                case 14:
                    return tt.paid;
                case 15:
                    return tt.date_paid;
                case 16:
                    return tt.remarks;
                case 17:
                    return tt.type;
                default:
                    return tt.or_no;
            }
        }
    }

    private void data_cols() {
        String search = tf_customer_id.getText();
        String where = " where customer_id='" + search + "' order by Date(date_applied) asc";
        loadData_accounts_receivable(S1_accounts_receivable.ret_data5(where));
        compute_ar_balance();
    }

    private void data_cols2() {
        String where = "";
        if (jCheckBox1.isSelected()) {
            where = " where ci_no like '%" + jTextField1.getText() + "%' ";
        }
        if (jCheckBox2.isSelected()) {
            where = " where trust_receipt like '%" + jTextField1.getText() + "%' ";
        }

        if (jCheckBox3.isSelected()) {
            where = " where customer_id='" + tf_customer_id.getText() + "' ";
        }
        loadData_accounts_receivable(S1_accounts_receivable.ret_data3(where));
        compute_ar_balance();
    }

    private void add_accounts_receivable() {
        int id = -1;
        String customer_id = tf_customer_id.getText();
        String customer_name = tf_customer_name.getText();
        String ar_no = S1_accounts_receivable.increment_id();
        String date_added = DateType.now();
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_amount.getText());
        double discount_amount = 0;// FitIn.toDouble(tf_discount_amount.getText();
        double discount_rate = 0;//FitIn.toDouble(tf_discount_rate.getText();
        String discount = "";//tf_discount.getText();
        int status = 0;// FitIn.toInt(tf_status.getText());
        double term = FitIn.toDouble(tf_term.getText());
        String date_applied = tf_ar_month.getText() + " " + tf_ar_day.getText() + ", " + tf_ar_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = date_applied;
        String remarks = "";// tf_remarks.getText();
        String type = "AR";//tf_type.getText();
        String or_no = "";//tf_or_no.getText();
        String ci_no = tf_ci_no.getText();//tf_or_no.getText();
        String trust_receipt = tf_trust_receipt.getText();//tf_or_no.getText();
        to_accounts_receivable to = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt);
        S1_accounts_receivable.add_accounts_receivable(to);
        data_cols();
        clear_accounts_receivable();
        init_ar_no();

        tf_ar_month.grabFocus();
        Alert.set(1, type);
    }

    private void compute_ar_balance() {
        List<to_accounts_receivable> datas = tbl_accounts_receivable_ALM;
        double total = 0;
        for (to_accounts_receivable to : datas) {
            total += to.amount - to.paid;
        }
        lbl_balance.setText(FitIn.fmt_wc_0(total));
    }

    private void select_accounts_receivable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));

        tf_customer_id.setText(to.customer_id);
        tf_customer_name.setText(to.customer_name);
        tf_ar_no.setText(to.ar_no);
        tf_amount.setText(FitIn.fmt_wc_0(to.amount));
        tf_term.setText(FitIn.fmt_woc(to.term));
        tf_ci_no.setText(to.ci_no);
        tf_trust_receipt.setText(to.trust_receipt);
        tf_paid.setText(FitIn.fmt_wc_0(to.paid));
        Date d = new Date();
        try {
            d = DateType.sf.parse(to.date_applied);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_encoding.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String month = DateType.m.format(d);
        String day = DateType.d.format(d);
        String year = DateType.y.format(d);
        tf_ar_month.setText(month);
        tf_ar_day.setText(day);
        tf_ar_year.setText(year);
        btn_add.setEnabled(false);
        btn_edit.setEnabled(true);
        btn_delete.setEnabled(true);

        data_cols_ar_payments();

    }

    private void edit_accounts_receivable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        int id = to.id;
        String customer_id = tf_customer_id.getText();
        String customer_name = tf_customer_name.getText();
        String ar_no = tf_ar_no.getText();
        String date_added = DateType.now();
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_amount.getText());
        double discount_amount = 0;// FitIn.toDouble(tf_discount_amount.getText();
        double discount_rate = 0;//FitIn.toDouble(tf_discount_rate.getText();
        String discount = "";//tf_discount.getText();
        int status = 0;// FitIn.toInt(tf_status.getText());
        double term = FitIn.toDouble(tf_term.getText());
        String date_applied = tf_ar_month.getText() + " " + tf_ar_day.getText() + ", " + tf_ar_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = FitIn.toDouble(tf_paid.getText());
        String date_paid = date_applied;
        String remarks = "";// tf_remarks.getText();
        String type = "AR";//tf_type.getText();
        String or_no = "";//tf_or_no.getText();
        String ci_no = tf_ci_no.getText();//tf_or_no.getText();
        String trust_receipt = tf_trust_receipt.getText();//tf_or_no.getText();
        to_accounts_receivable to1 = new to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt);

        S1_accounts_receivable.edit_accounts_receivable(to1, to.amount, to1.paid);

        data_cols();
        tbl_accounts_receivable.setRowSelectionInterval(row, row);
        data_cols_ar_payments();
        clear_accounts_receivable();
        Alert.set(2, "");

    }

    private void clear_accounts_receivable() {
        tf_paid.setText("");
        tf_amount.setText("");
        tf_term.setText("");
        tf_ci_no.setText("");
        tf_trust_receipt.setText("");

        tf_ar_month.setText("");
        tf_ar_day.setText("");
        tf_ar_year.setText("");

    }

    private void delete_accounts_receivable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        S1_accounts_receivable.delete_accounts_receivable(to);
        data_cols();
        tbl_accounts_receivable_payments_ALM.clear();
        tbl_accounts_receivable_payments_M.fireTableDataChanged();
        setEmployeeTableModel();
        clear_accounts_receivable();
        Alert.set(3, "");
    }
    private ArrayListModel tbl_accounts_receivable_payments_ALM;
    private Tblaccounts_receivable_paymentsModel tbl_accounts_receivable_payments_M;

    private void init_tbl_accounts_receivable_payments() {
        tbl_accounts_receivable_payments_ALM = new ArrayListModel();
        tbl_accounts_receivable_payments_M = new Tblaccounts_receivable_paymentsModel(tbl_accounts_receivable_payments_ALM);
        tbl_accounts_receivable_payments.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_accounts_receivable_payments.setModel(tbl_accounts_receivable_payments_M);
        tbl_accounts_receivable_payments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_accounts_receivable_payments.setRowHeight(25);
        int[] tbl_widths_accounts_receivable_payments = {100, 100, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable_payments.length; i < n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable_payments, i, tbl_widths_accounts_receivable_payments[i]);
        }
        Dimension d = tbl_accounts_receivable_payments.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_accounts_receivable_payments.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable_payments.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable_payments.setRowHeight(25);
        tbl_accounts_receivable_payments.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_accounts_receivable_payments, 3);
    }

    private void loadData_accounts_receivable_payments(List<to_accounts_receivable_payments> acc) {
        tbl_accounts_receivable_payments_ALM.clear();
        tbl_accounts_receivable_payments_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivable_paymentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "OR #", "Check", "Cash", "date_added", "user_name", "amount", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type", "or_no", "prev_balance"
        };

        public Tblaccounts_receivable_paymentsModel(ListModel listmodel) {
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
            to_accounts_receivable_payments tt = (to_accounts_receivable_payments) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_dash_date2(tt.date_applied);
                case 1:
                    return " " + tt.or_payment_no;
                case 2:
                    return FitIn.fmt_wc_0(tt.check_amount) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 4:
                    return tt.date_added;
                case 5:
                    return tt.user_name;
                case 6:
                    return tt.amount;
                case 7:
                    return tt.discount_amount;
                case 8:
                    return tt.discount_rate;
                case 9:
                    return tt.discount;
                case 10:
                    return tt.status;
                case 11:
                    return tt.term;
                case 12:
                    return tt.date_applied;
                case 13:
                    return tt.paid;
                case 14:
                    return tt.date_paid;
                case 15:
                    return tt.remarks;
                case 16:
                    return tt.type;
                case 17:
                    return tt.or_no;
                default:
                    return tt.prev_balance;
            }
        }
    }

    private void data_cols_ar_payments() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        loadData_accounts_receivable_payments(S1_accounts_receivable_payments.ret_data(to.ar_no));

        setEmployeeTableModel();
    }

    private void add_ar_payment() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        String customer_id = to.customer_id;
        String customer_name = to.customer_name;
        String ar_no = to.ar_no;
        String date_added = DateType.datetime.format(new Date());
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_ap_cash.getText());
        double discount_amount = 0;
        double discount_rate = 0;
        String discount = "";
        int status = 0;
        double term = 0;
        String date_applied = tf_ap_month.getText() + " " + tf_ap_day.getText() + ", " + tf_ap_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = DateType.sf.format(new Date());
        String remarks = "";
        String type = "CASH";
        String or_no = to.or_no;
        double prev_balance = 0;
        double check_amount = FitIn.toDouble(tf_ap_check_amount.getText());
        String check_holder = tf_ap_check_holder.getText();
        String check_bank = tf_ap_check_bank.getText();
        String check_no = tf_ap_check_no.getText();
        String ci_no = to.ci_no;//tf_or_no.getText();
        String trust_receipt = to.trust_receipt;//tf_or_no.getText();
        String or_payment_no = tf_or_payment_no.getText();
        S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no);
        S1_accounts_receivable_payments.add_accounts_receivable_payments(to1);
        int row1 = tbl_accounts_receivable.getSelectedRow();
        int i = tbl_accounts_receivable.getSelectedRow();
        data_cols();

        tbl_accounts_receivable.setRowSelectionInterval(i, i);
        data_cols_ar_payments();

        clear_accounts_receivable_payments();
        tf_ap_month.grabFocus();
        Alert.set(1, type);
    }

    private void select_accounts_receivable_payments() {
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));

        tf_ap_cash.setText(FitIn.fmt_wc_0(to.amount));
        tf_ap_check_amount.setText(FitIn.fmt_wc_0(to.check_amount));
        tf_ap_check_holder.setText(to.check_holder);
        tf_ap_check_bank.setText(to.check_bank);
        tf_ap_check_no.setText(to.check_no);
        tf_or_payment_no.setText(to.or_payment_no);
        Date d = new Date();
        try {
            d = DateType.sf.parse(to.date_applied);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_ar_encoding.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String month = DateType.m.format(d);
        String day = DateType.d.format(d);
        String year = DateType.y.format(d);
        tf_ap_month.setText(month);
        tf_ap_day.setText(day);
        tf_ap_year.setText(year);
        btn_add1.setEnabled(false);
        btn_edit1.setEnabled(true);
        btn_delete1.setEnabled(true);
    }

    private void edit_accounts_receivable_payments() {
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
        int id = to.id;
        String customer_id = to.customer_id;
        String customer_name = to.customer_name;
        String ar_no = to.ar_no;
        String date_added = DateType.datetime.format(new Date());
        String user_name = Users.user_name;
        double amount = FitIn.toDouble(tf_ap_cash.getText());
        double discount_amount = 0;
        double discount_rate = 0;
        String discount = "";
        int status = 0;
        double term = 0;
        String date_applied = tf_ap_month.getText() + " " + tf_ap_day.getText() + ", " + tf_ap_year.
                getText();
        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = DateType.sf.format(new Date());
        String remarks = "";
        String type = "CASH";
        String or_no = to.or_no;
        double prev_balance = 0;
        double check_amount = FitIn.toDouble(tf_ap_check_amount.getText());
        String check_holder = tf_ap_check_holder.getText();
        String check_bank = tf_ap_check_bank.getText();
        String check_no = tf_ap_check_no.getText();
        String ci_no = to.ci_no;//tf_or_no.getText();
        String trust_receipt = to.trust_receipt;//tf_or_no.getText();
        String or_payment_no = tf_or_payment_no.getText();
        S1_accounts_receivable_payments.to_accounts_receivable_payments to1 = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no);
        double previous_cash = to.amount;
        double previous_check = to.check_amount;
        S1_accounts_receivable_payments.edit_accounts_receivable_payments(to1, previous_cash, previous_check);
        int i = tbl_accounts_receivable.getSelectedRow();
        data_cols();

        tbl_accounts_receivable.setRowSelectionInterval(i, i);
        data_cols_ar_payments();

        Alert.set(2, type);
        clear_accounts_receivable_payments();
    }

    private void clear_accounts_receivable_payments() {
        tf_ap_cash.setText("");
        tf_ap_month.setText("");
        tf_ap_day.setText("");
        tf_ap_year.setText("");
        tf_ap_check_bank.setText("");
        tf_ap_check_holder.setText("");
        tf_ap_check_amount.setText("");
        tf_ap_check_no.setText("");

    }

    private void delete_accounts_receivable_payments() {
        int row = tbl_accounts_receivable_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable_payments to = (to_accounts_receivable_payments) tbl_accounts_receivable_payments_ALM.
                get(tbl_accounts_receivable_payments.convertRowIndexToModel(row));
        S1_accounts_receivable_payments.delete_accounts_receivable_payments(to);
        int i = tbl_accounts_receivable.getSelectedRow();
        data_cols();
        tbl_accounts_receivable.setRowSelectionInterval(i, i);
        data_cols_ar_payments();
        clear_accounts_receivable_payments();
        Alert.set(3, "");

    }

    private void customers() {
        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void ar_aging() {
        Window p = (Window) this;
        Dlg_ar_aging nd = Dlg_ar_aging.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_ar_aging.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_aging.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void customer_balances() {
        Window p = (Window) this;
        Dlg_customer_balances nd = Dlg_customer_balances.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_customer_balances.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_balances.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ar_ledger() {
        Window p = (Window) this;
        Dlg_ar_ledger nd = Dlg_ar_ledger.create(p, true);
        nd.setTitle("");
        Customers.to_customers to = customer_list.get(selected_row);
        nd.do_pass(to.customer_no, to.customer_name, to.address);
        nd.setCallback(new Dlg_ar_ledger.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_ledger.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void setEmployeeTableModel() {

        double cash = 0;
        double check = 0;

        List<to_accounts_receivable_payments> datas = tbl_accounts_receivable_payments_ALM;
        for (to_accounts_receivable_payments to : datas) {
            cash += to.amount;
            check += to.check_amount;

        }

        Object[][] obj = new Object[0][12];
        String[] col_names = {"", "", FitIn.fmt_wc_0(check), FitIn.fmt_wc_0(cash)};
        myModel(tbl_total_payments, obj, col_names);
        int[] tbl_widths_accounts_receivable = {100, 100, 80, 80};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 0 | i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_total_payments, i, tbl_widths_accounts_receivable[i]);
        }
        tbl_total_payments.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_total_payments.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void myModel(JTable tbl, Object[][] obj, String[] col_names) {
        tbl.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                col_names) {

                    boolean[] canEdit = new boolean[]{
                        false, false, false, false, false, false, false, false
                    };

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });

        tbl.setRowHeight(30);
        tbl.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl, 1);
        TableWidthUtilities.setColumnRightRenderer(tbl, 2);
    }
}
