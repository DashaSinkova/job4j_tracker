package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        name();
            String id = input.askStr("Enter id: ");
                Item item = tracker.findById(id);
                System.out.println(" Successful! " + System.lineSeparator() + item.getId() + " " + item.getName());
        return true;
    }
}
