package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String asdf = "";
        String result = "";
        while ( (asdf=fileReader.readLine())!=null ){
            result+=asdf + "\n";
        }
        byte zx[]=result.getBytes("Windows-1251");
        String bgf = new String(zx,"UTF-8");
        FileWriter fileWriter = new FileWriter(args[1]);
        fileWriter.write(bgf);
        fileReader.close();
        fileWriter.close();

    }
}
