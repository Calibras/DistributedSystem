package com.company;

public class Player {
    private String name;
    private int age;
    private PlayerPosition position;

    public String getName(){
        return this.name;
    }
    public PlayerPosition getPosition(){
        return this.position;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
    public Player(String name, PlayerPosition position, int age){
        this.name = name;
        this.position = position;
        this.age = age;
    }
}
