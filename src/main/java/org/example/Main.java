package org.example;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // коллекция игрушек для розыгрыша
        Set<Toy> toys = new HashSet<>();
        // суммарный вес игрушек
        int totalProbability = 0;

        Toy toy1 = new Toy();
        toy1.id = 1;
        toy1.name = "bear";
        toy1.probability = 20;
        toy1.quantity = 900;
        toys.add(toy1);

        Toy toy2 = new Toy();
        toy2.id = 2;
        toy2.name = "car";
        toy2.probability = 35;
        toy2.quantity = 500;
        toys.add(toy2);

//      System.out.println(toy1.toString());

        System.out.println("Игрушки, участвующие в розыгрыше");
        for (var item : toys) {
            System.out.println(item);
        }
        // Подсчитываем общий вес игрушек (сумму весов)
        for (var item : toys) {
            System.out.println("Вес: " + item.probability);
            totalProbability += item.probability;
        }
        System.out.println("Общий вес: " + totalProbability);

        // генерируем целые в диапазоне от 1 до значения общего веса
        int rndNum = (int) (Math.random() * totalProbability + 1);
        System.out.println("Сгенерированное значение: " + rndNum);

        // Определяем выигранную игрушку
        int count = 0;
        int previousCount;
        for (var item : toys) {
            previousCount = count;
            count += item.probability;
            if (count >= rndNum && rndNum > previousCount) {
                System.out.println("Выпавшая игрушка: " + item.name);
            }
        }
    }
}