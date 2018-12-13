package com.gmail.wizaripost.game.saper.logic;

import com.gmail.wizaripost.game.saper.utils.SapperHelper;
import com.gmail.wizaripost.game.saper.view.IGameView;

import java.awt.*;


public class SapperLogic {

    private IGameView view;
    private int[][] fieldd;
    private int[][] newField;
    private Component constructField;
    private int add;

    public SapperLogic(int[][] field, IGameView view) {
        this.fieldd = field;
        this.view = view;

    }

    public void start() {
//        view.constructButtonRestart("Restart!");
        add = 0;
        int field[][] = SapperHelper.calculateField(SapperHelper.createField(10, 10, 10));
        int[][] openArr = new int[field.length][field.length];
        view.addBackground(field);


        view.addRestartListener(e -> {
            view.closeBox();
            view.clearBackground();
            int[][] newField = SapperHelper.calculateField(SapperHelper.createField(10, 10, 10));
//            System.out.println("Restart");
            for (int i = 0; i < field[0].length; i++) {
                for (int j = 0; j < field.length; j++) {
                    field[i][j] = 0;
                    field[i][j] = newField[i][j];
                    add = 0;
                    openArr[i][j] = 0;
                    view.restartButtonRestart("Restart!");

                }
            }
            view.addBackground(field);
        });

        view.addRigthClickListener((row, column) -> {
//            view.clearBackground();
//            view.openBox(row, column);
//            field[row][column] += 100;
            if (field[row][column] >= 100) {
                field[row][column] -= 100;
                view.closeBox(row, column);
                view.clearBackground();
                view.addBackground(field);
                if (field[row][column] == 9) {
                    add--;
                }
//                add--;
                System.out.println(add);
            } else {
//            if (field[row][column] < 100) {

                field[row][column] += 100;
                view.clearBackground();
                view.addBackground(field);
//                view.closeBox(row, column);
                view.openBox(row, column);
                if (field[row][column] == 9) {
                    add++;
                }
//                add++;
                System.out.println(add);
            }

            System.out.println("Нажата правая кнопка " + row + " - " + column);
//            view.clearBackground();
//            view.addBackground(field);
        });

        view.addListener((row, column) -> {
            if (field[row][column] >= 100) {
                field[row][column] -= 100;
                view.clearBackground();
                view.addBackground(field);
                view.openBox(row, column);
                if (field[row][column] == 9) {
                    view.restartButtonRestart("Boom!");
                    System.out.println("boom!");
                }
            }

//            view.addRightClick(row, column);


//            view.addBackground(field);
            view.openBox(row, column);
            int[][] open = SapperHelper.openEmptyFields(field, column, row);
            if (field[row][column] != 0 && field[row][column] != 9) {
                view.openBox(row, column);
//                System.out.println(field[row][column]);
                openArr[row][column] = 10;
            }

            if (field[row][column] == 0) {
//                System.out.println("0");
//                int[][] open = SapperHelper.openEmptyFields(field, column, row);
                for (int i = 0; i < field[0].length; i++) {

                    for (int j = 0; j < field.length; j++) {
                        if (open[i][j] == 10) {
                            openArr[i][j] = 10;
                            view.openBox(i, j);

                        }

                    }
                }

            }
            if (field[row][column] == 9) {
//                view.alertWindow();
                System.out.println("Boom2!");
                view.restartButtonRestart("Boom!");
                for (int i = 0; i < field[0].length; i++) {

                    for (int j = 0; j < field.length; j++) {
                        if (field[i][j] == 9) {
                            view.openBox(i, j);
                        }
                    }
                }
                for (int i = 0; i < field[0].length; i++) {

                    for (int j = 0; j < field.length; j++) {
                        if (field[i][j] == 9) {
                            view.openBox(i, j);
                        }
                    }
                }

            }

            int fieldSumm = ((field.length * field[0].length) - add);
            for (int i = 0; i < openArr.length; i++) {
                for (int j = 0; j < openArr[0].length; j++) {

                    if (openArr[i][j] == 10 || field[row][column] == 109) {
                        fieldSumm--;
//                        System.out.println(fieldSumm);
                    }
                    if (fieldSumm <= 10) {
                        int[][] arr = new int[field.length][field.length];
                        for (int ix = 0; ix < openArr.length; ix++) {
                            for (int jx = 0; jx < openArr[0].length; jx++) {
                                view.openBox(ix,jx);
                                if (field[row][column] == 109) {
                                    arr[ix][jx] = 9;
                                } else {
                                    arr[ix][jx] = field[ix][jx];
                                }
                            }
                        }
                        view.clearBackground();
                        view.addBackground(arr);
                        view.restartButtonRestart("Victory!");
                        System.out.println("Win!!");

                    }
                }

            }
// buttons[i][j].addMouseListener(new MouseAdapter(){
//    @Override
//    public void mousePressed(MouseEvent e) {
//        if(e.getButton()==MouseEvent.BUTTON3){
//            ((JButton)e.getSource()).doClick();
//            System.out.println("Я люблю печеньки правой кнопкой мыши");
//        }
//    }
//});
//            if (SwingUtilities.isRightMouseButton(this) == true){
//
//            }
//            if (field[row][column].getButton() == MouseEvent.BUTTON1) {
//
//            }

//            mouseEvent.getModifiers()
//            if(ev.getButton(field[row][column]) == MouseEvent.BUTTON3){
//                System.out.println("azaza");
//            }
//                if(ev.getButton()==MouseEvent.Button1)
// Это левая кнопка. Правая - Button3.


//            System.out.println("Нажата кнопка в строке № " + row + " и столбце № " + column);
        });
    }

}
