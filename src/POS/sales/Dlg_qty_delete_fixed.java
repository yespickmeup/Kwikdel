/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.util.Alert;
import POS.util.Focus_Fire;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Maytopacka
 */
public class Dlg_qty_delete_fixed extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashin
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void delete(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final double qty;
        public final double price;
        public final int metered;
        public OutputData(double qty, double price,int metered) {
            this.qty = qty;
            this.price = price;
            this.metered=metered;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_qty_delete_fixed(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_qty_delete_fixed(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_qty_delete_fixed() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_qty_delete_fixed myRef;

    private void setThisRef(Dlg_qty_delete_fixed myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_qty_delete_fixed> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_qty_delete_fixed create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_qty_delete_fixed create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_qty_delete_fixed dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_qty_delete_fixed((java.awt.Frame) parent, false);
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
            Dlg_qty_delete_fixed dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_qty_delete_fixed((java.awt.Dialog) parent, false);
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

        Dlg_qty_delete_fixed dialog = Dlg_qty_delete_fixed.create(new javax.swing.JFrame(), true);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tf_qty = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tf_qty.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("QTY");

        tf_price.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_priceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PRICE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_qty, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name.setOpaque(true);

        jCheckBox1.setText("Metered");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
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

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        ok1();
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void tf_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_priceActionPerformed
        ok1();
    }//GEN-LAST:event_tf_priceActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_qty;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_qty, tf_price};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    public void do_pass(double qty, double price, String description) {
        tf_qty.setText(FitIn.fmt_woc(qty));
        tf_price.setText(FitIn.fmt_wc_0(price));
        tf_price.enable(false);
        tf_qty.grabFocus();
        tf_qty.selectAll();
        lbl_name.setText("  " + description);
    }
     public void do_pass2(double qty, double price, String description,int metered) {
        tf_qty.setText(FitIn.fmt_woc(qty));
        tf_price.setText(FitIn.fmt_wc_0(price));
        tf_price.enable(false);
        tf_qty.grabFocus();
        tf_qty.selectAll();
        jCheckBox1.setEnabled(false);
        lbl_name.setText("  " + description);
        if(metered==1){
            jCheckBox1.setVisible(true);
        }else{
             jCheckBox1.setVisible(false);
        }
    }
    public void do_pass3(double qty, double price, String description,int metered) {
        tf_qty.grabFocus();
        tf_qty.selectAll();
        tf_price.setText(FitIn.fmt_wc_0(price));
        tf_price.setEnabled(false);
        lbl_name.setText("  " + description);
        if(metered==1){
            jCheckBox1.setVisible(true);
        }else{
             jCheckBox1.setVisible(false);
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

    private void ok1() {
        double qty = FitIn.toDouble(tf_qty.getText());
        double price = FitIn.toDouble(tf_price.getText());

        System.out.println("aw");
        if (qty < 0) {
            Alert.set(0, "ENTER QTY");
            tf_qty.grabFocus();
            tf_qty.selectAll();
            return;
        }
        if (price < 0) {
            Alert.set(0, "ENTER AMOUNT");
            tf_price.grabFocus();
            tf_price.selectAll();
            return;
        }
        int metered=0;
        if(jCheckBox1.isSelected()){
            metered=1;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(qty, price,metered));
        }
    }

    private void delete() {
        double amount = FitIn.toDouble(tf_qty.getText());
        System.out.println("del");
//        if (amount < 0) {
//            Alert.set(0, "ENTER AMOUNT");
////            return;
//        }
        int metered=0;
        if(jCheckBox1.isSelected()){
            metered=1;
        }
        if (callback != null) {
            callback.delete(new CloseDialog(this), new OutputData(amount, 0,metered));
        }
    }
}
