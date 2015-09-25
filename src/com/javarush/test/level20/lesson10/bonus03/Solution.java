package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word>lw = new ArrayList<>();

        for (String slovo : words)
        {
            int SL = slovo.length() - 1;
            int a = slovo.charAt(0);

            for (int i = 0; i < crossword.length; i++)
            {

                for (int k = 0; k < crossword[i].length; k++)
                {
                    int iks = crossword[i][k];
                    if (a == iks)
                    {
                        if ((i - SL) >= 0)
                        {
                        }
                        if ((i + SL) <= crossword.length)
                        {
                        }
                        if ((k - SL) >= 0)
                        {
                        }
                        if ((k + SL) <= crossword[i].length)
                        {
                        }
                    }
                }
            }
        }
        class Perebor{
            private String word;
            private  int x[][];
            private boolean result;
            private int a;
            private int b;

            public Perebor(int a, int b,String word, int[][] x)
            {
                this.a = a;
                this.b = b;
                this.word = word;
                this.x = x;
            }

            public boolean isResult()
            {
                return result;
            }
            private boolean method1(){
                for(int i=1;i<word.length()-1;i++){
                    int buk = word.charAt(i);
                    int mtr = x[a-i][b-i];
                    if(buk==mtr)return true;
                    else return false;
                }
                return false;
            }
        }

        return lw;
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
