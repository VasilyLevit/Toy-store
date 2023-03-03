package org.example;

public class Toy {
    int id;
    int quantity;
    int probability;
    String name;

    @Override
    public String toString() {
        return String.format("id:%d name:%s probability:%s quantity:%d", id, name, probability, quantity );
    }
}
