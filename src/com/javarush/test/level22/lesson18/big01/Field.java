package com.javarush.test.level22.lesson18.big01;

public class Field {
    int width;
    int height;
    int[][]matrix;

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public void print(){}

    public void removeFullLines(){}

    public Integer getValue(int x, int y){
        return matrix[y][x];
    }
    void setValue(int x, int y, int value){
        matrix[y][x]=value;
    }
}
