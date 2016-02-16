/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.cash_drawer.Dlg_cashin;
import POS.cash_drawer.S1_cash_drawer;
import POS.cash_drawer.S1_cash_drawer.to_cash_drawer;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Users;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Maytopacka
 */
public class Dlg_login extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_login
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
    private Dlg_login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_login(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_login() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_login myRef;

    private void setThisRef(Dlg_login myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_login> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_login create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_login create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_login dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_login((java.awt.Frame) parent, false);
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
            Dlg_login dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_login((java.awt.Dialog) parent, false);
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


        Dlg_login dialog = Dlg_login.create(new javax.swing.JFrame(), true);
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
        tf_username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tf_password = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel2.setBackground(new java.awt.Color(27, 168, 215));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_username.setBackground(new java.awt.Color(251, 251, 168));
        tf_username.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 180, 31));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER NAME");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 90, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 70, 30));

        tf_password.setBackground(new java.awt.Color(251, 251, 168));
        tf_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 190, 32));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("LOG-IN");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 80, 30));

        jPanel3.setBackground(new java.awt.Color(27, 168, 215));
        jPanel3.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/users/log3.png"))); // NOI18N
        jLabel3.setText("LOG-IN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("|");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(27, 168, 215));
        jPanel4.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        ok1();
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        // TODO add your handling code here:ok1()
        ok1();
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton2ActionPerformed
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
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
//                disposed();
                System.exit(1);
            }
        });
    }
    // </editor-fold>

    private void ok1() {
        final String user_name = tf_username.getText();
        String date = DateType.sf.format(new Date());
        String password = tf_password.getText();
        final S1_users.to_users to = S1_users.ret_data_autho(user_name, password);
        if (to == null) {
            Alert.set(0, "WRONG USERNAME/PASSWORD");
            tf_password.setText("");
            tf_username.setText("");
            tf_username.grabFocus();
        } else {
            Users.setT_sales(to.t_sales);
            Users.setT_receipts(to.t_receipts);
            Users.setT_stock_transfer(to.t_stock_transfer);
            Users.setM_items(to.m_items);
            Users.setM_category(to.m_category);
            Users.setM_users(to.m_users);
            Users.setM_uom(to.m_uom);
            Users.setM_suppliers(to.m_suppliers);
            Users.setR_sales(to.r_sales);
            Users.setR_cash_count(to.r_cash_count);
            Users.setR_receipts(to.r_receipts);
            Users.setR_stock_transferred(to.r_stock_transferred);
            Users.setR_stock_take(to.r_stock_take);
            Users.setM_customers(to.m_customers);
            Users.setM_discount(to.m_discount);
            Users.setM_banks(to.m_banks);
            Users.setR_stock_left_supplier(to.r_stock_left_supplier);
            Users.setT_inventory_adjuster(to.t_inventory_adjuster);          
            if (to.user_level == 1) {
                S1_cash_drawer.to_cash_drawer to1 = S1_cash_drawer.ret_data2(user_name, date);
                if (to1 == null) {
                    Window p = (Window) this;
                    Dlg_cashin nd = Dlg_cashin.create(p, true);
                    nd.setTitle("");
                    nd.setCallback(new Dlg_cashin.Callback() {
                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
                            closeDialog.ok();
                            int id = 1;
                            String session_no = S1_cash_drawer.increment_id();
                            String user_name1 = to.user_name;
                            String screen_name1 = to.screen_name;
                            String time_in = DateType.datetime.format(new Date());
                            String time_out = null;
                            double amount = data.amount;
                            S1_cash_drawer.to_cash_drawer to2 = new S1_cash_drawer.to_cash_drawer(id, session_no, user_name1, screen_name1, time_in
                                    , time_out, amount, 0, 0, 0, 0, 0, 0, 0, 0, new ArrayList(), new ArrayList(),0);
                            S1_cash_drawer.add_cash_drawer(to2);
                            Users.setSession_no(session_no);
                            Users.setScreen_name(screen_name1);
                            Users.setUser_level(to.user_level);
                            Users.setUser_name(user_name);
                            to_cash_drawer.setAmount(amount);                          
                            Users.setTime_in(time_in);
                            ok2();
                        }
                    });
                    nd.setLocationRelativeTo(this);
                    nd.setVisible(true);
                } else {
                    Users.setSession_no(to1.session_no);
                    Users.setScreen_name(to1.screen_name);
                    Users.setUser_level(to.user_level);
                    Users.setUser_name(user_name);
                    Users.setTime_in(to1.time_in);
                    if (to1.time_out == null) {
                        Users.setIs_active(0);
                    } else {
                        Users.setIs_active(1);
                    }
                    Users.setChecks(to1.checks);
                    Users.setDrawer(to1);
                    ok2();
                }
            } else {
                Users.setSession_no("");
                Users.setScreen_name(to.screen_name);
                Users.setUser_level(to.user_level);
                Users.setUser_name(user_name);
                ok2();
            }
        }
    }

    private void ok2() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new Dlg_login.OutputData());
        }
    }
}
