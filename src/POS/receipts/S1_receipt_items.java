/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.items.S1_item_multi_level_pricing;
import POS.items.S1_items;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.MyConnectionInnosoft;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_receipt_items {

    public static class to_receipt_items {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String barcode;
        public final String description;
        public double qty;
        public double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public final double conversion;
        public final String unit;
        public final String date_delivered;
        public final String date_received;
        public final int status;
        public final String reference_no;
        public final String from_location_name;
        public final String from_location_id;
        public final String to_location_name;
        public final String to_location_id;

        public to_receipt_items(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id, double conversion, String unit, String date_delivered, String date_received, int status, String reference_no, String from_location_name, String from_location_id, String to_location_name, String to_location_id) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.conversion = conversion;
            this.unit = unit;
            this.date_delivered = date_delivered;
            this.date_received = date_received;
            this.status = status;
            this.reference_no = reference_no;
            this.from_location_name = from_location_name;
            this.from_location_id = from_location_id;
            this.to_location_name = to_location_name;
            this.to_location_id = to_location_id;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

    }

    public static void add_receipt_items(List<to_receipt_items> to_receipt_items1, String receipt_nos) {
        try {
            Connection conn = MyConnection.connect();
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s0 = "insert into receipt_items("
                        + "receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",conversion"
                        + ",unit"
                        + ",date_delivered"
                        + ",date_received"
                        + ",status"
                        + ",reference_no"
                        + ",from_location_name"
                        + ",from_location_id"
                        + ",to_location_name"
                        + ",to_location_id"
                        + ")values("
                        + ":receipt_no"
                        + ",:user_name"
                        + ",:session_no"
                        + ",:date_added"
                        + ",:supplier"
                        + ",:supllier_id"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:cost"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ",:conversion"
                        + ",:unit"
                        + ",:date_delivered"
                        + ",:date_received"
                        + ",:status"
                        + ",:reference_no"
                        + ",:from_location_name"
                        + ",:from_location_id"
                        + ",:to_location_name"
                        + ",:to_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("receipt_no", receipt_nos).
                        setString("user_name", to_receipt_items.user_name).
                        setString("session_no", to_receipt_items.session_no).
                        setString("date_added", to_receipt_items.date_added).
                        setString("supplier", to_receipt_items.supplier).
                        setString("supllier_id", to_receipt_items.supllier_id).
                        setString("remarks", to_receipt_items.remarks).
                        setString("barcode", to_receipt_items.barcode).
                        setString("description", to_receipt_items.description).
                        setNumber("qty", to_receipt_items.qty).
                        setNumber("cost", to_receipt_items.cost).
                        setString("category", to_receipt_items.category).
                        setString("category_id", to_receipt_items.category_id).
                        setString("classification", to_receipt_items.classification).
                        setString("classification_id", to_receipt_items.classification_id).
                        setString("sub_class", to_receipt_items.sub_class).
                        setString("sub_class_id", to_receipt_items.sub_class_id).
                        setNumber("conversion", to_receipt_items.conversion).
                        setString("unit", to_receipt_items.unit).
                        setString("date_delivered", to_receipt_items.date_delivered).
                        setString("date_received", to_receipt_items.date_received).
                        setNumber("status", to_receipt_items.status).
                        setString("reference_no", to_receipt_items.reference_no).
                        setString("from_location_name", to_receipt_items.from_location_name).
                        setString("from_location_id", to_receipt_items.from_location_id).
                        setString("to_location_name", to_receipt_items.to_location_name).
                        setString("to_location_id", to_receipt_items.to_location_id).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_receipt_items.class, "Successfully Added");
                S1_items.to_items tt = S1_items.ret_data2(to_receipt_items.barcode, to_receipt_items.from_location_id);
                double new_qty = tt.product_qty + (to_receipt_items.conversion * to_receipt_items.qty);
                String s2 = "update items set "
                        + "product_qty='" + new_qty + "',cost='" + to_receipt_items.cost + "' "
                        + " where barcode = '" + to_receipt_items.barcode + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_receipt_items(List<to_receipt_items> to_receipt_items1, S1_receipts.to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            Connection conn2 = MyConnectionInnosoft.connect();

            //<editor-fold defaultstate="collapsed" desc=" Receipt ">
            String s0 = "insert into receipts("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + ")values("
                    + ":receipt_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supllier_id"
                    + ",:remarks"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:status"
                    + ",:reference_no"
                    + ",:from_location_name"
                    + ",:from_location_id"
                    + ",:to_location_name"
                    + ",:to_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_no", to_receipts.receipt_no).
                    setString("user_name", to_receipts.user_name).
                    setString("session_no", to_receipts.session_no).
                    setString("date_added", to_receipts.date_added).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    setString("date_delivered", to_receipts.date_delivered).
                    setString("date_received", to_receipts.date_received).
                    setNumber("status", to_receipts.status).
                    setString("reference_no", to_receipts.reference_no).
                    setString("from_location_name", to_receipts.from_location_name).
                    setString("from_location_id", to_receipts.from_location_id).
                    setString("to_location_name", to_receipts.to_location_name).
                    setString("to_location_id", to_receipts.to_location_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            //<editor-fold defaultstate="collapsed" desc=" Receipt Items ">
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s4 = "insert into receipt_items("
                        + "receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",conversion"
                        + ",unit"
                        + ",date_delivered"
                        + ",date_received"
                        + ",status"
                        + ",reference_no"
                        + ",from_location_name"
                        + ",from_location_id"
                        + ",to_location_name"
                        + ",to_location_id"
                        + ")values("
                        + ":receipt_no"
                        + ",:user_name"
                        + ",:session_no"
                        + ",:date_added"
                        + ",:supplier"
                        + ",:supllier_id"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:cost"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ",:conversion"
                        + ",:unit"
                        + ",:date_delivered"
                        + ",:date_received"
                        + ",:status"
                        + ",:reference_no"
                        + ",:from_location_name"
                        + ",:from_location_id"
                        + ",:to_location_name"
                        + ",:to_location_id"
                        + ")";

                s4 = SqlStringUtil.parse(s4).
                        setString("receipt_no", to_receipts.receipt_no).
                        setString("user_name", to_receipts.user_name).
                        setString("session_no", to_receipts.session_no).
                        setString("date_added", to_receipts.date_added).
                        setString("supplier", to_receipts.supplier).
                        setString("supllier_id", to_receipts.supllier_id).
                        setString("remarks", to_receipts.remarks).
                        setString("barcode", to_receipt_items.barcode).
                        setString("description", to_receipt_items.description).
                        setNumber("qty", to_receipt_items.qty).
                        setNumber("cost", to_receipt_items.cost).
                        setString("category", to_receipt_items.category).
                        setString("category_id", to_receipt_items.category_id).
                        setString("classification", to_receipt_items.classification).
                        setString("classification_id", to_receipt_items.classification_id).
                        setString("sub_class", to_receipt_items.sub_class).
                        setString("sub_class_id", to_receipt_items.sub_class_id).
                        setNumber("conversion", to_receipt_items.conversion).
                        setString("unit", to_receipt_items.unit).
                        setString("date_delivered", to_receipts.date_delivered).
                        setString("date_received", to_receipts.date_received).
                        setNumber("status", to_receipts.status).
                        setString("reference_no", to_receipts.reference_no).
                        setString("from_location_name", to_receipts.from_location_name).
                        setString("from_location_id", to_receipts.from_location_id).
                        setString("to_location_name", to_receipts.to_location_name).
                        setString("to_location_id", to_receipts.to_location_id).
                        ok();

                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt.addBatch(s4);

                //<editor-fold defaultstate="collapsed" desc=" select qty Items ">
                String s7 = "select "
                        + "product_qty"
                        + " from items where "
                        + " barcode ='" + to_receipt_items.barcode + "' and location_id='" + to_receipts.from_location_id + "' "
                        + " ";

                Statement stmt7 = conn.createStatement();
                ResultSet rs7 = stmt7.executeQuery(s7);
                double product_qty = 0;
                if (rs7.next()) {
                    product_qty = rs7.getDouble(1);
                }

                //</editor-fold>
                double new_qty = product_qty + (to_receipt_items.conversion * to_receipt_items.qty);
                String s5 = " update items set "
                        + " product_qty='" + new_qty + "',cost='" + to_receipt_items.cost + "' "
                        + " where barcode = '" + to_receipt_items.barcode + "' and location_id='" + to_receipts.from_location_id + "' "
                        + "";
                PreparedStatement stmt5 = conn.prepareStatement(s5);
                stmt5.execute();

                //</editor-fold>
            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(S1_receipt_items.class, "Successfully Added Synapse");
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" TrnStockIn ">
            String send_sales_to_innosoft = System.getProperty("send_sales_to_innosoft", "false");
            System.out.println("Send to Innosoft: " + send_sales_to_innosoft);
            String LastStockInNumber = "";
            if (send_sales_to_innosoft.equalsIgnoreCase("true")) {
                String StockInDate = DateType.sf.format(new Date()) + " 00:00:00.000";
                LastStockInNumber = MyConnectionInnosoft.getLastStockInNumber();
                LastStockInNumber = ReceiptIncrementor.increment(LastStockInNumber);
                System.out.println("Transaction Number: " + LastStockInNumber);
                String s2 = " insert into dbo.TrnStockIn ("
                        + " PeriodId"
                        + ",StockInDate"
                        + ",StockInNumber"
                        + ",SupplierId"
                        + ",Remarks"
                        + ",IsReturn"
                        + ",CollectionId"
                        + ",PurchaseOrderId"
                        + ",PreparedBy"
                        + ",CheckedBy"
                        + ",ApprovedBy"
                        + ",IsLocked"
                        + ",EntryUserId"
                        + ",EntryDateTime"
                        + ",UpdateUserId"
                        + ",UpdateDateTime"
                        + ",SalesId"
                        + ")values("
                        + ":PeriodId"
                        + ",:StockInDate"
                        + ",:StockInNumber"
                        + ",:SupplierId"
                        + ",:Remarks"
                        + ",:IsReturn"
                        + ",:CollectionId"
                        + ",:PurchaseOrderId"
                        + ",:PreparedBy"
                        + ",:CheckedBy"
                        + ",:ApprovedBy"
                        + ",:IsLocked"
                        + ",:EntryUserId"
                        + ",:EntryDateTime"
                        + ",:UpdateUserId"
                        + ",:UpdateDateTime"
                        + ",:SalesId"
                        + ")";

                s2 = SqlStringUtil.parse(s2).
                        setString("PeriodId", "1").
                        setString("StockInDate", StockInDate).
                        setString("StockInNumber", LastStockInNumber).
                        setString("SupplierId", "23").
                        setString("Remarks", "").
                        setString("IsReturn", "0").
                        setString("CollectionId", null).
                        setString("PurchaseOrderId", null).
                        setString("PreparedBy", "1").
                        setString("CheckedBy", "1").
                        setString("ApprovedBy", "1").
                        setString("IsLocked", "-1").
                        setString("EntryUserId", "1").
                        setString("EntryDateTime", StockInDate).
                        setString("UpdateUserId", "1").
                        setString("UpdateDateTime", StockInDate).
                        setString("SalesId", null).
                        ok();
                PreparedStatement stmt2 = conn2.prepareStatement(s2);
                stmt2.execute();

                String s18 = "select TOP 1 "
                        + " Id"
                        + " from dbo.TrnStockIn ORDER BY Id DESC "
                        + " ";

                Statement stmt18 = conn2.createStatement();
                ResultSet rs18 = stmt18.executeQuery(s18);

                String TrnStockInId = "0";
                if (rs18.next()) {
                    TrnStockInId = rs18.getString(1);
                }

                for (to_receipt_items to_receipt_items : to_receipt_items1) {
                    //<editor-fold defaultstate="collapsed" desc=" TrnStockInLine ">
                    if (send_sales_to_innosoft.equalsIgnoreCase("true")) {
                        String s8 = "select "
                                + " Id"
                                + " ,OnHandQuantity"
                                + " from dbo.MstItem where "
                                + " ItemCode ='" + to_receipt_items.barcode + "'  "
                                + " ";

                        Statement stmt8 = conn2.createStatement();
                        ResultSet rs8 = stmt8.executeQuery(s8);
                        double product_qty2 = 0;
                        String id1 = "0";
                        if (rs8.next()) {
                            product_qty2 = rs8.getDouble(2);
                            id1 = rs8.getString(1);
                        }

                        String s6 = " insert into dbo.TrnStockInLine ("
                                + " StockInId"
                                + ",ItemId"
                                + ",UnitId"
                                + ",Quantity"
                                + ",Cost"
                                + ",Amount"
                                + ",ExpiryDate"
                                + ",LotNumber"
                                + ",AssetAccountId"
                                + ")values("
                                + " :StockInId"
                                + ",:ItemId"
                                + ",:UnitId"
                                + ",:Quantity"
                                + ",:Cost"
                                + ",:Amount"
                                + ",:ExpiryDate"
                                + ",:LotNumber"
                                + ",:AssetAccountId"
                                + ")";
                        float q = Float.parseFloat("" + to_receipt_items.qty);
                        float c = Float.parseFloat("" + to_receipt_items.cost);
                        float a = Float.parseFloat("" + (q * c));

                        s6 = SqlStringUtil.parse(s6).
                                setString("StockInId", TrnStockInId).
                                setString("ItemId", id1).
                                setString("UnitId", "1").
                                setString("Quantity", "" + q).
                                setString("Cost", "" + c).
                                setString("Amount", "" + a).
                                setString("ExpiryDate", null).
                                setString("LotNumber", null).
                                setString("AssetAccountId", "74").
                                ok();
                        PreparedStatement stmt6 = conn2.prepareStatement(s6);
                        System.out.println(s6);
                        stmt6.execute();

                        //<editor-fold defaultstate="collapsed" desc=" select MstIten OnHandQuantity ">
                        double new_qty = product_qty2 + (to_receipt_items.conversion * to_receipt_items.qty);
                        float new_qty1 = Float.parseFloat("" + new_qty);
                        String s9 = " update dbo.MstItem set "
                                + " OnHandQuantity='" + new_qty1 + "',cost='" + c + "' "
                                + " where barcode = '" + to_receipt_items.barcode + "' "
                                + "";
                        PreparedStatement stmt9 = conn2.prepareStatement(s9);
                        stmt9.execute();
                        System.out.println(s9);
                        //</editor-fold>
                    }
                }

                Lg.s(S1_receipt_items.class, "Successfully Added Innosoft");
            }
            //</editor-fold>
            //</editor-fold>

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_receipt_items(to_receipt_items to, double tendered_qty) {
        try {
            Connection conn = MyConnection.connect();
            S1_items.to_items tt = S1_items.ret_data2(to.barcode, to.from_location_id);
            double new_qty = (to.qty) - tendered_qty;
            new_qty = to.conversion * new_qty;
            new_qty = tt.product_qty - new_qty;
            String s2 = "update items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to.barcode + "'"
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
            String s3 = "update receipt_items set "
                    + "qty='" + tendered_qty + "' "
                    + " where id = '" + to.id + "'"
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items(to_receipt_items to, double tendered_qty) {
        try {
            Connection conn = MyConnection.connect();
            S1_items.to_items tt = S1_items.ret_data2(to.barcode, to.from_location_id);
            double new_qty = (to.qty) * to.conversion;
//            new_qty = to.conversion * new_qty;
            new_qty = tt.product_qty - new_qty;
            String s2 = "update items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to.barcode + "'"
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
            String s3 = "delete from receipt_items "
                    + " where id = '" + to.id + "'"
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipt_items set "
                    + "receipt_no= '" + to_receipt_items.receipt_no + "'"
                    + ",user_name= '" + to_receipt_items.user_name + "'"
                    + ",session_no= '" + to_receipt_items.session_no + "'"
                    + ",date_added= '" + to_receipt_items.date_added + "'"
                    + ",supplier= '" + to_receipt_items.supplier + "'"
                    + ",supllier_id= '" + to_receipt_items.supllier_id + "'"
                    + ",remarks= '" + to_receipt_items.remarks + "'"
                    + ",barcode= '" + to_receipt_items.barcode + "'"
                    + ",description= '" + to_receipt_items.description + "'"
                    + ",qty= '" + to_receipt_items.qty + "'"
                    + ",cost= '" + to_receipt_items.cost + "'"
                    + ",category= '" + to_receipt_items.category + "'"
                    + ",category_id= '" + to_receipt_items.category_id + "'"
                    + ",classification= '" + to_receipt_items.classification + "'"
                    + ",classification_id= '" + to_receipt_items.classification_id + "'"
                    + ",sub_class= '" + to_receipt_items.sub_class + "'"
                    + ",sub_class_id= '" + to_receipt_items.sub_class_id + "'"
                    + ",unit= '" + to_receipt_items.unit + "'"
                    + ",reference_no= '" + to_receipt_items.reference_no + "' "
                    + ",from_location_name= '" + to_receipt_items.from_location_name + "' "
                    + ",from_location_id= '" + to_receipt_items.from_location_id + "' "
                    + ",to_location_name= '" + to_receipt_items.to_location_name + "' "
                    + ",to_location_id= '" + to_receipt_items.to_location_id + "' "
                    + " where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from receipt_items where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipt_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data(String search) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipt_items where "
                    + " receipt_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                int status = rs.getInt(23);
                String reference_no = rs.getString(24);
                String from_location_name = rs.getString(25);
                String from_location_id = rs.getString(26);
                String to_location_name = rs.getString(27);
                String to_location_id = rs.getString(28);
                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data2(String barcodes, String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipt_items where "
                    + " barcode ='" + barcodes + "' "
                    + " and date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                int status = rs.getInt(23);
                String reference_no = rs.getString(24);
                String from_location_name = rs.getString(25);
                String from_location_id = rs.getString(26);
                String to_location_name = rs.getString(27);
                String to_location_id = rs.getString(28);
                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data2_supplier(String barcodes, String date_from, String date_to, String supplier1) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipt_items where "
                    + " barcode ='" + barcodes + "' and date(date_added) between '" + date_from + "' and '" + date_to + "' and supplier like '%" + supplier1 + "%' "
                    + " or description like '%" + barcodes + "%' and date(date_added) between '" + date_from + "' and '" + date_to + "' and supplier like '%" + supplier1 + "%' "
                    + " "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                int status = rs.getInt(23);
                String reference_no = rs.getString(24);
                String from_location_name = rs.getString(25);
                String from_location_id = rs.getString(26);
                String to_location_name = rs.getString(27);
                String to_location_id = rs.getString(28);
                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_where(String where) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",status"
                    + ",reference_no"
                    + ",from_location_name"
                    + ",from_location_id"
                    + ",to_location_name"
                    + ",to_location_id"
                    + " from receipt_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                int status = rs.getInt(23);
                String reference_no = rs.getString(24);
                String from_location_name = rs.getString(25);
                String from_location_id = rs.getString(26);
                String to_location_name = rs.getString(27);
                String to_location_id = rs.getString(28);
                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, date_delivered, date_received, status, reference_no, from_location_name, from_location_id, to_location_name, to_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(List<to_receipt_items> to_receipt_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s0 = "delete from receipt_items  "
                        + " where receipt_no='" + to_receipt_items.receipt_no + "' "
                        + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_receipt_items.class, "Successfully Added");

                S1_items.to_items tt = S1_items.ret_data3(to_receipt_items.barcode, to_receipt_items.from_location_id);
                double new_qty = tt.product_qty - (to_receipt_items.conversion * to_receipt_items.qty);
                String s2 = "update items set "
                        + " product_qty='" + new_qty + "',cost='" + to_receipt_items.cost + "' "
                        + " where barcode = '" + to_receipt_items.barcode + "' and location_id='" + to_receipt_items.from_location_id + "' "
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
