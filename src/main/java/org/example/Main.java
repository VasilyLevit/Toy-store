package org.example;
import java.io.File;
import java.io.IOException;
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
                System.out.println("id ");
                int id = Ui.getUserDataInt();
                System.out.println("Вес ");
                int chance = Ui.getUserDataInt();
                System.out.println("Количество ");
                int quantity = Ui.getUserDataInt();
//                userData.close(); // ?разобраться как работает и почему возникает ошибка
                store.add(new Toy(id, name, chance, quantity));
                System.out.print("Игрушка добавлена." + '\n');

            }
            else if (usrCmd.equals("pr")) {
                Draw.determPrize(store);
                Ui.printPrize(Draw.listPrize);
            }
            else if (usrCmd.equals("out")) {
                if (!Draw.listPrize.isEmpty()) {
                    saveList();
                    System.out.println("Выданная игрушка: " + Draw.listPrize.get(0) + '\n');
                    Draw.listPrize.remove(0);
                    Ui.printPrize(Draw.listPrize);
//                    System.out.println("Индекс выданной игрушки в списке: " + store. + '\n');
                }
                else System.out.println("Нет разыгранных игрушек." + '\n');
            }
            else if (usrCmd.equals("ex")) {
                userCmd.close();
                exit = true;
            }

        }
    }
}