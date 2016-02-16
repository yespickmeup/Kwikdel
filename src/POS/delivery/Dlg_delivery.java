
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.delivery;

import POS.accounts_receivable.S1_accounts_receivable;
import POS.customers.Dlg_customer_accounts;
import POS.customers.Dlg_customer_sales;
import POS.customers.Dlg_customers;
import POS.customers.S1_customers;
import POS.deposits.Dlg_deposits;
import POS.items.S1_items;
import POS.locations.S1_locations;
import static POS.locations.S1_locations.get_default_location;
import POS.my_reports.Dlg_my_reports;
import POS.my_sales.MySales;
import POS.on_account_payments.Dlg_on_account_payments;
import POS.sales.Dlg_change;
import POS.sales.Dlg_pay;
import POS.sales.Dlg_qty_delete_fixed;
import POS.sales.S1_sales;
import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items;
import POS.sales.Srpt_receipt;
import POS.sales_dr.S1_sales_dr;
import POS.sales_dr.S1_sales_dr_items;
import POS.services.S1_sales_services;
import POS.template.Dlg_confirm;
import POS.util.Alert;
import POS.util.Courier;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.MyBorder;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import synsoftech.panels.Loading;

/**
 *
 * @author Ronald
 */
public class Dlg_delivery extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_delivery
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
    private Dlg_delivery(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_delivery(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_delivery() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_delivery myRef;

    private void setThisRef(Dlg_delivery myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_delivery> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_delivery create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_delivery create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_delivery dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_delivery((java.awt.Frame) parent, false);
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
            Dlg_delivery dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_delivery((java.awt.Dialog) parent, false);
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

        Dlg_delivery dialog = Dlg_delivery.create(new javax.swing.JFrame(), true);

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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_trans_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbl_trans_type = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbl_payment_type = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        lbl_trans_type_id = new javax.swing.JTextField();
        lbl_payment_type_id = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales_items = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_customer_address = new javax.swing.JTextField();
        tf_customer_contact_no = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        jMenuItem3.setText("Update Driver");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem1.setText("Print Receipt");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Print Guide");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(65, 136, 210));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("25 Dr. V. Locsin Street, Dumaguete City, 6200, Negros Orietal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Welcome! Ronald Pascua");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("03/12/2014 9:51:01 PM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(13, 88, 166));
        jPanel2.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(62, 60, 60));
        jLabel11.setText("Delivery Report");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Date:");

        jCheckBox1.setSelected(true);
        jCheckBox1.setOpaque(false);

        jDateChooser1.setDate(new Date());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("From");

        jDateChooser2.setDate(new Date());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("To");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Status:");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");
        jCheckBox2.setOpaque(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("New");
        jCheckBox3.setOpaque(false);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("In Transit");
        jCheckBox4.setOpaque(false);
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Delivered");
        jCheckBox5.setOpaque(false);
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Cancelled");
        jCheckBox6.setOpaque(false);
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Search by:");

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("Customer");
        jCheckBox7.setOpaque(false);
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("Vehicle");
        jCheckBox8.setOpaque(false);
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("Driver");
        jCheckBox9.setOpaque(false);
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Search:");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

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
        tbl_sales.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_salesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_salesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sales);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Total Transactions:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("0");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("0.00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Total:");

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setText("Ready");
        jCheckBox10.setOpaque(false);
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jCheckBox10)
                                        .addGap(0, 0, 0)
                                        .addComponent(jCheckBox4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox9)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox5)
                        .addComponent(jCheckBox6)
                        .addComponent(jCheckBox10))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Transaction #:");

        lbl_trans_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_trans_no.setBorder(null);
        lbl_trans_no.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Customer:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Trans Type:");

        lbl_trans_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_trans_type.setText("Walkin");
        lbl_trans_type.setBorder(null);
        lbl_trans_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_trans_typeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Payment Type:");

        lbl_payment_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_payment_type.setText("Cash");
        lbl_payment_type.setBorder(null);
        lbl_payment_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_payment_typeActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Vehicle:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Driver:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setBorder(null);

        lbl_trans_type_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_trans_type_id.setText("1");
        lbl_trans_type_id.setBorder(null);
        lbl_trans_type_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_trans_type_idActionPerformed(evt);
            }
        });

        lbl_payment_type_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_payment_type_id.setText("1");
        lbl_payment_type_id.setBorder(null);

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setBorder(null);

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setBorder(null);

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Settle (Ctrl)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(65, 136, 210));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Total Items:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("0");

        lbl_total.setBackground(new java.awt.Color(8, 75, 241));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("0.00");

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
        jScrollPane1.setViewportView(tbl_sales_items);

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Search (F1) :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_payment_type, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_trans_type, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField13)
                            .addComponent(jTextField12)
                            .addComponent(lbl_trans_type_id, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(lbl_payment_type_id)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_customer_address)
                                .addGap(0, 0, 0)
                                .addComponent(tf_customer_contact_no)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_trans_no)
                        .addGap(15, 15, 15))))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_trans_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_customer_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_customer_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_trans_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_trans_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_payment_type_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel7.setBackground(new java.awt.Color(57, 123, 193));

        jLabel27.setBackground(new java.awt.Color(51, 153, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("REPORTS");
        jLabel27.setOpaque(true);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(51, 153, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("On Account Payments");
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(51, 153, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Re-print Sales");
        jLabel29.setOpaque(true);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(51, 153, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Customer Accounts");
        jLabel30.setOpaque(true);
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(51, 153, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Deposits");
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void lbl_trans_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_trans_typeActionPerformed
        init_trans_type();
    }//GEN-LAST:event_lbl_trans_typeActionPerformed

    private void lbl_payment_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_payment_typeActionPerformed
        init_payment_type();
    }//GEN-LAST:event_lbl_payment_typeActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        init_driver();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_truck();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        prompt_customers();
//        init_customers();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        init_items();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        settle();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
        update_status();
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void tbl_sales_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sales_itemsMouseClicked
        // TODO add your handling code here:
        delete_item();
    }//GEN-LAST:event_tbl_sales_itemsMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton3.setEnabled(true);
        jButton2.setEnabled(false);
        jButton1.setEnabled(false);
        jTextField7.setEnabled(true);
        jButton3.setEnabled(true);
        jTextField2.grabFocus();
        lbl_trans_no.setText("");
        jTextField2.setText("");
        jTextField9.setText("");
        lbl_trans_type.setText("Walkin");
        lbl_trans_type_id.setText("1");
        lbl_payment_type.setText("Cash");
        lbl_payment_type_id.setText("1");
        jTextField5.setText("");
        jTextField12.setText("");
        jTextField6.setText("");
        jTextField13.setText("");
        tf_customer_address.setText("");
        tf_customer_contact_no.setText("");
        init_or();
        tbl_sales_items_ALM.clear();
        tbl_sales_items_M.fireTableDataChanged();
        compute();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update_sales();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_sales();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbl_trans_type_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_trans_type_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_trans_type_idActionPerformed

    private void tbl_salesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMousePressed
        reprint_orders(evt);
    }//GEN-LAST:event_tbl_salesMousePressed

    private void tbl_salesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseReleased
        // TODO add your handling code here:
        reprint_orders(evt);
    }//GEN-LAST:event_tbl_salesMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        print_all();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        report();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        print_deliver_all();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        on_account_payment();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        reprint();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        data_cols();
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        update_multi_delivery();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        customer_accounts();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        deposits();
    }//GEN-LAST:event_jLabel31MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField lbl_payment_type;
    private javax.swing.JTextField lbl_payment_type_id;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTextField lbl_trans_no;
    private javax.swing.JTextField lbl_trans_type;
    private javax.swing.JTextField lbl_trans_type_id;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTable tbl_sales_items;
    private javax.swing.JTextField tf_customer_address;
    private javax.swing.JTextField tf_customer_contact_no;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
        jTextField9.setVisible(false);
        lbl_trans_type_id.setVisible(false);
        lbl_payment_type_id.setVisible(false);
        jTextField12.setVisible(false);
        jTextField13.setVisible(false);
        tf_customer_address.setVisible(false);
        tf_customer_contact_no.setVisible(false);

        jButton2.setEnabled(false);
        jButton1.setEnabled(false);
        init_tbl_sales_items();
        init_tbl_sales();
        data_cols();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                init_or();
                time();
            }
        });
        t.start();

        Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border border = BorderFactory.createLineBorder(Color.BLUE);

        hover();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTextField2.grabFocus();
            }
        });
        set_default_location();
    }

    String location = "";

    private void set_default_location() {

        S1_locations.to_locations def_location = get_default_location();
        location = "" + def_location.id;
    }

    private void hover() {
        JLabel[] lbl = {jLabel27, jLabel28, jLabel29, jLabel30, jLabel31};

        for (final JLabel l : lbl) {
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    l.setBackground(new java.awt.Color(51, 153, 255));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    l.setBackground(new java.awt.Color(247, 130, 40));
                }

            });
        }
    }

    private void time() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Timer ti = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Calendar currentCalendar = Calendar.getInstance();
                        Date currentTime = currentCalendar.getTime();
                        jLabel3.setText(DateType.slash_w_time2.format(currentTime));
