/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.banks.S1_banks;
import POS.check_holders.S1_check_holders;
import POS.customers.Customers;
import POS.discount_customers.S1_discount_customers;
import POS.discounts.S1_discounts;
import POS.main.Main;
import POS.services.S1_sales_services;
import POS.services.S1_services;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.SearchField;

/**
 *
 * @author i1
 */
public class Dlg_pay extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_pay
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

        public final S1_sales.to_sales to_sales;
        public final double change;
        public final List<S1_sales_services.to_sales_services> my_services;

        public OutputData(S1_sales.to_sales to_sales, double change, List<S1_sales_services.to_sales_services> my_services) {
            this.to_sales = to_sales;
            this.change = change;
            this.my_services = my_services;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_pay(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_pay(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_pay() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_pay myRef;

    private void setThisRef(Dlg_pay myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_pay> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_pay create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_pay create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_pay dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_pay((java.awt.Frame) parent, false);
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
            Dlg_pay dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_pay((java.awt.Dialog) parent, false);
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

        Dlg_pay dialog = Dlg_pay.create(new javax.swing.JFrame(), true);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tf_amount_paid = new javax.swing.JTextField();
        lbl_change = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnl_id_no = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_name = new SearchField();
        jLabel11 = new javax.swing.JLabel();
        tf_id_no = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_discount = new SearchField();
        lbl_discount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_discount_amount = new javax.swing.JTextField();
        pnl_check = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tf_check_holder = new SearchField();
        jLabel15 = new javax.swing.JLabel();
        tf_check_no = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_check_bank = new SearchField();
        jLabel8 = new javax.swing.JLabel();
        tf_check_amount = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbl_net_due = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbl_amount_due = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tf_services = new javax.swing.JTextField();
        lbl_service_total = new javax.swing.JLabel();
        tf_service_amount = new javax.swing.JTextField();

        jPopupMenu1.setFocusable(false);
        jPopupMenu1.setPreferredSize(new java.awt.Dimension(100, 72));

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(213, 250, 201));

        tf_amount_paid.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tf_amount_paid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_amount_paid.setNextFocusableComponent(tf_service_amount);
        tf_amount_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amount_paidActionPerformed(evt);
            }
        });
        tf_amount_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_amount_paidKeyReleased(evt);
            }
        });

        lbl_change.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_change.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_change.setText("0.00");
        lbl_change.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_change.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CHANGE:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TENDERED:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_amount_paid)
                    .addComponent(lbl_change, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_amount_paid)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_change, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_id_no.setBackground(new java.awt.Color(153, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("NAME:");

        tf_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_name.setNextFocusableComponent(tf_id_no);
        tf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("NO:");

        tf_id_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_id_no.setNextFocusableComponent(tf_customer_name);
        tf_id_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id_noActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DISCOUNT:");

        tf_discount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount.setNextFocusableComponent(lbl_discount_amount);
        tf_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discountActionPerformed(evt);
            }
        });

        lbl_discount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_discount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_discount.setText("0.00");
        lbl_discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("%");

        lbl_discount_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_discount_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbl_discount_amount.setText("0.00");
        lbl_discount_amount.setNextFocusableComponent(tf_name);
        lbl_discount_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_discount_amountActionPerformed(evt);
            }
        });
        lbl_discount_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_discount_amountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnl_id_noLayout = new javax.swing.GroupLayout(pnl_id_no);
        pnl_id_no.setLayout(pnl_id_noLayout);
        pnl_id_noLayout.setHorizontalGroup(
            pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_id_noLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_name)
                    .addComponent(tf_discount))
                .addGap(18, 18, 18)
                .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_id_noLayout.createSequentialGroup()
                        .addComponent(lbl_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_id_noLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_id_no, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_id_noLayout.setVerticalGroup(
            pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_id_noLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_id_noLayout.createSequentialGroup()
                        .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_discount_amount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_id_no, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_id_noLayout.createSequentialGroup()
                        .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnl_id_noLayout.createSequentialGroup()
                                .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(pnl_id_noLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnl_check.setBackground(new java.awt.Color(153, 204, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("NAME:");

        tf_check_holder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_holder.setNextFocusableComponent(tf_check_no);
        tf_check_holder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_holderActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("NO:");

        tf_check_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_no.setNextFocusableComponent(tf_amount_paid);
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CHECK:");

        tf_check_bank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_bank.setNextFocusableComponent(tf_check_amount);
        tf_check_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_bankActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("AMOUNT:");

        tf_check_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_amount.setNextFocusableComponent(tf_check_holder);
        tf_check_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_amountActionPerformed(evt);
            }
        });
        tf_check_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_check_amountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnl_checkLayout = new javax.swing.GroupLayout(pnl_check);
        pnl_check.setLayout(pnl_checkLayout);
        pnl_checkLayout.setHorizontalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_check_bank)
                    .addComponent(tf_check_holder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_check_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(tf_check_no))
                .addContainerGap())
        );
        pnl_checkLayout.setVerticalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_check_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_check_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        lbl_net_due.setBackground(new java.awt.Color(255, 255, 255));
        lbl_net_due.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_net_due.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_net_due.setText("0.00");
        lbl_net_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_net_due.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("NET DUE:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Customer:");

        tf_customer_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_customer_name.setNextFocusableComponent(tf_customer_id);
        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        tf_customer_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_customer_id.setNextFocusableComponent(tf_check_bank);
        tf_customer_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));

        lbl_amount_due.setBackground(new java.awt.Color(255, 255, 255));
        lbl_amount_due.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_amount_due.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_amount_due.setText("0.00");
        lbl_amount_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_amount_due.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("AMOUNT DUE:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_amount_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_amount_due, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SERVICES:");

        tf_services.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_servicesActionPerformed(evt);
            }
        });

        lbl_service_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_service_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_service_total.setText("0.00");
        lbl_service_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_service_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_service_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_service_amount.setNextFocusableComponent(tf_discount);
        tf_service_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_service_amountActionPerformed(evt);
            }
        });
        tf_service_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_service_amountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_services, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_service_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_service_total, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_service_amount)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_service_total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_services, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_id_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_id_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_check, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_amount_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount_paidKeyReleased
        payment();
    }//GEN-LAST:event_tf_amount_paidKeyReleased

    private void tf_amount_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount_paidActionPerformed
        ok1();
    }//GEN-LAST:event_tf_amount_paidActionPerformed

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers(tf_customer_name, tf_customer_id);
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_check_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_amountActionPerformed
        // TODO add your handling code here:
        tf_check_holder.grabFocus();
    }//GEN-LAST:event_tf_check_amountActionPerformed

    private void tf_check_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_bankActionPerformed

    private void tf_check_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_check_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_amountKeyReleased

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameActionPerformed

    private void tf_id_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id_noActionPerformed
        // TODO add your handling code here:
        tf_amount_paid.grabFocus();
    }//GEN-LAST:event_tf_id_noActionPerformed

    private void tf_check_holderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_holderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_holderActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        // TODO add your handling code here:
        payment();
        tf_amount_paid.grabFocus();
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void lbl_discount_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_discount_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_discount_amountKeyReleased

    private void lbl_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_discount_amountActionPerformed
        // TODO add your handling code here:
        compute_discount();
        tf_name.grabFocus();
    }//GEN-LAST:event_lbl_discount_amountActionPerformed

    private void tf_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_servicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_servicesActionPerformed

    private void tf_service_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_service_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_service_amountActionPerformed

    private void tf_service_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_service_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_service_amountKeyReleased

    private void tf_customer_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_customer_idActionPerformed

    private void tf_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_discountActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbl_amount_due;
    private javax.swing.JLabel lbl_change;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JTextField lbl_discount_amount;
    private javax.swing.JLabel lbl_net_due;
    private javax.swing.JLabel lbl_service_total;
    private javax.swing.JPanel pnl_check;
    private javax.swing.JPanel pnl_id_no;
    private javax.swing.JTextField tf_amount_paid;
    private javax.swing.JTextField tf_check_amount;
    private javax.swing.JTextField tf_check_bank;
    private javax.swing.JTextField tf_check_holder;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_id_no;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_service_amount;
    private javax.swing.JTextField tf_services;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        init_key();
        init_discount();
        tf_amount_paid.grabFocus();
        init_tf();
        focus();
        tf_services.enable(false);
        amount_due1 = 1500;
        lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due1));
        lbl_net_due.setText(FitIn.fmt_wc_0(amount_due1));
    }

    public void do_pass2(String amount){
        tf_amount_paid.setText(amount);
    }
    private void focus() {
        JTextField[] tf = {tf_service_amount, tf_services, tf_discount, tf_name, tf_id_no, tf_customer_name, tf_check_bank, tf_check_amount, tf_check_holder, tf_check_no, tf_amount_paid, lbl_discount_amount};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_tf() {

        final SearchField sf2 = (SearchField) tf_check_bank;
        sf2.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf2.set_instruction1("SELECT BANK");
        sf2.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return S1_banks.ret_cb_data();
            }
        });
        sf2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (sf2.getText().
                        isEmpty()) {
                    tf_check_amount.setText("");
                    tf_check_no.setText("");
                    tf_check_holder.setText("");
                    payment();
                    tf_amount_paid.grabFocus();
//                    pnl_check.setVisible(false);
                } else {
//                    pnl_check.setVisible(true);
                    tf_check_amount.grabFocus();
                }

            }
        });

        final SearchField sf3 = (SearchField) tf_name;
        sf3.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf3.set_instruction1("SEARCH NAME");
        sf3.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return S1_discount_customers.ret_cb_data();
            }
        });
        sf3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                S1_discount_customers.to_discount_customers to = S1_discount_customers.
                        ret_id_no(sf3.getText());
                if (to == null) {
                    tf_id_no.setText("");
                    tf_id_no.grabFocus();
                } else {
                    if (sf3.getText().
                            isEmpty()) {
                        tf_id_no.setText("");
                    } else {
                        tf_id_no.setText(to.id_no);
                    }

                    tf_id_no.grabFocus();
                }

            }
        });

        final SearchField sf4 = (SearchField) tf_check_holder;
        sf4.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf4.set_instruction1("SEARCH NAME");
        sf4.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return S1_discount_customers.ret_cb_data();
            }
        });
        sf4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                S1_check_holders.to_check_holders to = S1_check_holders.
                        ret_id_no(sf4.getText());
                if (to == null) {
                    tf_check_no.setText("");
                    tf_check_no.grabFocus();
                } else {
                    if (sf4.getText().
                            isEmpty()) {
                        tf_check_no.setText("");
                    } else {
                        tf_check_no.setText(to.holder_no);
                    }
                    tf_check_no.grabFocus();
                }

            }
        });

    }

    private void init_discount() {
        final SearchField sf2 = (SearchField) tf_discount;
        sf2.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf2.set_instruction1("Select Discount");
        sf2.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return S1_discounts.ret_cb_data();
            }
        });
        sf2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                get_discount();
                lbl_discount_amount.grabFocus();
            }
        });

    }

    private void get_discount() {
        String discount_name = tf_discount.getText();
        S1_discounts.to_discounts to = S1_discounts.ret_data2(discount_name);
        if (to == null) {
        } else {
            lbl_discount.setText(FitIn.fmt_wc_0(to.discount_rate));
            double discount = to.discount_rate;
            double due = FitIn.toDouble(lbl_amount_due.getText());
            double disc_amount = discount / 100;
            disc_amount = due * disc_amount;
//            double check = FitIn.toDouble(tf_check_amount.getText());
            lbl_discount_amount.setText(FitIn.fmt_wc_0(disc_amount));
//            lbl_net_due.setText(FitIn.fmt_wc_0((amount_due1) - (disc_amount + check)));
//            System.out.println(disc_amount + " asdad");
//            double tendered = FitIn.toDouble(lbl_net_due.getText());
//            double change = tendered - FitIn.toDouble(lbl_net_due.getText());
//            lbl_change.setText(FitIn.fmt_wc_0(change));
//            pnl_id_no.setVisible(true);
        }
        if (discount_name.isEmpty()) {
            lbl_discount.setText("0.00");
            lbl_discount_amount.setText("0.00");
            tf_name.setText("");
            tf_id_no.setText("");
//            pnl_id_no.setVisible(false);
        }
    }

    private void compute_discount() {

        double discount = FitIn.toDouble(lbl_discount.getText());
        double due = FitIn.toDouble(lbl_amount_due.getText());
        double disc_amount = FitIn.toDouble(lbl_discount_amount.getText());
        double check = FitIn.toDouble(tf_check_amount.getText());
        double service = FitIn.toDouble(tf_service_amount.getText());
//        lbl_discount_amount.setText(FitIn.fmt_wc_0(disc_amount));
        lbl_net_due.setText(FitIn.fmt_wc_0((amount_due1 + service) - (disc_amount)));
//        System.out.println(disc_amount + " asdad");
//        double tendered = FitIn.toDouble(lbl_net_due.getText());
//        double change = tendered - FitIn.toDouble(lbl_net_due.getText());
//        lbl_change.setText(FitIn.fmt_wc_0(change));
    }

    private void compute_services() {

        double discount = FitIn.toDouble(lbl_discount.getText());
        double due = FitIn.toDouble(lbl_amount_due.getText());
        double disc_amount = FitIn.toDouble(lbl_discount_amount.getText());
        double check = FitIn.toDouble(tf_check_amount.getText());
        double service = FitIn.toDouble(tf_service_amount.getText());
//        lbl_discount_amount.setText(FitIn.fmt_wc_0(disc_amount));
        lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due1 + service));
        lbl_net_due.setText(FitIn.fmt_wc_0((amount_due1 + service) - (disc_amount + check)));
        System.out.println(disc_amount + " asdad");
        double tendered = FitIn.toDouble(lbl_net_due.getText());
        double change = tendered - FitIn.toDouble(lbl_net_due.getText());
        lbl_change.setText(FitIn.fmt_wc_0(change));
    }

    private void payment() {
        double discount = FitIn.toDouble(lbl_discount.getText());
        double due = FitIn.toDouble(lbl_net_due.getText());
        double disc_amount = discount / 100;
//        disc_amount = due * disc_amount;

        double check_amount = FitIn.toDouble(tf_check_amount.getText());
        double service = FitIn.toDouble(tf_service_amount.getText());

        double tendered = (FitIn.toDouble(tf_amount_paid.getText()) + check_amount);
        double change = tendered - FitIn.toDouble(lbl_net_due.getText());
        lbl_change.setText(FitIn.fmt_wc_0(change));
    }
    String sales_no1 = "";
    double amount_due1 = 0;

    String customer_name1 = "";
    String customer_id1 = "";
    String transaction_type1 = "";
    String transaction_type_id1 = "";
    String payment_type1 = "";
    String payment_type_id1 = "";
    String vehicle_name1 = "";
    String vehicle_id1 = "";
    String driver_name1 = "";
    String driver_id1 = "";
    int status1 = 0;
    String customer_address1="";
    String customer_contact_no1="";
    public void do_pass(String sales_no, double amount_due, String customer_name, String customer_id, String transaction_type
            , String transaction_type_id, String payment_type, String payment_type_id, String vehicle_name, String vehicle_id
            , String driver_name, String driver_id, int status,String customer_address,String customer_contact_no) {
        customer_contact_no1=customer_contact_no;
        customer_address1=customer_address;
        sales_no1 = sales_no;
        amount_due1 = amount_due;
        status1 = status;
        services.clear();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                lbl_net_due.setText(FitIn.fmt_wc_0(amount_due1));
                lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due1));
                tf_amount_paid.setText(FitIn.fmt_wc_0(amount_due1));
                payment();
            }
        });

        tf_amount_paid.grabFocus();
        tf_customer_name.setText(customer_name);
        tf_customer_id.setText(customer_id);
        customer_name1 = customer_name;
        customer_id1 = customer_id;
        transaction_type1 = transaction_type;
        transaction_type_id1 = transaction_type_id;
        payment_type1 = payment_type;
        payment_type_id1 = payment_type_id;
        vehicle_name1 = vehicle_name;
        vehicle_id1 = vehicle_id;
        driver_name1 = driver_name;
        driver_id1 = driver_id;

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
                              KeyEvent.VK_F4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_service_amount.grabFocus();

            }
        });
        tf_service_amount.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    services();
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_discount.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F6, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_customer_name.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F7, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_check_bank.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F8, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                tf_amount_paid.grabFocus();
            }
        });
    }
    // </editor-fold>

    private void ok1() {
        if (callback != null) {
            int id = -1;
            String sales_no = sales_no1;
            String date_added = DateType.datetime.format(new Date());
            String user_name = Users.user_name;
            String session_no = Users.session_no;
            double gross_amount = amount_due1;
            double amount_paid = FitIn.toDouble(tf_amount_paid.getText());
            double amount_due = amount_due1;
            String discount_name = tf_discount.getText();
            if (discount_name.isEmpty()) {
                discount_name = "NO DISCOUNT";
            }
            double discount = FitIn.toDouble(lbl_discount.getText());
            double discount_amount = FitIn.toDouble(lbl_discount_amount.getText());
            double change = FitIn.toDouble(lbl_change.getText());
            if (change < 0) {
                Alert.set(0, "KULANG");
                return;
            }

            String customer = tf_customer_name.getText();
            String customer_id = tf_customer_id.getText();
            String discount_customer_name = tf_name.getText();
            String discount_customer_id = tf_id_no.getText();
            String check_holder = tf_check_holder.getText();
            String check_no = tf_check_no.getText();
            //-------datas
            add_customer();
            add_customer_discount();
            add_check_holders();
            //--------
            String check_bank = tf_check_bank.getText();

            double check_amount = FitIn.toDouble(tf_check_amount.getText());


//            System.out.println(discount_customer_name + " ----- ");
            int status = 0;
            String or_no = sales_no;
            String serv = tf_services.getText();
            double service_amount = FitIn.toDouble(tf_service_amount.getText());
            List<S1_services.to_services> service = services;
            String transaction_type = "";
            String transaction_type_id = "";
            String payment_type = "";
            String payment_type_id = "";
            String vehicle_name = "";
            String vehicle_id = "";
            String driver_name = "";
            String driver_id = "";
            String time_delivered="";
            String time_received="";
            S1_sales.to_sales to = new S1_sales.to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid
                    , amount_due, discount_name, discount, discount_amount, customer, check_bank, check_no, check_amount, discount_customer_name
                    , discount_customer_id, status1, or_no, check_holder, serv, service_amount, customer_id1, transaction_type1
                    , transaction_type_id1, payment_type1, payment_type_id1, vehicle_name1, vehicle_id1, driver_name1, driver_id1,false
                    ,time_delivered,time_received,customer_address1,customer_contact_no1,0,1);

            List<S1_sales_services.to_sales_services> my_serv = new ArrayList();
            for (S1_services.to_services s : service) {
                int id1 = 0;
                String or_no1 = sales_no;
                String service_name = s.service_name;
                double service_amount1 = s.amount;
                String date_added1 = DateType.datetime.format(new Date());
                String user_name1 = Users.user_name;
                int status1 = 0;
                S1_sales_services.to_sales_services ser = new S1_sales_services.to_sales_services(id1, or_no1, service_name, service_amount1, date_added1, user_name1, status1);
                my_serv.add(ser);
            }
            tf_customer_name.setText("");
            tf_customer_id.setText("");
            if (service_amount < 0) {
                my_serv = new ArrayList();
            }
            callback.ok(new CloseDialog(this), new OutputData(to, change, my_serv));
        }
    }

    private void add_customer() {

        List<Customers.to_customers> datas = customers_list;
        int naa = 0;
        if (!tf_customer_name.getText().isEmpty() || tf_customer_name.getText().equals("")) {
            for (Customers.to_customers to : datas) {
                if (to.customer_name.equalsIgnoreCase(tf_customer_name.getText())) {
                    naa = 1;
                    break;
                } else {
                    naa = 0;
                }
            }
//            S1_customers.to_customers to = new S1_customers.to_customers(-1, tf_customer_name.getText());
//            S1_customers.add_customers(to);

        }

    }

    private void add_customer_discount() {
        SearchField sf = (SearchField) tf_name;
        List<String> aw = sf.possibilities;
        String type = tf_name.getText();
        int naa = 0;
        for (String s : aw) {
            if (s.equalsIgnoreCase(type)) {
                naa = 1;
                break;
            } else {
                naa = 0;
            }
        }
        String id_no = tf_id_no.getText();
        if (naa == 0) {
            if (!sf.getText().
                    isEmpty()) {
                S1_discount_customers.to_discount_customers to = new S1_discount_customers.to_discount_customers(-1, type, id_no);
                S1_discount_customers.add_discount_customers(to);
                init_tf();
            }

        }
        sf.setText("");
    }

    private void add_check_holders() {
        SearchField sf = (SearchField) tf_check_holder;
        List<String> aw = sf.possibilities;
        String type = tf_check_holder.getText();
        int naa = 0;
        for (String s : aw) {
            if (s.equalsIgnoreCase(type)) {
                naa = 1;
                break;
            } else {
                naa = 0;
            }
        }
        String id_no = tf_check_no.getText();
        if (naa == 0) {
            if (!sf.getText().
                    isEmpty()) {
                S1_check_holders.to_check_holders to = new S1_check_holders.to_check_holders(-1, type, id_no);
                S1_check_holders.add_check_holders(to);
                init_tf();
            }

        }
        sf.setText("");
    }
    List<S1_services.to_services> services = new ArrayList();

    private void services() {
        
        Window p = (Window) this;
        Dlg_payment_services nd = Dlg_payment_services.create(p, true);
        nd.setTitle("");
        nd.do_pass(services);
        nd.setCallback(new Dlg_payment_services.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_payment_services.OutputData data) {
                closeDialog.ok();
                services = data.services;
                tf_services.setText(data.services_name);
//                double serv = FitIn.toDouble(tf_service_amount.getText());
                tf_service_amount.setText(FitIn.fmt_wc_0(data.total));
                tf_amount_paid.grabFocus();
//                amount_due1=(amount_due1)-(data.total+serv);               
                compute_services();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<Customers.to_customers> customers_list = new ArrayList();

    private void init_customers(final JTextField tf1, final JTextField tf2) {
        String search = tf1.getText();
        if (!search.isEmpty()) {
            customers_list.clear();
            String where = "";
            where = " where lname like '%" + search + "%' or fname like '%" + search + "%' order by fname asc";
            customers_list = Customers.ret_data(where);
            if (!customers_list.isEmpty()) {
                Object[][] obj = new Object[customers_list.size()][2];
                int i = 0;
                for (Customers.to_customers to : customers_list) {
                    obj[i][0] = to.customer_no;
                    obj[i][1] = to.customer_name;
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
                        Customers.to_customers to = customers_list.get(data.selected_row);
                        tf1.setText(to.customer_name);
                        tf2.setText("" +to.customer_no);
                        tf_amount_paid.grabFocus();
                    }
                });
            } else {
                tf_amount_paid.grabFocus();
            }

        } else {
            tf_customer_id.setText("");
            tf_customer_name.setText("");
            tf_amount_paid.grabFocus();
        }

    }
}
