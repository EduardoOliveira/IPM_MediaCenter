package pt.iscte.tsi.mediamood.gui;

import pt.iscte.tsi.mediamood.connection.ConnectionProlog;

import javax.swing.*;

/**
 * Created by Chen on 25-05-2015.
 */
public class Gui {

    private JFrame mainFrame;
    private JButton ok;

    public Gui(){
        String age = JOptionPane.showInputDialog("Introduza a sua idade");
        ConnectionProlog.getInstance().insertAge(Integer.valueOf(age));
    }
}
