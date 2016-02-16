/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

/**
 *
 * @author Maytopacka
 */
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Test {

    public static void main(String[] args) {
        JFrame frm = new JFrame();
        JSplitPane spn = new JSplitPane();
        JPanel pnButtons = new JPanel();
        final JDesktopPane dsk = new JDesktopPane();
        final JInternalFrame ifr1 = new JInternalFrame("11111", true, true, true, true);
        final JInternalFrame ifr2 = new JInternalFrame("22222", true, true, true, true);
        pnButtons.add(new JButton(new AbstractAction("Open 1") {
            public void actionPerformed(ActionEvent arg0) {
                dsk.getDesktopManager().
                        deiconifyFrame(ifr1);
                ifr1.hide();
                ifr1.show();
            }
        }));

        pnButtons.add(new JButton(new AbstractAction("Open 2") {

            public void actionPerformed(ActionEvent arg0) {
                dsk.getDesktopManager().
                        deiconifyFrame(ifr2);
                ifr2.hide();
                ifr2.show();
            }
        }));


        dsk.add(ifr1);
        ifr1.pack();
        ifr1.setSize(200, 100);
        ifr1.show();

        dsk.add(ifr2);
        ifr2.pack();
        ifr2.setSize(200, 100);
        ifr2.show();

        spn.setLeftComponent(pnButtons);
        spn.setRightComponent(dsk);
        frm.setContentPane(spn);
        frm.setSize(800, 600);
        frm.show();
    }
}
