package com.javarush.task.arrays;

import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        int[][] twoDimArray = {
                {5, 7, 3, 17},
                {7, 0, 1, 12},
                {8, 1, 2, 3}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(" " + twoDimArray[i][j] + " ");
            }

        }

        System.out.println(Arrays.deepToString(twoDimArray));

        System.out.println(twoDimArray.length);
        System.out.println(twoDimArray[0].length);

        String[][] chessBoard = new String[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    chessBoard[i][j] = "W" + chessBoardCoord(j, i);
                    System.out.print(chessBoard[i][j]);
                } else {
                    chessBoard[i][j] = "B" + chessBoardCoord(j, i);
                    ;
                    System.out.print(chessBoard[i][j]);
                }
            }
            System.out.println();

        }


        int[][] twoDimArray2 = new int[5][];
        twoDimArray2[0] = new int[]{1, 2, 3, 4, 5};
        twoDimArray2[1] = new int[]{1, 2, 3, 4};
        twoDimArray2[2] = new int[]{1, 2, 3};
        twoDimArray2[3] = new int[]{1, 2};
        twoDimArray2[4] = new int[]{1};

        for (int i = 0; i < twoDimArray2.length; i++) {
            for (int j = 0; j < twoDimArray2[i].length; j++) {
                System.out.print(twoDimArray2[i][j]);
            }
            System.out.println();
        }
    }

    public static String chessBoardCoord(int a, int b) {
        String letters = "abcdefgh";
        String numbers = "87654321";
        if (a > 7 || b > 7) {
            return null;
        } else {
            return (Character.toString(letters.charAt(a)) + numbers.charAt(b));
        }
    }
}
