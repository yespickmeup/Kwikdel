/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.accounts_receivable;

import POS.accounts_receivable.S1_accounts_receivable.to_accounts_receivable;
import POS.customers.S1_customers;
import POS.main.Main;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.TextHighlighter1;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author i1
 */
public class Dlg_accounts_receivable extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_accounts_receivable
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
    private Dlg_accounts_receivable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_accounts_receivable(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_accounts_receivable() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_accounts_receivable myRef;

    private void setThisRef(Dlg_accounts_receivable myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_accounts_receivable> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_accounts_receivable create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_accounts_receivable create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_accounts_receivable dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_accounts_receivable((java.awt.Frame) parent, false);
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
            Dlg_accounts_receivable dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_accounts_receivable((java.awt.Dialog) parent, false);
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


        Dlg_accounts_receivable dialog = Dlg_accounts_receivable.create(new javax.swing.JFrame(), true);
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
        tbl_customers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_accounts_receivable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_customers.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_customers);

        jLabel1.setText("SEARCH:");

        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TOTAL:");

        lbl_total.setBackground(new java.awt.Color(51, 153, 255));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.00");
        lbl_total.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_search)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
        jScrollPane2.setViewportView(tbl_accounts_receivable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here: data_cols() 
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customersMouseClicked
        data_cols_ar();
    }//GEN-LAST:event_tbl_customersMouseClicked

    private void tbl_accounts_receivableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_accounts_receivableMouseClicked
        select_accounts_payable();

    }//GEN-LAST:event_tbl_accounts_receivableMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_accounts_receivable;
    private javax.swing.JTable tbl_customers;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_algorithm");
        init_key();
        init_tbl_customers();
        init_tbl_accounts_receivable();


    }

    public class CustomRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 6703872492730589499L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 1).
                    equals("")) {
                cellComponent.setBackground(Color.WHITE);
            } else {
                cellComponent.setBackground(Color.LIGHT_GRAY);
            }
            return cellComponent;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        tbl_customers.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    data_cols_ar();
                    e.consume();

                }
            }
        });
        tbl_customers.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!tbl_accounts_receivable_ALM.isEmpty()) {
                        tbl_accounts_receivable.setRowSelectionInterval(0, 0);
                        tbl_accounts_receivable.grabFocus();
                    }
                }
            }
        });
        tbl_accounts_receivable.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    select_accounts_payable();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    select_payment();
                    e.consume();
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                disposed();
            }
        });
        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_customers_ALM.isEmpty()) {
                        tbl_customers.setRowSelectionInterval(0, 0);
                        tbl_customers.grabFocus();
                    }
                }
            }
        });
    }
    // </editor-fold>

    private void select_payment() {
//        int[] rows = tbl_accounts_receivable.getSelectedRows();
//        if (rows.length == 1) {
//            single_payment();
//        }
//        if (rows.length > 1) {
//        }
//        if (rows.length == 0) {
//        }
        get_ar_selected();
    }

    private void get_ar_selected() {
        List<to_accounts_receivable> datas = tbl_accounts_receivable_ALM;
        final List<to_accounts_receivable> selected_ap = new ArrayList();
        for (to_accounts_receivable t : datas) {
            if (t.selected == true) {
                selected_ap.add(t);
            }

        }

        double total = 0;
        int i = 0;
        for (to_accounts_receivable t1 : selected_ap) {
            total += t1.remaining_balance;
            i++;
        }
        if (i == 1) {
            to_accounts_receivable t11 = null;
            for (to_accounts_receivable t1 : selected_ap) {
                t11 = t1;
            }
            single_payment(t11);
        } else {

            Window p = (Window) this;
            Dlg_ar_payment nd = Dlg_ar_payment.create(p, true);
            nd.setTitle("");
            nd.do_pass2(total);
            nd.setCallback(new Dlg_ar_payment.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_ar_payment.OutputData data) {
                    closeDialog.ok();
                    String date_added = DateType.datetime.format(new Date());
                    String user_name = Users.user_name;
                    double discount_amount = 0;
                    double discount_rate = 0;
                    String discount = "";
                    int status = 0;
                    double term = 0;
                    String date_applied = DateType.sf.format(new Date());
                    double paid = 0;
                    String date_paid = DateType.sf.format(new Date());
                    String remarks = "";
                    String type = "CASH";
                    double prev_balance = 0;
                    for (to_accounts_receivable ap : selected_ap) {
                        String customer_id = ap.customer_id;
                        String customer_name = ap.customer_name;
                        String ar_no = ap.ar_no;
                        String or_no = ap.or_no;
                        double amount = ap.remaining_balance;

                        double check_amount = 0;
                        String check_holder = "";
                        String check_bank = "";
                        String check_no = "";

                        S1_accounts_receivable_payments.to_accounts_receivable_payments to = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                                status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term
                                , date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder
                                , check_bank, check_no,"","","");
//                        JOptionPane.showMessageDialog(null, amount);
//                        if (to.amount != 0) {
                        S1_accounts_receivable_payments.
                                add_accounts_receivable_payments(to);
//                        }
                    }
                    data_cols_ar();
                    data_cols();
                    tf_search.grabFocus();
                    Alert.set(1, type);
                }
            });
            nd.setLocationRelativeTo(jPanel3);
            nd.setVisible(
                    true);
        }

    }

    private void single_payment(final to_accounts_receivable to) {
        final int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        Window p = (Window) this;
        Dlg_ar_payment nd = Dlg_ar_payment.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.remaining_balance);
        nd.setCallback(new Dlg_ar_payment.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_ar_payment.OutputData data) {
                closeDialog.ok();
                String customer_id = to.customer_id;
                String customer_name = to.customer_name;
                String ar_no = to.ar_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.user_name;
                double amount = data.amount;
                double discount_amount = 0;
                double discount_rate = 0;
                String discount = "";
                int status = 0;
                double term = 0;
                String date_applied = DateType.sf.format(new Date());
                double paid = 0;
                String date_paid = DateType.sf.format(new Date());
                String remarks = "";
                String type = "CASH";
                String or_no = to.or_no;
                double prev_balance = 0;
                double check_amount = 0;
                String check_holder = "";
                String check_bank = "";
                String check_no = "";
                S1_accounts_receivable_payments.to_accounts_receivable_payments to = new S1_accounts_receivable_payments.to_accounts_receivable_payments(
                        status, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied
                        , paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no,"","","");
                S1_accounts_receivable_payments.add_accounts_receivable_payments(to);
                data_cols_ar();
                data_cols();
                tbl_customers.setRowSelectionInterval(row, row);
                tf_search.grabFocus();
                Alert.set(1, type);
            }
        });
        nd.setLocationRelativeTo(jPanel3);

        nd.setVisible(
                true);
    }
    private ArrayListModel tbl_customers_ALM;
    private TblcustomersModel tbl_customers_M;

    private void init_tbl_customers() {
        tbl_customers_ALM = new ArrayListModel();
        tbl_customers_M = new TblcustomersModel(tbl_customers_ALM);
        tbl_customers.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_customers.setModel(tbl_customers_M);
        tbl_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_customers.setRowHeight(25);
        int[] tbl_widths_customers = {0, 100, 80, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_customers, i, tbl_widths_customers[i]);
        }
        Dimension d = tbl_customers.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_customers.getTableHeader().
                setPreferredSize(d);
        tbl_customers.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_customers.setRowHeight(35);
        tbl_customers.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 3);

    }

    private void loadData_customers(List<S1_customers.to_customers> acc) {
        tbl_customers_ALM.clear();
        tbl_customers_ALM.addAll(acc);


    }

    public static class TblcustomersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "NAME", "BALANCE", "RECEIVABLE", "credit_limit", "address", "term", "location", "balance", "discount"
        };

        public TblcustomersModel(ListModel listmodel) {
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
            S1_customers.to_customers tt = (S1_customers.to_customers) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.customer_name;
                case 2:
                    return FitIn.fmt_wc_0(tt.balance);
                case 3:
                    return tt.contact_no;
                case 4:
                    return tt.credit_limit;
                case 5:
                    return tt.address;
                case 6:
                    return tt.term;
                case 7:
                    return tt.location;
                case 8:
                    return tt.balance;
                default:
                    return tt.discount;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        loadData_customers(S1_customers.ret_data(search));

        List<S1_customers.to_customers> datas = tbl_customers_ALM;
        double total = 0;
        for (S1_customers.to_customers t : datas) {
            total += t.balance;
        }
        lbl_total.setText(FitIn.fmt_wc_0(total));
    }
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
        int[] tbl_widths_accounts_receivable = {50, 100, 100, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_accounts_receivable.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_accounts_receivable, i, tbl_widths_accounts_receivable[i]);
        }
        Dimension d = tbl_accounts_receivable.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_accounts_receivable.getTableHeader().
                setPreferredSize(d);
        tbl_accounts_receivable.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable.setRowHeight(35);
        tbl_accounts_receivable.setFont(new java.awt.Font("Arial", 0, 11));
        tbl_accounts_receivable.getColumnModel().
                getColumn(1).
                setCellRenderer(new CustomRenderer());
        tbl_accounts_receivable.getColumnModel().
                getColumn(2).
                setCellRenderer(new CustomRenderer());
        tbl_accounts_receivable.getColumnModel().
                getColumn(3).
                setCellRenderer(new CustomRenderer());
        tbl_accounts_receivable.getColumnModel().
                getColumn(4).
                setCellRenderer(new CustomRenderer());
        tbl_accounts_receivable.getColumnModel().
                getColumn(5).
                setCellRenderer(new CustomRenderer());
        tbl_accounts_receivable.getColumnModel().
                getColumn(6).
                setCellRenderer(new CustomRenderer());

    }

    private void loadData_accounts_receivable(List<to_accounts_receivable> acc) {
        tbl_accounts_receivable_ALM.clear();
        tbl_accounts_receivable_ALM.addAll(acc);
    }

    public static class Tblaccounts_receivableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "", "DATE", "TERM", "CHARGE", "APPLIED", "PAYMENT", "BALANCE", "discount_amount", "discount_rate", "discount", "status", "term", "date_applied", "paid", "date_paid", "remarks", "type"
        };

        public Tblaccounts_receivableModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 111) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 0) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_accounts_receivable tt = (to_accounts_receivable) getRow(row);
            switch (col) {
                case 0:
                    return tt.selected;
                case 1:
                    if (tt.type.equals("PURCHASES")) {
                        return tt.date_applied;
                    } else {
                        return "";
                    }

                case 2:
                    if (tt.type.equals("PURCHASES")) {
                        return FitIn.fmt_woc(tt.term) + " MONTH/S";
                    } else {
                        return "";
                    }

                case 3:
                    if (tt.type.equals("PURCHASES")) {
                        return FitIn.fmt_wc_0(tt.amount);
                    } else {
                        return "";
                    }
                case 4:
                    return tt.date_applied;
                case 5:
                    if (tt.type.equals("PURCHASES")) {
                        return "";
                    } else {
                        return FitIn.fmt_wc_0(tt.amount);
                    }
                case 6:
                    if (tt.type.equals("PURCHASES")) {
                        return TextHighlighter1.highlight3(FitIn.fmt_wc_0(tt.paid), FitIn.
                                fmt_wc_0(tt.paid), "");
                    } else {
                        return FitIn.fmt_wc_0(tt.paid);
                    }

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
                default:
                    return tt.type;
            }
        }
    }

    private void data_cols_ar() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }

        S1_customers.to_customers to = (S1_customers.to_customers) tbl_customers_ALM.
                get(tbl_customers.convertRowIndexToModel(row));
        loadData_accounts_receivable(S1_accounts_receivable.ret_data(to.customer_no));

    }

    private void select_accounts_payable() {
        int row = tbl_accounts_receivable.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_accounts_receivable to = (to_accounts_receivable) tbl_accounts_receivable_ALM.
                get(tbl_accounts_receivable.convertRowIndexToModel(row));
        if (to.ap_main == 1) {
            if (to.selected == true) {
                to.setSelected(false);
            } else {
                to.setSelected(true);
            }
        }

        tbl_accounts_receivable_M.fireTableDataChanged();
    }
}
