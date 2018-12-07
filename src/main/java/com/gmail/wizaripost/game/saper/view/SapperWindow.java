package com.gmail.wizaripost.game.saper.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SapperWindow extends JFrame {

    private JPanel fildeButton;
    private JButton[][] buttons = new JButton[10][10];


    public SapperWindow(String title) {
        super(title);

//        this.fildeButton = this.constructField()

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(contentPanel);
        contentPanel.add(constructField());

    }

    private Component constructField() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(500, 500);
//        ActionListener id = new ActionListener()

//        JButton[][] buttons = new JButton[10][10];//это только массив создан.
        int y = 0;
        int id = 0;
        for (int i = 0; i < buttons.length; i++) {
            int x = 0;
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setLayout(null);
                buttons[i][j].setBounds(x, y, 50, 50);
//                buttons[i][j].addActionListener(listener);
//                buttons[i][j].addActionListener(id);
                panel.add(buttons[i][j]);
                x += 50;
//                id++;

            }
            y += 50;
        }
        return panel;
    }

//    public void addHitListener(ActionListener listener, int id) {
//        int x = 0;
//        for (int i = 0; i < buttons.length; i++) {
//            for (int j = 0; j < buttons[0].length; j++) {
//                buttons[i][j].addActionListener(listener, x);
//
//                x++;
//            }
//        }
//    }
}