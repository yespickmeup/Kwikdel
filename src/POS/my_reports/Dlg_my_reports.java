/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import POS.bir_session.Srpt_checks;
import POS.cash_drawer.Cash_drawer;
import POS.cash_drawer.S1_cash_drawer_checks;
import POS.cash_drawer.S1_cash_drawer_expenses;
import POS.reports.Srpt_void_items;
import POS.users.S1_users;
import POS.util.Center;
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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Dlg_my_reports extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_my_reports
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
    private Dlg_my_reports(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_my_reports(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_my_reports() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_my_reports myRef;

    private void setThisRef(Dlg_my_reports myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_my_reports> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_my_reports create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_my_reports create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_my_reports dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_reports((java.awt.Frame) parent, false);
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
            Dlg_my_reports dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_reports((java.awt.Dialog) parent, false);
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

        Dlg_my_reports dialog = Dlg_my_reports.create(new javax.swing.JFrame(), true);
        Center.setCenter(dialog);
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jButton6 = new Button.Default();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jTextField5 = new Field.Combo();
        jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jPanel16 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton4 = new Button.Default();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox27 = new javax.swing.JCheckBox();
        jTextField4 = new Field.Combo();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jButton5 = new Button.Info();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cash_drawer = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new Button.Default();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jTextField1 = new Field.Combo();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new Button.Default();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jTextField2 = new Field.Combo();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new Button.Default();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox25 = new javax.swing.JCheckBox();
        jTextField3 = new Field.Combo();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Date:");

        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox20.setText("All");
        jCheckBox20.setFocusable(false);

        jDateChooser11.setDate(new Date());
        jDateChooser11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("to");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Cashier:");

        jCheckBox29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox29.setSelected(true);
        jCheckBox29.setText("All");
        jCheckBox29.setFocusable(false);

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

        jDateChooser12.setDate(new Date());
        jDateChooser12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(396, 396, 396)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox20)))
                            .addComponent(jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox29)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Summary", jPanel14);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Date:");

        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox19.setText("All");
        jCheckBox19.setFocusable(false);

        jDateChooser9.setDate(new Date());
        jDateChooser9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("to");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Cashier:");

        jCheckBox27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox27.setSelected(true);
        jCheckBox27.setText("All");
        jCheckBox27.setFocusable(false);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jDateChooser10.setDate(new Date());
        jDateChooser10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton5.setText("Print Preview");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox19, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox19)))
                            .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox27)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        tbl_cash_drawer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cash_drawer);

        jLabel2.setText("Total no. cashcount:");

        jLabel3.setText("0");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("0.00");

        jLabel20.setText("Total Amount:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CashCount", jPanel11);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Date:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("All");
        jCheckBox2.setFocusable(false);

        jDateChooser4.setDate(new Date());
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("to");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Type:");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");
        jCheckBox3.setFocusable(false);

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Walkin");
        jCheckBox4.setFocusable(false);

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Delivery");
        jCheckBox5.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Payment:");

        buttonGroup2.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");
        jCheckBox6.setFocusable(false);

        buttonGroup2.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("Cash");
        jCheckBox7.setFocusable(false);

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("Charge");
        jCheckBox8.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cashier:");

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setSelected(true);
        jCheckBox9.setText("All");
        jCheckBox9.setFocusable(false);

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

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5))
                .addGap(137, 137, 137)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox4)
                                .addComponent(jCheckBox5))
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox2)))
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox6)
                                .addComponent(jCheckBox7)
                                .addComponent(jCheckBox8))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox9)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Collections", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Date:");

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setText("All");

        jDateChooser5.setDate(new Date());
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser6.setDate(new Date());
        jDateChooser6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("to");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Type:");

        buttonGroup3.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("All");

        buttonGroup3.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("Walkin");

        buttonGroup3.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("Delivery");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Status:");

        buttonGroup4.add(jCheckBox14);
        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setSelected(true);
        jCheckBox14.setText("All");

        buttonGroup4.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("Paid");

        buttonGroup4.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setText("Collectible");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cashier:");

        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setSelected(true);
        jCheckBox17.setText("All");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBox17)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField2))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBox11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox16, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox11)
                                .addComponent(jCheckBox12)
                                .addComponent(jCheckBox13))
                            .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox10))))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox14)
                                .addComponent(jCheckBox15)
                                .addComponent(jCheckBox16))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox17)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Collectibles", jPanel3);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Date:");

        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox18.setText("All");

        jDateChooser7.setDate(new Date());
        jDateChooser7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser8.setDate(new Date());
        jDateChooser8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("to");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Cashier:");

        jCheckBox25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox25.setSelected(true);
        jCheckBox25.setText("All");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCheckBox25)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCheckBox18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox18))))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox25)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sold Items", jPanel8);

        jLabel1.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        get_data_collections();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_cashier(jTextField1);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_cashier(jTextField1);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        get_data_collectibles();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_cashier(jTextField2);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_cashier(jTextField2);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        get_data_sold_items();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_cashier(jTextField3);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_cashier(jTextField3);
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        fetch_data_cash_drawer();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_cashier(jTextField4);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_cashier(jTextField4);
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        print_preview_cash_count();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        get_data_summary();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_cashier(jTextField5);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_cashier(jTextField5);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void tbl_cash_drawerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawerMouseClicked
        select_count();
    }//GEN-LAST:event_tbl_cash_drawerMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser12;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
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
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tbl_cash_drawer;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_cash_drawer(tbl_cash_drawer);
        String where = "";
        cashiers_list = S1_users.ret_data2(where);
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

    //<editor-fold defaultstate="collapsed" desc=" collections ">
    private void get_data_collections() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        jButton1.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where customer_name like '%" + "" + "%' ";
                String date_from = DateType.sf.format(jDateChooser3.getDate());
                String date_to = DateType.sf.format(jDateChooser4.getDate());
                if (!jCheckBox2.isSelected()) {
                    where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (jCheckBox4.isSelected()) {
                    where = where + " and transaction_type_id='" + "1" + "' ";
                }
                if (jCheckBox5.isSelected()) {
                    where = where + " and transaction_type_id='" + "2" + "' ";
                }
                if (jCheckBox7.isSelected()) {
                    where = where + " and payment_type_id='" + "1" + "' ";
                }
                if (jCheckBox8.isSelected()) {
                    where = where + " and payment_type_id='" + "2" + "' ";
                }
                if (!jCheckBox9.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField1;
                    where = where + " and user_name='" + combo.getId() + "' ";
                }
                where = where + " and status IN(0,5,6,7,8)";
                System.out.println(where);
                List<Srpt_collections.field> datas = Srpt_collections.ret_data(where);
                double cash_direct = 0;
                double cash_charge = 0;
                double cash_total = 0;
                double walkin = 0;
                double delivery = 0;
                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
                String date = DateType.slash.format(jDateChooser3.getDate()) + " - " + DateType.slash.format(jDateChooser4.getDate());
                String cashier = jTextField1.getText();
                String transaction_type = "All - [Walkin/Delivery]";
                String payment_type = "All - [Cash/Charge]";
                double check_total = 0;
                if (jCheckBox9.isSelected()) {
                    cashier = "All";
                }

                if (jCheckBox4.isSelected()) {
                    transaction_type = "Walkin";
                }
                if (jCheckBox5.isSelected()) {
                    transaction_type = "Delivery";
                }

                if (jCheckBox7.isSelected()) {
                    payment_type = "Cash";
                }
                if (jCheckBox8.isSelected()) {
                    payment_type = "Charge";
                }
                for (Srpt_collections.field to : datas) {
                    check_total += to.check_amount;

                    if (!to.dr_no.isEmpty()) {
                        cash_charge += to.cash;
                    } else {
                        cash_direct += to.cash;
                    }
                    if (to.transaction_type.equalsIgnoreCase("walkin")) {
                        walkin += to.amount_due;
                    } else {
                        delivery += to.amount_due;
                    }
                }

                cash_total = cash_direct + cash_charge;
                Srpt_collections rpt = new Srpt_collections(cash_direct, cash_charge, cash_total, walkin, delivery, business_name, address, date, cashier, transaction_type, payment_type, check_total);
                rpt.fields.addAll(datas);
                String jrxml = "rpt_collections.jrxml";
                report_collections(rpt, jrxml);
                try {
                    JasperReport jasperReport = null;
                    InputStream is = Srpt_collections.class.getResourceAsStream(jrxml);
                    jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.emptyDatasource());
                } catch (JRException ex) {
                    Logger.getLogger(Srpt_void_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                jButton1.setEnabled(true);
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_collections(final Srpt_collections to, String jrxml_name) {
        jPanel5.removeAll();
        jPanel5.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_collections(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel5.add(viewer);
            jPanel5.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_collections(Srpt_collections to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_collections(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_collections(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_collections.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    JasperPrint jasperPrint = null;

    private void print() {
        try {
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    List<S1_users.to_users> cashiers_list = new ArrayList();

    private void init_cashier(final JTextField tf) {

        Object[][] obj = new Object[cashiers_list.size()][1];
        int i = 0;
        for (S1_users.to_users to : cashiers_list) {
            obj[i][0] = " " + to.screen_name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf.getWidth()};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo combo = (Field.Combo) tf;
                S1_users.to_users to = cashiers_list.get(data.selected_row);
                tf.setText(to.screen_name);
                combo.setId("" + to.user_name);
            }
        });
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" collectibles ">
    private void get_data_collectibles() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where customer_name like '%" + "" + "%' ";
                String date_from = DateType.sf.format(jDateChooser5.getDate());
                String date_to = DateType.sf.format(jDateChooser6.getDate());
                if (!jCheckBox10.isSelected()) {
                    where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox17.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField2;
                    where = where + " and user_name='" + combo.getId() + "' ";
                }
                if (jCheckBox12.isSelected()) {
                    where = where + " and transaction_type_id='" + "1" + "' ";
                }
                if (jCheckBox13.isSelected()) {
                    where = where + " and transaction_type_id='" + "2" + "' ";
                }
                if (jCheckBox15.isSelected()) {
                    where = where + " and charge_status='" + "1" + "' ";
                }
                if (jCheckBox16.isSelected()) {
                    where = where + " and charge_status='" + "0" + "' ";
                }
                System.out.println(where);
                List<Srpt_collectibles.field> datas = Srpt_collectibles.ret_data(where);
                double total_amount = 0;
                double paid = 0;
                double collectible = 0;
                double walkin = 0;
                double delivery = 0;
                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
                String date = DateType.slash.format(jDateChooser3.getDate()) + " - " + DateType.slash.format(jDateChooser4.getDate());
                String cashier = jTextField2.getText();
                String transaction_type = "All - [Walkin/Delivery]";
                String payment_type = "All - [Paid/Collectible]";
                double paid_check = 0;
                if (jCheckBox17.isSelected()) {
                    cashier = "All";
                }

                if (jCheckBox12.isSelected()) {
                    transaction_type = "Walkin";
                }
                if (jCheckBox13.isSelected()) {
                    transaction_type = "Delivery";
                }

                if (jCheckBox15.isSelected()) {
                    payment_type = "Paid";
                }
                if (jCheckBox16.isSelected()) {
                    payment_type = "Collectible";
                }

                for (Srpt_collectibles.field to : datas) {
                    total_amount += to.amount_due;
                    if (to.status.equalsIgnoreCase("Paid")) {
                        paid += to.cash;
                        paid_check += to.check_amount;
                    }
                    if (to.transaction_type.equalsIgnoreCase("walkin")) {
                        walkin += to.amount_due;
                    } else {
                        delivery += to.amount_due;
                    }

                }
                collectible = total_amount - (paid + paid_check);

                Srpt_collectibles rpt = new Srpt_collectibles(total_amount, paid, collectible, walkin, delivery, business_name, address, date, cashier, transaction_type, payment_type, paid_check);
                rpt.fields.addAll(datas);
                String jrxml = "rpt_collectibles.jrxml";
                report_collectibles(rpt, jrxml);

                try {
                    JasperReport jasperReport = null;
                    InputStream is = Srpt_collectibles.class.getResourceAsStream(jrxml);
                    jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.emptyDatasource());
                } catch (JRException ex) {
                    Logger.getLogger(Srpt_void_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_collectibles(final Srpt_collectibles to, String jrxml_name) {
        jPanel7.removeAll();
        jPanel7.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_collectibles(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel7.add(viewer);
            jPanel7.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_collectibles(Srpt_collectibles to, String rpt_name) {
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
            InputStream is = Srpt_collectibles.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    JasperPrint jasperPrint2 = null;

    private void print2() {
        try {
            JasperPrintManager.printReport(jasperPrint2, true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" items ">

    private void get_data_sold_items() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where si.customer_name like '%" + "" + "%' ";
                String date_from = DateType.sf.format(jDateChooser7.getDate());
                String date_to = DateType.sf.format(jDateChooser8.getDate());
                if (!jCheckBox18.isSelected()) {
                    where = where + " and Date(si.date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox25.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField3;
                    where = where + " and si.user_name='" + combo.getId() + "' ";
                }
                where = where + " and si.status IN(0,5,6,7,8) group by si.description,si.selling_price ";
                System.out.println(where);

                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
                String date = DateType.slash.format(jDateChooser7.getDate()) + " - " + DateType.slash.format(jDateChooser8.getDate());
                String cashier = jTextField3.getText();
                String transaction_type = "All";
                String payment_type = "All";

                List<Srpt_collections_items.field> datas = Srpt_collections_items.ret_data_sales_items(where);
                List<Srpt_collections_items.field> datas2 = Srpt_collections_items.ret_data_sales_dr_items(where);

                Srpt_collections_items rpt = new Srpt_collections_items(business_name, address, date, cashier, transaction_type, payment_type);
                rpt.fields.addAll(datas);
                rpt.fields.addAll(datas2);
                String jrxml = "rpt_collections_items.jrxml";
                report_sold_items(rpt, jrxml);

                try {
                    JasperReport jasperReport = null;
                    InputStream is = Srpt_collections_items.class.getResourceAsStream(jrxml);
                    jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint3 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.emptyDatasource());
                } catch (JRException ex) {
                    Logger.getLogger(Srpt_void_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_sold_items(final Srpt_collections_items to, String jrxml_name) {
        jPanel10.removeAll();
        jPanel10.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_sold_items(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel10.add(viewer);
            jPanel10.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_sold_items(Srpt_collections_items to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_sold_items(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_sold_items(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_collections_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    JasperPrint jasperPrint3 = null;

    private void print3() {
        try {
            JasperPrintManager.printReport(jasperPrint3, true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" cash_drawer "> 
    public static ArrayListModel tbl_cash_drawer_ALM;
    public static Tblcash_drawerModel tbl_cash_drawer_M;

    public static void init_tbl_cash_drawer(JTable tbl_cash_drawer) {
        tbl_cash_drawer_ALM = new ArrayListModel();
        tbl_cash_drawer_M = new Tblcash_drawerModel(tbl_cash_drawer_ALM);
        tbl_cash_drawer.setModel(tbl_cash_drawer_M);
        tbl_cash_drawer.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer.setRowHeight(25);
        int[] tbl_widths_cash_drawer = {100, 100, 100, 100, 100, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer, i, tbl_widths_cash_drawer[i]);
        }
        Dimension d = tbl_cash_drawer.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_cash_drawer.getTableHeader().setPreferredSize(d);
        tbl_cash_drawer.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_cash_drawer.setRowHeight(25);
        tbl_cash_drawer.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_cash_drawer, 3);
    }

    public static void loadData_cash_drawer(List<Cash_drawer.to_cash_drawer> acc) {
        tbl_cash_drawer_ALM.clear();
        tbl_cash_drawer_ALM.addAll(acc);
    }

    public static class Tblcash_drawerModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "User", "Cashin", "CashCount", "Amount", "", "", "cash_out", "thousand", "five_hundred", "two_hundred", "fifty", "twenty", "coins", "one_hundred", "expenses"
        };

        public Tblcash_drawerModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 5) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Cash_drawer.to_cash_drawer tt = (Cash_drawer.to_cash_drawer) getRow(row);
            double thousand = 1000 * tt.thousand;
            double five_hundred = 500 * tt.five_hundred;
            double two_hundred = 200 * tt.two_hundred;
            double one_hundred = 100 * tt.one_hundred;
            double fifty = 50 * tt.fifty;
            double twenty = 20 * tt.twenty;
            double coins = tt.coins;
            double total = thousand + five_hundred + two_hundred + one_hundred + fifty + twenty + coins;
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime(tt.time_in);
                case 1:
                    return " " + tt.screen_name;
                case 2:
                    return FitIn.fmt_wc_0(tt.amount) + " ";
                case 3:
                    return FitIn.fmt_wc_0(total) + " ";
                case 4:
                    return FitIn.fmt_wc_0(total + tt.amount) + " ";
                case 5:
                    return tt.selected;
                case 6:
                    return tt.amount;
                case 7:
                    return tt.cash_out;
                case 8:
                    return tt.thousand;
                case 9:
                    return tt.five_hundred;
                case 10:
                    return tt.two_hundred;
                case 11:
                    return tt.fifty;
                case 12:
                    return tt.twenty;
                case 13:
                    return tt.coins;
                case 14:
                    return tt.one_hundred;
                default:
                    return tt.expenses;
            }
        }
    }

    private void fetch_data_cash_drawer() {
        String date_from = DateType.sf.format(jDateChooser10.getDate());
        String date_to = DateType.sf.format(jDateChooser9.getDate());
        String where = " where session_no like '%" + "" + "%' ";
        if (!jCheckBox19.isSelected()) {
            where = where + " and Date(time_in) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox27.isSelected()) {
            Field.Combo cashier = (Field.Combo) jTextField4;
            where = where + " and user_name = '" + cashier.getId() + "'";
        }
        System.out.println(where);
        List<Cash_drawer.to_cash_drawer> datas = Cash_drawer.ret_data(where);
        double amount = 0;
        for (Cash_drawer.to_cash_drawer tt : datas) {
            double thousand = 1000 * tt.thousand;
            double five_hundred = 500 * tt.five_hundred;
            double two_hundred = 200 * tt.two_hundred;
            double one_hundred = 100 * tt.one_hundred;
            double fifty = 50 * tt.fifty;
            double twenty = 20 * tt.twenty;
            double coins = tt.coins;
            double total = thousand + five_hundred + two_hundred + one_hundred + fifty + twenty + coins;
            amount += tt.amount + total;
        }
        jLabel19.setText(FitIn.fmt_wc_0(amount));
        jLabel3.setText("" + datas.size());
        loadData_cash_drawer(datas);
    }

    private void print_preview_cash_count() {
        List<Cash_drawer.to_cash_drawer> datas = tbl_cash_drawer_ALM;

        String business_name = System.getProperty("business_name", "Kwikdel Trading");
        String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
        String operated_by = Users.getScreen_name();
        double cash_in = 0;
        double thousand = 0;
        double five_hundred = 0;
        double two_hundred = 0;
        double one_hundred = 0;
        double fifty = 0;
        double twenty = 0;
        double coins = 0;
        double cash_total = 0;
        String cashier_name = jTextField4.getText();
        double net_total = 0;
        List<Srpt_checks.field> checks = new ArrayList();
        List<Srpt_checks.field> expenses = new ArrayList();
        double grand_sales = 0;
        double grand_checks = 0;
        double grand_expenses = 0;
        for (Cash_drawer.to_cash_drawer to : datas) {
            if (to.selected == true) {
                cash_in += to.amount;
                thousand += (to.thousand * 1000);
                five_hundred += (to.five_hundred * 500);
                two_hundred += (to.two_hundred * 200);
                one_hundred += (to.one_hundred * 100);
                fifty += (to.fifty * 50);
                twenty += (to.twenty * 20);
                coins += to.coins;
                Date d = new Date();
                try {
                    d = DateType.datetime.parse(to.time_in);
                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_my_reports.class.getName()).log(Level.SEVERE, null, ex);
                }
                String dd = DateType.sf.format(d);
                String where_check = " where Date(time_in) = '" + dd + "' and user_name='" + to.user_name + "' ";
                List<Srpt_checks.field> ch = S1_cash_drawer_checks.fetch_data(where_check);
                checks.addAll(ch);
            }

        }

        String date_from = DateType.sf.format(jDateChooser10.getDate());
        String date_to = DateType.sf.format(jDateChooser9.getDate());
        String where_expenses = " where session_no like '" + "" + "' ";
        if (!jCheckBox19.isSelected()) {
            where_expenses = where_expenses + " and Date(time_in) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox27.isSelected()) {
            Field.Combo cashier = (Field.Combo) jTextField4;
            where_expenses = where_expenses + " and user_name='" + cashier.getId() + "' ";
        } else {
            cashier_name = "All";
        }
        expenses = S1_cash_drawer_expenses.fetch_data(where_expenses);
        for (Srpt_checks.field to : checks) {
            grand_checks += to.getCheck_amount();
        }
        
        for (Srpt_checks.field to : expenses) {
            grand_expenses += to.getCheck_amount();
        }
        cash_total = cash_in + thousand + five_hundred + two_hundred + one_hundred + fifty + twenty + coins;
        grand_sales = cash_total + grand_checks;
        net_total = grand_sales - grand_expenses;
        String date = DateType.slash.format(jDateChooser10.getDate()) + " - " + DateType.slash.format(jDateChooser9.getDate());

        Window p = (Window) this;
        Dlg_my_report_cashcount nd = Dlg_my_report_cashcount.create(p, true);
        nd.setTitle("");
        nd.do_pass(business_name, address, operated_by, cash_in, thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, coins, cash_total, cashier_name, net_total, date, checks, expenses, grand_sales, grand_checks, grand_expenses);
        nd.setCallback(new Dlg_my_report_cashcount.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_report_cashcount.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void select_count() {
        int row = tbl_cash_drawer.getSelectedRow();
        if (row < 0) {
            return;
        }
        Cash_drawer.to_cash_drawer to = (Cash_drawer.to_cash_drawer) tbl_cash_drawer_ALM.get(row);
        int col = tbl_cash_drawer.getSelectedColumn();
        if (col == 5) {
            if (to.selected == true) {
                to.setSelected(false);
                tbl_cash_drawer_M.fireTableDataChanged();
            } else {
                to.setSelected(true);
                tbl_cash_drawer_M.fireTableDataChanged();
            }
        }
    }
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" summary ">

    private void get_data_summary() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                double total_gross_sales = 0;
                double walkin_gross_sales = 0;
                double charge_gross_sales = 0;
                double total_items_sold = 0;
                double walkin_items_sold = 0;
                double charge_items_sold = 0;
                double total_vatable_sales = 0;
                double total_non_vatable_sales = 0;
                double total_vat = 0;
                double total_cash_collected = 0;
                double walkin_cash_payment = 0;
                double walkin_check_payment = 0;
                double charge_cash_payment = 0;
                double total_charge_amount = 0;
                double charge_check_payment = 0;
                double total_collectible = 0;
                double total_no_of_transactions = 0;
                double walkin_trans = 0;
                double charge_transactions = 0;

                String business_name = System.getProperty("business_name", "Kwikdel Trading");
                String address = System.getProperty("address", "25 Dr. V. Locsin Street, Dumaguete, 6200");
                String date = DateType.slash.format(jDateChooser12.getDate()) + " - " + DateType.slash.format(jDateChooser11.getDate());
                String cashier = jTextField5.getText();
                String printed_by = Users.getScreen_name();
                double total_delivery_charge = 0;
                double total_discount = 0;
                double total_check_collected = 0;
                if (jCheckBox29.isSelected()) {
                    cashier = "All";
                }
                //collections
                String where_collections = " where customer_name like '%" + "" + "%' ";
                String date_from = DateType.sf.format(jDateChooser12.getDate());
                String date_to = DateType.sf.format(jDateChooser11.getDate());
                if (!jCheckBox20.isSelected()) {
                    where_collections = where_collections + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox29.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField5;
                    where_collections = where_collections + " and user_name='" + combo.getId() + "' ";
                }
                where_collections = where_collections + " and status IN(0,5,6,7,8)";
                List<Srpt_collections.field> datas_collections = Srpt_collections.ret_data(where_collections);
                for (Srpt_collections.field to : datas_collections) {
                    total_discount += to.discount_amount;
                    total_delivery_charge += to.service_charge;
                    if (to.payment_type.equalsIgnoreCase("Charge")) {
                        charge_gross_sales += to.gross_amount;
                    } else {
                        walkin_gross_sales += to.gross_amount;
                        walkin_trans++;
                    }

                    if (!to.dr_no.isEmpty()) {
                        charge_cash_payment += to.cash;
                        charge_check_payment += to.check_amount;
                    } else {
                        walkin_cash_payment += to.cash;
                        walkin_check_payment += to.check_amount;
                    }
                }

                //collectibles
                String where_collectibles = " where customer_name like '%" + "" + "%' ";

                if (!jCheckBox20.isSelected()) {
                    where_collectibles = where_collectibles + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox29.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField5;
                    where_collectibles = where_collectibles + " and user_name='" + combo.getId() + "' ";
                }
                List<Srpt_collectibles.field> datas_collectibles = Srpt_collectibles.ret_data(where_collectibles);
                for (Srpt_collectibles.field to : datas_collectibles) {
                    total_charge_amount += to.amount_due;
                    charge_transactions++;
                    if (!to.status.equalsIgnoreCase("Paid")) {
//                        charge_gross_sales += to.gross_amount;
                        total_discount += to.discount_amount;
                        total_delivery_charge += to.service_charge;
                    }
                }

                total_gross_sales = walkin_gross_sales + charge_gross_sales;
                total_vatable_sales = ((total_gross_sales + total_delivery_charge) - (total_discount)) / 1.12;
                total_vat = total_vatable_sales * .12;
                total_cash_collected = charge_cash_payment + walkin_cash_payment;
                total_check_collected = walkin_check_payment + charge_check_payment;
                total_collectible = total_charge_amount - (charge_cash_payment + charge_check_payment);
                total_no_of_transactions = charge_transactions + walkin_trans;

                String where_items = " where si.customer_name like '%" + "" + "%' ";

                if (!jCheckBox20.isSelected()) {
                    where_items = where_items + " and Date(si.date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox29.isSelected()) {
                    Field.Combo combo = (Field.Combo) jTextField5;
                    where_items = where_items + " and si.user_name='" + combo.getId() + "' ";
                }
                where_items = where_items + " and si.status IN(0,5,6,7,8) group by si.description,si.selling_price ";
                List<Srpt_collections_items.field> datas = Srpt_collections_items.ret_data_sales_items(where_items);
                List<Srpt_collections_items.field> datas2 = Srpt_collections_items.ret_data_sales_dr_items(where_items);
                for (Srpt_collections_items.field to : datas) {
                    walkin_items_sold += to.qty;                   
                }
                for (Srpt_collections_items.field to : datas2) {
                    charge_items_sold += to.qty;
                }
                
                total_items_sold = walkin_items_sold + charge_items_sold;
                Srpt_summary rpt = new Srpt_summary(total_gross_sales, walkin_gross_sales, charge_gross_sales, total_items_sold, walkin_items_sold, charge_items_sold, total_vatable_sales, total_non_vatable_sales, total_vat, total_cash_collected, walkin_cash_payment, walkin_check_payment, charge_cash_payment, total_charge_amount, charge_check_payment, total_collectible, total_no_of_transactions, walkin_trans, charge_transactions, business_name, address, date, cashier, printed_by, total_delivery_charge, total_discount, total_check_collected);

                String jrxml = "rpt_summary.jrxml";
                report_summary(rpt, jrxml);
                try {
                    JasperReport jasperReport = null;
                    InputStream is = Srpt_summary.class.getResourceAsStream(jrxml);
                    jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint5 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.emptyDatasource());
                } catch (JRException ex) {
                    Logger.getLogger(Srpt_void_items.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });

        t.start();
    }

    private void report_summary(final Srpt_summary to, String jrxml_name) {
        jPanel16.removeAll();
        jPanel16.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_summary(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel16.add(viewer);
            jPanel16.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_summary(Srpt_summary to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_summary(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_summary(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_summary.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    JasperPrint jasperPrint5 = null;

    private void print5() {
        try {
            JasperPrintManager.printReport(jasperPrint5, true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
//</editor-fold>

}
