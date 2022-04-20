package com.company;

public class Publication implements Display {
    private String title;
    private String language;
    private int price;

    public  Publication(String title, String language, int price){
        this.title = title;
        this.language = language;
        this.price = price;
    }
    public void print(){
        System.out.println("Title : " + this.title);
        System.out.println("Language : " + this.language);
        System.out.println("Price : " + this.price );
    }
}
