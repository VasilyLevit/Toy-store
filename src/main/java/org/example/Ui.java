package org.example;

import java.util.List;
import java.util.Set;

public class Ui {
    public static void programMenu() {
        System.out.println(
                "Команды управления: " + "\n"
                        + "ls - просмотр списка разыгрываемых игрушек" + "\n"
                        + "add - добавление игрушки к списку" + "\n"
                        + "pr - розыгрыш игрушки" + "\n"
                        + "out - выдача игрушки" + "\n"
                        + "ex - выход из программы" + "\n"
        );
        System.out.print("Введите команду: ");
    }
    public static void printList(Set<Toy> store) {
        System.out.println("Игрушки, участвующие в розыгрыше:");
        for (var item : store) {
            System.out.println(item);
        }
    }
    public static void printPrize(List prize) {
        System.out.println("Разыгранные игрушки:");
        for (var item : prize) {
            System.out.println(item);
        }
    }
}
