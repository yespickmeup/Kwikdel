/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

import POS.discounts.S1_discounts;
import POS.sales.S1_sales.to_sales;
import POS.util.Focus_Fire;
import POS.util.MyDate;
import POS.util.MyList;
import POS.util.TableRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Ronald
 */
public class Dlg_delivery_multi_update extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_delivery_update
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

        public final String vehicle_name;
        public final String vehicle_id;
        public final String driver_name;
        public final String driver_id;
        public final String time_delivered;

        public OutputData(String vehicle_name, String vehicle_id, String driver_name, String driver_id, String time_delivered) {
            this.vehicle_name = vehicle_name;
            this.vehicle_id = vehicle_id;
            this.driver_name = driver_name;
            this.driver_id = driver_id;
            this.time_delivered = time_delivered;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_delivery_multi_update(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_delivery_multi_update(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_delivery_multi_update() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_delivery_multi_update myRef;

    private void setThisRef(Dlg_delivery_multi_update myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_delivery_multi_update> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_delivery_multi_update create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_delivery_multi_update create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_delivery_multi_update dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_delivery_multi_update((java.awt.Frame) parent, false);
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
            Dlg_delivery_multi_update dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_delivery_multi_update((java.awt.Dialog) parent, false);
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

        Dlg_delivery_multi_update dialog = Dlg_delivery_multi_update.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_vehicle_name = new javax.swing.JTextField();
        tf_vehicle_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_driver_name = new javax.swing.JTextField();
        tf_driver_id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_customer_name = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(65, 136, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Customer/s:");

        jLabel3.setText("Vehicle:");

        tf_vehicle_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_vehicle_nameActionPerformed(evt);
            }
        });

        tf_vehicle_id.setFocusable(false);

        jLabel4.setText("Driver:");

        tf_driver_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_driver_nameActionPerformed(evt);
            }
        });

        tf_driver_id.setFocusable(false);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tf_customer_name.setColumns(20);
        tf_customer_name.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tf_customer_name.setLineWrap(true);
        tf_customer_name.setRows(5);
        tf_customer_name.setFocusable(false);
        jScrollPane1.setViewportView(tf_customer_name);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_vehicle_name)
                            .addComponent(tf_driver_name))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_driver_id, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(tf_vehicle_id)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_vehicle_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_vehicle_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_driver_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_driver_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_vehicle_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_vehicle_nameActionPerformed
        init_truck();
    }//GEN-LAST:event_tf_vehicle_nameActionPerformed

    private void tf_driver_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_driver_nameActionPerformed
        init_driver();
    }//GEN-LAST:event_tf_driver_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tf_customer_name;
    private javax.swing.JTextField tf_driver_id;
    private javax.swing.JTextField tf_driver_name;
    private javax.swing.JTextField tf_vehicle_id;
    private javax.swing.JTextField tf_vehicle_name;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_vehicle_name, tf_driver_name};

        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    public void do_pass(String customer_name, String vehicle_name, String vehicle_id, String driver_name, String driver_id, String time_delivered1) {

        tf_customer_name.setText(customer_name);

        tf_vehicle_name.setText(vehicle_name);
        tf_vehicle_id.setText(vehicle_id);
        tf_driver_name.setText(driver_name);
        tf_driver_id.setText(driver_id);

       

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
    List<S1_delivery_trucks.to_delivery_trucks> truck_list = new ArrayList();

    private void init_truck() {
        String search = tf_vehicle_name.getText();
        truck_list.clear();
        truck_list = S1_delivery_trucks.ret_data("");
        Object[][] obj = new Object[truck_list.size()][1];
        int i = 0;
        for (S1_delivery_trucks.to_delivery_trucks to : truck_list) {
            obj[i][0] = to.description;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {500};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_vehicle_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_delivery_trucks.to_delivery_trucks to = truck_list.get(data.selected_row);
                tf_vehicle_name.setText(to.description);
                tf_vehicle_id.setText("" + to.id);

            }
        });
    }

    List<S1_delivery_man.to_delivery_man> driver_list = new ArrayList();

    private void init_driver() {
        String search = tf_driver_name.getText();
        driver_list.clear();
        driver_list = S1_delivery_man.ret_data("");
        Object[][] obj = new Object[driver_list.size()][1];
        int i = 0;
        for (S1_delivery_man.to_delivery_man to : driver_list) {
            obj[i][0] = to.lname + ", " + to.fname + " " + to.mi;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {500};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_driver_name, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_delivery_man.to_delivery_man to = driver_list.get(data.selected_row);
                tf_driver_name.setText(to.lname + ", " + to.fname + " " + to.mi);
                tf_driver_id.setText("" + to.id);

            }
        });
    }

    List< S1_discounts.to_discounts> discount_list = new ArrayList();

    private void ok() {

        String vehicle_name = tf_vehicle_name.getText();
        String vehicle_id = tf_vehicle_id.getText();
        String driver_name = tf_driver_name.getText();
        String driver_id = tf_driver_id.getText();
        String time_delivered ="";

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(vehicle_name, vehicle_id, driver_name, driver_id, time_delivered
            ));
        }
    }

    List<String> hour_list = new ArrayList();

    private void init_hour(final JTextField tf) {
        String search = tf.getText();
        hour_list.clear();
        hour_list = MyList.hours();
        Object[][] obj = new Object[hour_list.size()][1];
        int i = 0;
        for (String to : hour_list) {
            obj[i][0] = to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String to = hour_list.get(data.selected_row);
                tf.setText(to);

            }
        });
    }

    List<String> minute_list = new ArrayList();

    private void init_minute(final JTextField tf) {
        String search = tf.getText();
        minute_list.clear();
        minute_list = MyList.minutes();
        Object[][] obj = new Object[minute_list.size()][1];
        int i = 0;
        for (String to : minute_list) {
            obj[i][0] = to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String to = minute_list.get(data.selected_row);
                tf.setText(to);
            }
        });
    }

}
