package com.javarush.test.level19.lesson10.bonus02;

import java.io.File;
import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException
    {
        char c [] = {'0','1','2','3','4'};
        String x = "String";
        CharSequence cs = "Sequence";
        File file = new File("D.txt");
        FileConsoleWriter f = new FileConsoleWriter(file);
        f.write(x);//������
        f.write(x,1,2);// ����� ������
        f.write(c);//������
        f.write(c,1,2);//����� �������
        f.write(33);//�����
        f.append('A');
        f.append(cs);
        f.append(cs,1,3);
        f.close();
    }
}
