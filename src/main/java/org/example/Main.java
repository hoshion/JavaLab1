package org.example;

public class Main {

    public static void main(String[] args) {
        Lab lab = new Lab();

        double res = lab.calc(Long.parseLong(args[0]), Long.parseLong(args[1]), Long.parseLong(args[2]), Long.parseLong(args[3]));

        System.out.println("Result of operation is " + res);
    }

}