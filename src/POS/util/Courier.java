/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class Courier {

    public static class to_courier {

        public final String id;
        public final String name;

        public to_courier(String id, String name) {
            this.id = id;
            this.name = name;
        }

    }

    public static List<String> metered_types() {
        List<String> datas = new ArrayList();
        datas.add("Low Pressure");
        datas.add("High Pressure");
        return datas;
    }

    public static List<to_courier> transaction_type() {
        List<to_courier> datas = new ArrayList();
        to_courier to1 = new to_courier("1", "Walkin");
        to_courier to2 = new to_courier("2", "Delivery");
        datas.add(to1);
        datas.add(to2);
        return datas;
    }

    public static List<to_courier> payment_type() {
        List<to_courier> datas = new ArrayList();
        to_courier to1 = new to_courier("1", "Cash");
        to_courier to2 = new to_courier("2", "Charge");
        datas.add(to1);
        datas.add(to2);
        return datas;
    }

    
}
