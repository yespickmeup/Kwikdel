/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.customers.S1_customers.to_customers;
import POS.util.Focus_Fire;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;

/**
 *
 * @author Maytopacka
 */
public class Dlg_customers extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_location
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

        public final String customer_id;
        public final String customer_name;
        public final String customer_address;
        public final String customer_contact_no;

        public OutputData(String customer_id, String customer_name, String customer_address, String customer_contact_no) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.customer_address = customer_address;
            this.customer_contact_no = customer_contact_no;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_customers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_customers(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_customers() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_customers myRef;

    private void setThisRef(Dlg_customers myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customers> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customers create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.APPLICATION_MODAL);

    }

    public static Dlg_customers create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers((java.awt.Frame) parent, false);
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
            Dlg_customers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers((java.awt.Dialog) parent, false);
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

        Dlg_customers dialog = Dlg_customers.create(new javax.swing.JFrame(), true);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_customers = new org.jdesktop.swingx.JXTable();
        jLabel11 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_contact_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_credit_limit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_term = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_customer_no = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_balance = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_discount = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_location = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tf_address = new javax.swing.JTextArea();
        jButton1 = new Button.Warning();
        jButton2 = new Button.Info();
        jButton3 = new Button.Success();
        jButton4 = new Button.Default();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_mi = new javax.swing.JTextField();
        tf_lname = new javax.swing.JTextField();
        tf_fname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel1.setOpaque(false);

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setOpaque(false);

        tbl_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_customers.setOpaque(false);
        tbl_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_customers);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Search:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("First Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Location:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Contact #:");

        tf_contact_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Credit Limit:");

        tf_credit_limit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_limit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_credit_limit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_credit_limitActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Term:");

        tf_term.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_term.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_term.setNextFocusableComponent(tf_address);
        tf_term.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_termActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Customer Id:");

        tf_customer_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_customer_no.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Address:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Balance:");

        tf_balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_balance.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_balance.setFocusable(false);
        tf_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_balanceActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Discount:");

        tf_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discountActionPerformed(evt);
            }
        });

        tf_location.setColumns(20);
        tf_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_location.setRows(5);
        jScrollPane3.setViewportView(tf_location);

        tf_address.setColumns(20);
        tf_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_address.setRows(5);
        jScrollPane4.setViewportView(tf_address);

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Mi:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Last Name:");

        tf_mi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_customer_no)
                            .addComponent(tf_lname)
                            .addComponent(tf_fname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_mi)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(tf_contact_no)
                            .addComponent(tf_credit_limit)
                            .addComponent(tf_discount)
                            .addComponent(tf_term)
                            .addComponent(tf_balance))))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(tf_customer_no, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_mi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_term, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_balance))
                .addGap(26, 26, 26)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customersMouseClicked
        select_customers();
    }//GEN-LAST:event_tbl_customersMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_termActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_termActionPerformed
        // TODO add your handling code here:
        tf_address.grabFocus();
    }//GEN-LAST:event_tf_termActionPerformed

    private void tf_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discountActionPerformed
    }//GEN-LAST:event_tf_discountActionPerformed

    private void tf_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_balanceActionPerformed
        tf_discount.grabFocus();
    }//GEN-LAST:event_tf_balanceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_customers();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_customers();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_customers();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_customers();
        init_no();
        tf_fname.grabFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_credit_limitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_credit_limitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_credit_limitActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable tbl_customers;
    private javax.swing.JTextArea tf_address;
    private javax.swing.JTextField tf_balance;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_credit_limit;
    private javax.swing.JTextField tf_customer_no;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_fname;
    private javax.swing.JTextField tf_lname;
    private javax.swing.JTextArea tf_location;
    private javax.swing.JTextField tf_mi;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_term;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        tf_search.grabFocus();
        init_key();
        focus();
        init_focus();
        search();
        init();
        init_tbl_customers();

        init_no();
        tf_balance.enable(false);
        tf_fname.grabFocus();
        act();

        jScrollPane3.setVisible(false);
        jLabel3.setVisible(false);
    }

    private void act() {
        tf_discount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                add_customers();
            }
        });
    }

    private void focus() {
        JTextField[] tf = {tf_customer_no, tf_contact_no, tf_credit_limit, tf_term, tf_balance, tf_discount, tf_search, tf_fname, tf_mi, tf_lname};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
        JTextArea[] tf2 = {tf_location, tf_address};
        Focus_Fire.onFocus_lostFocus(tf2);
        Focus_Fire.select_all(tf2);
    }

    private void init_focus() {
    }
    // <editor-fold defaultstate="collapsed" desc="settings">
    int posX = 0, posY = 0;

    private void init() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }

    private void search() {
    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    private void exit2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(153, 153, 153));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    // </editor-fold>

    private void init_no() {
        tf_customer_no.setText(S1_customers.increment_id());
    }

    public void do_pass(final String search) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_search.setText(search);
                tf_search.grabFocus();
                data_cols();
            }
        });

    }

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(), KeyEvent.VK_ESCAPE, new KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disposed();
            }
        });

        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    int row = tbl_customers_ALM.size();
                    if (row > 0) {
                        tf_search.transferFocus();
                        tbl_customers.grabFocus();
                        tbl_customers.setRowSelectionInterval(0, 0);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    tf_search.transferFocus();
                    tf_search.grabFocus();
                }
            }

        });

        tbl_customers.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    ok();
                    e.consume();
                }
            }

        });
    }
    // </editor-fold>
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
        int[] tbl_widths_customers = {100, 100, 150, 100, 0, 0, 80};
        for (int i = 0, n = tbl_widths_customers.length; i < n; i++) {
            if (i == 1 || i == 2) {
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
        tbl_customers.setRowHeight(25);
        tbl_customers.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_customers, 4);
    }

    private void loadData_customers(List<to_customers> acc) {
        tbl_customers_ALM.clear();
        tbl_customers_ALM.addAll(acc);
    }

    public static class TblcustomersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "ID #", "Name", "Address", "Contact No", "Credit Limit", "Term", "Balance"
        };

        public TblcustomersModel(ListModel listmodel) {
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
            to_customers tt = (to_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.customer_no;
                case 1:
                    return " " + tt.first_name + " " + tt.mi + " " + tt.last_name;
                case 2:
                    return " " + tt.address;
                case 3:
                    return " " + tt.contact_no;
                case 4:
                    return FitIn.fmt_wc_0(tt.credit_limit) + " ";
                case 5:
                    return FitIn.fmt_woc(tt.term) + " ";
                default:
                    return FitIn.fmt_wc_0(tt.balance) + " ";
            }
        }
    }

    private void data_cols() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where last_name like '%" + tf_search.getText() + "%' or first_name like '%" + tf_search.getText() + "%' order by last_name asc";
                loadData_customers(S1_customers.ret_data2(where));
            }
        });
        t.start();
    }
 private void data_cols2(final String search) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where last_name like '%" + search + "%' or first_name like '%" + search + "%' order by last_name asc";
                loadData_customers(S1_customers.ret_data2(where));
            }
        });
        t.start();
    }
    private void add_customers() {
        int id = -1;
        String customer_name = "";
        String customer_no = S1_customers.increment_id();
        String contact_no = tf_contact_no.getText();
        double credit_limit = FitIn.toDouble(tf_credit_limit.getText());
        String address = tf_address.getText();
        double term = FitIn.toDouble(tf_term.getText());
        String location = tf_location.getText();
        double balance = 0;
        double discount = FitIn.toDouble(tf_discount.getText());
        String account = customer_no;
        String first_name = tf_fname.getText();
        String last_name = tf_lname.getText();
        String mi = tf_mi.getText();
        double deposit=0;
        to_customers to = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi,deposit);
        S1_customers.add_customers(to);
        data_cols();
        clear_customers();
        init_no();
    }

    private void select_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        tf_fname.setText(to.first_name);
        tf_lname.setText(to.last_name);
        tf_mi.setText(to.mi);
        tf_customer_no.setText(to.customer_no);
        tf_contact_no.setText(to.contact_no);
        tf_credit_limit.setText(FitIn.fmt_wc_0(to.credit_limit));
        tf_location.setText(to.location);
        tf_term.setText(FitIn.fmt_woc(to.term));
        tf_address.setText(to.address);

    }

    private void edit_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        int id = to.id;
        String customer_name = "";
        String customer_no = tf_customer_no.getText();
        String contact_no = tf_contact_no.getText();
        double credit_limit = FitIn.toDouble(tf_credit_limit.getText());
        String address = tf_address.getText();
        double term = FitIn.toDouble(tf_term.getText());
        String location = tf_location.getText();
        double balance = 0;
        double discount = FitIn.toDouble(tf_discount.getText());
        String account = customer_no;
        String first_name = tf_fname.getText();
        String last_name = tf_lname.getText();
        String mi = tf_mi.getText();
        double deposit=to.deposit;
        to_customers to1 = new to_customers(id, customer_name, customer_no, contact_no, credit_limit, address, term, location, balance, discount, account, first_name, last_name, mi,deposit);
        S1_customers.edit_customers(to1);
        data_cols();
        clear_customers();
    }

    private void clear_customers() {
        tf_fname.setText("");
        tf_lname.setText("");
        tf_mi.setText("");
        tf_customer_no.setText("");
        tf_contact_no.setText("");
        tf_credit_limit.setText("");
        tf_location.setText("");
        tf_term.setText("");
        tf_address.setText("");
    }

    private void delete_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        S1_customers.delete_customers(to);
        data_cols();
        clear_customers();
        init_no();
    }

    private void ok() {

        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.convertRowIndexToModel(row));
        String customer_id = "" + to.id;
        String customer_name = to.first_name + " " + to.mi + " " + to.last_name;
        String customer_address = to.address;
        String customer_contact_no = to.contact_no;

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(customer_id, customer_name, customer_address, customer_contact_no));
        }
    }
}
