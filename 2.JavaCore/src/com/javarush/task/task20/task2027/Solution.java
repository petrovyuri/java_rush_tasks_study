package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        List<Word> list = new ArrayList<>();

        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        list = detectAllWords(crossword, "home", "same");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                System.out.print((char) crossword[i][j]);
            }
            System.out.println();
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> out = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (word.charAt(0) == crossword[i][j]) {
                        List<Word> wordsAssumed = findWholeWords(word, crossword, i, j);
                        if (wordsAssumed != null) {
                            out.addAll(wordsAssumed);
                        }
                    }
                }

            }
        }
        return out;
    }

    private static List<Word> findWholeWords(String word, int[][] crossword, int i, int j) {
        List<Word> out = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Word wordAssumed = findWordInDirection(word, crossword, i, j,direction);
            if (wordAssumed != null) out.add(wordAssumed);
        }
        return out.size() > 0 ? out : null;
    }

    private static Word findWordInDirection(String word, int[][] crossword, int i, int j, Direction dir) {
        StringBuilder wordBuilder = new StringBuilder();
        for (int k = i, l = j;
             k >= 0 && l >= 0 && k < crossword.length && l < crossword[k].length;
             k += dir.getI(), l += dir.getJ()) {
            wordBuilder.append((char) crossword[k][l]);
        }
        Word out = null;
        if (wordBuilder.toString().startsWith(word)) {
            int wordLength = word.length();
            out = new Word(word);
            out.setStartPoint(j, i);
            out.setEndPoint(j + dir.getJ() * (wordLength-1), i + dir.getI() * (wordLength-1));
        }
        return out;
    }


    public enum Direction {
        West(0, -1),
        East(0, 1),
        South(1, 0),
        North(-1, 0),
        NorthWest(-1, -1),
        NorthEast(-1, 1),
        SouthWest(1, -1),
        SouthEast(1, 1);
        private final int i;
        private final int j;

        Direction(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
