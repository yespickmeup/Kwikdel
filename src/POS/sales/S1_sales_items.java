/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.items.S1_items;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.MyConnectionInnosoft;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_sales_items {

    public static class to_sales_items {

        public final int id;
        public final String barcode;
        public final String description;
        public String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String session_no;
        public final String item_discount;
        public final double discount;
        public final double discount_amount;
        public final String sales_no;
        public final int fixed_price;
        public final String supplier;
        public final String supplier_id;
        public final int vatable;
        public final String or_no;
        public final String customer_name;
        public final String customer_id;
        public final int metered;
        public final String location_id;
        public final String location_name;

        public to_sales_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String session_no, String item_discount, double discount, double discount_amount, String sales_no, int fixed_price, String supplier, String supplier_id, int vatable, String or_no, String customer_name, String customer_id, int metered, String location_id, String location_name) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.session_no = session_no;
            this.item_discount = item_discount;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.sales_no = sales_no;
            this.fixed_price = fixed_price;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.vatable = vatable;
            this.or_no = or_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.metered = metered;
            this.location_id = location_id;
            this.location_name = location_name;

        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public String getGeneric_name() {
            return generic_name;
        }

        public void setGeneric_name(String generic_name) {
            this.generic_name = generic_name;
        }

    }

    public static String add_sales_items(List<to_sales_items> to_sales_items1, String id, double check_amount, String check_bank, String check_no, S1_sales.to_sales to_sales, String bank) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String sales_no = S1_sales.increment_id();

            String s5 = "update sales_dr set "
                    + " check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",check_amount= :check_amount"
                    + ",charge_status= :charge_status"
                    + ",date_added= :date_added"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";

            s5 = SqlStringUtil.parse(s5)
                    .setString("check_bank", check_bank)
                    .setString("check_no", check_no)
                    .setNumber("check_amount", check_amount)
                    .setNumber("charge_status", 1)
                    .setString("date_added", DateType.datetime.format(new Date()))
                    .ok();

            Lg.s(S1_sales.class, "Successfully Updated");

            PreparedStatement stmt1 = conn.prepareStatement("");
            stmt1.addBatch(s5);

            for (to_sales_items to_sales_items : to_sales_items1) {
                String s0 = "insert into sales_items("
                        + "barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",session_no"
                        + ",item_discount"
                        + ",discount"
                        + ",discount_amount"
                        + ",sales_no"
                        + ",fixed_price"
                        + ",supplier"
                        + ",supplier_id"
                        + ",vatable"
                        + ",or_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",metered"
                        + ",location_id"
                        + ",location_name"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:session_no"
                        + ",:item_discount"
                        + ",:discount"
                        + ",:discount_amount"
                        + ",:sales_no"
                        + ",:fixed_price"
                        + ",:supplier"
                        + ",:supplier_id"
                        + ",:vatable"
                        + ",:or_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:metered"
                        + ",:location_id"
                        + ",:location_name"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("barcode", to_sales_items.barcode).
                        setString("description", to_sales_items.description).
                        setString("generic_name", to_sales_items.generic_name).
                        setString("category", to_sales_items.category).
                        setString("category_id", to_sales_items.category_id).
                        setString("classification", to_sales_items.classification).
                        setString("classification_id", to_sales_items.classification_id).
                        setString("sub_classification", to_sales_items.sub_classification).
                        setString("sub_classification_id", to_sales_items.sub_classification_id).
                        setNumber("product_qty", to_sales_items.product_qty).
                        setString("unit", to_sales_items.unit).
                        setNumber("conversion", to_sales_items.conversion).
                        setNumber("selling_price", to_sales_items.selling_price).
                        setString("date_added", DateType.now()).
                        setString("user_name", to_sales_items.user_name).
                        setString("item_type", to_sales_items.item_type).
                        setNumber("status", to_sales_items.status).
                        setString("session_no", to_sales_items.session_no).
                        setString("item_discount", to_sales_items.item_discount).
                        setNumber("discount", to_sales_items.discount).
                        setNumber("discount_amount", to_sales_items.discount_amount).
                        setString("sales_no", sales_no).
                        setNumber("fixed_price", to_sales_items.fixed_price).
                        setString("supplier", to_sales_items.supplier).
                        setString("supplier_id", to_sales_items.supplier_id).
                        setNumber("vatable", to_sales_items.vatable).
                        setString("or_no", to_sales_items.or_no).
                        setString("customer_name", to_sales_items.customer_name).
                        setString("customer_id", to_sales_items.customer_id).
                        setNumber("metered", to_sales_items.metered).
                        setString("location_id", to_sales_items.location_id).
                        setString("location_name", to_sales_items.location_name).
                        ok();

                stmt1.addBatch(s0);
                Lg.s(S1_sales_items.class, "Successfully Added");

                if (to_sales_items.fixed_price == 1) {
                    S1_items.to_items tt = S1_items.ret_data2(to_sales_items.barcode, to_sales_items.location_id);
                    System.out.println("Barcode: " + to_sales_items.barcode);
                    System.out.println("Location: " + to_sales_items.location_id);
                    System.out.println(tt.product_qty + " - " + to_sales_items.conversion + " * " + to_sales_items.product_qty);
                    double new_qty = tt.product_qty - (to_sales_items.conversion * to_sales_items.product_qty);
                    String s2 = "update items set "
                            + "product_qty='" + new_qty + "' "
                            + " where barcode = '" + to_sales_items.barcode + "' and location_id='" + to_sales_items.location_id + "' "
                            + "";
                    stmt1.addBatch(s2);
                }

                if (to_sales_items.fixed_price == 0) {
                    S1_items.to_items tt = S1_items.ret_data2(to_sales_items.barcode, to_sales_items.location_id);
                    double new_qty = tt.product_qty - (to_sales_items.product_qty);
                    String s2 = "update items set "
                            + "product_qty='" + new_qty + "' "
                            + " where barcode = '" + to_sales_items.barcode + "' and location_id='" + to_sales_items.location_id + "' "
                            + "";
                    stmt1.addBatch(s2);
                }

            }

            String s6 = "insert into sales("
                    + "sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",transaction_type"
                    + ",transaction_type_id"
                    + ",payment_type"
                    + ",payment_type_id"
                    + ",vehicle_name"
                    + ",vehicle_id"
                    + ",driver_name"
                    + ",driver_id"
                    + ",customer_address"
                    + ",customer_contact_no"
                    + ",charge_status"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:gross_amount"
                    + ",:amount_paid"
                    + ",:amount_due"
                    + ",:discount_name"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:customer_name"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:status"
                    + ",:or_no"
                    + ",:check_holder"
                    + ",:services"
                    + ",:service_amount"
                    + ",:customer_id"
                    + ",:transaction_type"
                    + ",:transaction_type_id"
                    + ",:payment_type"
                    + ",:payment_type_id"
                    + ",:vehicle_name"
                    + ",:vehicle_id"
                    + ",:driver_name"
                    + ",:driver_id"
                    + ",:customer_address"
                    + ",:customer_contact_no"
                    + ",:charge_status"
                    + ")";

            s6 = SqlStringUtil.parse(s6)
                    .setString("sales_no", sales_no)
                    .setString("date_added", DateType.now())
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.or_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", bank)
                    .setString("check_no", check_no)
                    .setNumber("check_amount", check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", sales_no)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("services", to_sales.services)
                    .setNumber("service_amount", to_sales.service_amount)
                    .setString("customer_id", to_sales.customer_id)
                    .setString("transaction_type", to_sales.transaction_type)
                    .setString("transaction_type_id", to_sales.transaction_type_id)
                    .setString("payment_type", to_sales.payment_type)
                    .setString("payment_type_id", to_sales.payment_type_id)
                    .setString("vehicle_name", to_sales.vehicle_name)
                    .setString("vehicle_id", to_sales.vehicle_id)
                    .setString("driver_name", to_sales.driver_name)
                    .setString("driver_id", to_sales.driver_id)
                    .setString("customer_address", to_sales.customer_address)
                    .setString("customer_contact_no", to_sales.customer_contact_no)
                    .setNumber("charge_status", 1)
                    .ok();

            stmt1.addBatch(s6);

            stmt1.executeBatch();
            conn.commit();
            Lg.s(S1_sales_items.class, "Successfully Added");

            String send_sales_to_innosoft = System.getProperty("send_sales_to_innosoft", "false");
            System.out.println("Send to Innosoft: " + send_sales_to_innosoft);
            if (send_sales_to_innosoft.equalsIgnoreCase("true")) {
                int connected = MyConnectionInnosoft.check_connection();

                if (connected == 1) {
                    try {
                        Connection conn2 = MyConnectionInnosoft.connect();

                        for (S1_sales_items.to_sales_items items : to_sales_items1) {

                            int id1 = 0;
                            String s7 = "select id from dbo.MstItem  where ItemCode = '" + items.barcode + "' ";
                            Statement stmt7 = conn2.createStatement();
                            ResultSet rs7 = stmt7.executeQuery(s7);
                            if (rs7.next()) {
                                id1 = rs7.getInt(1);
                            }

                            String s16 = " insert into dbo.TrnSalesDraft ("
                                    + "DocRef"
                                    + ",DocDate"
                                    + ",ItemCode"
                                    + ",ItemId"
                                    + ",Price"
                                    + ",Quantity"
                                    + ",Amount"
                                    + ",CustomerCode"
                                    + ",Customer"
                                    + ",ContactPerson"
                                    + ",Address"
                                    + ",PhoneNumber"
                                    + ",MobilePhoneNumber"
                                    + ")values("
                                    + " :DocRef"
                                    + ",:DocDate"
                                    + ",:ItemCode"
                                    + ",:ItemId"
                                    + ",:Price"
                                    + ",:Quantity"
                                    + ",:Amount"
                                    + ",:CustomerCode"
                                    + ",:Customer"
                                    + ",:ContactPerson"
                                    + ",:Address"
                                    + ",:PhoneNumber"
                                    + ",:MobilePhoneNumber"
                                    + ")";

                            s16 = SqlStringUtil.parse(s16).
                                    setString("DocRef", sales_no).
                                    setString("DocDate", synsoftech.util.DateType.datetime2.format(new Date())).
                                    setString("ItemCode", items.barcode).
                                    setNumber("ItemId", id1).
                                    setNumber("Price", items.selling_price).
                                    setNumber("Quantity", items.product_qty).
                                    setNumber("Amount", (items.selling_price * items.product_qty)).
                                    setString("CustomerCode", to_sales.customer_id).
                                    setString("Customer", to_sales.customer_name).
                                    setString("ContactPerson", to_sales.customer_name).
                                    setString("Address", to_sales.customer_address).
                                    setString("PhoneNumber", to_sales.customer_contact_no).
                                    setString("MobilePhoneNumber", "").
                                    ok();
                            PreparedStatement stmt16 = conn2.prepareStatement(s16);
                            stmt16.execute();

                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        MyConnection.close();
                    }

                }

            }
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection strSel = new StringSelection(sales_no);
            clipboard.setContents(strSel, null);
            String result = "";

            try {
                result = (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
            } catch (IOException e) {
            }
            return sales_no;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sales_items(to_sales_items to_sales_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_items set "
                    + "barcode= '" + to_sales_items.barcode + "'"
                    + ",description= '" + to_sales_items.description + "'"
                    + ",generic_name= '" + to_sales_items.generic_name + "'"
                    + ",category= '" + to_sales_items.category + "'"
                    + ",category_id= '" + to_sales_items.category_id + "'"
                    + ",classification= '" + to_sales_items.classification + "'"
                    + ",classification_id= '" + to_sales_items.classification_id + "'"
                    + ",sub_classification= '" + to_sales_items.sub_classification + "'"
                    + ",sub_classification_id= '" + to_sales_items.sub_classification_id + "'"
                    + ",product_qty= '" + to_sales_items.product_qty + "'"
                    + ",unit= '" + to_sales_items.unit + "'"
                    + ",conversion= '" + to_sales_items.conversion + "'"
                    + ",selling_price= '" + to_sales_items.selling_price + "'"
                    + ",date_added= '" + to_sales_items.date_added + "'"
                    + ",user_name= '" + to_sales_items.user_name + "'"
                    + ",item_type= '" + to_sales_items.item_type + "'"
                    + ",status= '" + to_sales_items.status + "'"
                    + ",session_no= '" + to_sales_items.session_no + "'"
                    + ",item_discount= '" + to_sales_items.item_discount + "'"
                    + ",discount= '" + to_sales_items.discount + "'"
                    + ",discount_amount= '" + to_sales_items.discount_amount + "'"
                    + ",sales_no= '" + to_sales_items.sales_no + "'"
                    + ",fixed_price= '" + to_sales_items.fixed_price + "'"
                    + ",supplier= '" + to_sales_items.supplier + "'"
                    + ",supplier_id= '" + to_sales_items.supplier_id + "'"
                    + ",vatable= '" + to_sales_items.vatable + "'"
                    + ",customer_name= '" + to_sales_items.customer_name + "'"
                    + ",customer_id= '" + to_sales_items.customer_id + "'"
                    + ",metered= '" + to_sales_items.metered + "'"
                    + "where "
                    + " id ='" + to_sales_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_items.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales_items(to_sales_items to_sales_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales_items where "
                    + " id ='" + to_sales_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data(String search) {
        List<to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",metered"
                    + ",location_id"
                    + ",location_name"
                    + " from sales_items where "
                    + " sales_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, metered, location_id, location_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data_dr_items(String search) {
        List<to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",metered"
                    + ",location_id"
                    + ",location_name"
                    + " from sales_dr_items where "
                    + " sales_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, metered, location_id, location_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data3(String where) {
        List<to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",metered"
                    + ",location_id"
                    + ",location_name"
                    + " from sales_items  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, metered, location_id, location_name);
                if (customer_name != null) {
                    datas.add(to);
                }

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data2(String date_from, String date_to) {
        List<to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",sum(product_qty)"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",metered"
                    + ",location_id"
                    + ",location_name"
                    + " from sales_items where "
                    + " date(date_added)  between '" + date_from + "' and '" + date_to + "' group by description,selling_price "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                int metered = rs.getInt(31);
                String location_id = rs.getString(32);
                String location_name = rs.getString(33);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, metered, location_id, location_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
