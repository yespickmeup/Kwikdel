/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.items.S1_items;
import POS.locations.Dlg_locations;
import POS.locations.S1_locations;
import static POS.locations.S1_locations.get_default_location;
import POS.receipts.S1_receipt_items.to_receipt_items;
import POS.receipts.S1_receipts.to_receipts;
import POS.stocks.Dlg_stocks_available;
import POS.suppliers.Dlg_new_supplier;
import POS.suppliers.S1_suppliers;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Dlg_new_receipt extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_receipt
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
    private Dlg_new_receipt(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_receipt(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_receipt() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_receipt myRef;

    private void setThisRef(Dlg_new_receipt myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_receipt> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_receipt create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_receipt create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_receipt dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_receipt((java.awt.Frame) parent, false);
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
            Dlg_new_receipt dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_receipt((java.awt.Dialog) parent, false);
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

        Dlg_new_receipt dialog = Dlg_new_receipt.create(new javax.swing.JFrame(), true);
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
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new Field.Combo();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new Button.Info();
        jButton3 = new Button.Primary();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new Button.Default();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new Field.Input();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new Field.Combo();
        jTextField8 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField9 = new Field.Combo();
        jTextField10 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipt_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new Field.Search();
        jButton5 = new Button.Info();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new Field.Search();
        pnl_sales_items2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel19 = new javax.swing.JLabel();
        pnl_sales_items = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Supplier:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Remarks:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Date of Delivery:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Date Received:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setText("Update");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("+");
        jTextField3.setFocusable(false);
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Reference No:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Receiving");

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

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("location:");

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

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("+");
        jTextField10.setFocusable(false);
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9)
                            .addComponent(jTextField7))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jTextField10)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tbl_receipt_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipt_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receipt_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_receipt_items);

        jLabel1.setText("Total Items:");

        jLabel2.setText("0");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel3.setText("Status:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Item:");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receipts", jPanel2);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Search by:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Transaction No");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Reference No");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Supplier");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Delivered:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("From:");

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("To:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Received:");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("All");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("From:");

        jDateChooser5.setDate(new Date());
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("To:");

        jDateChooser6.setDate(new Date());
        jDateChooser6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3))
                    .addGroup(jPanel8Layout.createSequentialGroup()
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
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(525, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox4)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox5)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbl_receipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_receipts);

        jLabel9.setText("Total Transactions:");

        jLabel10.setText("0");

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

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Posted", jPanel3);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        jLabel20.setText("Status:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Item:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
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
            .addGap(0, 543, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_sales_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_sales_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventory Aging", jPanel5);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        jLabel19.setText("Status:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(816, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_sales_items.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_sales_itemsLayout = new javax.swing.GroupLayout(pnl_sales_items);
        pnl_sales_items.setLayout(pnl_sales_itemsLayout);
        pnl_sales_itemsLayout.setHorizontalGroup(
            pnl_sales_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_sales_itemsLayout.setVerticalGroup(
            pnl_sales_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_sales_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_sales_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Print Preview", jPanel4);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Stocks Availble", jPanel12);

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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_suppliers();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_suppliers();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_items();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_items();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        suppliers();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void tbl_receipt_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receipt_itemsMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_receipt_itemsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        post_receipt();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new_receipt();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        data_receipts();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        data_receipts();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        select_receipt();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update_receipt();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        update_receipt();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        init_items2();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        init_items2();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        init_locations(jTextField7);
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        init_locations(jTextField7);
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        my_location();
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        init_locations(jTextField9);
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        init_locations(jTextField9);
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        my_location();
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pnl_sales_items;
    private javax.swing.JPanel pnl_sales_items2;
    private javax.swing.JTable tbl_receipt_items;
    private javax.swing.JTable tbl_receipts;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_receipt_items(tbl_receipt_items);
        init_tbl_receipts(tbl_receipts);
        data_receipts();
        set_default_location();
        jTextField9.setVisible(false);
        jTextField10.setVisible(false);
        add_stocks_available();
    }

    private void add_stocks_available(){
        Dlg_stocks_available nd=new Dlg_stocks_available();
        jPanel13.setLayout(new BorderLayout());
        jPanel13.add(nd.getSurface());
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

    List<S1_suppliers.to_suppliers> supplier_list = new ArrayList();

    private void init_suppliers() {
        String search = jTextField2.getText();
        supplier_list.clear();
        String where = " where supplier like '%" + search + "%' order by supplier asc";
        supplier_list = S1_suppliers.ret_where(where);
        Object[][] obj = new Object[supplier_list.size()][1];
        int i = 0;
        for (S1_suppliers.to_suppliers to : supplier_list) {
            obj[i][0] = " " + to.supplier;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {jTextField2.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo tf = (Field.Combo) jTextField2;
                S1_suppliers.to_suppliers to = supplier_list.get(data.selected_row);
                jTextField2.setText(to.supplier);
                tf.setId("" + to.id);
            }
        });
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
                add_receipt_qty(to);
            }
        });
    }

    private void add_receipt_qty(final S1_items.to_items to) {

        Window p = (Window) this;
        Dlg_receipts_qty nd = Dlg_receipts_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(to);
        nd.setCallback(new Dlg_receipts_qty.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_receipts_qty.OutputData data) {
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
                double cost = data.cost;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_class = to.sub_classification;
                String sub_class_id = to.sub_classification_id;
                double conversion = to.conversion;
                String unit = to.unit;
                String date_delivered = "";
                String date_received = "";
                int status = 0;
                String reference_no = "";
                Field.Combo from = (Field.Combo) jTextField7;
                Field.Combo to = (Field.Combo) jTextField9;
                String from_location_name = from.getText();
                String from_location_id = from.getId();
                String to_location_name = "";
                String to_location_id = "";
                to_receipt_items item = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
                tbl_receipt_items_ALM.add(item);
                tbl_receipt_items_M.fireTableDataChanged();
            }
        }
        );
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void select_item() {
        int row = tbl_receipt_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_receipt_items to = (to_receipt_items) tbl_receipt_items_ALM.get(row);
        int col = tbl_receipt_items.getSelectedColumn();
        if (col == 5) {
            if (to.id == 0) {
                Window p = (Window) this;
                Dlg_receipts_qty nd = Dlg_receipts_qty.create(p, true);
                nd.setTitle("");
                nd.do_pass2(to);
                nd.setCallback(new Dlg_receipts_qty.Callback() {
                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_receipts_qty.OutputData data) {
                        closeDialog.ok();
                        to.setCost(data.cost);
                        to.setQty(data.qty);
                        tbl_receipt_items_M.fireTableDataChanged();
                    }
                }
                );
                nd.setLocationRelativeTo(jScrollPane1);
                nd.setVisible(true);
            } else {
            }
        }
        if (col == 6) {
            if (to.id == 0) {
                tbl_receipt_items_ALM.remove(row);
                tbl_receipt_items_M.fireTableDataChanged();
            } else {
            }
        }
    }
    //<editor-fold defaultstate="collapsed" desc=" receipt_items "> 
    public static ArrayListModel tbl_receipt_items_ALM;
    public static Tblreceipt_itemsModel tbl_receipt_items_M;

    public static void init_tbl_receipt_items(JTable tbl_receipt_items) {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);
        int[] tbl_widths_receipt_items = {50, 100, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipt_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_items, i, tbl_widths_receipt_items[i]);
        }
        Dimension d = tbl_receipt_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipt_items.getTableHeader().setPreferredSize(d);
        tbl_receipt_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_receipt_items.setRowHeight(25);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 4);
    }

    public static void loadData_receipt_items(List<to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);

    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Cost", "Amount", "", "", "remarks", "barcode", "description", "qty", "cost", "category", "category_id", "classification", "classification_id", "sub_class", "sub_class_id", "conversion", "unit", "date_delivered", "date_received"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            to_receipt_items tt = (to_receipt_items) getRow(row);
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
                    return " Update";
                case 6:
                    return " Delete";
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
                    return tt.date_delivered;
                default:
                    return tt.date_received;
            }
        }
    }
