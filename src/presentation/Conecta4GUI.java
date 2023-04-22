package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Conecta4GUI extends JFrame {

    public JMenuBar barra;
    public JMenu menu;
    public JMenuItem New, Open, Saved, Exit;

    public Conecta4GUI(){
        prepareElements();
        prepareAccions();
    }

    private void prepareElements() {
        setTitle("Conecta4");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowWidth = screenSize.width / 2;
        int windowHeight = screenSize.width / 2;
        setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        prepareElementsMenu();
    }

    private void prepareElementsMenu() {
        barra = new JMenuBar();
        menu = new JMenu("Menú");
        barra.add(menu);
        New = new JMenuItem("New");
        Open = new JMenuItem("Open");
        Saved = new JMenuItem("Saved");
        Exit = new JMenuItem("Exit");
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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
                New();
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
        JOptionPane.showMessageDialog(null, "Este Item todavía no está implementado");
    }

    private void open() {
        JOptionPane.showMessageDialog(null, "Este Item todavía no está implementado");
    }

    private void New() {
        JOptionPane.showMessageDialog(null, "Este Item todavía no está implementado");
    }
    private void exit() {
        int result = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        }
    }
