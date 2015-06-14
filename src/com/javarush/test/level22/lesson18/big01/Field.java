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

    public void print(){
        StringBuilder er = new StringBuilder();
        for(int k=0;k<height;k++) {
            for (int i = 0; i < width; i++)
            {
                if(getValue(i,k)==0)
                er.append(".");
                else er.append("X");
            }
            er.append("\n");
        }
        System.out.println(er.toString());
    }

    public void removeFullLines(){}

    public Integer getValue(int x, int y){
        return matrix[y][x];
    }
    void setValue(int x, int y, int value){
        matrix[y][x]=value;
    }
}
