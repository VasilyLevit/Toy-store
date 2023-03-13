package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // коллекция игрушек для розыгрыша
        Set<Toy> store = new HashSet<>();
        List listPrize = new ArrayList();
        // суммарный вес игрушек
        int totalProbability = 0;

        Toy toy1 = new Toy(1,"bear", 20, 54);
        store.add(toy1);

        Toy toy2 = new Toy(1, "car", 35, 23);
        store.add(toy2);

        Toy toy3 = new Toy(1, "doll", 15, 9);
        store.add(toy3);

        System.out.println("Игрушки, участвующие в розыгрыше:");
        for (var item : store) {
            System.out.println(item);
        }
        // Подсчитываем общий вес игрушек (сумму весов)
        for (var item : store) {
            totalProbability += item.getChance();
        }
        System.out.println("Общий вес: " + totalProbability);

        // Определяем выигранные игрушки
        int count;
        int previousCount;
        // цикл нескольких розыгрышей
        for ( int i=0; i<4; i++) {
            count = 0;
            // генерируем случайное целые в диапазоне от 1 до значения общего веса
            int rndNum = (int) (Math.random() * totalProbability + 1);
            System.out.println("Сгенерированное значение: " + rndNum);
            // определяем выигранную игрушку и добавляем в список listPrize
            for (var item : store) {
                previousCount = count;
                count += item.getChance();
                if (count >= rndNum && rndNum > previousCount) {
                    listPrize.add(item.name);
//                System.out.println("Выпавшая игрушка: " + item.name);
                }
            }
        }
        // вывод списка разыгранных игрушек
        System.out.println("Разыгранные игрушки:");
        for (var item : listPrize) {
            System.out.println(item);
        }

        // выдача игрушки (запись в файл)
        try (FileWriter fw = new FileWriter("file.txt",true)) {
            fw.append((String) listPrize.get(0));
            fw.append('\n');
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        listPrize.remove(0);

        System.out.println("Оставшиеся после выдачи игрушки:");
        for (var item : listPrize) {
            System.out.println(item);
        }
    }
}