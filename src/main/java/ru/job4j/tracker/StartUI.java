/**
 * 2.1. Реализация класса StartUI[#188284]
 * 4.2. Статические методы.[#188295]
 */
package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
                int select = input.askInt("Select: ", actions.size());
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
        }
    }
        private void showMenu(List<UserAction> actions) {
        System.out.println(System.lineSeparator() + "Menu.");
           for (UserAction userAction : actions) {
               System.out.println(actions.indexOf(userAction) + ". " + userAction.name());
           }
        }
        public static void main(String[]args) {
            Input validate = new ValidateInput(new ConsoleInput());
            MemTracker tracker = new MemTracker();
            List<UserAction> actions = new ArrayList<>();
                    actions.add(new CreateAction());
                    actions.add(new ShowAllitemsAction());
                    actions.add(new ReplaceAction());
                    actions.add(new DeleteAction());
                    actions.add(new FindByIdAction());
                    actions.add(new FindItemsByNameAction());
            new StartUI().init(validate, tracker, actions);
        }
    }

