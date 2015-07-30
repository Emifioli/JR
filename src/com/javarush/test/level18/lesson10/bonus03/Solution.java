package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException
    {

        List<String> textFile = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(nameFile));
        while (true){
            String text = reader.readLine();
            if(text == null){
                break;
            }
            textFile.add(text);
        }

        for (int i = 0; i < textFile.size(); i++) {
            if ("-u".equals(args[0]) && args.length >= 5&& getId(textFile.get(i), args[1])){
                textFile.set(i, updateProduct(args));
            } else if ("-d".equals(args[0]) && args.length == 2 && getId(textFile.get(i), args[1])){
                textFile.remove(i);
            }
        }

        reader.close();

        OutputStream writer = new FileOutputStream(nameFile);
        for (String aTextFile : textFile) {
            writer.write(aTextFile.getBytes());
            writer.write("\r\n".getBytes());
        }
        writer.flush();
        writer.close();

    }

    public static boolean getId(String text, String newID){
        boolean tr;
        String id = text.substring(0, 8);
        id = id.trim();
        int y=0;
        try {
            y = Integer.parseInt(id);
            tr=true;
        }catch (NumberFormatException e){  tr=false;  }
         int x;
        x = Integer.parseInt(newID);

        return tr && x==y;
    }

    public static String updateProduct (String[] product) {
        String nameProduct = product[2];
        for (int i = 3; i < product.length - 2; i++) {
            nameProduct += " " + product[i];
        }
        return String.format("%-8.8s%-30.30s%-8.8s%-4.4s", product[1], nameProduct, product[product.length - 2], product[product.length - 1]);
    }
}
