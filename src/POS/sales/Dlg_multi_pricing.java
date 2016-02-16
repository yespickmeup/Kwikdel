/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.sales.S1_multi_pricing.to_multi_pricing;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTextField;
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
public class Dlg_multi_pricing extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_multi_pricing
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

        public final double qty;
        public final double price;
        public final String unit;
        public final double conversion;

        public OutputData(double qty, double price, String unit, double conversion) {
            this.qty = qty;
            this.price = price;
            this.unit = unit;
            this.conversion = conversion;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_multi_pricing(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_multi_pricing(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_multi_pricing() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_multi_pricing myRef;

    private void setThisRef(Dlg_multi_pricing myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_multi_pricing> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_multi_pricing create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_multi_pricing create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_multi_pricing dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_multi_pricing((java.awt.Frame) parent, false);
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
            Dlg_multi_pricing dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_multi_pricing((java.awt.Dialog) parent, false);
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


        Dlg_multi_pricing dialog = Dlg_multi_pricing.create(new javax.swing.JFrame(), true);
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
        tbl_multi_pricing = new javax.swing.JTable()
        {

            @Override
            public void changeSelection(int r, int c, boolean tgl, boolean ext) {
                super.changeSelection(r, c, tgl, ext);
                if( this.isCellEditable(r, c)) {
                    this.editCellAt(r, c);

                    Component comp = this.getEditorComponent();
                    if(comp instanceof JTextField) {
                        JTextField f = (JTextField) this.getEditorComponent();
                        f.selectAll();
                        f.requestFocusInWindow();

                    }
                }
            }
        }

        ;
        lbl_name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_multi_pricing.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_multi_pricing);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_name.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTable tbl_multi_pricing;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_multi_pricing();

//        data_cols();
//        List<to_multi_pricing> datas = new ArrayList();
//        for (int i = 0; i < 5; i++) {
//            to_multi_pricing to = new to_multi_pricing(i, i, "PC " + i, i, 0);
//            datas.add(to);
//        }
//        loadData_multi_pricing(datas);
//        if (!tbl_multi_pricing_ALM.isEmpty()) {
//            tbl_multi_pricing.setRowSelectionInterval(0, 0);
//            tbl_multi_pricing.requestFocus();
////            tbl_multi_pricing.setC
//            tbl_multi_pricing.setColumnSelectionInterval(0, 4);
//            tbl_multi_pricing.setEditingColumn(4);
////            tbl_multi_pricing.editCellAt(0, 4);
//        }

    }

   
    public void do_pass(List<to_multi_pricing> datas, String desc) {
//        = new ArrayList();
//        for (int i = 0; i < 5; i++) {
//            to_multi_pricing to = new to_multi_pricing(i, i, "PC " + i, 0, 0);
//            datas.add(to);
//        }
        loadData_multi_pricing(datas);
        if (!tbl_multi_pricing_ALM.isEmpty()) {
//            tbl_multi_pricing.setRowSelectionInterval(0, 0);
            tbl_multi_pricing.grabFocus();
//            tbl_multi_pricing.setC
            tbl_multi_pricing.setColumnSelectionInterval(0, 4);
//            tbl_multi_pricing.setEditingColumn(4);
            tbl_multi_pricing.editCellAt(0, 4);
        }

        lbl_name.setText("  " + desc);
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
        tbl_multi_pricing.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
//                get_order();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    get_order();
//                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    clear_order();
                }
            }
        });
//        tbl_multi_pricing.add
    }

    private void clear_order() {
        List<to_multi_pricing> datas = tbl_multi_pricing_ALM;
        List<to_multi_pricing> datas2 = new ArrayList();

        for (to_multi_pricing to : datas) {
            to_multi_pricing t = new to_multi_pricing(to.id, to.qty, to.unit, to.price, 0, to.conversion);
            datas2.add(t);
        }
        tbl_multi_pricing_ALM.clear();
        tbl_multi_pricing_M.fireTableDataChanged();
        loadData_multi_pricing(datas2);
        if (!tbl_multi_pricing_ALM.isEmpty()) {
            tbl_multi_pricing.setRowSelectionInterval(0, 0);
            tbl_multi_pricing.requestFocus();
//            tbl_multi_pricing.setC
            tbl_multi_pricing.setColumnSelectionInterval(0, 4);
            tbl_multi_pricing.setEditingColumn(4);
            tbl_multi_pricing.editCellAt(0, 4);
        }
    }

    private void get_order() {
        List<to_multi_pricing> datas = tbl_multi_pricing_ALM;
        double qty = 0;
        double price = 0;
        String unit = "";
        double conversion = 0;
        for (to_multi_pricing to : datas) {
            if (to.invoice_qty > 0) {
                qty = to.invoice_qty;
                price = to.price;
                unit = to.unit;
                conversion = to.conversion;
                break;
            }
        }
//        System.out.println(" - " + qty);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(qty, price, unit, conversion));
        }
    }
    // </editor-fold>
    private ArrayListModel tbl_multi_pricing_ALM;
    private Tblmulti_pricingModel tbl_multi_pricing_M;

    private void init_tbl_multi_pricing() {
        tbl_multi_pricing_ALM = new ArrayListModel();
        tbl_multi_pricing_M = new Tblmulti_pricingModel(tbl_multi_pricing_ALM);
        tbl_multi_pricing.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_multi_pricing.setModel(tbl_multi_pricing_M);
        tbl_multi_pricing.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_multi_pricing.setRowHeight(25);
        int[] tbl_widths_multi_pricing = {0, 60, 100, 100, 60};
        for (int i = 0, n = tbl_widths_multi_pricing.length; i < n; i++) {
            if (i == 2) {
                continue;
            }

            TableWidthUtilities.setColumnWidth(tbl_multi_pricing, i, tbl_widths_multi_pricing[i]);
        }
        Dimension d = tbl_multi_pricing.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_multi_pricing.getTableHeader().
                setPreferredSize(d);
        tbl_multi_pricing.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_multi_pricing.setRowHeight(35);
        tbl_multi_pricing.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_multi_pricing(List<to_multi_pricing> acc) {
        tbl_multi_pricing_ALM.clear();
        tbl_multi_pricing_ALM.addAll(acc);
    }

    public static class Tblmulti_pricingModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "STOCK", "UNIT", "PRICE", "QTY"
        };

        public Tblmulti_pricingModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 4 || column == 3) {
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
            to_multi_pricing tt = (to_multi_pricing) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return FitIn.fmt_wc_0(tt.qty);
                case 2:
                    return tt.unit;
                case 3:
                    return FitIn.fmt_wc_0(tt.price);
                default:
                    if (tt.invoice_qty == 0) {
                        return "";
                    } else {
                        return FitIn.fmt_wc_0(tt.invoice_qty);
                    }

            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            to_multi_pricing tt = (to_multi_pricing) getRow(rowIndex);
            try {
                switch (columnIndex) {
                    case 4:

                        tt.setInvoice_qty(FitIn.toDouble(aValue.toString()));
                        break;
                }

                this.fireTableRowsUpdated(rowIndex, columnIndex);
            } catch (Exception e) {
            }

        }
    }
}
