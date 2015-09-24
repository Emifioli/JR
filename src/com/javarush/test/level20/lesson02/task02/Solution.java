package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name1 = new File("D.txt");
            File your_file_name2 = new File("D.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name1);
            InputStream inputStream = new FileInputStream(your_file_name2);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 = new User();
            Date d1 = new Date();
            u1.setBirthDate(d1);
            u1.setCountry(User.Country.RUSSIA);
            u1.setFirstName("Den");
            u1.setLastName("Ra");
            u1.setMale(false);
            javaRush.users.add(u1);

            User u2 = new User();
            Date d2 = new Date();
            u2.setBirthDate(d2);
            u2.setCountry(User.Country.UKRAINE);
            u2.setFirstName("Reu");
            u2.setLastName("Ko");
            u2.setMale(true);
            javaRush.users.add(u2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for(User u : loadedObject.users){
                System.out.println(u.getFirstName() + " " + u.getLastName() + "" +
                        " " + u.getCountry() +" "+ u.getBirthDate() +" " + u.isMale());

            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            int count = users.size();
            printWriter.println(count);
            for(User user : users){
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry());
                printWriter.println(user.getBirthDate().getTime());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int count = Integer.parseInt(reader.readLine());
            for(int i=0;i<count;i++){
                User user = new User();
                String fn = reader.readLine();
                user.setFirstName(fn);
                String fl = reader.readLine();
                user.setLastName(fl);
                boolean Male = Boolean.valueOf(reader.readLine());
                user.setMale(Male);
                String c = reader.readLine();
                if(c.equals("RUSSIA"))user.setCountry(User.Country.RUSSIA);
                else if(c.equals("UKRAINE"))user.setCountry(User.Country.UKRAINE);
                else if(c.equals("OTHER"))user.setCountry(User.Country.OTHER);
                Long d = Long.valueOf(reader.readLine());
                user.setBirthDate(new Date(d));
                users.add(user);
            }
        }
    }
}
