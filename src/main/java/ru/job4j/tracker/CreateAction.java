package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        name();
        String name = input.askStr("Enter name:");
            Item item = new Item(name);
            tracker.add(item);
            System.out.print("Item is created!");
        return true;
    }
}
