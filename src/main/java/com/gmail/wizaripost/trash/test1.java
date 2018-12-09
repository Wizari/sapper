package com.gmail.wizaripost.trash;

import com.gmail.wizaripost.game.saper.utils.SapperHelper;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {

//        int fieldLength = 10;
//            int fieldHeight = 10;
//            int amountMines = 10;
//        int[][] matrix = new int[fieldLength][fieldHeight];
//        public static int[][] calculateField(int[][] matrix) {

        int[][] matrix = SapperHelper.createField(10, 10, 10);
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

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(arr[i][j]);
            }

        }


        int yAxis = 4;
        int xAxis = 4;

//        List<Integer> yCoord = Arrays.asList();
//        List<Integer> xCoord = Arrays.asList();

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

            if (arr[yCoord.get(0)][xCoord.get(0)] == 0) {

                if (y != 0 && openField[y - 1][x] != 10) {
                    if (arr[y - 1][x] == 0) {
                        yCoord.add(y - 1);
                        xCoord.add(x);
                    }
                    openField[y - 1][x] = 10;
                }
                if (y != matrix.length - 1 && openField[y + 1][x] != 10) {
                    if (arr[y + 1][x] == 0) {
                        yCoord.add(y + 1);
                        xCoord.add(x);
                    }
                    openField[y + 1][x] = 10;

                }
                if (x != 0 && openField[y][x - 1] != 10) {
                    if (arr[y][x - 1] == 0) {
                        yCoord.add(y);
                        xCoord.add(x - 1);
                    }
                    openField[y][x - 1] = 10;


                }
                if (x != matrix[0].length - 1 && openField[y][x + 1] != 10) {
                    if (arr[y][x + 1] == 0) {
                        yCoord.add(y);
                        xCoord.add(x + 1);
                    }
                    openField[y][x + 1] = 10;

                }


                if (y != 0 && x != 0 && openField[y - 1][x - 1] != 10) {
                    if (arr[y - 1][x - 1] == 0) {
                        yCoord.add(y - 1);
                        xCoord.add(x - 1);
                    }
                    openField[y - 1][x - 1] = 10;

                }
                if (y != 10 - 1 && x != 10 - 1 && openField[y + 1][x + 1] != 10) {
                    if (arr[y + 1][x + 1] == 0) {
                        yCoord.add(y + 1);
                        xCoord.add(x + 1);
                    }
                    openField[y + 1][x + 1] = 10;
//                    sum += matrix[y + 1][x + 1];
                }
                if (y != 0 && x != matrix[0].length - 1 && openField[y - 1][x + 1] != 10) {
                    if (arr[y - 1][x + 1] == 0) {
                        yCoord.add(y - 1);
                        xCoord.add(x + 1);
                    }
                    openField[y - 1][x + 1] = 10;
//                    sum += matrix[i - 1][x + 1];
                }
                if (y != matrix.length - 1 && x != 0 && openField[y + 1][x - 1] != 10) {
                    if (arr[y + 1][x - 1] == 0) {
                        yCoord.add(y + 1);
                        xCoord.add(x - 1);
                    }
                    openField[y + 1][x - 1] = 10;
//                    sum += matrix[y + 1][x - 1];
                }
            }


        }


//            if (arr [y][x] == 0) {
//
//                if (y != 0) {
//                    if (arr[y - 1][x] == 0) {
//                        yCoord.add(y - 1);
//                        xCoord.add(x);
//                    }
//                    openField[y - 1][x] = 10;
//                }
//                if (y != matrix.length - 1) {
//                    if (arr[y + 1][x] == 0) {
//                        yCoord.add(y + 1);
//                        xCoord.add(x);
//                    }
//                    openField[y + 1][x] = 10;
//
//                }
//                if (y != 0) {
//                    if (arr[y][x - 1] == 0) {
//                        yCoord.add(y);
//                        xCoord.add(x - 1);
//                    }
//                    openField[y][x - 1] = 10;
//
//                }
//                if (y != matrix[0].length - 1) {
//                    if (arr[y][x + 1] == 0) {
//                        yCoord.add(y);
//                        xCoord.add(x + 1);
//                    }
//                    openField[y][x + 1] = 10;
//
//                }
//
//
//                if (y != 0 && x != 0) {
//                    if (arr[y - 1][x - 1] == 0) {
//                        yCoord.add(y - 1);
//                        xCoord.add(x - 1);
//                    }
//                    openField[y - 1][x - 1] = 10;
//
//                }
//                if (y != 10 - 1 && x != 10 - 1) {
//                    if (arr[y + 1][x + 1] == 0) {
//                        yCoord.add(y + 1);
//                        xCoord.add(x + 1);
//                    }
//                    openField[y + 1][x + 1] = 10;
////                    sum += matrix[y + 1][x + 1];
//                }
//                if (y != 0 && x != matrix[0].length - 1) {
//                    if (arr[y - 1][x + 1] == 0) {
//                        yCoord.add(y - 1);
//                        xCoord.add(x + 1);
//                    }
//                    openField[y - 1][x + 1] = 10;
////                    sum += matrix[i - 1][x + 1];
//                }
//                if (y != matrix.length - 1 && x != 0) {
//                    if (arr[y + 1][x - 1] == 0) {
//                        yCoord.add(y + 1);
//                        xCoord.add(x - 1);
//                    }
//                    openField[y + 1][x - 1] = 10;
////                    sum += matrix[y + 1][x - 1];
//                }
//            }
//
//
//        }
        System.out.println(" ");
        for (int i = 0; i < openField.length; i++) {
            System.out.print(">");
//            System.out.println(">");
//            System.out.println(" <<");
            for (int gg = 0; gg < openField[0].length; gg++) {
//                System.out.print("");
                System.out.print(openField[i][gg]);
                if (openField [i][gg] == 0) {
                    System.out.print(" ");
                }
                System.out.print(", ");
            }
            System.out.println(" <<");
        }


    }

}