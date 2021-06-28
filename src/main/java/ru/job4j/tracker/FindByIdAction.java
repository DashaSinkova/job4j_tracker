package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }
    @Override
    public boolean execute(Input input, Store tracker) {
        name();
            int id = Integer.valueOf(input.askStr("Enter id: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(" Successful! " + System.lineSeparator() + item);
                }
        return true;
    }
}
