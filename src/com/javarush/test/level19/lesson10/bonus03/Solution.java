package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1="";
        try
        {
            file1 = reader.readLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        String tag="";
        if(args!=null)
            if(args.length>0)
                tag=args[0];
        BufferedReader rdr;
        String str1;
        String AllLine="";
        try
        {
            rdr = new BufferedReader(new FileReader(file1));
            while ((str1 = rdr.readLine()) != null)
            {
                AllLine+=str1;
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        String parsTag = "</" +tag+">";
        String pattern2 = "<" +tag+"[^>]*>";

        Matcher m1 = Pattern.compile(pattern2).matcher(AllLine);
        Matcher m2 = Pattern.compile(parsTag).matcher(AllLine);
        ArrayList<Integer>OpenTag = new ArrayList<>();
        ArrayList<Integer>CloseTag = new ArrayList<>();
        while (m1.find())
        {
            int one = m1.start();
            OpenTag.add(one);
        }
        while (m2.find())
        {
            int one = m2.start();
            CloseTag.add(one);
        }


        int s = 0;
        ArrayList<String>tmp = new ArrayList<>();
        for(int i=0;i<CloseTag.size();i++){
            int x=-1; //кол-во открывающих скобок до закрывающих
            int last=-1;
            for(int k=s;k<OpenTag.size();k++)
                if(CloseTag.get(i)>OpenTag.get(k))
                {
                    ++x;
                    last=OpenTag.get(k);
                }
            if(x==i-s)
            {

                System.out.println(AllLine.substring(OpenTag.get(s), CloseTag.get(i) + 3 + tag.length()));
                for(String tm : tmp)
                    System.out.println(tm);
                tmp=new ArrayList<>();
                s+=++x;
            }
            else{
                tmp.add(AllLine.substring(last, CloseTag.get(i) + 3 + tag.length()));
            }


        }

    }
}
