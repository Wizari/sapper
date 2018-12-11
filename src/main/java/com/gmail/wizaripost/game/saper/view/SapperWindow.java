package com.gmail.wizaripost.game.saper.view;

import com.gmail.wizaripost.game.saper.logic.IClickListener;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Modality;
import javafx.stage.*;
//import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class SapperWindow extends JFrame {

    private JPanel fildeButton;
    private JButton[][] buttons = new JButton[10][10];
    private JLabel[][] field = new JLabel[10][10];
    private int[][] calculateField;
    private JPanel contentPanel = new JPanel();
    private JButton restartButton;
//    private JButton victoryButton;
    private JLabel back;
//    public static final int DEFAULT_WIDTH = 700;
//    public static final int DEFAULT_HEIGHT = 600;
//    private JPanel panel;

//    private AboutDialog dialog;

    private List<IClickListener> listenerList = new ArrayList<IClickListener>();
    private List<IClickListener> rightClickListeners = new ArrayList<IClickListener>();

    public SapperWindow(int[][] calculateField) {
        this.calculateField = calculateField;

    }

    public SapperWindow(String title) {
        super(title);
        this.restartButton = this.constructButtonRestart("Restart");
//        this.restartButton = this.constructButtonWinn("Victory!");
//        this.restartButton = this.alertPanel;
        contentPanel.setLayout(null);
        this.setLayout(null);
        this.setSize(635, 540);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(contentPanel);
//        contentPanel.add(panel);
        contentPanel.add(this.restartButton);
//        contentPanel.add(this.victoryButton);

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
                buttons[i][j].addActionListener(e -> {
                    listenerList.forEach(listener -> listener.onClick(finalI, finalJ));
                });
                buttons[i][j].addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            rightClickListeners.forEach(listener -> listener.onClick(finalI, finalJ));
                        }
                    }
                });

                contentPanel.add(buttons[i][j]);

                x += 50;
            }
            y += 50;
        }


    }

    public void restartButtonRestart(String title) {
        restartButton.setText(title);

}

    private JButton constructButtonRestart(String title) {
        JButton button = new JButton(title);
//        button
        button.setLayout(null);
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBounds(510, 50, 100, 50);
//        restartButton.setVisible(true);
//        contentPanel.remove(restartButtonRestart());
//        contentPanel.remove(restartButtonRestart());
        return button;

    }

//    private JButton constructButtonWinn(String title) {
//        JButton button = new JButton(title);
////        button
//        button.setLayout(null);
//        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 14));
//        button.setFocusPainted(false);
//        button.setBounds(510, 50, 90, 50);
////        restartButton.setVisible(true);
////        contentPanel.remove(restartButtonRestart());
////        contentPanel.remove(restartButtonRestart());
//        return button;
//
//    }

    public void addRestartListener(ActionListener listener) {
        restartButton.addActionListener(listener);
    }

    public void addListener(IClickListener listener) {
        this.listenerList.add(listener);
    }

    public void addRigthClickListener(IClickListener listener) {
        this.rightClickListeners.add(listener);
    }

    public void openBox(int y, int x) {
//        buttons[y][x].setVisible(false);
        buttons[y][x].setOpaque(false);
        buttons[y][x].setContentAreaFilled(false);
        buttons[y][x].setBorderPainted(false);
    }

    public void closeBox() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j].setOpaque(true);
                buttons[i][j].setContentAreaFilled(true);
                buttons[i][j].setBorderPainted(true);
//                buttons[i][j].setVisible(true);
            }

        }

    }

    public void closeBox(int y, int x) {
//                buttons[y][x].setVisible(true);
        buttons[y][x].setOpaque(true);
        buttons[y][x].setContentAreaFilled(true);
        buttons[y][x].setBorderPainted(true);
    }

    public void clearBackground() {
        contentPanel.remove(back);
    }
//    public void addBucket(int[][] calculateField) {
//
//        field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\bucket.png"));
//        contentPanel.add(field[i][j]);
//    }

    public void addBackground(int[][] calculateField) {
        JLabel back = new JLabel(new ImageIcon(this.getClass().getResource("/pesok3.jpg")));
        this.back = back;
        back.setFont(null);
        back.setBounds(0, 0, 500, 500);
        int y = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

            }
        }
        for (int i = 0; i < field.length; i++) {
            int x = 0;
            for (int j = 0; j < field[0].length; j++) {

                field[i][j].setIcon(null);
                if (calculateField[i][j] >= 100) {
//                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\bucket.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/bucket.png")));
//                    .getResource("/16070.png")
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 0) {
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 1) {
                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\1.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/1.png")));
                    contentPanel.add(field[i][j]);
                }
                if (calculateField[i][j] == 2) {
                    ImageIcon imageIcon = new ImageIcon();

                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\2.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/2.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 3) {
                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\3.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/3.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 4) {
                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\4.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/4.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 5) {
                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\5.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/5.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 6) {
                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\6.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/6.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 7) {
                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\7.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/7.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 8) {
//                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\8.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/8.png")));
                    contentPanel.add(field[i][j]);
                }

                if (calculateField[i][j] == 9) {
//                    field[i][j] = new JLabel(new ImageIcon("C:\\Users\\Ivan\\Desktop\\dd\\numbers\\cop\\92.png"));
                    field[i][j] = new JLabel(new ImageIcon(this.getClass().getResource("/92.png")));
                    contentPanel.add(field[i][j]);
                }

                field[i][j].setLayout(null);
                field[i][j].setBounds(x, y, 50, 50);
                x += 50;
            }
            y += 50;
        }
        contentPanel.add(back);
    }

    //    public void alertWindow() {
//        JButton alert = new JButton("Фух остался чистеньким!");
////        alert.setPreferredSize(220,200);
//        alert.setLayout(null);
//        alert.setBounds(300, 225, 100, 50);
//        contentPanel.add(alert);
//
//    }
//    public Component alertPanel() {
//
//
//        return alertP;
//    }

    public void alertWindow() {


//        JLabel alert = new JLabel();
////        alert.add(owner);
//        Button owner = new Button();
////        owner.setLayout(null);
////        owner.setBounds(525, 225, 200, 100);
//        owner.setOnAction(e -> SapperAlert.display("gg", "ty"));
//        alert.add(owner);
//        contentPanel.add(owner);
////            owner.super(owner, "About DialogTest", true);
//        owner.add(new JLabel(
//                        "<html><h1><i>Все о Java</i></h1><hr>"
//                                + "Pro-java.ru уроки Java</html>"),
//                BorderLayout.CENTER);
//        JButton ok = new JButton("ok");
//        ok.setLayout(null);
//        ok.setBounds(100, 50, 100, 50);
//        ok.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent event) {
//                setVisible(false);
//            }
//        });
//
//        JPanel panelX = new JPanel();
//        panel.add(ok);
////            contentPanel.add(panel, BorderLayout.SOUTH);
//        panel.setSize(200, 100);
    }
}