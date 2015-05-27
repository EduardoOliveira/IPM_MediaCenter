package pt.iscte.tsi.mediamood.gui;

import com.sun.xml.internal.ws.handler.HandlerException;
import pt.iscte.tsi.mediamood.connection.ConnectionProlog;
import pt.iscte.tsi.mediamood.database.entity.Movie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Chen on 25-05-2015.
 */
public class Gui {

    private JFrame mainFrame;
    private JButton ok;
    private JPanel mainPanel;
    private JPanel emotionPanel;
    private JComboBox emotionCombo;

    private JTable movieTable;
    private DefaultTableModel dtm;


    private String[] emotions = {"Excited", "Pissed Of", "Thoughtful", "Nostalgic", "Meh"};
    private String[] headerTable = {"Movie", "Genre"};

    public Gui(){
        String age = JOptionPane.showInputDialog("Introduza a sua idade");
        if(age == null || age.length() == 0) {
            System.out.println("Canceled By user");
            System.exit(0);
        }else{
            char[] chars = age.toCharArray();
            for(char c: chars){
                if(Character.isLetter(c)){
                    JOptionPane.showMessageDialog(null,"Introduza apenas numeros");
                    new Gui();
                }
            }
            ConnectionProlog.getInstance().insertMoviesAsFacts();
            ConnectionProlog.getInstance().getMoviesForAge(age);
            start();

        }

    }

    public void start(){
        mainFrame = new JFrame("TSI Media Moods");
        mainFrame.setSize(500, 560);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getContentPane().setLayout(new FlowLayout());

        mainPanel = new JPanel();
        mainFrame.getContentPane().add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JLabel("Welcome To Media Moods"));

        emotionPanel = new JPanel();
        mainFrame.add(emotionPanel);
        emotionPanel.setLayout(new GridLayout(1, 3, 10, 10));
        emotionPanel.add(new JLabel("Please Choose an Emotion"));
        emotionCombo = new JComboBox(emotions);
        emotionPanel.add(emotionCombo);
        ok = new JButton("OK");
        emotionPanel.add(ok);

        movieTable = new JTable();
        dtm = new DefaultTableModel(0,0);

        dtm.setColumnIdentifiers(headerTable);
        movieTable.setModel(dtm);

        TableColumnModel columnModel = movieTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(300);
        columnModel.getColumn(1).setPreferredWidth(70);

        JScrollPane scrollpane = new JScrollPane(movieTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainFrame.getContentPane().add(scrollpane);

        for(Movie m: ConnectionProlog.getInstance().getMoviesForList()){
            dtm.addRow(new Object[]{m.getTitle(), m.getGenre0()});
            ((JComponent) scrollpane.getParent()).revalidate();
        }


        //Action Listener for OK button
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) emotionCombo.getSelectedItem();
                ConnectionProlog.getInstance().introEmotion(s.toLowerCase());
                List<Movie> movieEmotionForTable = ConnectionProlog.getInstance().getMoviesForEmotion(ConnectionProlog.getInstance().getMoviesForList());
                    for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
                        dtm.removeRow(i);
                    }
                for(Movie m : movieEmotionForTable){
                    dtm.addRow(new Object[]{m.getTitle(), m.getGenre0()});
                }
                }
                             }

            );


            mainFrame.setVisible(true);
        }
    }
