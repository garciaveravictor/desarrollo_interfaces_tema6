/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzaayuda;

import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Victor Garcia Vera 2DAM
 */
public class LanzaAyuda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Panel y frame
        JFrame jFrame = new JFrame();
        
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();
        
        //Menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Ayuda");
        JMenuItem menuItemContenido = new JMenuItem("Contenido de ayuda");
        JMenuItem menuItemAbout = new JMenuItem("About");
        
        menuItemContenido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        hb.enableHelpKey(menuItemContenido, "top", hs);
        hb.enableHelpOnButton(menuItemContenido,"intro",hs);
        
        menu.add(menuItemContenido);
        menu.add(menuItemAbout);

        menuBar.add(menu);

        jFrame.setJMenuBar(menuBar);
        jFrame.setVisible(true);
        jFrame.setSize(300, 300);
    }

    public static HelpSet obtenFicAyuda() {
        try {
            ClassLoader cl = LanzaAyuda.class.getClassLoader();
            File file = new File(LanzaAyuda.class.getResource("/help/helpSet.hs").getFile());
            URL url = file.toURI().toURL();
            // crea un objeto Helpset
            HelpSet hs = new HelpSet(null, url);
            return hs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fichero HelpSet no encontrado");
            return null;
        }
    }

}
