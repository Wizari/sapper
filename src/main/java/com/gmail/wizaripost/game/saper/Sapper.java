package com.gmail.wizaripost.game.saper;

import com.gmail.wizaripost.game.saper.logic.SapperLogic;
import com.gmail.wizaripost.game.saper.utils.SapperHelper;
import com.gmail.wizaripost.game.saper.view.IGameView;
import com.gmail.wizaripost.game.saper.view.SapperWindow;
import com.gmail.wizaripost.game.saper.view.SapperWindow2;

import javax.swing.*;

public class Sapper {
    //    public int[][] calculateField;

    public SapperWindow gameWindow;
//private SapperWindow gameWindow = new SapperWindow("Sapper");
//    private int[][] calculateField;

    public static void main(String[] args) {

        IGameView gameWindow = new SapperWindow("Sapper");
        IGameView gameWindow2 = new SapperWindow2();

        int game1 = 1;
        int game2 = 2;


        int[][] calculateField = SapperHelper.calculateField(SapperHelper.createField(10, 10, 10));

        SapperLogic logic = new SapperLogic(calculateField, gameWindow2);

        ((SapperWindow) gameWindow).setVisible(true);

        ((SapperWindow) gameWindow).helloVania();

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
