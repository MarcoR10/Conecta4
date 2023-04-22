package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Conecta4GUI extends JFrame {

    public JMenuBar barra;
    public JMenu menu;
    public MenuItem New,Open,Saved,Exit;

    public Conecta4GUI(){
        prepareElements();
        prepareAccions();
    }

    private void prepareElements() {
        setTitle("Conecta4");
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,Screen.width,Screen.height);
        setLocationRelativeTo(null);
        prepareElementsMenu();
    }

    private void prepareElementsMenu() {
        barra = new JMenuBar();
        menu = new JMenu("Menú");
        barra.add(menu);
        JMenuItem New = new JMenuItem("New");
        JMenuItem Open = new JMenuItem("Open");
        JMenuItem Saved = new JMenuItem("Saved");
        JMenuItem Exit = new JMenuItem("Exit");
        menu.add(New);
        menu.addSeparator();
        menu.add(Open);
        menu.addSeparator();
        menu.add(Saved);
        menu.addSeparator();
        menu.add(Exit);
        setJMenuBar(barra);

    }

    private void prepareAccions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        prepareAccionsMenu();
    }
    private void prepareAccionsMenu() {

        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGame();
            }
        });
        Open.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        Saved.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                saved();
            }
        });
        Exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    private void saved() {
        JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
    }

    private void open() {
        JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
    }

    private void NewGame() {
        JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
    }
    private void exit() {
        if(JOptionPane.showConfirmDialog(rootPane,"Are you sure want exit") == JOptionPane.YES_OPTION){
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else{setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);}
    }

}