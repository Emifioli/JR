package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.
Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String line = "";
        ArrayList<String>list = new ArrayList<String>();
        while ((line=fileReader.readLine())!=null){
            String x[] = line.split(" ");
            for(String y : x){
                list.add(y);
            }
        }
        String y [] = new String[list.size()];
        for(int i=0;i<list.size();i++){
            y[i]=list.get(i);
        }

        StringBuilder result = getLine(y);
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) {
          StringBuilder x = new StringBuilder();
          for(int i=0;i<words.length;i++){
               for(int k=words.length-1;k>i;k--){
                   char one = words[i].toLowerCase().charAt(words[i].length()-1);
                   char two = words[k].toLowerCase().charAt(0);
                   if(one==two){
                       String qwe = words[i+1];
                       words[i+1]=words[k];
                       words[k]=qwe;
                   }
               }
          }
           for(int i=0;i<words.length;i++){
               if(i==words.length-1)
                   x.append(words[i]);
               else x.append(words[i]+" ");
           }

          return x;
    }
}
