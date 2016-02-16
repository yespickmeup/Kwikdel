/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import POS.expenses.S1_expenses;
import POS.expenses.S1_expenses.to_expenses;
import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_cloud {

    public static void add_expenses(to_expenses to_expenses) {
        to_expenses = new to_expenses(1, "ex");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into expenses("
                    + "id"
                    + ",expense_name"
                    + ")values("
                    + ":id"
                    + ",:expense_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("id", to_expenses.id).
                    setString("expense_name", to_expenses.expense_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
