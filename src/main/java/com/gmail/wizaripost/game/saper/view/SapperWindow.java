package com.gmail.wizaripost.game.saper.view;

import javax.swing.*;

public class SapperWindow extends JFrame {


    public SapperWindow(String title) {
        super(title);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        this.setLayout(null);
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(contentPanel);

    }


}