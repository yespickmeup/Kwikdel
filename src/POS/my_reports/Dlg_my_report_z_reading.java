/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import POS.bir_sales_ors.Sales_ors;
import POS.bir_sales_ors.bir_sales_or_details;
import POS.users.S1_users;
import POS.util.TableRenderer;
import POS.util.Users;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_my_report_z_reading extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_my_report_z_reading
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
    private Dlg_my_report_z_reading(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_my_report_z_reading(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_my_report_z_reading() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_my_report_z_reading myRef;

    private void setThisRef(Dlg_my_report_z_reading myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_my_report_z_reading> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_my_report_z_reading create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_my_report_z_reading create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_my_report_z_reading dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_report_z_reading((java.awt.Frame) parent, false);
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
            Dlg_my_report_z_reading dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_report_z_reading((java.awt.Dialog) parent, false);
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

        Dlg_my_report_z_reading dialog = Dlg_my_report_z_reading.create(new javax.swing.JFrame(), true);
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
        jPanel15 = new javax.swing.JPanel();
        jButton6 = new Button.Default();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jTextField5 = new Field.Combo();
        jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jPanel16 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Date:");

        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox20.setText("All");
        jCheckBox20.setFocusable(false);

        jDateChooser11.setDate(new Date());
        jDateChooser11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("to");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Cashier:");

        jCheckBox29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox29.setSelected(true);
        jCheckBox29.setText("All");
        jCheckBox29.setFocusable(false);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jDateChooser12.setDate(new Date());
        jDateChooser12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox20)))
                            .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox29)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jLabel1.setText("Status:");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6))
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        get_data_collections();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_cashier(jTextField5);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_cashier(jTextField5);
    }//GEN-LAST:event_jTextField5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox29;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();

        String where = "";
        cashiers_list = S1_users.ret_data2(where);
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

    List<S1_users.to_users> cashiers_list = new ArrayList();

    private void init_cashier(final JTextField tf) {

        Object[][] obj = new Object[cashiers_list.size()][1];
        int i = 0;
        for (S1_users.to_users to : cashiers_list) {
            obj[i][0] = " " + to.screen_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo combo = (Field.Combo) tf;
                S1_users.to_users to = cashiers_list.get(data.selected_row);
                tf.setText(to.screen_name);
                combo.setId("" + to.user_name);
            }
        });
    }

    private void get_data_collections() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                double total_gross_sales = 0;
                double walkin_gross_sales = 0;
                double charge_gross_sales = 0;
                double total_items_sold = 0;
                double walkin_items_sold = 0;
                double charge_items_sold = 0;
                double total_vatable_sales = 0;
                double total_non_vatable_sales = 0;
                double total_vat = 0;
                double total_cash_collected = 0;
                double walkin_cash_payment = 0;
                double walkin_check_payment = 0;
                double charge_cash_payment = 0;
                double total_charge_amount = 0;
                double charge_check_payment = 0;
                double total_collectible = 0;
                double total_no_of_transactions = 0;
                double walkin_trans = 0;
                double charge_transactions = 0;

                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
                String date = DateType.slash.format(jDateChooser12.getDate()) + " - " + DateType.slash.format(jDateChooser11.getDate());
                String cashier = jTextField5.getText();
                String printed_by = Users.getScreen_name();
                double total_delivery_charge = 0;
                double total_discount = 0;
                double total_check_collected = 0;

                String counter_id_start = "";
                String counter_id_end = "";
                double cancelled_transactions = 0;
                double cancelled_amount = 0;

                if (jCheckBox29.isSelected()) {
                    cashier = "All";
                }
                //collections
                String where_collections = " where customer_name like '%" + "" + "%' ";
                String date_from = DateType.sf.format(jDateChooser12.getDate());
                String date_to = DateType.sf.format(jDateChooser11.getDate());
                if (!jCheckBox20.isSelected()) {
                    where_collections = where_collections + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox29.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField5;
                    where_collections = where_collections + " and user_name='" + combo.getId() + "' ";
                }
                where_collections = where_collections + " ";

                String where_collections_bir = " where Date(created) between '" + date_from + "' and '" + date_to + "' ";
                if (jCheckBox20.isSelected()) {
                    where_collections_bir = "  ";
                }
                List<Srpt_collections.field> bir = Sales_ors.ret_data(where_collections_bir);

                List<Srpt_collections.field> datas_collections = new ArrayList();
                datas_collections.addAll(bir);
                datas_collections.addAll(Srpt_collections.ret_data(where_collections));

                int i = 0;
                for (Srpt_collections.field to : datas_collections) {
                    if (i == 0) {
                        counter_id_start = to.or_no;
                    }
                    counter_id_end = to.or_no;

                    if (to.status == 0 || to.status == 5 || to.status == 6 || to.status == 7 || to.status == 8) {
                        total_discount += to.discount_amount;
                        total_delivery_charge += to.service_charge;

                        if (to.payment_type.equalsIgnoreCase("Charge")) {
                            charge_gross_sales += to.gross_amount;
                        } else {
                            walkin_gross_sales += to.gross_amount;
                            walkin_trans++;
                        }

                        if (!to.dr_no.isEmpty()) {
                            charge_cash_payment += to.cash;
                            charge_check_payment += to.check_amount;
                        } else {
                            walkin_cash_payment += to.cash;
                            walkin_check_payment += to.check_amount;
                        }
                    } else {
                        cancelled_transactions++;
                        cancelled_amount += (to.gross_amount + to.service_charge) - to.discount_amount;
                    }

                    i++;
                }

