package com.javarush.test.level22.lesson13.task03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        Matcher m1 = Pattern.compile("^\\+").matcher(telNumber);
        Matcher m2 = Pattern.compile("^[0-9\\(]").matcher(telNumber);
        Matcher m3 = Pattern.compile("[0-9]").matcher(telNumber);
        Matcher m4 = Pattern.compile("--").matcher(telNumber);
        Matcher m5 = Pattern.compile("-").matcher(telNumber);
        Matcher m6 = Pattern.compile("[\\(\\)]").matcher(telNumber);
        Matcher m61 = Pattern.compile("\\(").matcher(telNumber);
        Matcher m62 = Pattern.compile("\\)").matcher(telNumber);
        Matcher m7 = Pattern.compile("\\([0-9]{3}\\)").matcher(telNumber);
        Matcher m8 = Pattern.compile(".*-.*\\([0-9]{3}\\)").matcher(telNumber);
        Matcher m91 = Pattern.compile("[^0-9\\(\\)\\-\\+]").matcher(telNumber);
        Matcher m92 = Pattern.compile("[^0-9\\(\\)\\-]").matcher(telNumber);
        Matcher m93 = Pattern.compile("\\+").matcher(telNumber);
        Matcher m10 = Pattern.compile("[0-9]$").matcher(telNumber);

        if(m1.find()){
            int i=0;
            while (m3.find()){++i;}
            if(i!=12)return false;
            if(m4.find())return false;
            int k=0;
            while (m5.find()){++k;}
            if(k>2)return false;
            if(m6.find()){
                int a=0;
                int b=0;
                while (m61.find()){++a;}
                while (m62.find()){++b;}
                if(a!=1)return false;
                if(b!=1)return false;

                if(m7.find()){
                    if(m8.find())return false;
                }else return false;
            }
            if(m91.find())return false;
            if(!(m10.find()))return false;
            int j=0;
            while (m93.find()){++j;}
            if(j>1)return false;
            return true;
        }
        if(m2.find()){
            int i=0;
            while (m3.find()){++i;}
            if(i!=10)return false;
            if(m4.find())return false;
            int k=0;
            while (m5.find()){++k;}
            if(k>2)return false;
            if(m6.find()){
                int a=0;
                int b=0;
                while (m61.find()){++a;}
                while (m62.find()){++b;}
                if(a!=1)return false;
                if(b!=1)return false;

                if(m7.find()){
                    if(m8.find())return false;
                }else return false;
            }
            if(m92.find())return false;
            if(!(m10.find()))return false;

            return true;
        }
        return false;
    }
}
