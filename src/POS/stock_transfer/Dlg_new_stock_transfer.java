/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.items.S1_items;
import POS.locations.Dlg_locations;
import POS.locations.S1_locations;
import static POS.locations.S1_locations.get_default_location;
import POS.receipts.Dlg_confirm_action;
import POS.stock_transfer.S1_stock_transfer_items.to_stock_transfer_items;
import POS.stock_transfer.S1_stock_transfers.to_stock_transfers;
import POS.stocks.Dlg_stocks_available;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_new_stock_transfer extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_stock_transfer
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
    private Dlg_new_stock_transfer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_stock_transfer(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_stock_transfer() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_stock_transfer myRef;

    private void setThisRef(Dlg_new_stock_transfer myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_stock_transfer> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_stock_transfer create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_stock_transfer create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_stock_transfer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer((java.awt.Frame) parent, false);
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
            Dlg_new_stock_transfer dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer((java.awt.Dialog) parent, false);
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

        Dlg_new_stock_transfer dialog = Dlg_new_stock_transfer.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new Field.Combo();
        jLabel23 = new javax.swing.JLabel();
        jTextField9 = new Field.Combo();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new Field.Input();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new Button.Default();
        jButton3 = new Button.Primary();
        jButton2 = new Button.Info();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stock_transfer_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField1 = new Field.Search();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_stock_transfers = new javax.swing.JTable();
        jTextField2 = new Field.Search();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        pnl_sales_items2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("From:");

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

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("To:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("+");
        jTextField8.setFocusable(false);
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

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("+");
        jTextField10.setFocusable(false);
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ref. No. :");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Remarks:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Post");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jTextField9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_transfer_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfer_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfer_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stock_transfer_items);

        jLabel1.setText("Total Items:");

        jLabel2.setText("0");

        jLabel3.setText("Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Item:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock Transfer", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Reference No");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Transaction No");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Search by:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Delivered:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("All");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("From:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("To:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox4)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_transfers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_stock_transfers);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Posted", jPanel3);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Status:");

        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(816, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_sales_items2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_sales_items2Layout = new javax.swing.GroupLayout(pnl_sales_items2);
        pnl_sales_items2.setLayout(pnl_sales_items2Layout);
        pnl_sales_items2Layout.setHorizontalGroup(
            pnl_sales_items2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_sales_items2Layout.setVerticalGroup(
            pnl_sales_items2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_sales_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_sales_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Stocks Available", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        init_locations(jTextField7);
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        init_locations(jTextField7);
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        init_locations(jTextField9);
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        init_locations(jTextField9);
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        my_location();
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        my_location();
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        new_stock_transfer();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        post_stock_transfer();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_items();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_items();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tbl_stock_transfersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseClicked
        select_stock_transfer();
    }//GEN-LAST:event_tbl_stock_transfersMouseClicked

    private void tbl_stock_transfer_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfer_itemsMouseClicked
        delete_item();
    }//GEN-LAST:event_tbl_stock_transfer_itemsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data_stock_transfers();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        data_stock_transfers();
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pnl_sales_items2;
    private javax.swing.JTable tbl_stock_transfer_items;
    private javax.swing.JTable tbl_stock_transfers;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_location();

        init_tbl_stock_transfer_items(tbl_stock_transfer_items);
        init_tbl_stock_transfers(tbl_stock_transfers);
        data_stock_transfers();
        add_stocks_available();
    }

     private void add_stocks_available(){
        Dlg_stocks_available nd=new Dlg_stocks_available();
        jPanel11.setLayout(new BorderLayout());
        jPanel11.add(nd.getSurface());
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

    private void set_default_location() {
        Field.Combo tf = (Field.Combo) jTextField7;
        S1_locations.to_locations def_location = get_default_location();
        tf.setText(def_location.name);
        tf.setId("" + def_location.id);

    }

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

    private void my_location() {
        Window p = (Window) this;
        Dlg_locations nd = Dlg_locations.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_locations.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_locations.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    List<S1_items.to_items> item_list = new ArrayList();

    private void init_items() {
        Field.Combo loc = (Field.Combo) jTextField7;
        System.out.println("From Location: " + loc.getId());
        String search = jTextField1.getText();
        item_list.clear();
        String where = " where barcode like '%" + search + "%' and location_id='" + loc.getId() + "' "
                + " or description like '%" + search + "%' and location_id='" + loc.getId() + "' "
                + " order by description asc";

        item_list = S1_items.ret_where(where);
        Object[][] obj = new Object[item_list.size()][3];
        int i = 0;
        for (S1_items.to_items to : item_list) {
            obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
            obj[i][1] = " " + to.barcode;
            obj[i][2] = " " + to.description;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {60, 100, jTextField1.getWidth() - 150};
        int width = 0;
        String[] col_names = {"", "", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_items.to_items to = item_list.get(data.selected_row);
                add_item(to);
            }
        });
    }

    private void add_item(final S1_items.to_items to) {
        Window p = (Window) this;
        Dlg_stock_transfers_qty nd = Dlg_stock_transfers_qty.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_stock_transfers_qty.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_stock_transfers_qty.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String receipt_no = "";
                String user_name = "";
                String session_no = "";
                String date_added = "";
                String supplier = "";
                String supllier_id = "";
                String remarks = "";
                String barcode = to.barcode;
                String description = to.description;
                double qty = data.qty;
                double cost = to.selling_price;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_class = to.sub_classification;
                String sub_class_id = to.sub_classification_id;
                String conversion = "" + to.conversion;
                String unit = to.unit;
                int status = 0;
                String reference_no = "";
                String from_location_name = "";
                String from_location_id = "";
                String to_location_name = "";
                String to_location_id = "";

                S1_stock_transfer_items.to_stock_transfer_items item = new to_stock_transfer_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
                tbl_stock_transfer_items_ALM.add(item);
            }
        }
        );
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void post_stock_transfer() {

        Field.Combo from = (Field.Combo) jTextField7;
        Field.Combo to = (Field.Combo) jTextField9;

        if (to.getId() == null || to.getId().isEmpty()) {
            Alert.set(0, "Select Location to be transfered!");
            return;
        }
        int id = 0;
        String stock_transfer_no = S1_stock_transfers.increment_id();
        String user_name = Users.get_username();
        String session_no = "";
        String date_added = DateType.now();
        String supplier = "";
        String supplier_id = "";
        String remarks = jTextArea1.getText();
        int status = 0;
        String reference_no = jTextField4.getText();
        String from_location_name = from.getText();
        String from_location_id = from.getId();
        String to_location_name = to.getText();
        String to_location_id = to.getId();

        S1_stock_transfers.to_stock_transfers stock_transfer = new S1_stock_transfers.to_stock_transfers(id, stock_transfer_no, user_name, session_no, date_added, supplier, supplier_id, remarks, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
        S1_stock_transfers.add_data(stock_transfer);
        List<to_stock_transfer_items> items = tbl_stock_transfer_items_ALM;
        S1_stock_transfer_items.add_data(items, stock_transfer);
        tbl_stock_transfer_items_ALM.clear();
        tbl_stock_transfer_items_M.fireTableDataChanged();

        jTextArea1.setText("");
        jTextField4.setText("");
        jTextField1.grabFocus();
        data_stock_transfers();
        Alert.set(0, "Transaction Posted!");

    }

    //<editor-fold defaultstate="collapsed" desc=" stock_transfer_items "> 
    public static ArrayListModel tbl_stock_transfer_items_ALM;
    public static Tblstock_transfer_itemsModel tbl_stock_transfer_items_M;

    public static void init_tbl_stock_transfer_items(JTable tbl_stock_transfer_items) {
        tbl_stock_transfer_items_ALM = new ArrayListModel();
        tbl_stock_transfer_items_M = new Tblstock_transfer_itemsModel(tbl_stock_transfer_items_ALM);
        tbl_stock_transfer_items.setModel(tbl_stock_transfer_items_M);
        tbl_stock_transfer_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfer_items.setRowHeight(25);
        int[] tbl_widths_stock_transfer_items = {50, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfer_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfer_items, i, tbl_widths_stock_transfer_items[i]);
        }
        Dimension d = tbl_stock_transfer_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfer_items.getTableHeader().setPreferredSize(d);
        tbl_stock_transfer_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfer_items.setRowHeight(25);
        tbl_stock_transfer_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_stock_transfer_items, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_stock_transfer_items, 4);
    }

    public static void loadData_stock_transfer_items(List<to_stock_transfer_items> acc) {
        tbl_stock_transfer_items_ALM.clear();
        tbl_stock_transfer_items_ALM.addAll(acc);

    }

    public static class Tblstock_transfer_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Cost", "Amount", "", "", "remarks", "barcode", "description", "qty", "cost", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "status", "reference_no", "from_location_name", "from_location_id", "to_location_name", "to_location_id"
        };

        public Tblstock_transfer_itemsModel(ListModel listmodel) {
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
            to_stock_transfer_items tt = (to_stock_transfer_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.qty * tt.cost) + " ";
                case 5:
                    return tt.supplier;
                case 6:
                    return tt.supllier_id;
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.barcode;
                case 9:
                    return tt.description;
                case 10:
                    return tt.qty;
                case 11:
                    return tt.cost;
                case 12:
                    return tt.category;
                case 13:
                    return tt.category_id;
                case 14:
                    return tt.classification;
                case 15:
                    return tt.classification_id;
                case 16:
                    return tt.sub_class;
                case 17:
                    return tt.sub_class_id;
                case 18:
                    return tt.conversion;
                case 19:
                    return tt.unit;
                case 20:
                    return tt.status;
                case 21:
                    return tt.reference_no;
                case 22:
                    return tt.from_location_name;
                case 23:
                    return tt.from_location_id;
                case 24:
                    return tt.to_location_name;
                default:
                    return tt.to_location_id;
            }
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" stock_transfers "> 
    public static ArrayListModel tbl_stock_transfers_ALM;
    public static Tblstock_transfersModel tbl_stock_transfers_M;

    public static void init_tbl_stock_transfers(JTable tbl_stock_transfers) {
        tbl_stock_transfers_ALM = new ArrayListModel();
        tbl_stock_transfers_M = new Tblstock_transfersModel(tbl_stock_transfers_ALM);
        tbl_stock_transfers.setModel(tbl_stock_transfers_M);
        tbl_stock_transfers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers.setRowHeight(25);
        int[] tbl_widths_stock_transfers = {100, 100, 100, 60, 60, 60, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers.length; i < n; i++) {
            if (i == 1 || i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers, i, tbl_widths_stock_transfers[i]);
        }
        Dimension d = tbl_stock_transfers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers.setRowHeight(25);
        tbl_stock_transfers.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_stock_transfers(List<to_stock_transfers> acc) {
        tbl_stock_transfers_ALM.clear();
        tbl_stock_transfers_ALM.addAll(acc);
    }

    public static class Tblstock_transfersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference No", "Location [From]", "Location [To]", "", "", "", "supplier_id", "remarks", "status", "reference_no", "from_location_name", "from_location_id", "to_location_name", "to_location_id"
        };

        public Tblstock_transfersModel(ListModel listmodel) {
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
            to_stock_transfers tt = (to_stock_transfers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.reference_no;
                case 1:
                    return " " + tt.from_location_name;
                case 2:
                    return " " + tt.to_location_name;
                case 3:
                    return " Update";
                case 4:
                    return " Delete";
                case 5:
                    return " Preview";
                case 6:
                    return tt.supplier_id;
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.status;
                case 9:
                    return tt.reference_no;
                case 10:
                    return tt.from_location_name;
                case 11:
                    return tt.from_location_id;
                case 12:
                    return tt.to_location_name;
                default:
                    return tt.to_location_id;
            }
        }
    }
