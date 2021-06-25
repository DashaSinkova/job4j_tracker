package ru.job4j.tracker;

import java.util.List;

public class FindItemsByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
            List<Item> arr = tracker.findByName(name);
            if (arr.size() != 0) {
                System.out.println(" Successful! ");
                for (Item item : arr) {
                    System.out.println(item.getId() + " " + item.getName());
                }
            } else {
                System.out.println("Array is empty or you input incorrect symbol");
                System.out.println("Please, try again");
            }
        return true;
    }
}
