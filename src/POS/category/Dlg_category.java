/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category;

import POS.category.S1_inv_categories.to_inv_categories;
import POS.category.S1_inv_classifications.to_inv_classifications;
import POS.category.S1_inv_sub_classifications.to_inv_sub_classifications;
import POS.main.Main;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.SearchField;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_category extends javax.swing.JDialog {

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
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_category(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_category(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_category() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_category myRef;

    private void setThisRef(Dlg_category myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_category> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_category create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_category create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_category dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_category((java.awt.Frame) parent, false);
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
            Dlg_category dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_category((java.awt.Dialog) parent, false);
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


        Dlg_category dialog = Dlg_category.create(new javax.swing.JFrame(), true);
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
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_category = new javax.swing.JTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        tf_search = new SearchField();
        btn_new = new org.jdesktop.swingx.JXLabel();
        btn_edit = new org.jdesktop.swingx.JXLabel();
        btn_delete = new org.jdesktop.swingx.JXLabel();
        btn_add = new org.jdesktop.swingx.JXLabel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_inv_categories = new org.jdesktop.swingx.JXTable();
        jPanel6 = new javax.swing.JPanel();
        jXPanel10 = new org.jdesktop.swingx.JXPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_classification = new javax.swing.JTextField();
        jXPanel11 = new org.jdesktop.swingx.JXPanel();
        tf_search3 = new SearchField();
        btn_new3 = new org.jdesktop.swingx.JXLabel();
        btn_edit3 = new org.jdesktop.swingx.JXLabel();
        btn_delete3 = new org.jdesktop.swingx.JXLabel();
        btn_add3 = new org.jdesktop.swingx.JXLabel();
        jXPanel12 = new org.jdesktop.swingx.JXPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_inv_classifications = new org.jdesktop.swingx.JXTable();
        jPanel7 = new javax.swing.JPanel();
        jXPanel13 = new org.jdesktop.swingx.JXPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_sub_classification = new javax.swing.JTextField();
        jXPanel14 = new org.jdesktop.swingx.JXPanel();
        tf_search4 = new SearchField();
        btn_new4 = new org.jdesktop.swingx.JXLabel();
        btn_edit4 = new org.jdesktop.swingx.JXLabel();
        btn_delete4 = new org.jdesktop.swingx.JXLabel();
        btn_add4 = new org.jdesktop.swingx.JXLabel();
        jXPanel15 = new org.jdesktop.swingx.JXPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_inv_sub_classifications = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATEGORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setOpaque(false);

        jXPanel2.setBackground(new java.awt.Color(240, 237, 223));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("NAME:");

        tf_category.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_category.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_category)
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_category)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel1.setBackground(new java.awt.Color(240, 237, 223));

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_reload.png"))); // NOI18N
        btn_new.setText("NEW");
        btn_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_newMouseClicked(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_edit.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_drop.png"))); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new.png"))); // NOI18N
        btn_add.setText("ADD");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel3.setBackground(new java.awt.Color(240, 237, 223));

        jScrollPane2.setOpaque(false);

        tbl_inv_categories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_inv_categories.setOpaque(false);
        tbl_inv_categories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inv_categoriesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_inv_categories);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLASSIFICATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel6.setOpaque(false);

        jXPanel10.setBackground(new java.awt.Color(240, 237, 223));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("NAME:");

        tf_classification.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_classification.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jXPanel10Layout = new javax.swing.GroupLayout(jXPanel10);
        jXPanel10.setLayout(jXPanel10Layout);
        jXPanel10Layout.setHorizontalGroup(
            jXPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_classification)
                .addContainerGap())
        );
        jXPanel10Layout.setVerticalGroup(
            jXPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_classification)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel11.setBackground(new java.awt.Color(240, 237, 223));

        tf_search3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search3KeyReleased(evt);
            }
        });

        btn_new3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_reload.png"))); // NOI18N
        btn_new3.setText("NEW");
        btn_new3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_new3MouseClicked(evt);
            }
        });

        btn_edit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_edit.png"))); // NOI18N
        btn_edit3.setText("EDIT");
        btn_edit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit3MouseClicked(evt);
            }
        });

        btn_delete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_drop.png"))); // NOI18N
        btn_delete3.setText("DELETE");
        btn_delete3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete3MouseClicked(evt);
            }
        });

        btn_add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new.png"))); // NOI18N
        btn_add3.setText("ADD");
        btn_add3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jXPanel11Layout = new javax.swing.GroupLayout(jXPanel11);
        jXPanel11.setLayout(jXPanel11Layout);
        jXPanel11Layout.setHorizontalGroup(
            jXPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_search3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_new3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel11Layout.setVerticalGroup(
            jXPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search3)
                    .addComponent(btn_new3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel12.setBackground(new java.awt.Color(240, 237, 223));

        jScrollPane5.setOpaque(false);

        tbl_inv_classifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_inv_classifications.setOpaque(false);
        tbl_inv_classifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inv_classificationsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_inv_classifications);

        javax.swing.GroupLayout jXPanel12Layout = new javax.swing.GroupLayout(jXPanel12);
        jXPanel12.setLayout(jXPanel12Layout);
        jXPanel12Layout.setHorizontalGroup(
            jXPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel12Layout.setVerticalGroup(
            jXPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SUB CLASSIFICATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel7.setOpaque(false);

        jXPanel13.setBackground(new java.awt.Color(240, 237, 223));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("NAME:");

        tf_sub_classification.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_sub_classification.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jXPanel13Layout = new javax.swing.GroupLayout(jXPanel13);
        jXPanel13.setLayout(jXPanel13Layout);
        jXPanel13Layout.setHorizontalGroup(
            jXPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_sub_classification)
                .addContainerGap())
        );
        jXPanel13Layout.setVerticalGroup(
            jXPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_sub_classification)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel14.setBackground(new java.awt.Color(240, 237, 223));

        tf_search4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search4KeyReleased(evt);
            }
        });

        btn_new4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_reload.png"))); // NOI18N
        btn_new4.setText("NEW");
        btn_new4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_new4MouseClicked(evt);
            }
        });

        btn_edit4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_edit.png"))); // NOI18N
        btn_edit4.setText("EDIT");
        btn_edit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit4MouseClicked(evt);
            }
        });

        btn_delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_drop.png"))); // NOI18N
        btn_delete4.setText("DELETE");
        btn_delete4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete4MouseClicked(evt);
            }
        });

        btn_add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new.png"))); // NOI18N
        btn_add4.setText("ADD");
        btn_add4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jXPanel14Layout = new javax.swing.GroupLayout(jXPanel14);
        jXPanel14.setLayout(jXPanel14Layout);
        jXPanel14Layout.setHorizontalGroup(
            jXPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_search4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_new4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel14Layout.setVerticalGroup(
            jXPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search4)
                    .addComponent(btn_new4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel15.setBackground(new java.awt.Color(240, 237, 223));

        jScrollPane6.setOpaque(false);

        tbl_inv_sub_classifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_inv_sub_classifications.setOpaque(false);
        tbl_inv_sub_classifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inv_sub_classificationsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_inv_sub_classifications);

        javax.swing.GroupLayout jXPanel15Layout = new javax.swing.GroupLayout(jXPanel15);
        jXPanel15.setLayout(jXPanel15Layout);
        jXPanel15Layout.setHorizontalGroup(
            jXPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel15Layout.setVerticalGroup(
            jXPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols_category();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        add_inv_categories();
    }//GEN-LAST:event_btn_addMouseClicked

    private void tbl_inv_categoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inv_categoriesMouseClicked
        select_inv_categories();
    }//GEN-LAST:event_tbl_inv_categoriesMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        edit_inv_categories();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        delete_inv_categories();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newMouseClicked
        clear_inv_categories();
    }//GEN-LAST:event_btn_newMouseClicked

    private void tf_search3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search3KeyReleased
        data_cols_classifications();
    }//GEN-LAST:event_tf_search3KeyReleased

    private void btn_add3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add3MouseClicked
        add_inv_classifications();
    }//GEN-LAST:event_btn_add3MouseClicked

    private void tbl_inv_classificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inv_classificationsMouseClicked
        select_inv_classifications();
    }//GEN-LAST:event_tbl_inv_classificationsMouseClicked

    private void btn_edit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit3MouseClicked
        edit_inv_classifications();
    }//GEN-LAST:event_btn_edit3MouseClicked

    private void btn_delete3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete3MouseClicked
        delete_inv_classifications();
    }//GEN-LAST:event_btn_delete3MouseClicked

    private void btn_new3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new3MouseClicked
        clear_inv_classifications();
    }//GEN-LAST:event_btn_new3MouseClicked

    private void tf_search4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search4KeyReleased
        data_cols_sub();
    }//GEN-LAST:event_tf_search4KeyReleased

    private void btn_delete4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete4MouseClicked
        delete_inv_sub_classifications();
    }//GEN-LAST:event_btn_delete4MouseClicked

    private void btn_edit4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit4MouseClicked
        edit_inv_sub_classifications();
    }//GEN-LAST:event_btn_edit4MouseClicked

    private void btn_new4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_new4MouseClicked
        clear_inv_sub_classifications();
    }//GEN-LAST:event_btn_new4MouseClicked

    private void tbl_inv_sub_classificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inv_sub_classificationsMouseClicked
        select_inv_sub_classifications();
    }//GEN-LAST:event_tbl_inv_sub_classificationsMouseClicked

    private void btn_add4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add4MouseClicked
        add_inv_sub_classifications();
    }//GEN-LAST:event_btn_add4MouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel btn_add;
    private org.jdesktop.swingx.JXLabel btn_add3;
    private org.jdesktop.swingx.JXLabel btn_add4;
    private org.jdesktop.swingx.JXLabel btn_delete;
    private org.jdesktop.swingx.JXLabel btn_delete3;
    private org.jdesktop.swingx.JXLabel btn_delete4;
    private org.jdesktop.swingx.JXLabel btn_edit;
    private org.jdesktop.swingx.JXLabel btn_edit3;
    private org.jdesktop.swingx.JXLabel btn_edit4;
    private org.jdesktop.swingx.JXLabel btn_new;
    private org.jdesktop.swingx.JXLabel btn_new3;
    private org.jdesktop.swingx.JXLabel btn_new4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel10;
    private org.jdesktop.swingx.JXPanel jXPanel11;
    private org.jdesktop.swingx.JXPanel jXPanel12;
    private org.jdesktop.swingx.JXPanel jXPanel13;
    private org.jdesktop.swingx.JXPanel jXPanel14;
    private org.jdesktop.swingx.JXPanel jXPanel15;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable tbl_inv_categories;
    private org.jdesktop.swingx.JXTable tbl_inv_classifications;
    private org.jdesktop.swingx.JXTable tbl_inv_sub_classifications;
    private javax.swing.JTextField tf_category;
    private javax.swing.JTextField tf_classification;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_search3;
    private javax.swing.JTextField tf_search4;
    private javax.swing.JTextField tf_sub_classification;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        tf_search.grabFocus();
        init_key();
        hover();
        search();
        init();

        init_tbl_inv_categories();
        data_cols_category();

        init_tbl_inv_classifications();
        init_tbl_inv_sub_classifications();
    }
    // <editor-fold defaultstate="collapsed" desc="settings">

    private void hover() {
        btn_edit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_edit.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_edit.png")));
            }
        });
        btn_delete.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_drop.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_drop.png")));
            }
        });
        btn_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_snewtbl.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_new.png")));
            }
        });
        btn_new.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/s_reload.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_reload.png")));
            }
        });

        btn_edit3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_edit3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_edit.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_edit3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_edit.png")));
            }
        });
        btn_delete3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_delete3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_drop.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_delete3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_drop.png")));
            }
        });
        btn_add3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_add3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_snewtbl.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_add3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_new.png")));
            }
        });
        btn_new3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_new3.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/s_reload.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_reload.png")));
            }
        });

        btn_edit4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_edit4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_edit.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_edit4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_edit.png")));
            }
        });
        btn_delete4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_delete4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_drop.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_delete4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_drop.png")));
            }
        });
        btn_add4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_add4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_snewtbl.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_add4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_new.png")));
            }
        });
        btn_new4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_new4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/s_reload.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_new4.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_reload.png")));
            }
        });


    }
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
        SearchField sf = (SearchField) tf_search;
        sf.setFont(new java.awt.Font("Tahoma", 0, 10));
        sf.set_instruction1("Type To Search");
        sf.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                // your search list here coming from svc for example.

                return new ArrayList();

            }
        });

        sf.setCallbackDisplay(new SearchField.CallbackDisplay() {

            @Override
            public void display(Object o) {
            }
        });
        sf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });
        SearchField sf2 = (SearchField) tf_search3;
        sf2.setFont(new java.awt.Font("Tahoma", 0, 10));
        sf2.set_instruction1("Type To Search");
        sf2.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                // your search list here coming from svc for example.

                return new ArrayList();

            }
        });

        sf2.setCallbackDisplay(new SearchField.CallbackDisplay() {

            @Override
            public void display(Object o) {
            }
        });
        sf2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });
        SearchField sf3 = (SearchField) tf_search4;
        sf3.setFont(new java.awt.Font("Tahoma", 0, 10));
        sf3.set_instruction1("Type To Search");
        sf3.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                // your search list here coming from svc for example.

                return new ArrayList();

            }
        });

        sf3.setCallbackDisplay(new SearchField.CallbackDisplay() {

            @Override
            public void display(Object o) {
            }
        });
        sf3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });
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
    private ArrayListModel tbl_inv_categories_ALM;
    private Tblinv_categoriesModel tbl_inv_categories_M;

    private void init_tbl_inv_categories() {
        tbl_inv_categories_ALM = new ArrayListModel();
        tbl_inv_categories_M = new Tblinv_categoriesModel(tbl_inv_categories_ALM);
        tbl_inv_categories.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inv_categories.setModel(tbl_inv_categories_M);
        tbl_inv_categories.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inv_categories.setRowHeight(25);
        int[] tbl_widths_inv_categories = {0, 100};
        for (int i = 0, n = tbl_widths_inv_categories.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inv_categories, i, tbl_widths_inv_categories[i]);
        }
        Dimension d = tbl_inv_categories.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_inv_categories.getTableHeader().
                setPreferredSize(d);
        tbl_inv_categories.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_inv_categories.setRowHeight(35);
        tbl_inv_categories.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_inv_categories(List<to_inv_categories> acc) {
        tbl_inv_categories_ALM.clear();
        tbl_inv_categories_ALM.addAll(acc);
    }

    public static class Tblinv_categoriesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "NAME"
        };

        public Tblinv_categoriesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            to_inv_categories tt = (to_inv_categories) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                default:
                    return tt.category;
            }
        }
    }

    private void data_cols_category() {
        String search = tf_search.getText();
        loadData_inv_categories(S1_inv_categories.ret_data(search));
    }

    private void add_inv_categories() {
        int id = -1;
        String category = tf_category.getText();
        to_inv_categories to = new to_inv_categories(id, category);
        S1_inv_categories.add_inv_categories(to);
        data_cols_category();
        clear_inv_categories();
    }

    private void select_inv_categories() {
        int row = tbl_inv_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_categories to = (to_inv_categories) tbl_inv_categories_ALM.get(tbl_inv_categories.
                convertRowIndexToModel(row));
        tf_category.setText(to.category);
        data_cols_classifications();
    }

    private void edit_inv_categories() {
        int row = tbl_inv_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_categories to = (to_inv_categories) tbl_inv_categories_ALM.get(tbl_inv_categories.
                convertRowIndexToModel(row));
        int id = to.id;
        String category = tf_category.getText();
        to_inv_categories to1 = new to_inv_categories(id, category);
        S1_inv_categories.edit_inv_categories(to1);
        data_cols_category();
        clear_inv_categories();
    }

    private void clear_inv_categories() {
        tf_category.setText("");
    }

    private void delete_inv_categories() {
        int row = tbl_inv_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_categories to = (to_inv_categories) tbl_inv_categories_ALM.get(tbl_inv_categories.
                convertRowIndexToModel(row));
        S1_inv_categories.delete_inv_categories(to);
        data_cols_category();
        clear_inv_categories();
    }
    private ArrayListModel tbl_inv_classifications_ALM;
    private Tblinv_classificationsModel tbl_inv_classifications_M;

    private void init_tbl_inv_classifications() {
        tbl_inv_classifications_ALM = new ArrayListModel();
        tbl_inv_classifications_M = new Tblinv_classificationsModel(tbl_inv_classifications_ALM);
        tbl_inv_classifications.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inv_classifications.setModel(tbl_inv_classifications_M);
        tbl_inv_classifications.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inv_classifications.setRowHeight(25);
        int[] tbl_widths_inv_classifications = {0, 0, 0, 100};
        for (int i = 0, n = tbl_widths_inv_classifications.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inv_classifications, i, tbl_widths_inv_classifications[i]);
        }
        Dimension d = tbl_inv_classifications.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_inv_classifications.getTableHeader().
                setPreferredSize(d);
        tbl_inv_classifications.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_inv_classifications.setRowHeight(35);
        tbl_inv_classifications.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_inv_classifications(List<to_inv_classifications> acc) {
        tbl_inv_classifications_ALM.clear();
        tbl_inv_classifications_ALM.addAll(acc);
    }

    public static class Tblinv_classificationsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "category_id", "category_name", "NAME"
        };

        public Tblinv_classificationsModel(ListModel listmodel) {
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
            to_inv_classifications tt = (to_inv_classifications) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.category_id;
                case 2:
                    return tt.category_name;
                default:
                    return tt.classification;
            }
        }
    }

    private void data_cols_classifications() {
        String search = tf_search3.getText();
        int row = tbl_inv_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_categories to = (to_inv_categories) tbl_inv_categories_ALM.get(tbl_inv_categories.
                convertRowIndexToModel(row));
        loadData_inv_classifications(S1_inv_classifications.ret_data(search, to.category));
    }

    private void add_inv_classifications() {
        int id = -1;
        int row = tbl_inv_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_categories to = (to_inv_categories) tbl_inv_categories_ALM.get(tbl_inv_categories.
                convertRowIndexToModel(row));
        String category_id = "" + to.id;
        String category_name = to.category;
        String classification = tf_classification.getText();
        to_inv_classifications to2 = new to_inv_classifications(id, category_id, category_name, classification);
        S1_inv_classifications.add_inv_classifications(to2);
        data_cols_classifications();
        clear_inv_classifications();
    }

    private void select_inv_classifications() {
        int row = tbl_inv_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_classifications to = (to_inv_classifications) tbl_inv_classifications_ALM.
                get(tbl_inv_classifications.convertRowIndexToModel(row));
        tf_classification.setText(to.classification);
        data_cols_sub();
    }

    private void edit_inv_classifications() {
        int row = tbl_inv_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_classifications to = (to_inv_classifications) tbl_inv_classifications_ALM.
                get(tbl_inv_classifications.convertRowIndexToModel(row));
        int id = to.id;
        String category_id = "" + to.category_id;
        String category_name = to.category_name;
        String classification = tf_classification.getText();
        to_inv_classifications to1 = new to_inv_classifications(id, category_id, category_name, classification);
        S1_inv_classifications.edit_inv_classifications(to1);
        data_cols_classifications();
        clear_inv_classifications();
    }

    private void clear_inv_classifications() {
        tf_classification.setText("");
    }

    private void delete_inv_classifications() {
        int row = tbl_inv_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_classifications to = (to_inv_classifications) tbl_inv_classifications_ALM.
                get(tbl_inv_classifications.convertRowIndexToModel(row));
        S1_inv_classifications.delete_inv_classifications(to);
        data_cols_classifications();
        clear_inv_classifications();
    }
    private ArrayListModel tbl_inv_sub_classifications_ALM;
    private Tblinv_sub_classificationsModel tbl_inv_sub_classifications_M;

    private void init_tbl_inv_sub_classifications() {
        tbl_inv_sub_classifications_ALM = new ArrayListModel();
        tbl_inv_sub_classifications_M = new Tblinv_sub_classificationsModel(tbl_inv_sub_classifications_ALM);
        tbl_inv_sub_classifications.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_inv_sub_classifications.setModel(tbl_inv_sub_classifications_M);
        tbl_inv_sub_classifications.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inv_sub_classifications.setRowHeight(25);
        int[] tbl_widths_inv_sub_classifications = {0, 0, 0, 0, 0, 100};
        for (int i = 0, n = tbl_widths_inv_sub_classifications.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inv_sub_classifications, i, tbl_widths_inv_sub_classifications[i]);
        }
        Dimension d = tbl_inv_sub_classifications.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_inv_sub_classifications.getTableHeader().
                setPreferredSize(d);
        tbl_inv_sub_classifications.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_inv_sub_classifications.setRowHeight(35);
        tbl_inv_sub_classifications.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_inv_sub_classifications(List<to_inv_sub_classifications> acc) {
        tbl_inv_sub_classifications_ALM.clear();
        tbl_inv_sub_classifications_ALM.addAll(acc);
    }

    public static class Tblinv_sub_classificationsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "category_id", "category_name", "classification_id", "classification_name", "NAME"
        };

        public Tblinv_sub_classificationsModel(ListModel listmodel) {
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
            to_inv_sub_classifications tt = (to_inv_sub_classifications) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.category_id;
                case 2:
                    return tt.category_name;
                case 3:
                    return tt.classification_id;
                case 4:
                    return tt.classification_name;
                default:
                    return tt.sub_classification;
            }
        }
    }

    private void data_cols_sub() {
        String search = tf_search4.getText();
        int row = tbl_inv_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_classifications to = (to_inv_classifications) tbl_inv_classifications_ALM.
                get(tbl_inv_classifications.convertRowIndexToModel(row));
//        System.out.println(to.classification);
        loadData_inv_sub_classifications(S1_inv_sub_classifications.ret_data(search, to.classification));
    }

    private void add_inv_sub_classifications() {
        int id = -1;
        int row = tbl_inv_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_classifications to = (to_inv_classifications) tbl_inv_classifications_ALM.
                get(tbl_inv_classifications.convertRowIndexToModel(row));
        String category_id = "" + to.category_id;
        String category_name = to.category_name;
        String classification_id = "" + to.id;
        String classification_name = to.classification;
        String sub_classification = tf_sub_classification.getText();
        to_inv_sub_classifications to1 = new to_inv_sub_classifications(id, category_id, category_name, classification_id, classification_name, sub_classification);
        S1_inv_sub_classifications.add_inv_sub_classifications(to1);
        data_cols_sub();
        clear_inv_sub_classifications();
    }

    private void select_inv_sub_classifications() {
        int row = tbl_inv_sub_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_sub_classifications to = (to_inv_sub_classifications) tbl_inv_sub_classifications_ALM.
                get(tbl_inv_sub_classifications.convertRowIndexToModel(row));

        tf_sub_classification.setText(to.sub_classification);
    }

    private void edit_inv_sub_classifications() {
        int row = tbl_inv_sub_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_sub_classifications to = (to_inv_sub_classifications) tbl_inv_sub_classifications_ALM.
                get(tbl_inv_sub_classifications.convertRowIndexToModel(row));
        int id = to.id;

        String category_id = "" + to.category_id;
        String category_name = to.category_name;
        String classification_id = "" + to.id;
        String classification_name = to.classification_name;
        String sub_classification = tf_sub_classification.getText();
        to_inv_sub_classifications to1 = new to_inv_sub_classifications(id, category_id, category_name, classification_id, classification_name, sub_classification);
        S1_inv_sub_classifications.edit_inv_sub_classifications(to1);
        data_cols_sub();
        clear_inv_sub_classifications();
    }

    private void clear_inv_sub_classifications() {
        tf_sub_classification.setText("");
    }

    private void delete_inv_sub_classifications() {
        int row = tbl_inv_sub_classifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inv_sub_classifications to = (to_inv_sub_classifications) tbl_inv_sub_classifications_ALM.
                get(tbl_inv_sub_classifications.convertRowIndexToModel(row));
        S1_inv_sub_classifications.delete_inv_sub_classifications(to);
        data_cols_sub();
        clear_inv_sub_classifications();
    }
}
