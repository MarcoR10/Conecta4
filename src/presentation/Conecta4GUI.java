package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class Conecta4GUI extends JFrame {

    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;

    private int[][] tablero = new int[NUM_ROWS][NUM_COLS];

    private JButton[][] buttons = new JButton[NUM_ROWS][NUM_COLS];
    public JMenuBar barra;
    public JMenu menu;
    public JMenuItem New, Open, Saved, Refresh, tableroColor, Exit;
    public JFileChooser Seleccion;
    public JLabel jugador1Label, jugador2Label, turnoLabel;
    public JPanel infoPanel;

    private enum Player {
        PLAYER_1, PLAYER_2
    }

    private Player currentPlayer = Player.PLAYER_1;

    public Conecta4GUI() {
        prepareElements();
        prepareAccions();
        prepareElementsBoard(5, 5);
        refresh();
    }

    private void prepareElements() {
        setTitle("Conecta4");
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, Screen.width / 2, Screen.height / 2);
        setLocationRelativeTo(null);
        prepareElementsMenu();

        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setPreferredSize(new Dimension(300, 10));


        infoPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                new EmptyBorder(10, 100, 10, 10)));

        jugador1Label = new JLabel("Player 1: Red", SwingConstants.CENTER);
        jugador1Label.setOpaque(true);
        jugador1Label.setBackground(Color.RED);
        jugador1Label.setForeground(Color.WHITE);

        jugador2Label = new JLabel("Player 2: Blue", SwingConstants.CENTER);
        jugador2Label.setOpaque(true);
        jugador2Label.setBackground(Color.BLUE);

        turnoLabel = new JLabel("Turno: 0", SwingConstants.CENTER);

        infoPanel.add(Box.createVerticalGlue());
        infoPanel.add(jugador1Label);
        infoPanel.add(jugador2Label);
        infoPanel.add(turnoLabel);
        infoPanel.add(Box.createVerticalGlue());

        getContentPane().add(infoPanel, BorderLayout.WEST);
    }


    private void prepareElementsMenu() {
        barra = new JMenuBar();
        menu = new JMenu("Menú");
        barra.add(menu);
        New = new JMenuItem("New");
        Open = new JMenuItem("Open");
        Saved = new JMenuItem("Saved");
        Refresh = new JMenuItem("Refresh");
        Exit = new JMenuItem("Exit");
        tableroColor = new JMenuItem("Cambiar el color del tablero");
        JMenuItem fichasColor = new JMenuItem("Cambiar el color de las fichas");
        menu.add(New);
        menu.addSeparator();
        menu.add(Open);
        menu.addSeparator();
        menu.add(Saved);
        menu.addSeparator();
        menu.add(Refresh);
        menu.addSeparator();
        menu.add(tableroColor);
        menu.addSeparator();
        menu.add(fichasColor);
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
        Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        Saved.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saved();
            }
        });
        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        tableroColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorTablero(5,5);
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    private void prepareElementsBoard(int numRows, int numCols) {

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        int buttonWidth = 150 / numCols;
        int buttonHeight = 350 / numRows;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                buttons[row][col] = new JButton();
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.weightx = 3.0 / numCols;
                gbc.weighty = 3.0 / numRows;
                gbc.ipadx = buttonWidth;
                gbc.ipady = buttonHeight;
                panel.add(buttons[row][col], gbc);
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getBackground().equals(UIManager.getColor("Button.background"))) {
                            if (currentPlayer == Player.PLAYER_1) {
                                clickedButton.setBackground(Color.RED);
                                currentPlayer = Player.PLAYER_2;
                            } else {
                                clickedButton.setBackground(Color.BLUE);
                                currentPlayer = Player.PLAYER_1;
                            }
                        }
                    }
                });
            }
        }

        int margin = 100;
        panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

        getContentPane().add(panel, BorderLayout.EAST);
    }

    private void saved() {
        Seleccion = new JFileChooser();
        Seleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int opcion = Seleccion.showSaveDialog(this);
        if (opcion != JFileChooser.CANCEL_OPTION) {
            File Archivo = Seleccion.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
        }
    }

    private void open() {
        Seleccion = new JFileChooser();
        Seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int opcion = Seleccion.showOpenDialog(this);
        if (opcion != JFileChooser.CANCEL_OPTION) {
            File Archivo = Seleccion.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Este Item todavía no esta implementado");
        }
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

    private void cambiarColorTablero(int numRows, int numCols) {
        Color newColor = JColorChooser.showDialog(this, "Seleccionar un color para el tablero", getBackground());
        if (newColor != null) {
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++)
                    buttons[row][col].setBackground(newColor);
            }
        }
    }

    private void refresh() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                tablero[row][col] = 0;
                buttons[row][col].setBackground(UIManager.getColor("Button.background"));
                buttons[row][col].setEnabled(true);
            }
        }
        currentPlayer = Player.PLAYER_1;
        jugador1Label.setBackground(Color.RED);
        jugador2Label.setBackground(Color.BLUE);
        turnoLabel.setText("Turno: 0");
    }
}