//                        jLabel6.setText(DateType.slash.format(currentTime));
                        jLabel2.setText("Welcome! " + Users.get_username());
                    }
                });
                ti.start();
            }
        });
        t.start();
    }

    private void init_or() {
        lbl_trans_no.setText(S1_sales.increment_id());
    }

    private void focus() {
        JTextField[] tf = {lbl_trans_no, jTextField2, lbl_trans_type, lbl_payment_type, jTextField5, jTextField6, jTextField7, jTextField8};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        MyBorder.setBorder2(tf);
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

        JTextField[] tf1 = {jTextField2, lbl_trans_type, lbl_payment_type, jTextField5, jTextField6};
        for (final JTextField t : tf1) {
            t.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_F1) {
                        jTextField7.grabFocus();
                    }
                }
            });
        }

        JTextField[] tf2 = {jTextField2, lbl_trans_type, lbl_payment_type, jTextField5, jTextField6, jTextField7};
        for (final JTextField t : tf2) {
            t.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                        settle();
                    }
                }
            });
        }
    }
    // </editor-fold>

    List<Courier.to_courier> trans_type_list = new ArrayList();

    private void init_trans_type() {
        String search = lbl_trans_type.getText();
        trans_type_list.clear();
        trans_type_list = Courier.transaction_type();
        Object[][] obj = new Object[trans_type_list.size()][1];
        int i = 0;
        for (Courier.to_courier to : trans_type_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {500};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(lbl_trans_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.to_courier to = trans_type_list.get(data.selected_row);
                lbl_trans_type.setText(to.name);
                lbl_trans_type_id.setText("" + to.id);
                lbl_payment_type.grabFocus();

            }
        });
    }
    List<Courier.to_courier> payment_type_list = new ArrayList();

    private void init_payment_type() {
        String search = lbl_payment_type.getText();
        payment_type_list.clear();
        payment_type_list = Courier.payment_type();
        Object[][] obj = new Object[payment_type_list.size()][1];
        int i = 0;
        for (Courier.to_courier to : payment_type_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {500};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(lbl_payment_type, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Courier.to_courier to = payment_type_list.get(data.selected_row);
                lbl_payment_type.setText(to.name);
                lbl_payment_type_id.setText(to.id);
                jTextField5.grabFocus();
            }
        });
    }

    List<S1_delivery_man.to_delivery_man> driver_list = new ArrayList();

    private void init_driver() {
        String search = jTextField6.getText();
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
        TableRenderer.setPopup(jTextField6, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_delivery_man.to_delivery_man to = driver_list.get(data.selected_row);
                jTextField6.setText(to.lname + ", " + to.fname + " " + to.mi);
                jTextField13.setText("" + to.id);
                jTextField7.grabFocus();
            }
        });
    }

    List<S1_delivery_trucks.to_delivery_trucks> truck_list = new ArrayList();

    private void init_truck() {
        String search = jTextField5.getText();
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
        TableRenderer.setPopup(jTextField5, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_delivery_trucks.to_delivery_trucks to = truck_list.get(data.selected_row);
                jTextField5.setText(to.description);
                jTextField12.setText("" + to.id);
                jTextField6.grabFocus();
            }
        });
    }

    private void prompt_customers() {
        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
        nd.do_pass(jTextField2.getText());
        nd.setCallback(new Dlg_customers.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
                jTextField2.setText(data.customer_name);
                tf_customer_address.setText(data.customer_address);
                tf_customer_contact_no.setText(data.customer_contact_no);
                jTextField9.setText(data.customer_id);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    List<S1_customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {
        String search = jTextField2.getText();
        customer_list.clear();
        String where = " where customer_name like '%" + search + "%' order by customer_name asc";
        customer_list = S1_customers.ret_data2(where);
        Object[][] obj = new Object[customer_list.size()][1];
        int i = 0;
        for (S1_customers.to_customers to : customer_list) {
            obj[i][0] = to.first_name + " " + to.last_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {500};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField2, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_customers.to_customers to = customer_list.get(data.selected_row);
                jTextField2.setText(to.first_name + " " + to.last_name);
                jTextField9.setText("" + to.id);
                lbl_trans_type.grabFocus();
            }
        });
    }

    List<S1_items.to_items> item_list = new ArrayList();

    private void init_items() {
        String search = jTextField7.getText();
        item_list.clear();
        String where = " where description like  '%" + search + "%' and location_id='" + location + "' "
                + " or barcode = '" + search + "'  and location_id='" + location + "' "
                + " order by description asc ";
        item_list = S1_items.ret_itmes(where);
        Object[][] obj = new Object[item_list.size()][3];
        int i = 0;
        for (S1_items.to_items to : item_list) {
            obj[i][0] = " " + FitIn.fmt_woc(to.product_qty);
            obj[i][1] = " " + to.description;
            obj[i][2] = " " + FitIn.fmt_wc_0(to.selling_price);
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {40, 500, 60};
        int width = 0;
        String[] col_names = {"Qty", "Description", "Price"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField7, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_items.to_items to = item_list.get(data.selected_row);
                add_order(to);
            }
        });
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
        int[] tbl_widths_sales_items = {50, 100, 70, 70, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales_items.length; i < n; i++) {
            if (i == 1) {
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
                setFont(new java.awt.Font("Arial", 0, 14));
        tbl_sales_items.setRowHeight(25);
        tbl_sales_items.setFont(new java.awt.Font("Arial", 0, 14));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 3);

        Color ivory = new Color(255, 255, 255);
        tbl_sales_items.setOpaque(true);
        tbl_sales_items.setFillsViewportHeight(true);
        tbl_sales_items.setBackground(ivory);
    }

    private void loadData_sales_items(List<S1_sales_items.to_sales_items> acc) {
        tbl_sales_items_ALM.clear();
        tbl_sales_items_ALM.addAll(acc);
    }

    public static class Tblsales_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", "Price", "Amount", "", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "id", "Unit", "conversion", "Price", "date_added", "user_name", "item_type", "status", "session_no", "item_discount", "discount", "discount_amount", "Total"
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
            S1_sales_items.to_sales_items tt = (S1_sales_items.to_sales_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.description;
                case 2:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.selling_price * tt.product_qty) + " ";
                case 4:
                    return "  X";
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.id;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return FitIn.fmt_wc_0(tt.selling_price);
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

                default:
                    return tt.sales_no;
            }
        }
    }

    private void data_cols_items() {

        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
        String where = " where sales_no='" + to.sales_no + "' ";
        List<S1_sales_items.to_sales_items> datas = S1_sales_items.ret_data3(where);
        loadData_sales_items(datas);
        compute();
    }

    private void add_order(final S1_items.to_items to) {
        Window p = (Window) this;
        Dlg_qty_delete_fixed nd = Dlg_qty_delete_fixed.create(p, true);
        nd.setTitle("");
        int metered = 0;
        if (lbl_payment_type.getText().equals("Charge")) {
            metered = 1;
        }
        nd.do_pass3(to.product_qty, to.selling_price, to.description, metered);
        nd.setCallback(new Dlg_qty_delete_fixed.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                closeDialog.ok();
                int id = -1;
                String barcode = to.barcode;
                String description = to.description;
                String generic_name = to.generic_name;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_classification = to.sub_classification;
                String sub_classification_id = to.sub_classification_id;
                double product_qty = data.qty;
                String unit = to.unit;
                double conversion = to.conversion;
                double selling_price = to.selling_price;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.get_username();
                String item_type = to.item_type;
                int status = 0;
                String session_no = Users.get_session_no();
                String item_discount = "";
                double discount = 0;
                double discount_amount = 0;
                String sales_no = "";
                int fixed_price = to.fixed_price;
                String supplier = to.supplier;
                String supplier_id = to.supplier_id;
                int vatable = to.vatable;
                String or_no = "";
                String customer_name = jTextField2.getText();
                String customer_id = jTextField9.getText();
                String location_id = to.location_id;
                String location_name = to.location_name;
                S1_sales_items.to_sales_items item = new S1_sales_items.to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, data.metered, location_id, location_name);
                List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
                int exists = 0;
                for (S1_sales_items.to_sales_items t : datas) {
                    if (t.barcode.equals(item.barcode) && t.unit.equals(item.unit) && t.metered == data.metered) {
                        double qty = t.product_qty + item.product_qty;
                        double amount = qty * t.selling_price;
                        t.setProduct_qty(qty);
                        t.setGeneric_name(FitIn.fmt_wc_0(amount));
                        tbl_sales_items_M.fireTableDataChanged();
                        compute();

                        return;
                    }
                }
                if (exists == 0) {
                    tbl_sales_items_ALM.add(item);
                    tbl_sales_items_M.fireTableDataChanged();
                }
                compute();
            }

            @Override
            public void delete(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {

            }

        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);

    }

    private void compute() {
        double amount = 0;
        List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
        for (S1_sales_items.to_sales_items to : datas) {
            amount += to.product_qty * to.selling_price;
        }
        lbl_total.setText(FitIn.fmt_wc_0(amount));
        jLabel19.setText("" + datas.size());
    }

    private void settle() {
        if (tbl_sales_items_ALM.isEmpty()) {
            Alert.set(0, "NO ORDERS");
            return;
        }
        Window p = (Window) this;
        Dlg_pay nd = Dlg_pay.create(p, true);
        nd.setTitle("");
        String sales_no = S1_sales.increment_id();
        double due = FitIn.toDouble(lbl_total.getText());
        String customer_name1 = jTextField2.getText();
        String customer_id1 = jTextField9.getText();
        String transaction_type1 = lbl_trans_type.getText();
        String transaction_type_id1 = lbl_trans_type_id.getText();
        String payment_type1 = lbl_payment_type.getText();
        String payment_type_id1 = lbl_payment_type_id.getText();
        String vehicle_name1 = jTextField5.getText();
        String vehicle_id1 = jTextField12.getText();
        String driver_name1 = jTextField6.getText();
        String driver_id = jTextField13.getText();
        String customer_address = tf_customer_address.getText();
        String customer_contact_no = tf_customer_contact_no.getText();
        int status = 0;
        if (lbl_trans_type_id.getText().equals("2")) {
            status = 5;
        }
        nd.do_pass(sales_no, due, customer_name1, customer_id1, transaction_type1, transaction_type_id1, payment_type1, payment_type_id1, vehicle_name1, vehicle_id1, driver_name1, driver_id, status, customer_address, customer_contact_no);
        if (lbl_payment_type_id.getText().equals("2")) {
            nd.do_pass2(FitIn.fmt_wc_0(due));
        }
        nd.setCallback(new Dlg_pay.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_pay.OutputData data) {
                closeDialog.ok();
                my_sales = data.to_sales;
                my_change = data.change;
                my_services = data.my_services;
                settle_now();
//                z Loader loader = new Loader(Dlg_delivery.this);
//                loader.execute();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void add_ar(double am, String or_no1) {
        int id = -1;
        String customer_id = jTextField9.getText();
        String customer_name = jTextField2.getText();
        String ar_no = S1_accounts_receivable.increment_id();
        String date_added = DateType.now();
        String user_name = Users.user_name;
        double amount = am;
        double discount_amount = 0;// FitIn.toDouble(tf_discount_amount.getText();
        double discount_rate = 0;//FitIn.toDouble(tf_discount_rate.getText();
        String discount = "";//tf_discount.getText();
        int status = 0;// FitIn.toInt(tf_status.getText());
        double term = 30;
        String date_applied = DateType.sf.format(new Date());
//        date_applied = DateType.mDate_to_Date(date_applied);
        double paid = 0;
        String date_paid = date_applied;
        String remarks = "";// tf_remarks.getText();
        String type = "AR";//tf_type.getText();
        String or_no = or_no1;//tf_or_no.getText();
        String ci_no = "";
        String trust_receipt = "";
        S1_accounts_receivable.to_accounts_receivable to = new S1_accounts_receivable.to_accounts_receivable(true, id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt);
        S1_accounts_receivable.add_accounts_receivable(to);
    }

    private void set_change(double change) {
        Window p = (Window) this;
        Dlg_change nd = Dlg_change.create(p, true);
        nd.setTitle("");
        nd.do_pass(change);
        nd.setCallback(new Dlg_change.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_change.OutputData data) {
                closeDialog.ok();
            }

            @Override
            public void print(CloseDialog closeDialog, Dlg_change.OutputData data) {
                closeDialog.ok();
                String print = System.getProperty("print_to_receipts", "false");
                if (print.equals("true")) {
                    try {
                        JasperPrintManager.printReport(jasperPrint, false);
                    } catch (JRException ex) {
                        Logger.getLogger(Dlg_delivery.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                tbl_sales_items_ALM.clear();
                tbl_sales_items_M.fireTableDataChanged();
                jTextField2.grabFocus();
                lbl_total.setText("0.00");
                jTextField2.setText("");
                jTextField9.setText("");
                lbl_trans_type.setText("Walkin");
                lbl_trans_type_id.setText("1");
                lbl_payment_type.setText("Cash");
                lbl_payment_type_id.setText("1");
                jTextField5.setText("");
                jTextField12.setText("");
                jTextField6.setText("");
                jTextField13.setText("");
                tf_customer_address.setText("");
                tf_customer_contact_no.setText("");
                my_sales = null;
                my_change = 0;
                my_services.clear();
                my_sales_no = "";
                my_qty = 0;
                my_fields.clear();
                my_vatable_sale = 0;
                my_zero_rate_sale = 0;
                my_vat_exempt_sale = 0;
                my_vat_percent = 0;
                init_or();
                data_cols();
            }

        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
    JasperPrint jasperPrint = null;

    public class CustomRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 6703872492730589499L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 6).equals("  [  ]")) {
                cellComponent.setBackground(new java.awt.Color(255, 255, 255));
            }
            if (table.getValueAt(row, 7).equals("  [  ]")) {
                cellComponent.setBackground(new java.awt.Color(222, 222, 141));
            }
            if (table.getValueAt(row, 8).equals("  [  ]")) {
                cellComponent.setBackground(new java.awt.Color(94, 168, 248));
            }
            if (table.getValueAt(row, 9).equals("  [  ]")) {
                cellComponent.setBackground(new java.awt.Color(255, 255, 126));
            }
            if (table.getValueAt(row, 10).equals("  [  ]")) {
                cellComponent.setBackground(new java.awt.Color(150, 123, 110));
            }

            return cellComponent;
        }
    }
    private ArrayListModel tbl_sales_ALM;
    private TblsalesModel tbl_sales_M;

    private void init_tbl_sales() {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {50, 100, 100, 100, 0, 70,
            30, 30, 30, 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }
//        tbl_sales.setC
        Dimension d = tbl_sales.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_sales.getTableHeader().setPreferredSize(d);
        tbl_sales.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_sales.setRowHeight(25);
        tbl_sales.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 5);
        tbl_sales.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(5).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(6).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(7).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(8).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(9).setCellRenderer(new CustomRenderer());
        tbl_sales.getColumnModel().getColumn(10).setCellRenderer(new CustomRenderer());
        Color ivory = new Color(255, 255, 255);
        tbl_sales.setOpaque(true);
        tbl_sales.setFillsViewportHeight(true);
        tbl_sales.setBackground(ivory);
        tbl_sales.setAutoResizeMode(1);
    }

    private void loadData_sales(List<to_sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);
    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Customer", "Vehicle", "Driver", "Status", "Amount", "N", "R", "I", "D", "C", " ", "check_bank", "check_no", "check_amount", "discount_customer_name", "discount_customer_id", "status", "or_no", "check_holder", "services", "service_amount", "customer_id", "transaction_type", "transaction_type_id", "payment_type", "payment_type_id", "vehicle_name", "vehicle_id", "driver_name", "driver_id"
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
            if (col == 11) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_sales tt = (to_sales) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.sales_no;
                case 1:
                    return " " + tt.customer_name + " - " + tt.customer_address;
                case 2:
                    return " " + tt.vehicle_name;
                case 3:
                    return " " + tt.driver_name;
                case 4:

                    return " " + tt.status;
                case 5:
                    return " " + FitIn.fmt_wc_0(tt.amount_due + tt.service_amount) + " ";
                case 6:
                    if (tt.status == 5) {
                        return "  [  ]";
                    } else {
                        return "";
                    }

                case 7:
                    if (tt.status == 6) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 8:
                    if (tt.status == 7) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 9:
                    if (tt.status == 8) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 10:
                    if (tt.status == 9) {
                        return "  [  ]";
                    } else {
                        return "";
                    }
                case 11:
                    return tt.selected;
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
                case 21:
                    return tt.service_amount;
                case 22:
                    return tt.customer_id;
                case 23:
                    return tt.transaction_type;
                case 24:
                    return tt.transaction_type_id;
                case 25:
                    return tt.payment_type;
                case 26:
                    return tt.payment_type_id;
                case 27:
                    return tt.vehicle_name;
                case 28:
                    return tt.vehicle_id;
                case 29:
                    return tt.driver_name;
                default:
                    return tt.driver_id;
            }
        }
    }

    private void data_cols() {

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                String where = "";
                String from = DateType.sf.format(jDateChooser1.getDate());
                String to = DateType.sf.format(jDateChooser2.getDate());

                if (jCheckBox2.isSelected()) {
                    where = " where status>1";
                }
                if (jCheckBox3.isSelected()) {
                    where = " where status=5";
                }
                if (jCheckBox10.isSelected()) {
                    where = " where status=6";
                }
                if (jCheckBox4.isSelected()) {
                    where = " where status=7";
                }
                if (jCheckBox5.isSelected()) {
                    where = " where status=8";
                }
                if (jCheckBox6.isSelected()) {
                    where = " where status=9";
                }

                where = where + " and charge_status=0";
                if (jCheckBox1.isSelected()) {
                    where = where + " and Date(date_added) between '" + from + "' and '" + to + "' ";
                }

                if (jCheckBox7.isSelected()) {
                    where = where + " and customer_name like '%" + jTextField8.getText() + "%' ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + " and vehicle_name like '%" + jTextField8.getText() + "%' ";
                }
                if (jCheckBox9.isSelected()) {
                    where = where + " and driver_name like '%" + jTextField8.getText() + "%' ";
                }
                where = where + " order by or_no asc";
                System.out.println(where);
                List<to_sales> datas = S1_sales.ret_data(where);
                List<S1_sales.to_sales> datas2 = S1_sales_dr.ret_data2(where);
                datas.addAll(datas2);
                loadData_sales(datas);
                double amount = 0;
                for (to_sales t : datas) {
                    amount += t.amount_due;
//              
                }
                jLabel21.setText("" + tbl_sales_ALM.size());
                jLabel22.setText(FitIn.fmt_wc_0(amount));
            }
        });
        t2.start();

    }

    private void update_status() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        int status = 5;
        int col = tbl_sales.getSelectedColumn();
        if (col < 6) {
            set_sales();
            jTextField7.setEnabled(false);
            jButton3.setEnabled(false);
            data_cols_items();
            prompt_update_sales();
        } else {
            if (col > -6 && col <= 10) {
                if (col == 6) {
                    status = 5;
                }
                if (col == 7) {
                    status = 6;
                }

                if (col == 8) {
                    status = 7;
                }
                if (col == 9) {
                    status = 8;
                }
                if (col == 10) {
                    status = 9;
                }
                to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
                if (to.sales_no.startsWith("DR")) {
                    S1_sales_dr.edit_status(to, status);
                } else {
                    S1_sales.edit_status(to, status);
                }
                data_cols();
            } else {
                if (col == 11) {
                    to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
                    if (to.selected == true) {
                        to.setSelected(false);
                    } else {
                        to.setSelected(true);
                    }

                    tbl_sales_M.fireTableDataChanged();
                }
            }

        }

    }

    private void delete_item() {
        int row = tbl_sales_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_sales_items.to_sales_items to = (S1_sales_items.to_sales_items) tbl_sales_items_ALM.get(tbl_sales_items.convertRowIndexToModel(row));
        int col = tbl_sales_items.getSelectedColumn();
        if (col == 4) {

            if (to.id == -1) {
                tbl_sales_items_ALM.remove(row);
                tbl_sales_items_M.fireTableDataChanged();
                compute();
            } else {
//                S1_sales_items.delete_sales_items(to);
//                compute();
            }
        } else {
//            update_item();
        }
    }

    private void set_sales() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));

        jTextField2.setText(to.customer_name);
        jTextField9.setText(to.customer_id);
        lbl_trans_type.setText(to.transaction_type);
        lbl_trans_type_id.setText(to.transaction_type_id);
        lbl_payment_type.setText(to.payment_type);
        lbl_payment_type_id.setText(to.payment_type_id);
        jTextField5.setText(to.vehicle_name);
        jTextField12.setText(to.vehicle_id);
        jTextField6.setText(to.driver_name);
        jTextField13.setText(to.driver_id);
        tf_customer_address.setText(to.customer_address);
        tf_customer_contact_no.setText(to.customer_contact_no);

        lbl_trans_no.setText(to.or_no);
        jButton3.setEnabled(false);
        jButton2.setEnabled(true);
        jButton1.setEnabled(true);
    }

    private void prompt_update_sales() {
        final int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_delivery_update nd = Dlg_delivery_update.create(p, true);
        nd.setTitle("");
        nd.do_pass(to);
        nd.setCallback(new Dlg_delivery_update.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_delivery_update.OutputData data) {
                closeDialog.ok();
                String id = "" + to.id;
                String discount_name = data.discount_name;
                double discount = data.discoun;
                double discount_amount = data.discount_amount;
                String discount_customer_name = data.discount_customer_name;
                String discount_customer_id = data.discount_customer_id;
                String customer_id = data.customer_id;
                String vehicle_name = data.vehicle_name;
                String vehicle_id = data.vehicle_id;
                String driver_name = data.driver_name;
                String driver_id = data.driver_id;
                String customer_name = data.customer_name;
                String time_delivered = DateType.convert_datetime_to_sf(to.date_added) + " " + data.time_delivered;
                String time_received = DateType.convert_datetime_to_sf(to.date_added) + " " + data.time_received;
                if (to.is_sales == 1) {
                    S1_sales.edit_sales_delivery(id, discount_name, discount, discount_amount, discount_customer_name, discount_customer_id, customer_id, vehicle_name, vehicle_id, driver_name, driver_id, time_delivered, time_received, customer_name, data.customer_address, data.customer_contact_no);

                } else {
                    S1_sales.edit_sales_delivery3(id, discount_name, discount, discount_amount, discount_customer_name, discount_customer_id, customer_id, vehicle_name, vehicle_id, driver_name, driver_id, time_delivered, time_received, customer_name, data.customer_address, data.customer_contact_no);

                }

                data_cols();
                tbl_sales.setRowSelectionInterval(row, row);
                set_sales();
                Alert.set(2, "");

            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

    private void update_item() {
        int row = tbl_sales_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final S1_sales_items.to_sales_items to = (S1_sales_items.to_sales_items) tbl_sales_items_ALM.get(tbl_sales_items.convertRowIndexToModel(row));

        Window p = (Window) this;
        Dlg_qty_delete_fixed nd = Dlg_qty_delete_fixed.create(p, true);
        nd.setTitle("");
        nd.do_pass2(to.product_qty, to.selling_price, to.description, to.metered);
        nd.setCallback(new Dlg_qty_delete_fixed.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                closeDialog.ok();
                if (to.id == -1) {
                    to.setProduct_qty(data.qty);
                    tbl_sales_items_M.fireTableDataChanged();
                    compute();
                } else {
                    to.setProduct_qty(data.qty);
                    S1_sales_items.edit_sales_items(to);
                    data_cols_items();
                    compute();
                }
            }

            @Override
            public void delete(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_sales() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
        int id = to.id;
        String sales_no = to.sales_no;
        String date_added = to.date_added;
        String user_name = to.user_name;
        String session_no = to.session_no;
        double gross_amount = to.gross_amount;
        double amount_paid = to.amount_paid;
        double amount_due = to.amount_due;
        String discount_name = to.discount_name;
        double discount = to.discount;
        double discount_amount = to.discount_amount;
        String customer_name = jTextField2.getText();
        String check_bank = to.check_bank;
        String check_no = to.check_no;
        double check_amount = to.check_amount;
        String discount_customer_name = to.discount_customer_name;
        String discount_customer_id = to.discount_customer_id;
        int status = to.status;
        String or_no = to.or_no;
        String check_holder = to.check_holder;
        String services = to.services;
        double service_amount = to.service_amount;
        String customer_id = jTextField9.getText();
        String transaction_type = lbl_trans_type.getText();
        String transaction_type_id = lbl_trans_type_id.getText();
        String payment_type = lbl_payment_type.getText();
        String payment_type_id = lbl_payment_type_id.getText();
        String vehicle_name = jTextField5.getText();
        String vehicle_id = jTextField12.getText();
        String driver_name = jTextField6.getText();
        String driver_id = jTextField13.getText();
        String customer_address = tf_customer_address.getText();
        String customer_contact_no = tf_customer_contact_no.getText();
        int charge_status = 0;
        int is_sales = 1;
        if (payment_type_id.equals("2")) {
            is_sales = 0;
        }

        S1_sales.to_sales to1 = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, transaction_type, transaction_type_id, payment_type, payment_type_id, vehicle_name, vehicle_id, driver_name, driver_id, false, "", "", customer_address, customer_contact_no, charge_status, is_sales);
        S1_sales.edit_sales(to1);
        data_cols();
        tbl_sales.setRowSelectionInterval(row, row);
        Alert.set(2, "");
    }

    private void delete_sales() {
        final int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.OutputData data) {
                closeDialog.ok();
                to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));
                S1_sales.delete_sales2(to);
                data_cols();
                tbl_sales_items_ALM.clear();
                tbl_sales_items_M.fireTableDataChanged();
                compute();
                Alert.set(3, "");
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void reprint_orders(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_sales, evt.getX(), evt.getY());
        }
    }

    private void print() {
        String print = System.getProperty("print_to_receipts", "false");
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String sa = S1_sales.increment_id();
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));

        List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_receipt.field> fields = new ArrayList();
        int qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;

        String customer_name = to.customer_name;
        String customer_id = to.customer_id;
        for (S1_sales_items.to_sales_items to1 : datas) {
            int id = to1.id;
            String barcode = to1.barcode;
            String description = to1.description;
            String generic_name = to1.generic_name;
            String category = to1.category;
            String category_id = to1.category_id;
            String classification = to1.classification;
            String classification_id = to1.classification_id;
            String sub_classification = to1.sub_classification;
            String sub_classification_id = to1.sub_classification_id;
            double product_qty = to1.product_qty;
            qty += product_qty;
            String unit = to1.unit;
            double conversion = to1.conversion;
            double selling_price = to1.selling_price;
            String date_added = to1.date_added;
            String user_name = to1.user_name;
            String item_type = to1.item_type;
            int status = to1.status;
            String session_no = to1.session_no;
            String item_discount = to1.item_discount;
            double discount = to1.discount;
            double discount_amount = to1.discount_amount;
            String sales_no = to1.sales_no;
            String add = "";
            if (discount_amount > 0) {
                add = " - " + FitIn.fmt_wc_0(discount_amount) + " disc";
            }
            int fixed_price = to1.fixed_price;

            String supplier = to1.supplier;
            String supplier_id = to1.supplier_id;
            int vatable = to1.vatable;
            if (selling_price == 0) {
                zero_rate_sale++;
            }
            if (to1.vatable == 0) {
                vat_exempt_sale += product_qty * selling_price;
            } else {
                vatable_sale += product_qty * selling_price;
            }

            Srpt_receipt.field tbar = new Srpt_receipt.field(to1.description + add, new Date(), FitIn.
                    toDouble(to1.sales_no), to1.product_qty, to1.selling_price);
            fields.add(tbar);

        }
        double vat_percent = vatable_sale * .12;
        vatable_sale = vatable_sale - vat_percent;

        if (print.equals("true")) {
            String operated_by = System.getProperty("operated_by", "");
            String address = System.getProperty("address", "");
            String status = System.getProperty("status", "NV");
            String tin_no = System.getProperty("tin_no", "") + " " + status;
            String serial_no = System.getProperty("serial_no", "");
            String permit_no = System.getProperty("permit_no", "");
            String datetime = DateType.slash_w_time.format(new Date());
            String or_no = "OR NO. " + sa;
            String items = System.getProperty("items", "");
            double total_due = FitIn.toDouble(lbl_total.getText());
            double cash = to.amount_paid;
            String check_bank = to.check_bank;
            double check_amount = to.check_amount;
            double change_due = to.amount_paid - to.amount_paid + to.check_amount;
            System.out.println(change_due + " - - ");
            String receipt_infos = System.getProperty("receipt_infos", "");
            String receipt_footer = System.getProperty("receipt_footer", "");
            double discount = to.discount_amount;
            String cashier_name = Users.user_name;
            String discount_name = to.discount_name;
            if (discount_name.equalsIgnoreCase("NO DISCOUNT")) {
                discount_name = "";
            }
            String pos_no = "POS 1";
            int total_qty = qty;
            String accreditation_no = System.getProperty("acct_no", "Accreditation No. 000-0000000000-000000");
            String trans_no = to.or_no;
            String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
            String discount_customer_name = to.discount_customer_name;
            String discount_customer_id = to.discount_customer_id;
            discount_customer_name = discount_customer_name + " - " + discount_customer_id;
            String min_no = System.getProperty("min_no", "MIN NO: 130321854");
            double addtl_service = to.service_amount;
            String customer_address = to.customer_address;
            double amount_due = to.amount_due;
            String check_no = to.check_no;
            Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address, "", amount_due, check_no);

            rpt.fields.addAll(fields);
            String l = "rpt_receipt.jrxml";
            InputStream is = Srpt_receipt.class.getResourceAsStream(l);
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(is);
                jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                        setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
                JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException ex) {
                Logger.getLogger(Dlg_delivery.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }

    }

    private void report() {
        Window p = (Window) this;
        Dlg_my_reports nd = Dlg_my_reports.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_my_reports.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_reports.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void print_all() {

        List<to_sales> sales = tbl_sales_ALM;
        for (to_sales to : sales) {
            if (to.selected == true) {
                String where = " where or_no='" + to.or_no + "'";
                List<S1_sales_items.to_sales_items> datas = S1_sales_items.ret_data3(where);
                List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
                List<Srpt_receipt.field> fields = new ArrayList();
                int qty = 0;
                double vatable_sale = 0;
                double zero_rate_sale = 0;
                double vat_exempt_sale = 0;
                for (S1_sales_items.to_sales_items to1 : datas) {
                    int id = to1.id;
                    String barcode = to1.barcode;
                    String description = to1.description;
                    String generic_name = to1.generic_name;
                    String category = to1.category;
                    String category_id = to1.category_id;
                    String classification = to1.classification;
                    String classification_id = to1.classification_id;
                    String sub_classification = to1.sub_classification;
                    String sub_classification_id = to1.sub_classification_id;
                    double product_qty = to1.product_qty;
                    qty += product_qty;
                    String unit = to1.unit;
                    double conversion = to1.conversion;
                    double selling_price = to1.selling_price;
                    String date_added = to1.date_added;
                    String user_name = to1.user_name;
                    String item_type = to1.item_type;
                    int status = to1.status;
                    String session_no = to1.session_no;
                    String item_discount = to1.item_discount;
                    double discount = to1.discount;
                    double discount_amount = to1.discount_amount;
                    String sales_no = to1.sales_no;
                    String add = "";
                    if (discount_amount > 0) {
                        add = " - " + FitIn.fmt_wc_0(discount_amount) + " disc";
                    }
                    int fixed_price = to1.fixed_price;

                    String supplier = to1.supplier;
                    String supplier_id = to1.supplier_id;
                    int vatable = to1.vatable;
                    if (selling_price == 0) {
                        zero_rate_sale++;
                    }
                    if (to1.vatable == 0) {
                        vat_exempt_sale += product_qty * selling_price;
                    } else {
                        vatable_sale += product_qty * selling_price;
                    }

                    Srpt_receipt.field tbar = new Srpt_receipt.field(to1.description + add, new Date(), (to1.product_qty * to1.selling_price), to1.product_qty, to1.selling_price);
                    fields.add(tbar);

                }
                vat_exempt_sale += to.service_amount;
                String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
                String operated_by = System.getProperty("operated_by", "");
                String address = System.getProperty("address", "");
                String status = System.getProperty("status", "NV");
                String tin_no = System.getProperty("tin_no", "") + " " + status;
                String serial_no = System.getProperty("serial_no", "");
                String permit_no = System.getProperty("permit_no", "");
                String datetime = DateType.slash_w_time.format(new Date());
                String or_no = "OR NO. " + to.or_no;
                String items = System.getProperty("items", "");
                double total_due = to.amount_due + to.service_amount;
                double cash = to.amount_paid;
                String check_bank = to.check_bank;
                double check_amount = to.check_amount;
                double change_due = (to.amount_paid + to.check_amount) - (total_due - to.discount_amount);
                System.out.println(change_due + " - - ");
                String receipt_infos = System.getProperty("receipt_infos", "");
                String receipt_footer = System.getProperty("receipt_footer", "");
                double discount = to.discount_amount;
                String cashier_name = Users.user_name;
                String discount_name = to.discount_name;
                if (discount_name.equalsIgnoreCase("NO DISCOUNT")) {
                    discount_name = "";
                }
                String pos_no = "POS 1";
                int total_qty = qty;
                String accreditation_no = System.getProperty("acct_no", "Accreditation No. 000-0000000000-000000");
                String trans_no = to.or_no;
                String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
                String discount_customer_name = to.discount_customer_name;
                String discount_customer_id = to.discount_customer_id;
                discount_customer_name = discount_customer_name + " - " + discount_customer_id;
                String min_no = System.getProperty("min_no", "MIN NO: 130321854");
                double addtl_service = to.service_amount;
                double vat_percent = vatable_sale * .12;
                String customer_address = to.customer_address;
                String check_no = to.check_no;
                Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, to.customer_name, cashier_name, discount_name, pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address, "", to.amount_due, check_no);
                rpt.fields.addAll(fields);
                String l = "rpt_receipt.jrxml";
                InputStream is = Srpt_receipt.class.getResourceAsStream(l);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    JasperPrintManager.printReport(jasperPrint, false);
                } catch (JRException ex) {
                    Logger.getLogger(Dlg_delivery.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void print_deliver_all() {

        List<to_sales> sales = tbl_sales_ALM;

        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_delivery_receipt.field> fields = new ArrayList();

        for (to_sales to : sales) {
            if (to.selected == true) {
                String where = " where or_no='" + to.or_no + "'";
                List<S1_sales_items.to_sales_items> datas = new ArrayList();// S1_sales_items.ret_data3(where);
//                JOptionPane.showMessageDialog(null, to.is_sales);
                if (to.is_sales == 1) {
                    datas = S1_sales_items.ret_data3(where);
                } else {
                    where = " where sales_no='" + to.or_no + "'";
                    datas = S1_sales_dr_items.ret_data(where);
                }

                for (S1_sales_items.to_sales_items to1 : datas) {
                    double qty = to1.product_qty;
                    String description = to1.description;
                    double price = to1.selling_price;
                    double amount = qty * price;
                    String customer_name = to.customer_name;
                    String customer_id = to.customer_id;
                    String customer_contact_no = to.customer_contact_no;
                    String customer_address = to.customer_address;
                    String dispatch_time = "";
                    String driver = to.driver_name;
                    String checked_by = "";
                    if (Users.screen_name != null) {
                        checked_by = Users.screen_name.toUpperCase();
                    }
                    String released_by = "";
                    String clearance_no = "";
                    String released_date = DateType.convert_jan_1_2013_datetime2(to.date_added);
                    if (to.time_delivered != null) {
                        dispatch_time = DateType.convert_slash_datetime2(to.time_delivered);
                    }
                    double amount_due = to.amount_due + to.service_amount;
                    double discount = to.discount_amount;
                    double addtl_service = to.service_amount;
                    String discount_customer_name = to.discount_customer_name;
                    double total_duel = (amount_due) - to.discount_amount;
                    String or_no = to.or_no;
                    String vehicle_no = to.vehicle_name;
                    Srpt_delivery_receipt.field f = new Srpt_delivery_receipt.field(qty, description, price, amount, customer_name, customer_id, customer_contact_no, customer_address, dispatch_time, driver, checked_by, released_by, clearance_no, released_date, amount_due, discount, addtl_service, discount_customer_name, total_duel, or_no, vehicle_no);
                    fields.add(f);
                }

            }

        }
        Window p = (Window) this;
        Dlg_delivery_guide nd = Dlg_delivery_guide.create(p, true);
        nd.setTitle("");
        nd.do_pass(fields);
        nd.setCallback(new Dlg_delivery_guide.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_delivery_guide.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void prompt_customer() {
            
    }

    private void on_account_payment() {
        Window p = (Window) this;
        Dlg_on_account_payments nd = Dlg_on_account_payments.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_on_account_payments.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_on_account_payments.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void update_multi_delivery() {
        List<to_sales> datas = tbl_sales_ALM;
        final List<to_sales> datas2 = new ArrayList();
        String customer_name = "";
        String vehicle_name = "";
        String vehicle_id = "";
        String driver_name = "";
        String driver_id = "";
        String time_delivered = "";
        for (to_sales to : datas) {
            if (to.selected == true) {
                customer_name = customer_name + "," + to.customer_name;
                vehicle_name = to.vehicle_name;
                vehicle_id = to.vehicle_id;
                driver_name = to.driver_name;
                driver_id = to.driver_id;
                time_delivered = to.time_delivered;
                datas2.add(to);
            }
        }
        if (customer_name.isEmpty()) {
            Alert.set(0, "Please select customer/s");
            return;
        }
        customer_name = customer_name.substring(1, customer_name.length());
        Window p = (Window) this;
        Dlg_delivery_multi_update nd = Dlg_delivery_multi_update.create(p, true);
        nd.setTitle("");
        nd.do_pass(customer_name, vehicle_name, vehicle_id, driver_name, driver_id, time_delivered);
        nd.setCallback(new Dlg_delivery_multi_update.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_delivery_multi_update.OutputData data) {
                closeDialog.ok();
                System.out.println("S1 " + data.time_delivered);
                S1_sales.edit_sales_delivery2(datas2, data.vehicle_id, data.vehicle_name, data.driver_id, data.driver_name, data.time_delivered);
                data_cols();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void customer_accounts() {
        Window p = (Window) this;
        Dlg_customer_accounts nd = Dlg_customer_accounts.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_customer_accounts.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_accounts.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void reprint() {
        Window p = (Window) this;
        Dlg_customer_sales nd = Dlg_customer_sales.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_customer_sales.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_sales.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void deposits() {
        Window p = (Window) this;
        Dlg_deposits nd = Dlg_deposits.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_deposits.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_deposits.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    public class Loader extends SwingWorker {

        private Loading dialog;

        public Loader(JDialog dlg) {

            dialog = new Loading();
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            dialog.setSize(xSize, ySize);
            dialog.setPreferredSize(new Dimension(xSize, ySize));
            dialog.setAlwaysOnTop(true);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == SwingWorker.StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == SwingWorker.StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {

            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                }
            });

        }

    }
    S1_sales.to_sales my_sales = null;
    double my_change = 0;
    List<S1_sales_services.to_sales_services> my_services = new ArrayList();
    String my_sales_no = "";
    int my_qty = 0;
    List<Srpt_receipt.field> my_fields = new ArrayList();
    double my_vatable_sale = 0;
    double my_zero_rate_sale = 0;
    double my_vat_exempt_sale = 0;
    double my_vat_percent = 0;

    private void settle_now() {
        List<S1_sales_items.to_sales_items> datas = tbl_sales_items_ALM;
        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_receipt.field> fields = new ArrayList();
        int qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;
        String customer_name = my_sales.customer_name;
        String customer_id = my_sales.customer_id;
        for (S1_sales_items.to_sales_items to1 : datas) {
            int id = to1.id;
            String barcode = to1.barcode;
            String description = to1.description;
            String generic_name = to1.generic_name;
            String category = to1.category;
            String category_id = to1.category_id;
            String classification = to1.classification;
            String classification_id = to1.classification_id;
            String sub_classification = to1.sub_classification;
            String sub_classification_id = to1.sub_classification_id;
            double product_qty = to1.product_qty;
            qty += product_qty;
            String unit = to1.unit;
            double conversion = to1.conversion;
            double selling_price = to1.selling_price;
            String date_added = to1.date_added;
            String user_name = to1.user_name;
            String item_type = to1.item_type;
            int status = to1.status;
            String session_no = to1.session_no;
            String item_discount = to1.item_discount;
            double discount = to1.discount;
            double discount_amount = to1.discount_amount;
            String sales_no = to1.sales_no;
            String add = "";
            if (discount_amount > 0) {
                add = " - " + FitIn.fmt_wc_0(discount_amount) + " disc";
            }
            int fixed_price = to1.fixed_price;

            String supplier = to1.supplier;
            String supplier_id = to1.supplier_id;
            int vatable = to1.vatable;
            if (selling_price == 0) {
                zero_rate_sale++;
            }
            if (to1.vatable == 0) {
                vat_exempt_sale += product_qty * selling_price;
            } else {
                vatable_sale += product_qty * selling_price;
            }

            Srpt_receipt.field tbar = new Srpt_receipt.field(to1.description + add, new Date(), (to1.selling_price * to1.product_qty), to1.product_qty, to1.selling_price);
            fields.add(tbar);
            String or_no = my_sales.sales_no;
            String location_id = to1.location_id;
            String location_name = to1.location_name;

            S1_sales_items.to_sales_items to3 = new S1_sales_items.to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, to1.metered, location_id, location_name);
            datas2.add(to3);
        }

        my_fields.addAll(fields);
        double net_due = ((my_sales.amount_due + my_sales.service_amount) - my_sales.discount_amount);
        System.out.println("TOTAL DUE: " + my_sales.amount_due + "+" + my_sales.service_amount + " = " + my_sales.discount_amount);
        vat_exempt_sale += my_sales.service_amount;
        vatable_sale = net_due / 1.12;
        double vat_percent = vatable_sale * .12;

        String print = System.getProperty("print_to_receipts", "false");
        String business_name = System.getProperty("business_name", "");
        String sa = "";

        if (my_sales.payment_type_id.equals("2")) {
            sa = MySales.add_sales_dr(my_sales, datas2, my_services);
        } else {
            sa = MySales.add_sales(my_sales, datas2, my_services);
        }
        my_sales_no = sa;
        set_change();
    }

    private void set_change() {
        double net_due = ((my_sales.amount_due + my_sales.service_amount) - my_sales.discount_amount);
        String print = System.getProperty("print_to_receipts", "false");
        String or_no = "OR NO. " + my_sales_no;
        String business_name = System.getProperty("business_name", "");
        String customer_name = my_sales.customer_name;
        String customer_id = my_sales.customer_id;
        if (lbl_payment_type_id.getText().equals("2")) {
            or_no = "DR NO. " + my_sales_no;
        }
        double total_due = net_due;

        if (print.equals("true")) {
            String operated_by = System.getProperty("operated_by", "");
            String address = System.getProperty("address", "");
            String status = System.getProperty("status", "NV");
            String tin_no = System.getProperty("tin_no", "") + " " + status;
            String serial_no = System.getProperty("serial_no", "");
            String permit_no = System.getProperty("permit_no", "");
            String datetime = DateType.slash_w_time.format(new Date());

            String items = System.getProperty("items", "");
            double cash = my_sales.amount_paid;
            String check_bank = my_sales.check_bank;
            double check_amount = my_sales.check_amount;
            double change_due = my_change;
            String receipt_infos = System.getProperty("receipt_infos", "");
            String receipt_footer = System.getProperty("receipt_footer", "");
            double discount = my_sales.discount_amount;
            String cashier_name = Users.user_name;
            String discount_name = my_sales.discount_name;
            if (discount_name.equalsIgnoreCase("NO DISCOUNT")) {
                discount_name = "";
            }
            String pos_no = "POS 1";
            int total_qty = my_qty;
            String accreditation_no = System.getProperty("acct_no", "Accreditation No. 000-0000000000-000000");
            String trans_no = my_sales.or_no;
            String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
            String discount_customer_name = my_sales.discount_customer_name;
            String discount_customer_id = my_sales.discount_customer_id;
            discount_customer_name = discount_customer_name + " - " + discount_customer_id;
            String min_no = System.getProperty("min_no", "MIN NO: 130321854");
            double addtl_service = my_sales.service_amount;
            String customer_address = my_sales.customer_address;

            String l = "rpt_receipt.jrxml";
            if (lbl_payment_type_id.getText().equals("2")) {
                l = "rpt_receipt_1.jrxml";
            }
            trans_no = my_sales_no;
            double amount_due = my_sales.amount_due;
            String check_no = my_sales.check_no;
            Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items, total_due, cash, change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name, pos_no, total_qty, my_vatable_sale, my_zero_rate_sale, my_vat_exempt_sale, my_vat_percent, accreditation_no, trans_no, check_bank, check_amount, telephone_number, discount_customer_name, discount_customer_id, min_no, addtl_service, customer_address, "", amount_due, check_no);

            rpt.fields.addAll(my_fields);
            InputStream is = Srpt_receipt.class.getResourceAsStream(l);
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(is);
                jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                        setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
                JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException ex) {
                Logger.getLogger(Dlg_delivery.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        set_change(my_change);
    }

}
