package com.gmail.wizaripost.game.saper.logic;

import com.gmail.wizaripost.game.saper.Sapper;
import com.gmail.wizaripost.game.saper.utils.SapperHelper;
import com.gmail.wizaripost.game.saper.view.SapperWindow;

import java.awt.*;

public class SapperLogic {

    private SapperWindow window;
    private int[][] field;
    private Component constructField;

    public SapperLogic(int[][] field, SapperWindow window) {
        this.field = field;
        this.window = window;

    }

    public void start() {
        window.addBackground(field);
        int[][] openArr = new int[field.length][field.length];
        window.addRestartListener(e -> {
            System.out.println("Restart");
//            Sapper.restart();
        });

        window.addListener((row, column) -> {
            window.openBox(row, column);
            int[][] open = SapperHelper.openEmptyFields(field, column, row);
            if (field[row][column] != 0 && field[row][column] != 9) {
                window.openBox(row, column);
                System.out.println(field[row][column]);
                openArr[row][column] = 10;
            }

            if (field[row][column] == 0) {
                System.out.println("0");
//                int[][] open = SapperHelper.openEmptyFields(field, column, row);
                for (int i = 0; i < field[0].length; i++) {

                    for (int j = 0; j < field.length; j++) {
                        if (open[i][j] == 10) {
                            openArr[i][j] = 10;
                            window.openBox(i, j);

                        }

                    }
                }
//                window.openBox(row, column);
            }
            if (field[row][column] == 9) {

                System.out.println("Boom!");
                for (int i = 0; i < field[0].length; i++) {

                    for (int j = 0; j < field.length; j++) {
                        if (field[i][j] == 9) {
                            window.openBox(i, j);
                        }
                    }
                }
                for (int i = 0; i < field[0].length; i++) {

                    for (int j = 0; j < field.length; j++) {
                        if (field[i][j] == 9) {
                            window.openBox(i, j);
                        }
                    }
                }

            }
            int fieldSumm = (field.length*field[0].length);
            for (int i = 0; i < openArr.length; i++) {
                for (int j = 0; j < openArr[0].length; j++) {

                    if (openArr[i][j] == 10) {
                        fieldSumm--;
                        System.out.println(fieldSumm);
                    }
                    if (fieldSumm <= 10) {
                        System.out.println("Win!!");

                    }
                }

            }
//            System.out.println("Нажата кнопка в строке № " + row + " и столбце № " + column);
        });
    }

}
