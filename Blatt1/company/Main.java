package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static int factorial(int number){
        if(number < 0){
            System.out.println("keine negativen Zahlen !");
            return -1;
        }
        int result = 1;
        for(int i = 2; i <= number; i++){
            result = result * i;
        }
        return  result;
    }
    public static void main(String[] args) {
        /*
        //System.out.println(Main.factorial(5));
        Publication publication = new Publication("Herr der Ringe", "Englisch", 20);
        publication.print();
        System.out.println("----------------------book------------------------");
        Book book = new Book("Herr der Ringe", "Englisch", 20, "JRR tolkien", 1827310371);
        book.print();
        */
        //Main.testFunction();
        threadMaster.waitForInput();
    }
    public static void testFunction(){
        Publication[] publications = new Publication[5];
        publications[0] = new Publication("Herr der Ringe", "Englisch", 20);
        publications[1] = new Book("Herr der Ringe", "Englisch", 20, "JRR tolkien", 1827310371);
        publications[2] = new Publication("Die blechtrommel", "Deutsch", 25);
        publications[3] = new Book("Die blechtrommel", "Deutsch", 25, "?", 384937483);
        publications[4] = new Publication("Das Kapital", "Deutsch", 30);
        //print
        for(int i = 0; i < 5; i++){
            publications[i].print();
            System.out.println("-----------------------------");
        }
    }
    public static void input(){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("String eingeben, wir trennen bei leerzeichen: ");
        String baseString = sc.nextLine();
        System.out.println(baseString);
        String[] array = baseString.split(" ", -1);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void filter(String[] args){
        HashSet<String> hashSet = new HashSet<String>();
        for(int i = 0; i < args.length; i++){
            hashSet.add(args[i]);
        }
        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
