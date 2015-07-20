package com.javarush.test.level25.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<Wheel>();
            String x[]=loadWheelNamesFromDB();
            int a=0;
            int b=0;
            int c=0;
            int d=0;
                for (int i = 0; i < x.length; i++) {
                    Wheel as = Wheel.valueOf(x[i]);
                    if(as==Wheel.BACK_LEFT)++a;
                    if(as==Wheel.FRONT_LEFT)++b;
                    if(as==Wheel.FRONT_RIGHT)++c;
                    if(as==Wheel.BACK_RIGHT)++d;
                    wheels.add(as);
                }
            if(a!=1 && b!=1 && c!=1 && d!=1)throw new IllegalArgumentException();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