//                //collectibles
//                String where_collectibles = " where customer_name like '%" + "" + "%' ";
//
//                if (!jCheckBox20.isSelected()) {
//                    where_collectibles = where_collectibles + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
//                }
//                if (!jCheckBox29.isSelected()) {
//                    Field.Combo combo = (Field.Combo) jTextField5;
//                    where_collectibles = where_collectibles + " and user_name='" + combo.getId() + "' ";
//                }
//                List<Srpt_collectibles.field> datas_collectibles = Srpt_collectibles.ret_data(where_collectibles);
//                for (Srpt_collectibles.field to : datas_collectibles) {
//                    total_charge_amount += to.amount_due;
//                    charge_transactions++;
//                    if (!to.status.equalsIgnoreCase("Paid")) {
//                        charge_gross_sales += to.gross_amount;
//                        total_discount += to.discount_amount;
//                        total_delivery_charge += to.service_charge;
//                    }
//                }
                total_gross_sales = walkin_gross_sales + charge_gross_sales;
                total_vatable_sales = ((total_gross_sales + total_delivery_charge) - (total_discount)) / 1.12;
                total_vat = total_vatable_sales * .12;
                total_cash_collected = charge_cash_payment + walkin_cash_payment;
                total_check_collected = walkin_check_payment + charge_check_payment;
                total_collectible = total_charge_amount - (charge_cash_payment + charge_check_payment);
                total_no_of_transactions = charge_transactions + walkin_trans;

                String where_items = " where si.customer_name like '%" + "" + "%' ";

                if (!jCheckBox20.isSelected()) {
                    where_items = where_items + " and Date(si.date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox29.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField5;
                    where_items = where_items + " and si.user_name='" + combo.getId() + "' ";
                }
                where_items = where_items + "  group by si.description,si.selling_price ";

                String where_items_bir = " where Date(bir.created) between '" + date_from + "' and '" + date_to + "'"
                        + "  group by i.lookup_code,i.prc ";

                if (jCheckBox20.isSelected()) {
                    where_items_bir = " "
                            + "  group by i.lookup_code,i.prc ";
                }
                List<Srpt_collections_items.field> datas_bir = bir_sales_or_details.ret_data(where_items_bir);

                List<Srpt_collections_items.field> datas = new ArrayList();
                datas.addAll(datas_bir);
                datas.addAll(Srpt_collections_items.ret_data_sales_items(where_items));

                List<Srpt_collections_items.field> datas2 = new ArrayList();// Srpt_collections_items.ret_data_sales_dr_items(where_items);
                double no_of_sku = 0;
                for (Srpt_collections_items.field to : datas) {
                    if (to.stat == 0 || to.stat == 5 || to.stat == 6 || to.stat == 7 || to.stat == 8) {
                        walkin_items_sold += to.qty;
                        no_of_sku++;
                    }
                }

                for (Srpt_collections_items.field to : datas2) {
                    if (to.stat == 0 || to.stat == 5 || to.stat == 6 || to.stat == 7 || to.stat == 8) {
                        charge_items_sold += to.qty;
                        no_of_sku++;
                    }

                }
                total_items_sold = walkin_items_sold + charge_items_sold;

                String operated_by = System.getProperty("operated_by", "");
                String permit_no = System.getProperty("permit_no", "");
                String tin_no = System.getProperty("tin_no", "");
                String accreditation_no = System.getProperty("acct_no", "");
                String serial_no = System.getProperty("serial_no", "");
                String machine_no = System.getProperty("min_no", "");
                double regular_discount = total_discount;
                double senior_discount = 0;
                double pwd_discount = 0;
                double net_sales = (total_gross_sales + total_delivery_charge) - (total_discount);

                Srpt_z_reading rpt = new Srpt_z_reading(total_gross_sales, total_gross_sales, charge_gross_sales, total_items_sold, walkin_items_sold, charge_items_sold, total_vatable_sales, total_non_vatable_sales, total_vat, total_cash_collected, walkin_cash_payment, walkin_check_payment, charge_cash_payment, total_charge_amount, charge_check_payment, total_collectible, total_no_of_transactions, walkin_trans, charge_transactions, business_name, address, date, cashier, printed_by, total_delivery_charge, total_discount, total_check_collected, operated_by, permit_no, tin_no, accreditation_no, serial_no, machine_no, regular_discount, senior_discount, pwd_discount, net_sales, counter_id_start, counter_id_end, no_of_sku, cancelled_transactions, cancelled_amount
                );
                String jrxml = "rpt_z_reading.jrxml";
                report_collections(rpt, jrxml);

                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_collections(final Srpt_z_reading to, String jrxml_name) {
        jPanel16.removeAll();
        jPanel16.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_collections(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel16.add(viewer);
            jPanel16.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_collections(Srpt_z_reading to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_collections(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_collections(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_z_reading.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
