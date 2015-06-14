package com.javarush.test.level22.lesson18.big01;

public class Tetris {
    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    Field field;
    Figure figure;
    public static Tetris game;

    public Field getField()
    {
        return field;
    }

    public Figure getFigure()
    {
        return figure;
    }

    public void run(){}

    public void step(){}
}
