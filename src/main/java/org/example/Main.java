package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // коллекция игрушек для розыгрыша
        Set<Toy> store = new HashSet<>();
        List listPrize = new ArrayList();


        store.add(new Toy(1,"bear", 20, 54));
        store.add(new Toy(2, "car", 35, 23));
        store.add(new Toy(3, "doll", 15, 9));

        System.out.println("Игрушки, участвующие в розыгрыше:");

        // Получение данных от пользователя
        System.out.println("Введите данные для добавляемой игрушки:");
        Scanner userData = new Scanner(System.in);
        System.out.printf("Название: ");
        String name = userData.nextLine();
        System.out.printf("id: ");
        int id = userData.nextInt();
        System.out.printf("Вес: ");
        int chance = userData.nextInt();
        System.out.printf("Количество: ");
        int quantity = userData.nextInt();
        userData.close();

        store.add(new Toy(id, name, chance, quantity));

        for (var item : store) {
            System.out.println(item);
        }
        // Подсчитываем общий вес игрушек (сумму весов)
        // суммарный вес игрушек
        int totalProbability = 0;
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
                    listPrize.add(item.getName());
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