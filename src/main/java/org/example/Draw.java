package org.example;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Draw {
    public static List<String> listPrize = new ArrayList();
    public static void determPrize(Set<Toy> store) {
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
        for (int i = 0; i < 4; i++) {
            count = 0;
            // генерируем случайное целые в диапазоне от 1 до значения общего веса
            int rndNum = (int) (Math.random() * totalProbability + 1);
//            System.out.println("Сгенерированное значение: " + rndNum); // тест
            // определяем выигранную игрушку и добавляем в список listPrize
            for (var item : store) {
                previousCount = count;
                count += item.getChance();
                if (count >= rndNum && rndNum > previousCount) {
                    listPrize.add(item.getName());
//                System.out.println("Выпавшая игрушка: " + item.name); // тест
                }
            }
        }

    }

}
