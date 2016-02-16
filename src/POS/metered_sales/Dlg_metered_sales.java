/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.metered_sales;

import POS.customers.S1_customers;
import POS.metered_sales.S1_metered_sale_readings.to_metered_sale_readings;
import POS.metered_sales.S1_metered_sales.to_metered_sales;
import POS.util.Courier;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.TableRenderer;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Ronald
 */
public class Dlg_metered_sales extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_metered_sales
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
    private Dlg_metered_sales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_metered_sales(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_metered_sales() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_metered_sales myRef;

    private void setThisRef(Dlg_metered_sales myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_metered_sales> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_metered_sales create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_metered_sales create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_metered_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_metered_sales((java.awt.Frame) parent, false);
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
            Dlg_metered_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_metered_sales((java.awt.Dialog) parent, false);
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

        Dlg_metered_sales dialog = Dlg_metered_sales.create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_metered_sale_readings = new javax.swing.JTable();
        tf_qty1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_qty2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_qty3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        dp_to = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_customer_name = new javax.swing.JTextField();
        tf_customer_id = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_metered_sales = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_meter_type = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jMenuItem3.setText("Department");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem1.setText("Print SOA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Payment");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem4.setText("Ledger");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_metered_sale_readings.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_metered_sale_readings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_metered_sale_readingsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_metered_sale_readings);

        tf_qty1.setFocusable(false);

        jLabel8.setText("Previous Reading:");

        jLabel9.setText("Current Reading:");

        tf_qty2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_qty2KeyReleased(evt);
            }
        });

        jLabel10.setText("Total:");

        tf_qty3.setFocusable(false);

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel12.setText("0");

        jLabel11.setText("# of Readings:");

        jButton8.setText("Settings");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Reports");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel13.setText("Period from:");

        dp_from.setDate(new Date());

        jLabel14.setText("To:");

        dp_to.setDate(new Date());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_qty2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_qty3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_qty1)
                        .addComponent(jButton8))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_qty2)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qty3)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Customer:");

        tf_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_customer_nameActionPerformed(evt);
            }
        });

        jLabel2.setText("Description:");

        jLabel3.setText("Starting cm3:");

        tbl_metered_sales.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_metered_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_metered_salesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_metered_salesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_metered_salesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_metered_sales);

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

        jButton3.setText("Add");
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

        jLabel4.setText("Type:");

        tf_meter_type.setText("Low Pressure");
        tf_meter_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_meter_typeActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Transaction/s:");

        jLabel6.setText("0");

        tf_price.setFocusable(false);
        tf_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_priceActionPerformed(evt);
            }
        });

        jLabel7.setText("Price:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_customer_name)
                        .addGap(1, 1, 1)
                        .addComponent(tf_customer_id))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_meter_type)
                            .addComponent(tf_description)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_meter_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tf_qty, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_price, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_customer_nameActionPerformed
        init_customers();
    }//GEN-LAST:event_tf_customer_nameActionPerformed

    private void tf_meter_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_meter_typeActionPerformed
        init_types();
    }//GEN-LAST:event_tf_meter_typeActionPerformed

    private void tf_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_priceActionPerformed
        add_metered_sales();
    }//GEN-LAST:event_tf_priceActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_metered_sales();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_metered_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_metered_salesMouseClicked
        select_metered_sales();
    }//GEN-LAST:event_tbl_metered_salesMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        add_reading();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_metered_sales();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_metered_sales();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_metered_sales();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_qty2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_qty2KeyReleased
        compute();
    }//GEN-LAST:event_tf_qty2KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        delete_metered_sale_readings();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_metered_sale_readingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_metered_sale_readingsMouseClicked
        select_metered_sale_readings();
    }//GEN-LAST:event_tbl_metered_sale_readingsMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        edit_reading();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tbl_metered_salesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_metered_salesMousePressed
        show_dialog(evt);
    }//GEN-LAST:event_tbl_metered_salesMousePressed

    private void tbl_metered_salesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_metered_salesMouseReleased
        show_dialog(evt);
    }//GEN-LAST:event_tbl_metered_salesMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        print_soa();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        department();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        settings();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        payment();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ledger();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ledger();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_metered_sale_readings;
    private javax.swing.JTable tbl_metered_sales;
    private javax.swing.JTextField tf_customer_id;
    private javax.swing.JTextField tf_customer_name;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_meter_type;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_qty1;
    private javax.swing.JTextField tf_qty2;
    private javax.swing.JTextField tf_qty3;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_metered_sales();
        focus();
        init_kg_price();
        tf_customer_id.setVisible(false);
        init_tbl_metered_sale_readings();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_customer_name.grabFocus();
            }
        });

    }

    private void init_kg_price() {
        String where = " where id=6";
        S1_metered_sales_settings.to_metered_sales_settings to = S1_metered_sales_settings.ret_data2(where);
        tf_price.setText(FitIn.fmt_wc_0(to.rate));
    }

    private void focus() {
        JTextField[] tf = {tf_customer_name, tf_customer_id, tf_description, tf_meter_type, tf_qty, tf_price, tf_qty2};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
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

    List<S1_customers.to_customers> customer_list = new ArrayList();

    private void init_customers() {
        String search = tf_customer_name.getText();
        customer_list.clear();
        String where = " where last_name like '%" + search + "%' or first_name like '%" + search + "%' ";
        customer_list = S1_customers.ret_data2(where);
        Object[][] obj = new Object[customer_list.size()][2];
        int i = 0;
        for (S1_customers.to_customers to : customer_list) {
            obj[i][0] = " " + to.first_name + " " + to.last_name;
            obj[i][1] = " " + to.address;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {100, 200};
        int width = 0;
        String[] col_names = {"Name", "Address"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf_customer_name, obj, labels, tbl_widths_customers, col_names, tf_customer_name.getWidth());
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_customers.to_customers to = customer_list.get(data.selected_row);
                tf_customer_name.setText(to.first_name + " " + to.last_name);
                tf_customer_id.setText("" + to.id);
                tf_description.grabFocus();
                data_cols();
            }
        });
    }

    List<String> type_list = new ArrayList();

    private void init_types() {
        String search = tf_meter_type.getText();
        type_list.clear();
        type_list = Courier.metered_types();
        Object[][] obj = new Object[type_list.size()][1];
        int i = 0;
        for (String to : type_list) {

            obj[i][0] = " " + to;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {};
        int width = 0;
        String[] col_names = {"Type"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup2(tf_meter_type, obj, labels, tbl_widths_customers, col_names, tf_customer_name.getWidth());
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                String to = type_list.get(data.selected_row);
                tf_meter_type.setText(to);
                tf_qty.grabFocus();

            }
        });
    }
    private ArrayListModel tbl_metered_sales_ALM;
    private Tblmetered_salesModel tbl_metered_sales_M;

    private void init_tbl_metered_sales() {
        tbl_metered_sales_ALM = new ArrayListModel();
        tbl_metered_sales_M = new Tblmetered_salesModel(tbl_metered_sales_ALM);
        tbl_metered_sales.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_metered_sales.setModel(tbl_metered_sales_M);
        tbl_metered_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_metered_sales.setRowHeight(25);
        int[] tbl_widths_metered_sales = {100, 70, 100, 100, 50, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_metered_sales.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_metered_sales, i, tbl_widths_metered_sales[i]);
        }
        Dimension d = tbl_metered_sales.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_metered_sales.getTableHeader().setPreferredSize(d);
        tbl_metered_sales.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_metered_sales.setRowHeight(25);
        tbl_metered_sales.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_metered_sales, 1);
    }

    private void loadData_metered_sales(List<to_metered_sales> acc) {
        tbl_metered_sales_ALM.clear();
        tbl_metered_sales_ALM.addAll(acc);
    }

    public static class Tblmetered_salesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Description", "Remaining", "Type", "Department", "", "date_added", "description", "qty", "price", "balance", "paid", "status", "remarks"
        };

        public Tblmetered_salesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 4) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_metered_sales tt = (to_metered_sales) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.description;
                case 1:
                    return " " + FitIn.fmt_wc_0(tt.balance) + " ";
                case 2:
                    return tt.meter_type;
                case 3:
                    return " " + tt.remarks;
                case 4:
                    return tt.selected;
                case 5:
                    return tt.date_added;
                case 6:
                    return tt.description;
                case 7:
                    return tt.qty;
                case 8:
                    return tt.price;
                case 9:
                    return tt.balance;
                case 10:
                    return tt.paid;
                case 11:
                    return tt.status;
                default:
                    return tt.remarks;
            }
        }
    }

    private void data_cols() {
        String where = "where customer_id='" + tf_customer_id.getText() + "'";
        loadData_metered_sales(S1_metered_sales.ret_data(where));
    }

    private void add_metered_sales() {
        int id = -1;
        String customer_id = tf_customer_id.getText();
        String customer_name = tf_customer_name.getText();
        String user_id = Users.user_name;
        String user_name = Users.user_name;
        String date_added = DateType.now();
        String description = tf_description.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        double price = FitIn.toDouble(tf_price.getText());
        double balance = qty;
        double paid = 0;
        int status = 0;
        String remarks = "";
        String meter_type = tf_meter_type.getText();
        to_metered_sales to = new to_metered_sales(id, customer_id, customer_name, user_id, user_name, date_added, description, qty, price, balance, paid, status, remarks, false, meter_type);
        S1_metered_sales.add_metered_sales(to);
        data_cols();
    }

    private void select_metered_sales() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));
        int col = tbl_metered_sales.getSelectedColumn();
        tf_description.setText(to.description);
        tf_qty.setText(FitIn.fmt_wc_0(to.qty));
        tf_price.setText(FitIn.fmt_wc_0(to.price));
        tf_meter_type.setText(to.meter_type);
        if (col == 4) {
            if (to.selected == false) {
                to.setSelected(true);
            } else {
                to.setSelected(false);
            }
            tbl_metered_sales_M.fireTableDataChanged();
        } else {

            init_meter_readings();
        }
    }

    private void edit_metered_sales() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to1 = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));
        int id = to1.id;
        String customer_id = to1.customer_id;
        String customer_name = tf_customer_name.getText();
        String user_id = Users.user_name;
        String user_name = Users.user_name;
        String date_added = DateType.now();
        String description = tf_description.getText();
        double qty = FitIn.toDouble(tf_qty.getText());
        double price = FitIn.toDouble(tf_price.getText());
        double balance = qty;
        double paid = 0;
        int status = 0;
        String remarks = "";
        String meter_type = tf_meter_type.getText();
        to_metered_sales to = new to_metered_sales(id, customer_id, customer_name, user_id, user_name, date_added, description, qty, price, balance, paid, status, remarks, false, meter_type);
        S1_metered_sales.edit_metered_sales(to);
        data_cols();
    }

    private void delete_metered_sales() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to1 = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));
        S1_metered_sales.delete_metered_sales(to1);
        data_cols();
    }
    private ArrayListModel tbl_metered_sale_readings_ALM;
    private Tblmetered_sale_readingsModel tbl_metered_sale_readings_M;

    private void init_tbl_metered_sale_readings() {
        tbl_metered_sale_readings_ALM = new ArrayListModel();
        tbl_metered_sale_readings_M = new Tblmetered_sale_readingsModel(tbl_metered_sale_readings_ALM);
        tbl_metered_sale_readings.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_metered_sale_readings.setModel(tbl_metered_sale_readings_M);
        tbl_metered_sale_readings.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_metered_sale_readings.setRowHeight(25);
        int[] tbl_widths_metered_sale_readings = {100, 100, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_metered_sale_readings.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_metered_sale_readings, i, tbl_widths_metered_sale_readings[i]);
        }
        Dimension d = tbl_metered_sale_readings.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_metered_sale_readings.getTableHeader().setPreferredSize(d);
        tbl_metered_sale_readings.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_metered_sale_readings.setRowHeight(25);
        tbl_metered_sale_readings.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_metered_sale_readings, 1);
    }

    private void loadData_metered_sale_readings(List<to_metered_sale_readings> acc) {
        tbl_metered_sale_readings_ALM.clear();
        tbl_metered_sale_readings_ALM.addAll(acc);
    }

    public static class Tblmetered_sale_readingsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Reading", "Status", "user_id", "user_name", "date_added", "description", "qty", "price", "balance", "paid", "status", "remarks", "metered_sale_id"
        };

        public Tblmetered_sale_readingsModel(ListModel listmodel) {
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
            to_metered_sale_readings tt = (to_metered_sale_readings) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 1:
                    return FitIn.fmt_wc_0(tt.qty) + " ";
                case 2:
                    if (tt.status == 0) {
                        return "  --------";
                    } else {
                        return "  Paid";
                    }
                case 3:
                    return tt.user_id;
                case 4:
                    return tt.user_name;
                case 5:
                    return tt.date_added;
                case 6:
                    return tt.description;
                case 7:
                    return tt.qty;
                case 8:
                    return tt.price;
                case 9:
                    return tt.balance;
                case 10:
                    return tt.paid;
                case 11:
                    return tt.status;
                case 12:
                    return tt.remarks;
                default:
                    return tt.metered_sale_id;
            }
        }
    }

    private void data_cols_reading() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));
        String where = " where metered_sale_id= '" + to.id + "'";
        loadData_metered_sale_readings(S1_metered_sale_readings.ret_data(where));

        tf_qty1.setText(FitIn.fmt_wc_0(to.balance));
        List<to_metered_sale_readings> datas = tbl_metered_sale_readings_ALM;

        for (to_metered_sale_readings to1 : datas) {

        }

    }

    private void init_meter_readings() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));
        String where = " where metered_sale_id='" + to.id + "'";
        loadData_metered_sale_readings(S1_metered_sale_readings.ret_data(where));
        tf_qty1.setText(FitIn.fmt_wc_0(to.balance));

    }

    private void add_reading() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));
        int id = 0;
        String customer_id = to.customer_id;
        String customer_name = to.customer_name;
        String user_id = Users.user_name;
        String user_name = Users.user_name;
        String date_added = DateType.now();
        String description = to.description;
        double qty = FitIn.toDouble(tf_qty3.getText());
        double price = to.price;
        double balance = FitIn.toDouble(tf_qty1.getText());
        double paid = FitIn.toDouble(tf_qty2.getText());
        int status = 0;
        String remarks = "";
        String metered_sale_id = "" + to.id;
        String department = to.remarks;
        String period_from = DateType.sf.format(dp_from.getDate());
        String period_to = DateType.sf.format(dp_to.getDate());
        to_metered_sale_readings to1 = new to_metered_sale_readings(id, customer_id, customer_name, user_id, user_name, date_added, description, qty, price, balance, paid, status, remarks, metered_sale_id, department, period_from, period_to);
        S1_metered_sale_readings.add_metered_sale_readings(to1, "" + to.id);
        data_cols();
        tbl_metered_sales.setRowSelectionInterval(row, row);
        data_cols_reading();
        tf_qty2.setText("");
        tf_qty3.setText("");
    }

    private void edit_reading() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));

        int row2 = tbl_metered_sale_readings.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_metered_sale_readings to2 = (to_metered_sale_readings) tbl_metered_sale_readings_ALM.get(tbl_metered_sale_readings.convertRowIndexToModel(row2));
        int id = to2.id;
        String customer_id = to.customer_id;
        String customer_name = to.customer_name;
        String user_id = Users.user_name;
        String user_name = Users.user_name;
        String date_added = DateType.now();
        String description = to.description;
        double qty = FitIn.toDouble(tf_qty3.getText());
        double price = to.price;
        double balance = FitIn.toDouble(tf_qty1.getText());
        double paid = FitIn.toDouble(tf_qty2.getText());
        int status = 0;
        String remarks = "";
        String metered_sale_id = "" + to.id;
        String department = to.remarks;
        String period_from = DateType.sf.format(dp_from.getDate());
        String period_to = DateType.sf.format(dp_to.getDate());
        to_metered_sale_readings to1 = new to_metered_sale_readings(id, customer_id, customer_name, user_id, user_name, date_added, description, qty, price, balance, paid, status, remarks, metered_sale_id, department, period_from, period_to);
        S1_metered_sale_readings.edit_metered_sale_readings(to1, "" + to.id, to2.qty);
        data_cols();
        tbl_metered_sales.setRowSelectionInterval(row, row);
        data_cols_reading();
        tf_qty2.setText("");
        tf_qty3.setText("");
    }

    private void select_metered_sale_readings() {
        int row = tbl_metered_sale_readings.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sale_readings to = (to_metered_sale_readings) tbl_metered_sale_readings_ALM.get(tbl_metered_sale_readings.convertRowIndexToModel(row));

        tf_qty3.setText(FitIn.fmt_wc_0(to.qty));
        tf_qty1.setText(FitIn.fmt_wc_0(to.balance));
        tf_qty2.setText(FitIn.fmt_wc_0(to.paid));
        try {
            Date from = DateType.sf.parse(to.period_from);
            Date too = DateType.sf.parse(to.period_to);
            dp_from.setDate(from);
            dp_to.setDate(too);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_metered_sales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void delete_metered_sale_readings() {
        int row = tbl_metered_sale_readings.getSelectedRow();
        if (row < 0) {
            return;
        }
        int row2 = tbl_metered_sales.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_metered_sale_readings to = (to_metered_sale_readings) tbl_metered_sale_readings_ALM.get(tbl_metered_sale_readings.convertRowIndexToModel(row));
        S1_metered_sale_readings.delete_metered_sale_readings(to, to.metered_sale_id);
        data_cols();
        tbl_metered_sales.setRowSelectionInterval(row2, row2);
        data_cols_reading();
        tf_qty2.setText("");
        tf_qty3.setText("");
    }

    private void compute() {
        double previous = FitIn.toDouble(tf_qty1.getText());
        double present = FitIn.toDouble(tf_qty2.getText());
        double total = previous - present;
        tf_qty3.setText(FitIn.fmt_wc_0(total));
    }

    private void clear_metered_sales() {
        tf_description.setText("");
        tf_qty.setText("");
//        tf_price.setText("");
        tf_description.grabFocus();
    }

    private void change_selected() {
        int row = tbl_metered_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_metered_sales to = (to_metered_sales) tbl_metered_sales_ALM.get(tbl_metered_sales.convertRowIndexToModel(row));

    }

    private void show_dialog(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tbl_metered_sales, evt.getX(), evt.getY());
        }
    }

    private void print_soa() {

        List<to_metered_sales> datas = tbl_metered_sales_ALM;
        List<Srpt_statement_of_account.field> fields = new ArrayList();
        String customer_id = tf_customer_id.getText();
        String where2 = " where id='" + customer_id + "'";
        S1_customers.to_customers cus = Srpt_statement_of_account.ret_data(where2);
        for (to_metered_sales to : datas) {
            if (to.selected == true) {
                String where = " where metered_sale_id='" + to.id + "' and status='" + "0" + "' ";
                List<Srpt_statement_of_account.field> f = Srpt_statement_of_account.ret_data(where, to.meter_type);
                fields.addAll(f);
            }
        }
        Window p = (Window) this;
        Dlg_soa nd = Dlg_soa.create(p, true);
        nd.setTitle("");
        nd.do_pass(fields, cus.first_name + " " + cus.last_name, "" + cus.id);
        nd.setCallback(new Dlg_soa.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_soa.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void department() {
        final List<to_metered_sales> datas = tbl_metered_sales_ALM;
        String department = "";
        for (to_metered_sales to : datas) {
            if (to.selected == true) {
                department = to.remarks;
            }

        }
        Window p = (Window) this;
        Dlg_metered_department nd = Dlg_metered_department.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_metered_department.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_metered_department.OutputData data) {
                closeDialog.ok();
                S1_metered_sales.update_department(datas, data.department);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void settings() {
        Window p = (Window) this;
        Dlg_metered_sales_settings nd = Dlg_metered_sales_settings.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_metered_sales_settings.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_metered_sales_settings.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void payment() {
        List<to_metered_sales> datas = tbl_metered_sales_ALM;
        List<Srpt_statement_of_account.field> fields = new ArrayList();
        String customer_id = tf_customer_id.getText();
        double amount_due = 0;
        final List<to_metered_sale_readings> rr = new ArrayList();
        String description = "";
        String metered_sales_id = "";
        for (to_metered_sales to : datas) {
            if (to.selected == true) {
                description = description + ", " + to.description;
                metered_sales_id = metered_sales_id + ", " + to.id;
                String where = " where metered_sale_id='" + to.id + "' and status='" + "0" + "'";
                List<to_metered_sale_readings> readings = S1_metered_sale_readings.ret_data(where);
                rr.addAll(readings);
                for (to_metered_sale_readings read : readings) {
                    amount_due += read.qty * to.price;
                }
            }
        }
        final double due = amount_due;
        if (!description.isEmpty()) {
            description = description.substring(1, description.length());
        }

        if (!metered_sales_id.isEmpty()) {
            metered_sales_id = metered_sales_id.substring(1, metered_sales_id.length());
        }
        final String metered_sales_ids = metered_sales_id;
        Window p = (Window) this;
        Dlg_metered_sales_payment nd = Dlg_metered_sales_payment.create(p, true);
        nd.setTitle("");
        nd.do_pass(amount_due, description);
        nd.setCallback(new Dlg_metered_sales_payment.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_metered_sales_payment.OutputData data) {
                closeDialog.ok();
                S1_metered_sale_readings.update_status(rr);
                int id = 0;
                String customer_id = tf_customer_id.getText();
                String customer_name = tf_customer_name.getText();
                String user_id = Users.user_name;
                String user_name = Users.user_name;
                String date_added = DateType.now();
                String or_no = data.or_no;
                double amount_due = due;
                double cash = data.cash;
                double check_amount = data.check_amount;
                String check_bank = data.check_bank;
                String check_no = data.check_no;
                int status = 0;
                String metered_sales_idd = metered_sales_ids;
                S1_metered_sales_payments.to_metered_sales_payments t = new S1_metered_sales_payments.to_metered_sales_payments(id, customer_id, customer_name, user_id, user_name, date_added, or_no, amount_due, cash, check_amount, check_bank, check_no, status, metered_sales_idd);
                S1_metered_sales_payments.add_metered_sales_payments(t);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ledger() {

        List<to_metered_sales> datas = tbl_metered_sales_ALM;
        List<Srpt_readings.field> fields = new ArrayList();
        String customer_id = tf_customer_id.getText();
        String where2 = " where id='" + customer_id + "'";

        for (to_metered_sales to : datas) {
            if (to.selected == true) {
                String where = " where metered_sale_id='" + to.id + "' ";
                List<Srpt_readings.field> f = Srpt_readings.ret_data(where);
                fields.addAll(f);
            }
        }
        Window p = (Window) this;
        Dlg_soa_print nd = Dlg_soa_print.create(p, true);
        nd.setTitle("");
        nd.do_pass(fields, tf_customer_name.getText());
        nd.setCallback(new Dlg_soa_print.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_soa_print.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
