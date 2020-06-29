package com.lsdd.test;

public class Rsf extends Thread {


    @Override
    public void run() {
        System.out.println("In Run");
        yield();
        System.out.println("leave Run");
    }

    public static void main(String[] args) {
        (new Rsf()).start();
    }
}
