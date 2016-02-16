/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.voider;

import POS.main.Main;
import POS.sales.Dlg_prompt_void2;
import POS.sales.S1_sales;
import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items;
import POS.sales.S1_sales_items.to_sales_items;
import POS.sales_dr.S1_sales_dr;
import POS.util.DateType;
import POS.util.TextHighlighter1;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_voider extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_all_sales_report
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
    private Dlg_voider(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_voider(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_voider() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_voider myRef;

    private void setThisRef(Dlg_voider myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_voider> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_voider create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_voider create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_voider dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_voider((java.awt.Frame) parent, false);
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
            Dlg_voider dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_voider((java.awt.Dialog) parent, false);
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

        Dlg_voider dialog = Dlg_voider.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sales_items = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_void_no = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        tbl_sales_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_sales_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sales_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sales_items);

        jLabel5.setText("SEARCH OR:");

        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel6.setText("Counted Trans:");

        jLabel8.setText("0");

        jLabel9.setText("Check:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("0.00");

        jLabel11.setText("Void Trans:");

        jLabel12.setText("0");

        jLabel13.setText("Cash:");

        jLabel14.setText("0.00");

        jLabel15.setText("Disc:");

        jLabel16.setText("0.00");

        jLabel17.setText("Total:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("VOIDER");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DATE FROM:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DATE TO:");

        jButton1.setText("SEARCH");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("|");

        lbl_void_no.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("VOID NO:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_void_no, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_void_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dp_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        data_cols_or();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_cols_or2();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
        data_cols();
        void_or();

    }//GEN-LAST:event_tbl_salesMouseClicked

    private void tbl_sales_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sales_itemsMouseClicked
        void_sales();
    }//GEN-LAST:event_tbl_sales_itemsMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_void_no;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTable tbl_sales_items;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        init_key();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        init_tbl_sales();
        init_tbl_sales_items();
        init_no();
        tf_search.grabFocus();
    }

    private void init_no() {
        lbl_void_no.setText(S1_voids.increment_id());
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
        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_sales_ALM.isEmpty()) {
                        tbl_sales.setRowSelectionInterval(0, 0);
                        tbl_sales.grabFocus();
                    }
                }
            }
        });
        tbl_sales.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    data_cols();
                    e.consume();
                }
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_sales_ALM;
    private TblsalesModel tbl_sales_M;

    private void init_tbl_sales() {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {0, 120, 80, 70, 70, 70, 70, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }

        Dimension d = tbl_sales.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_sales.getTableHeader().
                setPreferredSize(d);
        tbl_sales.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_sales.setRowHeight(35);
        tbl_sales.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 6);
    }

    private void loadData_sales(List<to_sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);

    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "OR No", "Date", "Amount Due", "Cash", "Disc", "Check", "Status", "discount_name", "discount", "discount_amount", "customer_name", "check_bank", "check_no", "check_amount", "discount_customer_name", "discount_customer_id", "status", "or_no", "check_holder", "services", "service_amount"
        };

        public TblsalesModel(ListModel listmodel) {
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
            to_sales tt = (to_sales) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return " " + tt.sales_no;
                case 2:
                    if (tt.date_added == null) {
                        return "";
                    } else {
                        return " " + DateType.convert_slash_datetime(tt.date_added);
                    }

                case 3:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.amount_due - tt.check_amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 6:
//                    return " " + tt.status;
                    return FitIn.fmt_wc_0(tt.check_amount) + " ";
                case 7:
                    if (tt.status == 1 || tt.status == 9) {
                        return TextHighlighter1.highlight2("VOID", "VOID", "RED");
                    } else {
                        return TextHighlighter1.highlight("COUNTED", "COUNTED", "BLUE");
                    }
                case 8:
                    return tt.discount_name;
                case 9:
                    return tt.discount;
                case 10:
                    return tt.discount_amount;
                case 11:
                    return tt.customer_name;
                case 12:
                    return tt.check_bank;
                case 13:
                    return tt.check_no;
                case 14:
                    return tt.check_amount;
                case 15:
                    return tt.discount_customer_name;
                case 16:
                    return tt.discount_customer_id;
                case 17:
                    return tt.status;
                case 18:
                    return tt.or_no;
                case 19:
                    return tt.check_holder;
                case 20:
                    return tt.services;
                default:
                    return tt.service_amount;
            }
        }
    }

    private void data_cols_or() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());

        String where = " where Date(date_added) between '" + date_from + "' and '" + date_to + "'";
        where = where + " ";
        where = where + " order by date_added asc";
        loadData_sales(S1_sales.ret_data(where));
        List<to_sales> datas = tbl_sales_ALM;
        int trans = datas.size();
        int voided = 0;
        double cash = 0;
        double disc = 0;
        double check = 0;
        double total = 0;
        for (to_sales to : datas) {
            if (to.status == 1) {
                voided++;
                trans++;
            } else {
                cash += to.amount_due - to.discount_amount;
                disc += to.discount_amount;
                total += to.amount_due - to.discount_amount;
                check += to.check_amount;
            }
        }
        jLabel8.setText("" + trans);
        jLabel12.setText("" + voided);
        jLabel14.setText(FitIn.fmt_wc_0(cash));
        jLabel16.setText(FitIn.fmt_wc_0(disc));
        jLabel10.setText(FitIn.fmt_wc_0(check));
        jLabel18.setText(FitIn.fmt_wc_0(total));

    }

    private void data_cols_or2() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());

        String where = " where";
        where = where + "  sales_no like '%" + tf_search.getText() + "%'";
        where = where + " order by date_added asc";
        List<S1_sales.to_sales> datass = S1_sales.ret_data(where);
        List<S1_sales.to_sales> datas2 = S1_sales_dr.ret_data2(where);
        datass.addAll(datas2);
        loadData_sales(datass);

        List<to_sales> datas = tbl_sales_ALM;
        int trans = datas.size();
        int voided = 0;
        double cash = 0;
        double disc = 0;
        double check = 0;
        double total = 0;
        for (to_sales to : datas) {
            if (to.status == 1) {
                voided++;
                trans++;
            } else {
                cash += to.amount_due - to.discount_amount;
                disc += to.discount_amount;
                total += to.amount_due - to.discount_amount;
                check += to.check_amount;
            }
        }
        jLabel8.setText("" + trans);
        jLabel12.setText("" + voided);
        jLabel14.setText(FitIn.fmt_wc_0(cash));
        jLabel16.setText(FitIn.fmt_wc_0(disc));
        jLabel10.setText(FitIn.fmt_wc_0(check));
        jLabel18.setText(FitIn.fmt_wc_0(total));
    }

    private void data_cols_date() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String search = tf_search.getText();
        loadData_sales(S1_sales.ret_data_or(date_from, date_to, search));
    }
    private ArrayListModel tbl_sales_items_ALM;
    private Tblsales_itemsModel tbl_sales_items_M;

    private void init_tbl_sales_items() {
        tbl_sales_items_ALM = new ArrayListModel();
        tbl_sales_items_M = new Tblsales_itemsModel(tbl_sales_items_ALM);
        tbl_sales_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_sales_items.setModel(tbl_sales_items_M);
        tbl_sales_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales_items.setRowHeight(25);
        int[] tbl_widths_sales_items = {40, 70, 100, 0, 50, 0, 80, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales_items, i, tbl_widths_sales_items[i]);
        }
        Dimension d = tbl_sales_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_sales_items.getTableHeader().
                setPreferredSize(d);
        tbl_sales_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_sales_items.setRowHeight(25);
        tbl_sales_items.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 4);
    }

    private void loadData_sales_items(List<to_sales_items> acc) {
        tbl_sales_items_ALM.clear();
        tbl_sales_items_ALM.addAll(acc);
    }

    public static class Tblsales_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Unit", "Disc.", "Pruce", "Total", "Status", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "session_no", "item_discount", "discount", "discount_amount", "sales_no", "fixed_price", "supplier", "supplier_id", "vatable", "or_no"
        };

        public Tblsales_itemsModel(ListModel listmodel) {
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
            to_sales_items tt = (to_sales_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_wc_0(tt.product_qty);
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.discount_amount);
                case 5:
                    return " " + FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 6:
                    return " " + FitIn.fmt_wc_0(tt.product_qty * tt.selling_price) + " ";
                case 7:
                    if (tt.status == 0) {
                        return "      ---";
                    } else {
                        return "      Void";
                    }

                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.session_no;
                case 19:
                    return tt.item_discount;
                case 20:
                    return tt.discount;
                case 21:
                    return tt.discount_amount;
                case 22:
                    return tt.sales_no;
                case 23:
                    return tt.fixed_price;
                case 24:
                    return tt.supplier;
                case 25:
                    return tt.supplier_id;
                case 26:
                    return tt.vatable;
                default:
                    return tt.or_no;
            }
        }
    }

    private void data_cols() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.
                convertRowIndexToModel(row));
        if (to.payment_type_id.equals("1")) {
            loadData_sales_items(S1_sales_items.ret_data(to.sales_no));
        } else {
            loadData_sales_items(S1_sales_items.ret_data_dr_items(to.sales_no));
        }

    }

    private void void_sales() {

        int row2 = tbl_sales_items.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_sales_items to = (to_sales_items) tbl_sales_items_ALM.get(tbl_sales_items.convertRowIndexToModel(row2));

        int row3 = tbl_sales.getSelectedRow();
        if (row3 < 0) {
            return;
        }
        to_sales to3 = (to_sales) tbl_sales_ALM.get(tbl_sales.
                convertRowIndexToModel(row3));

        int id = to.id;
        String barcode = to.barcode;
        String description = to.description;
        String generic_name = to.generic_name;
        String category = to.category;
        String category_id = to.category_id;
        String classification = to.classification;
        String classification_id = to.classification_id;
        String sub_classification = to.sub_classification;
        String sub_classification_id = to.sub_classification_id;
        double product_qty = to.product_qty;
        String unit = to.unit;
        double conversion = to.conversion;
        double selling_price = to.selling_price;
        String date_added = to.date_added;
        String user_name = to.user_name;
        String item_type = to.item_type;
        int status = to.status;
        String session_no = to.session_no;
        String item_discount = to.item_discount;
        double discount = to.discount;
        double discount_amount = to.discount_amount;
        String void_no = lbl_void_no.getText();
        int fixed_price = to.fixed_price;
        String supplier = to.supplier;
        String supplier_id = to.supplier_id;
        int vatable = to.vatable;
        String or_no = to.or_no;

//        S1_void_items.to_void_items to2 = new S1_void_items.to_void_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, void_no, fixed_price, supplier, supplier_id, vatable, or_no);
//        if (to.status >= 0) {
//            S1_void_items.add_void_items(to2, to3);
//            Alert.set(1, "");
//            data_cols_or();
//            tbl_sales.setRowSelectionInterval(row3, row3);
//            data_cols();
//        }
    }

    private void void_or() {
        final int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }

        Window p = (Window) this;
        Dlg_prompt_void2 nd = Dlg_prompt_void2.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_prompt_void2.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_prompt_void2.OutputData data) {
                closeDialog.ok();
                to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
                int status = 0;
                if (to.status == 0) {
                    status = 1;
                }
                List<to_sales_items> datas = tbl_sales_items_ALM;
                if (to.payment_type_id.equals("1")) {
                    S1_sales.void_sales(to, status, datas);
                } else {
//                    JOptionPane.showMessageDialog(null, "");
                    S1_sales.void_sales2(to, status, datas);
                }

                data_cols_or();
                tbl_sales.setRowSelectionInterval(row, row);
                data_cols();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
}
