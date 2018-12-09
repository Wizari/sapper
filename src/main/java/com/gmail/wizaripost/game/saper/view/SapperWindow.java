package com.gmail.wizaripost.game.saper.view;

import com.gmail.wizaripost.game.saper.logic.IClickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class SapperWindow extends JFrame {

    private JPanel fildeButton;
    private JButton[][] buttons = new JButton[10][10];
    private JLabel[][] field = new JLabel[10][10];
    private int[][] calculateField;
    private JPanel contentPanel = new JPanel();
    private JButton restartButton;

    private List<IClickListener> listenerList = new ArrayList<IClickListener>();

    public SapperWindow(int[][] calculateField) {
        this.calculateField = calculateField;

    }

    public SapperWindow(String title) {
        super(title);
        this.restartButton = this.constructButtonRestart();
//        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        this.setLayout(null);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(contentPanel);
        contentPanel.add(this.restartButton);

        int y = 0;
        int id = 0;
        for (int i = 0; i < buttons.length; i++) {
            int x = 0;
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setLayout(null);
                buttons[i][j].setBounds(x, y, 50, 50);
                field[i][j] = new JLabel();
                field[i][j].setLayout(null);
                field[i][j].setBounds(x, y, 50, 50);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(e -> listenerList.forEach(listener -> listener.onClick(finalI, finalJ)));
                contentPanel.add(buttons[i][j]);
//                contentPanel.add(field[i][j]);
//                contentPanel.add(field[i][j]);
                x += 50;
            }
            y += 50;
        }


    }

    private JButton constructButtonRestart() {
        JButton button = new JButton("Restart");
        button.setLayout(null);
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBounds(510, 50, 90, 50);
        return button;

    }

    public void addRestartListener(ActionListener listener) { restartButton.addActionListener(listener); }

    public void addListener(IClickListener listener) {
        this.listenerList.add(listener);
    }

    public void openBox(int y, int x) {
        buttons[y][x].setVisible(false);
    }

    public void addBackground(int[][] calculateField) {

        JLabel back = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\pesok3.jpg"));
        back.setFont(null);
        back.setBounds(0,0,500,500);
//        contentPanel.add(back);

        int y = 0;
        int id = 0;
        for (int i = 0; i < field.length; i ++) {
            int x = 0;
            for (int j = 0; j < field[0].length; j++) {
//                field[i][j] = new JLabel();
//                field[i][j].setLayout(null);
//                field[i][j].setBounds(x, y, 50, 50);

//                contentPanel.add(field[i][j]);

//        for (int i = 0; i < calculateField.length; i++) {
//            for (int j = 0; j < calculateField[0].length; j++) {
////                field[i][j].setLayout(null);
                if (calculateField[i][j] == 1) {
//                    ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\1.png");
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\1.png"));
//                    field[i][j] = new JLabel(new ImageIcon("/1.png"));
//                    field[i][j].setIcon(new ImageIcon("/1.png"));
                    contentPanel.add(field[i][j]);
//                    field[i][j] = new JLabel(new ImageIcon("/1.png"));
                }
                if (calculateField[i][j] == 2) {
                    ImageIcon imageIcon = new ImageIcon();
//                    field[i][j] = new JLabel(new ImageIcon("/2.png"));
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\2.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 3) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\3.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 4) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\4.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 5) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\5.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 6) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\6.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 7) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\7.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 8) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\8.png"));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 9) {
                    field[i][j] = new JLabel(new ImageIcon ("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\92.png"));
                    contentPanel.add(field[i][j]);
                }
                field[i][j].setLayout(null);
                field[i][j].setBounds(x, y, 50, 50);
//     panel.add(field[i][j]);
//            }
//
//        }
                x += 50;
            }
            y += 50;
        }
        contentPanel.add(back);
    }
}