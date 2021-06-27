package ru.job4j.tracker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * 5. Реализовать класс MemTracker[#188330]
 * написать тесты на все методы
 */
public class TrackerTest {
    @Test
    public void deleteTest() {
        MemTracker sc = new MemTracker();
        Item addItem1 = sc.add(new Item("Оборудование HP"));
        Item addItem2 = sc.add(new Item("Оборудование HPE"));
        List<Item> list = new ArrayList<>();
        list.add(addItem2);
        assertThat(sc.delete(Integer.valueOf(addItem1.getId())), is(true));
        assertThat(sc.findAll(), is(list));
    }
    @Test
    public void findAllTest() {
        MemTracker sc = new MemTracker();
        Item addItem1 = sc.add(new Item("Оборудование HP"));
        Item addItem2 = sc.add(new Item("Оборудование HPE"));
        List<Item> exp = new ArrayList<>();
        exp.add(addItem1);
        exp.add(addItem2);
        assertThat(sc.findAll(), is(exp));
    }
    @Test
    public void addTest() {
        MemTracker sc = new MemTracker();
        Item item = new Item("Оборудование HP");
        assertThat(sc.add(item).getName(), is(item.getName()));
    }
    @Test
    public void replaceTest() {
        Item res = new Item("Оборудование HP");
        MemTracker sc = new MemTracker();
        Item addItem = sc.add(new Item("Оборудование HPE"));
        res.setId(addItem.getId());
        sc.replace(addItem.getId(), res);
        assertThat(sc.findById(addItem.getId()).getName(), is("Оборудование HP"));
    }
    @Test
    public void findByIdTest() {
        MemTracker sc = new MemTracker();
        Item addItem = sc.add(new Item("Оборудование HPE"));
        assertThat(sc.findById(addItem.getId()).getName(), is(addItem.getName()));
    }
    @Test
    public void findByNameTest() {
        MemTracker sc = new MemTracker();
        Item addItem0 = sc.add(new Item("Оборудование HPE"));
        Item addItem1 = sc.add(new Item("Оборудование HPE"));
        List<Item> exp = new ArrayList<>();
        exp.add(addItem0);
        exp.add(addItem1);
        assertThat(sc.findByName(addItem0.getName()), is(exp));
    }
}
