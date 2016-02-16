/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_item_multi_level_pricing {

    public static class to_item_multi_level_pricing {

        public final int id;
        public final String barcode;
        public String description;
        public String unit;
        public double conversion;
        public double price;

        public to_item_multi_level_pricing(int id, String barcode, String description, String unit, double conversion, double price) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.conversion = conversion;
            this.price = price;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static void add_item_multi_level_pricing(List<to_item_multi_level_pricing> to_item_multi_level_pricing1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_item_multi_level_pricing to_item_multi_level_pricing : to_item_multi_level_pricing1) {
                String s0 = "insert into item_multi_level_pricing("
                        + "barcode"
                        + ",description"
                        + ",unit"
                        + ",conversion"
                        + ",price"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:unit"
                        + ",:conversion"
                        + ",:price"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("barcode", to_item_multi_level_pricing.barcode).
                        setString("description", to_item_multi_level_pricing.description).
                        setString("unit", to_item_multi_level_pricing.unit).
                        setNumber("conversion", to_item_multi_level_pricing.conversion).
                        setNumber("price", to_item_multi_level_pricing.price).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_item_multi_level_pricing.class, "Successfully Added");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_item_multi_level_pricing(to_item_multi_level_pricing to_item_multi_level_pricing) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update item_multi_level_pricing set "
                    + "barcode= '" + to_item_multi_level_pricing.barcode + "'"
                    + ",description= '" + to_item_multi_level_pricing.description + "'"
                    + ",unit= '" + to_item_multi_level_pricing.unit + "'"
                    + ",conversion= '" + to_item_multi_level_pricing.conversion + "'"
                    + ",price= '" + to_item_multi_level_pricing.price + "'"
                    + "where "
                    + " id ='" + to_item_multi_level_pricing.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_item_multi_level_pricing.class, "Successfully Updated");


         

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_item_multi_level_pricing(to_item_multi_level_pricing to_item_multi_level_pricing) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from item_multi_level_pricing where "
                    + " id ='" + to_item_multi_level_pricing.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_item_multi_level_pricing.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_item_multi_level_pricing> ret_data(String search) {
        List<to_item_multi_level_pricing> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",unit"
                    + ",conversion"
                    + ",price"
                    + " from item_multi_level_pricing where "
                    + " barcode ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String unit = rs.getString(4);
                double conversion = rs.getDouble(5);
                double price = rs.getDouble(6);

                to_item_multi_level_pricing to = new to_item_multi_level_pricing(id, barcode, description, unit, conversion, price);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
