package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<Pair>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String x = "";
        ArrayList<String>bank = new ArrayList<String>();
        ArrayList<String>rev = new ArrayList<String>();

        while ((x=fileReader.readLine())!=null){
            String line[]=x.split(" ");
            for(String str : line){
                bank.add(str);
                StringBuilder one = new StringBuilder(str);
                one = one.reverse();
                rev.add(one.toString());
            }
        }
        for(int i=0;i<bank.size();i++){
            for(int k=rev.size()-1;k>i;k--){
               if(bank.get(i).equals(rev.get(k))){
                   StringBuilder x1 = new StringBuilder(rev.get(k));
                   x1=x1.reverse();
                   Pair dsa = new Pair();
                   dsa.first = bank.get(i);
                   dsa.second=x1.toString();
                   result.add(dsa);
               }
            }
        }
        for(Pair qwe : result){
            System.out.println(qwe);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
