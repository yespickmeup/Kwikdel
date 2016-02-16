/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.banks.S1_banks;
import POS.check_holders.S1_check_holders;
import POS.discount_customers.S1_discount_customers;
import POS.discounts.S1_discounts;
import POS.main.Main;
import POS.util.Alert;
import POS.util.Focus_Fire;
import java.awt.event.*;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.SearchField;

/**
 *
 * @author i1
 */
public class Dlg_ar_payment extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_ar_payment
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

        public final double amount;

        public OutputData(double amount) {
            this.amount = amount;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_ar_payment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_ar_payment(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_ar_payment() {

        super();
        setUndecorated(true);
        initComponents();

        myInit();

    }
    private Dlg_ar_payment myRef;

    private void setThisRef(Dlg_ar_payment myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_ar_payment> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_ar_payment create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_ar_payment create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_ar_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_payment((java.awt.Frame) parent, false);
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
            Dlg_ar_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_ar_payment((java.awt.Dialog) parent, false);
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


        Dlg_ar_payment dialog = Dlg_ar_payment.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_net_due = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_amount_due = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        tf_check_bank = new SearchField();
        jLabel13 = new javax.swing.JLabel();
        tf_check_amount = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tf_amount_paid = new javax.swing.JTextField();
        lbl_change = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        lbl_net_due.setBackground(new java.awt.Color(255, 255, 255));
        lbl_net_due.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_net_due.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_net_due.setText("0.00");
        lbl_net_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_net_due.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Net Due:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lbl_net_due, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));

        lbl_amount_due.setBackground(new java.awt.Color(255, 255, 255));
        lbl_amount_due.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_amount_due.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_amount_due.setText("0.00");
        lbl_amount_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_amount_due.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Amount Due:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_amount_due, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_amount_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_id_no.setBackground(new java.awt.Color(153, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Name:");

        tf_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("NO:");

        tf_id_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_id_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id_noActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Discount (F2):");

        tf_discount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_id_noLayout.createSequentialGroup()
                        .addComponent(lbl_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_id_noLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_id_no)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_id_noLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_id_noLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tf_id_no, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_id_noLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))))
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
        jLabel14.setText("Name:");

        tf_check_holder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_holder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_holderActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("No:");

        tf_check_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Check (F3):");

        tf_check_bank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_check_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_bankActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Amount:");

        tf_check_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_check_bank)
                    .addComponent(tf_check_holder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_check_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        tf_amount_paid.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tf_amount_paid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        jLabel2.setText("Change:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tendered (F1):");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_id_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_id_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_check, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        btn_close.setBackground(new java.awt.Color(255, 255, 255));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_close.setForeground(new java.awt.Color(153, 153, 153));
        btn_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_close.setText("X");
        btn_close.setOpaque(true);
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PAYMENT");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameActionPerformed

    private void tf_id_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id_noActionPerformed
        // TODO add your handling code here:
        compute_discount();
        tf_amount_paid.grabFocus();
    }//GEN-LAST:event_tf_id_noActionPerformed

    private void lbl_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_discount_amountActionPerformed
        // TODO add your handling code here:
//        compute_discount();
        tf_name.grabFocus();
    }//GEN-LAST:event_lbl_discount_amountActionPerformed

    private void lbl_discount_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_discount_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_discount_amountKeyReleased

    private void tf_check_holderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_holderActionPerformed
        // TODO add your handling code here:
        tf_check_no.grabFocus();
    }//GEN-LAST:event_tf_check_holderActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        // TODO add your handling code here:
//        payment();
        compute();
        tf_amount_paid.grabFocus();
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void tf_check_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_bankActionPerformed

    private void tf_check_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_amountActionPerformed
        // TODO add your handling code here:
        tf_check_holder.grabFocus();
    }//GEN-LAST:event_tf_check_amountActionPerformed

    private void tf_check_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_check_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_check_amountKeyReleased

    private void tf_amount_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amount_paidActionPerformed
        ok1();
    }//GEN-LAST:event_tf_amount_paidActionPerformed

    private void tf_amount_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amount_paidKeyReleased