//</editor-fold> 

    private void suppliers() {
        Window p = (Window) this;
        Dlg_new_supplier nd = Dlg_new_supplier.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_new_supplier.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_new_supplier.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void post_receipt() {
        Field.Combo tf = (Field.Combo) jTextField7;
        if (tf.getId() == null || tf.getId().isEmpty()) {
            Alert.set(0, "Please Select Location");
            jTextField7.grabFocus();
            return;
        }

        if (tbl_receipt_items_ALM.isEmpty()) {
            Alert.set(0, "No Items Added!");
            return;
        }
        Field.Combo sup = (Field.Combo) jTextField2;
        int id = 0;
        String receipt_no = S1_receipts.increment_id();
        String user_name = Users.user_name;
        String session_no = "";
        String date_added = DateType.now();
        String supplier = sup.getText();
        String supllier_id = sup.getId();
        String remarks = jTextArea1.getText();
        String date_delivered = DateType.sf.format(jDateChooser2.getDate());
        String date_received = DateType.sf.format(jDateChooser1.getDate());
        int status = 0;
        String reference_no = jTextField4.getText();
        Field.Combo from = (Field.Combo) jTextField7;
        Field.Combo to = (Field.Combo) jTextField9;
        String from_location_name = from.getText();
        String from_location_id = from.getId();
        String to_location_name = "";
        String to_location_id = "";
        S1_receipts.to_receipts receipt = new S1_receipts.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
        List<to_receipt_items> items = tbl_receipt_items_ALM;
        S1_receipts.add_receipts(receipt);
        S1_receipt_items.add_receipt_items(items, receipt);
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
        sup.setText("");
        sup.setId("");
        jTextField4.setText("");
        jTextArea1.setText("");
        jTextField2.grabFocus();
        data_receipts();
        Alert.set(0, "Transaction Posted!");
    }

    //<editor-fold defaultstate="collapsed" desc=" receipts "> 
    public static ArrayListModel tbl_receipts_ALM;
    public static TblreceiptsModel tbl_receipts_M;

    public static void init_tbl_receipts(JTable tbl_receipts) {
        tbl_receipts_ALM = new ArrayListModel();
        tbl_receipts_M = new TblreceiptsModel(tbl_receipts_ALM);
        tbl_receipts.setModel(tbl_receipts_M);
        tbl_receipts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipts.setRowHeight(25);
        int[] tbl_widths_receipts = {120, 100, 100, 100, 60, 60, 60, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipts, i, tbl_widths_receipts[i]);
        }
        Dimension d = tbl_receipts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipts.getTableHeader().setPreferredSize(d);
        tbl_receipts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_receipts.setRowHeight(25);
        tbl_receipts.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_receipts(List<to_receipts> acc) {
        tbl_receipts_ALM.clear();
        tbl_receipts_ALM.addAll(acc);
    }

    public static class TblreceiptsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference No", "Supplier", "Date Delivered", "Date Received", "", "", "", "remarks", "date_delivered", "date_received", "status"
        };

        public TblreceiptsModel(ListModel listmodel) {
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
            to_receipts tt = (to_receipts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.reference_no;
                case 1:
                    return " " + tt.supplier;
                case 2:
                    return " " + DateType.convert_slash_datetime4(tt.date_delivered);
                case 3:
                    return " " + DateType.convert_slash_datetime4(tt.date_received);
                case 4:
                    return " Update";
                case 5:
                    return " Delete";
                case 6:
                    return " Preview";
                case 7:
                    return tt.remarks;
                case 8:
                    return tt.date_delivered;
                case 9:
                    return tt.date_received;
                default:
                    return tt.status;
            }
        }
    }
