/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.main.Main;
import POS.services.S1_services;
import POS.services.S1_services.to_services;
import POS.util.Alert;
import POS.util.Courier;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import mijzcx.synapse.desk.utils.SearchField;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_payment_services extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_payment_services
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

        public final List<to_services> services;
        public final String services_name;
        public final double total;

        public OutputData(List<to_services> services, String services_name, double total) {
            this.services = services;
            this.services_name = services_name;
            this.total = total;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_payment_services(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_payment_services(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_payment_services() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_payment_services myRef;

    private void setThisRef(Dlg_payment_services myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_payment_services> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_payment_services create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_payment_services create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_payment_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_payment_services((java.awt.Frame) parent, false);
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
            Dlg_payment_services dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_payment_services((java.awt.Dialog) parent, false);
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

        Dlg_payment_services dialog = Dlg_payment_services.create(new javax.swing.JFrame(), true);
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
        tbl_services = new javax.swing.JTable();
        tf_services = new javax.swing.JTextField();
        tf_amount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_services.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_services);

        tf_services.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_servicesActionPerformed(evt);
            }
        });

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Delete List (Del), Close (Ctrl)");

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0.00");
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TOTAL:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_services)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(202, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(104, 104, 104)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_services, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(tf_amount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        // TODO add your handling code here:
        add_service();
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tf_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_servicesActionPerformed
        init_services();
    }//GEN-LAST:event_tf_servicesActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_services;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_services;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        Main.MyDB.setNames("db_fortune_three");
        init_key();
        init_tf();
        focus();
        init_tbl_services();
    }

    private void focus() {
        JTextField[] tf = {tf_services, tf_amount};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    public void do_pass(List<to_services> services) {
        tbl_services_ALM.addAll(services);
        tbl_services_M.fireTableDataChanged();
        compute();
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_DELETE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                clear_all();
//                disposed();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_CONTROL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                ok1();
            }
        });
        tf_amount.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_services_ALM.isEmpty()) {
                        tbl_services.setRowSelectionInterval(0, 0);
                        tbl_services.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tbl_services.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    delete_service();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_services.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

    }
    // </editor-fold>

    private void init_tf() {

    }
    private ArrayListModel tbl_services_ALM;
    private TblservicesModel tbl_services_M;

    private void init_tbl_services() {
        tbl_services_ALM = new ArrayListModel();
        tbl_services_M = new TblservicesModel(tbl_services_ALM);
        tbl_services.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_services.setModel(tbl_services_M);
        tbl_services.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_services.setRowHeight(25);
        int[] tbl_widths_services = {0, 100, 100};
        for (int i = 0, n = tbl_widths_services.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_services, i, tbl_widths_services[i]);
        }
        Dimension d = tbl_services.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_services.getTableHeader().
                setPreferredSize(d);
        tbl_services.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_services.setRowHeight(35);
        tbl_services.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_services(List<to_services> acc) {
        tbl_services_ALM.clear();
        tbl_services_ALM.addAll(acc);
    }

    public static class TblservicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "NAME", "AMOUNT"
        };

        public TblservicesModel(ListModel listmodel) {
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
            to_services tt = (to_services) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.service_name;
                default:
                    return tt.amount;
            }
        }
    }

    List<S1_services.to_services> services_list = new ArrayList();

    private void init_services() {
        String search = tf_services.getText();
        services_list.clear();
        services_list = S1_services.ret_data2("");
        Object[][] obj = new Object[services_list.size()][2];
        int i = 0;
        for (S1_services.to_services to : services_list) {
            obj[i][1] = " " + to.service_name;
            obj[i][0] = " " + FitIn.fmt_wc_0(to.amount);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {40, 100};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_services, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_services.to_services to = services_list.get(data.selected_row);
                tf_services.setText(to.service_name);
                tf_amount.setText(FitIn.fmt_wc_0(to.amount));
                tf_amount.grabFocus();
            }
        });
    }

    private void add_service() {
        List<to_services> acc = new ArrayList();
        int id = 0;
        String name = tf_services.getText();
        double amount = FitIn.toDouble(tf_amount.getText());
        to_services to = new to_services(id, name, amount);
        acc.add(to);
        tbl_services_ALM.addAll(acc);
        tbl_services_M.fireTableDataChanged();
        tf_services.grabFocus();
        compute();
    }

    private void compute() {
        List<to_services> acc = tbl_services_ALM;
        double total = 0;
        for (to_services to : acc) {
            total += to.amount;
        }
        lbl_total.setText(FitIn.fmt_wc_0((total)));
    }

    private void delete_service() {
        int row = tbl_services.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_services_ALM.remove(row);
        tbl_services_M.fireTableDataChanged();
        tf_services.grabFocus();
        compute();

    }

    private void ok1() {

        List<to_services> services = tbl_services_ALM;
        String service_name = "";
        int i = 0;
        for (to_services t : services) {
            if (i == 0) {
                service_name = service_name + "" + t.service_name;
            } else {
                service_name = service_name + " ," + t.service_name;
            }
            i++;
        }
        double total = FitIn.toDouble(lbl_total.getText());
//        if (total <= 0) {
//            Alert.set(0, "NO SERVICE ADDED");
//        }
        System.out.println("asdads");
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(services, service_name, total));
        }
    }

    private void clear_all() {
        tbl_services_ALM.clear();
        tbl_services_M.fireTableDataChanged();
        compute();
    }
}