//        payment();
        compute();
    }//GEN-LAST:event_tf_amount_paidKeyReleased

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        disposed();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        hover(btn_close);
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        exit(btn_close);
    }//GEN-LAST:event_btn_closeMouseExited
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_amount_due;
    private javax.swing.JLabel lbl_change;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JTextField lbl_discount_amount;
    private javax.swing.JLabel lbl_net_due;
    private javax.swing.JPanel pnl_check;
    private javax.swing.JPanel pnl_id_no;
    private javax.swing.JTextField tf_amount_paid;
    private javax.swing.JTextField tf_check_amount;
    private javax.swing.JTextField tf_check_bank;
    private javax.swing.JTextField tf_check_holder;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_id_no;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_algorithm");
        init_key();
        focus();
        init();
        init_discount();
        check_holders();
        discount_customers();
        lbl_amount_due.enable(false);
      
    }

    private void focus() {
        JTextField[] tf = {tf_discount, lbl_discount_amount, tf_name, tf_id_no, tf_check_bank, tf_check_amount, tf_check_holder, tf_check_no, tf_amount_paid};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    public void do_pass(double amount_due) {
        lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due));
        lbl_net_due.setText(FitIn.fmt_wc_0(amount_due));
        tf_amount_paid.grabFocus();
    }
    public void do_pass2(double amount_due) {
        lbl_amount_due.setText(FitIn.fmt_wc_0(amount_due));
        lbl_net_due.setText(FitIn.fmt_wc_0(amount_due));
        tf_amount_paid.grabFocus();
        tf_amount_paid.setText(FitIn.fmt_wc_0(amount_due));
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
                tf_amount_paid.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 tf_discount.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 tf_check_bank.grabFocus();
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
    }
    // </editor-fold>
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

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(51, 102, 0));
        lbl.setForeground(new java.awt.Color(0, 0, 0));
    }

    private void exit2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
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
                    isEmpty() && tf_id_no.getText().
                    equals("")) {
                S1_discount_customers.to_discount_customers to = new S1_discount_customers.to_discount_customers(-1, type, id_no);
                S1_discount_customers.add_discount_customers(to);
                discount_customers();
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
                check_holders();
            }
        }
        sf.setText("");
    }

    private void discount_customers() {
        final SearchField sf3 = (SearchField) tf_name;
        sf3.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf3.set_instruction1("Select Name");
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
    }

    private void check_holders() {
        final SearchField sf2 = (SearchField) tf_check_bank;
        sf2.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf2.set_instruction1("Select Bank");
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
                    tf_amount_paid.grabFocus();
                } else {
                    tf_check_amount.grabFocus();
                }

            }
        });

        final SearchField sf4 = (SearchField) tf_check_holder;
        sf4.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf4.set_instruction1("Select Name");
        sf4.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return S1_discount_customers.ret_cb_data();
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
            lbl_discount_amount.setText(FitIn.fmt_wc_0(disc_amount));

        }
        if (discount_name.isEmpty()) {
            lbl_discount.setText("0.00");
            lbl_discount_amount.setText("0.00");
            tf_name.setText("");
            tf_id_no.setText("");
        }
    }

    private void compute_discount() {
        double due = FitIn.toDouble(lbl_amount_due.getText());
        double disc_amount = FitIn.toDouble(lbl_discount_amount.getText());
        lbl_net_due.setText(FitIn.fmt_wc_0((due) - (disc_amount)));
    }
    private void compute(){
        double due = FitIn.toDouble(lbl_net_due.getText());
        double disc_amount = FitIn.toDouble(lbl_discount_amount.getText());
        double check_amount=FitIn.toDouble(tf_check_amount.getText());
        double tendered=FitIn.toDouble(tf_amount_paid.getText());
        double total=(due)-check_amount;
        double change=tendered-total;
        lbl_change.setText(FitIn.fmt_wc_0(change));
    }

    private void ok1() {
        
        double amount = FitIn.toDouble(tf_amount_paid.getText());
        if (amount < 0) {
            Alert.set(0, "ENTER AMOUNT");
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(amount));
        }
    }
}
