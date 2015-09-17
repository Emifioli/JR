package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String>file1List = new ArrayList<>();
        ArrayList<String>file2List = new ArrayList<>();
        String str1 = "";
        String str2 = "";
        while ( (str1=reader1.readLine())!=null){
            file1List.add(str1);
        }
        while ( (str2=reader2.readLine())!=null){
            file2List.add(str2);
        }
         if(  ( file1List.size()*2+1 ) == file2List.size()  ){
             for(int i=0;i<file2List.size();i++) {
                 lines.add(new LineItem(Type.ADDED,file2List.get(i)));
                 ++i;
                 if(!(file2List.size()==i))
                 lines.add(new LineItem(Type.SAME,file2List.get(i)));
             }
         }
         if( file1List.size() == (file2List.size()/2) ){
             if(file1List.get(0).equals(file2List.get(0))){
                 for(int i=0;i<file2List.size();i++) {
                     lines.add(new LineItem(Type.SAME,file2List.get(i)));
                     i++;
                     lines.add(new LineItem(Type.ADDED,file2List.get(i)));
                 }
             }
             else {
                 for(int i=0;i<file2List.size();i++) {
                     lines.add(new LineItem(Type.ADDED,file2List.get(i)));
                     ++i;
                     lines.add(new LineItem(Type.SAME,file2List.get(i)));
                 }
             }

         }



        for(LineItem x : lines){
            System.out.println(x.type);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
