package ru.job4j.tracker;

import java.util.List;

public class ShowAllitemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        name();
        List<Item> items = tracker.findAll();
        if (items.size() != 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Array is empty");
        }
        return true;
    }
}
