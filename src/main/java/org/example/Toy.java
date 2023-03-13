package org.example;

/**
 * Класс Игрушка
 */
public class Toy {
    private int id;
    String name;
    private int chance;
    int quantity;

    /**
     *
     * @param id идентификационный номер
     * @param name название игрушки
     * @param chance вероятность выигрыша
     * @param quantity количество в магазине
     */
    public Toy(int id, String name, int chance, int quantity) {
        this.id = id;
        this.name = name;
        this.chance = chance;
        this.quantity = quantity;
    }

    public int getChance() {
        return chance;
    }
    @Override
    public String toString() {
        return String.format("id:%d name:%s chance:%s quantity:%d", id, name, chance, quantity );
    }
}
