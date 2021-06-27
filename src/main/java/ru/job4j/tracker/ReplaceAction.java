package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        String id = input.askStr("Enter id: ");
            String name = input.askStr("Enter name: ");
        if (tracker.replace(Integer.valueOf(id), new Item(name))) {
            System.out.println("Edit completed successfully");
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
