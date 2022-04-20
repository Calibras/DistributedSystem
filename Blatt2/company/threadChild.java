package com.company;

import java.util.concurrent.TimeUnit;

public class threadChild extends Thread{
    private int number;
    public threadChild(int number){
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                System.out.println(number);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
