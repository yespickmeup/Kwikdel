/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronald
 */
public class MyDate {

    public static SimpleDateFormat hh = new SimpleDateFormat("HH");
    public static SimpleDateFormat mm = new SimpleDateFormat("mm");

    public static String[] datetime_getHours(String datetime) {
        String[] dates = new String[2];
        dates[0] = "";
        dates[1] = "";
        try {
            Date d = DateType.datetime.parse(datetime);
            dates[0] = hh.format(d);
            dates[1] = mm.format(d);
        } catch (ParseException ex) {
            Logger.getLogger(MyDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    }
}
