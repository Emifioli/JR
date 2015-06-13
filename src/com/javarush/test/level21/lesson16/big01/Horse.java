package com.javarush.test.level21.lesson16.big01;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move(){
        speed=Math.random()*2;
        distance+=speed;
    }

    public void print(){
        long a =Math.round(distance);
        StringBuilder str = new StringBuilder();
        for(int i=0;i<a;i++){
            str.append(".");
        }
        str.append(name);
        System.out.println(str.toString());
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}

