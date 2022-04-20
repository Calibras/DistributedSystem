package com.company;

import java.awt.*;

public class Car implements Display {

    private Color color;
    private int horsepower;
    private int weight;

    public Car(Color color, int horsepower, int weight){
        this.color = color;
        this.horsepower = horsepower;
        this.weight = weight;
    }
    public void print(){
        System.out.println("Color: " + this.color.toString());
        System.out.println("Horsepower: " + this.horsepower);
        System.out.println("Weight : " + this.weight);
    }
}
