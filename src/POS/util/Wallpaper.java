/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import POS.pnl.Pnl_Dashboard;
import java.awt.Toolkit;
import java.io.InputStream;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author i1
 */
public class Wallpaper {
    
    public static void do_set(String img_url, JFrame pn) {
        JLabel l = new JLabel();
        InputStream is = Pnl_Dashboard.class.getResourceAsStream(img_url);
//        InputStream is1 = Wallpaper.class.getResourceAsStream(img_url);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        System.out.println(xSize + " " + ySize);
        l.setSize(xSize, ySize);
        
        ImageMounter2.do_set(l, is);
        pn.add(l);

//        j.add(pn);

        
    }
    
    public static void do_set(String img_url, JDesktopPane pn) {
        JLabel l = new JLabel();
        InputStream is = Pnl_Dashboard.class.getResourceAsStream(img_url);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        l.setSize(xSize, ySize);     
        ImageMounter2.do_set(l, is);
        pn.add(l); 
    }
    
    public static void do_set(String img_url, JPanel pn) {
        JLabel l = new JLabel();
        InputStream is = Pnl_Dashboard.class.getResourceAsStream(img_url);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        System.out.println(xSize + " " + ySize);
        l.setSize(xSize, ySize);
        System.out.println(is);
        ImageMounter2.do_set(l, is);
        pn.add(l);

//        j.add(pn);

        
    }
    
    public static void do_set(String img_url, JDialog pn) {
        JLabel l = new JLabel();
        InputStream is = Pnl_Dashboard.class.getResourceAsStream(img_url);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        System.out.println(xSize + " " + ySize);
        l.setSize(xSize, ySize);
        
        ImageMounter2.do_set(l, is);
        pn.add(l);

//        j.add(pn);

        
    }
}
