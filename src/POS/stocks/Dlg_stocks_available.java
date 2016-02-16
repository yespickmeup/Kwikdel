/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stocks;

import POS.items.S1_items;
import POS.locations.S1_locations;
import static POS.locations.S1_locations.get_default_location;
import static POS.stocks.Srpt_stocks_available.ret_data;
import POS.util.DateType;
import POS.util.TableRenderer;
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
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_stocks_available extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_stocks_available
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
    private Dlg_stocks_available(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }
    
    private Dlg_stocks_available(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }
    
    public Dlg_stocks_available() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();
        
    }
    private Dlg_stocks_available myRef;
    
    private void setThisRef(Dlg_stocks_available myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_stocks_available> dialogContainer = new java.util.HashMap();
    
    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }
    
    public static Dlg_stocks_available create(java.awt.Window parent, boolean modal) {
        
        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }
        
        return create(parent, ModalityType.MODELESS);
        
    }
    
    public static Dlg_stocks_available create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {
        
        if (parent instanceof java.awt.Frame) {
            
            Dlg_stocks_available dialog = dialogContainer.get(parent);
            
            if (dialog == null) {
                dialog = new Dlg_stocks_available((java.awt.Frame) parent, false);
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
            Dlg_stocks_available dialog = dialogContainer.get(parent);
            
            if (dialog == null) {
                dialog = new Dlg_stocks_available((java.awt.Dialog) parent, false);
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
        
        Dlg_stocks_available dialog = Dlg_stocks_available.create(new javax.swing.JFrame(), true);
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

        pnl_sales_items2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new Field.Combo();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jTextField8 = new Field.Search();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_sales_items2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_sales_items2Layout = new javax.swing.GroupLayout(pnl_sales_items2);
        pnl_sales_items2.setLayout(pnl_sales_items2Layout);
        pnl_sales_items2Layout.setHorizontalGroup(
            pnl_sales_items2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_sales_items2Layout.setVerticalGroup(
            pnl_sales_items2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        jLabel1.setText("Status:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Location:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("All");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Search:");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(304, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_sales_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_sales_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        init_locations(jTextField7);
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        init_locations(jTextField7);
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        get_data2();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel pnl_sales_items2;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_location();
        
    }
    
    private void set_default_location() {
        Field.Combo tf = (Field.Combo) jTextField7;
        S1_locations.to_locations def_location = get_default_location();
        tf.setText(def_location.name);
        tf.setId("" + def_location.id);
        
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

    List<S1_locations.to_locations> location_list = new ArrayList();
    
    private void init_locations(final JTextField tfs) {
        String search = tfs.getText();
        location_list.clear();
        String where = " where name like '%" + search + "%' order by name asc";
        location_list = S1_locations.ret_data(where);
        Object[][] obj = new Object[location_list.size()][1];
        int i = 0;
        for (S1_locations.to_locations to : location_list) {
            obj[i][0] = " " + to.name;
            
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tfs.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tfs, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo tf = (Field.Combo) tfs;
                S1_locations.to_locations to = location_list.get(data.selected_row);
                tf.setText(to.name);
                tf.setId("" + to.id);
            }
        });
    }
    
    private void get_data2() {
        
        jProgressBar3.setString("Loading...Please wait...");
        jProgressBar3.setIndeterminate(true);
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Field.Combo loc = (Field.Combo) jTextField7;
                Field.Search item = (Field.Search) jTextField8;
                String where = " ";
                
                where = where + " where description like '%" + jTextField8.getText() + "%'  ";
                if (!jCheckBox1.isSelected()) {
                    where = where + " and location_id='" + loc.getId() + "' ";
                }
                where = where + " order by description,location_name asc ";
                
                System.out.println(where);
                List<Srpt_stocks_available.field> fields = Srpt_stocks_available.ret_data(where);
                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
                String date = DateType.slash.format(new Date());
                Srpt_stocks_available rpt = new Srpt_stocks_available(business_name, address, date);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_stocks_available.jrxml";
                report_sales_items2(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });
        
        t.start();
    }
    
    private void report_sales_items2(final Srpt_stocks_available to, String jrxml_name) {
        pnl_sales_items2.removeAll();
        pnl_sales_items2.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_all_sales2(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_sales_items2.add(viewer);
            pnl_sales_items2.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static JRViewer get_viewer_all_sales2(Srpt_stocks_available to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper2(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
    
    public static JasperReport compileJasper2(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_stocks_available.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    
    List<S1_items.to_items> item_list = new ArrayList();
    
    private void init_items() {
        
        item_list.clear();
        String where = " where barcode like '%" + jTextField8.getText() + "%' "
                + " or description like '%" + jTextField8.getText() + "%' "
                + " order by description asc";
        
        item_list = S1_items.ret_where(where);
        Object[][] obj = new Object[item_list.size()][2];
        int i = 0;
        for (S1_items.to_items to : item_list) {
            
            obj[i][0] = " " + to.barcode;
            obj[i][1] = " " + to.description;
            
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, jTextField8.getWidth() - 100};
        int width = 0;
        String[] col_names = {"", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField8, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_items.to_items to = item_list.get(data.selected_row);
                Field.Search loc = (Field.Search) jTextField8;
                loc.setText(to.description);
                loc.setId(to.barcode);
            }
        });
    }
}