//</editor-fold> 

    private void data_receipts() {
        String where = " ";
        if (jCheckBox1.isSelected()) {
            where = " where receipt_no like '%" + jTextField5.getText() + "%' ";
        }
        if (jCheckBox2.isSelected()) {
            where = " where reference_no like '%" + jTextField5.getText() + "%' ";
        }
        if (jCheckBox3.isSelected()) {
            where = " where supplier like '%" + jTextField5.getText() + "%' ";
        }

        String delivered_from = DateType.sf.format(jDateChooser3.getDate());
        String delivered_to = DateType.sf.format(jDateChooser4.getDate());
        if (!jCheckBox4.isSelected()) {
            where = where + " and Date(date_delivered) between '" + delivered_from + "' and  '" + delivered_to + "' ";
        }

        String received_from = DateType.sf.format(jDateChooser5.getDate());
        String received_to = DateType.sf.format(jDateChooser6.getDate());
        if (!jCheckBox4.isSelected()) {
            where = where + " and Date(date_received) between '" + received_from + "' and  '" + received_to + "' ";
        }

        where = where + " order by id desc ";
        List<S1_receipts.to_receipts> datas = S1_receipts.ret_where(where);
        loadData_receipts(datas);
    }

    private void select_receipt() {

        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(row);
        int col = tbl_receipts.getSelectedColumn();
        Field.Combo sup = (Field.Combo) jTextField2;

        if (col == 4) {
            sup.setText(to.supplier);
            sup.setId(to.supllier_id);
            jTextArea1.setText(to.remarks);
            jTextField4.setText(to.reference_no);
            try {
                Date d = DateType.sf.parse(to.date_delivered);
                Date r = DateType.sf.parse(to.date_received);
                jDateChooser2.setDate(d);
                jDateChooser1.setDate(r);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_new_receipt.class.getName()).log(Level.SEVERE, null, ex);
            }
            String where = " where receipt_no='" + to.receipt_no + "'";
            List<to_receipt_items> datas = S1_receipt_items.ret_where(where);
            loadData_receipt_items(datas);
            jButton2.setEnabled(true);
            jTabbedPane1.setSelectedIndex(0);

        }
        if (col == 5) {
            delete_receipt();
        }
        if (col == 6) {
            get_data();
        }
    }

    private void new_receipt() {
        Field.Combo sup = (Field.Combo) jTextField2;
        sup.setText("");
        sup.setId("");
        jTextArea1.setText("");
        jTextField4.setText("");
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_M.fireTableDataChanged();
        jTextField2.grabFocus();
        jButton2.setEnabled(false);
    }

    private void update_receipt() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(row);
        Field.Combo sup = (Field.Combo) jTextField2;
        int id = to.id;
        String receipt_no = to.receipt_no;
        String user_name = to.user_name;
        String session_no = "";
        String date_added = to.date_added;
        String supplier = sup.getText();
        String supllier_id = sup.getId();
        String remarks = jTextArea1.getText();
        String date_delivered = DateType.sf.format(jDateChooser2.getDate());
        String date_received = DateType.sf.format(jDateChooser1.getDate());
        int status = to.id;
        String reference_no = jTextField4.getText();

        Field.Combo from = (Field.Combo) jTextField7;
        Field.Combo too = (Field.Combo) jTextField9;

        String from_location_name = from.getText();
        String from_location_id = from.getId();
        String to_location_name = too.getText();
        String to_location_id = too.getId();
        S1_receipts.to_receipts receipt = new S1_receipts.to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
        S1_receipts.edit_receipts(receipt);
        data_receipts();
        String where = " where receipt_no='" + to.receipt_no + "'";
        List<to_receipt_items> datas = S1_receipt_items.ret_where(where);
        loadData_receipt_items(datas);
        tbl_receipts.setRowSelectionInterval(row, row);
        Alert.set(0, "Transaction Updated!");
    }

    private void delete_receipt() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                int row = tbl_receipts.getSelectedRow();
                if (row < 0) {
                    return;
                }
                to_receipts to = (to_receipts) tbl_receipts_ALM.get(row);
                S1_receipts.delete_receipts(to);
                data_receipts();
                String where = " where receipt_no='" + to.receipt_no + "'";
                List<to_receipt_items> datas = S1_receipt_items.ret_where(where);
                S1_receipt_items.delete_data(datas);
                Alert.set(0, "Transaction Deleted!");
                new_receipt();
            }
        });
        nd.setLocationRelativeTo(jScrollPane3);
        nd.setVisible(true);

    }

    private void get_data() {
        jTabbedPane1.setSelectedIndex(3);
        jProgressBar2.setString("Loading...Please wait...");
        jProgressBar2.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int row = tbl_receipts.getSelectedRow();
                if (row < 0) {
                    return;
                }
                to_receipts to = (to_receipts) tbl_receipts_ALM.get(row);
                String where = " where receipt_no='" + to.receipt_no + "'";
                List<Srpt_receipt.field> fields = Srpt_receipt.ret_data(where);
                String supplier = to.supplier;
                String date_of_delivery = DateType.convert_slash_datetime4(to.date_delivered);
                String date_received = DateType.convert_slash_datetime4(to.date_received);
                String remarks = to.remarks;
                String reference_no = to.reference_no;
                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
                String date = DateType.slash_w_time.format(new Date());
                Srpt_receipt rpt = new Srpt_receipt(supplier, date_of_delivery, date_received, remarks, reference_no, business_name, address, date);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_receipt.jrxml";
                report_sales_items(rpt, jrxml);
                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_sales_items(final Srpt_receipt to, String jrxml_name) {
        pnl_sales_items.removeAll();
        pnl_sales_items.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_all_sales(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_sales_items.add(viewer);
            pnl_sales_items.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_all_sales(Srpt_receipt to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void get_data2(final S1_items.to_items to) {

        jProgressBar3.setString("Loading...Please wait...");
        jProgressBar3.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where barcode='" + to.barcode + "' and status=0 ";
                List<Srpt_beginning_inventory.field> receipts = Srpt_beginning_inventory.receipts(where);
                List<Srpt_beginning_inventory.field> sales = Srpt_beginning_inventory.sales(where);
                List<Srpt_beginning_inventory.field> drs = Srpt_beginning_inventory.drs(where);

                List<Srpt_beginning_inventory.field> all = new ArrayList();
                all.addAll(receipts);
                all.addAll(sales);
                all.addAll(drs);
                Collections.sort(all);
                double balance = 0;
                for (Srpt_beginning_inventory.field to : all) {
                    if (to.credit > 0) {
                        balance -= to.credit;
                    } else {
                        balance += to.debit;
                    }
                    to.setBalance(balance);
                }
                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");
                String barcode = to.barcode;
                String description = to.description;
                String date = DateType.slash_w_time.format(new Date());
                Srpt_beginning_inventory rpt = new Srpt_beginning_inventory(business_name, address, barcode, description, date);
                rpt.fields.addAll(all);
                String jrxml = "rpt_beginning_inventory.jrxml";

                report_sales_items2(rpt, jrxml);
                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_sales_items2(final Srpt_beginning_inventory to, String jrxml_name) {
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

    public static JRViewer get_viewer_all_sales2(Srpt_beginning_inventory to, String rpt_name) {
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
            InputStream is = Srpt_beginning_inventory.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    List<S1_items.to_items> item_list2 = new ArrayList();

    private void init_items2() {
        String search = jTextField6.getText();
        item_list2.clear();
        String where = " where barcode like '%" + search + "%' "
                + " or description like '%" + search + "%'"
                + "order by description asc";
        item_list2 = S1_items.ret_where(where);
        Object[][] obj = new Object[item_list2.size()][3];
        int i = 0;
        for (S1_items.to_items to : item_list2) {
            obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
            obj[i][1] = " " + to.barcode;
            obj[i][2] = " " + to.description;

            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {60, 100, jTextField6.getWidth() - 150};
        int width = 0;
        String[] col_names = {"", "", ""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField6, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_items.to_items to = (S1_items.to_items) item_list2.get(data.selected_row);
                jTextField6.setText(to.description);
                get_data2(to);
            }
        });
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
}
