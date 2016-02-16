/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_sales;

import POS.items.S1_items;
import POS.sales.S1_sales;
import POS.sales.S1_sales_items;
import POS.sales_dr.S1_sales_dr;
import POS.services.S1_sales_services;
import POS.services.S1_sales_services.to_sales_services;
import static POS.util.DateType.datetime;
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
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class MySales {

    public static String add_sales_dr(S1_sales.to_sales to_sales_dr, List<S1_sales_items.to_sales_items> to_sales_dr_items1, List<S1_sales_services.to_sales_services> to_sales_services1) {

        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String sa = S1_sales_dr.increment_id();
            String s1 = "insert into sales_dr("
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
            s1 = SqlStringUtil.parse(s1)
                    .setString("sales_no", sa)
                    .setString("date_added", to_sales_dr.date_added)
                    .setString("user_name", to_sales_dr.user_name)
                    .setString("session_no", to_sales_dr.session_no)
                    .setNumber("gross_amount", to_sales_dr.gross_amount)
                    .setNumber("amount_paid", to_sales_dr.amount_paid)
                    .setNumber("amount_due", to_sales_dr.amount_due)
                    .setString("discount_name", to_sales_dr.discount_name)
                    .setNumber("discount", to_sales_dr.discount)
                    .setNumber("discount_amount", to_sales_dr.discount_amount)
                    .setString("customer_name", to_sales_dr.customer_name)
                    .setString("check_bank", to_sales_dr.check_bank)
                    .setString("check_no", to_sales_dr.check_no)
                    .setNumber("check_amount", to_sales_dr.check_amount)
                    .setString("discount_customer_name", to_sales_dr.discount_customer_name)
                    .setString("discount_customer_id", to_sales_dr.discount_customer_id)
                    .setNumber("status", to_sales_dr.status)
                    .setString("or_no", sa)
                    .setString("check_holder", to_sales_dr.check_holder)
                    .setString("services", to_sales_dr.services)
                    .setNumber("service_amount", to_sales_dr.service_amount)
                    .setString("customer_id", to_sales_dr.customer_id)
                    .setString("transaction_type", to_sales_dr.transaction_type)
                    .setString("transaction_type_id", to_sales_dr.transaction_type_id)
                    .setString("payment_type", to_sales_dr.payment_type)
                    .setString("payment_type_id", to_sales_dr.payment_type_id)
                    .setString("vehicle_name", to_sales_dr.vehicle_name)
                    .setString("vehicle_id", to_sales_dr.vehicle_id)
                    .setString("driver_name", to_sales_dr.driver_name)
                    .setString("driver_id", to_sales_dr.driver_id)
                    .setString("customer_address", to_sales_dr.customer_address)
                    .setString("customer_contact_no", to_sales_dr.customer_contact_no)
                    .setNumber("charge_status", to_sales_dr.charge_status)
                    .ok();

            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.addBatch(s1);

            for (S1_sales_items.to_sales_items to_sales_dr_items : to_sales_dr_items1) {
                String s2 = "insert into sales_dr_items("
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

                s2 = SqlStringUtil.parse(s2)
                        .setString("barcode", to_sales_dr_items.barcode)
                        .setString("description", to_sales_dr_items.description)
                        .setString("generic_name", to_sales_dr_items.generic_name)
                        .setString("category", to_sales_dr_items.category)
                        .setString("category_id", to_sales_dr_items.category_id)
                        .setString("classification", to_sales_dr_items.classification)
                        .setString("classification_id", to_sales_dr_items.classification_id)
                        .setString("sub_classification", to_sales_dr_items.sub_classification)
                        .setString("sub_classification_id", to_sales_dr_items.sub_classification_id)
                        .setNumber("product_qty", to_sales_dr_items.product_qty)
                        .setString("unit", to_sales_dr_items.unit)
                        .setNumber("conversion", to_sales_dr_items.conversion)
                        .setNumber("selling_price", to_sales_dr_items.selling_price)
                        .setString("date_added", to_sales_dr_items.date_added)
                        .setString("user_name", to_sales_dr_items.user_name)
                        .setString("item_type", to_sales_dr_items.item_type)
                        .setNumber("status", to_sales_dr_items.status)
                        .setString("session_no", to_sales_dr_items.session_no)
                        .setString("item_discount", to_sales_dr_items.item_discount)
                        .setNumber("discount", to_sales_dr_items.discount)
                        .setNumber("discount_amount", to_sales_dr_items.discount_amount)
                        .setString("sales_no", sa)
                        .setNumber("fixed_price", to_sales_dr_items.fixed_price)
                        .setString("supplier", to_sales_dr_items.supplier)
                        .setString("supplier_id", to_sales_dr_items.supplier_id)
                        .setNumber("vatable", to_sales_dr_items.vatable)
                        .setString("or_no", to_sales_dr_items.or_no)
                        .setString("customer_name", to_sales_dr_items.customer_name)
                        .setString("customer_id", to_sales_dr_items.customer_id)
                        .setNumber("metered", to_sales_dr_items.metered)
                        .setString("location_id", to_sales_dr_items.location_id)
                        .setString("location_name", to_sales_dr_items.location_name)
                        .ok();

                stmt1.addBatch(s2);
            }

            for (S1_sales_services.to_sales_services to_sales_dr_services : to_sales_services1) {
                String s3 = "insert into sales_dr_services("
                        + "or_no"
                        + ",service_name"
                        + ",service_amount"
                        + ",date_added"
                        + ",user_name"
                        + ",status"
                        + ")values("
                        + ":or_no"
                        + ",:service_name"
                        + ",:service_amount"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:status"
                        + ")";

                s3 = SqlStringUtil.parse(s3)
                        .setString("or_no", to_sales_dr_services.or_no)
                        .setString("service_name", to_sales_dr_services.service_name)
                        .setNumber("service_amount", to_sales_dr_services.service_amount)
                        .setString("date_added", to_sales_dr_services.date_added)
                        .setString("user_name", to_sales_dr_services.user_name)
                        .setNumber("status", to_sales_dr_services.status)
                        .ok();

                stmt1.addBatch(s3);
            }
            stmt1.executeBatch();
            conn.commit();
            Lg.s(S1_sales.class, "Successfully Added Sales Dr");

            return sa;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String add_sales(S1_sales.to_sales to_sales, List<S1_sales_items.to_sales_items> to_sales_items1, List<S1_sales_services.to_sales_services> to_sales_services1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String sa = S1_sales.increment_id();
            String s1 = "insert into sales("
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

            s1 = SqlStringUtil.parse(s1)
                    .setString("sales_no", sa)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", sa)
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
                    .setNumber("charge_status", to_sales.charge_status)
                    .ok();

            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.addBatch(s1);

            for (S1_sales_items.to_sales_items to_sales_items : to_sales_items1) {
                String s2 = "insert into sales_items("
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

                s2 = SqlStringUtil.parse(s2).
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
                        setString("date_added", to_sales_items.date_added).
                        setString("user_name", to_sales_items.user_name).
                        setString("item_type", to_sales_items.item_type).
                        setNumber("status", to_sales_items.status).
                        setString("session_no", to_sales_items.session_no).
                        setString("item_discount", to_sales_items.item_discount).
                        setNumber("discount", to_sales_items.discount).
                        setNumber("discount_amount", to_sales_items.discount_amount).
                        setString("sales_no", sa).
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

                stmt1.addBatch(s2);

                if (to_sales_items.fixed_price == 1) {
                    S1_items.to_items tt = S1_items.ret_data2(to_sales_items.barcode, to_sales_items.location_id);
                    System.out.println("Barcode: " + to_sales_items.barcode);
                    System.out.println("Location: " + to_sales_items.location_id);
                    System.out.println(tt.product_qty + " - " + to_sales_items.conversion + " * " + to_sales_items.product_qty);
                    double new_qty = tt.product_qty - (to_sales_items.conversion * to_sales_items.product_qty);
                    String s3 = "update items set "
                            + "product_qty='" + new_qty + "' "
                            + " where barcode = '" + to_sales_items.barcode + "' and location_id='" + to_sales_items.location_id + "' "
                            + "";
                    stmt1.addBatch(s3);
                }

                if (to_sales_items.fixed_price == 0) {
                    S1_items.to_items tt = S1_items.ret_data2(to_sales_items.barcode, to_sales_items.location_id);
                    double new_qty = tt.product_qty - (to_sales_items.product_qty);
                    String s3 = "update items set "
                            + "product_qty='" + new_qty + "' "
                            + " where barcode = '" + to_sales_items.barcode + "' and location_id='" + to_sales_items.location_id + "' "
                            + "";
                    stmt1.addBatch(s3);
                }

            }

            for (to_sales_services to_sales_services : to_sales_services1) {
                String s4 = "insert into sales_services("
                        + "or_no"
                        + ",service_name"
                        + ",service_amount"
                        + ",date_added"
                        + ",user_name"
                        + ",status"
                        + ")values("
                        + ":or_no"
                        + ",:service_name"
                        + ",:service_amount"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:status"
                        + ")";

                s4 = SqlStringUtil.parse(s4).
                        setString("or_no", sa).
                        setString("service_name", to_sales_services.service_name).
                        setNumber("service_amount", to_sales_services.service_amount).
                        setString("date_added", to_sales_services.date_added).
                        setString("user_name", to_sales_services.user_name).
                        setNumber("status", to_sales_services.status).
                        ok();

                stmt1.addBatch(s4);

            }
            stmt1.executeBatch();
            conn.commit();
            Lg.s(S1_sales.class, "Successfully Added Sales");

            String send_sales_to_innosoft = System.getProperty("send_sales_to_innosoft", "false");
            System.out.println("Send to Innosoft: " + send_sales_to_innosoft);
            if (send_sales_to_innosoft.equalsIgnoreCase("true")) {
                int connected = MyConnectionInnosoft.check_connection();

                if (connected == 1) {
                    try {
                        Connection conn2 = MyConnectionInnosoft.connect();
                        for (S1_sales_items.to_sales_items items : to_sales_items1) {

                            int id = 0;
                            String s7 = "select id from dbo.MstItem  where ItemCode = '" + items.barcode + "' ";
                            Statement stmt7 = conn2.createStatement();
                            ResultSet rs7 = stmt7.executeQuery(s7);
                            if (rs7.next()) {
                                id = rs7.getInt(1);
                            }
                            String s6 = " insert into dbo.TrnSalesDraft ("
                                    + "DocRef"
                                    + ",DocDate"
                                    + ",ItemCode"
                                    + ",ItemId "
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

                            s6 = SqlStringUtil.parse(s6).
                                    setString("DocRef", sa).
                                    setString("DocDate", DateType.datetime2.format(new Date())).
                                    setString("ItemCode", items.barcode).
                                    setNumber("ItemId", id).
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
                            PreparedStatement stmt6 = conn2.prepareStatement(s6);
                            stmt6.execute();

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
            StringSelection strSel = new StringSelection(sa);
            clipboard.setContents(strSel, null);
            String result = "";

            try {
                result = (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
            } catch (IOException e) {
            }
            return sa;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
