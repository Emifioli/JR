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
19846   Шорты пляжные синие           159.00  1233
198478  Шорты пляжные черные с рисунко173.00  1755
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String name = rdr.readLine();
        RandomAccessFile raf = new RandomAccessFile(name,"rw");
        if(args.length>0){
            String s = ""; //для чтения файла
            int asq = Integer.parseInt(args[1]);//парсим номер строки

          if(args[0].equals("-u")){
              //делаем строку из аргументов
              String repl = "";
              for(int i=2;i<args.length;i++){
                  try {
                      Double pa = Double.parseDouble(args[i]);
                      if(repl.length()>30)repl=repl.substring(0,30);
                      while (repl.length()<30){
                          repl+=" ";
                      }
                      //цена
                      String ptr = pa.toString();
                      if(ptr.length()>8)   {
                          System.out.println("Ошибка длинны аргумента");
                          throw new IOException();
                      }
                      while (ptr.length()<8){
                          ptr+=" ";
                      }
                      repl+=ptr;
                      //кол-во
                      ++i;
                      String ptr2 = args[i];
                      if(ptr2.length()>4){
                          System.out.println("Ошибка длинны аргумента");
                          throw new IOException();
                      }
                      while (ptr2.length()<4){
                          ptr2+=" ";
                      }
                      repl+=ptr2;
                  }catch (NumberFormatException e){
                      if(i==2) repl+=args[i];
                      else  repl+=" "+args[i];
                  }
              }

              while ( (s=raf.readLine())!=null){
                      try  {
                          String id = s.substring(0, 8);
                          id = id.trim();
                          int num = Integer.parseInt(id);
                          if (num == asq)  {
                              raf.seek(raf.getFilePointer() - 44);
                              raf.write(repl.getBytes());
                          }
                      }catch (NumberFormatException e){
                      }catch (StringIndexOutOfBoundsException e){}

              }
          }
            if(args[0].equals("-d")){
                int xx = 0;
                while ( (s=raf.readLine())!=null){
                    try  {
                        String id = s.substring(0, 8);
                        id = id.trim();
                        int num = Integer.parseInt(id);
                        if (num == asq)  {
                            ++xx;  }
                    }catch (NumberFormatException e){
                    }catch (StringIndexOutOfBoundsException e){}
                }
                for(int i=0;i<xx;i++){
                    RandomAccessFile delLine = new RandomAccessFile(name, "rw");
                    long qwa = 0;
                    String ws;
                    while ( (ws=delLine.readLine())!=null)  {
                        long length = delLine.getFilePointer()-qwa;
                        try  {
                            String id = ws.substring(0, 8);
                            id = id.trim();
                            int num = Integer.parseInt(id);
                            if (num == asq)
                            {
                                byte buffer[] = new byte[4444];
                                int read = -1;
                                while ((read = delLine.read(buffer)) > -1)
                                {
                                    delLine.seek(delLine.getFilePointer() - read - length);
                                    delLine.write(buffer, 0, read);
                                    delLine.seek(delLine.getFilePointer() + length);

                                }
                                delLine.setLength(delLine.length() - length);
                            }
                            qwa = delLine.getFilePointer();
                        }catch (NumberFormatException e){
                        }catch (StringIndexOutOfBoundsException e){}
                    }
                    delLine.close();
                }
            }

        }


        rdr.close();
        raf.close();
    }
}
