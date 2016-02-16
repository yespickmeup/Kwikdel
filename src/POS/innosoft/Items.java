/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.innosoft;

import POS.items.S1_items;
import POS.items.S1_items.to_items;
import POS.items.S1_new_items;
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
import mijzcx.synapse.desk.utils.SqlStringUtil;


/**
 *
 * @author Guinness
 */
public class Items {

    public static void main(String[] args) {

    }

    public static void update_innosoft() {
        String where = " group by barcode order by description asc";
        List<to_items> items = Items.ret_data(where);
        System.out.println("Total Items: " + items.size());
        try {
            Connection conn = MyConnectionInnosoft.connect();

            String datetime = DateType.datetime2.format(new Date());

            String s2 = "delete from dbo.MstItem";
            PreparedStatement stmt = conn.prepareStatement(s2);
            stmt.execute();
            Lg.s(S1_items.class, "Successfully Deleted");

            for (to_items to : items) {

                String s0 = " insert into dbo.MstItem ("
                        + "ItemCode"
                        + ",BarCode"
                        + ",ItemDescription"
                        + ",Alias"
                        + ",GenericName"
                        + ",Category"
                        + ",SalesAccountId"
                        + ",AssetAccountId"
                        + ",CostAccountId"
                        + ",InTaxId"
                        + ",OutTaxId"
                        + ",UnitId"
                        + ",DefaultSupplierId"
                        + ",Cost"
                        + ",MarkUp"
                        + ",Price"
                        + ",ImagePath"
                        + ",ReorderQuantity"
                        + ",OnhandQuantity"
                        + ",IsInventory"
                        + ",ExpiryDate"
                        + ",LotNumber"
                        + ",Remarks"
                        + ",EntryUserId"
                        + ",EntryDateTime"
                        + ",UpdateUserId"
                        + ",UpdateDateTime"
                        + ",IsLocked"
                        + ",DefaultKitchenReport"
                        + ",IsPackage"
                        + ")values("
                        + " :ItemCode"
                        + ",:BarCode"
                        + ",:ItemDescription"
                        + ",:Alias"
                        + ",:GenericName"
                        + ",:Category"
                        + ",:SalesAccountId"
                        + ",:AssetAccountId"
                        + ",:CostAccountId"
                        + ",:InTaxId"
                        + ",:OutTaxId"
                        + ",:UnitId"
                        + ",:DefaultSupplierId"
                        + ",:Cost"
                        + ",:MarkUp"
                        + ",:Price"
                        + ",:ImagePath"
                        + ",:ReorderQuantity"
                        + ",:OnhandQuantity"
                        + ",:IsInventory"
                        + ",:ExpiryDate"
                        + ",:LotNumber"
                        + ",:Remarks"
                        + ",:EntryUserId"
                        + ",:EntryDateTime"
                        + ",:UpdateUserId"
                        + ",:UpdateDateTime"
                        + ",:IsLocked"
                        + ",:DefaultKitchenReport"
                        + ",:IsPackage"
                        + ")";
                double cost = to.cost;
                double selling_price = to.selling_price;
                double difference = selling_price - cost;
                double markup = difference / cost;
                markup = markup * 100;

                s0 = SqlStringUtil.parse(s0).
                        setString("ItemCode", to.barcode).
                        setString("BarCode", to.barcode).
                        setString("ItemDescription", to.description).
                        setString("Alias", "").
                        setString("GenericName", "").
                        setString("Category", to.category).
                        setNumber("SalesAccountId", 159).
                        setNumber("AssetAccountId", 74).
                        setNumber("CostAccountId", 238).
                        setNumber("InTaxId", 4).
                        setNumber("OutTaxId", 4).
                        setNumber("UnitId", 1).
                        setNumber("DefaultSupplierId", 23).
                        setNumber("Cost", to.cost).
                        setNumber("MarkUp", 0).
                        setNumber("Price", to.selling_price).
                        setString("ImagePath", "NA").
                        setNumber("ReorderQuantity", 0).
                        setNumber("OnhandQuantity", to.product_qty).
                        setNumber("IsInventory", 1).
                        setString("ExpiryDate", null).
                        setString("LotNumber", "NULL").
                        setString("Remarks", "").
                        setNumber("EntryUserId", 1).
                        setString("EntryDateTime", datetime).
                        setNumber("UpdateUserId", 1).
                        setString("UpdateDateTime", datetime).
                        setNumber("IsLocked", 1).
                        setString("DefaultKitchenReport", "NULL").
                        setNumber("IsPackage", 0).
                        ok();
                PreparedStatement stmt2 = conn.prepareStatement(s0);
                stmt2.execute();
            }

            Lg.s(Items.class, "Successfully Added");

        } catch (SQLException e) {
            System.out.println("DB error : " + e);
        }
    }

