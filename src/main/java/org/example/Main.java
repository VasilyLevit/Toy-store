package org.example;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy();
        toy1.id = 1;
        toy1.name = "bear";
        toy1.probability = 20;
        toy1.quantity = 1000;

        System.out.println(toy1.toString());
    }
}