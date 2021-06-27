//package ru.job4j.tracker;
//import static org.hamcrest.core.Is.is;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class StartUITest {
//    @Test
//    public void whenAddItem() {
//            String[] answers = {"Fix PC"};
//            Input input = new StubInput(answers);
//            MemTracker tracker = new MemTracker();
//            StartUI.createItem(input, tracker);
//            Item created = tracker.findAll()[0];
//            Item expected = new Item("Fix PC");
//            assertThat(created.getName(), is(expected.getName()));
//        }
//        @Test
//    public void whenReplace() {
//        MemTracker tracker = new MemTracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {item.getId(), "replaced item"};
//        StartUI.replaceItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(), is("replaced item"));
//        }
//        @Test
//    public void whenDelete() {
//            MemTracker tracker = new MemTracker();
//            Item item = new Item("new item");
//            tracker.add(item);
//            String[] answers = {item.getId()};
//            StartUI.deteleItem(new StubInput(answers), tracker);
//            Item expected = null;
//            assertThat(tracker.findById(item.getId()), is(expected));
//        }
//    }
//
