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

    static void saveList() {
        try (FileWriter fw = new FileWriter("file.txt",true)) {
            fw.append((String) Draw.listPrize.get(0));
            fw.append('\n');
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void main(String[] args) {

        // коллекция игрушек для розыгрыша
        Set<Toy> store = new HashSet<>();
        // коллекция призовых игрушек
//        List listPrize = new ArrayList();

        store.add(new Toy(1,"bear", 20, 54));
        store.add(new Toy(2, "car", 35, 23));
        store.add(new Toy(3, "doll", 15, 9));

        Scanner userCmd = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            Ui.programMenu();
            String usrCmd = userCmd.nextLine();
            if (usrCmd.equals("ls")) {
                Ui.printList(store);
            }
            else if (usrCmd.equals("add")) {
                // Получение данных пользователья о добавляемой игрушке
                System.out.println("Введите данные для добавляемой игрушки:");
                Scanner userData = new Scanner(System.in);
                System.out.print("Название: ");
                String name = userData.nextLine();
                System.out.print("id: ");
                int id = userData.nextInt();
                System.out.print("Вес: ");
                int chance = userData.nextInt();
                System.out.print("Количество: ");
                int quantity = userData.nextInt();
//                userData.close(); // ?разобраться как работает и почему возникает ошибка
                store.add(new Toy(id, name, chance, quantity));
                System.out.print("Игрушка добавлена." + '\n');

            }
            else if (usrCmd.equals("pr")) {
                Draw.determPrize(store);
                Ui.printPrize(Draw.listPrize);
            }
            else if (usrCmd.equals("out")) {
                saveList();
                Draw.listPrize.remove(0);
                Ui.printPrize(Draw.listPrize);
            }
            else if (usrCmd.equals("ex")) {
                userCmd.close();
                exit = true;
            }

        }

        // Подсчитываем общий вес игрушек (сумму весов)
        // суммарный вес игрушек - перенести в класс Toy
//        int totalProbability = 0;
//        for (var item : store) {
//            totalProbability += item.getChance();
//        }
//        System.out.println("Общий вес: " + totalProbability);
//
//        // Определяем выигранные игрушки
//        int count;
//        int previousCount;
//        // цикл нескольких розыгрышей
//        for ( int i=0; i<4; i++) {
//            count = 0;
//            // генерируем случайное целые в диапазоне от 1 до значения общего веса
//            int rndNum = (int) (Math.random() * totalProbability + 1);
//            System.out.println("Сгенерированное значение: " + rndNum);
//            // определяем выигранную игрушку и добавляем в список listPrize
//            for (var item : store) {
//                previousCount = count;
//                count += item.getChance();
//                if (count >= rndNum && rndNum > previousCount) {
//                    listPrize.add(item.getName());
////                System.out.println("Выпавшая игрушка: " + item.name);
//                }
//            }
//        }
        // вывод списка разыгранных игрушек
//        System.out.println("Разыгранные игрушки:");
//        for (var item : Draw.listPrize) {
//            System.out.println(item);
//        }

        // выдача игрушки (запись в файл)
//        try (FileWriter fw = new FileWriter("file.txt",true)) {
//            fw.append((String) Draw.listPrize.get(0));
//            fw.append('\n');
//        }
//        catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        }

//        Draw.listPrize.remove(0);

//        System.out.println("Оставшиеся после выдачи игрушки:");
//        for (var item : Draw.listPrize) {
//            System.out.println(item);
//        }
    }
}