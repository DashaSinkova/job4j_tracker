package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Deleted completed successfully");
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
