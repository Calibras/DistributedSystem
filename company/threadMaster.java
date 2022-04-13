package com.company;

import java.util.Scanner;

public class threadMaster {
    static int threadNumber;
    public static void waitForInput(){
        while (true){
            Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
            System.out.print(" ");
            sc.nextLine();
            //thread starten
            threadMaster.threadNumber++;
            threadChild threadChild = new threadChild(threadMaster.threadNumber);
            threadChild.start();
        }
    }
}
