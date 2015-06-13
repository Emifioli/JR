package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    static ArrayList<Horse>horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public Horse getWinner(){
        double maxd=-1;
        Horse h = null;
        for(Horse x : horses){
            if(maxd<x.distance)  h=x;
        }
        return h;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public void run(){
        for(int i=1;i<101;i++){
            move();
            print();
            try  {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println("Забег прерван");
            }
        }
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public ArrayList<Horse> getHorses()  {
        return horses;
    }

    public static void main(String[] args)  {
           game= new Hippodrome();
           Horse Plotva = new Horse("Plotva",5.0,0.0);
           Horse Vushek = new Horse("Gomer",6.0,0.0);
           Horse Listva = new Horse("Listva",7.0,0.0);
           horses.add(Plotva);
           horses.add(Vushek);
           horses.add(Listva);

           game.run();
           game.printWinner();
    }
}
