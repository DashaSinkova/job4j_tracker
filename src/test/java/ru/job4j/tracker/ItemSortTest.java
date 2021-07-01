package ru.job4j.tracker;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class ItemSortTest {
    @Test
    public void whenSortAscending() {
        List<Item> items = Arrays.asList(
                new Item("Willy", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Alice", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Kira", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Brad", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59))
        );
        List<Item> exp = Arrays.asList(
                new Item("Alice", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Brad", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Kira", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Willy", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59))
        );
        Collections.sort(items, new ItemSortAscending());
        assertThat(items.toString(), is(exp.toString()));
    }
    @Test
    public void whenSortDescending() {
        List<Item> items = Arrays.asList(
                new Item("Willy", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Alice", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Kira", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Brad", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59))
        );
        List<Item> exp = Arrays.asList(
                new Item("Willy", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Kira", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Brad", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59)),
                new Item("Alice", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59))
        );
        Collections.sort(items, new ItemSortDescending());
        assertThat(items.toString(), is(exp.toString()));
    }
}