//</editor-fold> 

    private void data_stock_transfers() {
        String where = " ";
        if (jCheckBox1.isSelected()) {
            where = " where stock_transfer_no like '%" + jTextField2.getText() + "%' ";
        } else {
            where = " where reference_no like '%" + jTextField2.getText() + "%' ";
        }
        String from = DateType.sf.format(jDateChooser3.getDate());
        String to = DateType.sf.format(jDateChooser4.getDate());
        if (jCheckBox4.isSelected()) {
            where = where + " and Date(date_added) between '" + from + "' and '" + to + "'  ";
        }
        where = where + " order by id desc";
        System.out.println(where);
        List<to_stock_transfers> datas = S1_stock_transfers.ret_data(where);
        loadData_stock_transfers(datas);
    }

    private void select_stock_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_stock_transfers to = (to_stock_transfers) tbl_stock_transfers_ALM.get(row);
        String where = " where receipt_no='" + to.stock_transfer_no + "' ";
        final List<to_stock_transfer_items> datas = S1_stock_transfer_items.ret_data(where);

        int col = tbl_stock_transfers.getSelectedColumn();
        if (col == 3) {
            jTextArea1.setText(to.remarks);
            jTextField4.setText(to.reference_no);
            Field.Combo from = (Field.Combo) jTextField7;
            Field.Combo too = (Field.Combo) jTextField9;
            from.setText(to.from_location_name);
            from.setId(to.from_location_id);
            too.setText(to.to_location_name);
            too.setId(to.to_location_id);
            loadData_stock_transfer_items(datas);
            jTabbedPane1.setSelectedIndex(0);
            jButton2.setEnabled(true);
            jTextField1.grabFocus();
        }
        if (col == 4) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    S1_stock_transfers.delete_data(to, datas);
                    data_stock_transfers();
                    jTextField4.setText("");
                    jTextArea1.setText("");
                    tbl_stock_transfer_items_ALM.clear();
                    tbl_stock_transfer_items_M.fireTableDataChanged();
                    Alert.set(0, "Transaction Deleted!");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
        if (col == 5) {
            get_data2(to);
        }
    }

    private void new_stock_transfer() {
        jButton2.setEnabled(false);
        Field.Combo from = (Field.Combo) jTextField7;
        Field.Combo too = (Field.Combo) jTextField9;
        jTextField4.setText("");
        jTextArea1.setText("");
        tbl_stock_transfer_items_ALM.clear();
        tbl_stock_transfer_items_M.fireTableDataChanged();
    }

    private void get_data2(final to_stock_transfers to) {
        jTabbedPane1.setSelectedIndex(2);
        jProgressBar3.setString("Loading...Please wait...");
        jProgressBar3.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where receipt_no='" + to.stock_transfer_no + "' ";
                List<Srpt_stock_transfer.field> fields = Srpt_stock_transfer.ret_data(where);
                String from_location = to.from_location_name;
                String to_location = to.to_location_name;
                String reference_no = to.reference_no;
                String remarks = to.remarks;
                String date_transfered = DateType.convert_slash_datetime2(to.date_added);
                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");

                Srpt_stock_transfer rpt = new Srpt_stock_transfer(from_location, to_location, reference_no, remarks, date_transfered, business_name, address);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_stock_transfer.jrxml";

                report_sales_items2(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_sales_items2(final Srpt_stock_transfer to, String jrxml_name) {
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

    public static JRViewer get_viewer_all_sales2(Srpt_stock_transfer to, String rpt_name) {
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
            InputStream is = Srpt_stock_transfer.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete_item() {
        int row = tbl_stock_transfer_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_stock_transfer_items_ALM.remove(row);
        tbl_stock_transfer_items_M.fireTableDataChanged();
    }
}
