package ru.job4j.tracker;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class ItemSortTest {
    @Test
    public void whenSortAscending() {
        List<Item> items = Arrays.asList(
                new Item("Willy"),
                new Item("Alice"),
                new Item("Kira"),
                new Item("Brad")
        );
        List<Item> exp = Arrays.asList(
                new Item("Alice"),
                new Item("Brad"),
                new Item("Kira"),
                new Item("Willy")
        );
        Collections.sort(items, new ItemSortAscending());
        assertThat(items.toString(), is(exp.toString()));
    }
    @Test
    public void whenSortDescending() {
        List<Item> items = Arrays.asList(
                new Item("Willy"),
                new Item("Alice"),
                new Item("Kira"),
                new Item("Brad")
        );
        List<Item> exp = Arrays.asList(
                new Item("Willy"),
                new Item("Kira"),
                new Item("Brad"),
                new Item("Alice")
        );
        Collections.sort(items, new ItemSortDescending());
        assertThat(items.toString(), is(exp.toString()));
    }
}