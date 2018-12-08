package com.gmail.wizaripost.game.saper.utils;

import java.util.ArrayList;
import java.util.Random;

public class SapperHelper {
    /**
     * Метод создает двумерный пустой массив с запрошенымколичеством рандомно расставлннызх едениц
     *
     * @param fieldLength длинна матрицы
     * @param fieldHeight ширина матрицы
     * @param amountMines Количество 1
     * @return заполненная матрица
     */
    public static int[][] createField(int fieldLength, int fieldHeight, int amountMines) {
        int[][] arr = new int[fieldLength][fieldHeight];
        int mines = amountMines;
        for (int i = 0; i < mines; i++) {
            int l = SapperHelper.generateRandom(0, fieldLength - 1);
            int h = SapperHelper.generateRandom(0, fieldHeight - 1);

            arr[h][l] += 1;
            if (arr[h][l] == 2) {
                arr[h][l] = 1;
                mines++;
            }
        }
        return arr;
    }

    public static int generateRandom(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        Random rnd = new Random();
        int number = min + rnd.nextInt(max - min + 1);
        return number;
    }

    /**
     * Метод заполняет не занятые минами ячейки, числами равными количеству мин находящихся вокруг ячейки
     *
     * @param matrix матрица где мины обозначены числами > 8, пустные ячейки обозначены 0
     * @return заполненная матрица
     */
    public static int[][] calculateField(int[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = 0;

                if (i != 0) {
                    sum += matrix[i - 1][j];
                }
                if (i != matrix.length - 1) {
                    sum += matrix[i + 1][j];
                }
                if (j != 0) {
                    sum += matrix[i][j - 1];
                }
                if (j != matrix[0].length - 1) {
                    sum += matrix[i][j + 1];
                }


                if (i != 0 && j != 0) {
                    sum += matrix[i - 1][j - 1];
                }
                if (i != 10 - 1 && j != 10 - 1) {
                    sum += matrix[i + 1][j + 1];
                }
                if (i != 0 && j != matrix[0].length - 1) {
                    sum += matrix[i - 1][j + 1];
                }
                if (i != matrix.length - 1 && j != 0) {
                    sum += matrix[i + 1][j - 1];
                }
                arr[i][j] = sum;
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    arr[i][j] = 9;
                }
            }
        }
        return arr;
    }

    /**
     * Метод при нажатии на пустую клетку открывает всю прилегающую зону пустых полей
     *
     * @return открытые поля заполняются цифрой 10
     */
    public static int[][] openEmptyFields(int[][] matrix, int xAxis, int yAxis) {
//        int yAxis = 9;
//        int xAxis = 8;

        ArrayList<Integer> yCoord = new ArrayList<Integer>();
        ArrayList<Integer> xCoord = new ArrayList<Integer>();

        yCoord.add(yAxis);
        xCoord.add(xAxis);
        int[][] openField = new int[matrix.length][matrix[0].length];

        int j = 0;
        for (int i = 0; i < yCoord.size(); i++, j++) {
            final int y = yCoord.get(i);
            final int x = xCoord.get(j);
            openField[yAxis][xAxis] = 10;

            if (matrix[yCoord.get(0)][xCoord.get(0)] == 0) {

                if (y != 0 && openField[y - 1][x] != 10) {
                    if (matrix[y - 1][x] == 0) {
                        yCoord.add(y - 1);
                        xCoord.add(x);
                    }
                    openField[y - 1][x] = 10;
                }
                if (y != matrix.length - 1 && openField[y + 1][x] != 10) {
                    if (matrix[y + 1][x] == 0) {
                        yCoord.add(y + 1);
                        xCoord.add(x);
                    }
                    openField[y + 1][x] = 10;

                }
                if (x != 0 && openField[y][x - 1] != 10) {
                    if (matrix[y][x - 1] == 0) {
                        yCoord.add(y);
                        xCoord.add(x - 1);
                    }
                    openField[y][x - 1] = 10;


                }
                if (x != matrix[0].length - 1 && openField[y][x + 1] != 10) {
                    if (matrix[y][x + 1] == 0) {
                        yCoord.add(y);
                        xCoord.add(x + 1);
                    }
                    openField[y][x + 1] = 10;

                }

                if (y != 0 && x != 0 && openField[y - 1][x - 1] != 10) {
                    if (matrix[y - 1][x - 1] == 0) {
                        yCoord.add(y - 1);
                        xCoord.add(x - 1);
                    }
                    openField[y - 1][x - 1] = 10;

                }
                if (y != 10 - 1 && x != 10 - 1 && openField[y + 1][x + 1] != 10) {
                    if (matrix[y + 1][x + 1] == 0) {
                        yCoord.add(y + 1);
                        xCoord.add(x + 1);
                    }
                    openField[y + 1][x + 1] = 10;

                }
                if (y != 0 && x != matrix[0].length - 1 && openField[y - 1][x + 1] != 10) {
                    if (matrix[y - 1][x + 1] == 0) {
                        yCoord.add(y - 1);
                        xCoord.add(x + 1);
                    }
                    openField[y - 1][x + 1] = 10;

                }
                if (y != matrix.length - 1 && x != 0 && openField[y + 1][x - 1] != 10) {
                    if (matrix[y + 1][x - 1] == 0) {
                        yCoord.add(y + 1);
                        xCoord.add(x - 1);
                    }
                    openField[y + 1][x - 1] = 10;

                }
            }
        }

        return openField;
    }

//    public static ArrayList shuffleArrayList(ArrayList numbers, int count) {
//        if (count < numbers.size() * 2) {
//            count = numbers.size() * 2;
//        }
//        for (int i = 0; i < count; i++) {
//            int i1 = SapperHelper.generateRandom(0, numbers.size() - 1);
//            int i2 = SapperHelper.generateRandom(0, numbers.size() - 1);
//            ArrayList temp = (ArrayList) numbers.get(i1);
//            numbers.set(i1, numbers.get(i2));
//            numbers.set(i2, temp);
//        }
//        return numbers;
//    }


//    public static ArrayList generateRandomNumbers(int fieldLength, int fieldHeight, int amountMines) {
//        List<Integer> arr = new ArrayList(fieldLength*fieldHeight);
//
//        for (int i = 0; i < arr.size(); i++) {
////            arr.
//
//        }
//
//
//        return null;
//    }
}
