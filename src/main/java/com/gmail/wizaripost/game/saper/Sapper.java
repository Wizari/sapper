package com.gmail.wizaripost.game.saper;

import com.gmail.wizaripost.game.saper.logic.SapperLogic;
import com.gmail.wizaripost.game.saper.utils.SapperHelper;
import com.gmail.wizaripost.game.saper.view.SapperWindow;

import javax.swing.*;

public class Sapper {
    //    public int[][] calculateField;

    public SapperWindow gameWindow;
//private SapperWindow gameWindow = new SapperWindow("Sapper");
//    private int[][] calculateField;

    public static void main(String[] args) {

        SapperWindow gameWindow = new SapperWindow("Sapper");

        int[][] calculateField = SapperHelper.calculateField(SapperHelper.createField(10, 10, 10));

        SapperLogic logic = new SapperLogic(calculateField, gameWindow);

        gameWindow.setVisible(true);

        logic.start();

    }
//
//    public static void restart() {
//        int[][] calculateField = SapperHelper.calculateField(SapperHelper.createField(10, 10, 10));
//
//        SapperLogic logic = new SapperLogic(calculateField);
//
//        logic.start();
//    }


}
