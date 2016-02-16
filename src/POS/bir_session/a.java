/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir_session;

import POS.util.DateUtils;
import java.util.Date;

/**
 *
 * @author Maytopacka
 */
public class a {

    public static void main(String[] args) {

        Date now = new Date();

        Date a=new Date();
        DateUtils.add_day(a, -2);
        
        
        System.out.println(a + " - "+now);
        int count = DateUtils.count_days(a, now);
        System.out.println(count);
    }
}
