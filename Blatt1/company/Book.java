package com.company;

public class Book  extends  Publication{
    private String author;
    private int isbn;
    public Book(String title, String language, int price, String author, int isbn){
        super(title, language, price);
        this.author = author;
        this.isbn = isbn;
    }
    public void print(){
        super.print();
        System.out.println("Author: " +  this.author);
        System.out.println("ISBN : " + this.isbn);
    }
}
