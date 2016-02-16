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
public class MyList {

    
    public static List<String> hours() {
        List<String> datas = new ArrayList();
        for (int i = 1; i < 13; i++) {
            String min = "" + i;
            if (min.length() == 1) {
                min = "0" + min;
            }
            
            datas.add(min);
        }
        return datas;
    }

    public static void main(String[] args) {
        hours();
    }

    public static List<String> minutes() {
        List<String> datas = new ArrayList();
        for (int i = 1; i < 60; i++) {
            String min = "" + i;
            if (min.length() == 1) {
                min = "0" + min;
            }
            
            datas.add(min);
        }
        return datas;
    }
}