    public static void add_item(S1_new_items.to_items to) {
        try {
            Connection conn = MyConnectionInnosoft.connect();

            String datetime = DateType.datetime2.format(new Date());
            String s0 = " insert into dbo.MstItem ("
                    + "ItemCode"
                    + ",BarCode"
                    + ",ItemDescription"
                    + ",Alias"
                    + ",GenericName"
                    + ",Category"
                    + ",SalesAccountId"
                    + ",AssetAccountId"
                    + ",CostAccountId"
                    + ",InTaxId"
                    + ",OutTaxId"
                    + ",UnitId"
                    + ",DefaultSupplierId"
                    + ",Cost"
                    + ",MarkUp"
                    + ",Price"
                    + ",ImagePath"
                    + ",ReorderQuantity"
                    + ",OnhandQuantity"
                    + ",IsInventory"
                    + ",ExpiryDate"
                    + ",LotNumber"
                    + ",Remarks"
                    + ",EntryUserId"
                    + ",EntryDateTime"
                    + ",UpdateUserId"
                    + ",UpdateDateTime"
                    + ",IsLocked"
                    + ",DefaultKitchenReport"
                    + ",IsPackage"
                    + ")values("
                    + " :ItemCode"
                    + ",:BarCode"
                    + ",:ItemDescription"
                    + ",:Alias"
                    + ",:GenericName"
                    + ",:Category"
                    + ",:SalesAccountId"
                    + ",:AssetAccountId"
                    + ",:CostAccountId"
                    + ",:InTaxId"
                    + ",:OutTaxId"
                    + ",:UnitId"
                    + ",:DefaultSupplierId"
                    + ",:Cost"
                    + ",:MarkUp"
                    + ",:Price"
                    + ",:ImagePath"
                    + ",:ReorderQuantity"
                    + ",:OnhandQuantity"
                    + ",:IsInventory"
                    + ",:ExpiryDate"
                    + ",:LotNumber"
                    + ",:Remarks"
                    + ",:EntryUserId"
                    + ",:EntryDateTime"
                    + ",:UpdateUserId"
                    + ",:UpdateDateTime"
                    + ",:IsLocked"
                    + ",:DefaultKitchenReport"
                    + ",:IsPackage"
                    + ")";
            double cost = to.cost;
            double selling_price = to.selling_price;
            double difference = selling_price - cost;
            double markup = difference / cost;
            markup = markup * 100;

            s0 = SqlStringUtil.parse(s0).
                    setString("ItemCode", to.barcode).
                    setString("BarCode", to.barcode).
                    setString("ItemDescription", to.description).
                    setString("Alias", "").
                    setString("GenericName", "").
                    setString("Category", to.category).
                    setNumber("SalesAccountId", 159).
                    setNumber("AssetAccountId", 74).
                    setNumber("CostAccountId", 238).
                    setNumber("InTaxId", 4).
                    setNumber("OutTaxId", 4).
                    setNumber("UnitId", 1).
                    setNumber("DefaultSupplierId", 23).
                    setNumber("Cost", to.cost).
                    setNumber("MarkUp", 0).
                    setNumber("Price", to.selling_price).
                    setString("ImagePath", "NA").
                    setNumber("ReorderQuantity", 0).
                    setNumber("OnhandQuantity", to.product_qty).
                    setNumber("IsInventory", 1).
                    setString("ExpiryDate", null).
                    setString("LotNumber", "NULL").
                    setString("Remarks", "").
                    setNumber("EntryUserId", 1).
                    setString("EntryDateTime", datetime).
                    setNumber("UpdateUserId", 1).
                    setString("UpdateDateTime", datetime).
                    setNumber("IsLocked", 1).
                    setString("DefaultKitchenReport", "NULL").
                    setNumber("IsPackage", 0).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s0);
            stmt2.execute();

            Lg.s(Items.class, "Successfully Added");

        } catch (SQLException e) {
            System.out.println("DB error : " + e);
        }
    }

    public static void update_item(S1_new_items.to_items to) {
        try {
            Connection conn = MyConnectionInnosoft.connect();

            String datetime = DateType.datetime2.format(new Date());
            String s0 = " update  dbo.MstItem set  "
                    + "ItemDescription = :ItemDescription"
                    + ",Alias = :Alias"
                    + ",GenericName = :GenericName"
                    + ",Category = :Category"
                    + ",SalesAccountId = :SalesAccountId"
                    + ",AssetAccountId = :AssetAccountId"
                    + ",CostAccountId = :CostAccountId"
                    + ",InTaxId = :InTaxId"
                    + ",OutTaxId = :OutTaxId"
                    + ",UnitId = :UnitId"
                    + ",DefaultSupplierId = :DefaultSupplierId"
                    + ",Cost = :Cost"
                    + ",MarkUp = :MarkUp"
                    + ",Price = :Price"
                    + ",ImagePath = :ImagePath"
                    + ",ReorderQuantity = :ReorderQuantity"
                    + ",OnhandQuantity = :OnhandQuantity"
                    + ",IsInventory = :IsInventory"
                    + ",ExpiryDate = :ExpiryDate"
                    + ",LotNumber = :LotNumber"
                    + ",Remarks = :Remarks"
                    + ",EntryUserId = :EntryUserId"
                    + ",EntryDateTime = :EntryDateTime"
                    + ",UpdateUserId = :UpdateUserId"
                    + ",UpdateDateTime = :UpdateDateTime"
                    + ",IsLocked = :IsLocked"
                    + ",DefaultKitchenReport = :DefaultKitchenReport"
                    + ",IsPackage = :IsPackage"
                    + " where "
                    + " ItemCode = :ItemCode ";
            double cost = to.cost;
            double selling_price = to.selling_price;
            double difference = selling_price - cost;
            double markup = difference / cost;
            markup = markup * 100;

            s0 = SqlStringUtil.parse(s0).
                    setString("ItemCode", to.barcode).
                    setString("ItemDescription", to.description).
                    setString("Alias", "").
                    setString("GenericName", "").
                    setString("Category", to.category).
                    setNumber("SalesAccountId", 159).
                    setNumber("AssetAccountId", 74).
                    setNumber("CostAccountId", 238).
                    setNumber("InTaxId", 4).
                    setNumber("OutTaxId", 4).
                    setNumber("UnitId", 1).
                    setNumber("DefaultSupplierId", 23).
                    setNumber("Cost", to.cost).
                    setNumber("MarkUp", 0).
                    setNumber("Price", to.selling_price).
                    setString("ImagePath", "NA").
                    setNumber("ReorderQuantity", 0).
                    setNumber("OnhandQuantity", to.product_qty).
                    setNumber("IsInventory", 1).
                    setString("ExpiryDate", null).
                    setString("LotNumber", "NULL").
                    setString("Remarks", "").
                    setNumber("EntryUserId", 1).
                    setString("EntryDateTime", datetime).
                    setNumber("UpdateUserId", 1).
                    setString("UpdateDateTime", datetime).
                    setNumber("IsLocked", 1).
                    setString("DefaultKitchenReport", "NULL").
                    setNumber("IsPackage", 0).
                    ok();
            PreparedStatement stmt2 = conn.prepareStatement(s0);
            stmt2.execute();

            Lg.s(Items.class, "Successfully Added");

        } catch (SQLException e) {
            System.out.println("DB error : " + e);
        }
    }

    public static void delete_items(S1_new_items.to_items to) {
        try {
            Connection conn = MyConnectionInnosoft.connect();
            String s0 = "delete from dbo.MstItem where "
                    + " ItemCode ='" + to.barcode + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_data(String where) {
        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " id"
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
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",location_name"
                    + ",location_id"
                    + " from items"
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
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                String location_name = rs.getString(26);
                String location_id = rs.getString(27);

                to_items to = new to_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, new ArrayList(), vatable, reorder_level, location_name, location_id);
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
