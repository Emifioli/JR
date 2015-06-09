package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    ArrayList<Horse>horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()  {
        return horses;
    }

    public static void main(String[] args)  {
           Hippodrome hippodrome = new Hippodrome();
           game=hippodrome;
           Horse Plotva = new Horse("Plotva",3.0,0.0);
           Horse Vushek = new Horse("Vushek",3.0,0.0);
           Horse Listva = new Horse("Listva",3.0,0.0);
           hippodrome.horses.add(Plotva);
           hippodrome.horses.add(Vushek);
           hippodrome.horses.add(Listva);
    }
}
