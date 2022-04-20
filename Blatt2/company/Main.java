package com.company;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(Color.green, 10, 100);
        Display[] displays = new Display[3];
        displays[0] = car;
        displays[1] = new Book("WOllstand der Nationen", "British", 10, "Adam smith", 121212);
        displays[2] = new Publication("Herr der Ringe", "english", 10);
        for(int i = 0; i < displays.length; i++){
            displays[i].print();
            System.out.println("-----------------------------");
        }
        //Einlesen:
        try {
            FileOutputStream fs = new FileOutputStream("test.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(displays);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //auslesen:
        try {
            FileInputStream fs = new FileInputStream("test.ser");
            ObjectInputStream is = new ObjectInputStream(fs);
            Display[] displays2 = (Display[]) is.readObject();
            System.out.println("Aus dem File Gelesen!");
            for(int i = 0; i < displays2.length; i++){
                displays2[i].print();
                System.out.println("-----------------------------");
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
